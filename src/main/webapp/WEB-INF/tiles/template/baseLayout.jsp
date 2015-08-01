<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><tiles:insertAttribute name="title" /></title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="page-wrap">
			<header>
				<tiles:insertAttribute name="heading" />
			</header>
			<div class="wrapper">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<footer class="site-footer">
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</body>
</html>