package br.com.rafaelmurata.mvc.logic;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafaelmurata.dao.ContactDAO;
import br.com.rafaelmurata.model.Contact;

public class AddContactLogic implements Logic{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String adress = request.getParameter("adress");
		String email = request.getParameter("email");
		String dateOfBirthText = request.getParameter("dateOfBirth");
		Calendar dateOfBirth = null;
		
		try{
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirthText);
			dateOfBirth = Calendar.getInstance();
			dateOfBirth.setTime(date);
		}catch(java.text.ParseException e){
			return;
		}
		Contact contact = new Contact();
		contact.setName(name);
		contact.setEmail(email);
		contact.setAdress(adress);
		contact.setDateOfBirth(dateOfBirth);
		
		try {
			ContactDAO	dao = new ContactDAO();
			dao.add(contact);
		} catch (SQLException e) {
			e.printStackTrace();
		}

        RequestDispatcher rd = request.getRequestDispatcher("/contacts-list.jsp");
        rd.forward(request, response);
        System.out.println("saving contact ... "+contact.getName());

		
	}

}
