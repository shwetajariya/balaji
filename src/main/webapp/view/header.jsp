<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User Management</title>
	<!--c:set var="baseURL" value="${pageContext.servletContext.contextPath}" /-->
	
	<link href="<c:url value="/css/Site.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/css/themes/metroblue/jquery-ui.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/css/highlight.css" />" rel="stylesheet" type="text/css" />
    <!--link href="<c:url value="/jquery/jtable/themes/" />" + jTableStyle)" rel="stylesheet" type="text/css" /-->
    <!--link href="<c:url value="/jquery/jtable/themes/metro/blue/jtable.css" />")" rel="stylesheet" type="text/css" /-->
    <link href="<c:url value="/jquery/jtable/themes/metro/blue/jtable.css" />" rel="stylesheet" type="text/css" />

    <link href="<c:url value="/jquery/syntaxhighligher/styles/shCore.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/jquery/syntaxhighligher/styles/shThemeDefault.css" />" rel="stylesheet" type="text/css" />
    
    <script src="<c:url value="/jquery/modernizr-2.6.2.js" />" type="text/javascript"></script>

    <script src="<c:url value="/jquery/jquery-1.9.0.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/jquery/jquery-ui-1.9.2.min.js" />" type="text/javascript"></script>

    <script src="<c:url value="/jquery/syntaxhighligher/shCore.js" />" type="text/javascript"></script>
    <script src="<c:url value="/jquery/syntaxhighligher/shBrushJScript.js" />" type="text/javascript"></script>
    <script src="<c:url value="/jquery/syntaxhighligher/shBrushXml.js" />" type="text/javascript"></script>
    <script src="<c:url value="/jquery/syntaxhighligher/shBrushCSharp.js" />" type="text/javascript"></script>
    <script src="<c:url value="/jquery/syntaxhighligher/shBrushSql.js" />" type="text/javascript"></script>

    <script src="<c:url value="/jquery/jtablesite.js" />" type="text/javascript"></script>
        
    <script type="text/javascript" src="<c:url value="/jquery/jtable/jquery.jtable.js" />"></script>
    
    <style>
		.ui-menu {
			width: 200px;
			background-color:#FF9640;
		}
		
		div.checkbox-container {
			border:2px solid #ccc;
			width:300px;
			height: 150px;
			overflow-y: scroll;
		}
		
		div.content-renderer {
			
		}
	</style>
    
    