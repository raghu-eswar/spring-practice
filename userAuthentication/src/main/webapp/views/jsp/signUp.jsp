<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Sign up</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/styles/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="<%=request.getContextPath()%>/resources/script/script.js"></script>
</head>

<header>
    <div>
        <h1>WELCOME</h1>
    </div>
    <div><a href="Home">Log in</a></div>
</header>

<main>
    <div id="signup">
        <form method="POST" action="AddUser">
            <h2>SIGNUP</h2>
            <div class="form-input">
                <input type="text" name="firstName" placeholder="first name" class="form-input-field" pattern="^[A-Z][a-z]{2,}"
                    title="should contain only letters and starts with capital letter" required>
            </div>
            <div class="form-input">
                <input type="text" name="lastName" placeholder="last name" class="form-input-field" pattern="^[A-Z][a-z]{2,}"
                    title="should contain only letters and starts with capital letter">
            </div>
            <div class="form-input">
                <input type="email" name="email" placeholder="Email" class="form-input-field" required
                    pattern="^([a-zA-Z]+[a-zA-Z0-9\.-]+[a-zA-Z0-9]+)@([a-zA-Z]+).([a-z]){2,3}(.[a-z]{2,3})?$"
                    title="should be like --user name--@--domine name--">
            </div>
            <div class="form-input">
                <input type="password" name="password" placeholder="Password" class="form-input-field"  required
                    pattern="^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{5,}$"
                    title="must have at least 1 symbol and 1 number and 1 capital letter  ">
            </div>
            <div id="error-message">
                <%
                    if (request.getParameter("error") != null) {
                %>
                <%=request.getParameter("error")%>
                <%}%>
            </div>
            <div class="form-input"><input type="submit" value="submit" class="form-submit-button"></div>
        </form>
    </div>
</main>

</html>
