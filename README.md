[//]: # (# be14-2nd-SAMSUNG-Dieat-BE)

[//]: ![](https://github.com/user-attachments/assets/a5362d12-edad-4d7c-921b-e2766741756b)
![](https://github.com/user-attachments/assets/2906b038-99fe-464b-acef-16372fa2078f)

---

# 팀원 소개
| ![img]() | ![img]() | ![img]() | ![img]() | ![img]() | ![img]() |
| --- | --- | --- | --- | --- | --- |
| 이성준 | 박지원 | 고윤석 | 고도연 | 권민수 | 강수지 |

---

# Git 폴더 구조
```
📂 Dieat
⎿ 📂 SQL
  ⎿ 📂 DDL
    ⎿ 💬 각 테이블 생성 sql
  ⎿ 📂 DUMMY_DATA
    ⎿ 💬 더미 데이터 생성 sql
  ⎿ 📂 TRIGGER
    ⎿ 💬 트리거 관련 sql
⎿ 📂 dieat
  ⎿ 📂 회원 정보: member
  ⎿ 📂 회원 개인 정보
  ⎿ 📂 탈퇴한 회원 정보
  ⎿ 📂 공공 데이터 / 사용자 등록 음식
  ⎿ 📂 음식 / 식단 정보
  ⎿ 📂 공지사항 / 문의사항
  ⎿ 📂 자유 / 식단 공유 / 성공기 공유 게시판
  ⎿ 📂 신고 / 차단
⎿ 📂 dieatmember
  ⎿ 💬 회원 정보 관련 기능 MSA 
⎿ 📂 spring-gate-way
  ⎿ 💬 게이트웨이
⎿ 📂 user-data-food
  ⎿ 💬 사용자 등록 음식 관련 기능 MSA
```

---

# _DI-EαT!_
>_“지속 가능한 식단, 체계적인 관리”_  

식단 기록부터 추천, 배열까지 한 번에!  
다잇은 <b>건강한 다이어트를 위한 <u>맞춤형 식단 관리 서비스</u></b>입니다.

## 다이어트, 다들 해 보셨죠?
> “적게 먹고, 많이 움직이면 된다.”

간단한 공식 같지만, 막상 실천해 보면 절대 간단하지 않습니다.

### 🥗 운동보다 식단을 선택하는 사람들,  
포케 한 그릇으로 버텨 보지만 결국 질리고, 포기하고...

유튜브나 ChatGPT에서 `다이어트에 좋은 음식`, `하루 칼로리`, `3대 영양소 비율`을 검색해 보면

![](https://github.com/user-attachments/assets/a77e256c-5042-4201-8328-dfd8a6f4856c)

이렇게 정보는 많지만, 정작 나에게 딱 맞는 식단을 구성하는 건 어렵습니다.

1. 칼로리를 계산하고
2. 영양소 비율을 맞추고 
3. 음식 하나하나 검색해서 조합하고

복잡하고 귀찮고, 무엇보다 *<u>지칩니다.</u>*

### ❓ 유튜버 식단 따라 하면 끝?

안타깝지만 사람마다 필요한 영양소는 *<u>다릅니다.</u>*  
누군가에겐 완벽한 식단이,  
당신에겐 탄수화물이 과하거나 단백질이 부족할 수도 있습니다.

### 💡 그래서 필요한 건,
식단을 직접 만들지 않아도 나에게 맞는 식단을 쉽게 찾고 저장할 수 있는,  
식단을 나에게 맞게 커스텀하고 공유하고 소통할 수 있는,
> 나에게 맞는 식단을 쉽게 검색할 수 있는 서비스

## ✨ 그래서 저희가 만들었습니다!
### 당신만의 다이어트 식단 플랫폼, `다잇(DI-EαT)`
- 🔍 영양소 기준으로 식단 검색 가능  
칼로리, 단백질, 탄수화물, 지방까지! 딱 맞는 한 끼를 찾아보세요.
- 🍱 맞춤 식단 커스텀 & 저장  
내 입맛과 영양소에 맞게 직접 수정하고 저장할 수 있어요.
- 📢 식단 공유 & 커뮤니티  
다른 사람들과 식단을 공유하고 소통하면서 지치지 않는 다이어트!

> ## 🏃🏻 다이어트, 이제는 복잡할 필요 없습니다.
### 다잇과 함께, 쉽고 맛있고 체계적인 식단 관리 시작해 보세요!

---

## 📌 프로젝트 개요
- **프로젝트명**: 식단 다이어트 매니저 (DIEAT)
- **목표**: 사용자의 체중 감량을 도움까지 위해 식단을 기록하고, 맞추형 식단을 추천 및 배열하는 웹 서비스 개발
- **기간**: 2025.02.27 ~ 2025.03.26
- **기술 스택**: Java, Spring Boot, Spring Security, MariaDB, Docker, redis, HTML 등

---

## 🧱 도메인 주도 설계 (DDD)
| 도메인                 | 설명                      |
|---------------------|-------------------------|
| 사용자 (User)          | 회원가입, 로그인, 개인 신체 정보 입력  |
| 식단 (Diet)           | 음식 정보 기록, 하루 식단 요약      |
| 식품 DB (Food)        | 음식명, 영양소 정보 저장          |
| 배열 (Analysis)       | 하루 섭취량 분석, 권장 섭취 기준과 비교 |

[//]: # (| 추천 &#40;Recommendation&#41; | 사용자 맞춤 식단 추천 알고리즘 적용    |)

![](https://github.com/user-attachments/assets/f4529c6b-2550-4b43-b28f-12bc8d9fa394)

> 📌 각 도메인은 독립적인 Bounded Context로 나누며, Aggregate Root를 기준으로 엔터트리 관계를 구성했습니다.

---

## **🧠 논리 모델링 (ERD)**

```
[User] ---< [Diet] >--- [Food]
                  |
             [Analysis]
                  |
           [Recommendation]

```

> ### 주요 관계:
> 
> - 한 명의 사용자는 여러 식단을 기록할 수 있습니다.
> - 식단은 여러 음식으로 구성됩니다.
> - 배열 및 추천 결과는 식단을 기반으로 생성됩니다.

---

## 🛠️ 물리 모델링 (DB 스키마 일반)
![](https://github.com/user-attachments/assets/f5747103-2739-4348-bff5-d747374618b5)

## 논리 모델링
![](https://github.com/user-attachments/assets/7cbcb938-bdf0-42ca-b377-417305ccda4d)

---

## 🗂️ WBS (Work Breakdown Structure)
[//]: ![](https://github.com/user-attachments/files/19461901/SHEET.-.Google.Sheets.pdf)
![](https://github.com/user-attachments/assets/6808b82c-db38-4f6d-a898-5f2dde3c66dc)

---

## 📋 요구사항 명세서 (Summary)

| 기능 | 설명 |
|------|------|
| 회원가입 / 로그인 | 이메일 기반 인증 |
| 신체정보 입력 | 키, 체중 등 건강 관리 정보 저장 |
| 식단 기록 | 날짜별 음식 정보 기록 |
| 식단 배열 | 영양소 섬치량 배열 제공 |
| 식단 추천 | 현재 상황에 맞는 음식 제안 |

---

## 단위 테스트 결과
<details>
  <summary>
    Meal
  </summary>
  <img src="https://github.com/user-attachments/assets/fee5a422-efa5-4e0a-978e-d26a56ad1dc8">
</details>

<details>
  <summary>
    Open Data Foor
  </summary>
  <img src="https://github.com/user-attachments/assets/ef85ac21-2532-4100-8f00-7eded75e3029">
</details>

<details>
  <summary>
    Diet Post
  </summary>
  <img src="https://github.com/user-attachments/assets/917c373b-bf24-41b7-a510-36b944d55399">
</details>

<details>
  <summary>
    Success Post
  </summary>
  <img src="https://github.com/user-attachments/assets/bfea5f96-4f2e-4efe-a981-4b5eea274f3c">
</details>

<details>
  <summary>
    User Data Food
  </summary>
  <img src="https://github.com/user-attachments/assets/41d34c3d-95c5-4019-b618-a8106045830f">
  <img src="https://github.com/user-attachments/assets/b55bc7d3-3955-4229-8931-a037d8cb3623">
</details>

---

## 🕊️ POSTMAN
- 식단
  <details>
    <summary>게시글 등록</summary>
    <img src="https://github.com/user-attachments/assets/8f4e9263-5951-40ec-862f-4bb1750c6e76">
  </details>

  <details>
    <summary>게시글 수정</summary>
    <img src="https://github.com/user-attachments/assets/d4c42cc2-e7e2-4f88-8fb7-738f77951ad4">
  </details>

  <details>
    <summary>게시글 전체 조회</summary>
    <img src="https://github.com/user-attachments/assets/8d8fa8a5-7681-4a41-8ee7-f4818a70f15f">
  </details>

  <details>
    <summary>단일 게시글 상세 조회</summary>
    <img src="https://github.com/user-attachments/assets/49848e3b-e0b8-4be4-a1f4-3a392cb5c002">
  </details>

  <details>
    <summary>페이징네이션</summary>
    <img src="https://github.com/user-attachments/assets/e845a1de-0d0e-4353-80f5-7673d5fb455c">
  </details>
  
  <details>
    <summary>영양소 범위로 조회</summary>
    <img src="https://github.com/user-attachments/assets/771769b6-f567-49cc-a286-0bdca76fdc19">
  </details>

- 회원
  <details>
    <summary>로그인</summary>
    <img src="https://github.com/user-attachments/assets/b4d2a3f2-a2b7-4038-840e-072432740d9a">
  </details>
  
  <details>
    <summary>회원 가입</summary>
    <img src="https://github.com/user-attachments/assets/031c2679-f316-489b-9288-dbb035cb0d6b">
  </details>

- 댓글
  <details>
    <summary>댓글 등록</summary>
    <img src="https://github.com/user-attachments/assets/8f6aa988-b7a5-4d45-80e8-82ae792ba337">
  </details>
  
  <details>
    <summary>댓글 수정</summary>
    <img src="https://github.com/user-attachments/assets/2ea6adfb-87d4-4f5e-9077-2336b43bf299">
  </details>
  
  <details>
    <summary>댓글 삭제(soft)</summary>
    <img src="https://github.com/user-attachments/assets/d70a7fe0-4685-46e3-ae65-f6fc32ae31a7">
  </details>
  
  <details>
    <summary>특정 게시글의 댓글 조회</summary>
    <img src="https://github.com/user-attachments/assets/a1c8c9da-7067-41b7-b625-42fc67f0642d">
  </details>

- 사용자 데이터 음식 평가
  <details>
    <summary>수정이 필요해요</summary>
    <img src="https://github.com/user-attachments/assets/6d3627fd-6db2-401c-a93d-a621896e3d87">
  </details>
  
  <details>
    <summary>음식 정보 정확해요</summary>
    <img src="https://github.com/user-attachments/assets/824a8de7-803c-4a79-a646-f1984b5b6b76">
  </details>
  
  <details>
    <summary>평가 삭제</summary>
    <img src="https://github.com/user-attachments/assets/92918f28-73e3-4aa2-bb05-66607035f009">
  </details>

- 사용자 데이터 음식
  <details>
    <summary>음식 추가</summary>
    <img src="https://github.com/user-attachments/assets/8bc895b5-f891-4eb7-8c50-a813e3cb8de9">
  </details>
  
  <details>
    <summary>음식 삭제</summary>
    <img src="https://github.com/user-attachments/assets/7ab950bd-56ab-47d0-90b4-8bd1209afdac">
  </details>

---

## 🤝 동료 평가 (Peer Review)

| 팀원 | 기억도 | 강점 | 감정점 |
|------|--------|------|--------|
| 강수지 |  |  |  |
| 고도연 |  |  |  |
| 고윤석 |  |  |  |
| 권민수 |  |  |  |
| 박지원 |  |  |  |
| 이성준 |  |  |  |
