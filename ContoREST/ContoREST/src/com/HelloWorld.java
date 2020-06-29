package com;

import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Movimento;
import dao.UpdateConto;

@Path("/helloworld")
public class HelloWorld {
			
			@POST
			@Path("/post")
			@Consumes(MediaType.APPLICATION_JSON)
			public Response createTrackInJSON(String id) {

				UpdateConto uc = new UpdateConto();
				uc.newConto(Integer.valueOf(id));
				String result = "Conto created";
				return Response.status(201).entity(result).build();

			} 

			@PUT
			@Path("/put")
			@Consumes(MediaType.APPLICATION_JSON)
			public Response updateContoInJSON(Movimento mov) {
				
				UpdateConto uc = new UpdateConto();
				if((mov.getOp().compareTo("0"))==0) {
				
					uc.entrate(Integer.valueOf(mov.getIdConto()), Double.valueOf(mov.getMov()));
				}
				else if((mov.getOp().compareTo("1"))==0) {
					
					uc.uscite(Integer.valueOf(mov.getIdConto()), Double.valueOf(mov.getMov()));
				}
				String result = "Conto updated";
				return Response.status(201).entity(result).build();
			}
			
}
