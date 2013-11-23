<%-- <%@include file="header.jsp" %> --%>

<%@include file="newHeader.jsp" %>
<%@include file="leftSidebar.jsp" %>     
	<script type="text/javascript">
	 
	    $(document).ready(function () {
	 
	        $('#messageTemplateTableContainer').jtable({
	            title: 'MessageTemplate List',
	            paging: true,
	            sorting: true,
	            defaultSorting: 'Name ASC',
	            actions: {
	                listAction: '<c:url value="/messageTemplate/messageTemplateListByFiter" />',
	                deleteAction: '<c:url value="/messageTemplate/deleteMessageTemplate" />',
	                updateAction: '<c:url value="/messageTemplate/updateMessageTemplate" />',
	                createAction: '<c:url value="/messageTemplate/createMessageTemplate" />'
	            },
	            fields: {
	                templateId: {
	                    key: true,
	                    create: false,
	                    edit: false,
	                    list: false
	                },
	                text: {
	                    title: 'template text',
	                    width: '23%'
	                }
	            }
	        });
	 
	        //Re-load records when messageTemplate click 'load records' button.
	        $('#searchButton').click(function (e) {
	        	e.preventDefault();
	            $('#messageTemplateTableContainer').jtable('load', {
	                name: $('#name').val()
	            });
	        });
	 
	        //Load all records when page is first shown
	        $('#searchButton').click();
	    });
	 
	</script>
</head>
<body>

<%-- <%@include file="menu.jsp" %> --%>

	<div id="contentRendererDiv1" style="height:500px;width:700px;float:left;">
		<div class="filtering">
			<form>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Name: <input type="text" name="name" id="name" /> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" id="searchButton">Search</button>
			</form>
		</div>
	
		<div id="messageTemplateTableContainer"></div>
	</div>

<%@include file="newFooter.jsp" %>
