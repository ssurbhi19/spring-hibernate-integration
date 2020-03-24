package org.student.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.student.dao.StudentDAO;
import org.student.model.Student;

import java.util.List;

public class StudentController
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");

        StudentDAO studentDAO=context.getBean(StudentDAO.class);
        Student student= new Student("SURBHI","VERMA","surbhi@gmail.com");
        studentDAO.save(student);
        System.out.println("Student::"+student);


        List<Student> studentList = studentDAO.list();

        for(Student stu : studentList){
            System.out.println("Person List::"+stu);
        }

        context.close();
    }
}