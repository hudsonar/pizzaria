package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ItemPizzaDao;
import dominio.ItemPizza;

public class ItemPizzaDaoImpl implements ItemPizzaDao {
	
	private EntityManager em;
	
	public ItemPizzaDaoImpl(){
		this.em = EM.getlocalEm();
	}
	
	@Override
	public void inserirAtualizar(ItemPizza x) {
		if(x.getCodItemPizza()!= null){
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(ItemPizza x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public ItemPizza buscar(int cod) {
		return em.find(ItemPizza.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemPizza> buscarTodos() {
		String jpql = "SELECT x FROM ItemPizza x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
