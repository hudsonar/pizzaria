package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Pedido;
import servico.PedidoServico;

@WebServlet("/itempedido/pedidos")
public class ItemPedidoPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/itempedido/listar.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		PedidoServico ps = new PedidoServico();
		
//		int codigo = Integer.parseInt(request.getParameter("codCliente"));
				
//		List<Pedido> itens = ps.buscarPorCliente(codigo);
//		request.setAttribute("itens", itens);
//		request.getRequestDispatcher(DESTINO).forward(request, response);
		
		PedidoServico ps = new PedidoServico();
		List<Pedido> itens = ps.buscarTodos();
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
		
	}
}
