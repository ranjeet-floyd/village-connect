package org.village.connect.resources;

import org.village.connect.model.Representation;
import org.village.connect.model.StudentModel;
import org.village.connect.service.StudentService;

import com.codahale.metrics.annotation.Timed;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author ranjeet.kumar
 *
 */

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentResource.class);

    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GET
    @Timed
    public Representation<List<StudentModel>> getStudents() {
        return new Representation<List<StudentModel>>(HttpStatus.OK_200, studentService.getStudents());
    }

    @GET
    @Timed
    @Path("{id}")
    public Representation<StudentModel> getUser(@PathParam("id") final int id) {
        return new Representation<StudentModel>(HttpStatus.OK_200, studentService.getStudent(id));
    }

    @POST
    @Timed
    public Representation<StudentModel> createUser(@NotNull final StudentModel studentModel) {
        System.out.println("got student model : " + studentModel);
        return new Representation<StudentModel>(HttpStatus.OK_200, studentService.createStudent(studentModel));
    }

}
