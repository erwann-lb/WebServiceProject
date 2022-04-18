package com.service.labmembers.resource;

import java.net.URI;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.service.labmembers.ScientistFunctions;
import com.service.labmembers.data.Laboratory;
import com.service.labmembers.data.Scientist;
import com.service.labmembers.service.LaboratoryService;

@Path("/Laboratories")
public class LaboratoryResource {
	
	LaboratoryService laboratoryService = new LaboratoryService();
	ScientistFunctions scientistFunctions = new ScientistFunctions();

	@Context
	UriInfo uriInfo;
	
	@POST
	  @Consumes(MediaType.APPLICATION_XML)
	  @Produces(MediaType.APPLICATION_XML)
	  public Response addLaboratory(String name, String specialty, int money, int nbEmployees) {
	    Laboratory laboratory = laboratoryService.addLaboratory(name, specialty, money, nbEmployees);
	    if(laboratory == null) {
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    URI uri = uriInfo.getRequestUri();
	    String newUri = uri.getPath() + "/" + laboratory.getId();
	    return Response.status(Response.Status.CREATED)
	                   .entity(laboratory)
	                   .contentLocation(uri.resolve(newUri))
	                   .build();
	  }
	
	
	@DELETE
	  @Path("/{id}")
	  @Produces(MediaType.APPLICATION_XML)
	  public Response deleteLaboratoryService(@PathParam("id") int id) { 
	    laboratoryService.deleteLaboratory(id);
	    return Response.status(Response.Status.OK).build();
	  }
	
	@Path("/scientists")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response addScientists(Scientist s) { 
       Scientist scientist = scientistFunctions.addScientist(s);
       if(scientist == null) {
 	      return Response.status(Response.Status.BAD_REQUEST).build();
 	    }
 	    URI uri = uriInfo.getRequestUri();
 	    String newUri = uri.getPath() + "/" + scientist.getId();
       return Response.status(Response.Status.OK)
           .entity(scientist)
           .contentLocation(uri.resolve(newUri))
           .build();
    }
	
	/*@GET
	  @Path("/{id}")
	  @Produces(MediaType.APPLICATION_XML)
	  public Response getStudent(@PathParam("id") int id) {
	    Laboratory laboratory = laboratoryService.getLaboratory(id);
	    if(laboratory == null) {
	      return Response.status(Response.Status.NOT_FOUND).build();
	    }
	    Link link = Link.fromUri(uriInfo.getRequestUri())
	                    .rel("self")
	                    .type("application/xml")
	                    .build();
	    return Response.status(Response.Status.OK)
	                   .entity(student)
	                   .links(link)
	                   .build();
	  }*/
	  

	
}
