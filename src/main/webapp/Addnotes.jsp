<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
</head>

<%@ include file="All_js_css.jsp" %>
<body>

 <div class="container-fluid p-0 m-0">
   <%@ include file="navbar.jsp" %>
   </div>
   <br>
  <h1>Please Fill your Notes details</h1> 
 <br>
 
 <form action="savenote"  method="post">
  <div class="form-group">
    <label for="title">Note Title</label>
    <input name="title" type="text" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter Title " required="required">
  
  </div>
  <div class="form-group">
    <label for="content">Content</label>
    <textarea name="content" class="form-control" id="content" placeholder="Enter Your content Here" style="height: 300px" required="required"></textarea>
  </div>
  <div class="container text-center">
     <button type="submit" class="btn btn-primary">ADD</button>
  </div>
  
  
   
</form>
 

</body>
</html>