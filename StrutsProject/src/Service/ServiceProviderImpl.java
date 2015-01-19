package Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Dao.*;
import Model.*;

public class ServiceProviderImpl implements ServiceProvider {

	
	static UserDao userDao;
	public ServiceProviderImpl(){
		userDao=new UserDaoImpl();
	} 
	public boolean checkUserService(LoginForm loginForm) {
		boolean status=false; 
		status=userDao.checkUser(loginForm);
		return status;
	}
	public List<HotelDVO> fetchHotels(String userid){
		 
		List<HotelDVO> hotelList = new ArrayList<HotelDVO>();
		HotelDVO hotelDVO ;
		ResultSet rs=allHotelInfo();
		List<String> favHotelList=fetchFavHotel(userid);
		
		try {
			while(rs.next()){
				hotelDVO  = new HotelDVO();
				hotelDVO.setId(rs.getString("Id"));
				hotelDVO.setName(rs.getString("Name"));
				hotelDVO.setCapacity(rs.getInt("Capacity"));
				hotelDVO.setRating(rs.getString("Rating"));
				hotelDVO.setCost(rs.getInt("Cost"));
				hotelDVO.setAddress(rs.getString("Address"));
				hotelDVO.setContact(rs.getString("Contact"));
				hotelDVO.setImgURL(rs.getString("URL"));
				if(favHotelList.contains(hotelDVO.getId()))
					hotelDVO.setFavValue("Remove from Favourites");
				else
					hotelDVO.setFavValue("Add to Favourites");
				hotelList.add(hotelDVO);
			}
		} 
		catch (SQLException e) {
				e.printStackTrace();
		}
	
		return hotelList;	
	}
	
	public boolean insertFavourite(String hotelId,String userid){
		boolean status=userDao.insertFavourites(hotelId,userid);
		return status;
	}
	
	public boolean deleteFavourite(String hotelId,String userid){
		boolean status=userDao.deleteFavourites(hotelId,userid);
		return status;
	}
	
	public List<HotelDVO> fetchFavourite(String userid){
		ResultSet rs=userDao.fetchFavourites(userid);
		List<HotelDVO> hotelList = new ArrayList<HotelDVO>();
		HotelDVO hotelDVO ;
		try {
			while(rs.next()){
				hotelDVO  = new HotelDVO();
				hotelDVO.setId(rs.getString("Id"));
				hotelDVO.setName(rs.getString("Name"));
				hotelDVO.setCapacity(rs.getInt("Capacity"));
				hotelDVO.setRating(rs.getString("Rating"));
				hotelDVO.setCost(rs.getInt("Cost"));
				hotelDVO.setAddress(rs.getString("Address"));
				hotelDVO.setContact(rs.getString("Contact"));
				hotelDVO.setImgURL(rs.getString("URL"));
				hotelDVO.setFavValue("Remove from Favourites");
				hotelList.add(hotelDVO);
			}
		} 
		
		catch (SQLException e) {
			
		}
		return hotelList;	
	}
	
	public List<String> fetchFavHotel(String userid){
		ResultSet rs=userDao.fetchFavHotelName(userid);
		List<String> hotelList = new ArrayList<String>();
	
		try {
			while(rs.next()){
				hotelList.add(rs.getString("hotelId"));
			}
		} 
		
		catch (SQLException e) {
			
		}
		return hotelList;	
	}
	
	public ResultSet allHotelInfo(){
		ResultSet rs=userDao.fetchHotels();
		return rs;
	}
	
	public List<String> selectHotelList(){
		ResultSet rs=userDao.fetchHotels();
		List<String> selectList =new ArrayList<String>();
		try {	
			while(rs.next()){
				String listEntry=rs.getString("Id") + "-" + rs.getString("Name");
				selectList.add(listEntry);
			}
		}
		catch(Exception e){
			
		}
		return selectList;
	}
	
	public JSONObject costJSON(){
		ResultSet rs=userDao.fetchHotels();
		JSONObject jsonobj=new JSONObject();

		
		try {	
			while(rs.next()){
		
				jsonobj.put(rs.getString("ID"),rs.getInt("Cost"));
				jsonobj.put("capacity"+rs.getString("Id"), rs.getInt("Capacity"));
			}
					}
		catch(Exception e){
			System.out.println("My exception");
		}
		return jsonobj;
	}
	
	public int insertBooking(BookingForm bookingInfo){
		
		int errorcode=checkBookingAvailability(bookingInfo);
			if(errorcode==400)
				{
					userDao.insertBooking(bookingInfo);
					return errorcode;
				}
			else 
				{
					return errorcode;
				}

			
	}
	public List<BookingForm> fetchBooking(String userid){
		ResultSet rs=userDao.fetchBookingHistory(userid);
		BookingForm bookingInfo;
		List<BookingForm> bookingList = new ArrayList<BookingForm>();
		try {
			while(rs.next()){
				bookingInfo=new BookingForm();
				bookingInfo.setBookingId(rs.getInt("BookingId"));
				bookingInfo.setUserId(userid);
				bookingInfo.setHotelId(rs.getString("HotelId"));
				bookingInfo.setHotelName(rs.getString("HotelName"));
				bookingInfo.setEventDate(rs.getString("EventDate"));
				bookingInfo.setBookingDate(rs.getString("BookingDate"));
				bookingInfo.setTimeSlot(rs.getString("TimeSlot"));
				bookingInfo.setPersons(rs.getInt("Persons"));
				bookingInfo.setCost(rs.getFloat("Cost"));
				bookingList.add(bookingInfo);
			}
		}	
		catch(Exception e){
			return null;
		}
			return bookingList;
			
	}
	
	
	public int checkBookingAvailability(BookingForm bookingInfo){
		ResultSet rs=userDao.bookingAvailability(bookingInfo);
		java.sql.Date eventDateDb,eventDate;
		String timeSlot="Full day(12pm to 10pm)";
		String timeSlot1="Slot 1(10am to 2pm)";
		String timeSlot2="Slot 2(3pm to 7pm)";
		String timeSlot3="Slot 3(8pm to 12am)";
		String timeSlotDb;
		int status=400;
		try{
				while(rs.next()){
					eventDateDb=rs.getDate("EventDate");
					eventDate=bookingInfo.convertDate(bookingInfo.getEventDate());
					timeSlotDb=rs.getString("TimeSlot");
					if((eventDate.toString()).equals(eventDateDb.toString()))
						if(timeSlot.equals(timeSlotDb))
							{
								status=100;
								break;
							}
						else if((bookingInfo.getTimeSlot()).equals(rs.getString("TimeSlot")))
						{
							status=200;
							break;
						}
						else if(bookingInfo.getTimeSlot().equals(timeSlot) && (timeSlotDb.equals(timeSlot1) || timeSlotDb.equals(timeSlot2) || timeSlotDb.equals(timeSlot3)))
						{
							status=300;
							break;
						}
				}
				
			}	
		catch(Exception e){
			
		}
		
		return status; 
	}
}

/*
	@Override
	public boolean SaveUserService(User user) {
		boolean status=false;
		UserDao userDao=new UserDaoImpl();
		status=userDao.saveUser(user);
		return status;
	}
	
	@Override
	public boolean checkAvailableService(LoginData data) {
		boolean status=false;
		UserDao userDao=new UserDaoImpl();
		status=userDao.checkAvailability(data);
		return status;
	}
}
*/