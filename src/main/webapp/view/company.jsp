<%-- <%@include file="header.jsp" %> --%>
  
<%@include file="newHeader.jsp" %>
<%@include file="leftSidebar.jsp" %>
	<script type="text/javascript">
	 
	    $(document).ready(function () {
	 
	        $('#companyTableContainer').jtable({
	            title: 'Company List',
	            paging: true,
	            sorting: true,
	            defaultSorting: 'Name ASC',
	            actions: {
	                listAction: '<c:url value="/company/companyListByFiter" />',
	                deleteAction: '<c:url value="/company/deleteCompany" />',
	                updateAction: '<c:url value="/company/updateCompany" />',
	                createAction: '<c:url value="/company/createCompany" />'
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

<%-- <%@include file="menu.jsp" %> --%>

	<div id="contentRendererDiv1" style="height:500px;width:700px;float:left;">
		<div class="filtering">
			<form>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Name: <input type="text" name="name" id="name" /> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" id="searchButton">Search</button>
			</form>
		</div>
	
		<div id="companyTableContainer"></div>
	</div>

<%@include file="newFooter.jsp" %>
