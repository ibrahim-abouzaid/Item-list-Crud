<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Item" %>
<%@ page import="model.ItemDetails" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Item Details</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="css/add-item.css">
  <style>
    body {
      font-family: "Segoe UI", sans-serif;
      background-color: #f9f9f9;
      padding: 40px;
    }

    .container {
      background: #fff;
      max-width: 600px;
      margin: auto;
      padding: 30px;
      border-radius: 12px;
      box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    }

    .text {
      font-size: 24px;
      font-weight: bold;
      margin-bottom: 25px;
      color: #333;
    }

    .form-row {
      display: flex;
      flex-direction: column;
      gap: 15px;
    }

    .input-data p {
      margin: 0;
      padding: 10px;
      background: #f1f1f1;
      border-left: 4px solid #007BFF;
      border-radius: 6px;
    }

    .input-data strong {
      color: #333;
    }

    .back {
      margin-top: 30px;
      text-align: center;
    }

    .back a {
      color: #007BFF;
      text-decoration: none;
      font-weight: bold;
    }

    .back a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="text">Item Details</div>

  <%
    Item item = (Item) request.getAttribute("itemData");
    ItemDetails itemDetails = (ItemDetails) request.getAttribute("itemDetailsData");
  %>

  <div class="form-row">
    <div class="input-data">
      <p><strong>Name:</strong> <%= item.getName() %></p>
    </div>
    <div class="input-data">
      <p><strong>Price:</strong> <%= item.getPrice() %></p>
    </div>
    <div class="input-data">
      <p><strong>Total Number:</strong> <%= item.getTotalNumber() %></p>
    </div>
    <div class="input-data">
      <p><strong>Description:</strong> <%= itemDetails.getDescription() %></p>
    </div>
    <div class="input-data">
      <p><strong>Colors:</strong> <%= itemDetails.getColors() %></p>
    </div>
    <div class="input-data">
      <p><strong>Category:</strong> <%= itemDetails.getCategory() %></p>
    </div>
  </div>

  <p class="back">
    <a href="/Item_Service/ItemController">Back To Items</a>
  </p>
</div>
</body>
</html>