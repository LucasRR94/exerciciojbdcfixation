package db;

public class DbException extends RuntimeException{
	// code from: https://github.com/acenelio/demo-dao-jdbc/blob/master/src/db/DbException.java
	private static final long serialVersionUID = 1L;
	
	public DbException(String msg) {
		super(msg);
	}
	
}
