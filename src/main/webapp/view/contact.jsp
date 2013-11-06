<%@include file="header.jsp" %>
    
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
	                    title: 'Department',
	                    options: '<c:url value="/department/departmentOptions" />',
	                    width: '23%'
	                },
	                companyId: {
	                    title: 'Company',
	                    options: '<c:url value="/company/companyOptions" />'
	                },
	                designationId: {
	                    title: 'Designation',
	                    options: '<c:url value="/designation/designationOptions" />'
	                },
	                sectionId: {
	                    title: 'Section',
	                    options: '<c:url value="/section/sectionOptions" />'
	                },
	                employeeId: {
	                    title: 'Employee Id'
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
	                officePhoneNumber: {
	                    title: 'Office Phone Number'
	                },
	                mobileNumber: {
	                    title: 'Mobile Number'
	                },
	                residencePhoneNumber: {
	                    title: 'Residence Phone Number'
	                },
	                emailAddress: {
	                    title: 'Email Address',
	                    type: 'email'
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
	<div class="filtering">
		<form>
			Name: <input type="text" name="name" id="name" /> 
			<button type="submit" id="searchButton">Search</button>
		</form>
	</div>

	<div id="contactTableContainer"></div>
</body>
</html>