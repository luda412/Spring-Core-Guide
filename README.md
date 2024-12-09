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

## Persistence Context

- 애플리케이션과 데이터베이스 사이에서 Entity와 레코드의 괴리를 해소하는 기능과 객체를 보관하는 기능을 수행한다.
- Entity 객체가 영속성 켄텍스트에 들어오면 JPA는 Eitity 객체의 매핑 정보를 데이터베이스에 반영하는 작업을 수행한다.
- 생명주기는 세션 단위

### Entity Manager

- Entity를 관리하는 객체
- 데이터베이스에 접근해서 CRUD 작업을 수행한다.

### Entity Manager Factory

- Entity Manager를 만드는 주체
- 생성된 Entity Manager는 Entity를 영속성 컨텍스트에 추가해서 영속 객체로 만드는 작업을 수행하고, 영속성 컨텍스트와 데이터베이스를 비교하면서 실제 데이터베이스를 대상으로 작업을 수행한다.

#### Entity의 생명주기

- 비영속성 - New
- 영속 - Managed
- 준영속성 - Detached
- 삭제 - Removed

----

## Repository Interface 설계

- Spring Data JPA는 JpaRepository를 기반으로 더욱 쉽게 데이터베이스를 사용할 수 있는 아키텍처를 제공한다.
- Entity를 데이터베이스의 테이블과 구조를 생성하는 데 사용했다면 Repository는 Entity가 생성한 데이터베이스에 접근하는 데 사용

----

## DAO와 DAOImpl

- Data Access Object는 데이터베이스에 접근하기 위한 로직을 관리하기 위한 객체이다.
- 비즈니스 로직의 동작 과정에서 데이터를 조작하는 기능은 DAO 객체가 수행한다.
  - Spring Data JPA에서 DAO의 개념은 Repository가 대체한다.

### DAO Interface 생성

- interface로 ProductDAO 클래스를 생성하고 구현하고자하는 insert, select, update, delete 메서드 인터페이스 생성

### DAO 구현체 생성

- ProductDAOImpl 클래스를 생성하고 ProductDAO implements 해준다음 final 변수를 사용하여 ProductRepository 주입
- `@Override` 를 통해 ProductDAO 클래스의 메서드들을 받아준다음 메서드 구현 시작

#### `insertProduct()` 메서드

```java
@Override
public Product insertProduct(Product product) {
  Product savedProduct = productRepository.save(product);
  return savedProduct;
}
```

#### `selectProduct()` 메서드

```java
@Override
public Product selectProduct(Long number) {
    Product selectedProduct = productRepository.getById(number);
    return selectedProduct;
    }
```

#### `updateProductName()` 메서드

```java
@Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> seletedProduct = productRepository.findById(number);

        Product updatedProduct;
        if (seletedProduct.isPresent()){
            Product product = seletedProduct.get();

            product.setName(name);
            product.setUpdateAt(LocalDateTime.now());
            updatedProduct = productRepository.save(product);
        }else {
            throw new Exception();
        }
        return updatedProduct;
    }
```

#### `deleteProduct()` 메서드

```java
@Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            productRepository.delete(product);
        }else {
            throw new Exception();
        }
    }
```

----

## Service Interface & Service Impl

- Service Layer는 클라이언트가 요청한 데이터를 적절하게 가공해서 controller에 넘기는 역할을 한다.
- `getProduct(Long number)`
- `saveProduct(ProductDto productDto)`
- `changeProductName(Long number, String name)`
- `deleteProduct(Long number)` 와 같이 interface를 생성하고 ProductServiceImpl에서 구현체 정의

### ProductServiceImpl

#### getProduct

```java
@Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }
```
- DTO 객체와 Entity 객체가 공존하기 때문에 변환작업이 필요하다.
  - DAO를 이용하여 number 값으로 가져온 데이터를 product에 할당
  - product에서 get메서드로 값을 빼어 DTO 객체에 set메서드로 할당한다.

#### saveProduct

```java
@Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreateAt(LocalDateTime.now());
        product.setUpdateAt(LocalDateTime.now());

        Product savedProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(savedProduct.getNumber());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setPrice(savedProduct.getPrice());
        productResponseDto.setStock(savedProduct.getStock());

        return productResponseDto;
    }
```
- Product Entity형을 가진 객체를 생성하고 DTO를 통해 저장할 객체를 Productdp gkfekd
- Product에 할당 받은 데이터를 DAO의 insert 메서드를 통해 저장한다.

#### changeProduct

```java
@Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product chagedProduct = productDAO.updateProductName(number, name);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(chagedProduct.getNumber());
        productResponseDto.setName(chagedProduct.getName());
        productResponseDto.setPrice(chagedProduct.getPrice());
        productResponseDto.setStock(chagedProduct.getStock());

        return productResponseDto;
    }
```
- DTO를 통해 변경하고자 요청 받은 데이터를 Product 형을 가진 changeProduct에 할당과 동시에 number index에 해당하는 name을 변경
- 변경항 값을 productResponseDto에 담아준 다음 반환

#### deleteProduct

```java
@Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
```
- Repository에서 제공하는 delete 메서드를 사용할 경우 리턴 받는 타입이 지정되어 있지 않기 때문에 void 사용

----

## Controller 생성

### `GetMapping getProduct` 메서드

```java
@GetMapping()
    public ResponseEntity<ProductResponseDto> getProduct(Long number){
        ProductResponseDto productResponseDto = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }
```
- `ResponseEntity` 로 요청을 DTO 형으로 받고 Service의 getProduct 메서드 호출
- 반환 값은 성공시 `HttpStatus.OK` , body는 DTO를 담아서 전송

### `PostMapping createProduct` 메서드

```java
@PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto){
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }
```
- ProductDto 형으로 Body를 통해 요청을 받고 productService의 `saveProduct` 메서드를 통해 product 생성
- 반환 값으로 ProuductResponseDto 전달

### `PutMapping chageProductName` 메서드

```java
@PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductNameDto changeProductNameDto) throws Exception{
        ProductResponseDto productResponseDto = productService.changeProductName(changeProductNameDto.getNumber(), changeProductNameDto.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }
```
- `ChangeProductNameDto` 생성, 요청을 받은 다음
- `productResponseDto`에 담을 때 productService의 `changeProductName` 메서드를 이용한다.
  - 이때, 전달 하는 매개 변수인 number와 name은 요청받은 changePorductNameDto에서 꺼내어 사용

### `DeleteMapping deleteProduct` 메서드

```java
@DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long number) throws Exception{
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
```
- productService의 `deleteProduct`가 void 타입의 메서드 임으로 반환 값을 String으로 설정해준다.
- 요청받은 number 값으로 삭제를 이관하여 데이터를 삭제한다.
  - body에 메시지를 넣어 반환한다.

----