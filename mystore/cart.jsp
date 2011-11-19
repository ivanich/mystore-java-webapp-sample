<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="html" uri="/tags/struts-html" %>
<%@ taglib prefix="bean" uri="/tags/struts-bean" %>

<html>
<head>
<title>�������</title>
</head>
<body>
<h1>�������</h1>

<table>
<thead>
<tr><c:forEach var="column" 
        items="�����,��������">
    <th><c:out value="${column}"/></th>
    </c:forEach>
</tr>
</thead>

<tbody>
<c:forEach var="item" items="${cart}">
<tr><td><c:out value="${item.id}"/></td>
    <td><c:out value="${item.quantity}"/></td>
</tr>
</c:forEach>
</tbody>
</table>

<p><html:link page="/listItems.do">������� � ������ �������</html:link>
</p>		
</body>
</html>
