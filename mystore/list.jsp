<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="html" uri="/tags/struts-html" %>
<%@ taglib prefix="bean" uri="/tags/struts-bean" %>

<html>
<head>
<title>Добро пожаловать в магазин.</title>
</head>

<body>
<h1>Список товаров</h1>

<html:errors />

<table>
<thead>
<tr><c:forEach var="column" 
        items="Наименование товара,Цена,В наличии на складе,Заказать">
    <th><c:out value="${column}"/></th>
    </c:forEach>
</tr>
</thead>

<tbody>
<c:forEach var="item" items="${goods}">
<tr><td><c:out value="${item.name}"/></td>
    <td><c:out value="${item.price}"/></td>
    <td><c:out value="${item.quantity}"/></td>
    <td><html:form action="orderItem">
    <input type="hidden" name="id" value="<c:out value='${item.id}'/>"/>
    <html:text property="quantity"/>
    <html:submit />
    </html:form></td>
</tr>
</c:forEach>
</tbody>
</table>

<p><html:link page="/showCart.do">Перейти к корзине</html:link>
</p>		
</body>
</html>
