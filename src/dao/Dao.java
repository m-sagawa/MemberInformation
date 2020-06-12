package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dao {
	//beanを受け取ってDBに登録し、登録できたか否かのメッセージを返す
	public String Registration(Bean memberBean) {
		String sql = "INSERT INTO database.members VALUES(?,?,?,?,?,?)";
		String message = null;

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
			String member = sdf.format(now);


			String name = memberBean.getName();
			int age = memberBean.getAge();
			int year = memberBean.getYear();
			int month = memberBean.getMonth();
			int day = memberBean.getDay();

			pstmt.setString(1, "A" + member);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setInt(4, year);
			pstmt.setInt(5, month);
			pstmt.setInt(6, day);
			int count = pstmt.executeUpdate();

			if(count == 0) {
				message = "登録に失敗しました";
			}else if(count == 1){
				message = "登録に成功しました";
			}
		}catch(SQLException | ClassNotFoundException e) {
			message = "登録に失敗しました";
		}
		return message;
	}

	//受けっとったmember_noに合わせた情報をDB上から削除し、できたか否かのメッセージを返す
	public String Delete(String member) {
		String sql = "DELETE FROM members WHERE member_no = ?";
		String message = null;

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, member);
			int count = pstmt.executeUpdate();
			if(count == 1) {
				message = "削除に成功しました";
			}else {
				message = "削除に失敗しました";
			}
		}catch(SQLException | ClassNotFoundException e) {
			message = "削除に失敗しました";
			//e.printStackTrace();
		}
		return message;
	}

	//DB内の情報をすべてListに入れて返す
	public List<Bean> memberList(){
		List<Bean> memberList = new ArrayList<Bean>();
		String sql = "SELECT * FROM database.members";
		try(Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){
			while(res.next()) {
				String member = res.getString("member_no");
				String name = res.getString("name");
				int age = res.getInt("age");
				int year = res.getInt("birth_year");
				int month = res.getInt("birth_month");
				int day = res.getInt("birth_day");

				Bean memberBean = new Bean();

				memberBean.setMember(member);
				memberBean.setName(name);
				memberBean.setAge(age);
				memberBean.setYear(year);
				memberBean.setMonth(month);
				memberBean.setDay(day);

				memberList.add(memberBean);
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	//member_noをもらって対応する会員情報を返す
	public Bean SelectMember(String member) {
		String sql = "SELECT name, age, birth_year, birth_month, birth_day FROM members WHERE member_no = ?";

		Bean memberBean = new Bean();

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, member);
			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				String name = res.getString("name");
				int age = res.getInt("age");
				int year = res.getInt("birth_year");
				int month = res.getInt("birth_month");
				int day = res.getInt("birth_day");

				memberBean.setName(name);
				memberBean.setAge(age);
				memberBean.setYear(year);
				memberBean.setMonth(month);
				memberBean.setDay(day);
			}

		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return memberBean;
	}

	//beanを受け取ってDBを変更し、登録できたか否かのメッセージを返す
	public String Update(Bean memberBean) {
		String message = null;
		String sql = "UPDATE members SET name=?, age=?, birth_year=?, birth_month=?, birth_day=? WHERE member_no=?";
		String member = memberBean.getMember();
		String name = memberBean.getName();
		int age = memberBean.getAge();
		int year = memberBean.getYear();
		int month = memberBean.getMonth();
		int day = memberBean.getDay();

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, year);
			pstmt.setInt(4, month);
			pstmt.setInt(5, day);
			pstmt.setString(6, member);
			int count = pstmt.executeUpdate();

			if(count == 1) {
				message = "変更に成功しました";
			}else {
				message = "変更に失敗しました";
			}
		}catch(SQLException | ClassNotFoundException e) {
			message = "変更に失敗しました";
		}

		return message;
	}
}
