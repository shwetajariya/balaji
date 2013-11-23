<%-- <%@include file="header.jsp" %> --%>

<%@include file="newHeader.jsp" %>
<%@include file="leftSidebar.jsp" %>
    
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
<%-- <%@include file="menu.jsp" %> --%>

	<div id="contentRendererDiv1" style="height:500px;width:700px;float:left;">
		<div class="filtering">
			<form>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Name:Name: <input type="text" name="name" id="name" /> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Name:<button type="submit" id="searchButton">Search</button>
			</form>
		</div>
	
		<div id="groupsTableContainer"></div>
	</div>

<%@include file="newFooter.jsp" %>
