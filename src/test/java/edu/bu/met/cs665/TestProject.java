package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import dao.CourseDao;
import dao.StudentDao;

import java.io.IOException;
// Write some Unit tests for your program like the following.

public class TestProject {

    public TestProject() {}

    @Test
    public void testGetCourse() throws IOException {

        CourseDao cd = new CourseDao();
        assertEquals("Java",cd.getCourseById("c0001").getCourseName());

    }


    @Test
    public void testGetTeacher() throws IOException {
        CourseDao cd = new CourseDao();
        String instructorName = cd.getCourseById("c0001").getTeacher();
        assertEquals("Tom",instructorName);

    }


    @Test
    public void testGetReaminingSeats() throws IOException {

        CourseDao cd = new CourseDao();
        int remainingSeats = cd.getCourseById("c0005").getRestNum();
        assertEquals(97, remainingSeats);

    }






}