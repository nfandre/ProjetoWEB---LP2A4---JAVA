package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Usuario;
import Persist.UsuarioPersist;


@WebServlet("/UsuarioControlador")
public class UsuarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String listar="usuarios/listar.jsp";
    String add="usuarios/adicionar.jsp";
    String edit="usuarios/editar.jsp";
    String cadastrado = "usuarios/cadastroEfetuado.jsp";
    String logado = "index.html";
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
		if(rota.equalsIgnoreCase("cadastrado")) {
			acesso=cadastrado;
			
			Usuario c = new Usuario();

			c.setCpf(request.getParameter("cpf"));
			c.setEmail(request.getParameter("email"));
			c.setNome(request.getParameter("nome"));
			c.setSenha(request.getParameter("senha"));
			
			if(up.VerificarSeUsuarioExiste(c)==null) {
			   up.inserir(c);
			   retorno = "inserido";
			}else {
				retorno = "JaCadastrado";
			}
		}
		if(rota.equalsIgnoreCase("logado")) {
			String email = request.getParameter("email");
			if(up.verificarEmailExiste(email)==null) {
				retorno = "email não cadastrado";
			}else {
				Usuario userLogado = new Usuario();
				if(up.verificarSenhaEstaCorreta(userLogado)==true) {
					request.setAttribute("userLogado", userLogado);
				}else {
					retorno = "A senha está inválida";
					logado = "erro";
				}
			}
		}
		request.setAttribute("retorno", retorno);
		RequestDispatcher usuariosViews = request.getRequestDispatcher(acesso);
		usuariosViews.forward(request, response);
		
	}

}
