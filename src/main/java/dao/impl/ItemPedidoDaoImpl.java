package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ItemPedidoDao;
import dominio.ItemPedido;
import dominio.Pedido;
import dominio.Pizza;

public class ItemPedidoDaoImpl implements ItemPedidoDao {
	
	private EntityManager em;
	
	public ItemPedidoDaoImpl(){
		this.em = EM.getlocalEm();
	}
	
	@Override
	public void inserirAtualizar(ItemPedido x) {
		if(x.getCodItemPedido()!= null){
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(ItemPedido x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public ItemPedido buscar(int cod) {
		return em.find(ItemPedido.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemPedido> buscarTodos() {
		String jpql = "SELECT x FROM ItemPedido x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ItemPedido buscarExato(Pizza pizza, Pedido pedido){
		String jpql = "SELECT x FROM ItemPedido x WHERE x.pizza = :p1 AND x.pedido = :p2";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", pizza);
		query.setParameter("p2", pedido);
		List<ItemPedido> aux = query.getResultList();
		return (aux.size() > 0)? aux.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ItemPedido buscarExatoDiferente(Integer codigo, Pizza pizza, Pedido pedido){
		String jpql = "SELECT x FROM ItemPedido x WHERE x.codItemPedido <> :p0 AND x.pizza = :p1 AND x.pedido = :p2";
		Query query = em.createQuery(jpql);
		query.setParameter("p0", codigo);
		query.setParameter("p1", pizza);
		query.setParameter("p2", pedido);
		List<ItemPedido> aux = query.getResultList();
		return (aux.size() > 0)? aux.get(0) : null;
	}

}
