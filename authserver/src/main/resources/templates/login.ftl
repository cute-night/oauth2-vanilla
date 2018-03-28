<html>
<head>
<link rel="stylesheet" type="text/css"
  href="webjars/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="webjars/jquery/jquery.min.js"></script>
<script type="text/javascript"
  src="webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<#if RequestParameters['error']??>
	<div class="alert alert-danger">
		登录信息错误，请重试
	</div>
</#if>
	<div class="container">
		<form role="form" action="login" method="post">
		  <div class="form-group">
		    <label for="username">Username:</label>
		    <input type="text" class="form-control" id="username" name="username"/>
		  </div>
		  <div class="form-group">
		    <label for="password">Password:</label>
		    <input type="password" class="form-control" id="password" name="password"/>
		  </div>
		  <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>