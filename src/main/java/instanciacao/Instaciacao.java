package instanciacao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import dominio.Ingrediente;
import dominio.ItemPedido;
import dominio.ItemPizza;
import dominio.Pedido;
import dominio.Pizza;
import servico.ClienteServico;
import servico.IngredienteServico;
import servico.ItemPedidoServico;
import servico.ItemPizzaServico;
import servico.PedidoServico;
import servico.PizzaServico;

@WebServlet("/Instanciacao")
public class Instaciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try{
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Cliente c1 = new Cliente(null, "Jose Humberto", "josej@hotmail.com", "001.001.001-01", "32000001", sdf.parse("01/01/2001"), new BigDecimal("300.00"));
			Cliente c2 = new Cliente(null, "Joao Pedro", "jp@hotmail.com", "002.002.002-02", "32000002", sdf.parse("02/02/2000"), new BigDecimal("550.00"));
			Cliente c3 = new Cliente(null, "Luiz Otavio", "otaviol@hotmail.com", "003.003.003-03", "32000003", sdf.parse("03/03/1995"), new BigDecimal("1110.00"));
			
			Ingrediente i1 = new Ingrediente(null, "Calabresa", new BigDecimal("7.00"));
			Ingrediente i2 = new Ingrediente(null, "Bacon", new BigDecimal("10.00"));
			Ingrediente i3 = new Ingrediente(null, "Mussarela", new BigDecimal("5.50"));
			Ingrediente i4 = new Ingrediente(null, "Presunto", new BigDecimal("9.90"));
			Ingrediente i5 = new Ingrediente(null, "Massa", new BigDecimal("12.90"));
			
			Pizza p1 = new Pizza(null, "Da casa");
			Pizza p2 = new Pizza(null, "Americana");
			Pizza p3 = new Pizza(null, "Italiana");
			
			ItemPizza ipz10 = new ItemPizza(null, p1, i5);
			ItemPizza ipz11 = new ItemPizza(null, p1, i1);
			ItemPizza ipz12 = new ItemPizza(null, p1, i2);
			ItemPizza ipz13 = new ItemPizza(null, p1, i3);
			ItemPizza ipz14 = new ItemPizza(null, p1, i4);
			ItemPizza ipz20 = new ItemPizza(null, p2, i5);
			ItemPizza ipz21 = new ItemPizza(null, p2, i2);
			ItemPizza ipz22 = new ItemPizza(null, p2, i3);
			ItemPizza ipz23 = new ItemPizza(null, p2, i4);
			ItemPizza ipz30 = new ItemPizza(null, p3, i5);
			ItemPizza ipz31 = new ItemPizza(null, p3, i1);
			ItemPizza ipz32 = new ItemPizza(null, p3, i3);
			
			Pedido pd1 = new Pedido(null, sdf.parse("09/03/2016"), c1);
			Pedido pd2 = new Pedido(null, sdf.parse("01/03/2016"), c1);
			Pedido pd3 = new Pedido(null, sdf.parse("05/03/2016"), c2);
			Pedido pd4 = new Pedido(null, sdf.parse("03/03/2016"), c3);
			Pedido pd5 = new Pedido(null, sdf.parse("04/03/2016"), c2);
			
			ItemPedido ipd10 = new ItemPedido(null, 2, pd1, p1);
			ItemPedido ipd11 = new ItemPedido(null, 1, pd1, p3);
			ItemPedido ipd20 = new ItemPedido(null, 1, pd2, p1);
			ItemPedido ipd21 = new ItemPedido(null, 5, pd2, p2);
			ItemPedido ipd30 = new ItemPedido(null, 2, pd3, p2);
			ItemPedido ipd31 = new ItemPedido(null, 3, pd3, p3);
			ItemPedido ipd40 = new ItemPedido(null, 1, pd4, p2);
			ItemPedido ipd41 = new ItemPedido(null, 1, pd4, p3);
			ItemPedido ipd50 = new ItemPedido(null, 1, pd5, p1);
			ItemPedido ipd51 = new ItemPedido(null, 1, pd5, p2);
			
			ClienteServico cs = new ClienteServico();
			PedidoServico ps = new PedidoServico();
			ItemPedidoServico ipds = new ItemPedidoServico();
			PizzaServico pzs = new PizzaServico();
			ItemPizzaServico ipzs = new ItemPizzaServico();
			IngredienteServico is = new IngredienteServico();
			
			cs.inserirAtualizar(c1);
			cs.inserirAtualizar(c2);
			cs.inserirAtualizar(c3);
			
			is.inserirAtualizar(i1);
			is.inserirAtualizar(i2);
			is.inserirAtualizar(i3);
			is.inserirAtualizar(i4);
			is.inserirAtualizar(i5);
			
			pzs.inserirAtualizar(p1);
			pzs.inserirAtualizar(p2);
			pzs.inserirAtualizar(p3);
			
			ipzs.inserirAtualizar(ipz10);
			ipzs.inserirAtualizar(ipz11);
			ipzs.inserirAtualizar(ipz12);
			ipzs.inserirAtualizar(ipz13);
			ipzs.inserirAtualizar(ipz14);
			ipzs.inserirAtualizar(ipz20);
			ipzs.inserirAtualizar(ipz21);
			ipzs.inserirAtualizar(ipz22);
			ipzs.inserirAtualizar(ipz23);
			ipzs.inserirAtualizar(ipz30);
			ipzs.inserirAtualizar(ipz31);
			ipzs.inserirAtualizar(ipz32);
			
			ps.inserirAtualizar(pd1);
			ps.inserirAtualizar(pd2);
			ps.inserirAtualizar(pd3);
			ps.inserirAtualizar(pd4);
			ps.inserirAtualizar(pd5);
			
			ipds.inserirAtualizar(ipd10);
			ipds.inserirAtualizar(ipd11);
			ipds.inserirAtualizar(ipd20);
			ipds.inserirAtualizar(ipd21);
			ipds.inserirAtualizar(ipd30);
			ipds.inserirAtualizar(ipd31);
			ipds.inserirAtualizar(ipd40);
			ipds.inserirAtualizar(ipd41);
			ipds.inserirAtualizar(ipd50);
			ipds.inserirAtualizar(ipd51);
			
			
			response.getWriter().append("Pronto");
			
		}catch(ParseException e){
			response.getWriter().append("Erro ao instanciar data, verifique!");
		}		
	}

}