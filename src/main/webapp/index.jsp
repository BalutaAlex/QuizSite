<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Quiz">
    <div class="container">
        <div id="home" class="flex-column flex-center">
            <h1>Ești pregătit?</h1>            
            <a href="${pageContext.request.contextPath}/NewQuizServlet" class="btn">Începe</a>         
            <a href="${pageContext.request.contextPath}/QuestionsOperationsMenuServlet" class="btn">Manage questions</a>                         
        </div>
    </div>
</t:pageTemplate>
