package org.student.dao;

import org.student.model.Student;
import java.util.List;

public interface StudentDAO
{
    public void save(Student student);
    public List<Student> list();
}