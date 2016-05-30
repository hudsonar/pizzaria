package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.ItemPedido;
import dominio.Pedido;
import dominio.Pizza;
import servico.ItemPedidoServico;
import servico.PedidoServico;
import servico.PizzaServico;
import servico.ServicoException;
import servico.ValidacaoException;

@WebServlet("/itempedido/inserir")
public class ItemPedidoInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/pedido/detalhesCompleto.jsp";
	private static String FORM = "/itempedido/formInserir.jsp";
	private static String ERRO = "/publico/erro.jsp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PedidoServico ps = new PedidoServico();
		PizzaServico pzs = new PizzaServico();
		ItemPedidoServico is = new ItemPedidoServico();
		
		ItemPedido x = Instanciar.itempedido(request);
		try {
			is.validar(x);
			is.inserir(x);
			Pedido pedido = ps.buscar(x.getPedido().getCodPedido());
			request.setAttribute("item", pedido);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		} catch (ValidacaoException e) {
			List<Pizza> pizzas = pzs.buscarTodos();
			request.setAttribute("erros", e.getErros());
			request.setAttribute("item", x);
			request.setAttribute("pizzas", pizzas);
			request.getRequestDispatcher(FORM).forward(request, response);
		}
				
	}
}
