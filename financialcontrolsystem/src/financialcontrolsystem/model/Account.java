package financialcontrolsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="contas", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"nome"})})

public class Account implements Serializable{
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="seq_contas")
	@GenericGenerator(strategy="increment", name="seq_contas") 
	private Long id;
	
	@Column
	private String descricao;
	
	@Column
	private boolean ativo;
	
	@Column
	@OneToMany
	@JoinColumn(name="tipo_conta")
	private AccountType tipo;
	
	@Column
	private int cc;
	
	@Column
	private int ag;
	

	/*************************Getters and Setters*************************/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String name) {
		this.descricao = name;
	}

	public boolean isAtivo() {
		return ativo;
	
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public AccountType getTipo() {
		return tipo;
	}

	public void setTipo(AccountType tipo) {
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
