<%@include file="header.jsp" %>
    
	<script type="text/javascript">
	 
	    $(document).ready(function () {
	 
	        $('#groupsTableContainer').jtable({
	            title: 'Groups List',
	            paging: true,
	            sorting: true,
	            defaultSorting: 'Name ASC',
	            actions: {
	                listAction: '<c:url value="/groups/groupsListByFiter" />',
	                deleteAction: '<c:url value="/groups/deleteGroups" />',
	                updateAction: '<c:url value="/groups/updateGroups" />',
	                createAction: '<c:url value="/groups/createGroups" />'
	            },
	            fields: {
	                groupId: {
	                    key: true,
	                    create: false,
	                    edit: false,
	                    list: false
	                },
	                groupName: {
	                    title: 'Groups Name',
	                    width: '23%'
	                }
	            }
	        });
	 
	        //Re-load records when groups click 'load records' button.
	        $('#searchButton').click(function (e) {
	        	e.preventDefault();
	            $('#groupsTableContainer').jtable('load', {
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

	<div id="groupsTableContainer"></div>
</body>
</html>