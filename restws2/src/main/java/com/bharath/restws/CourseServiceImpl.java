package com.bharath.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.bharath.restws.model.Course;

@Service
public class CourseServiceImpl implements CoursesServices {

	Map<Long,Course> cstz = new HashMap<>();
	long currentId = 223;
	
	public CourseServiceImpl() {
		
		init();
	}
	
	void init()
	{
		Course cstr = new Course();
		cstr.setId(currentId);
		cstr.setName("Java");
		cstr.setPrice(5000);
		cstr.setRating(1);
		cstz.put(cstr.getId(), cstr);
	}

	@Override
	public List<Course> getCourse() {

		Collection<Course> results = cstz.values();
		List<Course> response = new ArrayList<>(results);
				
		return response;
	}

	@Override
	public Course getCourse(Long id) {
		return cstz.get(id);
	}

	@Override
	public Response createCourse(Course course) {
		
		course.setId(++currentId);
		cstz.put(course.getId(), course);
		return Response.ok(course).build();
		
	}

	@Override
	public Response updatePatient(Course course) {
		
		Course currCouse = cstz.get(course.getId());
		Response response;
		
		if(currCouse != null)
		{
			cstz.put(course.getId(), course);
			response = Response.ok().build();
		}
		else
		{
			response = Response.notModified().build();
		}
		
		return response;
	}


	

	
}
