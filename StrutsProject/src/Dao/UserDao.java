package Dao;

import java.sql.ResultSet;

import Model.BookingForm;
import Model.LoginForm;

public interface UserDao {
	public boolean checkUser(LoginForm loginForm);
	public ResultSet fetchHotels();
	public boolean insertFavourites(String hotelId,String userid);
	public boolean deleteFavourites(String hotelId,String userid);
	public ResultSet fetchFavourites(String userid);
	public ResultSet fetchFavHotelName(String userid);
	public boolean insertBooking(BookingForm bookInfo);
	public ResultSet fetchBookingHistory(String userid);
	public ResultSet bookingAvailability(BookingForm bookInfo);
//	public boolean saveUser(User user);
	//public boolean checkAvailability(DynaValidatorForm data);

}
