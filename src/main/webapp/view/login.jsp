<%@include file="header.jsp"%>

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
<!-- onblur="userid_validation();" -->
<div id="headerRendererDiv1"
	style="background-color: #dd4814; text-align: center;">
	<h1 style="margin-bottom: 0;">Bharat Oman Refineries Limited Bina</h1>
</div>
</head>
<body>
	<div id="contentRendererDiv1"
		style="height: 500px; width: 700px; float: left; margin: 100px auto 0 auto;">
		<form action="<c:url value="/login/loginUser" />" method="post">
			<table align="center">
				<tr>
					<td>Login id:</td>
					<td><input type="text" name="loginName" id="loginName" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="left"><font color="red">${message}</font></td>
				</tr>
				<tr>
					<td><button type="submit" id="loginButton">Login</button></td>
					<td><button type="submit" id="clear" onclick='clear();'>Clear</button></td>
				</tr>
			</table>
		</form>
	</div>

	<%@include file="footer.jsp"%>