package financialcontrolsystem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO extends ConnectionDatabase {

	private Connection connection = null;

	//Adiciona um novo usuário
	public void insertNewAccount(AccountTO accountTO) {

		try {
			String sqlNewAccount = "insert into usuarios (usuario, senha, ativo) values (?, ?, ?)";
			PreparedStatement statement = connection
					.prepareStatement(sqlNewAccount);

			statement.setString(1, accountTO.getNameAccount());
			statement.setString(2, accountTO.getPassword());
			statement.setBoolean(3, true);
			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro.");
			// e.printStackTrace();
		}
	}
	
	//Retorna todos os cadastros
		public void requestAllAccounts(AccountTO accountTO) {

			String sqlReqAcc = "select * from usuarios u";

			Statement statement;
			try {
				statement = getStatement();
				ResultSet result = statement.executeQuery(sqlReqAcc);

				while (result.next()) {

					accountTO.setNameAccount(result.getString("usuario"));
					accountTO.setPassword(result.getString("senha"));
				}

			} catch (SQLException e) {
				System.out.println("Erro: " + e.getMessage());
				e.printStackTrace();
			}
		}

	//Busca um cadastro de usuário específico
	public void requestAccount(AccountTO accountTO) {

		String sqlReqAcc = "select * from usuarios u where u.usuario = '"+ accountTO.getNameAccount() + "'";

		Statement statement;
		try {
			statement = getStatement();
			ResultSet result = statement.executeQuery(sqlReqAcc);

			while (result.next()) {

				accountTO.setNameAccount(result.getString("usuario"));
				accountTO.setPassword(result.getString("senha"));
			}

		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
