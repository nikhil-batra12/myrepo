package Controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import Service.ServiceProvider;
import Service.ServiceProviderImpl;

public class CostAction extends org.apache.struts.action.Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
			 ServiceProvider service=new ServiceProviderImpl();
			 JSONObject jsoncost=service.costJSON();
			 response.setContentType("application/json;charset=utf-8");
			 PrintWriter out=response.getWriter();
			 out.println(jsoncost.toString());
	        out.close();
			return null;
		}
	}




