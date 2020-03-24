package org.student.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.student.model.Student;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Student student)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(student);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> list() {
        Session session = this.sessionFactory.openSession();
        List<Student> personList = session.createQuery("from Student").list();
        session.close();
        return personList;
    }

}
