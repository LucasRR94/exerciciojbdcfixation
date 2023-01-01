package db;

public class DbIntegrityException extends RuntimeException {
	// code from : https://github.com/acenelio/demo-dao-jdbc/blob/master/src/db/DbIntegrityException.java
	private static final long serialVersionUID = 1L;
	
	public DbIntegrityException(String msg) {
		super(msg);
	}

}
