package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ShowListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Sagar@2544");
			Statement st=con.createStatement();
			
			//PreparedStatement ps=con.prepareStatement("select * from doctorinfo");
			
			ResultSet rs=st.executeQuery("select * from patientinfo1,appointmentinfo where patientinfo1.patid=appointmentinfo.patid and apptdate<current_date()");
			pw.println("<html><head>");
			pw.println("</head><body>");
			pw.println("<br><a href='home.html'>Home</a><br><br>");
			pw.println("<table width='100%' height='90%' border='1'><tr><td>PatientID</td><td>PracticeID</td><td>LastName</td><td>FirstName</td><td>City</td><td>State</td><td>Gender</td><td>PatientAgeGroup</td><td>Birthdate</td><td>Age</td></tr>");
			
			while(rs.next())
					{
			

				int PID=rs.getInt(1);
				int PracticeID=rs.getInt(2);
				String LName=rs.getString(3);
				String FName=rs.getString(4);
				String City=rs.getString(5);
				String State=rs.getString(6);
				String Gender=rs.getString(7);
				String PatAgeGroup=rs.getString(8);
				String BD=rs.getString(9);
				String Age=rs.getString(10);
				
				
				//pw.println("<tr>");
				pw.println("<tr>");
				pw.println("<td>"+PID+"</td>");
				pw.println("<td>"+PracticeID+"</td>");
				pw.println("<td>"+LName+"</td>");
				pw.println("<td>"+FName+"</td>");
				pw.println("<td>"+City+"</td>");
				pw.println("<td>"+State+"</td>");
				pw.println("<td>"+Gender+"</td>");
				pw.println("<td>"+PatAgeGroup+"</td>");
				pw.println("<td>"+BD+"</td>");
				pw.println("<td>"+Age+"</td>");
				pw.println("</tr>");
				
					}
			
			pw.println("</table>");
			
			

			pw.println("</body></html>");
			//res.sendRedirect("home.html");
			//RequestDispatcher rd=req.getRequestDispatcher("home.html");
			//rd.forward(req, res);
		}
		catch(NullPointerException npe)
		{
			pw.println("don't pass null value");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
