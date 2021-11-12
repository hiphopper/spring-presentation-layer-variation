# lucy-xss-servlet-filter 사용
OWASP top 10 대 취약점 중 Cross Site Scripting (XSS) 방지를 위하여 사용
> Production: [Lucy Github](https://github.com/naver/lucy-xss-servlet-filter, "제공경로")
>> 가이드에서 **메모리를 효율적으로 쓰는 SAX 방식의 HTML 파싱 모듈 제공**한다하여 SAX 방식을 기본으로 구성
> 
>> 기본적으로 모든 event attribute 를 방지


### 정보 참고
* [XSS 취약 페이지 구현 및 공격 실습](https://gomguk.tistory.com/61, "땅콩킹땅콩 블로그")
* [XSS(Cross Site Scripting) 공격의 개요와 실습](https://swk3169.tistory.com/23, "swk의 지식저장소 블로그")

### 변화 가능성
1. `href` 속성의 Domain 제한

   - `com.gsk.presentation.lucy.config.listener.WhilteDomainListener` 에서 `WHITE_DOMAINS` 항목을 제외한 모든
      값을 '/' 로 변경
   - `src` 속성도 동일하게 Domain 제한이 가능 할 것 같음