package financialcontrolsystem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {

	private Connection connection = null;

	public AccountDAO() {
		connection = new ConnectionDatabase().createConnection();
	}

	public void inserNewAccount(AccountTO accountTO) {

		try {
			String sql = "insert into account (active, description) values (?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setBoolean(1, true);
			statement.setString(2, accountTO.getNameAccount());
			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro.");
			// e.printStackTrace();
		}

	}
}
