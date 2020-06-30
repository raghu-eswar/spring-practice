<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Home</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/styles/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="<%=request.getContextPath()%>/resources/script/script.js"></script>
</head>

<header>
    <div>
        <h1>WELCOME</h1>
    </div>
    <div>
        <div><a href="SignUp">Sign up</a></div>
    </div>
</header>

<main>
    <div class="success-message">
        <%
            if (request.getParameter("message") != null) {
        %>
            <%=request.getParameter("message")%>
            <%}%>
    </div>
    <div id="login">
        <form method="POST" action="Validate">
            <h2>LOGIN</h2>
            <div id="lock-icon"><i class="fa fa-lock"></i></div>
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
            <div class="form-input"><input type="submit" value="Log in" class="form-submit-button"></div>
        </form>
    </div>
</main>

</html>