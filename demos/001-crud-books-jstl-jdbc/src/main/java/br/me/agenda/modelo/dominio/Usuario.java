package br.me.agenda.modelo.dominio;

import br.me.agenda.modelo.persistencia.jdbc.UsuarioDAO;

/**
 * Classe conhecida como Java Bean ou Classe basica. Javabeans sao classes que
 * possuem o construtor sem argumentos e metodos de acesso do tipo get e set!
 * 
 * @author marcos.eduardo
 * 
	CREATE TABLE public.usuario (
		id bigserial NOT NULL,
		login varchar NULL,
		senha varchar NULL,
		nome varchar NULL,
		telefone varchar NULL,
		email varchar NULL,
		CONSTRAINT usuario_pk PRIMARY KEY (id)
	);
	
	INSERT INTO public.usuario (login,senha,nome,telefone,email) VALUES ('admin','123','marcos','996145615','marcos.eduardo@uece.br');
 */
public class Usuario {//da tabela usuario
	/*
     * Atributos
     */

    private Long id;//chave de identifica��o �nica
    private String login;//na tabela corresponde a coluna login
    private String senha;//na tabela corresponde a coluna senha
    private String nome;//na tabela corresponde a coluna nome
    private String telefone;
    private String email;
    /*
     * contrutores
     */

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(String login, String senha) {
        super();
        this.login = login;
        this.senha = senha;
    }

    /*
     * M�todos com regras de neg�cio
     */
    public Usuario logar() throws Exception {
        Usuario u = (Usuario)UsuarioDAO.getInstance().getUsuario(login, senha);
        if (u != null) {
            return u;
        } else {
            throw new Exception("Usuario nao autorizado");
        }
    }

    /*
     * M�todos de acesso
     */
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
