<%-- <%@include file="header.jsp" %> --%>
<%@include file="newHeader.jsp" %>
<%@include file="leftSidebar.jsp" %>
    
	<script type="text/javascript">
	 
	    $(document).ready(function () {
	 
	        $('#contactTableContainer').jtable({
	            title: 'Contact List',
	            paging: true,
	            sorting: true,
	            defaultSorting: 'Name ASC',
	            //openChildAsAccordion: true, //Enable this line to show child tabes as accordion style
	            actions: {
	                listAction: '<c:url value="/contact/contactListByFiter" />',
	                deleteAction: '<c:url value="/contact/deleteContact" />',
	                updateAction: '<c:url value="/contact/updateContact" />',
	                createAction: '<c:url value="/contact/createContact" />'
	            },
	            fields: {
	                contactId: {
	                    key: true,
	                    create: false,
	                    edit: false,
	                    list: false
	                },
	                departmentId: {
	                    title: 'Dept.',
	                    options: '<c:url value="/department/departmentOptions" />',
	                    width: '23%'
	                },
	                companyId: {
	                    title: 'Company',
	                    options: '<c:url value="/company/companyOptions" />'
	                },
	                designationId: {
	                    title: 'Desig.',
	                    options: '<c:url value="/designation/designationOptions" />'
	                },
	                sectionId: {
	                    title: 'Section',
	                    options: '<c:url value="/section/sectionOptions" />'
	                },
	                employeeId: {
	                    title: 'Emp Id'
	                },
	                firstName: {
	                    title: 'First Name'
	                },
	                lastName: {
	                    title: 'Last Name'
	                },
	                priority: {
	                    title: 'Priority'
	                },
	                mobileNumber: {
	                    title: 'Mobile Number'
	                },
	                officePhoneNumber: {
	                    title: 'Office Phone Number',
	                    list: false
	                },
	                residencePhoneNumber: {
	                    title: 'Residence Phone Number',
	                    list: false
	                },
	                emailAddress: {
	                    title: 'Email Address',
	                    type: 'email',
	                    list: false
	                }
	            }
	        });
	 
	        //Re-load records when contact click 'load records' button.
	        $('#searchButton').click(function (e) {
	        	e.preventDefault();
	            $('#contactTableContainer').jtable('load', {
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

	&nbsp;&nbsp;&nbsp;<div id="contentRendererDiv1" style="height:500px;width:700px;float:left;">
		<div class="filtering">
			<form>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Name: <input type="text" name="name" id="name" /> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" id="searchButton">Search</button>
			</form>
		</div>
	
		&nbsp;&nbsp;&nbsp;<div id="contactTableContainer"></div>
	</div>

<%-- <%@include file="footer.jsp" %> --%>
<%-- <%@include file="rightSilder.jsp" %> --%>
<%@include file="newFooter.jsp" %>
