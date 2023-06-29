<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../css/lista-contatos.css">
</head>
<body>
<c:import url="cabecalho.jsp"/>

    <form action="mvc?logica=AdicionaContatoLogica" method="POST">
        Nome: <input type="text" name="nome" /><br />
        E-mail: <input type="text" name="email" /><br />
        Endereço: <input type="text" name="endereco" /><br />
        Data Nascimento: <input type="date" name="dataNascimento" /><br />
        <input type="submit" value="Gravar" />
    </form>
<c:import url="rodape.jsp"/>
</body>
</html>