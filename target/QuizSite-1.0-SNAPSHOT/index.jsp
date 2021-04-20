<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Quiz">
    <div class="container">
        <div id="home" class="flex-column flex-center">
            <h1>Ești pregătit?</h1>            
            <a href="${pageContext.request.contextPath}/NewQuizServlet" class="btn">Începe</a>
            <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                <a href="${pageContext.request.contextPath}/QuestionsOperationsMenuServlet" class="btn">Administrează Întrebările</a> 
            </c:if>
        </div>
    </div>
</t:pageTemplate>

