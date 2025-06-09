<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Items</title>
    <link rel="stylesheet" href="css/show-items.css">
</head>
<body>
<div class="layer">
    <table>
        <h1>Items</h1>
        <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>TOTAL_NUMBER</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
        List<Item> items = (List<Item>) request.getAttribute("itemsData");
        %>
        <%
        	for(Item item: items){
        %>
        <tr>
            <td><strong><%=item.getId() %></strong></td>
            <td><%=item.getName() %></td>
            <td><%=item.getPrice() %></td>
            <td><%=item.getTotalNumber()%></td>
            <td>
                <a href='ItemController?action=load-item&id=<%=item.getId() %>'>Update</a>
                <a href='ItemController?action=remove-item&id=<%=item.getId() %>'>Delete</a>
                <%
                if(!item.isHasDetails().equals("False")) {%>  
                <a href='ItemDetailsController?action=show-details&id=<%=item.getId() %>'>Show details</a> 
                <%
                } else{
                %>
                <a href='item-details.jsp?id=<%=item.getId() %>'>Add Details</a>
                <%} %>
              	
                
            </td>
        </tr>
        <%
        	}
        %>
        
        </tbody>
    </table>


    <button class="f"><a href="add-item.html">Add Item</a></button>


</div>

</body>
</html>