package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import Model.BookingForm;
import Model.HotelDVO;
import Service.ServiceProvider;
import Service.ServiceProviderImpl;

public class LinkAction extends DispatchAction{
	  
	public ActionForward home(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		
	        return mapping.findForward("Home");
	    }
	
	public ActionForward hotel(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
					ServiceProvider service=new ServiceProviderImpl();
					List<HotelDVO> hotelList;
					HttpSession session=request.getSession();
					 String userid=session.getAttribute("userid").toString();
					hotelList=service.fetchHotels(userid);
					request.setAttribute("hotelList", hotelList);
				
			        return mapping.findForward("Hotel");
    }
	
	public ActionForward myfavourite(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
					ServiceProvider service=new ServiceProviderImpl();
					List<HotelDVO> favHotelList;
					HttpSession session=request.getSession();
					 String userid=session.getAttribute("userid").toString();
					favHotelList=service.fetchFavourite(userid);
					request.setAttribute("FavHotelList", favHotelList);
					return mapping.findForward("Favourites");
    }
	
	public ActionForward booking(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
				HttpSession session=request.getSession();
				String userid=session.getAttribute("userid").toString();
				ServiceProvider service=new ServiceProviderImpl();
				List<String> selectList=service.selectHotelList();
				List<BookingForm> bookingInfo=service.fetchBooking(userid);
				request.setAttribute("BookingList", bookingInfo);
				request.setAttribute("selectHotelList", selectList);
				
        		return mapping.findForward("Booking");
    }
	
	public ActionForward signout(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        	HttpSession session=request.getSession();
        	session.invalidate();
        	return new ActionForward("LoginPage.jsp", true);
    }
}
