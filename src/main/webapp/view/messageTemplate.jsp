<%@include file="header.jsp" %>
    
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
	<div class="filtering">
		<form>
			Name: <input type="text" name="name" id="name" /> 
			<button type="submit" id="searchButton">Search</button>
		</form>
	</div>

	<div id="messageTemplateTableContainer"></div>
</body>
</html>