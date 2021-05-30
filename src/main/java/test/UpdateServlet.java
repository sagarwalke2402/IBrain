package test;
import java.io.*;
import java.sql.*;
//import java.text.SimpleDateFormat;
//import java.text.ParseException;
//import java.time.format.DateTimeParseException;
//import java.time.DateTimeException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.time.LocalDate;
import java.time.Period;
//import java.util.Calendar;
public class UpdateServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Sagar@2544");
			
			ps=con.prepareStatement("select * from patientinfo1");
			ResultSet rs=ps.executeQuery();
			pw.println("<br><a href='home.html'>Home</a><br><br>");

			while(rs.next())
			{
				
				String q=rs.getString(9);
				int PatID=rs.getInt(1);
			

				LocalDate l1=LocalDate.parse(q);
				LocalDate now1=LocalDate.now();
				Period diff1=Period.between(l1, now1);
				int Age=diff1.getYears();
				//pw.println("Patid"+PatID);
				//pw.println("age:"+diff1.getYears());
				//pw.println("Count"+age);
			
				if(Age<18)
				{
					String a;
					a="minor";
					ps=con.prepareStatement("update patientinfo1 set patientagegroup=a,age=Age where patid=PatID");
				}
				else
				{
					String b;
					b="adult";
					ps=con.prepareStatement("update patientinfo1 set patientagegroup=b,age=Age where patid=PatID");
				}	
			}
			pw.println("patient age and agegroup updated successfully in the database");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
}
		