package service.implementation;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Item;
import service.ItemService;

public class ItemServiceImp  implements ItemService {

	private DataSource dataSource;
	

    public ItemServiceImp(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	
    
	@Override
	public boolean saveItem(Item item) {
		try {
			Connection connection=this.dataSource.getConnection();
			String query="insert into item (name,price,total_number) values (?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,item.getName());
			ps.setDouble(2,item.getPrice());
			ps.setInt(3,item.getTotalNumber());
			
			int result= ps.executeUpdate();
		   
			connection.close();
		    return result==1;
			}catch(Exception e) {
				   System.out.println(e.getMessage());
				   return false;
			}
		
	}

	@Override
	public boolean removeItem(int id) {
		try {
			Connection connection=this.dataSource.getConnection();
			String query="delete from item where id= ?";
			
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,id);
			int result= ps.executeUpdate();
		   
			connection.close();
		    return result==1;
			}catch(Exception e) {
				   System.out.println(e.getMessage());
				   return false;
			}
	}

	@Override
	public boolean updateItem(Item item) {
		try {
			Connection connection=this.dataSource.getConnection();
			String query="update item set name=?,price=?,total_number=? where id= ?";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,item.getName());
			ps.setDouble(2,item.getPrice());
			ps.setInt(3,item.getTotalNumber());
			ps.setInt(4,item.getId());
			
			int result= ps.executeUpdate(query);
		   
			connection.close();
		    return result==1;
			}catch(Exception e) {
				   System.out.println(e.getMessage());
				   return false;
			}
			
		
	}

	@Override
	public Item loadItem(int id) {
		try {
			Connection connection=this.dataSource.getConnection();
			String query="select * from item where id= ?";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
		
			ResultSet resultSet= ps.executeQuery(query);
		   
			resultSet.next();
			connection.close();
		    return new Item(id,resultSet.getString("Name"), resultSet.getDouble("price"), resultSet.getInt("total_number"));
			}catch(Exception e) {
				   System.out.println(e.getMessage());
				   return null;
				   
			}
	}

	@Override
	public List<Item> loadItems() {
		try {
		Connection connection=this.dataSource.getConnection();
		String query="Select * from item order by id";
		Statement statement=connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
	    List<Item> items = new ArrayList<Item>();	
	    
	    while(resultSet.next()) {
            Item item = new Item(resultSet.getInt("id"), resultSet.getString("Name"), resultSet.getDouble("price"), resultSet.getInt("total_number"));
            items.add(item);
        }
	    connection.close();
	    return items;
		}catch(Exception e) {
			   System.out.println(e.getMessage()+" loadItems");
			   return null;
		}
		
	}
	
	@Override
	public boolean updateItemStatus(int itemId) {
		try {
			Connection connection=this.dataSource.getConnection();
			String query="update item set hasDetails='True' where id =?";
		
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,itemId);
			int result= ps.executeUpdate();

			connection.close();
			return  result==1;
			}catch(Exception e) {
				   System.out.println(e.getMessage());
				   return false;
			}
	}
	
	

}