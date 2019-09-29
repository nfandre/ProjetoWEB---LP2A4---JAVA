package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cliente;
import Model.Usuario;
import Persist.UsuarioPersist;

/**
 * Servlet implementation class usuarioCadastro
 */
@WebServlet("/usuarioCadastro")
public class usuarioCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usuarioCadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Usuario c = new Usuario();
		
		c.setCpf(request.getParameter("cpf"));
		c.setEmail(request.getParameter("email"));
		c.setNome(request.getParameter("nome"));
		c.setSenha(request.getParameter("senha"));
		
		
		UsuarioPersist up = new UsuarioPersist();
		

		String result = "" +Integer.parseInt(up.inserir(c));
		
		out.print("<h5> Dados a serem Cadastrados: <h5> ");
		out.print("<p> Usuario cadastrado id: " + result);

		out.flush();
		out.close();
	}

}
