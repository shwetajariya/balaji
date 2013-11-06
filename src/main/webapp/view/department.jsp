<%@include file="header.jsp" %>
    
	<script type="text/javascript">
	 
	    $(document).ready(function () {
	 
	        $('#departmentTableContainer').jtable({
	            title: 'Department List',
	            paging: true,
	            sorting: true,
	            defaultSorting: 'Name ASC',
	            actions: {
	                listAction: '<c:url value="/department/departmentListByFiter" />',
	                deleteAction: '<c:url value="/department/deleteDepartment" />',
	                updateAction: '<c:url value="/department/updateDepartment" />',
	                createAction: '<c:url value="/department/createDepartment" />'
	            },
	            fields: {
	                departmentId: {
	                    key: true,
	                    create: false,
	                    edit: false,
	                    list: false
	                },
	                departmentName: {
	                    title: 'Department Name',
	                    width: '23%'
	                }
	            }
	        });
	 
	        //Re-load records when department click 'load records' button.
	        $('#searchButton').click(function (e) {
	        	e.preventDefault();
	            $('#departmentTableContainer').jtable('load', {
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

	<div id="departmentTableContainer"></div>
</body>
</html>