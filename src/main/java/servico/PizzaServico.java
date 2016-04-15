package servico;

import java.util.List;

import dao.DaoFactory;
import dao.PizzaDao;
import dao.Transaction;
import dominio.Pizza;

public class PizzaServico {
	
	private PizzaDao dao;
	
	public PizzaServico(){
		dao = DaoFactory.criarPizzaDao();
	}
	
	public void inserirAtualizar(Pizza x){
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
	public void excluir(Pizza x){
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
	public Pizza buscar(int cod){
		return dao.buscar(cod);
	}
	public List<Pizza> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
