<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Successful">
    <div class="container">
        <div class="flex-column flex-center">
            <h1 id="green-text">Adăugare realizată cu succes</h1>
            <a href="${pageContext.request.contextPath}/AddNewQuestionServlet" class="btn">Adaugă încă o întrebare</a>         
            <a href="${pageContext.request.contextPath}" class="btn">Pagina principala</a>
        </div>
    </div>
</t:pageTemplate>