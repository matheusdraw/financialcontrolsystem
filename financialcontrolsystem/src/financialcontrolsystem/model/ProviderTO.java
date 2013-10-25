package financialcontrolsystem.model;

import java.sql.Date;

public class ProviderTO {
	
	private int id;
	private int idag;
	private boolean ativo;
	private Date dataCad;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdag() {
		return idag;
	}
	public void setIdag(int idag) {
		this.idag = idag;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Date getDataCad() {
		return dataCad;
	}
	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}
}
