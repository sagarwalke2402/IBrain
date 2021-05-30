package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Sagar@2544");
			PreparedStatement ps=con.prepareStatement("delete from appointmentinfo where amount<50");
			int k=ps.executeUpdate();
			pw.println("<br><a href='home.html'>Home</a><br><br><br>");

			if(k>=0)
			{
				pw.println("delete successfuly");
			}else
			{
				pw.println("Already deleted");
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
}
	