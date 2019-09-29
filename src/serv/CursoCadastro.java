package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Curso;

/**
 * Servlet implementation class CursoCadastro
 */
@WebServlet("/CursoCadastro")
public class CursoCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CursoCadastro() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Curso c = new Curso();

		c.setNome(request.getParameter("nome"));
		c.setSite(request.getParameter("site"));
		c.setValor(request.getParameter("valor"));
		
		out.print("<h5> Dados a serem Cadastrados: <h5> ");
		out.print("<br>Nome: " + c.getNome());
		out.print("<br>Valor: " + c.getValor());
		out.print("<br>Site:" + c.getSite());
		out.flush();
		out.close();
	}

}
