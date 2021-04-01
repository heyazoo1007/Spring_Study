Junit
==

junit 이용해서 service 별 test, 통합 test 등 가능

어노테이션 이용해서 표시

@SpringBootTest 로 통합테스트 가능

@DataJpaTest 사용 시 롤백 가능 (test 정보 db에 남지않게함) 또는 @AfterEach로 db 삭제 구현
     
     @RunWith(SpringRunner.class)
     @DataJpaTest //윗줄과 항상 함께 사용
     @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //내부 h2 db 사용 안할 시