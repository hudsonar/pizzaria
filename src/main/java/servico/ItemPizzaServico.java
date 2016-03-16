package servico;

import java.util.List;

import dao.ItemPizzaDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.ItemPizza;

public class ItemPizzaServico {
	
	private ItemPizzaDao dao;
	
	public ItemPizzaServico(){
		dao = DaoFactory.criarItemPizzaDao();
	}
	
	public void inserirAtualizar(ItemPizza x){
		EM.getlocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getlocalEm().getTransaction().commit();
	}
	public void excluir(ItemPizza x){
		EM.getlocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getlocalEm().getTransaction().commit();
	}
	public ItemPizza buscar(int cod){
		return dao.buscar(cod);
	}
	public List<ItemPizza> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
