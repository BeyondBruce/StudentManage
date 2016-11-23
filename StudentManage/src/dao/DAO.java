package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import util.DbUtil;

//验证安卓端登录的类
public class DAO {
	static DbUtil dbUtil=new DbUtil();
	public static String login(String userName, String password) throws Exception {
		final String sql = "SELECT * FROM t_user WHERE userName=? AND password=?";
		Connection  con =(Connection) dbUtil.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = (ResultSet) ps.executeQuery();
			if(rs.next()){
				return "true";
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return "false";
		
	}
}
