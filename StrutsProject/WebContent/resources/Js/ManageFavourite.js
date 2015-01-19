function equalHeight(group) {    
    var tallest = 0;    
    group.each(function() {       
        var thisHeight = $(this).height();       
        if(thisHeight > tallest) {          
            tallest = thisHeight;       
        }    
    });    
    group.each(function() { $(this).height(tallest); });
} 
$(document).ready(function() {   
    equalHeight($(".thumbnail")); 
});

    $(".thumbanil").ready(function() {   
        equalHeight($(".thumbnail")); 
    });

$(".fav").click(function(){
	var hotelid=$(this).attr('id');
	var urlToSend;

	urlToSend="Favorite.do?hotelId="+hotelid+"&method=Delete";

	$.ajax({url:urlToSend,
		 type: 'GET',
		  dataType: 'html',
		  success:function(result){
			  $("#"+hotelid).parent().closest('.content-container').remove();
			  var numItems = $('.content-container').length;
	//		  window.location.reload();
			  if(numItems==0)
				  $("#No-fav").text("No Favourites");
			}
	 
		});
	});