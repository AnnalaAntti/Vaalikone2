package rest;

import java.io.IOException;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


import data.Kysymys;

@Path("/kysymyksetservice")
public class KysymyksetService {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");
	
	@GET
	@Path("/readkysymys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymys> readKysymys() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Kysymys> list=em.createQuery("select k from Kysymys k").getResultList();		
		em.getTransaction().commit();
		return list;
	}	
	
	@GET
	@Path("/readallkysymys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readAllKysymys(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Kysymys> list=em.createQuery("select k from Kysymys k").getResultList();		
		em.getTransaction().commit();
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/readallkysymys.jsp");
		request.setAttribute("kysymykset", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	@POST
	@Path("/addkysymys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymys> addKysymys(Kysymys kysymys) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(kysymys);//The actual insertion line
		em.getTransaction().commit();
		//Calling the method readKysymys() of this service
		List<Kysymys> list=readKysymys();		
		return list;
	}	
	@PUT
	@Path("/updatekysymys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymys> updatekysymys(Kysymys kysymys) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Kysymys k=em.find(Kysymys.class, kysymys.getId()); //select * from fish where id=fish.getId()
		if (k!=null) {
			em.merge(kysymys);//The actual update line
		}
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		List<Kysymys> list=readKysymys();		
		return list;
	}	
	@DELETE
	@Path("/deletekysymys/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymys> deletekysymys(@PathParam("id") int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Kysymys k=em.find(Kysymys.class, id);
		if (k!=null) {
			em.remove(k);//The actual delete line
		}
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		List<Kysymys> list=readKysymys();		
		return list;
	}	
	@GET
	@Path("/deletekysymys/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteKysymysByGet(@PathParam("id") int id, 
			@Context HttpServletRequest request,
			@Context HttpServletResponse response
			) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Kysymys k=em.find(Kysymys.class, id);
		if (k!=null) {
			em.remove(k);//The actual delete line
		}
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		List<Kysymys> list=readKysymys();		
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/kysymysyllapito.jsp");
		request.setAttribute("kysymykset", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	@GET
	@Path("/readtoupdatekysymys/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Kysymys readToUpdateKysymys(@PathParam("id") int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Kysymys k=em.find(Kysymys.class, id);
		em.getTransaction().commit();
		return k;
	}
	@GET
	@Path("/kysymysyllapito")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void YllapitoKysymys(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Kysymys> list=em.createQuery("select k from Kysymys k").getResultList();		
		em.getTransaction().commit();
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/kysymysyllapito.jsp");
		request.setAttribute("kysymykset", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
