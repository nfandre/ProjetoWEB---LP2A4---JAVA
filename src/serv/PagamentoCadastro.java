package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Pagamento;


/**
 * Servlet implementation class PagamentoCadastro
 */
@WebServlet("/PagamentoCadastro")
public class PagamentoCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagamentoCadastro() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Pagamento p = new Pagamento();
		p.setCpf(request.getParameter("cpf"));
		p.setCurso(request.getParameter("curso"));
		p.setDtaInscricao(request.getParameter("dtaInscricao"));


		
		out.print("<h5> Dados a serem Cadastrados: <h5> ");
		out.print("<p> CPF: " + p.getCpf());
		out.print("<br>Curso: " + p.getCurso());
		out.print("<br>Data Inscricção: " + p.getDtaInscricao());
		out.flush();
		out.close();
	}

}
