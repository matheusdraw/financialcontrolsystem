package financialcontrolsystem.model;

import java.util.List;

import javax.persistence.Query;

public class AccountDAO extends ConnectionDataBase {

	public boolean createNewAccount(Account acc) {
		try {
			manager.getTransaction().begin();
			manager.persist(acc);
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage()); 
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<AccountType> listTypes() {
		try {
			Query query = manager.createQuery("SELECT t FROM AccountType t");
			List<AccountType> accTypes = query.getResultList();
			return accTypes;
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage()); 
			e.printStackTrace();
		}
		return null;
	}

	public List<Account> listAccounts() {
		try {
			Query query = manager.createQuery("SELECT a FROM Account a WHERE a.ativo = true");
			List<Account> accounts = query.getResultList();
			return accounts;
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage()); 
			e.printStackTrace();
		}
		return null;
	}

	public boolean delAccount(Account account) {
		try {
			manager.getTransaction().begin();
			manager.merge(account);
			manager.getTransaction().commit();
			manager.close();
			return true;
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage()); 
			e.printStackTrace();
			return false;
		}
	}
	
	
	/*
	 * private Connection connection = null; private Statement statement = null;
	 * 
	 * public AccountDAO(){ connection = createConnection();
	 * 
	 * try { statement = getStatement(); } catch (SQLException e) {
	 * System.out.println("Erro:" + e.getMessage()); e.printStackTrace(); } }
	 * 
	 * // Retorna todas as contas. public List<AccountTO> listAllAccounts() {
	 * AccountTO accountTO = new AccountTO(); List<AccountTO> accounts = new
	 * ArrayList<AccountTO>();
	 * 
	 * try { String sqlReqAcc = "select * from contas"; PreparedStatement
	 * statement; PreparedStatement statement1;
	 * 
	 * statement = connection.prepareStatement(sqlReqAcc); ResultSet result =
	 * statement.executeQuery();
	 * 
	 * // Termina o while quando retorna todos os registros. while
	 * (result.next()) { AccountTO acc = new AccountTO();
	 * acc.setId(result.getInt("id")); acc.setName(result.getString("nome"));
	 * acc.setTipo(result.getInt("tipo"));
	 * acc.setAtivo(result.getBoolean("ativo"));
	 * 
	 * if(acc.getTipo() == 2){ String sqlReqCc =
	 * "select * from contacorrente c where c.idcontas =" + accountTO.getId();
	 * statement1 = connection.prepareStatement(sqlReqCc); ResultSet result1 =
	 * statement1.executeQuery();
	 * 
	 * accountTO.setAg(result1.getInt("agencia"));
	 * accountTO.setCc(result1.getInt("cc"));
	 * 
	 * } accounts.add(acc); } result.close(); statement.close();
	 * connection.close();
	 * 
	 * 
	 * } catch (SQLException e) { System.out.println("Erro: " + e.getMessage());
	 * e.printStackTrace(); } return accounts; }
	 * 
	 * // Busca uma conta específica. public void requestAccount(AccountTO
	 * accountTO) {
	 * 
	 * String sqlReqAcc = "select * from contas c where c.descricao = '" +
	 * accountTO.getName() + "'";
	 * 
	 * Statement statement; try { statement = getStatement(); ResultSet result =
	 * statement.executeQuery(sqlReqAcc);
	 * 
	 * while (result.next()) { accountTO.setName(result.getString("descricao"));
	 * }
	 * 
	 * } catch (SQLException e) { System.out.println("Erro: " + e.getMessage());
	 * e.printStackTrace(); } }
	 * 
	 * // Verifica se a conta está ativa ou inativa. public boolean
	 * verifyAccount(AccountTO accountTO) { Boolean active = null; String
	 * sqlVerAcc = "select c.ativo from contas c where c.descricao = '" +
	 * accountTO.getName() + "'";
	 * 
	 * Statement statement; try { statement = getStatement(); ResultSet result =
	 * statement.executeQuery(sqlVerAcc);
	 * 
	 * while (result.next()) { active = result.getBoolean("ativo"); }
	 * 
	 * } catch (SQLException e) { System.out.println("Erro: " + e.getMessage());
	 * e.printStackTrace(); } if (active) { return true; }else{ return false; }
	 * }
	 */

}
