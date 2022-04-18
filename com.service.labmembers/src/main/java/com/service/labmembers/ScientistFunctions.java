package com.service.labmembers;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.service.labmembers.data.Scientist;

public class ScientistFunctions {
	
    java.sql.Connection connection;	
    java.sql.Statement statement;

	
	public Scientist addScientistToALab(Scientist s, int laboratoryId) {
		int scientistId = s.getId();
		s.setLaboratoryId(laboratoryId);
		try {
			connection = DriverManager.getConnection("jdbc:mysql://mysql-amineee.alwaysdata.net/amineee_123", "amineee", "GH123@5");
			statement = connection.createStatement();
	        String query = "update scientist set laboratoryId = '"+laboratoryId+"' WHERE id = '"+scientistId+"'";
			statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return s;    
	}
	
	public Scientist addScientist(Scientist s) {
		int id = s.getId();
		String firstName = s.getFirstName();
		String lastName=s.getLastName();
		String specialty=s.getSpecialty();
		int laboratoryId=s.getLaboratoryId();
		try {
			connection = DriverManager.getConnection("jdbc:mysql://mysql-amineee.alwaysdata.net/amineee_123", "amineee", "GH123@5");
			statement = connection.createStatement();
	        String query = "INSERT INTO scientist (id,first_name,last_name,specialty,laboratory_id) values('"+id+"','"+firstName+"','"+lastName+"','"+specialty+"','"+laboratoryId+"')";
			statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return s;
	}
	
	public void deleteScientist(int id) {
		try {
    		connection = DriverManager.getConnection("jdbc:mysql://mysql-amineee.alwaysdata.net/amineee_123", "amineee", "GH123@5");
			statement = connection.createStatement();
	        String query = "DELETE from scientist WHERE id ="+id;
			statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
	
	public Scientist getScientist(int id) {
		Scientist s =null;
		try {
    		connection = DriverManager.getConnection("jdbc:mysql://mysql-amineee.alwaysdata.net/amineee_123", "amineee", "GH123@5");
			statement = connection.createStatement();
	        String query = "SELECT * from scientist WHERE id = '"+id;
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()){
				 String firstName = result.getString("first_name");
				 String last_name = result.getString("last_name");
				 String specialty = result.getString("specialty");
				 int laboratory_id = Integer.parseInt(result.getString("laboratory_id"));
				 s = new Scientist(id,firstName,last_name,specialty,laboratory_id);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return s;
	}
	
}
