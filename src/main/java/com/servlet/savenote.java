package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entities.Notes;
import com.helper.Factoryprovider;


public class savenote extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public savenote() {
        super();
        
    }




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			String title= request.getParameter("title");
			String content= request.getParameter("content");
			
			Notes note= new Notes(title, content,new Date(0, 0, 0));
			
			
		Session session=	Factoryprovider.getFactory().openSession();
		Transaction tx= session.beginTransaction();
		
		
		session.save(note);
		
		
		
		
		
		tx.commit();
		
		session.close();
		
		
		 response.setContentType("text/html");
		  PrintWriter writer=response.getWriter(); 
		 writer.println("<h1 style='text-align : center;'> Notes Added Succefully </h1>"); 
		  writer.println("<h1 style='text-align : center;'> <a href=fetch_AllNote.jsp> View All Notes </a></h1>");
		 
		
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
