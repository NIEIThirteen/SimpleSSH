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
	  Query query = session.createQuery("from Sign");//��ѯEmployee
		List list = query.list();//��ѯ������浽list��
		Iterator iter = list.iterator();//���list���ڲ�������
		Sign employee = null;
		System.out.println("ְԱ���\tְԱ����\tְԱ�Ա�\tְԱ��������\t\tְԱ�ֻ�����" +
				"\tְԱ��ס��ַ\tְԱ����˾ʱ��");
		while(iter.hasNext()) {		//����list
			employee = (Sign) iter.next();
			System.out.println(employee.getUsername()+"\t"
				
			);
		}					
		HibernateSessionFactory.closeSession();
  }
}
