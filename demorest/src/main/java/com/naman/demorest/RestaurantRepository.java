package com.naman.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;



public class RestaurantRepository {


	Connection con = null;
	
	
	public RestaurantRepository()
	{
		
			String url = "jdbc:mysql://localhost:3306/restdb";
			String username = "root";
			String password = "naman";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url,username,password);
			} 
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}
	
	
	public List<Restaurant> getRestaurant()
	{ 
		List<Restaurant> c = new ArrayList<>();
		String sql = "select restaurant.ID,restaurant.name,restaurant.menu,restaurant.city, menu.menuitem from restaurant,menu where restaurant.ID=menu.ID;";
		
		//SELECT users.email, users.password, data.data_1, data.data_2
		//FROM users,data 
		//WHERE users.email='$user_email' AND users.user_id=data.user_id";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				Restaurant a =  new Restaurant();
				
				a.setID(rs.getInt("ID"));
				a.setName(rs.getString("name"));
				a.setMenu(rs.getString("menu"));
				a.setCity(rs.getString("city"));
				a.setMenuitem(rs.getString("menuitem"));
				c.add(a);
				
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return c;
		 
		}
	
	
	public Restaurant getrestaurant(int id)
	{ 
		Restaurant a =  new Restaurant();
	//	List<Restaurant> c = new ArrayList<>();
		String sql = "select restaurant.ID,restaurant.name,restaurant.menu,restaurant.city, menu.menuitem from restaurant,menu where restaurant.ID=menu.ID and restaurant.ID="+id;
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next())
			{
				
				a.setID(rs.getInt("ID"));
				a.setName(rs.getString("name"));
				a.setMenu(rs.getString("menu"));
				a.setCity(rs.getString("city"));
				a.setMenuitem(rs.getString("menuitem"));
	
				System.out.println(rs.getString("name"));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
		 
		}

	
	public void createRestaurant(Restaurant a1)
	{  
		System.out.println("called create restaurant");
		String sql = "insert into restaurant values(?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, a1.getName());
			st.setInt(2, a1.getID());
			st.setString(3, a1.getCity());
			st.setString(4,a1.getMenu());
			st.executeUpdate();
			
			
				
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void createRestaurantMenu(Restaurant a1)
	{  
		System.out.println("called create restaurantmenu");
		String sql = "insert into menu values(?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a1.getID());
			st.setString(2,a1.getMenu());
			st.setString(3, a1.getMenuitem());
			st.executeUpdate();
			
			
				
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void UpdateRestaurant(Restaurant a1)
	{
		String sql = "update restaurant set name=?, city=?, Menu=? where id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, a1.getName());
			st.setInt(4, a1.getID());
			st.setString(2, a1.getCity());
			st.setString(3,a1.getMenu());
			st.executeUpdate();
				
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void UpdateRestaurantmenu(Restaurant a1)
	{
		String sql = "update menu set menuname=?,menuitem=? where id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(3, a1.getID());
			st.setString(1,a1.getMenu());
			st.setString(2, a1.getMenuitem());
			st.executeUpdate();
				
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void deleteRestaurant(int id) {
				String sql = "delete from restaurant where id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,id);
			st.executeUpdate();
				
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
