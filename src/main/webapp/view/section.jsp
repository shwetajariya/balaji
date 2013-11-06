<%@include file="header.jsp" %>
    
	<script type="text/javascript">
	 
	    $(document).ready(function () {
	 
	        $('#sectionTableContainer').jtable({
	            title: 'Section List',
	            paging: true,
	            sorting: true,
	            defaultSorting: 'Name ASC',
	            actions: {
	                listAction: '<c:url value="/section/sectionListByFiter" />',
	                deleteAction: '<c:url value="/section/deleteSection" />',
	                updateAction: '<c:url value="/section/updateSection" />',
	                createAction: '<c:url value="/section/createSection" />'
	            },
	            fields: {
	                sectionId: {
	                    key: true,
	                    create: false,
	                    edit: false,
	                    list: false
	                },
	                sectionName: {
	                    title: 'Section',
	                    width: '23%'
	                }
	            }
	        });
	 
	        //Re-load records when section click 'load records' button.
	        $('#searchButton').click(function (e) {
	        	e.preventDefault();
	            $('#sectionTableContainer').jtable('load', {
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
			Section: <input type="text" name="name" id="name" /> 
			<button type="submit" id="searchButton">Search</button>
		</form>
	</div>

	<div id="sectionTableContainer"></div>
</body>
</html>