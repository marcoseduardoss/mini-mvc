package br.me.agenda.modelo.persistencia.jdbc;

/**
 * classe de acesso a dados
 *
 * @author marcos.eduardo\\\\\e
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.me.agenda.modelo.dominio.Usuario;
import br.me.agenda.modelo.persistencia.Conexao;
import br.me.agenda.modelo.persistencia.DaoI;

public class UsuarioDAO implements DaoI<Usuario> {

    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    //padrão - singleton - parte 1
    private static UsuarioDAO dao = null;

    /**
     * Retornoa uma única instância desta classe para toda aplicação. Para saber
     * mais: procure padrão singleton no google.
     */ //padrão - singleton - parte 2
    public static UsuarioDAO getInstance() {
    	
        if (dao == null) {
            return dao = new UsuarioDAO();
        } else {
            return dao;
        }
    }

    //padrão - singleton - parte 3
    private UsuarioDAO() {
    }

    
    public void salvar(Usuario usuario) {
        try {
            pstmt = Conexao.getInstance().getConnection().prepareStatement(""
                    + "Insert Into "
                    + "Usuario(login, senha, nome, email, telefone) "
                    + "Values(?,?,?,?,?)");
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, usuario.getNome());
            pstmt.setString(4, usuario.getEmail());
            pstmt.setString(5, usuario.getTelefone());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.getInstance().fechar(pstmt);
        }
    }

    
    public void atualizar(Usuario usuario) {
        try {
            String sql = "Update Usuario Set ";
            sql += "login=?, Senha=?, Nome=?, Email=?, telefone=? ";
            sql += "Where id = ?";
            pstmt = Conexao.getInstance().getConnection().prepareStatement(sql);
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, usuario.getNome());
            pstmt.setString(4, usuario.getEmail());
            pstmt.setString(5, usuario.getTelefone());
            pstmt.setInt(6, usuario.getId().intValue());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.getInstance().fechar(pstmt);
        }
    }

    
    public void remover(Usuario usuario) {
        try {
            pstmt = Conexao.getInstance().getConnection().prepareStatement(
                    "Delete From Usuario Where id = ?");
            pstmt.setInt(1, usuario.getId().intValue());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.getInstance().fechar(pstmt, rs);
        }
    }

    
    public List<Usuario> getTodos() {
        try {
            ArrayList<Usuario> listAll = null;
            Usuario usuario = new Usuario();
            pstmt = Conexao.getInstance().getConnection().prepareStatement(
                    "select * from usuario order by nome");
            rs = pstmt.executeQuery();
            listAll = new ArrayList<Usuario>();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(new Long(rs.getInt("id")));
                usuario.setSenha(rs.getString("Senha"));
                usuario.setLogin(rs.getString("login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefone(rs.getString("telefone"));
                listAll.add(usuario);
            }
            return listAll;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            Conexao.getInstance().fechar(pstmt, rs);
        }
    }

    
    public Usuario obterPorId(Long id) {
        try {
            Usuario usuario = null;
            pstmt = Conexao.getInstance().getConnection().prepareStatement(
                    "select * from usuario where id = ?");
            pstmt.setInt(1, id.intValue());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(new Long(rs.getInt("id")));
                usuario.setSenha(rs.getString("Senha"));
                usuario.setLogin(rs.getString("login"));
                usuario.setNome(rs.getString("Nome"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setEmail(rs.getString("email"));
            }
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            Conexao.getInstance().fechar(pstmt, rs);
        }
    }

    
    public Usuario getUsuario(String login, String senha) {
        try {
            Usuario usuario = null;

            pstmt = Conexao.getInstance().getConnection().prepareStatement(
                    "select * from usuario where login=? and senha=?");
            pstmt.setString(1, login);
            pstmt.setString(2, senha);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(new Long(rs.getInt("id")));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNome(rs.getString("login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setEmail(rs.getString("email"));
            }
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            Conexao.getInstance().fechar(pstmt, rs);
        }
    }
}