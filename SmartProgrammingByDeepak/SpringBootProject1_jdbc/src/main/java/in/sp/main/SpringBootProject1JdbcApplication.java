package in.sp.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.dao.UserDao;
import in.sp.main.entity.User;

@SpringBootApplication
public class SpringBootProject1JdbcApplication implements CommandLineRunner{
	@Autowired
	private UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject1JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		-------:Insertion:-------
//		User user1=new User("shivam", "shivam@gamil.com","male","boring");
//		boolean status=userDao.insertUser(user1);
//		if(status)
//			System.out.println("-------User inserted succes-------");
//		else
//			System.out.println("-------user not inserted--------");
		
//		---------:Updation 1:---------
//		User user=new User("suraj","sps@gamil.com","malel","bihar");
//		boolean status=userDao.updateUser(user);
//		if(status)
//			System.out.println("---------updating Success---------");
//		else
//			System.out.println("-----------do not updaing----------");

//		---------:Updation 2:---------
		User user = userDao.getUserByEmail("shivam@gamil.com");
		user.setCity("delhi");
		boolean status = userDao.updateUser(user);
		if(status)
			System.out.println("------Updation Successful-----");
		else
			System.out.println("------Updation Failed--------");
		
//				-----------:Deletion:---------
//		boolean status=userDao.deleteUserByEmail("sps@gamil.com");
//		if(status)
//			System.out.println("-----Deletion Succes-----");
//		else
//			System.out.println("------Deletion Failed-----");


//				-------:select one user:----------
//		User user = userDao.getUserByEmail("shivam@gamil.com");
//		System.out.println("Name: "+user.getName());
//		System.out.println("Email: "+ user.getEmail());
//		System.out.println("Gender: "+user.getGender());
//		System.out.println("City: "+user.getCity());
		
//		-------------:Select All Users:------------
//		List<User> list = userDao.getAllUsers();
//		for(User user:list)
//		{
//			System.out.println("Name: "+user.getName());
//			System.out.println("Email: "+ user.getEmail());
//			System.out.println("Gender: "+user.getGender());
//			System.out.println("City: "+user.getCity());
//			System.out.println("-----------------------");
//		}
	}
}
