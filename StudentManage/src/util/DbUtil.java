package util;

import java.sql.Connection;
import java.sql.DriverManager;

//�������ݿ���
public class DbUtil {

	private static String dbUrl="jdbc:mysql://localhost:3306/db_studentinfo";
	private static String dbUserName="root";
	private static String dbPassword="x5";
	private static String jdbcName="com.mysql.jdbc.Driver";
	
	
	public static Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	
	
	public void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
