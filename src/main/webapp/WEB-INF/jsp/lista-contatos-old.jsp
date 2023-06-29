<%@ page import="com.example.model.Contato" %>
<%@ page import="com.example.model.ContatoDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="dao" class="com.example.model.ContatoDAO"/>

<html>
<head>
    <title>Lista de contatos</title>
    <link rel="stylesheet" type="text/css" href="../../css/lista-contatos.css">

</head>
<body>
<c:import url="cabecalho.jsp"/>
<%
    List<Contato> contatos = dao.getLista();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>
<table>
    <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Endereço</th>
        <th>Data de Nascimento</th>
    </tr>
    <% for (Contato contato : contatos) {
        String formattedDate = dateFormat.format(contato.getDataNascimento().getTimeInMillis());
    %>
    <tr>
        <td><%=contato.getNome()%></td>
        <td><%=contato.getEmail()%></td>
        <td><%=contato.getEndereco()%></td>
        <td><%=formattedDate%></td>
    </tr>
    <% } %>
</table>
<hr>
<h2> Tabela utilizando JSTL</h2>
<table>
    <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Endereço</th>
        <th>Data de Nascimento</th>
    </tr>
    <c:forEach var="contato" items="${dao.lista}">
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
