package br.insper.edu;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Lista")
public class Lista extends HttpServlet {
	
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	
		DAO dao;
		try {
			dao = new DAO();
		
		List<Pessoa> pessoas = dao.getLista();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border='1'>");
		out.println("<tr><td>Id</td><td>Nome</td><td>Idade</td></tr>");
		
		for (Pessoa pessoa : pessoas) {
			out.println("<tr><td>" + pessoa.getId() + "</td>");
			out.println("<td>" + pessoa.getNome() + "</td>");
			out.println("<td>" + pessoa.getIdade() + "</td></tr>");
		}
		
		out.println("</table></body></html>");
		dao.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
