package br.me.agenda.modelo.dominio;
/**
 * 
 * @author marcos.eduardo
 * 
	CREATE TABLE public.Book (
		id bigserial NOT NULL,
		title varchar NULL,
		author varchar NULL,
		summary varchar NULL,
		ano int4 null,
		CONSTRAINT book_pk PRIMARY KEY (id)
	);
 */
public class Book {

    private Long id;
    private String title;
    private String author;
    private String summary;
    private int ano;

    public Book() {
    }
    
    public Book(String title, String author) {
        this.id = new Long(-1);
        this.title = title;
        this.author = author;
    }

    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    
    public Book(Long id, String title, String author, String summary, int ano) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.summary = summary;
        this.ano = ano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
