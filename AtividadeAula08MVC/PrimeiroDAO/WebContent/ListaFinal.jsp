<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<body>
	<jsp:useBean id="dao" class="br.insper.edu.DAO"/>
	
	<table border="1">
		<tr>
			<td><b>#</b></td>
			<td><b>nome</b></td>
			<td><b>idade</b></td>
		</tr>
	
		<c:forEach var="pessoa" items="${dao.lista}" varStatus="id">
			<tr bgcolor="#${id.count%2 == 0 ? 'bbffcc' : 'ffffbb' }" >
				<td>${id.count}</td>
				<td>${pessoa.nome}</td>
				<td>${pessoa.idade}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>