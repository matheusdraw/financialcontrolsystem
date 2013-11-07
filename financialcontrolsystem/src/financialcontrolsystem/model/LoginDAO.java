package financialcontrolsystem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO extends Connection {

	private Connection connection = null;

	//Adiciona um novo usuário.
	public void insertNewLogin(LoginTO loginTO) {

		try {
			String sqlNewLogin = "insert into usuarios (usuario, senha, ativo) values (?, ?, ?)";
			PreparedStatement statement = connection
					.prepareStatement(sqlNewLogin);

			statement.setString(1, loginTO.getNameAccount());
			statement.setString(2, loginTO.getPassword());
			statement.setBoolean(3, true);
			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro.");
			// e.printStackTrace();
		}
	}
	
	//Retorna todos os cadastros.
		public void requestAllLogins(LoginTO loginTO) {

			String sqlReqLogin = "select * from usuarios u";

			Statement statement;
			try {
				statement = getStatement();
				ResultSet result = statement.executeQuery(sqlReqLogin);
				
				//Termina o while quando retorna todos os registros.
				while (result.next()) {
					loginTO.setNameAccount(result.getString("usuario"));
					loginTO.setPassword(result.getString("senha"));
				}

			} catch (SQLException e) {
				System.out.println("Erro: " + e.getMessage());
				e.printStackTrace();
			}
		}

	//Busca um cadastro de usuário específico.
	public void requestLogin(LoginTO loginTO) {

		String sqlReqLogin = "select * from usuarios u where u.usuario = '"+ loginTO.getNameAccount() + "'";

		Statement statement;
		try {
			statement = getStatement();
			ResultSet result = statement.executeQuery(sqlReqLogin);

			while (result.next()) {

				loginTO.setNameAccount(result.getString("usuario"));
				loginTO.setPassword(result.getString("senha"));
			}

		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
