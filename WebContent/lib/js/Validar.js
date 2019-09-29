    function validateEmailAddress(email) {
    	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    	return re.test(email);
    }

    function validate() {
    	$("#result").text("");
    	var emailaddress = $("#email").val();
    	if (validateEmailAddress(emailaddress)) {
    	$("#result").text(emailaddress + " é valido :)");
    	$("#result").css("color", "green");
    	} else {
    	$("#result").text("O email '"+ emailaddress + "' não está correto, tente novamente:(");
    	$("#result").css("color", "red");
    	}
    	return false;
    	}
    function TestaCPF(strCPF) {
        var Soma;
        var Resto;
        Soma = 0;
      if (strCPF == "00000000000") return false;
         
      for (i=1; i<=9; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i);
      Resto = (Soma * 10) % 11;
       
        if ((Resto == 10) || (Resto == 11))  Resto = 0;
        if (Resto != parseInt(strCPF.substring(9, 10)) ) return false;
       
      Soma = 0;
        for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i);
        Resto = (Soma * 10) % 11;
       
        if ((Resto == 10) || (Resto == 11))  Resto = 0;
        if (Resto != parseInt(strCPF.substring(10, 11) ) ) return false;
        return true;
    }

    function exibirResultadoCpf(){
    	var cpf = document.getElementById("cpf").value;
    	var resultado = TestaCPF(cpf);
    	if(resultado == true){
        	$("#resultCpf").text("O cpf '"+ cpf + "' está correto :)");
        	$("#resultCpf").css("color", "green");
    	}else{
        	$("#resultCpf").text("O cpf '"+ cpf + "' não está correto, tente novamente :(");
        	$("#resultCpf").css("color", "red");
    	}
    }
    function validarCpfEmail(){
    	validate()
    	exibirResultadoCpf()
    }

