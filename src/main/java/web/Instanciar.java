package web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import dominio.Cliente;
import dominio.ItemPedido;
import dominio.Pedido;
import dominio.Pizza;
import servico.PedidoServico;
import servico.PizzaServico;

public class Instanciar {

	public static Cliente cliente(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Cliente aux = new Cliente();
		String s;
		
		s = request.getParameter("codCliente");

		if (s != null && !s.isEmpty()) {
			try{
				aux.setCodCliente(Integer.parseInt(s));
			}catch (NumberFormatException e){
				e.printStackTrace();
			}
		}		
		
		s = request.getParameter("nome");

		if (s != null && !s.isEmpty()) {
			aux.setNome(s);
		}

		s = request.getParameter("email");

		if (s != null && !s.isEmpty()) {
			aux.setEmail(s);;
		}
		
		s = request.getParameter("cpf");

		if (s != null && !s.isEmpty()) {
			try{
				aux.setCpf(s);
			} catch (NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		s = request.getParameter("telefone");

		if (s != null && !s.isEmpty()) {
			try{
				aux.setTelefone(s);
			}catch (NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		s = request.getParameter("dataNasc");

		if (s != null && !s.isEmpty()) {
			try {
				aux.setDataNasc(sdf.parse(s));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		s = request.getParameter("renda");

		if (s != null && !s.isEmpty()) {
			try{
				aux.setRenda(new BigDecimal(s));
			} catch (NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		return aux;
	}
	
	public static ItemPedido itempedido(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		PedidoServico ps = new PedidoServico();
		PizzaServico pzs = new PizzaServico();
		
		ItemPedido aux = new ItemPedido();
		
		String s;
		
		s = request.getParameter("codItemPedido");

		if (s != null && !s.isEmpty()) {
			try{
				aux.setCodItemPedido(Integer.parseInt(s));
			}catch (NumberFormatException e){
				e.printStackTrace();
			}
		}		
		
		s = request.getParameter("quantidade");

		if (s != null && !s.isEmpty()) {
			aux.setQuantidade(Integer.parseInt(s));
		}

		s = request.getParameter("codPedido");

		if (s != null && !s.isEmpty()) {
			Pedido x = ps.buscar(Integer.parseInt(s));
			aux.setPedido(x);
		}
		
		s = request.getParameter("codPizza");

		if (s != null && !s.isEmpty()) {
			try{
				Pizza x = pzs.buscar(Integer.parseInt(s));
				aux.setPizza(x);
			} catch (NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		return aux;
	}
}
