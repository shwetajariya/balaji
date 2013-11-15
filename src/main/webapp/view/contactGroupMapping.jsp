<%@include file="header.jsp" %>
    
	<script type="text/javascript">
	 
	    $(document).ready(function () {
	 
	        $('#contactGroupMappingTableContainer').jtable({
	            title: 'ContactGroupMapping List',
	            paging: true,
	            sorting: true,
	            defaultSorting: 'Name ASC',
	            actions: {
	                listAction: '<c:url value="/contactGroupMapping/contactGroupMappingListByFiter" />',
	                deleteAction: '<c:url value="/contactGroupMapping/deleteContactGroupMapping" />',
	                updateAction: '<c:url value="/contactGroupMapping/updateContactGroupMapping" />',
	                createAction: '<c:url value="/contactGroupMapping/createContactGroupMapping" />'
	            },
	            fields: {
	            	contactGroupMappingId: {
	                    key: true,
	                    create: false,
	                    edit: false,
	                    list: false
	                },
	                groups: {
	                    title: 'Group Name',
	                    options: '<c:url value="/groups/groupsOptions" />',
		                width: '23%'
	                },
	                contact: {
	                	title: 'Contact',
	                	options: '<c:url value="/contact/contactOptions" />',
	                    width: '23%'
	                }
	            }
	        });
	 
	        //Re-load records when contactGroupMapping click 'load records' button.
	        $('#searchButton').click(function (e) {
	        	e.preventDefault();
	            $('#contactGroupMappingTableContainer').jtable('load', {
	                name: $('#name').val()
	            });
	        });
	 
	        //Load all records when page is first shown
	        $('#searchButton').click();
	    });
	 
	</script>
</head>
<body>

<%@include file="menu.jsp" %>

	<div id="contentRendererDiv1" style="height:500px;width:700px;float:left;">
		<div class="filtering">
			<form>
				Name: <input type="text" name="name" id="name" /> 
				<button type="submit" id="searchButton">Search</button>
			</form>
		</div>
	
		<div id="contactGroupMappingTableContainer"></div>
	</div>

<%@include file="footer.jsp" %>
