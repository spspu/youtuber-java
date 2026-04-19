package in.sp.main;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.sp.entities.User;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) 
    {
    	User user1 = new User();
    	//user1.setId(1);
    	
    	user1.setName("sruaj");
    	user1.setEmail("suraj@gmail.com");
    	user1.setPassword("deepak123");
    	user1.setGender("male");
    	user1.setCity("patna");
    	
//    	user1.setName("priya");
//    	user1.setEmail("priya@gmail.com");
//    	user1.setPassword("priya123");
//    	user1.setGender("female");
//    	user1.setCity("banglore");
    	
        Configuration cfg = new Configuration();
        cfg.configure("/in/sp/config/hibernate.cfg.xml");
        
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        -------------Insertion------------------
        try {
        	session.save(user1);
            transaction.commit();
            System.out.println("----------User Details Added Successfully------");
        }catch (Exception e)
        {
        	transaction.rollback();
        	e.printStackTrace();
        	System.out.println("-----------User Details Not Added due to Eroor----------");
        }


//                -----------Data Fetching-----------
        
//        try {
//        	User user = session.get(User.class, 6L);
//        	
//        	if(user != null)
//        	{
//        		System.out.println("--------User found---------");
//        		System.out.println(user.getId());
//            	System.out.println(user.getName());
//            	System.out.println(user.getEmail());
//            	System.out.println(user.getPassword());
//            	System.out.println(user.getGender());
//            	System.out.println(user.getCity());
//        	}
//        	else {
//        		System.out.println("---------User Not Found---------");
//        	}
//        	
//        }catch (Exception e) {
//        	e.printStackTrace();
//        }
 
        
//        -------------Updation------------------
        /*User user = new User();
    	user.setId("3");
        user.setCity("pune");*/
        
//        try {
//        	User user = session.get(User.class, 2L);
//        	user.setCity("dhanbad");
//        	
//        	session.saveOrUpdate(user);
//            transaction.commit();
//            System.out.println("----------User Details Updated Successfully------");
//        }catch (Exception e)
//        {
//        	transaction.rollback();
//        	e.printStackTrace();
//        	System.out.println("-----------User Details Not Updated due to Eroor----------");
//        }
        
        
//      -------------Deletion------------------
      
//      try {
//    	  
//      		User user = new User();
//      		user.setId(4L);
//      	
//      		session.delete(user);
//      		transaction.commit();
//      		System.out.println("----------User Details Deleted Successfully------");
//      }catch (Exception e)
//      {
//      	transaction.rollback();
//      	e.printStackTrace();
//      	System.out.println("-----------User Details Not Deleted due to Eroor----------");
//      }
    }
}
