<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:choose>
    <c:when test="${ items.size() != 0 }">
        <c:forEach var="row" items="${items}">
		    ${row.author}<br/>
		    ${row.title}<br/>
		</c:forEach>
    </c:when>    
    <c:otherwise>
        Aucune donnee a afficher 
        <br />
    </c:otherwise>
</c:choose>

</body>
</html>