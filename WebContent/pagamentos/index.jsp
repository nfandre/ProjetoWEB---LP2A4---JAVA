<%@page import="Model.Pagamento"%>
<%@page import="PersistJPA.PagamentoPersist"%>
<%@page import="Model.Curso"%>
<%@page import="java.util.List"%>
<%@page import="PersistJPA.CursoPersist"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
            <h3 class="tt_menu">&gt;&gt; CURSOS &lt;&lt;</h3>
            <div class="col-md-12  btn-group btn-group-lg btn-group-vertical">
              <a href="consulta.html" class="btn btn-outline-primary">Consultar um Pagamento Específico</a>
              <a href="cadastro.html" class="btn btn-default">Cadastrar um Novo Pagamento</a>
            </div>
          </div>
        </div>
      </div>
    </div>
             <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center corrigir">
          <!--javascript:window.history.go(-1)   -->
            <a class="btn btn-info" href="javascript:window.history.go(-1)">Voltar</a>
          </div>
        </div>
      </div>
    </div>
    
 	<div class="container">



 	 <div class="row justify-content-center">
 	      <%
	    	PagamentoPersist pp = new PagamentoPersist();
 	      
	    	List<Pagamento> pagamentos = pp.findAll();
	    
	    	for(Pagamento p:pagamentos){


	    %>
		   <div class="card mt-4">
		        <div class="card-body">
		            <h3><%=p.getCpf() %></h3>
		            <h5>Curso : <%=p.getCurso() %></h5>

		            <h5>Data Inscrição: <%=p.getDtaInscricao() %></h5>

		        </div>
		    </div>
				
		      <a href="../CursoControlador?rota=edit&i=<%=p.getId()%>"><button class="btn btn-info mt-4" onclick="">Editar Pagamento</button></a>
            <a href="alteracao.jsp"><button class="btn btn-danger mt-4">Deletar Pagamento</button></a>
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