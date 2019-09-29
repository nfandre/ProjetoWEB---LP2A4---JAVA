<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <script type="text/javascript" src="lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="lib/js/bootstrap.min.js"></script>
    <link href="lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="lib/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="lib/css/padrao.css" rel="stylesheet" type="text/css">
    <link href="lib/css/login.css" rel="stylesheet" type="text/css">
    <title>CriarConta</title>
</head>
<body>
        <div class="fundo">
                <div class="caixa">
                        <div class="d-flex p-2 bd-highlight"></div>

                            <div class="d-flex justify-content-center col-sm-9 col-md-9 col-lg-9" align="center">



                                <form class="form-horizontal" role="form" action="./UsuarioControlador?rota=cadastrado" method="post">
                                    <br>
                                    <h3 style="color: white">Criar conta: </h3>
                                    <label for="inputEmail3" class="control-label">CPF:</label> 
                                    <input class="form-control" type="text" name="cpf"  id="cpf" placeholder="cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" title="Digite um CPF no formato: xxx.xxx.xxx-xx" required=""class="form-control">
                                    <label for="inputNome" class="control-label">NOME:</label>
                                    <input name="nome" type="text" class="form-control" id="inputNome" placeholder="Nome" class="form-control">
                                    



                                    <label for="inputEMAIL" class="control-label">EMAIL:</label>
                                    <input name="email"type="text" class="form-control" id="email" placeholder="E-mail" class="form-control">


                                    <label for="inputEMAIL" class="control-label">Senha:</label>
                                    <input name="senha"type="password" class="form-control" id="senha" placeholder="senha" class="form-control">
                                    <label for="inputEMAIL" class="control-label">Confirmar senha:</label>
                                    <input name="senhaC"type="password" class="form-control" id="senhaC" placeholder="Confirmar senha" class="form-control">
                                    <br>
                                    <button type="submit" id="cadastrar" class="btn btn-info mt-9" onclick="validarCpfEmail()">Cadastrar</button>
                                    
                                    
                                    <a href="login.jsp"><p >Entrar</p></a>

                                    <h2 id='result'></h2>
                                    <h2 id="resultCpf"> </h2>

                                </form>
                            </div>        
                       
                     </div>
                </div>
        </div>





</body>
</html>