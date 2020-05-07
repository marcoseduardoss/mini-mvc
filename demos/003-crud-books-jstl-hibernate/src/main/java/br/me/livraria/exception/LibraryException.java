package br.me.livraria.exception;

@SuppressWarnings("serial")
public class LibraryException extends RuntimeException {

	public LibraryException() {
		super();
	}

	public LibraryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		print(cause);
	}

	public LibraryException(String message, Throwable cause) {
		super(message, cause);
		print(cause);
	}

	public LibraryException(String message) {
		super(message);
		System.err.println(message);
	}

	public LibraryException(Throwable cause) {
		super(cause);
	}

	public void print(Throwable cause) {
		if(cause!=null)
			cause.printStackTrace();
	}


}
