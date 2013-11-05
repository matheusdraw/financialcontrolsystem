package financialcontrolsystem.view;

import java.util.List;
import java.util.Scanner;

import financialcontrolsystem.controller.AccountController;

import financialcontrolsystem.model.Account;

import financialcontrolsystem.model.AccountType;

// esta view é apenas para teste do banco de dados.
public class ViewTest {
	Scanner input = new Scanner(System.in);

	public void menu() {
		int option;

		System.out.println("Opções:");
		System.out.println("1 - Adicionar Nova Conta");
		System.out.println("2 - Listar Todas as Contas");
		System.out.println("3 - Excluir Conta");
		option = input.nextInt();

		switch (option) {
		case 1:
			newAcc();
			break;
		case 2:
			listAllAcc();
			break;
		case 3:
			deleteAcc();
			break;
		}
	}

	private void deleteAcc() {
		AccountController acc = new AccountController();
		List<Account> accounts = acc.listAccounts();
		
		System.out.println("--------------------------");
		for (Account account : accounts) {
			AccountType type = account.getTipo();
			
			System.out.println("ID: " + account.getId());
			System.out.println("Conta: " + account.getDescricao());
			System.out.println("Tipo: " + type.getDescricao());

			if (type.getId() == 2) {
				System.out.println("Conta Corrente: " + account.getCc());
				System.out.println("Agência: " + account.getAg());
			}
			System.out.println("--------------------------");
		}
		
		System.out.println("Escolha a conta:");
		int option = input.nextInt();
		
		for(Account account : accounts){
			if(account.getId() == option){
				boolean flag = acc.delAccount(account);
				if(flag){
					System.out.println("Conta Excluida com Sucesso!!");
				}
			}
		}
		
	}

	private void listAllAcc() {
		AccountController acc = new AccountController();
		List<Account> accounts = acc.listAccounts();
		
		System.out.println("--------------------------");
		for (Account account : accounts) {
			AccountType type = account.getTipo();
			
			System.out.println("ID: " + account.getId());
			System.out.println("Conta: " + account.getDescricao());
			System.out.println("Tipo: " + type.getDescricao());

			if (type.getId() == 2) {
				System.out.println("Conta Corrente: " + account.getCc());
				System.out.println("Agência: " + account.getAg());
			}
			System.out.println("--------------------------");
		}
	}

	private void newAcc() {
		Account acc = new Account();
		AccountController controller = new AccountController();
		int id;
		boolean flag;
		List<AccountType> accTypes;

		acc.setAtivo(true);
		System.out.println("Nome:");
		acc.setDescricao(getString());
		accTypes = controller.getAccTypes();

		System.out.println("Selecione um tipo:");
		System.out.println("--------------------------");
		for (AccountType t : accTypes) {
			System.out.println(t.getId() + "." + t.getDescricao());
			System.out.println("--------------------------");
		}

		id = input.nextInt();

		if (id == 2) {
			System.out.println("Conta Corrente:");
			acc.setCc(input.nextInt());
			System.out.println("Agência:");
			acc.setAg(input.nextInt());
		}

		for (AccountType t : accTypes) {
			if (t.getId() == id) {
				acc.setTipo(t);
			}
		}
		flag = controller.createAccount(acc);

		if (flag) {
			System.out.println("Conta Cadastrada com Sucesso!");
		}
	}

	/*
	 * private void delete(OrderTO ped) { do{ System.out.println("PEDIDO:");
	 * ped.setOrderNumber(input.nextInt());
	 * }while(!dao.checkOrderNumber(ped.getOrderNumber()));
	 * 
	 * dao.delete(ped);
	 * 
	 * } public void destinatario(OrderTO ped){
	 * System.out.println("--------- DADOS DO DESTINATARIO ---------");
	 * 
	 * do{ System.out.println("CEP:"); ped.setDestinataryCep(input.nextInt());
	 * //ped = controller.getDestinataryCityState(ped);
	 * }while(!dao.returnDestinataryCityState(ped));
	 * 
	 * 
	 * System.out.println("ESTADO: " + ped.getDestinataryState());
	 * System.out.println("CIDADE: " + ped.getDestinataryCity());
	 * System.out.println("BAIRRO:"); ped.setDestinataryNeighbor(getString());
	 * System.out.println("ENDEREÇO:"); ped.setDestinataryStreet(getString());
	 * System.out.println("NUMERO:");
	 * ped.setDestinataryStreetNumber(input.nextInt());
	 * System.out.println("MODO DE ENVIO:"); ped.setSendMode(input.next() +
	 * input.nextLine()); System.out.println("TOTAL:");
	 * ped.setTotalCosts(input.nextFloat()); numPedGenerator(ped);
	 * 
	 * } public void numPedGenerator(OrderTO ped){ // fazer o calculo do frete
	 * dao.getDeliveryDays(ped); System.out.println("prazo:" +
	 * ped.getDeliveryDays()); // gerar numero do pedido
	 * //System.out.println("num envio:" + controller.newOrderNum(ped));
	 * dao.create(ped); busca(ped); }
	 * 
	 * public void busca(OrderTO ped){
	 * System.out.println("--------- BUSCA PEDIDO ---------"); int orderNumber;
	 * 
	 * do{ System.out.println("PEDIDO:"); orderNumber = input.nextInt();
	 * }while(!dao.checkOrderNumber(orderNumber));
	 * 
	 * dao.retrieveOne(orderNumber, ped);
	 * 
	 * System.out.println("estado dest: " + ped.getDestinataryState());
	 * System.out.println("cidade dest: " + ped.getDestinataryCity());
	 * System.out.println("bairro dest:" + ped.getDestinataryNeighbor());
	 * System.out.println("end dest:" + ped.getDestinataryStreet());
	 * System.out.println("num dest:" + ped.getDestinataryStreetNumber());
	 * System.out.println("cidade emit: " + ped.getSenderCity());
	 * System.out.println("estado emit: " + ped.getSenderState());
	 * System.out.println("bairro emi:" + ped.getSenderNeighbor());
	 * System.out.println("end emit:" + ped.getSenderStreet());
	 * System.out.println("num emit:" + ped.getSenderStreetNumber());
	 * System.out.println("modo envio: " + ped.getSendMode());
	 * System.out.println("preço:" + ped.getTotalCosts());
	 * 
	 * altera(ped); }
	 * 
	 * 
	 * public void altera(OrderTO ped){ String campo;
	 * 
	 * System.out.println("--------- ALTERAR PEDIDO ---------"); do{
	 * System.out.println("CAMPO:"); campo = (input.next() + input.nextLine());
	 * if(!controller.checkField(campo)){ System.out.println("CAMPO INVALIDO");
	 * } }while(!controller.checkField(campo));
	 * 
	 * 
	 * do{ System.out.println("PEDIDO:"); ped.setOrderNumber(input.nextInt());
	 * }while(!dao.checkOrderNumber(ped.getOrderNumber()));
	 * 
	 * System.out.println("nova entrada:"); String newData = input.next() +
	 * input.nextLine();
	 * 
	 * dao.update(ped, campo, newData);
	 * 
	 * }
	 */

	public String getString() {
		return input.next() + input.nextLine();
	}
}
