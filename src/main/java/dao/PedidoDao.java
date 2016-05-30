package dao;

import java.util.Date;
import java.util.List;

import dominio.Pedido;

public interface PedidoDao {
	public void inserirAtualizar(Pedido x);
	public void excluir(Pedido x);
	public Pedido buscar(int cod);
	public List<Pedido> buscarTodos();
	
	public List<Pedido> buscarPorData(Date dataMin,Date dataMax);
	public List<Pedido> buscarPorCliente(int cliente);
}
