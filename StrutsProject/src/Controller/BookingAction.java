package Controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONObject;

import Model.BookingForm;
import Service.ServiceProvider;
import Service.ServiceProviderImpl;

public class BookingAction extends org.apache.struts.action.Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			 HttpSession session = request.getSession();
			 BookingForm bookInfo=new BookingForm();
			 bookInfo.setUserId(session.getAttribute("userid").toString());
			 bookInfo.setHotelId(request.getParameter("hotelInfo").substring(0,8));
			 bookInfo.setHotelName(request.getParameter("hotelInfo").substring(9));
			 bookInfo.setBookingDate(request.getParameter("bookingDate"));
			 bookInfo.setEventDate(request.getParameter("eventDate"));
			 bookInfo.setTimeSlot(request.getParameter("timeSlot"));
			 bookInfo.setPersons(Integer.parseInt(request.getParameter("persons")));
			 bookInfo.setCost(Float.parseFloat(request.getParameter("cost")));
			 String method=request.getParameter("method");
			 PrintWriter out=response.getWriter();
			 
			 ServiceProvider service=new ServiceProviderImpl();
			 int errorcode;
			 if(method==null)
				 method="uncheck";
			 if(method.equals("check"))
				 errorcode=service.checkBookingAvailability(bookInfo);
			 else
				 errorcode=service.insertBooking(bookInfo);
			 out.println(errorcode);
			 out.close();
			return null;
		}

}
