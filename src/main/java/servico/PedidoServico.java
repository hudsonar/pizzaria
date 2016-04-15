package servico;

import java.util.Date;
import java.util.List;

import dao.DaoFactory;
import dao.PedidoDao;
import dao.Transaction;
import dominio.Pedido;

public class PedidoServico {
	
	private PedidoDao dao;
	
	public PedidoServico(){
		dao = DaoFactory.criarPedidoDao();
	}
	
	public void inserirAtualizar(Pedido x){
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("ERRO: " + e.getMessage());
		}

	}
	public void excluir(Pedido x){
		try {
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	public Pedido buscar(int cod){
		return dao.buscar(cod);
	}
	public List<Pedido> buscarTodos(){
		return dao.buscarTodos();
	}
	
	public List<Pedido> buscarPorData(Date dataMin, Date dataMax){
		return dao.buscarPorData(dataMin, dataMax);
	}
	
}
