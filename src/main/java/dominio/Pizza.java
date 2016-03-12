package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_pizza")
public class Pizza implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codPizza;
	private String nome;
	
	@OneToMany(mappedBy="pizza")
	private List<ItemPedido> itensPedido;
	
	@OneToMany(mappedBy="pizza")
	private List<ItemPizza> itens;
	
	public Pizza(){
		itensPedido = new ArrayList<>();
		itens = new ArrayList<>();
	}

	public Pizza(Integer codPizza, String nome) {
		super();
		this.codPizza = codPizza;
		this.nome = nome;
		itensPedido = new ArrayList<>();
		itens = new ArrayList<>();
	}

	public Integer getCodPizza() {
		return codPizza;
	}

	public void setCodPizza(Integer codPizza) {
		this.codPizza = codPizza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public List<ItemPizza> getItens() {
		return itens;
	}

	public void setItens(List<ItemPizza> itens) {
		this.itens = itens;
	}

	public void addItemPedido(ItemPedido itemPedido) {
		this.itensPedido.add(itemPedido);
		itemPedido.setPizza(this);
	}
	
	public void removeItemPedido(ItemPedido itemPedido) {
		this.itensPedido.remove(itemPedido);
	}

	public void addItemPizza(ItemPizza itemPizza) {
		this.itens.add(itemPizza);
		itemPizza.setPizza(this);
	}
	
	public void removeItemPizza(ItemPizza itemPizza) {
		this.itens.remove(itemPizza);
	}

	@Override
	public String toString() {
		return "Pizza [codPizza=" + codPizza + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPizza == null) ? 0 : codPizza.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (codPizza == null) {
			if (other.codPizza != null)
				return false;
		} else if (!codPizza.equals(other.codPizza))
			return false;
		return true;
	}

	public BigDecimal valorTotal() {
		BigDecimal soma = new BigDecimal("0.00");
		for(ItemPizza x : itens){
			soma = soma.add(x.getIngrediente().getPreco());
		}
		return soma;
	}
	
	
}
