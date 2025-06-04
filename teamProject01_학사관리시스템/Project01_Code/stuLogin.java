package classes;
import java.util.Scanner;
import java.util.ArrayList;

public class  stuLogin{
	int chk = 0;
	//int logoutchk = 0;
	UserAPI ui = new UserAPI();
	//ArrayList<String> log = new ArrayList<>();
	String[] log = new String[2];
	Scanner s = new Scanner(System.in);
	String s1;
	
	miniproject_student forchklog;
	miniproject_student nowlog;
	
	void stulog(){		//로그인 메뉴
		while (true)
			{	
				chk = 0;
				ui.mLine('=',35);
				System.out.println("\t##학생로그인##"); 
				ui.mLine('=',35);
				System.out.println("ID: \n "); 
				IDenter();
				if(chk == 1){
					return;
				}
				ui.mLine('-',35);
				System.out.println("\n PWD : \n"); 
				PWDenter();
				if(chk == 1){
					return;
				}
			}
		}
	
	void IDenter(){		//Id 입력
		Scanner s = new Scanner(System.in);
		s1 = s.nextLine();
		int st;
		if(s1.isEmpty()){
			System.out.println("ID를 입력해주세요");
			stulog();
		}
		else if (s1.equals("q")||s1.equals("Q"))
			{
				System.out.println("^입력을 종료합니다.");
				chk = 1;
				return;
			}else{
			//log.add(0, s1);
			log[0] = s1;
			}
		}
	
	void PWDenter(){	//PWD 입력
		s1 = s.nextLine();
		int st;
		if(s1.isEmpty()){
			System.out.println("PWD를 입력해주세요");
			stulog();
		}
		else if (s1.equals("q")||s1.equals("Q"))
			{
				System.out.println("^입력을 종료합니다.");
				chk = 1;
				return;
			}
		else{
			//log.add(1, s1);
			log[1] = s1;
			infoChk();
		}
	}
	
	void infoChk(){//비교
		for(miniproject_student i : miniminiprojectV01.stuinfoList){
			if(i.getId().equals(log[0])){
				forchklog = i;
				if(forchklog.getPassword().equals(log[1])){
						log[0] = "";
						log[1] = "";
						nowlog = i;
						Stuinfomenu();
						return;
					}
					log[0] = "";
					log[1] = "";
					System.out.println("비밀번호가 다릅니다. FOR TEST : " + forchklog.getPassword());
				    return;
			}
				
		}
		System.out.println("해당하는 ID는 없습니다.");

	}
	
	void Stuinfomenu(){		//학생시스텝		개인정보수정 개인정보조회 성적조회 출석조회
		while (true)
			{	
				chk = 0;
				ui.mLine('=',35);
				System.out.println("\t##학생시스템##"); 
				ui.mLine('=',35);
				System.out.println("\n\n1. 개인정보수정\n2. 개인정보조회\n3. 성적조회\n4. 출석조회\n5. 로그아웃\n"); 
				Menuenter();	
				if(chk == 1)
				{
					return;
				}
			}
		}
	void Menuenter(){		//학생시스템 메뉴
		s1 = s.nextLine();
		int st;
		if(s1.isEmpty()){
			System.out.println("메뉴를 입력해주세요");
			Stuinfomenu();
		}
		else if (s1.equals("q")||s1.equals("Q"))
		{
			System.out.println("^로그인으로 돌아갑니다.");
			/*
			chk = 1;
			return;
			*/
			logout();
		}
		else {
			st = Integer.parseInt(s1);
			if(st<1|| st >5){
				System.out.println("1~5사이의 숫자를 입력해주세요");
				Stuinfomenu();
			}
			else if(st == 1){
				sMenu01();
			}
			else if(st == 2){
				sMenu02();
			}
			else if (st == 3)
			{
				sMenu03();
			}
			else if (st == 4)
			{
				sMenu04();
			}
			else if (st == 5)
			{
				logout();
			}
		}
	}
	
	void sMenu01(){			//개인정보수정		비밀번호수정 email수정 전화번호 수정
		ui.mLine('=',35);
		System.out.println("\n\t 학생개인정보수정");
		ui.mLine('=',35);
		System.out.println("\n\n1. 비밀번호수정\n2. email수정\n3. 전화번호수정\nq. 학생시스템\n"); 
		sM01enter();
	}
	
