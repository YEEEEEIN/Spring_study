package com.kopo.test;

//@springformtag
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController14 {
	
/*
* [스프링 폼태그]
* 폼 태그 라이브러리 선언 후 사용
* 스프링 폼태그는 사용범위가 다양함
* 
* <%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
*
* 사용방법: <form: 태그이름>
* 
* [태그종류]
* <form> = 폼의 시작과 끝에 붙음
* <input> = 일반 텍스트를 입력할 필드
* <checkbox>  = 체크박스 다중선택
* <checkboxes> = 체크박스 목록
* <radiobutton> = 단일 선택
* <radiobuttons> = radiobutton 목록
* <password> = 비밀번호 *로 현시
* <option>= <SELECT>에 포함된 목록 구성
* <options> option 목록
* <textarea> = 여러 줄 텍스트 입력
* <hidden> = 웹에 출력 안됨 그러나 파라미터 넘길 때 사용
* <errors> = validation 오류 메시지
* 
* [사용방법]
* <form: form 속성1 = "값1" .... >
* 		//태그입력 - 양식 <input>,<textarea>
* </form:from>
* 
* [form 속성]
* modelAttribute = 참조 객체 설정 (※첫글자가 반드시 소문자여야 함.)
* action = 처리 url 주소
* method = http 방식
* name = 폼 이름
* target = 응답 실행할 프레임 설정
* enctype = MIME 설정 
* accept-charset = 문자 인코딩 설정
* 
* 
* */
	
	
	@GetMapping("/member")
	public String showForm(Model model) {
		Member member = new Member();
		System.out.println("GetMapping ---------");
		System.out.println("아이디 : " + member.getId());
		System.out.println("패스워드 : " + member.getPassword());
		System.out.println("거주도시 : " + member.getCity());
		System.out.println("성별  : " + member.getSex());
		System.out.println("취미  : " + member.getHobby());
		model.addAttribute("member",member);
		return "exam14_01";
	}

}
	

