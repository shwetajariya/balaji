<%@include file="header.jsp" %>
    
	<script type="text/javascript">
	 
	    $(document).ready(function () {
	 
	        $('#userTableContainer').jtable({
	            title: 'User List',
	            paging: true,
	            sorting: true,
	            defaultSorting: 'Name ASC',
	            actions: {
	                listAction: '<c:url value="/user/userListByFiter" />',
	                deleteAction: '<c:url value="/user/deleteUser" />',
	                updateAction: '<c:url value="/user/updateUser" />',
	                createAction: '<c:url value="/user/createUser" />'
	            },
	            fields: {
	                userId: {
	                    key: true,
	                    create: false,
	                    edit: false,
	                    list: false
	                },
	                loginName: {
	                    title: 'Login Name',
	                    width: '23%'
	                },
	                firstName: {
	                    title: 'First Name',
	                    width: '23%'
	                },
	                lastName: {
	                    title: 'Last Name',
	                    width: '23%'
	                },
	                password: {
	                    title: 'User Password',
	                    type: 'password',
	                    list: false
	                },
	                emailAddress: {
	                    title: 'Email address',
	                    list: false
	                }
	            }
	        });
	 
	        //Re-load records when user click 'load records' button.
	        $('#searchButton').click(function (e) {
	        	e.preventDefault();
	            $('#userTableContainer').jtable('load', {
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

	<div id="userTableContainer"></div>
</body>
</html>