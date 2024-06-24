package br.ufg.inf.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/task")
public class TaskServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private List<String> tasks = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = 1;
        for (String task : tasks) {
            resp.getWriter().println("Tarefa " + i + ": " + task);
            i++;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String task = req.getParameter("task");
        tasks.add(task);
        resp.getWriter().println("Tarefa \"" + task + "\" salva com sucesso");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indexString = req.getParameter("index");
        String newTask = req.getParameter("task");
        
        try {
            int index = Integer.parseInt(indexString);
            if (index >= 0 && index < tasks.size()) {
                tasks.set(index, newTask);
                resp.getWriter().println("Tarefa " + (index + 1) + " atualizada com sucesso para: " + newTask);
            } else {
                resp.getWriter().println("Índice fora de alcance");
            }
        } catch (NumberFormatException e) {
            resp.getWriter().println("Índice inválido");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indexString = req.getParameter("index");
        
        try {
            int index = Integer.parseInt(indexString);
            if (index >= 0 && index < tasks.size()) {
                String removedTask = tasks.remove(index);
                resp.getWriter().println("Tarefa " + (index + 1) + " (" + removedTask + ") removida com sucesso");
            } else {
                resp.getWriter().println("Índice fora de alcance");
            }
        } catch (NumberFormatException e) {
            resp.getWriter().println("Índice inválido");
        }
    }
}
