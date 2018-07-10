<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--  <c:if test="xxxx{cbs=='value' }">selected="selected"</c:if>
 xxxx{s.sex=="男"?"checked":""} 
 <c:if test="xxxx{fn:contains(s.kc, 'corojava')}">checked</c:if> 
 xxxx{u.dept.did==d.did?"selected":""}
 xxxx("form").serialize()  --%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/index2.css" type="text/css"></link>
<script type="text/javascript">
</script>
</head>
<title>列表</title>
</head>
<body >
	<table>
		<tr>
			<th colspan="11"></th>		
		</tr>
		<tr>
			<td></td>	
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="xxxx{list }" var="li" varStatus="p">
			<tr>
				<td>
				    <input type="checkbox" class="bx" value="xxxx{li.id }" >
				</td>
				<td>xxxx{p.index+1 }</td>
				<td>xxxx{li.name }</td>
				<td>xxxx{li.author }</td>
				<td>xxxx{li.cbs }</td>
				<td>xxxx{li.price }</td>
				<td>xxxx{li.zt }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>