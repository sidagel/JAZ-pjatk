package servlets;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/pdf")
public class pdf extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.sendRedirect("/");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{/*
		int kwota = Integer.parseInt(request.getParameter("kwota"));
		int raty = Integer.parseInt(request.getParameter("ilosc"));
		float oproc = Float.parseFloat(request.getParameter("oproc"));
		int stala = Integer.parseInt(request.getParameter("stala"));

		float kapital = kwota / raty;
		*/
  		response.setContentType("application/pdf");
	//	response.setContentType("text/html");
		
		String[] NR;
		String[] KAPITAL;
		String[] ODSETKI;
		String[] STALA;
		String[] RATA;

		Document document = new Document();
	      try
	      {
	    	NR= request.getParameterValues("NR");
	    	KAPITAL= request.getParameterValues("KAPITAL");
	    	ODSETKI= request.getParameterValues("ODSETKI");
	    	STALA= request.getParameterValues("STALA");
	    	RATA= request.getParameterValues("RATA");
		
	        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
	        document.open();
	        
	        PdfPTable table = new PdfPTable(5); 
	        float[] columnWidths = {1f, 1f, 1f, 1f, 1f};
	        table.setWidths(columnWidths);
	        
	        PdfPCell cell1 = new PdfPCell(new Paragraph("Rata nr"));
	        cell1.setBorderColor(BaseColor.BLUE);
	        cell1.setPaddingLeft(10);
	        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        PdfPCell cell2 = new PdfPCell(new Paragraph("Kwota Kapitalu"));
	        cell2.setBorderColor(BaseColor.BLUE);
	        cell2.setPaddingLeft(10);
	        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        PdfPCell cell3 = new PdfPCell(new Paragraph("Kwota Odsetek"));
	        cell3.setBorderColor(BaseColor.BLUE);
	        cell3.setPaddingLeft(10);
	        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        PdfPCell cell4 = new PdfPCell(new Paragraph("Oplaty stale"));
	        cell4.setBorderColor(BaseColor.BLUE);
	        cell4.setPaddingLeft(10);
	        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        PdfPCell cell5 = new PdfPCell(new Paragraph("Calkowita rata"));
	        cell5.setBorderColor(BaseColor.BLUE);
	        cell5.setPaddingLeft(10);
	        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        table.addCell(cell1);
	        table.addCell(cell2);
	        table.addCell(cell3);
	        table.addCell(cell4);
	        table.addCell(cell5);

	    	for(int i = 0; i < NR.length; i++)
	    	{
	 	         cell1 = new PdfPCell(new Paragraph(NR[i]));
		         cell1.setBorderColor(BaseColor.BLUE);
		         cell1.setPaddingLeft(10);
		         cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		         cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		         cell2 = new PdfPCell(new Paragraph(KAPITAL[i]));
		         cell2.setBorderColor(BaseColor.BLUE);
		         cell2.setPaddingLeft(10);
		         cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		         cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		         cell3 = new PdfPCell(new Paragraph(ODSETKI[i]));
		         cell3.setBorderColor(BaseColor.BLUE);
		         cell3.setPaddingLeft(10);
		         cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		         cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		         cell4 = new PdfPCell(new Paragraph(STALA[i]));
		         cell4.setBorderColor(BaseColor.BLUE);
		         cell4.setPaddingLeft(10);
		         cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		         cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		         cell5 = new PdfPCell(new Paragraph(RATA[i]));
		         cell5.setBorderColor(BaseColor.BLUE);
		         cell5.setPaddingLeft(10);
		         cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		         cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
		         table.addCell(cell1);
		         table.addCell(cell2);
		         table.addCell(cell3);
		         table.addCell(cell4);
		         table.addCell(cell5);
	    	}

	        document.add(table);
	         
	        document.close();
	        writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	}
	
	private static final long serialVersionUID = 1L;

}
