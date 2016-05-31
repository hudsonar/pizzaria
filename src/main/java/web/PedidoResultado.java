package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Pedido;
import servico.PedidoServico;

@WebServlet("/pedido/resultado")
public class PedidoResultado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/pedido/resultadoBusca.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		PedidoServico ps = new PedidoServico();
		
		String dataMin = request.getParameter("dataMin");
		char[] dataMinChar = dataMin.toCharArray();
		dataMinChar[4] = '/';
		dataMinChar[7] = '/';
		dataMin = String.valueOf(dataMinChar);
		
		String dataMax = request.getParameter("dataMax");
		char[] dataMaxChar = dataMax.toCharArray();
		dataMaxChar[4] = '/';
		dataMaxChar[7] = '/';
		dataMax = String.valueOf(dataMaxChar);
						
		try {	
			List<Pedido> itens;
			itens = ps.buscarPorData(sdf.parse(dataMin), sdf.parse(dataMax));
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
