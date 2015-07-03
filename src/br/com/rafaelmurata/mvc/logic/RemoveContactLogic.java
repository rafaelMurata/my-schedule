package br.com.rafaelmurata.mvc.logic;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafaelmurata.dao.ContactDAO;

public class RemoveContactLogic implements Logic {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		ContactDAO dao = new ContactDAO();
		dao.remove(Long.parseLong(id));
		RequestDispatcher rd = request.getRequestDispatcher("/contacts-list.jsp");
		rd.forward(request, response);
		System.out.println("removing contact id ... " + id);
	}

}
