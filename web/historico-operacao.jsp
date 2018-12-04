<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Histórico de Operações</title>
    </head>
    <body>
            <ul>
                <li><a href="cadastrar-conta.jsp">Cadastrar Conta</a></li>
                <li><a href="cadastrar-operacao.jsp">Cadastrar Operação</a></li>
                <li><a href="historico-operacao.jsp">Histórico de Operações</a></li>
            </ul>
        <h1>Historico de Operações</h1>
        <form action="HistoricoOperacao" method="post">
            Número da Conta: <input type="text" name="numero">
            <input type="submit" value="Visualizar">
        </form>
    </body>
</html>
