package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import model.PageBean;
import model.Student;
import util.DateUtil;
import util.StringUtil;

//对学生信息进行操作的类
public class StudentDao {

	public ResultSet studentList(Connection con,PageBean pageBean,Student student,String bbirthday,String ebirthday)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_student s,t_grade g where s.gradeId=g.id");
		if(StringUtil.isNotEmpty(student.getStuNo())){
			sb.append(" and s.stuNo like '%"+student.getStuNo()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuName())){
			sb.append(" and s.stuName like '%"+student.getStuName()+"%'");
		}

		if(student.getGradeId()!=-1){
			sb.append(" and s.gradeId ='"+student.getGradeId()+"'");
		}
//		if(StringUtil.isNotEmpty(student.getAndroid())){
//		sb.append(" and s.android ='"+student.getAndroid()+"'");
//	}
		if(StringUtil.isNotEmpty(bbirthday)){
			sb.append(" and TO_DAYS(s.birthday)>=TO_DAYS('"+bbirthday+"')");
		}
		if(StringUtil.isNotEmpty(ebirthday)){
			sb.append(" and TO_DAYS(s.birthday)<=TO_DAYS('"+ebirthday+"')");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	public int studentCount(Connection con,Student student,String bbirthday,String ebirthday)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_student s,t_grade g where s.gradeId=g.id");
		if(StringUtil.isNotEmpty(student.getStuNo())){
			sb.append(" and s.stuNo like '%"+student.getStuNo()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuName())){
			sb.append(" and s.stuName like '%"+student.getStuName()+"%'");
		}
//		if(StringUtil.isNotEmpty(student.getSex())){
//			sb.append(" and s.sex ='"+student.getSex()+"'");
//		}
		if(student.getGradeId()!=-1){
			sb.append(" and s.gradeId ='"+student.getGradeId()+"'");
		}
		if(StringUtil.isNotEmpty(bbirthday)){
			sb.append(" and TO_DAYS(s.birthday)>=TO_DAYS('"+bbirthday+"')");
		}
		if(StringUtil.isNotEmpty(ebirthday)){
			sb.append(" and TO_DAYS(s.birthday)<=TO_DAYS('"+ebirthday+"')");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	//对数据库进行删除学生信息操作
	public int studentDelete(Connection con,String delIds)throws Exception{
		String sql="delete from t_student where stuId in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}

	//对数据库进行增加学生操作
	public int studentAdd(Connection con,Student student)throws Exception{
		String sql="insert into t_student values(null,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStuNo());
		pstmt.setString(2, student.getStuName());
		pstmt.setInt(3, student.getGradeId());
		pstmt.setString(4, DateUtil.formatDate(student.getData(), "yyyy-MM-dd"));
		pstmt.setString(5, student.getJava());
		pstmt.setString(6, student.getJavaweb());
		pstmt.setString(7, student.getAndroid());
		pstmt.setString(8, student.getEnglish());
		pstmt.setString(9, student.getStuDesc());
		return pstmt.executeUpdate();
	}
	//对数据库进行修改学生信息操作
	public int studentModify(Connection con,Student student)throws Exception{
		String sql="update t_student set stuNo=?,stuName=?,gradeId=?,data=?,java=?,javaweb=?,android=?,English=?,stuDesc=? where stuId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStuNo());
		pstmt.setString(2, student.getStuName());
		pstmt.setInt(3, student.getGradeId());
		
		pstmt.setString(4, DateUtil.formatDate(student.getData(), "yyyy-MM-dd"));
		pstmt.setString(5, student.getJava());
		pstmt.setString(6, student.getJavaweb());
		pstmt.setString(7, student.getAndroid());
		pstmt.setString(8, student.getEnglish());
		pstmt.setString(9, student.getStuDesc());
		pstmt.setInt(10, student.getStuId());
		return pstmt.executeUpdate();
	}
	
	public boolean getStudentByGradeId(Connection con,String gradeId)throws Exception{
		String sql="select * from t_student where gradeId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, gradeId);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}
}
