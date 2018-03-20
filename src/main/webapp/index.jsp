<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>

<body>

	<h2>Formularz do wyliczania rat kredytu.</h2>
	
	<form action= "loanrepaymant" method="post">
	
		Wnioskowana kwota kredytu (pln):
		<INPUT name="creditAmmount" value = ""></br>
		Ilosc rat (miesiecznych):
		<INPUT name="creditPeriod" value = ""></br>
		Oprocentowanie (%):
		<INPUT name="creditInterestRate" value = ""></br>
		Rodzaj rat:
		<SELECT id="list" name ="list">
		<OPTION VALUE = "stala">rata stala</OPTION>
		<OPTION VALUE = "malejaca">rata malejaca</OPTION>
		</SELECT></br>

		<INPUT TYPE = "submit" value = "oblicz" NAME = "oblicz">
		
	</form>

</body>
</html>