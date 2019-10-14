package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Usuario;
import PersistJPA.UsuarioPersist;


@WebServlet("/UsuarioControlador")
public class UsuarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String listar="usuarios/listar.jsp";
    String add="usuarios/adicionar.jsp";
    String edit="usuarios/editar.jsp";
    String cadastrado = "usuarios/cadastroEfetuado.jsp";
    String logado = "index.jsp";
    public UsuarioControlador() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String acesso="";
		String rota=request.getParameter("rota");
		if(rota.equalsIgnoreCase("listar")) {
			acesso=listar;
		}
		RequestDispatcher usuariosViews = request.getRequestDispatcher(acesso);
		usuariosViews.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acesso="";
		String rota=request.getParameter("rota");
		String retorno=null;
		UsuarioPersist up = new UsuarioPersist();
		//Tela de cadastro
		if(rota.equalsIgnoreCase("cadastrado")) {
			acesso=cadastrado;
			
			Usuario u = new Usuario();

			u.setCpf(request.getParameter("cpf"));
			u.setEmail(request.getParameter("email"));
			u.setNome(request.getParameter("nome"));
			u.setSenha(request.getParameter("senha"));
			if(up.VerificarSeUsuarioExiste(u)==null) {
			   up.save(u);
			   retorno = "inserido";
			}else {
				retorno = "JaCadastrado";
			}
		}
		//tela de login
		if(rota.equalsIgnoreCase("logado")) {
			String email = request.getParameter("email");
			if(up.verificarEmailExiste(email)==null) {
				retorno = "email";
				acesso=cadastrado;
			}else {
				String senha = request.getParameter("senha");
				Usuario userLogado = up.verificarEmailExiste(email);

				if(up.verificarSenhaEstaCorreta(userLogado,senha)==true) {
					
					request.setAttribute("userLogado", userLogado);
				}else {
					retorno = "senha";
					acesso=cadastrado;

				}
			}
		}
		request.setAttribute("retorno", retorno);
		RequestDispatcher usuariosViews = request.getRequestDispatcher(acesso);
		usuariosViews.forward(request, response);
		
	}

}
