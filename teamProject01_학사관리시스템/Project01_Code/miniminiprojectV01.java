package classes;
import java.util.Scanner;
import java.util.ArrayList;

public class miniminiprojectV01
{
	static ArrayList <miniproject_student> stuinfoList = new ArrayList<>();
	static ArrayList <miniproject_pro> proinfoList = new ArrayList<>();
	boolean addstuinfoChk = false; //학생회원가입상태표시
	boolean addproinfoChk = false; //교직원회원가입상태표시
	stuLogin slog = new stuLogin();
	ProLogin plog = new ProLogin();

	miniproject_student findstuac;
	miniproject_pro findproac;

	//miniproject_findidorpwd fidpwd = new miniproject_findidorpwd();
	char i[];
	UserAPI objapi = new UserAPI();
	Scanner s = new Scanner(System.in);
	public static void main(String[] args){

		miniminiprojectV01 obj = new miniminiprojectV01();
		obj.MainMenu();
	}
	void addstuinfo(){//학생회원가입
			addstuinfoChk = false;
			objapi.mLine('=', 35);
			System.out.print("\t 학생회원가입 ");
			objapi.mLine('=', 35);
			String name;//이름
			String field;
			String email;
			String phonenum;// 전화번호 ~
			String id; //학번 임시저장변수
			String password;
			String s1;
			while(true){//이름형식확인
				System.out.print("이름 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 회원가입취소 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[\uAC00-\uD7A3]+$")){//한글형식검사
					name = s1;
				   break;
				}
				 System.out.println("한글만 입력하세요");
				   continue;
			}
			
