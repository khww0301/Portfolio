package classes;

class UserAPI{

	void mLine(char vC01, int num01){ 

		for(int i=0; i<num01; i++){
			System.out.print(vC01);
		}
		System.out.println("");
	}

	String mLineReturn(char vC01, int num01){
		System.out.println();
		String c = ""; //리턴보낼 String을 만듬

		for(int i=0; i<num01; i++){
			c += vC01;// -
		}
		return c;
	}
	
}                                                                         