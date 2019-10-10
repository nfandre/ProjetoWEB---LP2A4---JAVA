<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="lib/js/bootstrap.min.js"></script>
    <link href="lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="lib/css/bootstrap.css" rel="stylesheet" type="text/css">
     <link href="lib/css/padrao.css" rel="stylesheet" type="text/css">
  
  </head><body>
    <div class="section bgred text-justify ">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <h1 class="text-center">Sistema de Gerenciamento de Cursos <%=request.getAttribute("userLogado") %></h1>
          </div>
        </div>
      </div>
    </div>
    <%
     if(request.getAttribute("userLogado")==null){
    	 
     }else{
    	 
    	 
    	 
    	 %>
       <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <div class="col-md-12  btn-group btn-group-lg btn-group-vertical">
              <a href="clientes/index.html" class="btn btn-default">CLIENTES</a>
              <a href="cursos/index.jsp" class="btn btn-default">CURSOS</a>
              <a href="pagamentos/index.html" class="btn btn-default">PAGAMENTOS</a>
            </div>
          </div>
        </div>
      </div>
    </div> 	 
    	 
    	 
    	 <%
    	 
    	 
     }
    
    
    %>

    <footer>
      <div class="navbar navbar-fixed-bottom bgred">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 text-center" style="top:13px;color:#fff;">�nfandre - Andr� Nascimento de Freitas</div>
          </div>
        </div>
      </div>
    </footer>
  

</body></html>