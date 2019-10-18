package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Curso;
import PersistJPA.CursoPersist;

/**
 * Servlet implementation class CursoControlador
 */
@WebServlet("/CursoControlador")
public class CursoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String listar="cursos/alteracao.jsp";
    String add="cursos/index.jsp";
    String edit="cursos/alteracao.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CursoControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acesso="";
		String rota=request.getParameter("rota");
		if(rota.equalsIgnoreCase("edit")) {
			acesso = edit;
			String rotaId= request.getParameter("i");
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+rotaId);
		        CursoPersist cp = new CursoPersist();
				Curso c = cp.findById(Integer.parseInt(rotaId));
			
			request.setAttribute("curso", c);
			RequestDispatcher cursoViews = request.getRequestDispatcher(acesso);
			cursoViews.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acesso="";
		String rota=request.getParameter("rota");
		CursoPersist cp = new CursoPersist();
		if(rota.equalsIgnoreCase("add")) {
			acesso= add;
			
			Curso c = new Curso();
			if(request.getAttribute("curso")!=null) {
			    c = (Curso) request.getAttribute("curso");
			}
			
			c.setCurso(request.getParameter("curso"));
			c.setDescricao(request.getParameter("descricao"));
			c.setSite(request.getParameter("site"));
			c.setValor(request.getParameter("valor"));
			cp.save(c);
			
			RequestDispatcher cursoViews = request.getRequestDispatcher(acesso);
			cursoViews.forward(request, response);
		}

	}

}
