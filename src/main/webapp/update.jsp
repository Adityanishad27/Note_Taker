<%@page import="com.helper.Factoryprovider"%>
<%@page import="com.Entities.Notes"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="All_js_css.jsp" %>
</head>
<body>
<div class="container-fluid p-0 m-0">
   <%@ include file="navbar.jsp" %>
   </div>
   <h1> Edit Notes</h1>
   
   	<% 
	
	int noteid = Integer.parseInt(request.getParameter("note_id"));
   	
   	
   	Session s= Factoryprovider.getFactory().openSession();
   	
   Notes note =(Notes)s.get(Notes.class, noteid);
   	
   	
   	s.close();
	
	
   %>
   
   <form action="UpdateServlet"  method="post">
   
   <input value="<%=note.getId() %>" name="note_id" type="hidden"/>
  <div class="form-group">
    <label for="title">Note Title</label>
    <input name="title"  value="<%= note.getTitle() %>" type="text" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter Title " required="required"/>
  
  </div>
  <div class="form-group">
    <label for="content">Content</label>
    <textarea name="content" class="form-control" id="content" placeholder="Enter Your content Here" style="height: 300px" required="required" ><%= note.getContent() %>
    
    </textarea>
  </div>
  <div class="container text-center">
     <button type="submit" class="btn btn-success">SAVE YOUR NOTE</button>
  </div>

</form>
   
   
   
</body>
</html>