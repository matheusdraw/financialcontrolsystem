package financialcontrolsystem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

	Connection connection;

	public Connection createConnection() {
		String url = "jdbc:postgresql://localhost:5432/financialcontrolsystem";
		String user = "postgres";
		String password = "1583141aehcada";

		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão com banco de dados estabelecida!");
			
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o banco de dados!");
			e.printStackTrace();
		}
		return connection;
	}

}
