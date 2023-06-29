<%@ page import="com.example.model.Contato" %>
<%@ page import="com.example.model.ContatoDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Lista de contatos</title>
    <c:url var="rootPath" value="/" />
    <link rel="stylesheet" type="text/css" href="${rootPath}/css/lista-contatos.css">

</head>
<body>
<c:import url="cabecalho.jsp"/>

<h2> Lista de contatos </h2>
<table>
    <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Endereço</th>
        <th>Data de Nascimento</th>
    </tr>
    <c:forEach var="contato" items="${contatos}">
        <tr>
            <td>${contato.nome}</td>
            <td>
                <c:choose>
                    <c:when test="${not empty contato.email}">
                        <a href="mailto:${contato.email}">${contato.email}</a>
                    </c:when>
                    <c:otherwise>
                        E-mail não informado
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${contato.endereco}</td>
            <td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
            <td> <a href="mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a> </td>
        </tr>
    </c:forEach>
</table>
<c:import url="rodape.jsp"/>
</body>
</html>
