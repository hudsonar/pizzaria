package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codPedido;
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itens;
	
	public Pedido(){
		itens = new ArrayList<>();
	}

	public Pedido(Integer codPedido, Date data, Cliente cliente) {
		super();
		this.codPedido = codPedido;
		this.data = data;
		this.cliente = cliente;
		cliente.addPedido(this);
		itens = new ArrayList<>();
	}

	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public void addItemPedido(ItemPedido itemPedido) {
		this.itens.add(itemPedido);
		itemPedido.setPedido(this);
	}

	public void removeItemPedido(ItemPedido itemPedido) {
		this.itens.remove(itemPedido);		
	}

	@Override
	public String toString() {
		return "Pedido [codPedido=" + codPedido + ", data=" + data + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPedido == null) ? 0 : codPedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (codPedido == null) {
			if (other.codPedido != null)
				return false;
		} else if (!codPedido.equals(other.codPedido))
			return false;
		return true;
	}
	
	public BigDecimal valorTotal(){
		BigDecimal soma = new BigDecimal("0.00");
		for(ItemPedido ipd : itens){
			soma = soma.add(ipd.subTotal());
		}
		return soma;
	}
}
