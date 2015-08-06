package test;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.signServiceImpl;
import hibernate.HibernateSessionFactory;
import po.Sign;
import dao.signImpl;
import po.User;
import dao.userImpl;
public class QueryTest {
  public static void main(String[] args) {
	  
	  test6();
  }
  public static void test2(){
	  signServiceImpl s= new signServiceImpl();
	  List<Sign> slist=s.findAllSign();
	  System.out.println(slist.get(0).getUsername());
  }
  public static void test6(){
	  userImpl s=new userImpl();
	  User sl=s.getUser("093");
	  System.out.println(sl.getName());
  }
  public static void test5(){
	  signImpl s=new signImpl();
	  Sign sl=s.getSign("093");
	  System.out.println(sl.getName());
  }
  public static void test4(){
	  signImpl s=new signImpl();
	  List<Sign> sl=s.findALLSign();
	  System.out.println(sl.get(0).getUsername());
  }
  public static void test3(){
	  Session session = HibernateSessionFactory.getSession();
	  Query query = session.createQuery("from Sign");
	  List<Sign> sl=query.list();
	  HibernateSessionFactory.closeSession();		
	  System.out.println(sl.get(0).getUsername());
  }
  
  public void test1(){
	  Session session = HibernateSessionFactory.getSession();
	  Query query = session.createQuery("from Sign");//查询Employee
		List list = query.list();//查询结果保存到list中
		Iterator iter = list.iterator();//获得list的内部迭代器
		Sign employee = null;
		System.out.println("职员编号\t职员姓名\t职员性别\t职员出生日期\t\t职员手机号码" +
				"\t职员居住地址\t职员进公司时间");
		while(iter.hasNext()) {		//遍历list
			employee = (Sign) iter.next();
			System.out.println(employee.getUsername()+"\t"
				
			);
		}					
		HibernateSessionFactory.closeSession();
  }
}
