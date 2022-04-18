package com.service.labmembers.service;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.service.labmembers.data.Laboratory;

public class LaboratoryService {
	
    java.sql.Connection connection;	//Creating object of Connection class
    java.sql.Statement statement;	//Creating object of Statement class
        
    public int getNewId() {
    	int newId=0;
        try {
        	connection = DriverManager.getConnection("jdbc:mysql://mysql-amineee.alwaysdata.net/amineee_123", "amineee", "GH123@5");
			statement = connection.createStatement();
			String query = "SELECT id FROM laboratory ORDER BY id DESC LIMIT 1;";
			ResultSet res = statement.executeQuery(query);
			
			while(res.next()) {
				newId = Integer.parseInt(res.getString("id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
   return newId++;   
   }
    
	public Laboratory addLaboratory(String name, String specialty, int money, int nbEmployees) {
		int id = getNewId();
		
		Laboratory lab = new Laboratory(id, name, specialty, money, nbEmployees);
        try {
        	connection = DriverManager.getConnection("jdbc:mysql://mysql-amineee.alwaysdata.net/amineee_123", "amineee", "GH123@5");
            statement = connection.createStatement();
            String query = "INSERT INTO laboratory (id,name,specialty,money,nbEmployees) VALUES ('"+id+"','"+name+"','"+specialty+"',"+money+","+nbEmployees+")";
			statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return lab;
	}
	
	public void deleteLaboratory(int id) {
        try {
    		connection = DriverManager.getConnection("jdbc:mysql://mysql-amineee.alwaysdata.net/amineee_123", "amineee", "GH123@5");
			statement = connection.createStatement();
	        String query = "DELETE from laboratory WHERE id ="+id;
			statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
	
	public Laboratory getLaboratory(int id) {
		Laboratory lab=null;
		try {
        	connection = DriverManager.getConnection("jdbc:mysql://mysql-amineee.alwaysdata.net/amineee_123", "amineee", "GH123@5");
            statement = connection.createStatement();
            String query = "SELECT * FROM laboratory WHERE id="+id;
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()){
				 String name = result.getString("name");
				 String specialty = result.getString("specialty");
				 int nbEmployees = Integer.parseInt(result.getString("nbEmployees"));
				 int money = Integer.parseInt(result.getString("money"));
				 lab = new Laboratory(id,name,specialty,nbEmployees,money);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lab;
	}
}
