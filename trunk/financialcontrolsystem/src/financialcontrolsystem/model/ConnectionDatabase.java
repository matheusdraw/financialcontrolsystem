package financialcontrolsystem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDatabase {

	Connection connection;

	public void createConnection() {
		String url = "jdbc:postgresql://localhost:5432/financialcontrolsystem";
		String user = "postgres";
		String password = "1583141aehcada";

		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão com banco de dados estabelecida!");

//			String sql = "insert into account (active, description) values (?, ?)";
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setBoolean(1, true);
//			statement.setString(2, "Dinheiro");
//			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o banco de dados!");
			e.printStackTrace();
		}
	}

}
