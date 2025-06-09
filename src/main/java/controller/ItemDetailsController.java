package controller;

import java.io.IOException;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Item;
import model.ItemDetails;
import service.ItemDetailsService;
import service.ItemService;
import service.implementation.ItemDetailsServiceImpl;
import service.implementation.ItemServiceImp;

/**
 * Servlet implementation class ItemDetailsController
 */
@WebServlet("/ItemDetailsController")
public class ItemDetailsController extends HttpServlet {
	
       
    @Resource( name = "jdbc/item")
    private DataSource dataSource;
    
    ItemDetailsService itemDetailService;
    ItemService itemService;

	@Override
	public void init() throws ServletException {
		itemDetailService = new ItemDetailsServiceImpl(dataSource);
		itemService = new ItemServiceImp(dataSource);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");
	        if (Objects.isNull(action)) {
	            action = "load-items";
	            response.sendRedirect("ItemController?action=load-items");
	        }
	        switch (action) {
	        
	        case "add-details":
	        	this.addDetails(request,response);
	        	 return;
	        case "show-details":
	        	this.showDetails(request,response);
	        	 return;
	        default :
	        	response.sendRedirect("ItemController?action=load-items");
	        	return;
	        }
	}

	private void showDetails(HttpServletRequest request, HttpServletResponse response) {
		
		 int  id =Integer.parseInt( request.getParameter("id"));
		 ItemDetails itemdetails =itemDetailService.showItemDetails(id);
		 Item item =itemService.loadItem(id);
		 
		 request.setAttribute("itemData", item);
		 request.setAttribute("itemDetailsData", itemdetails);

	        try {
	            request.getRequestDispatcher("/show-details.jsp").forward(request, response);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
		
	}

	private void addDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		int itemId= Integer.parseInt( request.getParameter("itemId"));
		
		String description=request.getParameter("itemDescription");
		String colors=request.getParameter("itemColors");
		String Category=request.getParameter("itemCategory");
		
		 boolean isAdded=itemDetailService.saveItemDetails(new ItemDetails(description,colors,Category,itemId));
		 if (isAdded) {
			 if(itemService.updateItemStatus(itemId)) {
			 response.sendRedirect("ItemController?action=load-items");
			 }
	        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
