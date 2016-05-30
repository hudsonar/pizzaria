package servico;

import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import dao.ItemPedidoDao;
import dao.Transaction;
import dominio.ItemPedido;

public class ItemPedidoServico {
	
	private ItemPedidoDao dao;
	
	public ItemPedidoServico(){
		dao = DaoFactory.criarItemPedidoDao();
	}
	
	public void inserir(ItemPedido x) throws ServicoException{
		try {
			ItemPedido aux = dao.buscarExato(x.getPizza(), x.getPedido());
			if(aux != null){
				throw new ServicoException("O pedido "+x.getPedido().getCodPedido()+ " já possui a pizza de "+x.getPizza().getNome(), 1);
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
	
	public void atualizar(ItemPedido x)throws ServicoException{
		try {
			ItemPedido aux = dao.buscarExatoDiferente(x.getCodItemPedido(), x.getPizza(), x.getPedido());
			if(aux != null){
				throw new ServicoException("O pedido "+x.getPedido().getCodPedido()+ " já possui a pizza de "+x.getPizza().getNome(), 1);
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
	
	public void excluir(ItemPedido x){
		try {
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
	public ItemPedido buscar(int cod){
		return dao.buscar(cod);
	}
	public List<ItemPedido> buscarTodos(){
		return dao.buscarTodos();
	}
	
	public void validar(ItemPedido x) throws ValidacaoException{
		List<String> erros = new ArrayList<>();
		
		if(x.getQuantidade()==null){
			erros.add("Favor preencher o campo quantidade");
		}
		if(x.getPizza()==null){
			erros.add("Favor preencher o campo pizza");
		}
		if(x.getPedido()==null){
			erros.add("Favor selecionar um pedido");
		}
		if(!erros.isEmpty()){
			throw new ValidacaoException("Erro de validação", erros);
		}
	}
}
