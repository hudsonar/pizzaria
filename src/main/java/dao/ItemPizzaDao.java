package dao;

import java.util.List;

import dominio.ItemPizza;

public interface ItemPizzaDao {
	public void inserirAtualizar(ItemPizza x);
	public void excluir(ItemPizza x);
	public ItemPizza buscar(int cod);
	public List<ItemPizza> buscarTodos();
}
