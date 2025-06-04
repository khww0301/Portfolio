package classes;

import java.util.Scanner;
import java.util.ArrayList;

public class ProLogin{
	UserAPI userAPI = new UserAPI();
	Scanner sc = new Scanner(System.in);
	String userInput = "";
	ArrayList<String> log = new ArrayList<>();

	int errCode = 0;

	miniproject_pro forchklog;
	miniproject_pro nowlog;
	miniproject_student stuchk;
	void identer(){ // ID입력
		userInput = sc.nextLine();
		int st;
		if(userInput.isEmpty()){
			System.out.println("ID를 입력해주세요");
			proLogMenu();
		}
		else if (userInput.equals("q")||userInput.equals("Q"))
			{
				System.out.println("^입력을 종료합니다.");
				errCode = 1;
				return;
			}
		else{
			log.add(0, userInput);
		}
	}
	void PWDenter(){	//PWD 입력
		userInput = sc.nextLine();
		int st;
		if(userInput.isEmpty()){
			System.out.println("PWD를 입력해주세요");
			proLogMenu();
		}
		else if (userInput.equals("q")||userInput.equals("Q"))
			{
				System.out.println("^입력을 종료합니다.");
				errCode = 1;
				return;
			}
		else{
			log.add(1, userInput);
			infoChk();
		}
	}
	void infoChk(){

		for(miniproject_pro i : miniminiprojectV01.proinfoList){
			if(i.getId().equals(log.get(0))){
				forchklog = i;
				if(i.getPassword().equals(log.get(1))){
						nowlog = i;
						proSystem();
						return;
					}
			else{
				System.out.println("비밀번호가 다릅니다.");
				return;
				}
			}
			
	}
	System.out.println("해당하는 ID는 없습니다.");
	}

	void proLogMenu(){	//교직원 로그인메뉴
		while(true){
			errCode = 0;
			userAPI.mLine('=',50);
			System.out.println("\t##교직원로그인##"); 
			userAPI.mLine('=',50);
			System.out.println("ID: \n "); 
			identer();
			if(errCode == 1){
			break;
		}
			System.out.println("\n PWD : \n"); 
			PWDenter();
			if(errCode == 1){
			break;
		}
			userAPI.mLine('-',50);

			}
		}
		
