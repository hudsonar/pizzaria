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
@Table(name="tb_ingrediente")
public class Ingrediente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codIngrediente;
	private String nome;
	private BigDecimal preco;
	
	@OneToMany(mappedBy="ingrediente")
	private List<ItemPizza> itens;
	
	public Ingrediente(){
		itens = new ArrayList<>();
	}

	public Ingrediente(Integer codIngrediente, String nome, BigDecimal preco) {
		super();
		this.codIngrediente = codIngrediente;
		this.nome = nome;
		this.preco = preco;
		itens = new ArrayList<>();
	}

	public Integer getCodIngrediente() {
		return codIngrediente;
	}

	public void setCodIngrediente(Integer codIngrediente) {
		this.codIngrediente = codIngrediente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public List<ItemPizza> getItens() {
		return itens;
	}

	public void setItens(List<ItemPizza> itens) {
		this.itens = itens;
	}

	public void addItemPizza(ItemPizza itemPizza) {
		this.itens.add(itemPizza);
		itemPizza.setIngrediente(this);
	}
	
	public void removeItemPizza(ItemPizza itemPizza) {
		this.itens.remove(itemPizza);
	}

	@Override
	public String toString() {
		return "Ingrediente [codIngrediente=" + codIngrediente + ", nome=" + nome + ", preco=" + preco + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codIngrediente == null) ? 0 : codIngrediente.hashCode());
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
		Ingrediente other = (Ingrediente) obj;
		if (codIngrediente == null) {
			if (other.codIngrediente != null)
				return false;
		} else if (!codIngrediente.equals(other.codIngrediente))
			return false;
		return true;
	}
	
	
}