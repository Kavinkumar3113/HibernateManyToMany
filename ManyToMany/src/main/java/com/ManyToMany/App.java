package com.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	Scanner scan=new Scanner(System.in);
    	Student student=new Student();
    	System.out.print("\nEnter the student id: ");
    	student.setSid(scan.nextInt());
    	scan.nextLine();
    	System.out.print("\nEnter the student name: ");
    	student.setSname(scan.nextLine());
    	
    	
    	Laptop laptop=new Laptop();
    	System.out.print("\nEnter the Laptop id: ");
    	laptop.setLid(scan.nextInt());
    	scan.nextLine();
    	System.out.print("\nEnter the Laptop name: ");
    	laptop.setLname(scan.nextLine());
    	
    	List<Laptop> slist=new ArrayList<>();
    	slist.add(laptop);
    	student.setLaptop(slist);
    	List<Student> llist=new ArrayList<>();
    	llist.add(student);
    	laptop.setStudent(llist);
    	
    	Configuration con = new Configuration().configure()
    			.addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
    	SessionFactory sf=con.buildSessionFactory();
    	Session session=sf.openSession();
    	Transaction tx=session.beginTransaction();
    	session.persist(student);
    	session.persist(laptop);
    	tx.commit();
    	
    }
}
