package com.bharath.restws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.bharath.restws.model.Course;

@Path("/courses")
public interface CoursesServices {

	@Path("/coursedetails")
	@GET
	List<Course> getCourse();
	
	@Path("/coursedetails/{id}")
	@GET
	Course getCourse(@PathParam(value = "id") Long id); 
	
	@Path("/coursedetails")
	@POST
	Response createCourse(Course course);
	
	

	@Path("/patients")
	@PUT
	Response updatePatient(Course course);
	
}
