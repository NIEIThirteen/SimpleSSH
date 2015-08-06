package test;
import javax.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.HibernateSessionFactory;
import po.User;
public class InsertTest {
	public static void main(String[] args) {
		User student = new User();//实例化一个student对象
		student.setUsername("456789");//设置学生学号
		student.setPassword("盛帅");//设置学生名字
		
		Session session = 
			HibernateSessionFactory.getSession();//获得Session对象
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.save(student);//保存学生信息
			transaction.commit();//提交事务
			System.out.println("添加记录成功!");
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();
	}
}
