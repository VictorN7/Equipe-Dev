package br.senai.sp.calculotriangulo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resposta")
public class CalcArea extends HttpServlet{
	
	// tetess
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int tmpBase = Integer.parseInt (req.getParameter("campBase"));
		int tmpAlt = Integer.parseInt (req.getParameter("campAltura"));
		
		int resposta = tmpBase * tmpAlt / 2;
		
		PrintWriter html =  res.getWriter();          
		
		html.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"pt-br\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n"
				+ "    <link href=\"https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap\" rel=\"stylesheet\">\r\n"
				+ "    <title>Aula01 - Imersão_dev</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"pai\">\r\n"
				+ "        \r\n"
				+ "        <div class=\"filho\">\r\n"
				+ "            <h1>Qual a area do Triangulo ?📝📚💡</h1>\r\n"
				+ "\r\n"
				+ "            <form action=\"\">\r\n"
				+ "\r\n"
				+ "                <div>"
				+            + resposta +""
				+ "                </div>"
				+ "\r\n"
				+ "            </form>\r\n"
				+ "                \r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "    </div>\r\n"
				+ "    \r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		
		
		System.out.print(resposta);    
		
	}
	
}
