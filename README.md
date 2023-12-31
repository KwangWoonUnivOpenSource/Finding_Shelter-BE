# 🔍 Finding_Shelter   
주소 정보를 입력하면 빠르게 가까운 대피소 3곳을 알려주는 서비스
- 위급상황에 어디로 가야할지 안내하고, 각 상황에 반드시 해야할 지침을 제시하는 웹사이트를 제공하고자 한다.

> 광운대학교 2023년 2학기 <오픈소스소프트웨어개발> 교과목의 8조 팀프로젝트 결과물입니다.
  
## 💡 소프트웨어의 기능 

- 위급 상황 발생 시 긴급 대피 요령을 알려준다.
- 해당 서비스로 주소 정보를 입력하여 요청하면 주소 위치 기준에서 가까운 대피소 3곳을 추출한다.
- 입력한 주소 정보에서 정해진 반경(10km) 내에 있는 대피소 3곳을 가까운 순서대로 추천한다.
- 추출한 대피소 데이터는 길안내 URL 및 로드뷰 URL로 제공한다.
    - 길안내 URL : http://localhost:8080/dir/3Ta
    - 로드뷰 URL : https://map.kakao.com/link/roadview/37.402056,127.108212

[외부 API(카카오 주소 검색 API](https://developers.kakao.com/docs/latest/ko/local/dev-guide))와 [공공 데이터(대피소 현황 정보)를 활용헀다.
추천된 대피소 길 안내는 [카카오 지도 및 로드뷰 바로가기 URL](https://apis.map.kakao.com/web/guide/#routeurl)로 제공된다. 


## 💁 사용 방법 💁 

**대피소 찾기 페이지**

긴급 대피 요령 확인하기

주소 검색 버튼 클릭 시 Kakao 우편번호 서비스로 이동 

현재 위치 주소 정보를 입력하면 대피소 결과 페이지로 이동

- 주소는 도로명 주소 또는 지번을 입력하여 요청 받는다.
- 주소는 정확한 상세 주소(동, 호수)를 제외한 주소 정보를 이용하여 추천 한다.
    - ex) 서울 광운로 20

**대피소 결과 페이지**

현재 위치에서의 거리가 가까운 대피소 순으로 3곳을 확인할 수 있다.

대피소의 이름, 대피소 주소, 입력 주소에서의 거리 또한 알 수 있다. 

길안내 URL을 클릭 시 Kakao Map으로 이동하여 길 찾기를 할 수 있도록 한다. 

로드뷰 URL을 클릭 시에는 대피소 주변을 확인하여 정확한 위치를 파악할 수 있도록 한다. 

- ex) 길안내 URL : http://localhost:8080/dir/3Ta
    - 로드뷰 URL : https://map.kakao.com/link/roadview/37.402056,127.108212
 
## 📲 설치 방법

https://findin-shelter-fe.vercel.app/


## ⚙ Shelter Recommendation Process   

<img width="484" alt="2023-11-15 174420" src="https://github.com/KwangWoonUnivOpenSource/Finding_Shelter-BE/assets/105183327/81c7c613-0e9a-4a97-b8ee-e1d950100d2b">

## ⚙ Direction Shorten Url Process

<img width="457" alt="2023-11-15 174344" src="https://github.com/KwangWoonUnivOpenSource/Finding_Shelter-BE/assets/105183327/c6c949cb-9eb0-4935-b2f1-87e03ca12a5f">


## 📑 Feature List   

- Spring Data JPA를 이용한 CRUD 메서드 구현하기      
- Spock를 이용한 테스트 코드 작성하기     
- 카카오 주소검색 API 연동하여 주소를 위도, 경도로 변환하기   
- 추천 결과를 카카오 지도 URL로 연동하여 제공하기   
- 공공 데이터를 활용하여 개발하기 (대피소 현황 데이터)    
- base62를 이용한 shorten url 개발하기 (길안내 URL)
- redis를 이용하여 성능 최적화하기
- Spring retry를 이용한 재처리 구현하기 (카카오 API의 네트워크 오류 등에 대한 재처리)
- vercel을 이용한 배포하기
- microsoft azure로 서버 구축하기 


## 🛠 Tech Stack   
- JDK 17
- Spring Boot 3.1.5
- Spring Data JPA
- Gradle
- Lombok
- Github
- MariaDB
- Spock

## 🧾 License 
이 프로젝트는 MIT License를 따른다.

이 소프트웨어를 누구라도 무상으로 제한없이 취급해도 좋다. 단, 저작권 표시 및 이 허가 표시를 소프트웨어의 모든 복제물 또는 중요한 부분에 기재해야 한다.

저자 또는 저작권자는 소프트웨어에 관해서 아무런 책임을 지지 않는다.
