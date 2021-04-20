<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Login">

    <div class="container">
        <div id="login" class="flex-column flex-center">
            <c:if test="${message!= null}">
                <h1>
                    ${message}
                </h1>
            </c:if>
            <form  method="POST" action="j_security_check" class="add-newQuestion-form">                            
                <input type="text" name="j_username"  placeholder="Username" autofocus required>
                <input type="password" name="j_password"  placeholder="Password" required>
                <button class="btn" type="submit" name="loginBtn">Login</button>                
            </form>
        </div>
    </div>
</t:pageTemplate>
