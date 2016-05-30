package dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.PedidoDao;
import dominio.Pedido;

public class PedidoDaoImpl implements PedidoDao {
	
	private EntityManager em;
	
	public PedidoDaoImpl(){
		this.em = EM.getlocalEm();
	}
	
	@Override
	public void inserirAtualizar(Pedido x) {
		if(x.getCodPedido()!= null){
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Pedido x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Pedido buscar(int cod) {
		return em.find(Pedido.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> buscarTodos() {
		String jpql = "SELECT x FROM Pedido x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> buscarPorData(Date dataMin, Date dataMax){
		String jpql = "SELECT x FROM Pedido x WHERE x.data >= :p1 AND x.data <= :p2";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", dataMin);
		query.setParameter("p2", dataMax);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> buscarPorCliente(int cliente){
		String jpql = "SELECT x FROM Pedido x WHERE x.cliente = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", cliente);
		return query.getResultList();
	}
}
