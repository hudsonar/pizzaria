package servico;

import java.util.List;

import dao.PizzaDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Pizza;

public class PizzaServico {
	
	private PizzaDao dao;
	
	public PizzaServico(){
		dao = DaoFactory.criarPizzaDao();
	}
	
	public void inserirAtualizar(Pizza x){
		EM.getlocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getlocalEm().getTransaction().commit();
	}
	public void excluir(Pizza x){
		EM.getlocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getlocalEm().getTransaction().commit();
	}
	public Pizza buscar(int cod){
		return dao.buscar(cod);
	}
	public List<Pizza> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
