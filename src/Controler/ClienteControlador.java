package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cliente;
import Model.Curso;
import PersistJPA.ClientePersist;
import PersistJPA.CursoPersist;

/**
 * Servlet implementation class ClienteControlador
 */
@WebServlet("/ClienteControlador")
public class ClienteControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String listar="clientes/consulta.jsp";
    String add="clientes/cadastro.jsp";
    String edit="clientes/alteracao.jsp";  

    public ClienteControlador() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acesso="";
		String rota=request.getParameter("rota");
		if(rota.equalsIgnoreCase("listar")) {
			acesso=listar;
		}
		if(rota.equalsIgnoreCase("add")) {
			acesso=add;
		}
		if(rota.equalsIgnoreCase("alterar")) {
			acesso=edit;
		}
		RequestDispatcher usuariosViews = request.getRequestDispatcher(acesso);
		usuariosViews.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acesso="";
		String rota=request.getParameter("rota");
		ClientePersist cp = new ClientePersist();
		if(rota.equalsIgnoreCase("add")) {
			acesso= add;
			
			Cliente c = new Cliente();
			if(request.getAttribute("cliente")!=null) {
			    c = (Cliente) request.getAttribute("cliente");
			}
			
			c.setCpf(request.getParameter("cpf"));
			Curso curso = new Curso();
		  //   int idCurso = (Curso) request.getParameter("curso");
			c.setNome(request.getParameter("nome"));
		//	c.setCurso();
			cp.save(c);
			
			RequestDispatcher cursoViews = request.getRequestDispatcher(acesso);
			cursoViews.forward(request, response);
		}
	}

}
