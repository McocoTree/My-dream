package controller;

import java.util.Scanner;
import model.SubjectVO;

public class SubjectRegisterManager {
// 학과 목록
	public void subjectList() throws Exception {
		SubjectDAO sd = new SubjectDAO();
		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();
		System.out.println();
	}

// 학과 등록 관리
	public void subjectRegistr() throws Exception {
		Scanner input = new Scanner(System.in);
		SubjectDAO sd = new SubjectDAO();
		SubjectVO svo = new SubjectVO();
		String s_num; // 학과 번호
		String s_name; // 학과명
		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();
		System.out.println();
		System.out.println("학과 정보 입력");
		System.out.print("학과번호 : ");
		s_num = input.nextLine();
		System.out.print("학과명 : ");
		s_name = input.nextLine();
		svo.setS_num(s_num);
		svo.setS_name(s_name);
		sd.setSubjectRegiste(svo);
		System.out.println();
		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();
		System.out.println();
	}

// 학과 수정 관리
	public void subjectUpdate() throws Exception {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		SubjectDAO sd = new SubjectDAO();
		SubjectVO svo = new SubjectVO();
		int s_no; // 입력한 일련번호
		String s_num; // 학과 번호
		String s_name; // 학과명
		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();
		System.out.println();
		System.out.println("수정할 학과 일련번호 입력");
		System.out.print("일련번호 : ");
		s_no = input1.nextInt();
		System.out.println();
		System.out.println("새로운 정보 모두 입력");
		System.out.print("학과번호 : ");
		s_num = input.nextLine();
		System.out.print("학과명 : ");
		s_name = input.nextLine();
		svo.setNo(s_no);
		svo.setS_num(s_num);
		svo.setS_name(s_name);
		sd.setSubjectUpdate(svo);
		System.out.println();
		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();
		System.out.println();
	}

// 학과 삭제 관리
	public void subjectDelete() throws Exception {
		Scanner input = new Scanner(System.in);
		SubjectDAO sd = new SubjectDAO();
		SubjectVO svo = new SubjectVO();
		int s_no; // 입력한 일련번호
		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();
		System.out.println();
		System.out.println("삭제할 학과 일련번호 입력");
		System.out.print("일련번호 : ");
		s_no = input.nextInt();
		sd.setSubjectDelete(s_no);
		System.out.println();
		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();
		System.out.println();
	}
}
