package Service;

import java.sql.ResultSet;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Model.*;


public interface ServiceProvider {
	public boolean checkUserService(LoginForm loginForm);
	public List<HotelDVO> fetchHotels(String userid);
	public boolean insertFavourite(String hotelId,String userid);
	public boolean deleteFavourite(String hotelId,String userid);
	public List<HotelDVO> fetchFavourite(String userid);
	public List<String> fetchFavHotel(String userid);
	public List<String> selectHotelList();
	public ResultSet allHotelInfo();
	public JSONObject costJSON();
	public int insertBooking(BookingForm bookingInfo);
	public List<BookingForm> fetchBooking(String userid);
	public int checkBookingAvailability(BookingForm bookingInfo);
	//public boolean SaveUserService(User user);
	//public boolean checkAvailableService(LoginData data);
}
