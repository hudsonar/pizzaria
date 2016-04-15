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
import servico.ClienteServico;
import servico.ItemPedidoServico;
import servico.PedidoServico;
import servico.PizzaServico;

@WebServlet("/ServletTeste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		ClienteServico cs = new ClienteServico();
		PedidoServico ps = new PedidoServico();
		ItemPedidoServico is = new ItemPedidoServico();
		PizzaServico pzs = new PizzaServico();
		
/*		
		//Tentando inserir um cliente com nome  repetido:
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Cliente c1 = null;
		try {
			c1 = new Cliente(null, "Jose Humberto", "josej@hotmail.com", "00100100101", "32000001", sdf.parse("01/01/2001"), new BigDecimal("300.00"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			cs.inserir(c1);
			response.getWriter().append("Jose Humberto inserido!");
		}
		catch(ServicoException e){
			response.getWriter().append(e.getMessage());
		}

		
		//Tentando atualizar um cliente
		Cliente c1 = cs.buscar(1);
		try{
			c1.setRenda(c1.getRenda().add(new BigDecimal("10.00")));
			cs.atualizar(c1);
			response.getWriter().append("Renda atualizada!");
		}
		catch(ServicoException e){
			response.getWriter().append(e.getMessage());
		}

		
		//Tentando atualizar cliente
		Cliente c1 = cs.buscar(1);
		try{
			c1.setCpf("00200200202");
			cs.atualizar(c1);
			response.getWriter().append("Cliente atualizado!");
		}
		catch(ServicoException e){
			response.getWriter().append(e.getMessage());
		}

		
		//Tentando inserir um Item pedido nao repetido
		Pizza pz1 = pzs.buscar(1);
		Pedido p1 = ps.buscar(3);
		ItemPedido ip = new ItemPedido(null, 1, p1, pz1);
		try{
			is.inserir(ip);
			response.getWriter().append("Item Pedido inserido");
		}
		catch(ServicoException e){
			response.getWriter().append(e.getMessage());
		}

		
		//Tentando inserir um Item pedido repetido
		Pizza pz1 = pzs.buscar(1);
		Pedido p1 = ps.buscar(3);
		ItemPedido ip = new ItemPedido(null, 1, p1, pz1);
		try{
			is.inserir(ip);
			response.getWriter().append("Item Pedido inserido");
		}
		catch(ServicoException e){
			response.getWriter().append(e.getMessage());
		}

		
		//Realizando a consulta
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			List<Pedido> lista = ps.buscarPorData(sdf.parse("01/03/2016"), sdf.parse("03/03/2016"));
			for(Pedido x : lista){
				response.getWriter().append(x+"\n");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
		
		
	}
}
