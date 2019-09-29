package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
