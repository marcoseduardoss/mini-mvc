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

import br.me.agenda.modelo.dominio.Book;
import br.me.agenda.modelo.persistencia.Conexao;
import br.me.agenda.modelo.persistencia.DaoI;

public class BookDAO implements DaoI<Book> {

    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    //padrão - singleton - parte 1
    private static BookDAO dao = null;

    /**
     * Retornoa uma única instância desta classe para toda aplicação. Para saber
     * mais: procure padrão singleton no google.
     */ //padrão - singleton - parte 2
    public static BookDAO getInstance() {
    	
        if (dao == null) {
            return dao = new BookDAO();
        } else {
            return dao;
        }
    }

    //padrão - singleton - parte 3
    private BookDAO() {
    }

    
    public void salvar(Book book) {
        try {
            pstmt = Conexao.getInstance().getConnection().prepareStatement(""
                    + "Insert Into "
                    + "Book(title, author, summary, ano) "
                    + "Values(?,?,?,?)");
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getSummary());
            pstmt.setInt(4, book.getAno());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.getInstance().fechar(pstmt);
        }
    }

    
    public void atualizar(Book book) {
        try {
            String sql = "Update Book Set ";
            sql += "title=?, Author=?, Summary=?, Ano=? ";
            sql += "Where id = ?";
            pstmt = Conexao.getInstance().getConnection().prepareStatement(sql);
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getSummary());
            pstmt.setInt(4, book.getAno());
            pstmt.setLong(5, book.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.getInstance().fechar(pstmt);
        }
    }

    
    public void remover(Book book) {
        try {
            pstmt = Conexao.getInstance().getConnection().prepareStatement(
                    "Delete From Book Where id = ?");
            pstmt.setLong(1, book.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.getInstance().fechar(pstmt, rs);
        }
    }

    
    public List<Book> getTodos() {
        try {
            ArrayList<Book> listAll = null;
            
            Book book;
            
            pstmt = Conexao.getInstance().getConnection().prepareStatement(
                    "select * from book order by summary");
            rs = pstmt.executeQuery();
            listAll = new ArrayList<Book>();
            while (rs.next()) {
                book = new Book();
                book.setId(new Long(rs.getInt("id")));
                book.setAuthor(rs.getString("Author"));
                book.setTitle(rs.getString("title"));
                book.setSummary(rs.getString("summary"));
                book.setAno(rs.getInt("ano"));
                listAll.add(book);
            }
            return listAll;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            Conexao.getInstance().fechar(pstmt, rs);
        }
    }

    
    public Book obterPorId(Long id) {
        try {
            Book book = null;
            pstmt = Conexao.getInstance().getConnection().prepareStatement(
                    "select * from book where id = ?");
            pstmt.setInt(1, id.intValue());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setId(rs.getLong("id"));
                book.setAuthor(rs.getString("Author"));
                book.setTitle(rs.getString("title"));
                book.setSummary(rs.getString("Summary"));
                book.setAno(rs.getInt("ano"));
            }
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            Conexao.getInstance().fechar(pstmt, rs);
        }
    }

}