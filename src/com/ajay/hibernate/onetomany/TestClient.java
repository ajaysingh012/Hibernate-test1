package com.ajay.hibernate.onetomany;
import org.hibernate.*;
import org.hibernate.cfg.*;

import com.ajay.hibernate.onetomany.Movies;
import java.util.*;

public class TestClient{

	public static void main(String s[])throws Exception{
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");

		SessionFactory sf=cfg.buildSessionFactory();

		Session session=sf.openSession();
		
		Transaction txn = session.beginTransaction();
        
        Movies mov1 = new Movies();
        mov1.setMid(1);
        mov1.setMoviename("Movie-1");
        
        Movies mov2 = new Movies();
        mov2.setMid(2);
        mov2.setMoviename("Movie-2");
        
        Set<Movies> mset = new HashSet<Movies>();
        mset.add(mov1);
        mset.add(mov2);
        
		Actor act = new Actor();
        act.setAid(1);
        act.setActorname("Actor-1");
        
        act.setMovies(mset);
        
        //session.save(mov1);
        //session.save(mov2);
        session.save(act);
        
        txn.commit();
        System.out.println("Insertion Success");
		
		session.close();
	}// main
}// class
		