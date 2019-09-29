package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cliente;

/**
 * Servlet implementation class ClienteCadastro
 */
@WebServlet("/ClienteCadastro")
public class ClienteCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteCadastro() {
        super();
        
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cliente c = new Cliente();
		
		c.setCpf(request.getParameter("cpf"));
		c.setEmail(request.getParameter("email"));
		c.setNome(request.getParameter("nome"));

		
		out.print("<h5> Dados a serem Cadastrados: <h5> ");
		out.print("<p> CPF: " + c.getCpf());
		out.print("<br>Nome: " + c.getNome());
		out.print("<br>Email: " + c.getEmail());
		out.flush();
		out.close();
	}

}
