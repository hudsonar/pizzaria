package dao;

import java.util.List;

import dominio.Ingrediente;

public interface IngredienteDao {
	public void inserirAtualizar(Ingrediente x);
	public void excluir(Ingrediente x);
	public Ingrediente buscar(int cod);
	public List<Ingrediente> buscarTodos();
}