		void proSystem(){	//교직원시스템
			
			while(true){
				userAPI.mLine('=',50);
				System.out.println("\t\t## 교직원시스템 ##\n");
				userAPI.mLine('=',50);
				System.out.println("1.개인정보수정 \n");
				System.out.println("2.개인정보조회\n");
				System.out.println("3.성적관리\n");
				System.out.println("4.출석관리\n");
				System.out.println("5.로그아웃\n");
				System.out.println("Q.로그아웃.");
				userAPI.mLine('-',50);
				String _userInput = sc.nextLine();
			
			if(_userInput.equalsIgnoreCase("q")){
				logout();
				return;
			}
			switch(_userInput){
			case"1":
				editInfo();
				break;
			case"2":
				viewInfo();
				break;
			case"3":
				gradeManager();
				break;
			case"4":
				attenManager();
				break;
			case"5":
				logout();
				break;
			}
		}
	}
	//-------------------------------------------------------------
		void editInfo(){	//교직원개인정보수정
			while(true){
				userAPI.mLine('=',50);
				System.out.println("\t\t## 교직원개인정보수정 ##\n");
				userAPI.mLine('=',50);
				System.out.println("1.비밀번호수정 \n");
				System.out.println("2.email수정\n");
				System.out.println("3.전화번호수정\n");
				System.out.println("Q.이전으로 이동합니다.");
				userAPI.mLine('-',50);
				String _userInput = sc.nextLine();
			
			if(_userInput.equalsIgnoreCase("q")){
				System.out.println("\t이전 메뉴로 이동합니다.");
				return;
			}
			switch(_userInput){
			case"1":
				pwdEdit();
				break;
			case"2":
				emailEdit();
				break;
			case"3":
				telNumEdit();
				break;
			}
		}
	}
	void pwdEdit(){		//비밀번호수정
			userAPI.mLine('=',50);
			System.out.println("\t\t## 비밀번호수정 ##\n");
			userAPI.mLine('=',50);
			System.out.println("수정전 비밀번호 : " + nowlog.getPassword());
		while(true){//비밀번호형식확인
				System.out.print("비밀번호 : ");
				String s1 = sc.nextLine();
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
	}
	void emailEdit(){	//이메일수정
			userAPI.mLine('=',50);
			System.out.println("\t\t## 비밀번호수정 ##\n");
			userAPI.mLine('=',50);
			System.out.println("수정전 email : " + nowlog.getEmail());
			while(true){//이메일형식확인
				System.out.print("이메일 : ");
				String s1 = sc.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 수정취소 재인정보수정메뉴로 돌아갑니다.");
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
	}
	void telNumEdit(){	//전화번호수정
			userAPI.mLine('=',50);
			System.out.println("\t\t## 전화번호수정 ##\n");
			userAPI.mLine('=',50);
			System.out.println("수정전 전화번호 : " + nowlog.getPhonenum());
			while(true){//전화번호형식확인
				System.out.print("전화번호 : ");
				String s1 = sc.nextLine();
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
				 System.out.println("정확한 비밀번호 형식으로 입력하세요");
				   continue;
			}
	}
	//----------------------------------------------------------

	void viewInfo(){	//개인정보조회
			
			while(true){
				userAPI.mLine('=',50);
				System.out.println("\t\t## 교직원개인정보조회 ##\n");
				userAPI.mLine('=',50);
				
			System.out.println("ID : " + nowlog.getId());
			System.out.println("비밀번호 : " + nowlog.getPassword());
			System.out.println("이메일 : " + nowlog.getEmail());
			System.out.println("이름 : " + nowlog.getName());
			System.out.println("전공 : " + nowlog.getField());
			System.out.println("전화번호 : " + nowlog.getPhonenum());
			System.out.println("\nQ.이전으로 이동합니다.");

				String _userInput = sc.nextLine();
			
			if(_userInput.equalsIgnoreCase("q")){
				System.out.println("\t이전 메뉴로 이동합니다.");
				return;
			}
		}
	}
	//----------------------------------------------------------

	void gradeManager(){ // 성적관리

			while(true){
				userAPI.mLine('=',50);
				System.out.println("\t\t## 성적관리 ##\n");
				userAPI.mLine('=',50);
				System.out.println("1.성적기입 \n");
				System.out.println("2.성적수정\n");
				System.out.println("Q.이전으로 이동합니다.");
				userAPI.mLine('-',50);
				String _userInput = sc.nextLine();

			if(_userInput.equalsIgnoreCase("q")){
				System.out.println("\t이전 메뉴로 이동합니다.");
				return;
			}
			switch(_userInput){
			case"1":
				gradeInput();
				break;
			case"2":
				gradeEdit();
				break;
			}
		}
	}
	void gradeInput(){		//성적기입
				boolean chk_for = false;
				ArrayList<String[]> result1 = new ArrayList<>();//성적
				userAPI.mLine('=',50);
				System.out.println("\t\t## 성적기입 ##\n");
				userAPI.mLine('=',50);
				String rname;
				String rnum;
				/////////////////////////////////////////////
				String name;
				String id;
				String s1;
				while(true){//이름형식확인
				System.out.print("학생이름 : ");
				s1 = sc.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 성적관리메뉴로 돌아갑니다.");
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
			
			while(true){//학번형식확인
				//int chk = 0;
				System.out.print("학번 : ");
				s1 = sc.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 성적관리메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				
				if(s1.matches("^[0-9]+$") && s1.length() == 9){
					id = s1;
					 for(miniproject_student i : miniminiprojectV01.stuinfoList){
				//System.out.println("이름: " + i.getName() + ", 학번: " + i.getId());
				
				if(id.equals(i.getId()) && name.equals(i.getName())){
					stuchk = i;
					chk_for = true;
					//System.out.println(stuchk);
					break;
				}
			}
				if(chk_for){
					break;
				}
					System.out.println("학생정보가 없습니다.");
					continue;
				}
				else{
					System.out.println("정확한 학번형식으로 입력하세요.");
				}
			}
			////////////////////////////////////////
			if(true){
				while(true){//과목형식확인
				System.out.print("과목명 : ");
				s1 = sc.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 성적관리메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[\uAC00-\uD7A3]+$")){
					rname = s1;
				   break;
				}
				 System.out.println("한글만 입력하세요");
				   continue;
			}
			while(true){//성적형식확인
				System.out.print("성적 : ");
				s1 = sc.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 성적관리메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^(100|[1-9]?[0-9])$")){
					rnum = s1;
				   break;
				}
				 System.out.println("0~100사이의 숫자만 입력하세요");
				   continue;
			}
			
			result1 = stuchk.getResult();
			result1.add(new String[]{rname, rnum});
			stuchk.setResult(result1);
			System.out.println("성적기입완료");
			}

	}

	void gradeEdit(){		//성적수정
				boolean chk_for = false;
				boolean in_chk = false;
				String[] c = new String[2];
				ArrayList<String[]> result1 = new ArrayList<>();//성적
				userAPI.mLine('=',50);
				System.out.println("\t\t## 성적수정 ##\n");
				userAPI.mLine('=',50);
				String rname;
				String rnum;
				/////////////////////////////////////////////
				String name;
				String id;
				String s1;
				while(true){//이름형식확인
				System.out.print("학생이름 : ");
				s1 = sc.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 성적관리메뉴로 돌아갑니다.");
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
			
			while(true){//학번형식확인
				//int chk = 0;
				System.out.print("학번 : ");
				s1 = sc.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 출석관리메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				
				if(s1.matches("^[0-9]+$") && s1.length() == 9){
					id = s1;
					 for(miniproject_student i : miniminiprojectV01.stuinfoList){
				//System.out.println("이름: " + i.getName() + ", 학번: " + i.getId());
				
				if(id.equals(i.getId()) && name.equals(i.getName())){
					stuchk = i;
					chk_for = true;
					//System.out.println(stuchk);
					break;
				}
			}
				if(chk_for){
					break;
				}
					System.out.println("학생정보가 없습니다.");
					continue;
				}
				else{
					System.out.println("정확한 학번형식으로 입력하세요.");
				}
			}
			////////////////////////////////////////////////////////
			 if(stuchk.getResult().size() != 0){
					while(true){//과목형식확인
				result1 = stuchk.getResult();
				System.out.print("과목명 : ");
				s1 = sc.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 성적관리메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				if(s1.matches("^[\uAC00-\uD7A3]+$")){
					c[0] = s1;
					for(int i = 0; i < result1.size(); i++){
						if(result1.get(i)[0].equals(s1)){
							in_chk = true;
							while(true){//성적형식확인
							System.out.println("원 : " + result1.get(i)[1]);
							System.out.print("성적 : ");
							s1 = sc.nextLine();
							if(s1.equalsIgnoreCase("q")){
							System.out.print("\t^ 성적관리메뉴로 돌아갑니다.");
							return;
							}
							if(s1.trim().isEmpty()){
							System.out.println("입력하세요");
							continue;
							}
							if(s1.matches("^(100|[1-9]?[0-9])$")){
							c[1] = s1;
							result1.set(i, c);
							stuchk.setResult(result1);
							System.out.println("수정성공");
							return;
							}
							System.out.println("0~100사이의 숫자만 입력하세요");
							continue;
							}
						}
					}
					
				}
				 System.out.println("한글만 입력하세요");
				   continue;
			}
			 }

	}
	//--------------------------------------------------------
	void attenManager(){	//출석관리

			while(true){
				userAPI.mLine('=',50);
				System.out.println("\t\t## 출석관리 ##\n");
				userAPI.mLine('=',50);
				System.out.println("1.출석기입 \n");
				System.out.println("2.출석수정\n");
				System.out.println("Q.이전으로 이동합니다.");
				userAPI.mLine('-',50);
				String _userInput = sc.nextLine();

			if(_userInput.equalsIgnoreCase("q")){
				System.out.println("\t이전 메뉴로 이동합니다.");
				return;
			}
			switch(_userInput){
			case"1":
				attenInput();
				break;
			case"2":
				attenEdit();
				break;
			}
		}
	}
	void attenInput(){		//출석기입
				boolean chk_for = false;
				stuchk = null;
				userAPI.mLine('=',50);
				System.out.println("\t\t## 출석기입 ##\n");
				userAPI.mLine('=',50);
				String name;
				String id;
				String s1;
				while(true){//이름형식확인
				System.out.print("학생이름 : ");
				s1 = sc.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 출석관리메뉴로 돌아갑니다.");
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
			
			while(true){//학번형식확인
				//int chk = 0;
				System.out.print("학번 : ");
				s1 = sc.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 출석관리메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				
				if(s1.matches("^[0-9]+$") && s1.length() == 9){
					id = s1;
					 for(miniproject_student i : miniminiprojectV01.stuinfoList){
				//System.out.println("이름: " + i.getName() + ", 학번: " + i.getId());
				
				if(id.equals(i.getId()) && name.equals(i.getName())){
					stuchk = i;
					chk_for = true;
					//System.out.println(stuchk);
					break;
				}
			}
				if(chk_for){
					break;
				}
					System.out.println("학생정보가 없습니다.");
					continue;
				}
				else{
					System.out.println("정확한 학번형식으로 입력하세요.");
				}
			}
			
				if(stuchk.getAttendance() == null){
					 while(true){
					System.out.println("출석입력 : ");
					s1 = sc.nextLine();
					if(s1.matches("^[oxw]+$") && s1.length() == 12){
						stuchk.setAttendance(s1);
						System.out.println("출석입력완료");
						break;
					}
					if(s1.trim().isEmpty()){
					System.out.println("입력하세요");
					continue;
					}
					System.out.println("정확한 형식으로 입력하세요");
					continue;
				}
				}
				else{
				 System.out.println("출석 기입 완료된 학생입니다.");
					 return;
			}
			

			
			

	}
	void attenEdit(){		//출석수정
				boolean chk_for = false;
				stuchk = null;
				char[] c;
				String sendtostuattendance;
				userAPI.mLine('=',50);
				System.out.println("\t\t## 출석수정 ##\n");
				////////
				String name;
				String id;
				String s1;
				while(true){//이름형식확인
				System.out.print("학생이름 : ");
				s1 = sc.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 출석관리메뉴로 돌아갑니다.");
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
			
			while(true){//학번형식확인
				//int chk = 0;

				System.out.print("학번 : ");
				s1 = sc.nextLine();
				if(s1.equalsIgnoreCase("q")){
				System.out.print("\t^ 출석관리메뉴로 돌아갑니다.");
				return;
				}
				if(s1.trim().isEmpty()){
				System.out.println("입력하세요");
				continue;
				}
				
				if(s1.matches("^[0-9]+$") && s1.length() == 9){
					id = s1;
					 for(miniproject_student i : miniminiprojectV01.stuinfoList){
				//System.out.println("이름: " + i.getName() + ", 학번: " + i.getId());
				
				if(id.equals(i.getId()) && name.equals(i.getName())){
					stuchk = i;
					chk_for = true;
					//System.out.println(stuchk);
					break;
				}
			}
				if(chk_for){
					break;
				}
					System.out.println("학생정보가 없습니다.");
					continue;
				}
				else{
					System.out.println("정확한 학번형식으로 입력하세요.");
				}
				
				
			

			}
			
			if(stuchk.getAttendance() != null){
				while(true){
					sendtostuattendance = "";
					c = stuchk.getAttendance().toCharArray();
					System.out.println("원래 출석 : " + stuchk.getAttendance());
					System.out.print("주차 : ");
					s1 = sc.nextLine();
					if(s1.equalsIgnoreCase("q")){
					System.out.print("\t^ 출석관리메뉴로 돌아갑니다.");
					return;
					}
					if(s1.matches("^(1[0-2]|[1-9])$")){
						int chkatt =  Integer.parseInt(s1) - 1;
						while(true){
							System.out.print("원 : " + c[chkatt] +"수정 : ");
							s1 = sc.nextLine();
							if(s1.matches("^[oxw]+$") && s1.length() == 1){
								c[chkatt] = s1.charAt(0);
								break;
							}
							else{
								System.out.println("정확한 형식으로");
							}
						}
						for(int i = 0; i < c.length; i++){

						sendtostuattendance += c[i];
						}
						stuchk.setAttendance(sendtostuattendance);
					}
					
				}
			}
			else{
				System.out.println("아직 출석가입안된 학생입니다.");
				return;
			}

			/////////
	}
	//--------------------------------------------------------
	void logout(){
		proLogMenu();
	}

/*
	public static void main(String[] args){
		ProLogin obj = new ProLogin();
		obj.proLogMenu();
		
	}*/
}