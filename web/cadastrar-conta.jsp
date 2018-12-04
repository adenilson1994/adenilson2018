<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Conta</title>
    </head>
    <body>
            <ul>
                <li><a href="cadastrar-conta.jsp">Cadastrar Conta</a></li>
                <li><a href="cadastrar-operacao.jsp">Cadastrar Operação</a></li>
                <li><a href="historico-operacao.jsp">Histórico de Operações</a></li>
            </ul>
        <h1>Cadastrar Conta</h1>
        <form action="CadastrarConta" method="post">
            Número da Conta: <input type="text" name="numero"><br>
            CPF do Titular:  <input type="text" name="cpfTitular"><br> 
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
