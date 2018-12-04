<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Operação</title>
    </head>
    <body>
            <ul>
                <li><a href="cadastrar-conta.jsp">Cadastrar Conta</a></li>
                <li><a href="cadastrar-operacao.jsp">Cadastrar Operação</a></li>
                <li><a href="historico-operacao.jsp">Histórico de Operações</a></li>
            </ul>
        <h1>Cadastrar Operação</h1>
        <form action="CadastrarOperacao" method="post">
            Número da Conta: <input type="text" name="numero"><br>
            CPF do Responsavel: <input type="text" name="cpfResponsavel"><br> 
            Valor: <input type="text" name="valor"><br>
            Operação: <input type="radio" name="operacao" value="+" checked="checked">Crédito
                      <input type="radio" name="operacao" value="-">Débito
                      <br><input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
