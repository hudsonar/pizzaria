package dao;

import java.util.List;

import dominio.Cliente;

public interface ClienteDao {
	
	public void inserirAtualizar(Cliente x);
	public void excluir(Cliente x);
	public Cliente buscar(int cod);
	public List<Cliente> buscarTodos();
	
	public Cliente buscaCpfExato(String cpf);
	public Cliente buscaCpfExatoDiferente(Integer codigo, String cpf);
	public List<Cliente> buscarPorNome(String trecho);
}
