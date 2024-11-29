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

----

## Swagger 설정 (REST API 명세)

- API가 어떤 로직을 수행하는지 설명하고, 어떠 값을 요청하며, 어떤 응답 값을 반환하는지 정리한 자료로써 활용된다.

### 의존성 추가 - springdoc - openapi

- Spring Boot Version 3.x 에는 springfox 의존성이 충돌하여 springdoc-openapi를 사용
- `implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0'`

### @Operation 어노테이션

- summary 옵션: API에 대한 설명
- description 옵션: API에 대한 요약
- response 옵션: 응답 코드 예제

### @Parameter 어노테이션

- required 옵션: @RequestParam이나 @PathVariable에 사용 가능하며, 필수 여부를 나타낸다.
- example 옵션: 어떤 값을 어떻게 작성하면 되는지 간략한 설명

### @Content 어노테이션

- 응답의 미디어 타입 및 상세 정보를 정의한다.

----

## Logback 설정

- 시스템의 상태나 동작 정보를 시간순으로 기록하기 위해 Logback을 사용한다.
- slf4j 이후는 `spring-boot-starter-web`에 내장되어 있어 별도의 의존성을 추가 하지 않아도 된다.

### Logback 특징

- 5개의 로그 레벨 설정이 가능하다.
  - ERROR: 로직 수행 중에 시스템에 심각한 문제가 발생해서 애플리케이션의 작동이 불가능한 경우
  - WARN: 시스템 에러의 원인이 될 수 있는 경고 레벨을 의미한다.
  - INFO: 애클리케이션의 상태 변경과 같은 정보 전달을 위해 사용한다.
  - DEBUG: 애플리케이션의 디버깅을 위한 메시지를 표시하기 위한 레벨을 의미한다.
  - TRACE: DEBUG 보다 더 상세한 메시지를 표현하기 위한 레벨을 의미한다.
- 실제 운영 환경과 개발 환경에서 각각 다른 출력 레벨을 설정해서 로그 확인 가능.

### Logback 설정

- application yml에 `logging.level.root: info` 설정
- 파일로 출력 시 `logging.file.name` & `path` 설정
- 형식을 설정 시 `logginf.pattern.console` & `path` 설정

### Logback 적용

- Logger 객체 활용 시 `private final Logger LOGGER = LoggerFactory.getLogger((GetController.class));`로 설정하고, `LOGGER.info(...)`로 사용할 수 있지만, 아래와 같이 어노테이션 명시로도 사용가능하다.
- `@Slf4j` 어노테이션을 명시하고 `log.info(...)`와 같이 사용한다.
- 컨트롤러에 들어오는 값을 직접 logger로 확인할 때는 변수 값을 명시하여 사용한다.
```java
  @GetMapping(value = "/variable1/{variable}")
  public String getVariable1(@PathVariable String variable){
  LOGGER.info("@PathVariable을 통해 들어온 값: {}", variable);
  return variable;
  }
  ```

## ORM 

- Object Relational Mapping으로 객체 관계 매핑을 의미한다.
- 객체 지향 언어에서 의미하는 객체와 RDB의 테이블을 자동으로 매핑하는 방법이다.
- 클래스는 데이터베이스의 테이블과 매핑하기 위해 만들어진 것이 아니기 때문에 RDB 테이블과 어쩔수 없이 불일치가 존재한다. 이때, 불일치와 제약사항을 해결하는 것이 ORM이다.

### ORM의 장점

- ORM을 사용하면서 데이터베이스 쿼리를 객체지향적으로 조작할 수 있다.
- 재사용 및 유지보수가 편리하다.
- 데이터베이스에 대한 종속성이 줄어든다.

### ORM의 단점

- ORM만으로 온전한 서비스를 구현하기에는 한계가 있다.
- 애플리케이션의 객체 관점과 데이터베이스의 관계 관점 불일치가 발생한다.

----

## JPA

- Java Persistence API로 Java 진영의 ORM 기술 표준으로 채택된 인터페이스의 모음이다.
- ORM이 큰 개념이라면 JPA는 더 구체화된 스펙을 포함한다. 
  - JPA 또한 실제로 동작하는 것이 아니고 어떻게 동작해야하는지 매커니즘을 정리한 표준 명세로 생각하면 된다.

### 하이버네이트

- Java ORM 프레임워크로 JPA가 정의하는 인터페이스를 구현하고 있는 JPA 구현체 중 하나이다.
- 따라서, Spring Data JPA는 스프링 하위 프로젝트 중 하나로 생각하여, CRUD 처리에 필요한 인터페이스를 제공하며, 하이버네이트의 Entity Manager를 직접다루지 않고, Repository를 정의해 사용함으로 spring에 적합한 쿼리를 동적으로 생성하는 방식으로 데이터베이스를 조작한다.
- 이를 통해 하이버네이트에서 자주 사용되는 기능을 더 쉽게 사용할 수 있게 구현한 라이브러리가 Spring Data JPA이다.

----