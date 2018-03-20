import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import servlets.LoanServlet;

public class TestLoanServlet extends Mockito{
	
	@Test
	public void servlet_should_not_compute_if_the_parameters_is_null() throws IOException{
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		LoanServlet servlet = new LoanServlet();
		
		when(request.getParameter("creditAmmount")).thenReturn(null);
		servlet.doPost(request, response);
		
		when(request.getParameter("creditPeriod")).thenReturn(null);
		servlet.doPost(request, response);
		
		when(request.getParameter("creditInterestRate")).thenReturn(null);
		servlet.doPost(request, response);
		
		when(request.getParameter("list")).thenReturn(null);
		servlet.doPost(request, response);
		
		verify(response).sendRedirect("/");
		
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		
					}
	@Test
	public void servlet_should_not_compute_if_the_parameters_is_not_numeric() throws IOException{
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);

		
		LoanServlet servlet = new LoanServlet();
		
		when(request.getParameter("creditAmmount")).thenReturn("not number");
		servlet.doPost(request, response);
		
		when(request.getParameter("creditPeriod")).thenReturn("not number");
		servlet.doPost(request, response);
		
		when(request.getParameter("creditInterestRate")).thenReturn("not number");
		servlet.doPost(request, response);
		
		verify(response).sendRedirect("/");
		
					}
	@Test
	public void servlet_should_compute_if_the_parameters_is_numeric() throws IOException{
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		
		LoanServlet servlet = new LoanServlet();
		
		when(request.getParameter("creditAmmount")).thenReturn("ok");
		servlet.doPost(request, response);
		
		when(request.getParameter("creditPeriod")).thenReturn("ok");
		servlet.doPost(request, response);
		
		when(request.getParameter("creditInterestRate")).thenReturn("ok");
		servlet.doPost(request, response);
		
		verify(response).sendRedirect("/");
		
					}
	
	
}