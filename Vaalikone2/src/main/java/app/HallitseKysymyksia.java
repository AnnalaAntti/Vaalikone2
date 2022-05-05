package app;

import java.io.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.Kysymys;

@WebServlet(urlPatterns = {"/addkysymys", "/deletekysymys","/updatekysymys","/readkysymys","/readtoupdatekysymys"})
public class HallitseKysymyksia extends HttpServlet {

	  @Override
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		  doGet(request, response);
	  }
	  
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
	  String action = request.getServletPath();
	  List<Kysymys> list=null;
	  switch (action) {
	  case "/addkysymys":
		  list=addkysymys(request);break;
	  case "/deletekysymys":
		  String id=request.getParameter("id");
		  list=deletekysymys(request);break;
	  case "/updatekysymys":
		  list=updatekysymys(request);break;
	  case "/readkysymys":
		  list=readkysymys(request);break;
	  case "/readtoupdatekysymys":
		  Kysymys k=readtoupdatekysymys(request);
		  request.setAttribute("kysymys", k);
		  RequestDispatcher rd=request.getRequestDispatcher("./jsp/kysymystoupdateform.jsp");
		  rd.forward(request, response);
		  return;
	  }
	  request.setAttribute("kysymykset", list);
	  RequestDispatcher rd=request.getRequestDispatcher("./jsp/kysymysform.jsp");
	  rd.forward(request, response);
  }

	private Kysymys readtoupdatekysymys(HttpServletRequest request) {
		String id=request.getParameter("id");
		String uri = "http://127.0.0.1:8080/rest/kysymyksetservice/readtoupdatekysymys/"+id;
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		Kysymys kysymys=b.get(Kysymys.class);
		return kysymys;
	}

	private List<Kysymys> addkysymys(HttpServletRequest request) {
		//A Fish object to send to our web-service 
		Kysymys k=new Kysymys(request.getParameter("kysymys"), request.getParameter("numero"));
		System.out.println(k);
		String uri = "http://127.0.0.1:8080/rest/kysymyksetservice/addkysymys";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Here we create an Entity of a Fish object as JSON string format
		Entity<Kysymys> e=Entity.entity(k,MediaType.APPLICATION_JSON);
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Kysymys>> genericList = new GenericType<List<Kysymys>>() {};
		
		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
		List<Kysymys> returnedList=b.post(e, genericList);
		return returnedList;
	}
	
	private List<Kysymys> readkysymys(HttpServletRequest request) {
		String id=request.getParameter("id");
		String uri = "http://127.0.0.1:8080/rest/kysymyksetservice/readkysymys";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Kysymys>> genericList = new GenericType<List<Kysymys>>() {};
		
		List<Kysymys> returnedList=b.get(genericList);
		return returnedList;
	}
	
	private List<Kysymys> updatekysymys(HttpServletRequest request) {
		//A Fish object to send to our web-service 
		Kysymys k=new Kysymys(request.getParameter("id"), request.getParameter("kysymys"), request.getParameter("numero"));
		System.out.println(k);
		String uri = "http://127.0.0.1:8080/rest/kysymyksetservice/updatekysymys";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Here we create an Entity of a Fish object as JSON string format
		Entity<Kysymys> e=Entity.entity(k,MediaType.APPLICATION_JSON);
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Kysymys>> genericList = new GenericType<List<Kysymys>>() {};
		
		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
		List<Kysymys> returnedList=b.put(e, genericList);
		return returnedList;
	}
	
	private List<Kysymys> deletekysymys(HttpServletRequest request) {
		String id=request.getParameter("id");
		String uri = "http://127.0.0.1:8080/rest/kysymyksetservice/deletekysymys/"+id;
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Kysymys>> genericList = new GenericType<List<Kysymys>>() {};
		
		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
		List<Kysymys> returnedList=b.delete(genericList);
		return returnedList;
	}
}