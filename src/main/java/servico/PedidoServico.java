package servico;

import java.util.List;

import dao.PedidoDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Pedido;

public class PedidoServico {
	
	private PedidoDao dao;
	
	public PedidoServico(){
		dao = DaoFactory.criarPedidoDao();
	}
	
	public void inserirAtualizar(Pedido x){
		EM.getlocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getlocalEm().getTransaction().commit();
	}
	public void excluir(Pedido x){
		EM.getlocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getlocalEm().getTransaction().commit();
	}
	public Pedido buscar(int cod){
		return dao.buscar(cod);
	}
	public List<Pedido> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
