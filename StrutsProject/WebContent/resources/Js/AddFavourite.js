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
	var value=$(this).text();
	var urlToSend;


	if(value==="Add to Favourites")
		{
			urlToSend="Favorite.do?hotelId="+hotelid+"&method=Insert";
		}
	else
			urlToSend="Favorite.do?hotelId="+hotelid+"&method=Delete";

	$.ajax({url:urlToSend,
		 type: 'GET',
		  dataType: 'html',
		  success:function(result){
			 
			  if(value==="Add to Favourites")
				  $('#'+hotelid).text("Remove from Favourites");
			  else
				  $('#'+hotelid).text("Add to Favourites");
			}
	 
		});
	});