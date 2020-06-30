<%@ page import="com.bridgelabz.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Profile</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/styles/styles.css">
    <script src="<%=request.getContextPath()%>/resources/script/script.js"></script>
</head>

<body>

<header>
    <div>
        <h1>WELCOME</h1>
    </div>
    <div>
        <div><a href="">Log out</a></div>
    </div>
</header>

<main>
    <div id="user-info">
        <form action="UpdateProfile" method="POST">
            <h2>PROFILE</h2>
            <div class="form-input"><label>First Name</label><input type="text" value=${user.firstName} name="FirstName" placeholder="Email" class="blocked-input-field"></div>
            <div class="form-input"><label>Last Name</label><input type="text" value=${user.lastName} name="LastName" placeholder="Email" class="blocked-input-field"></div>
            <div class="form-input"><label>Email id</label><input type="text" value=${user.email} name="email" placeholder="Email" class="blocked-input-field"></div>
            <div class="form-input"><input type="submit" value="save" class="user-info-submit-button" disabled></div>
        </form>
        <div class="form-input"><input type="button" value="edit" class="user-info-submit-button" onclick="enableEditProfile()"></div>
    </div>
</main>

</body>

</html>