<%@page import="Model.Curso"%>
<%@page import="java.util.List"%>
<%@page import="PersistJPA.CursoPersist"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="../lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/js/bootstrap.min.js"></script>
    <link href="../lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../lib/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="../lib/css/padrao.css" rel="stylesheet" type="text/css">
  </head><body>
    <div class="section bgred text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <h1 class="text-center">Sistema de Gerenciamento de Cursos</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <h3 class="tt_menu">&gt;&gt; CURSOS - CONSULTAR UM NOVO CURSO &lt;&lt;</h3>
          </div>
        </div>
     	<div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center corrigir">
            <a class="btn btn-default" href="javascript:window.history.go(-1)">Voltar</a>
          </div>
        </div>
      </div>
    </div>
	    <%
	    	CursoPersist cp = new CursoPersist();
	    	List<Curso> cursos = cp.findAll();
	    	for(Curso c:cursos){

	    	
	    %>
		   <div class="card mt-4">
		        <div class="card-body">
		            <h3><%=c.getCurso() %></h3>
		            <h5>Descricao: <%=c.getDescricao() %></h5>

		            <h5>Site: <%=c.getSite() %></h5>
		            <h5>Valor: <%=c.getValor() %></h5>
		        </div>
		    </div>
		    <a href="/admin/postagens/edit/{{_id}}"><button class="btn btn-info mt-4">Editar postagem</button></a>
            <a href="/admin/postagens/deletar/{{_id}}"><button class="btn btn-danger mt-4">Deletar postagem</button></a>
            <hr>
	    <%
		
		  }
	    
	    %>
	  </div>
	  </div>
    <footer>
      <div class="navbar navbar-bottom bgred">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 text-center" style="top:13px;color:#fff;">©nfandre - André Nascimento de Freitas</div>
          </div>
        </div>
      </div>
    </footer>

  

</body></html>