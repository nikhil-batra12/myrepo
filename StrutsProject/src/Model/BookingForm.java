package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingForm {
	private int bookingId;
	private String userId;
	private String hotelId;
	private String hotelName;
	private String bookingDate;
	private String eventDate;
	private String timeSlot;
	private int persons;
	private float cost;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate=bookingDate;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate=eventDate;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public int getPersons() {
		return persons;
	}
	public void setPersons(int persons) {
		this.persons = persons;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public java.sql.Date convertDate(String date){
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        Date parsed;
        java.sql.Date finalDate;
		try {
			parsed = format.parse(date);
			 finalDate = new java.sql.Date(parsed.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
       
        return finalDate;
	}
}
