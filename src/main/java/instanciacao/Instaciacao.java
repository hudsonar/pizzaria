package instanciacao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			em.persist(c1);
			em.persist(c2);
			em.persist(c3);
			em.persist(i1);
			em.persist(i2);
			em.persist(i3);
			em.persist(i4);
			em.persist(i5);
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.persist(ipz10);
			em.persist(ipz11);
			em.persist(ipz12);
			em.persist(ipz13);
			em.persist(ipz14);
			em.persist(ipz20);
			em.persist(ipz21);
			em.persist(ipz22);
			em.persist(ipz23);
			em.persist(ipz30);
			em.persist(ipz31);
			em.persist(ipz32);
			em.persist(pd1);
			em.persist(pd2);
			em.persist(pd3);
			em.persist(pd4);
			em.persist(pd5);
			em.persist(ipd10);
			em.persist(ipd11);
			em.persist(ipd20);
			em.persist(ipd21);
			em.persist(ipd30);
			em.persist(ipd31);
			em.persist(ipd40);
			em.persist(ipd41);
			em.persist(ipd50);
			em.persist(ipd51);
			
			
			
			em.getTransaction().commit();
			em.close();
			emf.close();
			
			response.getWriter().append("Pronto");
			
		}catch(ParseException e){
			response.getWriter().append("Erro ao instanciar data, verifique!");
		}		
	}

}