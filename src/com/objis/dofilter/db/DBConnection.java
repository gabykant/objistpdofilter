package com.objis.dofilter.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.objis.dofilter.entity.Item;

public class DBConnection {
	String url = "jdbc:mysql://localhost:3306/dofilter";
	String username = "root";
	String mdp = "";
	Connection strCon;
	
	public boolean login(String Username, String Password) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			strCon = DriverManager.getConnection(url, username, mdp);
			
			String sql = "SELECT * FROM admin WHERE username = '" +Username +"' AND password='" +Password+"';";
			
			Statement st = strCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = st.executeQuery(sql);
			
			int index = 0;
			
			rs.last();
			index = rs.getRow();
			rs.beforeFirst();
			
			if(index > 0 )
				result =true;

			st.close();
			strCon.close();
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Item> getItem(){
		List<Item> items = new ArrayList<Item>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			strCon = DriverManager.getConnection(url, username, mdp);
			
			String sql = "SELECT * FROM item;";
			
			Statement st = strCon.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Item item = new Item();
				item.setTitle(rs.getString(3));
				item.setAuthor(rs.getString(4));
				items.add(item);
			}
			strCon.close();
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
	
	public int insertInsert(Item item) throws SQLException 
	{
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			strCon = DriverManager.getConnection(url, username, mdp);
			
			Statement st = strCon.createStatement();
			
			String sqlStr = "INSERT INTO item VALUES(null,"
					+ item.getUserid() + ",'"
					+ item.getTitle()+ "', '"
					+ item.getAuthor() + "');";
			
			result = st.executeUpdate(sqlStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