			while(true){//전공형식확인
				System.out.print("전공 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 회원가입취소 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[\uAC00-\uD7A3]+$")){
					field = s1;
				   break;
				}
				 System.out.println("한글만 입력하세요");
				   continue;
			}

			while(true){//이메일형식확인
				System.out.print("이메일 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 회원가입취소 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
					email = s1;
				   break;
				}
				 System.out.println("정확한 이메일 형식으로 입력하세요");
				   continue;
			}
			while(true){//학번형식확인
				int chk = 0;
				System.out.print("학번 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 회원가입취소 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				
				if(s1.matches("^[0-9]+$") && s1.length() == 9){
					for(miniproject_student i : stuinfoList){
					if(i.getId().equals(s1)){
						chk = 1;
						break;
					}
				}
				if(chk == 1){
					System.out.println("동일한 학번이 존재합니다. 다시 입력하세요.");
					continue;
				}
				else{
					id = s1;
				   break;
				}
				}
				 System.out.println("정확한 ID(학번) 형식으로 입력하세요");
				   continue;
			}

			
				while(true){//비밀번호형식확인
				System.out.print("비밀번호 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 회원가입취소 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[a-z0-9A-Z@]+$") && (s1.length() >= 6 && s1.length() <= 9)){
				password = s1;
				   break;
				}
				 System.out.println("정확한 비밀번호 형식으로 입력하세요");
				   continue;
			}
			
			while(true){//전화번호형식확인
				System.out.print("전화번호 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 회원가입취소 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[0-9@]+$") && s1.length() == 11){
				phonenum = s1;
				   break;
				}
				 System.out.println("정확한 전화번호 형식으로 입력하세요");
				   continue;
			}

			while(true){//최종확인
				System.out.print("회원가입하겠습니까? Y/N");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("y")){
				stuinfoList.add(new miniproject_student(id, name, phonenum, password, field, email));
				addstuinfoChk = true;
				System.out.print("\t회원가입 성공 메인 메뉴로 돌아갑니다.");
				return;
				}
				if(s1.equalsIgnoreCase("n")){
				System.out.print("\t회원가입 취소 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				
			}
			
	}

	void addproinfo(){//교직원회원가입
		addproinfoChk = false;
			objapi.mLine('=', 35);
			System.out.print("\t 교직원회원가입 ");
			objapi.mLine('=', 35);
			String name;//이름
			String field;
			String email;
			String phonenum;// 전화번호 ~
			String id; //id 임시저장변수
			String password;
			String s1;
			while(true){//이름형식확인
				System.out.print("이름 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[\uAC00-\uD7A3]+$")){
					name = s1;
				   break;
				}
				 System.out.println("한글만 입력하세요");
				   continue;
			}
			
			while(true){//전공형식확인
				System.out.print("전공 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[\uAC00-\uD7A3]+$")){
					field = s1;
				   break;
				}
				 System.out.println("한글만 입력하세요");
				   continue;
			}

			while(true){//이메일형식확인
				System.out.print("이메일 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
					email = s1;
				   break;
				}
				 System.out.println("정확한 이메일 형식으로 입력하세요");
				   continue;
			}
			while(true){//교직원ID형식확인
				int chk = 0;
				System.out.print("ID : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[a-zA-Z]+$") && (s1.length() > 0 && s1.length() < 8)){
					for(miniproject_pro i : proinfoList){
					if(i.getId().equals(s1)){
						chk = 1;
						break;
					}
				}
				if(chk == 1){
					System.out.println("동일한 id가 존재합니다. 다시 입력하세요.");
					continue;
				}
				else{
					id = s1;
				   break;
				}
				}
				 System.out.println("정확한 ID 형식으로 입력하세요");
				   continue;
			}

			
				while(true){//비밀번호형식확인
				System.out.print("비밀번호 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[a-z0-9A-Z@]+$") && (s1.length() >= 6 && s1.length() <= 9)){
				password = s1;
				   break;
				}
				 System.out.println("정확한 비밀번호 형식으로 입력하세요");
				   continue;
			}

			while(true){//전화번호형식확인
				System.out.print("전화번호 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[0-9@]+$") && s1.length() == 11){
				phonenum = s1;
				   break;
				}
				 System.out.println("정확한 비밀번호 형식으로 입력하세요");
				   continue;
			}

			while(true){//최종확인
				System.out.print("회원가입하겠습니까? Y/N");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("y")){
				proinfoList.add(new miniproject_pro(id, name, phonenum, password, field, email));
				addproinfoChk = true;
				System.out.print("\t회원가입 성공 메인 메뉴로 돌아갑니다.");
				return;
				}
				if(s1.equalsIgnoreCase("n")){
				System.out.print("\t회원가입 취소 회원가입메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				
			}
	}
	void MainMenu(){//메인메뉴
		while(true){
			objapi.mLine('=', 35);
			System.out.print("\t 학사관리시스템 ");
			objapi.mLine('=', 35);
			System.out.print("1.회원가입\n2.로그인\n3.id찾기\n4.비밀번호찾기\n\nQ.종료");
			objapi.mLine('=', 35);
			System.out.print("\t^ 메뉴를 선택 하세요");
			String s1 = s.nextLine();
			if(inputValidate(s1)){
				continue;
			}
			}
	}
	void addinfomenu(){//회원가입메뉴
		while(true){
			objapi.mLine('=', 35);
			System.out.print("\t 회원가입 ");
			objapi.mLine('=', 35);
			System.out.println("1.학생");
			System.out.println("2.교직원\n");
			System.out.println("Q 메인 메뉴로 돌아갑니다.");
			objapi.mLine('=', 35);
			System.out.print("\t^ 메뉴를 선택 하세요");
			String s1 = s.nextLine();
			if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 메인 메뉴로 돌아갑니다.");
				break;
			}
			if(s1.trim().isEmpty()){
			System.out.println("입력하세요");
			continue;
			}
			if(s1.equals("1")){
				addstuinfo();
				if(addstuinfoChk){
					return;
				}
				continue;
			}
			if(s1.equals("2")){
				addproinfo();
				if(addproinfoChk){
					return;
				}
				continue;
			}
			System.out.println("잘못입력했어요.");
		}
	}


	void loginmenu(){//로그인메뉴
			while(true){
			objapi.mLine('=', 35);
			System.out.print("\t 로그인 ");
			objapi.mLine('=', 35);
			System.out.println("1.학생");
			System.out.println("2.교직원");
			System.out.println("Q");
			String s1 = s.nextLine();
			if(s1.isEmpty()){
				System.out.println("\t^Enter Chk >> empty\n");
				continue;
			}
			if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 메인 메뉴로 돌아갑니다.");
				break;//메인메뉴로 돌아갑니다.
			}
			if(s1.trim().isEmpty()){
			System.out.println("입력하세요");
			continue;
			}
			if(s1.equals("1")){
				slog.stulog();//학생로그인
			
			}
			if(s1.equals("2")){
				plog.proLogMenu();//교직원로그인
			}
			
		}
	}
	void findstuid(){//학생ID찾기메뉴
		
		while(true){
			String ckname;
			String ckemail;
			objapi.mLine('=', 35);
			System.out.print("\t 학생ID찾기 ");
			objapi.mLine('=', 35);
			String s1;
			while(true){//이름형식확인
				System.out.print("이름 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ id찾기취소 id찾기메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[\uAC00-\uD7A3]+$")){//한글형식검사
				   ckname = s1;
				   break;
				}
				 System.out.println("한글만 입력하세요");
				   continue;
			}
			
			while(true){//이메일형식확인
				System.out.print("이메일 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ id찾기취소 id찾기메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
					ckemail = s1;
				   break;
				}
				 System.out.println("정확한 이메일 형식으로 입력하세요");
				   continue;
			}
			for(miniproject_student i : stuinfoList){
				if(i.getName().equals(ckname) && i.getEmail().equals(ckemail)){
					System.out.println("학생id는 : " + i.getId());
					return;
				}
			}
			System.out.println("해당한 학생정보가 없습니다");
			
	}
	}

	void findproid(){//교직원ID찾기메뉴
		
		while(true){
			String ckname;
			String ckemail;
			objapi.mLine('=', 35);
			System.out.print("\t 교직원ID찾기 ");
			objapi.mLine('=', 35);
			String s1;
			while(true){//이름형식확인
				System.out.print("이름 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ id찾기취소 id찾기메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[\uAC00-\uD7A3]+$")){//한글형식검사
				   ckname = s1;
				   break;
				}
				 System.out.println("한글만 입력하세요");
				   continue;
			}
			
			while(true){//이메일형식확인
				System.out.print("이메일 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ id찾기취소 id찾기메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
					ckemail = s1;
				   break;
				}
				 System.out.println("정확한 이메일 형식으로 입력하세요");
				   continue;
			}
			for(miniproject_pro i : proinfoList){
				if(i.getName().equals(ckname) && i.getEmail().equals(ckemail)){
					System.out.println("교직원id는 : " + i.getId());
					return;
				}
			}
			System.out.println("해당한 교직원정보가 없습니다");
	}


	}

	void findidmenu(){//ID찾기메뉴
	while(true){
			objapi.mLine('=', 35);
			System.out.print("\t ID찾기 ");
			objapi.mLine('=', 35);
			System.out.println("1.학생ID찾기");
			System.out.println("2.교직원ID찾기");
			System.out.println("Q");
			String s1 = s.nextLine();
			if(s1.isEmpty()){
				System.out.println("\t^Enter Chk >> empty\n");
				continue;
			}
			if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 메인 메뉴로 돌아갑니다.");
				return;
			}
			if(s1.trim().isEmpty()){
			System.out.println("입력하세요");
			continue;
			}
			if(s1.equals("1")){
				findstuid();//학생id찾기메뉴
				continue;
			}
			if(s1.equals("2")){
				findproid();//교직원id찾기메뉴
				continue;
			}
			System.out.println("잘못입력했어요.");
	}
	}
	
	void findstupw(){
		while(true){
			String ckname;
			String ckid;
			String ckemail;
			objapi.mLine('=', 35);
			System.out.print("\t 학생비밀번호찾기 ");
			objapi.mLine('=', 35);
			/*
			System.out.print("입력 : ");
			String s1 = s.nextLine();
			*/
			//////////////////
			String s1;
			while(true){//이름형식확인
				System.out.print("이름 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 비번찾기취소 비밀번호찾기메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[\uAC00-\uD7A3]+$")){//한글형식검사
					ckname = s1;
				   break;
				}
				 System.out.println("한글만 입력하세요");
				   continue;
			}
			
			while(true){//학번형식확인
				System.out.print("학번 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 비번찾기취소 비밀번호찾메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[0-9]+$") && s1.length() == 9){
					ckid = s1;
				   break;
				}
				 System.out.println("정확한 ID(학번) 형식으로 입력하세요");
				   continue;
			}

			while(true){//이메일형식확인
				System.out.print("이메일 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 비번찾기취소 비밀번호찾기메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
					ckemail = s1;
				   break;
				}
				 System.out.println("정확한 이메일 형식으로 입력하세요");
				   continue;
			}
			for(miniproject_student i : stuinfoList){
				if(i.getName().equals(ckname) && i.getId().equals(ckid) && i.getEmail().equals(ckemail)){
					System.out.println("비밀번호는 : " + i.getPassword());
					return;
				}
			}
			System.out.println("입력정보가 틀린것이 있습니다");
			//////
	}
	}

	void findpropw(){
		while(true){
			String ckname;
			String ckid;
			String ckemail;
			objapi.mLine('=', 35);
			System.out.print("\t 교직원비밀번호찾기 ");
			objapi.mLine('=', 35);
			/*
			System.out.print("입력 : ");
			String s1 = s.nextLine();
			*/
			//////////////////
			String s1;
			while(true){//이름형식확인
				System.out.print("이름 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 비번찾기취소 비밀번호찾기메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[\uAC00-\uD7A3]+$")){//한글형식검사
					ckname = s1;
				   break;
				}
				 System.out.println("한글만 입력하세요");
				   continue;
			}
			
			while(true){//교직원ID형식확인
				System.out.print("ID : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 비번찾기취소 비밀번호찾기메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[a-zA-Z]+$") && (s1.length() > 0 && s1.length() < 8)){
					ckid = s1;
				   break;
				}
				 System.out.println("정확한 ID 형식으로 입력하세요");
				   continue;
			}

			while(true){//이메일형식확인
				System.out.print("이메일 : ");
				s1 = s.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 비번찾기취소 비밀번호찾기메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
					ckemail = s1;
				   break;
				}
				 System.out.println("정확한 이메일 형식으로 입력하세요");
				   continue;
			}
			for(miniproject_pro i : proinfoList){
				if(i.getName().equals(ckname) && i.getId().equals(ckid) && i.getEmail().equals(ckemail)){
					System.out.println("비밀번호는 : " + i.getPassword());
					return;
				}
			}
			System.out.println("입력정보가 틀린것이 있습니다");
			//////
	}
	}

	void findpwmenu(){
		while(true){
			objapi.mLine('=', 35);
			System.out.print("\t 비밀번호찾기 ");
			objapi.mLine('=', 35);
			System.out.println("1.학생비밀번호찾기");
			System.out.println("2.교직원비밀번호찾기");
			System.out.println("Q");
			String s1 = s.nextLine();
			if(s1.isEmpty()){
				System.out.println("\t^Enter Chk >> empty\n");
				continue;
			}
			if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 메인 메뉴로 돌아갑니다.");
				return;
			}
			if(s1.trim().isEmpty()){
			System.out.println("입력하세요");
			continue;
			}
			if(s1.equals("1")){
				findstupw();//학생비밀번호찾기메뉴
				continue;
			}
			if(s1.equals("2")){
				findpropw();//교직원비밀번호찾기메뉴
				continue;
			}
			System.out.println("잘못입력했어요.");
	}

	}
	boolean inputValidate(String _userInput){
			if(_userInput.isEmpty()){
				System.out.println("\t^Enter Chk >> 메뉴번호를 선택 하세요\n");
				return true;
			}
			if(_userInput.equalsIgnoreCase("q")){
				System.out.print("\t^ 시스템을 종료합니다.");
				System.exit(0);
			}
			i = _userInput.toCharArray();
			if(_userInput.length() != 1){
				System.out.println("\t^1 ~ 4 사이의 한자리 숫자를 입력하세요.(양식,2자리숫자ero)");
				return true;
			}
			if(i[0] < 49 || i[0] > 52){
				System.out.println("\t^1 ~ 4 사이의 한자리 숫자를 입력하세요.(숫자범위)");
				return true;
			}
			if(_userInput.equals("1")){
				addinfomenu();
				return true;
			}
			if(_userInput.equals("2")){
				loginmenu();
				return true;
			}
			if(_userInput.equals("3")){
				findidmenu();
				return true;
			}
			if(_userInput.equals("4")){
				findpwmenu();
				return true;
			}
			return false;
	}

}
