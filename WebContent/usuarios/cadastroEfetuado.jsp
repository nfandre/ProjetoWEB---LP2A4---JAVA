<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <script type="text/javascript" src="./lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/js/bootstrap.min.js"></script>
    <link href="./lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="./lib/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="./lib/css/padrao.css" rel="stylesheet" type="text/css">
    <link href="./lib/css/login.css" rel="stylesheet" type="text/css">
    <title>Conta criada</title>
</head>
<body>
        <div class="fundo">
                <div class="caixa">
                        <div class="d-flex p-2 bd-highlight">

                            <div class="d-flex justify-content-center col-sm-9 col-md-9 col-lg-9" align="center">

								<%
								String redirect=null;
								
								String resultado=request.getParameter("cpf");
								String retorno = null;

							    retorno = ""+ request.getAttribute("retorno");
								String mensagem = null;
								String botao = null;
								if(retorno.trim().equals("inserido")==true){
									
									mensagem = "Conta criada :)";
									botao = "Entrar";
									redirect ="./login.jsp";

									
								}else
									if(retorno.trim().equals("JaCadastrado") ==true){
										mensagem = "Usuario ja cadastrado no nosso sistema";
										botao = "Tente novamente";
										redirect ="./loginCadastro.jsp";

								}else{
									mensagem = "Ocorreu um erro durante o cadastro :(";
									botao = "Tente novamente";
									redirect ="./loginCadastro.jsp";
								}

								
								%>

                                <form class="form-horizontal" role="form" action="<%=redirect%>" method="post">
                                    <br>
                                    <h3 style="color: white"><%=mensagem %>  </h3>

                                    <br>
                                    <button type="submit" id="cadastrar" class="btn btn-info mt-9" onclick="validarCpfEmail()"><%=botao%></button>
                                    
                                    

                                    <h2 id='result'></h2>
                                    <h2 id="resultCpf"> </h2>

                                </form>
                            </div>        
                       
                     </div>
                </div>
                
       </div>
        


</body>
</html>