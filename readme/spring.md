
Spring
==

## 구조
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

#### 저장소
    @Repository
    public interface repository extends JpaRepository <Entity, Primary Key Type> {}
    
#### 객체
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