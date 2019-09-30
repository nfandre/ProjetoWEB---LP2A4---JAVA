<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="./lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./lib/js/Validar.js"></script>
    
    <link href="./lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="./lib/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="./lib/css/padrao.css" rel="stylesheet" type="text/css">
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
            <h3 class="tt_menu">&gt;&gt; CLIENTES - CONSULTAR UM NOVO CLIENTE &lt;&lt;</h3>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal" role="form" action="../ClienteCadastro" method="post">
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">Informar o CPF:</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" name="cpf" class="form-control" id="cpf" placeholder="cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" title="Digite um CPF no formato: xxx.xxx.xxx-xx" required="">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputNome" class="control-label">Informar o NOME:</label>
                </div>
                <div class="col-sm-10">
                  <input name="nome" type="text" class="form-control" id="inputNome" placeholder="Nome">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEMAIL" class="control-label">Informar o EMAIL:</label>
                </div>
                <div class="col-sm-10">
                  <input name="email"type="text" class="form-control" id="email" placeholder="E-mail">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" id="cadastrar" class="btn btn-info" onclick="validarCpfEmail()">Cadastrar</button>
                  <h2 id='result'></h2>
                  <h2 id="resultCpf"> </h2>
                </div>
              </div>
            </form>
          </div>
        </div>
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
    <footer>
      <div class="navbar navbar-fixed-bottom bgred">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 text-center" style="top:13px;color:#fff;">©nfandre - André Nascimento de Freitas</div>
          </div>
        </div>
      </div>
    </footer>
  

</body>
</html>