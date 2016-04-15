package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ItemPizzaDao;
import dao.Transaction;
import dominio.ItemPizza;

public class ItemPizzaServico {
	
	private ItemPizzaDao dao;
	
	public ItemPizzaServico(){
		dao = DaoFactory.criarItemPizzaDao();
	}
	
	public void inserirAtualizar(ItemPizza x){
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
	public void excluir(ItemPizza x){
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
	public ItemPizza buscar(int cod){
		return dao.buscar(cod);
	}
	public List<ItemPizza> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
