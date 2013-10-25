package financialcontrolsystem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO extends ConnectionDataBase {

	private Connection connection = null;

	// Adiciona uma nova conta.
	public void createNewAccount(AccountTO accountTO) {

		try {
			String sqlNewAcc = "insert into contas (ativo, descricao, tipo) values (?, ?, ?)";
			PreparedStatement statement = connection
					.prepareStatement(sqlNewAcc);

			statement.setBoolean(1, true);
			statement.setString(2, accountTO.getName());
			statement.setInt(3, accountTO.getTipo());
			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro:" + e.getMessage());
			e.printStackTrace();
		}
	}

	// Retorna todas as contas.
	public void requestAllAccounts(AccountTO accountTO) {

		String sqlReqAcc = "select * from contas";

		Statement statement;
		try {
			statement = getStatement();
			ResultSet result = statement.executeQuery(sqlReqAcc);

			// Termina o while quando retorna todos os registros.
			while (result.next()) {
				accountTO.setName(result.getString("descricao"));
			}

		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Busca uma conta específica.
	public void requestAccount(AccountTO accountTO) {

		String sqlReqAcc = "select * from contas c where c.descricao = '"
				+ accountTO.getName() + "'";

		Statement statement;
		try {
			statement = getStatement();
			ResultSet result = statement.executeQuery(sqlReqAcc);

			while (result.next()) {
				accountTO.setName(result.getString("descricao"));
			}

		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Verifica se a conta está ativa ou inativa.
	public boolean verifyAccount(AccountTO accountTO) {
		Boolean active = null;
		String sqlVerAcc = "select c.ativo from contas c where c.descricao = '" + accountTO.getName() + "'";

		Statement statement;
		try {
			statement = getStatement();
			ResultSet result = statement.executeQuery(sqlVerAcc);

			while (result.next()) {
				active = result.getBoolean("ativo");
			}

		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
		if (active) {
			return true;
		}else{
			return false;
		}
	}
}
