var cost;
var hotels;
var key;
var capacity;

$('#datepicker1').on('changeDate', function(ev){
    $(this).datepicker('hide');
});


function currentDateSetter(){

	
	
	
	 var today = new Date();
	 var dd = today.getDate();
	 var mm = today.getMonth()+1; //January is 0!
	 var yyyy = today.getFullYear();

	 if(dd<10) {
	     dd='0'+dd;
	 } 

	 if(mm<10) {
	     mm='0'+mm;
	 } 

	 today = dd+'-'+mm+'-'+yyyy;

	 $("#bookingDate").val(today);
	
	 }

$(document).ready(function(){
	 $("#Booking-Container").hide();
	 $("#BookingSuccessMessage").hide();

	 currentDateSetter();
	 $(".error-message").hide();
	  $.ajax({ 
		    url:'Cost.do',
		    datatype:'json',
		    success:function(data){
		    	hotels=data;
		    	key=$("#hotelSelectList option:first").val().substring(0,8);
		      	cost=hotels[key];
		    	capacity=hotels['capacity'+key];
		    	$("#hotelSelectList").val($("#hotelSelectList option:first").val());
		    }
	  });
	 	
});


$("#hotelSelectList").change(function(){
		
		key=$("#hotelSelectList option:selected" ).text().substring(0,8);
		cost=hotels[key];
		capacity=hotels['capacity'+key];
});

$("#persons").on('change keyup paste',function(){
	
	var persons=parseInt($(this).val());
	var totalCost=persons*cost;
	if($(this).val() =='')
		$("#cost").val("");
	
	else if(persons>capacity)
		{
			$(this).val(capacity);
			totalCost=capacity*cost;
			$("#cost").val(totalCost);
		}
	else
		$("#cost").val(totalCost);
	
});

function validate(){
	var validate=true;
	if($("#datePickerText").val()=='')
		{
		$("#date-error-message").show();
			validate=false;
		}
	else
		{
		
		$("#date-error-message").hide();}
	
	if($("#persons").val()=='')
	{
		$("#person-error-message").show();
			validate=false;
	}
	
	else
		$("#person-error-message").hide();
	
	return validate;

}

$("#MainBookButton").click(function(){
	 $("#Booking-Container").toggle();
	 if($(this).text()=="Book Now")
		 {
		 	$(this).text("Cancel Booking");
		 	$(this).addClass("btn-danger");
		 	$("#ClearButton").click();
		 }
	 else
	 	{
		 	$(this).text("Book Now");
		 	$(this).removeClass("btn-danger");
		 }
});



$("#BookingForm").submit(function(e)
		{
		    var postData = $(this).serializeArray();
		    var	formURL= $(this).attr("action");
		    $("#timeslot-unavalaible-message").hide();
		    $("#timeslot-full-message").hide();
		    $("#date-unavalaible-message").hide();
		    
		    $.ajax(
		    {
		        url : formURL,
		        type: "POST",
		        data : postData,
		        success:function(data) 
		        {
		        	if(data==400)
			        	{
			        	
			        			alert("Congratulations! The hotel was successfully booked");
			        			window.location.reload();
			        		
			        	}
			        	else if(data==300)
			        		$("#timeslot-unavalaible-message").show();
			        	else if(data==200)
			        		$("#timeslot-full-message").show();
			        	else 
			        		$("#date-unavalaible-message").show();
			        	
		        	
		        },
		        error: function(jqXHR, textStatus, errorThrown) 
		        {
		                  
		        }
		    });
		    e.preventDefault(); //STOP default action
	
		});
$("#ClearButton").click(function(){
	
	$("#hotelSelectList").val($("#hotelSelectList option:first").val());
	$('#datePickerText').val('');
	$("#timeSlot").val($("#timeSlot option:first").val());
	$("#persons").val('');
	
});

$("#CheckAvailable").click(function(){
	 var postData = $("#BookingForm").serializeArray();
	    var	formURL= $("#BookingForm").attr("action")+"?method=check";
	    $("#timeslot-unavalaible-message").hide();
	    $("#timeslot-full-message").hide();
	    $("#date-unavalaible-message").hide();
	    
	    $.ajax(
	    {
	        url : formURL,
	        type: "POST",
	        data : postData,
	        success:function(data) 
	        {
	        	if(data==400)
		        	{
		        		$("#OverallAvailable").show();
		        		
		        	}
		        	else if(data==300)
		        		$("#timeslot-unavalaible-message").show();
		        	else if(data==200)
		        		$("#timeslot-full-message").show();
		        	else 
		        		$("#date-unavalaible-message").show();
		        	
	        	
	        },
	        error: function(jqXHR, textStatus, errorThrown) 
	        {
	                  
	        }
	    });
	    e.preventDefault();
});