package servico;

import java.util.List;

import dao.IngredienteDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Ingrediente;

public class IngredienteServico {
	
	private IngredienteDao dao;
	
	public IngredienteServico(){
		dao = DaoFactory.criarIngredienteDao();
	}
	
	public void inserirAtualizar(Ingrediente x){
		EM.getlocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getlocalEm().getTransaction().commit();
	}
	public void excluir(Ingrediente x){
		EM.getlocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getlocalEm().getTransaction().commit();
	}
	public Ingrediente buscar(int cod){
		return dao.buscar(cod);
	}
	public List<Ingrediente> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
