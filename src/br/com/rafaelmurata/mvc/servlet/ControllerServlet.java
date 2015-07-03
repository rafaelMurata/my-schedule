package br.com.rafaelmurata.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafaelmurata.mvc.logic.Logic;

public class ControllerServlet extends HttpServlet{

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("logic");
        String className = "br.com.rafaelmurata.mvc.logic." + param;

        try {
            Class classe = Class.forName(className);
            Logic logica = (Logic) classe.newInstance();
            logica.executa(request, response);
        } catch (Exception e) {
            throw new ServletException("Exception on logic class", e);
        }
    }
}
