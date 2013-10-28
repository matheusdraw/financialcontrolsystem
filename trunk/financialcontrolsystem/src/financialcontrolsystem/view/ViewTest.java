package financialcontrolsystem.view;

import java.util.List;
import java.util.Scanner;

import financialcontrolsystem.controller.AccountController;
import financialcontrolsystem.model.AccountDAO;
import financialcontrolsystem.model.AccountTO;
import financialcontrolsystem.model.CcTO;

// esta view é apenas para teste do banco de dados.
public class ViewTest {
	Scanner input = new Scanner(System.in);	

	public void menu() {
		int option;
		
		System.out.println("Opções:");
		System.out.println("1 - Adicionar Nova Conta");
		System.out.println("2 - Listar Todas as Contas");
		option = input.nextInt();
		
		switch(option){
			case 1: newAcc();
			case 2:listAllAcc();
		}
	}
	
	private void listAllAcc() {
		AccountController acc = new AccountController();
		List<AccountTO> accounts = acc.listAccounts();
		
		for(AccountTO account : accounts){
			
			System.out.println("--------------------------");	
			System.out.println("ID: " + account.getId());
			System.out.println("Conta: " + account.getName());
			System.out.println("Tipo: " + account.getTipo());
			
			if(account.getTipo() == 2){
				System.out.println("Conta Corrente: " + account.getCc());
				System.out.println("Agência: " + account.getAg());
			
			}
			System.out.println("--------------------------");
		}
	}

	private void newAcc() {
		AccountTO accTO = new AccountTO();
		AccountController acc = new AccountController();
		
		System.out.println("Nome:");
		accTO.setName(getString());
		System.out.println("Tipo: 1-Carteira 2-Conta Corrente 3-Poupança");
		accTO.setTipo(input.nextInt());
		
		if (accTO.getTipo() == 2) {
			System.out.println("Conta Corrente:");
			accTO.setCc(input.nextInt());
			System.out.println("Agência:");
			accTO.setAg(input.nextInt());
		}
		acc.createAccount(accTO);
	}

	/*private void delete(OrderTO ped) {
		do{
			System.out.println("PEDIDO:");
			ped.setOrderNumber(input.nextInt());
		}while(!dao.checkOrderNumber(ped.getOrderNumber()));
		
		dao.delete(ped);
		
	}
	public void destinatario(OrderTO ped){
		System.out.println("--------- DADOS DO DESTINATARIO ---------");
		
		do{
			System.out.println("CEP:");
			ped.setDestinataryCep(input.nextInt());
			//ped = controller.getDestinataryCityState(ped);			
		}while(!dao.returnDestinataryCityState(ped));
		
		
		System.out.println("ESTADO: " + ped.getDestinataryState());
		System.out.println("CIDADE: " + ped.getDestinataryCity());
		System.out.println("BAIRRO:");
		ped.setDestinataryNeighbor(getString());
		System.out.println("ENDEREÇO:");
		ped.setDestinataryStreet(getString());
		System.out.println("NUMERO:");
		ped.setDestinataryStreetNumber(input.nextInt());
		System.out.println("MODO DE ENVIO:");
		ped.setSendMode(input.next() + input.nextLine());
		System.out.println("TOTAL:");
		ped.setTotalCosts(input.nextFloat());
		numPedGenerator(ped);
		
	}
	public void numPedGenerator(OrderTO ped){
	    // fazer o calculo do frete
		dao.getDeliveryDays(ped);
		System.out.println("prazo:" + ped.getDeliveryDays());
		// gerar numero do pedido
		//System.out.println("num envio:" + controller.newOrderNum(ped));
		dao.create(ped);
		busca(ped);
	}	
	
	public void busca(OrderTO ped){
		System.out.println("--------- BUSCA PEDIDO ---------");
		int orderNumber; 
		
		do{
			System.out.println("PEDIDO:");
			orderNumber = input.nextInt();
		}while(!dao.checkOrderNumber(orderNumber));
		
		dao.retrieveOne(orderNumber, ped);
		
		System.out.println("estado dest: " + ped.getDestinataryState());
		System.out.println("cidade dest: " + ped.getDestinataryCity());
		System.out.println("bairro dest:" + ped.getDestinataryNeighbor());
		System.out.println("end dest:" + ped.getDestinataryStreet());
		System.out.println("num dest:" + ped.getDestinataryStreetNumber());
		System.out.println("cidade emit: " + ped.getSenderCity());
		System.out.println("estado emit: " + ped.getSenderState());
		System.out.println("bairro emi:" + ped.getSenderNeighbor());
		System.out.println("end emit:" + ped.getSenderStreet());
		System.out.println("num emit:" + ped.getSenderStreetNumber());
		System.out.println("modo envio: " + ped.getSendMode());
		System.out.println("preço:" + ped.getTotalCosts());
		
		altera(ped);
	}
	
	
	public void altera(OrderTO ped){
		String campo;
		
		System.out.println("--------- ALTERAR PEDIDO ---------");
		do{
			System.out.println("CAMPO:");
			campo = (input.next() + input.nextLine());
			if(!controller.checkField(campo)){
				System.out.println("CAMPO INVALIDO");
			}
		}while(!controller.checkField(campo));
		
		
		do{
			System.out.println("PEDIDO:");
			ped.setOrderNumber(input.nextInt());
		}while(!dao.checkOrderNumber(ped.getOrderNumber()));

		System.out.println("nova entrada:");
		String newData = input.next() + input.nextLine();
		
		dao.update(ped, campo, newData);		
		
	}*/
	
	public String getString(){
		return input.next() + input.nextLine();
	}
}
