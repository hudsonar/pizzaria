package dao;

import java.util.List;

import dominio.ItemPedido;
import dominio.Pedido;
import dominio.Pizza;

public interface ItemPedidoDao {
	public void inserirAtualizar(ItemPedido x);
	public void excluir(ItemPedido x);
	public ItemPedido buscar(int cod);
	public List<ItemPedido> buscarTodos();
	
	public ItemPedido buscarExato(Pizza pizza, Pedido pedido);
	public ItemPedido buscarExatoDiferente(Integer codigo, Pizza pizza, Pedido pedido);
}
