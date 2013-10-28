package financialcontrolsystem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class AccountDAO extends ConnectionDataBase {

	private Connection connection = null;
	private Statement statement = null;
	
	public AccountDAO(){
		connection = createConnection();
		
		try {
			statement = getStatement();
		} catch (SQLException e) {
			System.out.println("Erro:" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	// Adiciona uma nova conta.
	public void createNewAccount(AccountTO accountTO) {

		try {
			String sqlNewAcc = "insert into contas (ativo, nome, tipo) values (?, ?, ?) returning id";
			PreparedStatement statement = connection.prepareStatement(sqlNewAcc);
			
			statement.setBoolean(1, true);
			statement.setString(2, accountTO.getName());
			statement.setInt(3, accountTO.getTipo());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				accountTO.setId(rs.getInt("id"));    
			}
			

		} catch (SQLException e) {
			System.out.println("Erro:" + e.getMessage());
			e.printStackTrace();
		}
		
		this.setAccType(accountTO);
	}
	
	//Verifica o tipo da conta e adiciona na tabela correta.
	private void setAccType(AccountTO accountTO){
		
		if (accountTO.getTipo() == 1) {
			String sqlSetType = "insert into carteira (idcontas) values (?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sqlSetType);
				
				statement.setInt(1, accountTO.getId());
				statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro:" + e.getMessage());
			e.printStackTrace();
			}
			try {
				statement.close();
				connection.close();	
			} catch (SQLException e) {
				System.out.println("Erro:" + e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		if (accountTO.getTipo() == 2) {
			String sqlSetType = "insert into contacorrente (idcontas, cc, agencia) values (?, ?, ?)";
			try {
				PreparedStatement statement = connection.prepareStatement(sqlSetType);
				
				statement.setInt(1, accountTO.getId());
				statement.setInt(2, accountTO.getCc());
				statement.setInt(3, accountTO.getAg());
				statement.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("Erro:" + e.getMessage());
				e.printStackTrace();
			}
			
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				System.out.println("Erro:" + e.getMessage());
				e.printStackTrace();
			}
		}
		
		if (accountTO.getTipo() == 3) {
			String sqlSetType = "insert into poupanca (idcontas) values (?)";
			try {
				PreparedStatement statement = connection.prepareStatement(sqlSetType);
				
				statement.setInt(1, accountTO.getId());
				statement.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("Erro:" + e.getMessage());
				e.printStackTrace();
			}
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("Erro:" + e.getMessage());
				e.printStackTrace();
			}
			
		}		
	}
	
	// Retorna todas as contas.
	public List<AccountTO> listAllAccounts() {
		AccountTO accountTO = new AccountTO();
		List<AccountTO> accounts = new ArrayList<AccountTO>();
		
		try {
			String sqlReqAcc = "select * from contas";
			PreparedStatement statement;
			PreparedStatement statement1;
			
			statement = connection.prepareStatement(sqlReqAcc);
			ResultSet result = statement.executeQuery();

			// Termina o while quando retorna todos os registros.
			while (result.next()) {
				AccountTO acc = new AccountTO(); 
				acc.setId(result.getInt("id"));
				acc.setName(result.getString("nome"));
				acc.setTipo(result.getInt("tipo"));
				acc.setAtivo(result.getBoolean("ativo"));
				
				if(acc.getTipo() == 2){
					String sqlReqCc = "select * from contacorrente c where c.idcontas =" + accountTO.getId();
					statement1 = connection.prepareStatement(sqlReqCc);
					ResultSet result1 = statement1.executeQuery();
					
					accountTO.setAg(result1.getInt("agencia"));
					accountTO.setCc(result1.getInt("cc"));
					
				}
				accounts.add(acc);
			}
			result.close();
			statement.close();
			connection.close();
			
		
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
		return accounts;
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
