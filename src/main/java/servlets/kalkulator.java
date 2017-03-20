package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/kalkulator")
public class kalkulator extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.sendRedirect("/");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		int kwota = Integer.parseInt(request.getParameter("kwota"));
		int raty = Integer.parseInt(request.getParameter("ilosc"));
		float oproc = Float.parseFloat(request.getParameter("oproc"));
		int stala = Integer.parseInt(request.getParameter("stala"));

		float kapital = kwota / raty;

		if(kwota == 0 || raty == 0 || oproc == 0 )
		{
			response.sendRedirect("/");
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<HTML><BODY>");
		out.print("<TABLE align=\"center\" border=\"1\">");
		out.print("<TR>");
		out.print("<TH>Rata nr</TH>");
		out.print("<TH>Kwota Kapitalu</TH>");
		out.print("<TH>Kwota Odsetek</TH>");
		out.print("<TH>Oplaty stale</TH>");
		out.print("<TH>Calkowita rata</TH>");
		out.print("</TR>");		
		if( request.getParameter("rata").equals("malejaca") )
		{
			int pozostala = kwota;
			
			for( int rata = 1;rata <= raty ;rata++,pozostala -= kapital)
			{
				float odsetki = ( (float)pozostala * ((float)oproc / 100))/12 ;
				out.print("<TR>");
				out.print("<TH>"+rata+"</TH>");
				out.print("<TH>"+kapital+"</TH>");
				out.print("<TH>"+odsetki+"</TH>");
				out.print("<TH>"+stala+"</TH>");
				out.print("<TH>"+ (kapital + odsetki + stala)+"</TH>");
				out.print("</TR>");		
			}
		}
		else if( request.getParameter("rata").equals("stala"))
		{
			/*
			 * rata = S * q^n * (q-1)/(q^n-1)
			 * S – kwota zaciągniętego kredytu
			 * n – ilość rat
			 * q – współczynnik równy 1 + (r / m), gdzie
			 * q^n – „q” do potęgi „n”
			 * r – oprocentowanie kredytu
			 * m – ilość rat w okresie dla którego obowiązuje oprocentowanie „r”. Najczęściej oprocentowanie podawanej jest w skali roku, a raty płacone są co miesiąc, więc „m” wtedy jest równe 12.
			 */
			double q = 1 + (((double)oproc/100)/12);
			double qn = Math.pow((double)q, (double)raty);
			
			double calkowita = (double)kwota * qn * ( q - 1) / ( qn - 1);

			for( int rata = 1; rata <= raty;rata++)
			{
				out.print("<TR>");
				out.print("<TH>"+rata+"</TH>");
				out.print("<TH>"+kapital+"</TH>");
				out.printf("<TH>%f",(calkowita - (double)kapital),"</TH>");
				out.print("<TH>"+stala+"</TH>");
				out.printf("<TH>%f",(calkowita + stala),"</TH>");			
				out.print("</TR>");		
			}
		}
		else
		{
		}
		out.print("</BODY></HTML>");
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
