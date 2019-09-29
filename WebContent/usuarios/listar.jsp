<%@page import="java.util.Iterator"%>
<%@page import="Model.Usuario"%>
<%@page import=" java.util.List"%>
<%@page import="Persist.UsuarioPersist"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios do sistemas</title>
</head>
<body>
 <%
 
 	UsuarioPersist up = new UsuarioPersist();
 	List<Usuario> usuarios = up.listar();
 	Iterator<Usuario> iter = usuarios.iterator();
 	Usuario u = null;
 	while(iter.hasNext()){
 		u = iter.next();
 		
 	
 	
 %>
</body>
<p> 
	<%=u.getCpf() , u.getId(), u.getEmail() %>
</p>

	<%} %>
</html>