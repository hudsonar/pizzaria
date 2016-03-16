package servico;

import java.util.List;

import dao.ItemPedidoDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.ItemPedido;

public class ItemPedidoServico {
	
	private ItemPedidoDao dao;
	
	public ItemPedidoServico(){
		dao = DaoFactory.criarItemPedidoDao();
	}
	
	public void inserirAtualizar(ItemPedido x){
		EM.getlocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getlocalEm().getTransaction().commit();
	}
	public void excluir(ItemPedido x){
		EM.getlocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getlocalEm().getTransaction().commit();
	}
	public ItemPedido buscar(int cod){
		return dao.buscar(cod);
	}
	public List<ItemPedido> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
