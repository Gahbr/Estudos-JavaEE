<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title>Bem vindo!</title>
</head>
<body>
  <%--Comentário em JSP --%>
  <%
      String nome = "Gabriel Ribeiro";
      String mensagem = "Bem vindo ao sistema de agenda do FJ-21!";
      PrintWriter outs = response.getWriter();
      outs.println(mensagem);
  %>
  <br/>
  <%
      String desenvolvido = "Desenvolvido por " + nome;
  %>
  <%= desenvolvido %>
  <br/>
  <%
      System.out.println("Tudo foi executado!");
  %>
</body>
</html>
