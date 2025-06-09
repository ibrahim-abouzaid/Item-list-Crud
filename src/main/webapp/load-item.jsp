<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Item"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>update Item</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="css/add-item.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="container">
  <div class="text">
    Update Item
  </div>
   <%
        Item item = (Item) request.getAttribute("itemData");
        %>
  <form action="/Item_Service/ItemController">
    <div class="form-row">
      <div class="input-data">
        <input type="text" required name="itemName" value="<%=item.getName() %>">
        <div class="underline"></div>
        <label>Name</label>
      </div>
      <div class="input-data">
        <input type="text" required name="itemPrice" value=<%=item.getPrice() %>>
        <div class="underline"></div>
        <label>PRICE</label>
      </div>
    </div>
    <div class="form-row">
      <div class="input-data">
        <input type="text" required name="itemTotalNumber" value=<%=item.getTotalNumber() %>>
        <div class="underline"></div>
        <label>TOTAL_NUMBER</label>
      </div>
     
        
       <input type="hidden" required name="itemId" value=<%=item.getId() %>>
       <input type="hidden" required name="itemHasDetails" value=<%=item.isHasDetails() %>>
      <input type="hidden" required name="action" value="update-item">

    </div>
    <input type="submit" value="Update" class="button">
  </form>

  <p class="back">
    <a href="/Item_Service/ItemController" >Back To Items</a>
  </p>
</div>
<!-- partial -->

</body>
</html>
