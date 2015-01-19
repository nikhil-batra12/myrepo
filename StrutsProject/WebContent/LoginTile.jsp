<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>


<html>
	<head>
		
		<link rel="stylesheet" href="resources/css/bootstrap.css" type="text/css">
		<link rel="stylesheet" href="resources/css/LoginTile.css" type="text/css">
	</head>
	<body>
	 <div class="tab-pane fade in row Login_form_body">
		<div class="container">
			<div class="row">
				<div class="col-xs-offset-1 col-xs-10  login_content">
					<h1>Login</h1>
					
					<form class="form-horizontal" action="login.do" method="post" >
						
						<div class="form-group">
							<div class="col-xs-offset-3 col-xs-6 col-sm-offset-4 col-sm-4">
								<input type="text" class="form-control" name="username" placeholder="Username"/>
							</div>
						</div>
						
						<div class="form-group">
								<div class="col-xs-offset-3 col-xs-6 col-sm-offset-4 col-sm-4">
									<input type="password" class="form-control" name="password" placeholder="Password"/>
								</div>
						</div>
					
						<div class="col-xs-offset-3 col-sm-offset-4 col-sm-4 col-xs-8 control-label submit_button_container" >
								<button type="submit" class="submit_button btn pull-left">Sign in</button>
								<button type="reset" class="clear_button btn btn-default pull-left">Clear</button>
						</div>
						
					</form>
					
				</div>
			</div>
		</div>
	</div>
	</body>
</html>