package br.com.rafaelmurata.mvc.logic;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstLogic implements Logic{

	public void executa(HttpServletRequest req,HttpServletResponse res) throws Exception{
        System.out.println("Executing the logic and redirecting...");

        RequestDispatcher rd = req.getRequestDispatcher("/first-logic.jsp");
        rd.forward(req, res);
    }

}
