package web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;
import util.DbUtil;
import util.StringUtil;

//验证web端登录的类LoginServlet
public class LoginServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                // 获取输入的用户名和密码     
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		request.setAttribute("userName", userName);
	 	request.setAttribute("password", password);

                // 逻辑判断
		if(StringUtil.isEmpty(userName)||StringUtil.isEmpty(password)){
			request.setAttribute("error", "用户名或密码为空！");
			request.getRequestDispatcher("login1.jsp").forward(request, response);
			return;
		}
		User user=new User(userName,password);
	   	Connection con=null;
		try {

                       //连接数据库进行用户名和密码判断
			con=dbUtil.getCon();
			User currentUser=userDao.login(con, user);
			if(currentUser==null){
				request.setAttribute("error", "用户名或密码错误！");
				// 服务器跳转
				request.getRequestDispatcher("login1.jsp").forward(request, response);
			}else{
				// 获取Session
				HttpSession session=request.getSession();
				session.setAttribute("currentUser", currentUser);
				// 客户端跳转
				response.sendRedirect("main.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
}
