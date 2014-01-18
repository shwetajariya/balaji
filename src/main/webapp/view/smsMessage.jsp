<%@include file="newHeader.jsp" %>
<%@include file="leftSidebar.jsp" %>
	<script type="text/javascript">
	</script>
</head>
<body>
<%-- <%@include file="menu.jsp" %> --%>
	<div id="contentRendererDiv1" style="height:500px;width:700px;float:left;">
		<div>
			<form action="<c:url value="/smsMessage/sendSMSMessage" />" method="post">
				<table>
					<tr>
						<td colspan="1">Groups:</td>
						<td colspan="1">
							Choose from group of recipients...
							<div class="checkbox-container" title="Select the Groups">
								<c:forEach items="${groups}" var="group">
									<input type="checkbox" id="selectedGroups"
										name="selectedGroups" value="${group.groupId}" />${group.groupName}<br />
								</c:forEach>
							</div>
						</td>
						<td colspan="1">Contacts:</td>
						<td colspan="1">
							Choose recipients...
							<div class="checkbox-container"
								title="Select the individual Contacts">
								<c:forEach items="${contacts}" var="contact">
									<input type="checkbox" id="selectedContacts"
										name="selectedContacts" value="${contact.contactId}" />${contact.contactName}<br />
								</c:forEach>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="1">Mobile Numbers:</td>
						<td colspan="1">
							Type unsaved numbers...
							<textarea name="mobileNumbers" id="mobileNumbers"
								rows="2" cols="35"
								title="Comma separated list of mobile numbers to which the SMS needs to be sent.
						 		example:09999999999,08888888888,07777777777..."></textarea>
						</td>
					</tr>
					<tr>
						<td>Message Text:</td>
						<td>
							Type message here...
							<textarea name="messageText" id="messageText"
								rows="8" cols="35" maxlength="140"
								title="Type the message to be sent..."></textarea>
						</td>
						<td><button type="button" id="templateButton"> << Use </button></td>
						<td>
							Choose message template...
							<div class="checkbox-container" title="Select any template" >
								<c:forEach items="${templates}" var="template">
									<input type="radio" id="selectedTemplate"
										name="selectedTemplates" value="${template.templateId}" />${template.text}<br />
								</c:forEach>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="1">Timeout In Minutes:</td>
						<td colspan="3"><input type="text" name="timeoutMinutes" id="timeoutMinutes"
							title="Time in number of minutes after which the SMS sending process should be terminated." /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<button type="submit" id="postSMSButton">Send</button>
							<button type="reset" id="resetButton">Reset</button>
						</td>
					</tr>
				</table>
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
<%@include file="newFooter.jsp" %>