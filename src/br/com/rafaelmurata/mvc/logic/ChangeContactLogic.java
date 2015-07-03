package br.com.rafaelmurata.mvc.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafaelmurata.dao.ContactDAO;
import br.com.rafaelmurata.model.Contact;

public class ChangeContactLogic implements Logic{

	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Contact contact = new Contact();
        long id = Long.parseLong(request.getParameter("id"));
        contact.setId(id);
        contact.setName(request.getParameter("name"));
        contact.setAdress(request.getParameter("adress"));
        contact.setEmail(request.getParameter("email"));

        String dateOfBirthText = request.getParameter("dateOfBirth");
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirthText);
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.setTime(date);

        contact.setDateOfBirth(dateOfBirth);

        ContactDAO dao = new ContactDAO();
        dao.change(contact);

        RequestDispatcher rd = request.getRequestDispatcher("/contacts-list.jsp");
        rd.forward(request, response);
        System.out.println("changing contact ... "+contact.getName());

    }

}
