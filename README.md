<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
</head>
<body>
    <h1>Criação de um Servlet de Calculadora</h1>
    <ol>
        <li><strong>Nome do Servlet:</strong> FPBE-Aula1</li>
        <li><strong>Tipo de Requisição:</strong> GET</li>
        <li><strong>Função:</strong> Realizar operações matemáticas com base nos parâmetros recebidos.</li>
        <li><strong>Método:</strong> doGet</li>
        <li><strong>Parâmetros:</strong>
            <ul>
                <li><code>num1</code> e <code>num2</code>: Números para a operação.</li>
                <li><code>operacao</code>: Tipo de operação (soma, subtracao, multiplicacao, divisao).</li>
            </ul>
        </li>
        <li><strong>Validação:</strong>
            <ul>
                <li>Certifique-se de que <code>num1</code> e <code>num2</code> são numéricos.</li>
                <li>Use <code>request.getParameter()</code> para obter os valores dos parâmetros.</li>
            </ul>
        </li>
        <li><strong>Testar o Servlet:</strong>
            <ul>
                <li><strong>Ferramenta:</strong> Use o Postman ou um navegador.</li>
                <li><strong>Verificação:</strong> Confirme se as respostas para as operações estão corretas.</li>
            </ul>
        </li>
    </ol>
</body>
</html>
