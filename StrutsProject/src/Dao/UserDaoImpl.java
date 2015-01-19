package Dao;

import java.sql.*;

import Model.*;


public class UserDaoImpl implements UserDao {

	@Override
	public boolean checkUser(LoginForm loginForm) {
			
		 String query="Select Username,Password,First_Name from userdata where Username = ? AND Password= ?";
		 Connection con; 
		 PreparedStatement ps;
		 try{  
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/user_database","root","nikhil"); 
			 ps = con.prepareStatement(query);
			
			 ps.setString(1,loginForm.getUsername().toString()); 
			 ps.setString(2,loginForm.getPassword().toString()); 
			 
			 ResultSet rs= ps.executeQuery();
			 if (!rs.isBeforeFirst() ) {    
				 	return true;
				} 
			 else
			 	{
					 rs.next();		
					 loginForm.setFirstName(rs.getString(3));
					 return false;
			 	}
				
				
		}  
		
		catch(Exception e)
			{
				return true;
			}
		
		 
	
		
		
	}



	public ResultSet fetchHotels(){
		String query="Select * from hotel_info";
		 Connection con; 
		 Statement smt;
		 ResultSet rs;
		 try{  
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/user_database","root","nikhil"); 
			 smt = con.createStatement();
			 rs= smt.executeQuery(query);
			 return rs;
			 	
				
				
		}  
		
		catch(Exception e)
			{
				rs=null;
				return rs;
			}
		
		
	}
	
	public ResultSet fetchFavourites(String userid){
		String query="Select * from hotel_info where Id in (Select hotelId from favouriteHotel where userid='"+ userid+"')";
		 Connection con; 
		 Statement smt;
		 ResultSet rs;
		 try{  
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/user_database","root","nikhil"); 
			 smt = con.createStatement();
			 rs= smt.executeQuery(query);
			 return rs;
			 	
				
				
		}  
		
		catch(Exception e)
			{
			
				rs=null;
				return rs;
			}
	}
	
	public boolean insertFavourites(String hotelId,String userid){
		String query="Insert into favouriteHotel values(?,?)";
		 Connection con; 
		 PreparedStatement ps;
		 try{  
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/user_database","root","nikhil"); 
			 ps = con.prepareStatement(query);
			
			 ps.setString(1,userid); 
			 ps.setString(2,hotelId); 
			
			
			 int rows= ps.executeUpdate();
		
			 System.out.print("Rows:"+rows);
			 if (rows==0 ) {    
				 	return true;
				} 
			 else
			 	{	
					 return false;
			 	}
				
				
		}  
		
		catch(Exception e)
			{
			System.out.println(e);
				return true;
			}
		
		 
	}
	
	public boolean deleteFavourites(String hotelId,String userid){
		String query="Delete from favouriteHotel where userid=? and hotelid=?";
		 Connection con; 
		 PreparedStatement ps;
		 try{  
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/user_database","root","nikhil"); 
			 ps = con.prepareStatement(query);
			
			 ps.setString(1,userid); 
			 ps.setString(2,hotelId); 
			 
			 int rows= ps.executeUpdate();
			 if (rows==0 ) {    
				 	return true;
				} 
			 else
			 	{	
					 return false;
			 	}
				
				
		}  
		
		catch(Exception e)
			{
				return true;
			}
	}
	
	public ResultSet fetchFavHotelName(String userid){
		String query="Select hotelId from favouriteHotel where userid='"+userid+"'";
		System.out.print(query);
		 Connection con; 
		 Statement smt;
		 ResultSet rs;
		 try{  
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/user_database","root","nikhil"); 
			 smt = con.createStatement();
			 rs= smt.executeQuery(query);
			 return rs;
			 	
				
				
		}  
		
		catch(Exception e)
			{
				System.out.print("Exception in DAO");
				rs=null;
				return rs;
			}
		
		 
	}
	public boolean insertBooking(BookingForm bookInfo){
		String query="Insert into bookingtable(UserId,HotelId,HotelName,EventDate,BookingDate,TimeSlot,Persons,Cost) values(?,?,?,?,?,?,?,?)";
		 Connection con; 
		 PreparedStatement ps;
		 try{  
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/user_database","root","nikhil"); 
			 ps = con.prepareStatement(query);
			
			 ps.setString(1,bookInfo.getUserId()); 
			 ps.setString(2,bookInfo.getHotelId());
			 ps.setString(3,bookInfo.getHotelName());
			 ps.setDate(4, (bookInfo.convertDate(bookInfo.getEventDate())));
			 ps.setDate(5,(bookInfo.convertDate(bookInfo.getBookingDate())));
			 ps.setString(6,bookInfo.getTimeSlot());
			 ps.setInt(7,bookInfo.getPersons());
			 ps.setFloat(8,bookInfo.getCost());
			 
			 int rows= ps.executeUpdate();
		
			 if (rows==0 ) {    
				 	return true;
				} 
			 else
			 	{	
					 return false;
			 	}
				
				
		}  
		
		catch(Exception e)
			{
			System.out.println(e);
				return true;
			}
	}
	public ResultSet fetchBookingHistory(String userid)
	{
		 String query="Select * from bookingTable where userid='"+userid+"'";
		 Connection con; 
		 Statement smt;
		 ResultSet rs;
		 try{  
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/user_database","root","nikhil"); 
			 smt = con.createStatement();
			 rs= smt.executeQuery(query);
			 return rs;
			 	
				
		}  
		
		catch(Exception e)
			{
				rs=null;
				return rs;
			}
		
	}
	public ResultSet bookingAvailability(BookingForm bookInfo){
		String query="Select HotelId,EventDate,TimeSlot from bookingtable where HotelId=?";
		 Connection con; 
		 PreparedStatement ps;
		 try{  
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/user_database","root","nikhil"); 
			 ResultSet rs;
			 ps = con.prepareStatement(query);
			
			 ps.setString(1,bookInfo.getHotelId()); 
					 
			 rs= ps.executeQuery();
			 
			 return rs;
		}  
		
		catch(Exception e)
			{
			System.out.println(e);
			return null;
			}
	}
}
	

/*
	@Override
	public boolean saveUser(User userDetails) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/user_database","root","nikhil");  
	      
		String query="insert into userdata(Username,Password,First_Name,Last_name,Email,Gender,City,State,Pincode,Country)"
				+"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		 PreparedStatement ps = con.prepareStatement(query);
		 ps.setString(1,userDetails.getUsername()); 
		 ps.setString(2,userDetails.getPassword()); 
		 ps.setString(3,userDetails.getFirstName()); 
		 ps.setString(4,userDetails.getLastName()); 
		 ps.setString(5,userDetails.getEmail()); 
		 ps.setString(6,userDetails.getGender());
		 ps.setString(7,userDetails.getCity()); 
		 ps.setString(8,userDetails.getState()); 
		 ps.setFloat(9,userDetails.getPincode()); 
		 ps.setString(10,userDetails.getCountry()); 
		 
		 ps.executeUpdate();
		 ps.close();
		 con.close();
		 return false;
		
		}
		catch(Exception e){  
			return true;
		}

	}
	
	@Override
	public boolean checkAvailability(LoginData data) {
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
		     Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/user_database","root","nikhil");
	         Statement st=con.createStatement();
	         String query="select Username from userdata where Username= ?";
	         PreparedStatement ps = con.prepareStatement(query);
	         ps.setString(1,data.getUser());
	         ResultSet rs = ps.executeQuery();
	         if(rs.next())
	        	 return true;
	         else 
	        	 return false;
		 }
		 
		 catch(Exception e)
		 {
			 return true;
		 }
		 
	}
}
*/