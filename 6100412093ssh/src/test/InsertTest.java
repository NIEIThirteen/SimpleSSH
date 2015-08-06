package test;
import javax.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.HibernateSessionFactory;
import po.User;
public class InsertTest {
	public static void main(String[] args) {
		User student = new User();//ʵ����һ��student����
		student.setUsername("456789");//����ѧ��ѧ��
		student.setPassword("ʢ˧");//����ѧ������
		
		Session session = 
			HibernateSessionFactory.getSession();//���Session����
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.save(student);//����ѧ����Ϣ
			transaction.commit();//�ύ����
			System.out.println("��Ӽ�¼�ɹ�!");
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();
	}
}
