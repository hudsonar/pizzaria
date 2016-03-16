package dao;

import java.util.List;

import dominio.Pizza;

public interface PizzaDao {
	public void inserirAtualizar(Pizza x);
	public void excluir(Pizza x);
	public Pizza buscar(int cod);
	public List<Pizza> buscarTodos();
}