	void sM01enter(){			//개인정보수정 메뉴
		s1 = s.nextLine();
		int st;
		if(s1.isEmpty()){
			System.out.println("메뉴를 입력해주세요");
			sMenu01();
		}
		else if (s1.equals("q")||s1.equals("Q"))
		{
			System.out.println("\n학생시스템으로 돌아갑니다");
			Stuinfomenu();
		}
		else {
			st = Integer.parseInt(s1);
			if(st<1|| st >3){
				System.out.println("1~3사이의 숫자를 입력해주세요");
				sMenu01();
			}
			else if(st == 1){
				siDir01();		//비밀번호수정
			}
			else if(st == 2){
				siDir02();		//email수정
			}
			else if (st == 3)
			{
				siDir03();		//전화번호수정
			}
		}
	}
	void siDir01(){		//비밀번호수정
		ui.mLine('=',35);
		System.out.println("\t 학생 비밀번호 수정");
		ui.mLine('=',35);
		System.out.println("수정전 비밀번호 : " + nowlog.getPassword());
	while(true){//비밀번호형식확인
				System.out.print("비밀번호 : ");
				s1 = s.nextLine();
				
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 수정취소 개인정보수정메뉴로 돌아갑니다.");
				return;
				}
				
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[a-z0-9A-Z@]+$") && (s1.length() >= 6 && s1.length() <= 9)){
				   nowlog.setPassword(s1);
				   break;
				}
				 System.out.println("정확한 비밀번호 형식으로 입력하세요");
				   continue;
			}

		sMenu01();
	}
	void siDir02(){		//email수정
		ui.mLine('=',35);
		System.out.println("\t 학생 email 수정");
		ui.mLine('=',35);
		System.out.println("수정전 이메일 : " + nowlog.getEmail());
		while(true){//이메일형식확인
				System.out.print("이메일 : ");
				s1 = s.nextLine();
				
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 수정취소 개인정보수정메뉴로 돌아갑니다.");
				return;
				}
				
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
				   nowlog.setEmail(s1);
				   break;
				}
				 System.out.println("정확한 이메일 형식으로 입력하세요");
				   continue;
			}
		sMenu01();
	}
	void siDir03(){		//전화번호수정
		ui.mLine('=',35);
		System.out.println("\t 학생 전화번호 수정");
		ui.mLine('=',35);
		System.out.println("수정전 전화번호 : " + nowlog.getPhonenum());
		while(true){//전화번호형식확인
				System.out.print("전화번호 : ");
				s1 = s.nextLine();
				
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 수정취소 개인정보수정메뉴로 돌아갑니다.");
				return;
				}
				
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[0-9@]+$") && s1.length() == 11){
				  nowlog.setPhonenum(s1);
				   break;
				}
				 System.out.println("정확한 전화번호 형식으로 입력하세요");
				   continue;
			}
		sMenu01();
	}
	void sMenu02(){			//개인정보조회
			ui.mLine('=',35);
			System.out.println("\n\t 개인정보조회");
			ui.mLine('=',35);; 

			System.out.println("학번 : " + nowlog.getId());
			System.out.println("비밀번호 : " + nowlog.getPassword());
			System.out.println("이메일 : " + nowlog.getEmail());
			System.out.println("이름 : " + nowlog.getName());
			System.out.println("전공 : " + nowlog.getField());
			System.out.println("전화번호 : " + nowlog.getPhonenum());
			System.out.println("\nQ.이전으로 이동합니다.");
			ui.mLine('=',35);
			
			s1 = s.nextLine();
			if (s1.equals("q")||s1.equals("Q"))
			{
				System.out.println("\n학생시스템으로 돌아갑니다");
				Stuinfomenu();
			}
		}
	
	void sMenu03(){			//성적조회		
		ui.mLine('=',35);
		System.out.println("\n\t 학생성적조회");
		ui.mLine('=',35);
		sM03enter();
	}
	
	void sM03enter(){		//성적출력
		if(nowlog.getResult().size() == 0){
			System.out.println("정보없습");
		}
		else{
			for(String[] i : nowlog.getResult()){
				System.out.println("과목 : " + i[0] + " 성적 : " + i[1]);
			}
		}
		s1 = s.nextLine();
		//int st;
		if (s1.equals("q")||s1.equals("Q"))
		{
			System.out.println("\n학생시스템으로 돌아갑니다");
			Stuinfomenu();
		}		
	}
	void sMenu04(){			//출석조회		
		ui.mLine('=',35);
		System.out.println("\n\t 출석조회");
		ui.mLine('=',35);
		sM04enter();
	}
	
	void sM04enter(){		//출석출력
		if(nowlog.getAttendance() == null){
			System.out.println("정보없습");
		}
		else{
			System.out.println(nowlog.getAttendance());
		}
		System.out.println("Q 학생시스템으로");
		s1 = s.nextLine();
		//int st;
		if (s1.equals("q")||s1.equals("Q"))
		{
			System.out.println("\n학생시스템으로 돌아갑니다");
			Stuinfomenu();
		}		
	}
	void logout(){
		stulog();

	}
}
