<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Formularz do wyliczania rat kredytu!
	<form action="kalkulator" method="post">
		<label>Wnioskowana kwota kredytu:<input type="number" id="kwota" name="kwota"/></label><br>
		<label>Ilosc rat:<input type="number" id="ilosc" name="ilosc"/></label><br>
		<label>Oprocentowanie:<input type="number" id="oproc" name="oproc"/></label><br>
		<label>Oplata stala:<input type="number" id="stala" name="stala"/></label><br>
		<label>Rodzaj rat :
			<select name="rata" >
				<option value="malejaca" >malejaca</option>
				<option value="stala" selected>stala</option>
			</select>
		</label><br>
		<input type="submit" value="Wyślij"/>
	</form>
</body>
</html>