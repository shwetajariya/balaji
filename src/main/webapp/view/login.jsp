<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Bharat Oman Refineries Limited Bina</title>

<link href="<c:url value="/css/login-box.css" />" rel="stylesheet"
	type="text/css" />
<!-- <div id="headerRendererDiv1"
	style="background-color: #dd4814; text-align: center;">
	<h1 style="margin-bottom: 0;">Bharat Oman Refineries Limited Bina</h1>
</div> -->

<script type="text/javascript">
	$(document).ready(function() {
	});
	function clear() {
		document.getElementById("loginName").value = "";
		document.getElementById("password").value = "";
	}
	function userid_validation() {
		var uid_len = String(document.getElementById("loginName")).length;

		if (uid_len == 0 || uid_len >= 15 || uid_len < 7) {
			alert("User Id should not be empty / length be between " + 7
					+ " to " + 15);
			document.getElementById('loginName').focus();
		}
		/* return true; */
	}
</script>
</head>

<body>

	<form action="<c:url value="/login/loginUser" />" method="post"
		name="frm1">
		<table align="center">
			<div style="padding: 100px 0 0 250px;">


				<div id="login-box">

					<H2>Login</H2>
					Bharat Oman Refineries Limited Bina <br /> <br />
					<div id="login-box-name" style="margin-top: 20px;">User Name:</div>
					<div id="login-box-field" style="margin-top: 20px;">
						<input type="text" name="loginName" class="form-login"
							title="Username" value="" size="30" maxlength="2048"
							id="loginName" />
					</div>
					<div id="login-box-name">Password:</div>
					<div id="login-box-field">
						<input name="password" id="password" type="password"
							class="form-login" title="Password" value="" size="30"
							maxlength="2048" />
					</div>
					<br /> <span class="login-box-options"><input
						type="checkbox" name="1" value="1"> Remember Me <a
							href="#" style="margin-left: 30px;">Forgot password?</a></span> <br />
					<br />
					<%-- <a href="" id="other"><img
						src="<c:url value="/image/login-btn.png" />" width="103"
						height="42" style="margin-left: 90px;" /></a> --%>
					<button type="submit"
						style="margin-left: 90px; background: url(
						./image/login-btn.png) no-repeat;"
						width="103" height="42" id="searchButton">Login</button>
				</div>

			</div>
			</form>
</body>
</html>
<%@include file="footer.jsp"%>
