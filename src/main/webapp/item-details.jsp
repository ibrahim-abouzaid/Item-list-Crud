<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>ADD Item</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="css/add-item.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="container">
  <div class="text">
    Add Item Details
  </div>
  <form action="/Item_Service/ItemDetailsController">
    <div class="form-row">
      <div class="input-data">
        <input type="text" required name="itemDescription">
        <div class="underline"></div>
        <label>description</label>
      </div>
      <div class="input-data">
        <input type="text" required name="itemColors">
        <div class="underline"></div>
        <label>colors</label>
      </div>
    </div>
    
    <div class="form-row">
      <div class="input-data">
        <input type="text" required name="itemCategory">
        <div class="underline"></div>
        <label>category</label>
      </div>
        </div>
    
      <input type="hidden" required name="itemId" value= ${param.id} >
      <input type="hidden" required name="action" value="add-details">

   
    <input type="submit" value="Add" class="button">
  </form>

  <p class="back">
    <a href="/Item_Service/ItemController" >Back To Items</a>
  </p>
</div>
<!-- partial -->

</body>
</html>
