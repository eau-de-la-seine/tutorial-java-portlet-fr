<%@ include file="/init.jsp" %>

<%-- render() | Mode Scriplet  --%>
<p>
	Salut, je m'appelle <%= request.getAttribute("name") %>, j'ai <%= request.getAttribute("age") %> ans. (Mode Scriplet)
</p>

<%-- render() | Mode EL --%>
<p>
	Salut, je m'appelle ${name}, j'ai ${age} ans. (Mode EL)
</p>

<%-- render() | Boucle JSTL --%>
<p>
	<ul>
		J'affiche mes langages informatiques favoris avec une boucle JSTL :
		<c:forEach items="${favoriteLanguages}" var="favLang">
			<li>${favLang}</li>
		</c:forEach>
	</ul>
</p>

<hr />
<hr />


<%-- Formulaires --%>
<p>
	Deux formulaires basiques :
</p>

<portlet:actionURL name="processAction" var="processAction" />
<portlet:actionURL name="formSentWithAlloy" var="formSentWithAlloy" />

<%-- processAction() | Formulaire --%>
<form method="post" action="<%= processAction %>">
	<label for="field1">Texte du formulaire : </label>
	<input id="field1" name="<portlet:namespace/>field1" type="text" />
	<input type="submit" value="Envoyer formulaire vers `processAction()`" />
</form>

<hr />

<%-- processAction() | Formulaire envoyé avec Alloy --%>
<aui:form method="post" action="<%= formSentWithAlloy %>">
	<aui:input name="field2" label="Texte du formulaire Alloy : " />
	<aui:button type="submit" value="Envoyer formulaire vers `formSentWithAlloy()`" />
</aui:form>