<%@include file="header.jsp" %>
    
	<script type="text/javascript">
	 
	</script>
</head>
<body>

<%@include file="menu.jsp" %>

	<div id="contentRendererDiv1" style="height:500px;width:700px;float:left;">
		<div>
			<form action="<c:url value="/smsMessage/sendSMSMessage" />">
				Message Text: <input type="text" name="messageText" id="messageText" /><br/> 
				
				Mobile Number: <input type="text" name="mobileNumber" id="mobileNumber" /><br/>
				
				Timeout In Minutes: <input type="text" name="timeoutMinutes" id="timeoutMinutes" /><br/> 
				
				Contacts: <select id="selectedContacts" name="selectedContacts" multiple="multiple">
					<c:forEach items="${contacts}" var="contact">
				        <option value="${contact.contactId}">${contact.contactName}</option>
				    </c:forEach>
				</select><br/> 
				
				Groups: <select id="selectedGroups" name="selectedGroups" multiple="multiple">
					<c:forEach items="${groups}" var="group">
				        <option value="${group.groupId}">${group.groupName}</option>
				    </c:forEach>
				</select><br/> 
				
				<button type="submit" id="postSMSButton">Send SMS</button>
			</form>
		</div>
	</div>

	<!--script>
		//Re-load records when company click 'load records' button.
	    $('#postSMSButton').click(function (e) {
	    	var cellNumber = '#mobileNumber'.valueOf();
	    	var smsText = '#messageText'.valueOf();
	    	
	    	alert(cellNumber);
	    	alert(smsText);
	    	
	    	var theURL = '<c:url value="/smsMessage/sendSMSMessage" />' + '?number=' + cellNumber + '&text=' + smsText;
	    	
	    	alert(theURL);
	    	
	    	var xmlHttp = new XMLHttpRequest();
	    	xmlHttp.open( "GET", theUrl, false );
	        xmlHttp.send( null );
	        alert(xmlHttp.responseText);
	        return xmlHttp.responseText;
	    });
	</script-->
<%@include file="footer.jsp" %>
