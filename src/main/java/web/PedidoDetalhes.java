package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Pedido;
import servico.PedidoServico;

@WebServlet("/pedido/detalhes")
public class PedidoDetalhes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/pedido/detalhes.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PedidoServico ps = new PedidoServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Pedido pedido = ps.buscar(cod);
		request.setAttribute("item", pedido);
		request.getRequestDispatcher(DESTINO).forward(request, response);		
	}
}
