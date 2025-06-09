package controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Item;
import service.ItemDetailsService;
import service.ItemService;
import service.implementation.ItemDetailsServiceImpl;
import service.implementation.ItemServiceImp;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
       
    @Resource( name = "jdbc/item")
        private DataSource dataSource;
    private ItemService itemService;

	@Override
	public void init() throws ServletException {
		itemService = new ItemServiceImp(dataSource);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");
	        if (Objects.isNull(action)) {
	            action = "load-items";
	        }
	        
	        switch (action) {
            case "load-items":
                this.loadItems(request, response);
                return;
            case "add-item":
                this.addItem(request, response);
                return;
            case "update-item":
                this.updateItem(request, response);
                return;
            case "remove-item":
                this.removeItem(request, response);
                return;
            case "load-item":
                this.loadItem(request, response);
                return;
            default :
            	this.loadItems(request, response);
            	break;
        }

        this.loadItems(request, response);

	}

	private void loadItem(HttpServletRequest request, HttpServletResponse response) {
			
			 int  id =Integer.parseInt( request.getParameter("id"));
			 Item loaded_item=itemService.loadItem(id);
			 
			 request.setAttribute("itemData", loaded_item);

		        try {
		            request.getRequestDispatcher("/load-item.jsp").forward(request, response);
		        } catch (Exception e) {
		            System.out.println(e.getMessage());
		        }
			

			 
		
	}

	private void removeItem(HttpServletRequest request, HttpServletResponse response) {
		 int  id =Integer.parseInt( request.getParameter("id"));
	
		 boolean isRemoved=itemService.removeItem(id);
		 if (isRemoved) {
	            this.loadItems(request, response);
	        }
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		 
		 boolean isUpdated=itemService.updateItem(getItemData(request,response));
		 if(isUpdated) {
			 this.loadItems(request, response);
		 }
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) {
	
		 boolean isAdded=itemService.saveItem(getItemData(request,response));
		 if (isAdded) {
	            this.loadItems(request, response);
	        }
		
	}

	private void loadItems(HttpServletRequest request, HttpServletResponse response) {
			//item details service
			ItemDetailsService itemDetailService= new ItemDetailsServiceImpl(dataSource);			
			
	        List<Item> items = itemService.loadItems();
	        //check if item has details or not 
	        //if show item details return null that mean there is no details for this item
	        for(int i=0;i<items.size();i++) {
	        
	        	if(Objects.nonNull(itemDetailService.showItemDetails(items.get(i).getId()))) {
	        		items.get(i).setHasDetails("True");
	        	}
	        }
	        request.setAttribute("itemsData", items);
	        

	        try {
	            request.getRequestDispatcher("/load-items.jsp").forward(request, response);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private  Item getItemData(HttpServletRequest request, HttpServletResponse response) {
		 String  name =request.getParameter("itemName");
		 double  price =Double.parseDouble(request.getParameter("itemPrice"));
		 int  totalNumber = Integer.parseInt(request.getParameter("itemTotalNumber"));
		 
		 Item item=new Item(name,price,totalNumber);
		 
		 String id = request.getParameter("itemId");
		 if (Objects.nonNull(id)) {
				item.setId(Integer.parseInt(id));
			}
		 return item;
	}
	

}
