package financialcontrolsystem.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tipos_contas")
public class AccountType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="seq_tipos_contas")
	@GenericGenerator(strategy="increment", name="seq_tipos_contas") 
	private Long id;
	
	@Column
	private String descricao;
	
	@OneToMany(mappedBy="Account", targetEntity=Account.class)
	private List<Account> contas;
	

	/*************************Getters and Setters*************************/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Account> getContas() {
		return contas;
	}

	public void setContas(List<Account> contas) {
		this.contas = contas;
	}
}
