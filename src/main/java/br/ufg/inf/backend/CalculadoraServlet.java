package br.ufg.inf.backend;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String operacao = req.getParameter("operacao");

        resp.setContentType("text/plain");

        try {
            double numero1 = Double.parseDouble(num1);
            double numero2 = Double.parseDouble(num2);

            String mensagem = "Operação informada é invalida: " + operacao; 
            double resultado;
            switch (operacao) {
                case "soma": 
                    resultado = numero1 + numero2;
                    mensagem = formataRetorno(resultado);
                    break;
                case "subtracao": 
                    resultado = numero1 - numero2;
                    mensagem = formataRetorno(resultado);
                    break;
                case "divisao":
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                        mensagem = formataRetorno(resultado);
                    } else {
                        mensagem = "Erro: Divisão por zero.";
                    }
                    break;
                case "multiplicacao":
                    resultado = numero1 * numero2;
                    mensagem = formataRetorno(resultado);
                    break;
                default:
                    break;
            }

            resp.getWriter().print(mensagem);

        } catch (NullPointerException | NumberFormatException e) {
            resp.getWriter().print("Informe valores válidos para os parâmetros num1, num2 e operacao.");
        }
    }

    private String formataRetorno(double resultado) {
        return "Resultado da Operação: " + resultado;
    }
}
