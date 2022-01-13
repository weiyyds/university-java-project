package demo;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bean.user.UserBean;

public class MyBatisTest {
	public static void main(String[] args) throws Exception {
		String path="demo/mybatis-config.xml";
		InputStream in=Resources.getResourceAsStream(path);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession=factory.openSession();
		System.out.println(sqlSession);
		/*UserBean user=new UserBean();
		user.setAccount("张三");
		user.setPwd("123456");
		sqlSession.insert("insertUser",user);
		sqlSession.commit();
		*/
		/*java.util.List<UserBean> list=sqlSession.selectList("selectAllUsers");
		for(int i=0;i<list.size();i++) {
			UserBean u=list.get(i);
			System.out.println("id是"+u.getId()+" 密码是"+u.getPwd()+" 账号是"+u.getAccount());
		}*/
		UserBean user=new UserBean();
		//user.setProvince("广东省");
		user.setProvince(null);
		java.util.List<UserBean> list=sqlSession.selectList("select_if",user.getProvince());
		for(int i=0;i<list.size();i++) {
			UserBean u=list.get(i);
			System.out.println("id是"+u.getId()+" 密码是"+u.getPwd()+" 账号是"+u.getAccount()+"省份是："+u.getProvince());
		}
		sqlSession.close();
	}
}
