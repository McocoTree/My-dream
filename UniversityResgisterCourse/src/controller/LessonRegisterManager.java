package controller;

import java.util.Scanner;
import model.LessonVO;

public class LessonRegisterManager {
// 과목 목록
	public void lessonList() throws Exception {
		LessonDAO ld = new LessonDAO();
		System.out.println("과목 전체 리스트");
		ld.getLessonTotalList();
		System.out.println();
	}

// 과목 등록 관리
	public void lessonRegistr() throws Exception {
		Scanner input = new Scanner(System.in);
		LessonDAO ld = new LessonDAO();
		LessonVO lvo = new LessonVO();
		String l_abbre; // 과목약어
		String l_name; // 과목명
		System.out.println("과목 전체 리스트");
		ld.getLessonTotalList();
		System.out.println();
		System.out.println("과목 정보 입력");
		System.out.print("과목약어 : ");
		l_abbre = input.nextLine();
		System.out.print("과목명 : ");
		l_name = input.nextLine();
		lvo.setL_abbre(l_abbre);
		lvo.setL_name(l_name);
		ld.setLessonRegiste(lvo);
		System.out.println();
		System.out.println("과목 전체 리스트");
		ld.getLessonTotalList();
		System.out.println();
	}

// 과목 수정 관리
	public void lessonUpdate() throws Exception {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		LessonDAO ld = new LessonDAO();
		LessonVO lvo = new LessonVO();
		int l_no; // 수정할 과목 일련번호
		String l_abbre; // 수정할 과목약어
		String l_name; // 수정할 과목명
		System.out.println("과목 전체 리스트(사용중인 과목 변경 불가)");
		ld.getLessonTotalList();
		System.out.println();
		System.out.println("수정할 과목 일련번호 입력");
		System.out.print("일련번호 : ");
		l_no = input1.nextInt();
		System.out.println();
		System.out.println("새로운 정보 모두 입력");
		System.out.print("과목약어 : ");
		l_abbre = input.nextLine();
		System.out.print("과목명 : ");
		l_name = input.nextLine();
		lvo.setNo(l_no);
		lvo.setL_abbre(l_abbre);
		lvo.setL_name(l_name);
		ld.setLessonUpdate(lvo);
		System.out.println();
		System.out.println("과목 전체 리스트");
		ld.getLessonTotalList();
		System.out.println();
	}

// 과목 삭제 관리
	public void lessonDelete() throws Exception {
		Scanner input = new Scanner(System.in);
		LessonDAO ld = new LessonDAO();
		LessonVO lvo = new LessonVO();
		int l_no; // 삭제할 과목 번호
		System.out.println("과목 전체 리스트(사용중인 과목 삭제 불가)");
		ld.getLessonTotalList();
		System.out.println();
		System.out.println("삭제할 과목 일련번호 입력");
		System.out.print("일련번호 : ");
		l_no = input.nextInt();
		ld.setLessonDelete(l_no);
		System.out.println();
		System.out.println("학과 전체 리스트");
		ld.getLessonTotalList();
		System.out.println();
	}
}
