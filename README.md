# 스프링 핵심 가이드 프로젝트

## HTTP GET 메서드 구현

- GET API는 웹 애플리케이션 서버에서 값을 가져올 떄 사용하는 API로 요청에 대한 처리 방법을 아래와 같이 구분한다.

### PathVariable 활용

-  URL에 `{}`를 활용하여 값을 받아 요청하는 방법으로 값을 간단히 전달 할 때 주로 사용하는 방법
-  매개 변수와 그 값을 연결하기 위해 Controller에 `@PathVariable` 어노테이션을 명시하고, 변수의 이름과 요청 URL의 변수의 이름을 동일하게 한다.

### RequestParam 활용

- URL 경로에 쿼리 형식으로 값을 전달하는 방식으로 `?`를 기준으로 Key-Value 형식으로 구성된 전송 방식이다.
- Controller에 `@RequestParam`을 명시하여 쿼리 값과 매핑하여 사용한다.
- 여러 개의 값 전달 시 `&`로 값을 묶어 전달한다.
- 값에 상관 없이 요청을 받을 시에는 `Map` 객체를 활용한다.
  - 예를 들어, 필수 항목이 아닌 경우에는 값을 기입하지 않는 경우가 생긴다. 이러한 경우에는 `Map` 객체로 받아 `<String, String>` 형식으로 Key-Value 를 처리한다. 

### DTO 객체를 활용

- 다른 레이어 간의 데이터 교환에 활용하며 요청을 받고자 하는 형식 혹은 값을 미리 정하여 요청할 값을 명시하는 형태로 DTO를 사용한다.
- DTO 패키지를 선언하고, DTO 클래스에는 Lombok을 활용하여 `Getter`와 `Setter`를 간편화할 수 있다.

----

## HTTP POST 메서드 구현

- POST API는 웹 애플리케이션을 통해 데이터베이스 등의 저장소에 리소를 저장할 때 사용된다.
- HTTP Body에 JSON 형식의 값ㅇ르 담아 전달하면 된다.

### RequestBody 활용

- 클라이언트의 요청에 트래픽 값이 포함 되어 있으며 리소스르 HTTP Body에 담아 전송한다.
- `@RequestMapping` 대신 `@PostMapping`을 사용하면 Method 요소를 정의하지 않아도 된다.
- `@RequestBody` 어노테이션을 매개변수로 정의하면 HTTP Body 내용을 지정된 객체에 매핑하는 역할을 한다.

----

## HTTP PUT 메서드 구현

- 웹 애플리케이션 서버를 통해 데이터베이스 같은 저장소에 존재하는 리소스 값을 업데이트하는 데 사용한다.
- HTTP Body를 이용한 통신 방법을 사용한다.

### RequestBody 활용

- 어떤 값이 들어올지 모르는 경우에 Map 객체를 활용해 값을 받을 수도 있지만, 대부분의 경우 API를 개발한 쪽에서 작성한 명세를 작성한다.

### DTO 객체를 활용 (DTO Type 선언)

- DTO 객체 Type으로 메서드를 선언하여 응답을 반환하는 경우 결과 값이 JSON 형식으로 정렬되어 출력된다.
- 또한, Headers의 Content-Type도 application/json 형식으로 반환된다.

### ResponseEntity를 활용한 PUT 메서드 구현

- HttpEntity 클래스를 활용하여 Headers와 Body로 구성된 Http 요청과 응답을 구성하는 역할을 할 수 있다.
- ResponseEntity는 서버에 들어온 요청에 대해 응답 데이터를 구성해 전달할 수 있으며, Http Status를 활용할 수 있다.

----

## HTTP DELETE 메서드 구현

- 웹 애플리케이션 서버를 통해 데이터베이스 등의 저장소에 있는 리소스를 삭제할 때 사용한다.
- GET 메서드와 같이 URI 값에 넣어 요청을 받는 형식으로 사용한다.

### PathVariable 활용

- URI에 포함된 값을 받아 로직을 처리할 수 있다.
- 어노테이션에 정의한 value의 이름과 메서드의 매개변수 이름을 동일하게 설정해야 삭제할 값이 주입된다.

### RequestParam 활용

- 쿼리스트링을 통해서 값을 받을 수도 있다.