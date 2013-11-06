<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User Management</title>
	<!--c:set var="baseURL" value="${pageContext.servletContext.contextPath}" /-->
	
	<link href="/balaji/css/Site.css" rel="stylesheet" type="text/css" />
    <link href="/balaji/css/themes/metroblue/jquery-ui.css" rel="stylesheet" type="text/css" />
    <link href="/balaji/css/highlight.css" rel="stylesheet" type="text/css" />
    <!--link href="/balaji/jquery/jtable/themes/" + jTableStyle)" rel="stylesheet" type="text/css" /-->
    <link href="/balaji/jquery/jtable/themes/metro/blue/jtable.css")" rel="stylesheet" type="text/css" />

    <link href="/balaji/jquery/syntaxhighligher/styles/shCore.css" rel="stylesheet" type="text/css" />
    <link href="/balaji/jquery/syntaxhighligher/styles/shThemeDefault.css" rel="stylesheet" type="text/css" />
    
    <script src="/balaji/jquery/modernizr-2.6.2.js" type="text/javascript"></script>

    <script src="/balaji/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
    <script src="/balaji/jquery/jquery-ui-1.9.2.min.js" type="text/javascript"></script>

    <script src="/balaji/jquery/syntaxhighligher/shCore.js" type="text/javascript"></script>
    <script src="/balaji/jquery/syntaxhighligher/shBrushJScript.js" type="text/javascript"></script>
    <script src="/balaji/jquery/syntaxhighligher/shBrushXml.js" type="text/javascript"></script>
    <script src="/balaji/jquery/syntaxhighligher/shBrushCSharp.js" type="text/javascript"></script>
    <script src="/balaji/jquery/syntaxhighligher/shBrushSql.js" type="text/javascript"></script>

    <script src="/balaji/jquery/jtablesite.js" type="text/javascript"></script>
        
    <script type="text/javascript" src="/balaji/jquery/jtable/jquery.jtable.js"></script>
    
	<!--script src="/balaji/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
	<script src="/balaji/jquery/jquery-ui-1.9.2.min.js" type="text/javascript"></script>
	<script src="/balaji/jquery/jtable/jquery.jtable.js" type="text/javascript"></script-->

	<script type="text/javascript">
	 
	    $(document).ready(function () {
	 
	        $('#userTableContainer').jtable({
	            title: 'User List',
	            paging: true,
	            sorting: true,
	            defaultSorting: 'Name ASC',
	            actions: {
	                listAction: '/balaji/user/userListByFiter',
	                deleteAction: '/balaji/user/deleteUser',
	                updateAction: '/balaji/user/updateUser',
	                createAction: '/balaji/user/createUser'
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