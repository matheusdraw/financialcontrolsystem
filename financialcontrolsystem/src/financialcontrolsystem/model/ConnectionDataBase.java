package financialcontrolsystem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

abstract class ConnectionDataBase {

	private Connection connection = null;
	private Statement statement = null;
	
	protected Connection createConnection() {
		String url = "jdbc:postgresql://localhost:5432/financialdb";
		String user = "postgres";
		String password = "*fin_2013";

		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão com banco de dados estabelecida!");
			
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o banco de dados!");
			e.printStackTrace();
		}
		return connection;
	}
	
	protected Statement getStatement() throws SQLException {
		if(statement == null) {
			statement = createConnection().createStatement();
		}
		return statement;
	}
	
	protected void close() {
		try {
			if(statement != null){ 
				statement.close();}
			if(connection != null){ 
				connection.close();}
		} 
		catch (Exception e) {
			// se houve algum erro, uma exceção é gerada para informar o erro.
			System.out.println("Error: " + e.getMessage());
		}
	}
}
