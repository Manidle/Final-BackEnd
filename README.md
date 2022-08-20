# 참고사항
* application.yml 파일에서 각자 Maria DB의 Username 및 Password 변경 할 것
* 스프링부트 2.5 버전 이하로 다운 실패하여 현재 상용중인 2.6.11 버전으로 진행
* DataBase : MariaDB 사용
* DataBase 이름생성 : planergram 통일
* 금주내에 Board / Like 엔티티 생성 후 Join 연결 계획중
* User Entity 향후 변경될 가능성 큼# Final-BackEnd

# develop 브랜치 1차 merge - 김영광
1. Board 엔티티 CRUD
2. User / Board Join
## 변경사항
1. Board 칼럼중 DESC 칼럼 Content로 변경
2. 본래 Post 테이블 이였으나 Board 테이블로 변경
