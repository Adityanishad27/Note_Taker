package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entities.Notes;
import com.helper.Factoryprovider;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			
			int noteid = Integer.parseInt(request.getParameter("note_id").trim());
			
			
			Session session =Factoryprovider.getFactory().openSession();
			
			
			Notes note = (Notes)session.get(Notes.class, noteid);
			
			Transaction tx = session.beginTransaction();
			
			
			session.delete(note);
			
			
			tx.commit();
			session.close();
			
			response.sendRedirect("fetch_AllNote.jsp");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	

}
