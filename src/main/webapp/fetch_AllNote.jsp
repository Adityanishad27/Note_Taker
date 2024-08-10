
<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>

<%@page import="com.helper.Factoryprovider"%>

<%@page import="com.Entities.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes : NoteTaker</title>
<%@ include file="All_js_css.jsp" %>
</head>
<body>

<div class="container-fluid p-0 m-0">
   <%@ include file="navbar.jsp" %>
   </div>
   <br>
   <h1 class="text-uppercase"> show all notes </h1>
   
   
   <div class="row">
   
   
   <div class="col-12">
     
   <% 
  Session s =Factoryprovider.getFactory().openSession();
   
 Query q=s.createQuery("from Notes");
 
 
 List<Notes> list= q.list();
 
 for(Notes note : list){
	 
	 
	 %>
	 
	 
	 
	 <div class="card " >
  <img class="card-img-top " style="max-width: 50px"  src="img/pencil.png" alt="Card image cap">
  <div class="card-body px-5" >
    <h5 class="card-title"><%= note.getTitle() %></h5>
    <p class="card-text"> <%=note.getContent() %></p>
   <div class="container text-align">
    <a href="DeleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger">DELETE</a>
     <a href="update.jsp?note_id=<%= note.getId()%>" class="btn btn-primary">UPDATE</a>
   </div>
  </div>
</div>
	 
	 
	 
	 <%
	
	 
 }
 
 s.close();
 
 
   %>
   
   </div>
   
   
   
   </div>
   
   
   
   
   
   
 

</body>
</html>