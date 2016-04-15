package servico;

import java.util.List;

import dao.ClienteDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Cliente;

public class ClienteServico {

	private ClienteDao dao;

	public ClienteServico() {
		dao = DaoFactory.criarClienteDao();
	}

	public void inserir(Cliente x) throws ServicoException {
		try {
			Cliente aux = dao.buscaCpfExato(x.getCpf());
			if(aux != null){
				throw new ServicoException("Já exite um cliente com esse CPF!", 1);
			}
			
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void atualizar(Cliente x) throws ServicoException {
		try {
			Cliente aux = dao.buscaCpfExatoDiferente(x.getCodCliente(), x.getCpf());
			if(aux != null){
				throw new ServicoException("Já exite um cliente com esse CPF!", 1);
			}
			
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void excluir(Cliente x) throws ServicoException {
		try {
			x = dao.buscar(x.getCodCliente());
			if(!x.getPedidos().isEmpty()){
				throw new ServicoException("Este cliente possui pedidos!", 2);
			}
			
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("ERRO: " + e.getMessage());
		}
	}

	public Cliente buscar(int cod) {
		return dao.buscar(cod);
	}

	public List<Cliente> buscarTodos() {
		return dao.buscarTodos();
	}

	public List<Cliente> buscarPorNome(String trecho){
		return dao.buscarPorNome(trecho);
	}
}
