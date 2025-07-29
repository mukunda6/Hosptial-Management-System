package model;

import java.sql.*;

public class Doctor {
	private Connection connection;

	public Doctor(Connection connection)
	{
		this.connection=connection;
	}
	
	public void viewDoctors()
	{
		String query="select * from doctors";
		try
		{
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet resultset=preparedStatement.executeQuery();
			
			System.out.println("Doctors: ");
			System.out.println("+------------+--------------------+-----------------+");
			System.out.println("| Doctor ID  | Name               | Specilization   |");
			System.out.println("+------------+--------------------+-----------------+");
			
			while(resultset.next())
			{
				int id=resultset.getInt("id");
				String name=resultset.getString("name");
				String specilization=resultset.getString("specilization");
				
				System.out.printf("|%-12s|%-20s|%-17s|\n", id, name, specilization);
				System.out.println("+------------+--------------------+-----------------+");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean getDoctorByID(int id)
	{
		String query="select * from doctors where id=?";
		try
		{
			PreparedStatement preparedStatement= connection.prepareStatement(query);
			preparedStatement.setInt(1,  id);
			ResultSet resultset=preparedStatement.executeQuery();
			if(resultset.next())
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
