<%@include file="header.jsp" %>
    
	<script type="text/javascript">
	 
	    $(document).ready(function () {
	 
	        $('#companyTableContainer').jtable({
	            title: 'Company List',
	            paging: true,
	            sorting: true,
	            defaultSorting: 'Name ASC',
	            actions: {
	                listAction: '/balaji/company/companyListByFiter',
	                deleteAction: '/balaji/company/deleteCompany',
	                updateAction: '/balaji/company/updateCompany',
	                createAction: '/balaji/company/createCompany'
	            },
	            fields: {
	                companyId: {
	                    key: true,
	                    create: false,
	                    edit: false,
	                    list: false
	                },
	                companyName: {
	                    title: 'Company Name',
	                    width: '23%'
	                }
	            }
	        });
	 
	        //Re-load records when company click 'load records' button.
	        $('#searchButton').click(function (e) {
	        	e.preventDefault();
	            $('#companyTableContainer').jtable('load', {
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

	<div id="companyTableContainer"></div>
</body>
</html>