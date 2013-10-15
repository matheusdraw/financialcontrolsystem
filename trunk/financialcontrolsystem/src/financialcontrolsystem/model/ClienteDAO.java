package financialcontrolsystem.model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ClienteDAO {

	@SuppressWarnings("unchecked")
	public void salvar(ClienteTO clienteTO) {

		ArrayList<ClienteTO> clientes = null;

		try {
			@SuppressWarnings("resource")
			XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(
					"Test.xml"));
			clientes = (ArrayList<ClienteTO>) xmlDecoder.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (clientes == null) {
			clientes = new ArrayList<ClienteTO>();
		}
		clientes.add(clienteTO);

		try {
			@SuppressWarnings("resource")
			XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(
					"Test.xml"));
			xmlEncoder.writeObject(clientes);
			// xmlEncoder.close();
			xmlEncoder.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "resource", "unchecked" })
	public ArrayList<ClienteTO> getAll() {
		ArrayList<ClienteTO> clientes = null;

		XMLDecoder xmlDecoder;
		try {
			xmlDecoder = new XMLDecoder(new FileInputStream("Test.xml"));
			clientes = (ArrayList<ClienteTO>) xmlDecoder.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clientes;

	}
}
