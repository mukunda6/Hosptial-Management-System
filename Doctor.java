package hms;

import java.sql.*;

public class Doctor {

	private Connection connection;
	
	public Doctor(Connection connection)
	{
		this.connection = connection;
	}
	
	//Method to view doctors
	public void viewDoctors()
	{
		String query = "select * from doctors";
		
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultset = preparedStatement.executeQuery();
			
			System.out.println("Doctors: ");
			System.out.println("+-------------+---------------------+-----------------+");
			System.out.println("| doctor ID   | Name                | Specilization   |");
			System.out.println("+-------------+---------------------+-----------------+");
			
			while(resultset.next())
			{
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				String specilization = resultset.getString("specilization");
				
				System.out.printf("|%-13s|%-21s|%-17s|\n",id,name,specilization);
				System.out.println("+-------------+---------------------+-----------------+");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean getDoctorById(int id)
	{
		String Query = "select * from doctors where id = ?";
				
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setInt(1, id);
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
}
