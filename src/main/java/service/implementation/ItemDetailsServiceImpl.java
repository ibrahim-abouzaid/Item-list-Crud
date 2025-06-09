package service.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import model.ItemDetails;
import service.ItemDetailsService;

public class ItemDetailsServiceImpl implements ItemDetailsService {
	
	private DataSource dataSource;
	
	

	public ItemDetailsServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean saveItemDetails(ItemDetails itemDetails) {
		
		try {
			Connection connection=this.dataSource.getConnection();
			String query="insert into item_details (description,colors,category,item_id) values (?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,itemDetails.getDescription());
			ps.setString(2,itemDetails.getColors());
			ps.setString(3,itemDetails.getCategory());
			ps.setInt(4,itemDetails.getItem_id());
		
			int result= ps.executeUpdate();
			connection.close();
		    return result==1;
			}catch(Exception e) {
				   System.out.println(e.getMessage());
				   return false;
			}
		
		
	}

	@Override
	public ItemDetails showItemDetails(int itemId) {
		try {
			Connection connection=this.dataSource.getConnection();
			String query="select * from item_details where item_id =?";
		
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,itemId);
			ResultSet resultSet= ps.executeQuery();
			
			if(resultSet.next()) {
				
				 return new ItemDetails(resultSet.getString("description"),resultSet.getString("colors"),resultSet.getString("category"),itemId);
			}
			else {
				return null;
			}
			
		   
			}catch(Exception e) {
				   System.out.println(e.getMessage()+"showItemdetails ");
				   return null;
			}
		
		
	}



	

}
