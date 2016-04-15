package servico;

import java.util.List;

import dao.DaoFactory;
import dao.IngredienteDao;
import dao.Transaction;
import dominio.Ingrediente;

public class IngredienteServico {
	
	private IngredienteDao dao;
	
	public IngredienteServico(){
		dao = DaoFactory.criarIngredienteDao();
	}
	
	public void inserirAtualizar(Ingrediente x){
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
	public void excluir(Ingrediente x){
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
	public Ingrediente buscar(int cod){
		return dao.buscar(cod);
	}
	public List<Ingrediente> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
