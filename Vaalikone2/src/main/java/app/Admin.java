package app;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/AdminNakyma"})
public class Admin extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    response.setContentType("text/plain;utf-8");
    PrintWriter out=response.getWriter();
    out.print("Tervetuloa admin n&auml;kym&auml;&auml;n!");
    
	RequestDispatcher rd=request.getRequestDispatcher("/jsp/AdminNakyma.jsp");
	rd.forward(request, response);
}

  }
