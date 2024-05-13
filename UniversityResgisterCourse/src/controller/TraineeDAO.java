package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.TraineeVO;

public class TraineeDAO {
// 수강 신청
	public void setTraineeRegiste(TraineeVO tvo) throws Exception {
		String sql = "insert into trainee " + "(no, sd_num, l_abbre, t_section, t_date)" + " values "
				+ "(trainee_seq.nextval, ?, ?, ?, sysdate)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tvo.getSd_num());
			pstmt.setString(2, tvo.getL_abbre());
			pstmt.setString(3, tvo.getT_section());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("수강 신청 완료.");
				System.out.println("수강 신청 성공!!!");
			} else {
				System.out.println("수강 신청 실패!!!");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

// 수강 신청 삭제
	public void setTraineeDelete(int no) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from trainee where no = ?");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("수강 신청 취소 완료.");
				System.out.println("수강 신청 취소 성공!!!");
			} else {
				System.out.println("수강 신청 취소 실패!!!");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

// 개인 수강 신청 전체 목록
	public void getTraineeTotalList(String sd_num) throws Exception {
		String sql = "select tr.no as no, tr.sd_num as sd_num, tr.l_abbre as l_abbre, le.l_name as l_name, st.sd_name as sd_name, t_section, t_date "
				+ " from trainee tr, lesson le , student st "
				+ " where tr.sd_num = ? and tr.l_abbre = le.l_abbre and tr.sd_num = st.sd_num order by t_date";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TraineeVO tVo = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sd_num);
			rs = pstmt.executeQuery();
			System.out.println("일련번호\t학생번호 \t\t과목약어\t과목명\t학생이름\t과목구분\t등록일");
			while (rs.next()) {
				tVo = new TraineeVO();
				tVo.setNo(rs.getInt("no"));
				tVo.setSd_num(rs.getString("sd_num"));
				tVo.setL_abbre(rs.getString("l_abbre"));
				tVo.setT_section(rs.getString("t_section"));
				tVo.setT_date(rs.getString("t_date"));
				System.out.println(
						tVo.getNo() + "\t" + tVo.getSd_num() + " \t" + tVo.getL_abbre() + "\t" + rs.getString("l_name")
								+ "\t" + rs.getString("sd_name") + "\t" + tVo.getT_section() + "\t" + tVo.getT_date());
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	// 선택한 과목명의 과목 번호
	public String getLessonNum(String lessonName) throws Exception {
		String l_abbre = "";
		String sql = "select l_abbre from lesson where l_name = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lessonName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				l_abbre = rs.getString("l_abbre");
			} else {
				System.out.println("수강 과목의 과목 번호");
				System.out.println("선택한 " + lessonName + " 과목의		과목번호가 없습니다.");
				System.out.println("과목 검색 실패");
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
		return l_abbre;
	}
}