<%@ include file="/init.jsp" %>

<%-- Mode Scriplet  --%>
<p>
	Salut, je m'appelle <%= request.getAttribute("name") %>, j'ai <%= request.getAttribute("age") %> ans. (Mode Scriplet)
</p>

<%-- Mode EL --%>
<p>
	Salut, je m'appelle ${name}, j'ai ${age} ans. (Mode EL)
</p>

<%-- Boucle JSTL --%>
<p>
	<ul>
		Mes langages informatiques favoris sont :
		<c:forEach items="${favoriteLanguages}" var="favLang">
			<li>${favLang}</li>
		</c:forEach>
	</ul>
</p>