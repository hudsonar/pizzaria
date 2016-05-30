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
import servico.PedidoServico;
import servico.PizzaServico;

@WebServlet("/itempedido/novo")
public class ItemPedidoNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/itempedido/formInserir.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PedidoServico ps = new PedidoServico();
		PizzaServico pzs = new PizzaServico();
		
		int cod = Integer.parseInt(request.getParameter("codPedido"));
		Pedido pedido = ps.buscar(cod);
		
		ItemPedido ip = new ItemPedido();
		ip.setPedido(pedido);
		
		List<Pizza> pizzas = pzs.buscarTodos();
		
		request.setAttribute("item", ip);
		request.setAttribute("pizzas", pizzas);
		request.getRequestDispatcher(DESTINO).forward(request, response);
		
	}
}
