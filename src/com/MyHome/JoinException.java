package com.MyHome;

import java.util.regex.Pattern;

public class JoinException {
	
	//아이디 가능여부 확인
	public void idFormat(String str) throws AuthenException{
		
		if(str.length()<5 || str.length()>10){
			throw new AuthenException("※5~10자 이내의 아이디만 가능합니다");
		}
		
		int cnt1=0;
		int cnt2=0;
		
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
				cnt1++;
			else if(ch>='0' && ch<='9')
				cnt2++;
		}
	
		if(cnt1==0 || cnt2==0)
			throw new AuthenException("※아이디는 영문자와 숫자를 혼용해서 만들어주세요");	
		
	}
	
	//아이디 중복여부 확인
	public void sameId() throws AuthenException {
		throw new AuthenException("※동일한 아이디가 이미 존재합니다");	
	}
	
	
	//비밀번호 확인
	public void pwCheck(String pw1, String pw2) throws AuthenException{
		if(!pw1.equals(pw2))
			throw new AuthenException("※비밀번호가 다릅니다");	
	}
	
	//이름 확인
	public void nameCheck(String name) throws AuthenException{

		boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
		if(!check)
			throw new AuthenException("※이름은 한글로 입력해주세요");	
	}

	//전화번호 확인
	public void phoneCheck(String phone) throws AuthenException{

		boolean check = Pattern.matches("(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", phone);

		if(!check)
			throw new AuthenException("※전화번호 입력 형식은 [XXX-XXXX-XXXX]입니다");	
	}
	
	//중개업자, 판매자/구매자 확인
	public void typeCheck(int type) throws AuthenException{
		if(!(type==1) && !(type==2))
			throw new AuthenException("※번호를 바르게 입력해주세요");
	}
	
	public void n(String n) throws AuthenException{

		if( !n.equals("1") && !n.equals("2") && !n.equals("3") && !n.equals("9"))
			throw new AuthenException("※번호를 제대로 입력해주세요");	
	}
}
