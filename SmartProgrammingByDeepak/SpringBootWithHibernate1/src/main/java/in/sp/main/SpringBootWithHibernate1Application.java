package in.sp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.entities.User;

@SpringBootApplication
public class SpringBootWithHibernate1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithHibernate1Application.class, args);
		
		Configuration cfg = new Configuration();
		cfg.configure("/in/sp/main/config/hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
		
		try {
			User user = session.get(User.class, 2L);
			if(user != null)
			{
				System.out.println(user.getName());
				System.out.println(user.getEmail());
			}else {
				System.out.println("----User not found-----");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
