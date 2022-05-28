<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Hello World</title>
<!-- Add some CSS to change client UI -->
<style>
body {
	background-color: #232F3E;
}

label, button {
	color: #FF9900;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 20px;
	margin-left: 40px;
}

input {
	color: #232F3E;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 20px;
	margin-left: 20px;
}
</style>
</head>
<body>
	<form action="send" method="get">
		<label>First Name :</label> <input type="text" id="fNameinput" name="fNameinput">
		<label>Last Name :</label> <input type="text"  id="lNameinput" name="lNameinput">
		<button type="submit"
			onclick="callSQS(document.getElementById('fNameinput').value,document.getElementById('lNameinput').value)">Call
			SQS</button>

	</form>
	<script type="text/javascript">
 var callSQS = (firstName,lastName)=>{
	 alert("Hello from Lambda, "+ firstName + " "+lastName );
     };
</script>
</body>
</html>