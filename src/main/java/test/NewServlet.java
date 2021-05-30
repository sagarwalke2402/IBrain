package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class NewServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html"); 
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Sagar@2544");
			ps=con.prepareStatement("select count(*) as c,year(apptdate) as y,month(apptdate) as m from appointmentinfo group by year(apptdate),month(apptdate)");
			ResultSet rs=ps.executeQuery();
			
			pw.println("<html><head>");
			pw.println("</head><body>");
			
			pw.println("<br><a href='home.html'>Home</a><br><br>");

			pw.println("<table width='50%' height='40%' border='1'>");
			pw.println("<tr>");
			pw.println("<th>Number Of Appointments</th>");
			pw.println("<th>Year<th>");
			pw.println("<th>Month</th");
			pw.println("</tr>");
			while(rs.next())
			{
				int app=rs.getInt(1);
				int year=rs.getInt(2);
				int month=rs.getInt(3);
				pw.println("<tr>");
			
				pw.println("<td>"+app+"<td>");
				pw.println("<td>"+year+"<td>");
				pw.println("<td>"+month+"<td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
			

			pw.println("</body></html>");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
