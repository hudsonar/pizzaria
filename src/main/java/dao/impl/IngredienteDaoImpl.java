package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IngredienteDao;
import dominio.Ingrediente;

public class IngredienteDaoImpl implements IngredienteDao {
	
	private EntityManager em;
	
	public IngredienteDaoImpl(){
		this.em = EM.getlocalEm();
	}
	
	@Override
	public void inserirAtualizar(Ingrediente x) {
		if(x.getCodIngrediente()!= null){
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Ingrediente x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Ingrediente buscar(int cod) {
		return em.find(Ingrediente.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ingrediente> buscarTodos() {
		String jpql = "SELECT x FROM Ingrediente x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
