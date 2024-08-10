package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entities.Notes;
import com.helper.Factoryprovider;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateServlet() {
        super();
        
    }

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			
			String title= request.getParameter("title");
			String content= request.getParameter("content");
			
			int noteid=Integer.parseInt(request.getParameter("note_id").trim());
			
			Session session=	Factoryprovider.getFactory().openSession();
			Transaction tx= session.beginTransaction();
			Notes note = session.get(Notes.class, noteid);
			
			note.setTitle(title);
			note.setContent(content);
			note.setAddeddate(new Date(0));
		
			tx.commit();
			
			session.close();
			
			
			response.sendRedirect("fetch_AllNote.jsp");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			
		}
		
		
	}

}
