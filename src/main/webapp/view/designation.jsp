<%@include file="header.jsp" %>
    
	<script type="text/javascript">
	 
	    $(document).ready(function () {
	 
	        $('#designationTableContainer').jtable({
	            title: 'Designation List',
	            paging: true,
	            sorting: true,
	            defaultSorting: 'Name ASC',
	            actions: {
	                listAction: '<c:url value="/designation/designationListByFiter" />',
	                deleteAction: '<c:url value="/designation/deleteDesignation" />',
	                updateAction: '<c:url value="/designation/updateDesignation" />',
	                createAction: '<c:url value="/designation/createDesignation" />'
	            },
	            fields: {
	                designationId: {
	                    key: true,
	                    create: false,
	                    edit: false,
	                    list: false
	                },
	                designation: {
	                    title: 'Designation',
	                    width: '23%'
	                }
	            }
	        });
	 
	        //Re-load records when designation click 'load records' button.
	        $('#searchButton').click(function (e) {
	        	e.preventDefault();
	            $('#designationTableContainer').jtable('load', {
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
			Designation: <input type="text" name="name" id="name" /> 
			<button type="submit" id="searchButton">Search</button>
		</form>
	</div>

	<div id="designationTableContainer"></div>
</body>
</html>