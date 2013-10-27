package financialcontrolsystem.model;

public class AccountTO {

	private int id;
	private String name;
	private boolean ativo;
	private int tipo;
	private int cc;
	private int ag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getAg() {
		return ag;
	}

	public void setAg(int ag) {
		this.ag = ag;
	}
}
