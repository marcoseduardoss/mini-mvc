package br.me.crudbooks.model.domain.exception;

@SuppressWarnings("serial")
public class LibrarySystemException extends RuntimeException {

	public LibrarySystemException() {
		super();
	}

	public LibrarySystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		print(cause);
	}

	public LibrarySystemException(String message, Throwable cause) {
		super(message, cause);
		print(cause);
	}

	public LibrarySystemException(String message) {
		super(message);
		System.err.println(message);
	}

	public LibrarySystemException(Throwable cause) {
		super(cause);
	}

	public void print(Throwable cause) {
		if(cause!=null)
			cause.printStackTrace();
	}


}
