package test;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;
public class Exam extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Sagar@2544");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select transactioninfo.proceduretype,clinicinfo.clinicname,YEAR(appointmentinfo.apptdate) AS Y,MONTH(appointmentinfo.apptdate) AS M,appointmentinfo.amount from transactioninfo,appointmentinfo,clinicinfo where transactioninfo.clinicid=clinicinfo.clinicid AND clinicinfo.clinicid=appointmentinfo.clinicid group by clinicinfo.clinicname,YEAR(appointmentinfo.apptdate),MONTH(appointmentinfo.apptdate)");
		
			pw.println("<html>");
			pw.println("<head></head>");
			pw.println("<body>");
			
			pw.println("<br><a href='home.html'>Home</a><br><br>");

			pw.println("<table width='100%' height='100%' border='1'>");
			
			while(rs.next())
		{
			pw.println("<tr>");
			pw.println("<td>"+rs.getString(1)+"</td>");
			pw.println("<td>"+rs.getString(2)+"</td>");
			pw.println("<td>"+rs.getInt(3)+"</td>");
			pw.println("<td>"+rs.getInt(4)+"</td>");
			pw.println("<td>"+rs.getInt(5)+"</td>");
			pw.println("</tr>");
		}
			pw.println("</table>");
			pw.println("</body>");
			pw.println("</html>");

		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}