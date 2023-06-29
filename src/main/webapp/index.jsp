<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/cabecalho.jsp"/>
<h1><%= "Naruto kun!" %>
</h1>
<br/>
<%--<a href="WEB-INF/jsp/adiciona-contato.jsp">Adicionar contato</a> <br> --%>
<a href="adicionaContato">Adicionar contato</a> <br>
<a href="mvc?logica=ListaContatosLogica">Listar contatos</a>
</body>
</html>