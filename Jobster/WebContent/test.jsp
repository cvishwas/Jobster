<%@ page import = "com.jster.beans.User, javax.servlet.*" %>
<html>
	<body>
		<h3>Test to Display if User was passed</h3>
		<%-- <%
		HttpSession sess = request.getSession(false);
		User sessUser = (User) sess.getAttribute("UserObj");
		out.print(sessUser);	
		%> --%>
		<h3>${UserObj}</h3>
</body>	


</html>