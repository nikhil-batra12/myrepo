package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Service.ServiceProvider;
import Service.ServiceProviderImpl;

public class FavouriteAction extends org.apache.struts.action.Action{
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		 HttpSession session=request.getSession();
		 String userid=session.getAttribute("userid").toString();
		 ServiceProvider service=new ServiceProviderImpl();
		 boolean status=false;
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 String method=request.getParameter("method");
		 if(method.equals("Insert")){
			
			 status=service.insertFavourite(request.getParameter("hotelId"),userid);
		 }
		 else{
			 status=service.deleteFavourite(request.getParameter("hotelId"),userid);
		 }
			 
		 if(status){    
            out.println("Error");

        }
		 else {
			 out.println("Success");
        }
		return null;

	}

}
