Spring
==

## 구조!!
Controller-Service-Repository 구성

## DB
* JDBC
* JDBC Template
* [JPA](#jpa)

DB 연동 시 gradle의 dependency, application.properties(or application.yml)에 설정 필요

## JPA
JPA : ORM 사용 명세 API : Interface : 구현체 Hibernate 등

ORM : 객체 - table mapping, 객체와 쿼리문 분리

Spring Data JPA : EntityMapper 대신 Repository Inteface 사용

#### 컨트롤러(Controller)
    @Controller

가장 처음 사용자의 경로 제어하는 부분
    @RequestMapping("/경로")

를 사용해서 Controller 자체의 경로를 설정하거나 메소드의 경로를 설정할 수 있다

URI 중 쿼리스트링이 /경로?name=<> 식으로 들어오면 아래와 같이 받는다

    public void function(@RequstParam name)

응답은 아래의 어노테이션을 통해 넘겨준다. @ResponseBody로 객체 넘길 경우 MessageConverter(Jackson)에 의해 JSON으로 변환

    @ResponseBody

#### 저장소(Repository)

    @Repository
    public interface repository extends JpaRepository <Entity, Primary Key Type> {}
    
#### 객체 (Entity)
JPA 변경 감지 : 영속성 있는 entity 변경 시 변경을 감지하고 트랙잭션 하거나 enitity manager의 flush() 호출하는 경우 자동으로 update 됨

영속 : 엔티티 매니저가 관리하는 persistence context에 엔티티가 저장된 상태

persist() 호출, find(), JPQ, QueryDSL로 entity 조회 시 영속 상태가 됨

update의 경우 트랜잭션 커밋까지 반영 안되고 영속성 context에 기존 값 남아있을 경우 우선되므로 원하는 쿼리 결과 나오지 않을 수 있다

save() 기존에 없는 객체면 persist하고 있으면 merge하므로 set() 후 save() 하면 해결?

primary key AUTO_INCREMENT 설정시 save 후에 primary key 생성되므로 주의



    @Getter
    @RequiredArgsConstructor //NonNull 설정 파라미터 포함한 생성자
    
    @Entity
    @Table(name="") //생략시 객체 클래스 이름 == 테이블 이름
    public class Object{
         @Id //PRIMARY KEY
         @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
         private Long id;
         @NonNull //lombok
         @Column(nullable = false)
         private String name;
    }
