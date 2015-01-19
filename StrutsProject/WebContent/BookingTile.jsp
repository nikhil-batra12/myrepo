<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="resources/css/datepicker.css" type="text/css">
</head>
<body>

<div class="col-xs-12" id="BookingHistoryContainer">
<div class="col-xs-offset-5"><h1>Booking History</h1></div>
 <div class="col-xs-offset-1 col-xs-10">
 	
 	<c:if test="${empty BookingList}">
 		<div class="col-xs-offset-3"><h1>No booking History Available</h1></div>
 	</c:if>
	<c:if test="${not empty BookingList}">
	<div>
	<table class="table table-condensed table-bordered table-responsive">
		<tr>
			<td>Booking Id</td>
			<td>Hotel Id</td>
			<td>Hotel Name</td>
			<td>Booking Date</td>
			<td>Event Date</td>
			<td>Time Slot</td>
			<td>Persons</td>
			<td>Cost</td>
		</tr>
		
	<c:forEach items="${BookingList}" var="hotel"> 
		<tr>
			<td><bean:write name="hotel" property="bookingId"/></td>	
			<td><bean:write name="hotel" property="hotelId"/></td>
			<td><bean:write name="hotel" property="hotelName"/></td>	
			<td><bean:write name="hotel" property="bookingDate"/></td>	
			<td><bean:write name="hotel" property="eventDate"/></td>
			<td><bean:write name="hotel" property="timeSlot"/></td>
			<td><bean:write name="hotel" property="persons"/></td>
			<td><bean:write name="hotel" property="cost"/></td>
		</tr>								 
	</c:forEach>
	</table>
	</div>
	</c:if>
</div>
</div>


<div class="col-xs-offset-5 col-xs-4 control-label" >
<button type="submit" class="btn btn-success pull-left" id="MainBookButton">Book Now</button>
</div>

<div class="cols-xs-12 tab-pane fade in row" id="Booking-Container">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
				
					<h2><center>Booking Form</center></h2><hr/>
					<form class="form-horizontal" id="BookingForm" onSubmit="return validate()" method="post" action="Book.do"  >
						<div class="form-group">
							<label for="Hotel" class="col-xs-offset-1 col-xs-3 control-label">Select Hotel</label>
							<div class="col-xs-5">
								<select class="form-control" name="hotelInfo" id="hotelSelectList">
									 <c:forEach items="${selectHotelList}" var="hotel"> 
											<option>${hotel }</option>									 
									 </c:forEach>
								</select>
								<span id="OverallAvailable" class="error-message">Booking is available</span>
							</div>
						</div>
						
						<div class="form-group">
							<label for="bookingDate" class="col-xs-offset-1 col-xs-3 control-label">Booking Date</label>
							<div class="col-xs-5">
								<input type="text" class="form-control" readonly="readonly" id="bookingDate" name="bookingDate"/>	
							</div>
						</div>
						
						<div class="form-group">
						<label for="DateTime" class="col-xs-offset-1 col-xs-3 control-label">Select Date</label>
						<div class="col-xs-5">
                			<div class='input-group date' id='datepicker1'>
			                    <input type='text' id="datePickerText" name="eventDate" class="form-control" placeholder="Select Date" />
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
			                    </span>
			                    
			                    
                			</div>
                			<span class="error-message" id="date-error-message">Date is required</span>
                			<span class="error-message" id="date-unavalaible-message">Booking not available. Please select other date.</span>
                			</div>
            			</div>
						<div class="form-group">
							<label for="Time Slot" class="col-xs-offset-1 col-xs-3 control-label">Time Slot</label>
							<div class="col-xs-5">
								<select class="form-control" id="timeSlot" name="timeSlot">
									<option>Slot 1(10am to 2pm)</option>
									<option>Slot 2(3pm to 7pm)</option>
									<option>Slot 3(8pm to 12am)</option>
									<option>Full day(12pm to 10pm)</option>
								</select>

							</div>
							<span class="error-message" id="timeslot-full-message">Time slot not available. Please select some other time slot.</span>
                			<span class="error-message" id="timeslot-unavalaible-message">Full day booking not available.</span>
                			
						</div>
						<div class="form-group">
							<label for="persons" class="col-xs-offset-1 col-xs-3 control-label">Number of persons</label>
							<div class="col-xs-5">
								<input type="text" class="form-control" placeholder="Enter Number of Persons" id="persons" name="persons"/>
								<span class="error-message" id="person-error-message">Persons is required</span>
							</div>
						</div>
						<div class="form-group">
							<label for="cost" class="col-xs-offset-1 col-xs-3 control-label">Total Cost</label>
							<div class="col-xs-5">
								<input type="text" class="form-control" readonly="readonly" id="cost" name="cost"/>
								
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-offset-4 col-md-offset-4 col-md-5 col-xs-8 control-label" >
								<button type="submit" class="btn btn-success pull-left">Book Now</button>
								<button style="margin-left:5px;" type="button" class="btn btn-warning pull-left" id="CheckAvailable">Check Availability</button>
								<button style="margin-left:5px;" type="button" class="btn btn-danger pull-left" id="ClearButton">Clear</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<script src="resources/Js/jquery.js"></script>
 	<script src="resources/Js/bootstrap.js"></script>
  	<script src="resources/Js/bootstrap-datepicker.js"></script>
    <script src="resources/Js/BookingFormManager.js"></script>
    <script type="text/javascript">
    $(function () {
    	$(document).ready(function() {
    	    $('#datepicker1').datepicker({
    	    	format: 'dd-mm-yyyy'
    	    });
    
    	});
    });
    </script>
</body>
 	
</html>