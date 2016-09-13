package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class DownloadServlet extends HttpServlet
{
      public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
      {
                PrintWriter out=res.getWriter();
		String filename="abc.jpg";
                
                ServletContext ctx=getServletContext();
                String filepath=ctx.getRealPath("files");
                System.out.println("Path "+filepath);
                out.println("Path "+filepath);
                res.setContentType("APPLICATION/OCTET-STREAM");
                res.setHeader("Content-Disposition","attachement;filename="+filename);
                
                FileInputStream fileinputstream =new FileInputStream(filepath+"\\"+filename);
                int i;
                while((i=fileinputstream.read())!=-1)
                out.write(i);
                fileinputstream.close();
                out.close();
      }
}