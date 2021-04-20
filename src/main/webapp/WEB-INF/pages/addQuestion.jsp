<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Adauga Intrebare">

    <div class="container">
        <div id="addQuestion" class="flex-column flex-center">
            <form  method="POST" action="${pageContext.request.contextPath}/AddNewQuestionServlet" class="add-newQuestion-form">
                <h1 id="smaller-font">Adaugati o intrebare noua</h1>                            
                <input type="text" name="question"  placeholder="Introduceti intrebarea" autofocus required>
                <input type="text" name="answer1"  placeholder="Raspunsul A" required>
                <input type="text" name="answer2"  placeholder="Raspunsul B" required>
                <input type="text" name="answer3"  placeholder="Raspunsul C" required>
                <input type="text" name="answer4"  placeholder="Raspunsul D" required>
                
                <label for="correctAnswer" id="answer-label">Alegeti raspunsul corect:</label>
                <select name="answer" id="correctAnswer" >
                    <option value="1">Raspunsul A</option>
                    <option value="2">Raspunsul B</option>
                    <option value="3">Raspunsul C</option>
                    <option value="4">Raspunsul D</option>
                </select>
                <button class="btn" type="submit" name="newQuestionBtn">Adaugă</button>
                <a href="${pageContext.request.contextPath}/QuestionsOperationsMenuServlet" class="btn-back">Renunță</a> 
            </form>
        </div>
    </div>
</t:pageTemplate>
