<html>
 	<body>
 	<head>
 		<link rel="stylesheet" href="resources/css/bootstrap.css" type="text/css">
 		<link rel="stylesheet" href="resources/css/Navbar.css" type="text/css">
 	</head>
 	
	<div class="navbar navbar-default navbar-fixed row" >
		
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>

			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav" id="myTab">
					<li class="tabs"><a href="Link.do?method=home">Home</a></li>
					<li class="tabs"><a href="Link.do?method=hotel">Hotels</a></li>
					<li class="tabs"><a  href="Link.do?method=myfavourite">My Favourites</a></li>
					<li class="tabs"><a  href="Link.do?method=booking" >Booking</a></li>
					<li class="tabs"><a  href="Link.do?method=signout">Signout</a></li>
				</ul>
			</div>
			
		</div>

	</div>
	<script src="resources/Js/jquery.js"></script>
	<script src="resources/Js/bootstrap.js"></script>
	<script>
	<script>
	$(document).ready(function () {
 		 $(".navbar-toggle").click(function(){
 			$(".navbar-collapse").collapse('hide');
 		 });
		$(".navbar-nav li a").click(function(event) {
   		 $(".navbar-collapse").collapse('hide');
  });
 		 
});

</script>
	</script>
	</body>
</html>