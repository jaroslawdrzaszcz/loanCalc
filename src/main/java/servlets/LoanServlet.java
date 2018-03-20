package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loanrepaymant")
public class LoanServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		double creditAmmount = Double.parseDouble(request.getParameter("creditAmmount"));
		int creditPeriod = Integer.parseInt(request.getParameter("creditPeriod"));
		double creditInterestRate = Double.parseDouble(request.getParameter("creditInterestRate"));
		
			if(creditAmmount==0 || creditPeriod==0 || creditInterestRate==0)
			{
				response.sendRedirect("/");
			}
		
		String list =	request.getParameter("list");
		
		PrintWriter out = response.getWriter();
						
		if(list.equals("stala"))
		{	response.setContentType("text/html");
			out.println("Wnioskowana kwota kredytu: "+ creditAmmount + "</br>");
			out.println("Ilosc rat: " + creditPeriod + "</br>");
			out.println("Oprocentowanie: " + creditInterestRate + " % </br>");
			out.println("Rodzaj rat: "+ request.getParameter("list") + "</br>");

		
		double q = 1+(creditInterestRate/1200);
		double instalment = (creditAmmount * (Math.pow(q, (creditPeriod)))*(q-1)/(Math.pow(q, (creditPeriod))-1));
		
			out.println("<h4>Calkowita kwota do splaty: " + Math.round(instalment*creditPeriod*100)/100.0 + " PLN.</h4>");
					
		out.println("<table border='1'> <tr> <th>Nr raty</th><th>Kwota kapitalu</th> <th>Kwota odsetek</th><th>Calkowita kwota raty</th> </tr>");
		
		for (int i = 1;i<=(creditPeriod);i++)
		
		{
			double interst = creditAmmount*creditInterestRate/100;
			double creditCapital = instalment-interst;
			creditAmmount = creditAmmount - creditCapital;
			out.println(" <tr> <td align='center'>"+i+"</td> <td align='center'>"+Math.round(creditCapital*100)/100.0+"</td> <td align='center'>"+Math.round(interst*100)/100.0+"</td> <td align='center'>"+Math.round(instalment*100)/100.0+"</td> </tr>");
		}
		
		
		}	
		else
			//malejace
		{	response.setContentType("text/html");
			out.println("Wnioskowana kwota kredytu: "+ creditAmmount + "</br>");
			out.println("Ilosc rat: " + creditPeriod + "</br>");
			out.println("Oprocentowanie: " + creditInterestRate + " % </br>");
			out.println("Rodzaj rat: "+ request.getParameter("list") + "</br>");
		
		double creditCapital = creditAmmount/(creditPeriod);
		
		double sum = 0;
		out.println("<table border='1'> <tr> <th>Nr raty</th><th>Kwota kapitalu</th> <th>Kwota odsetek</th><th>Calkowita kwota raty</th> </tr>");

		for (int i = 1;i<=(creditPeriod);i++)
			
		{
			double interst = ((creditAmmount-(i-1)*creditCapital)/12)*creditInterestRate/(100);
			out.println(" <tr> <td align='center'>"+i+"</td> <td align='center'>"+Math.round(creditCapital*100)/100.0+"</td> <td align='center'>"+Math.round(interst*100)/100.0+"</td> <td align='center'>"+Math.round((creditCapital+interst)*100)/100.0+"</td> </tr>");
			sum+=(creditCapital+interst);
		}
		
		out.println("<h4>Calkowita kwota do splaty: " + Math.round(sum*100)/100.0 + " PLN.</h4>");
			
		}		
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		double creditAmmount = Double.parseDouble(request.getParameter("creditAmmount"));
		int creditPeriod = Integer.parseInt(request.getParameter("creditPeriod"));
		double creditInterestRate = Double.parseDouble(request.getParameter("creditInterestRate"));
		
			if(creditAmmount==0 || creditPeriod==0 || creditInterestRate==0)
			{
				response.sendRedirect("/");
			}
		
		String list =	request.getParameter("list");
		
		PrintWriter out = response.getWriter();
						
		if(list.equals("stala"))
		{	response.setContentType("text/html");
			out.println("Wnioskowana kwota kredytu: "+ creditAmmount + "</br>");
			out.println("Ilosc rat: " + creditPeriod + "</br>");
			out.println("Oprocentowanie: " + creditInterestRate + " % </br>");
			out.println("Rodzaj rat: "+ request.getParameter("list") + "</br>");
		
		double q = 1+(creditInterestRate/1200);
		double instalment = (creditAmmount * (Math.pow(q, (creditPeriod)))*(q-1)/(Math.pow(q, (creditPeriod))-1));
		
			out.println("<h4>Calkowita kwota do splaty: " + Math.round(instalment*creditPeriod*100)/100.0 + " PLN.</h4>");
					
		out.println("<table border='1'> <tr> <th>Nr raty</th><th>Kwota kapitalu</th> <th>Kwota odsetek</th><th>Calkowita kwota raty</th> </tr>");
		
		for (int i = 1;i<=(creditPeriod);i++)
		
		{
			double interst = creditAmmount*creditInterestRate/1200;
			double creditCapital = instalment-interst;
			creditAmmount = creditAmmount - creditCapital;
			out.println(" <tr> <td align='center'>"+i+"</td> <td align='center'>"+Math.round(creditCapital*100)/100.0+"</td> <td align='center'>"+Math.round(interst*100)/100.0+"</td> <td align='center'>"+Math.round(instalment*100)/100.0+"</td> </tr>");
		}
		
		
		}	
		//malejace
		else
		{	response.setContentType("text/html");
			out.println("Wnioskowana kwota kredytu: "+ creditAmmount + "</br>");
			out.println("Ilosc rat: " + creditPeriod + "</br>");
			out.println("Oprocentowanie: " + creditInterestRate + " % </br>");
			out.println("Rodzaj rat: "+ request.getParameter("list") + "</br>");
		
		double creditCapital = creditAmmount/(creditPeriod);
		
		double sum = 0;
		out.println("<table border='1'> <tr> <th>Nr raty</th><th>Kwota kapitalu</th> <th>Kwota odsetek</th><th>Calkowita kwota raty</th> </tr>");

		for (int i = 1;i<=(creditPeriod);i++)
			
		{
			double interst= ((creditAmmount-(i-1)*creditCapital)/12)*creditInterestRate/(100);
			out.println(" <tr> <td align='center'>"+i+"</td> <td align='center'>"+Math.round(creditCapital*100)/100.0+"</td> <td align='center'>"+Math.round(interst*100)/100.0+"</td> <td align='center'>"+Math.round((creditCapital+interst)*100)/100.0+"</td> </tr>");
			sum+=(creditCapital+interst);
		}
		
		out.println("<h4>Calkowita kwota do splaty: " + Math.round(sum*100)/100.0 + " PLN.</h4>");
			
				
		}		
			
		}


}
