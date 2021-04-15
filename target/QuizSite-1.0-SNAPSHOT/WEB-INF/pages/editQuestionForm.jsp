<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Edit">

    <div class="container">
        <div id="editQuestion" class="flex-column flex-center">
            <form  method="POST" action="${pageContext.request.contextPath}/EditQuestionFormServlet" class="add-newQuestion-form">
                <h1 id="smaller-font">Completati campurile si salvati pentru a edita intrebarea</h1>                            
                <input type="text" name="question"  value="${question.question}" autofocus required>
                <input type="text" name="answer1"  value="${question.choice1}" required>
                <input type="text" name="answer2"  value="${question.choice2}" required>
                <input type="text" name="answer3"  value="${question.choice3}" required>
                <input type="text" name="answer4"  value="${question.choice4}" required>

                <label for="correctAnswer" id="answer-label">Alegeti raspunsul corect:</label>
                <select name="answer" id="correctAnswer" >                   
                    <option value="1" ${question.answer eq '1' ? ' selected' : ''}>Raspunsul A</option>
                    <option value="2" ${question.answer eq '2' ? ' selected' : ''}>Raspunsul B</option>
                    <option value="3" ${question.answer eq '3' ? ' selected' : ''}>Raspunsul C</option>
                    <option value="4" ${question.answer eq '4' ? ' selected' : ''}>Raspunsul D</option>
                </select>
                <input type="hidden" name="question_id" value="${question.id}"/>
                <button class="btn" type="submit" name="editedQuestionBtn">Salveaza Modificarile</button>
            </form>
        </div>
    </div>
</t:pageTemplate>

