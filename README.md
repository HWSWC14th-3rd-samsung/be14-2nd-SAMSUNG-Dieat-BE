# (# be14-2nd-SAMSUNG-Dieat-BE)

[//]: ![](https://github.com/user-attachments/assets/a5362d12-edad-4d7c-921b-e2766741756b)
![](https://github.com/user-attachments/assets/2906b038-99fe-464b-acef-16372fa2078f)

---

# 팀원 소개
| ![강수지](https://github.com/user-attachments/assets/d89e69c4-b747-480d-9008-d587ecf6ec7b) | ![고도연](https://github.com/user-attachments/assets/a684658d-343f-4747-9eec-b0c8bd0fb01d) | ![고윤석](https://github.com/user-attachments/assets/35814dc7-10b2-48bc-8cab-817e2a9b4b21) | ![권민수](https://github.com/user-attachments/assets/01553124-15de-4f76-91cb-9bdf6cf21283) | ![박지원](https://github.com/user-attachments/assets/2f6470be-866e-49f3-b9b4-4abf91cccb01) | ![이성준](https://github.com/user-attachments/assets/f264b005-3b62-4cc2-9415-bb996f5a7d89) |
| --- | --- | --- | --- | --- | --- |
| 강수지 | 고도연 | 고윤석 | 권민수 | 박지원 | 이성준 |




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

![image](https://github.com/user-attachments/assets/3d6159ec-6847-449e-b710-921f7bd6073d)


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

## API 명세서
<details>
  <summary>user-data-food-controller</summary>
  <img src="https://github.com/user-attachments/assets/c8c6f6bb-2ea9-4e70-b8a3-313d8f6333c6" />
</details>

<details>
  <summary>user-data-food-query-controller</summary>
    <img src="https://github.com/user-attachments/assets/a8222efc-7db4-456d-ba9b-9720ec966108" />
</details>

<details>
  <summary>user-data-food-review-controller</summary>
    <img src="https://github.com/user-attachments/assets/f04b8ad7-11cb-4484-b884-cec60a2f9af5" />
</details>

<details>
  <summary>open-data-food-controller</summary>
    <img src="https://github.com/user-attachments/assets/4a72b568-c6a4-44e8-8d5f-0d2260f5922f" />
</details>

<details>
  <summary>open-data-food-query-controller</summary>
    <img src="https://github.com/user-attachments/assets/6b88bf8a-4b47-4465-9ed7-b8c867bad2ff" />
</details>

<details>
  <summary>diet-post-command-controller</summary>
    <img src="https://github.com/user-attachments/assets/bf8871bd-47d5-4ba7-9406-45e5ee25a017" />
</details>
  
<details>
  <summary>diet-post-query-controller</summary>
    <img src="https://github.com/user-attachments/assets/ff6561cc-4378-4455-a5b7-f671804c7f7d" />
</details>

<details>
  <summary>meal-command-controller</summary>
    <img src="https://github.com/user-attachments/assets/31043e90-c16a-421b-9a41-bdcd87a5b26f" />
</details>

<details>
  <summary>meal-query-controller</summary>
    <img src="https://github.com/user-attachments/assets/e6b2f06d-4e22-407f-aa01-f7fb7f21e178" />
</details>
  
<details>
  <summary>comment-controller</summary>
    <img src="https://github.com/user-attachments/assets/86301813-8338-4b06-92df-e2d9505dfb20">
</details>
  
<details>
  <summary>comment-query-controller</summary>
    <img src="https://github.com/user-attachments/assets/916871c2-12f1-4201-b82e-f3e6008c1e1b" />
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
### 👤 강수지

| Member | Review |
| ------ | ------ |
| 고도연 | 매 회의마다 적극적인 의견 제시로 다양한 기능을 구현하는 게 도움을 줌. 또한 자신의 입장을 명확하고 차분하게 전달하여 중요한 사항을 결정할 때 큰 몫을 함. 당장 해야 하는 일들을 빠르게 파악하여 프로젝트 진행에 문제가 없도록 잘 이끌어 줌.<br>팀원들이 지치지 않게 항상 웃으며 잘 챙겨주어 더욱 힘내서 프로젝트에 임할 수 있었음. |
| 고윤석 | 프로젝트 과정에서 규모가 큰 회원 등록 데이터 파트를 맡아서 책임감 있게 맡은 부분을 잘 개발하였다. 프로젝트 기간 동안 체력적으로 힘든 상황에 팀원들을 잘 독려하여 프로젝트가 잘 진행될 수 있도록 기여하였다. 개발 외적으로도 항상 아이디어를 내주시기 위해서 노력하며 다른 팀원의 아이디어가 잘 다듬어질 수 있도록 신경 써주시는 모습이 프로젝트에 도움이 되었던 것 같다. |
| 권민수 | 프로젝트를 함께하는 동안 현업자의 경험치와 책임감, 그리고 사람 자체에 내재된 다정함과 배려심을 느낄 수 있었습니다. 회의가 진행되는 동안 누구보다 집중하여 팀원들이 미처 인지하지 못했던 허점이나 누락된 요소들을 빠르게 캐치해냈고, 팀 전체의 퀄리티를 한 단계 높이는 데 큰 도움을 주셨습니다.<br>또한 현업에서만 알 수 있는 부분들을 알려주셔서 프로젝트가 한 층 더 빠르게 진행될 수 있었습니다.<br>무엇보다 기억에 남는 것은 팀원들의 사기를 끊임없이 북돋아주는 따뜻한 마음입니다. 일정이 점점 빡빡해지고 피로가 누적됨에도, 본인의 피로를 이겨내고 팀원들에게 선물을 나눠주고, 진심 어린 격려로 팀 전체에 밝은 에너지를 불어넣고 분위기를 환기시켜주셨습니다. 덕분에 팀원들은 몸은 지칠지언정 마음만큼은 지치지 않고 끝까지 함께 달려올 수 있었습니다. |
| 박지원 | 실무 경험을 바탕으로 여러 방면에서 다양한 지식 덕분에 프로젝트를 진행하는데 있어서 도움이 많이 되었습니다. 회의할 때는 의견도 적극적으로 내주시고 또 팀원들이 미처 신경쓰지 못한 부분도 세세하게 신경 써주신 덕분에 어려울 수 있는 부분도 순조롭게 진행할 수 있었습니다.<br>또 프로젝트에서 맡으신 공공데이터 파트는 꼼꼼하게 구현해주셔서 더 나은 결과물을 만들어 낼 수 있었습니다. |
| 이성준 | 우리 팀의 QA 팀장!<br>프로젝트 후반, 모두가 지치고 정신적으로나 체력적으로 한계에 가까워졌을 때, 늘 조용히, 그러나 확실하게 옆에서 힘을 주는 존재였습니다.<br>특히 프로젝트 발표를 끝낸 후, 대부분의 팀원이 체력 방전으로 쓰러질 때까지 이르렀던 상황에서도 혼자 마지막까지 자리를 지키며 문서 정리와 산출물 마무리, QA 관련 작업 등을 묵묵히 처리해주신 모습이 정말 인상 깊었습니다.<br>말보다 행동으로 보여주는 책임감과 성실함, 그리고 보이지 않는 곳에서도 팀을 위해 헌신하는 태도 덕분에 우리 프로젝트는 단단한 마무리를 할 수 있었습니다. |

---

### 👤 고도연

| Member | Review |
| ------ | ------ |
| 강수지 | 항상 활발하고, 활기차고, 생기 있는 모습이 눈에 띄는 팀원입니다. 지치고 힘들 때 밝은 에너지를 주고, 팀원들이 놓치고 있는 부분들을 예리하게 짚어 주어 프로젝트의 완성도를 높여 주었습니다. 맡은 일이 아님에도 불구하고 먼저 나서서 개발을 진행하여, 막히는 부분 없이 원활한 프로젝트가 될 수 있었습니다. |
| 고윤석 | 문서화 작업, 데이터 전처리, PPT 등의 작업부터 개발까지 맡은 역할이 많아 부담될 수 있는 상황에서도 자신의 책임을 다하기 위해서 노력하였으며, 팀원들이 하기에 어려움을 느끼는 부분들을 책임져 잘 마무리하였습니다. 팀의 막내로서 분위기 메이커 역할도 잘 하는 만능 개발자(지망생)라고 생각합니다. |
| 권민수 | 디자인을 잘하는 막내라고 생각했지만, 디자인을 포함한 수많은 능력을 가진 에이스 막내였습니다.<br>자발적으로 팀 노션을 제작하고 체계적이고 가독성 높은 문서를 제공해주었으며, 회의록 작성의 모범을 보여 회의 문화에 긍정적인 영향을 주었습니다.<br>단순한 구현을 넘어서 완성도 있는 결과를 위해 수업 이상의 내용을 학습하고 적용하였고, 책임감 있게 임하는 모습이 인상적이었습니다. 다음 프로젝트도 함께하고 싶은 최고의 팀원입니다. |
| 박지원 | 강사님께 피드백을 받거나 팀 회의를 할 때 항상 기록해주시고 또 정리해서 노션에 올려주신 덕분에 이해 못하거나 놓친 부분도 다시 볼 수 있어서 정말 도움이 많이 되었습니다.<br>신경쓰지 못하고 있던 노션 정리나 문서화도 귀찮을 법한데 보기 편하고 꼼꼼하게 만들어 주셔서 감사했습니다. 프로젝트 발표에 쓸 PPT를 맡으신 와중에도 하나라도 더 구현하려는 모습이 정말 멋있었고 피피티 자료도 정말 잘 만들어주셔서 프로젝트가 더 돋보일 수 있었습니다. |
| 이성준 | 우리 팀의 막내이자 프론트엔드 팀장!<br>항상 차분하고 묵묵한 태도로 맡은 역할을 해내는 모습이 인상 깊었고, 문제가 생겼을 때 스스로 해결하려는 끈기 있는 태도가 돋보였습니다.<br>프론트엔드 팀장으로서 UI/UX에 대한 고민과 피드백을 통해 항상 책임감 있는 태도를 보여주었으며, 앞으로의 성장이 기대되는 팀원이었습니다. |
---

### 👤 고윤석

| Member | Review |
| ------ | ------ |
| 강수지 | 마르지 않는 열정과 넘치는 아이디어 샘을 가지고 있는 조원이라고 생각합니다. 막히는 부분이 있을 때도 복습을 통해 스스로의 힘으로 해결하려는 의지와 맡은 부분에 대해서 완벽한 해결을 강구하는 책임감 있는 모습이 돋보였습니다. 모두의 의견이 아우르도록 하는 데에 최선을 다해 주었으며, 회의 때마다 팀원 모두의 일관성 있는 이해를 위해 주도적으로 챙겨 주었습니다. |
| 고도연 | 회의를 진행할 때마다 여러 의견들을 제시하고 열심히 활동에 임하여 많은 열정을 느꼈음. 자신과 다른 의견을 가진 팀원들의 의견들도 경청하고 적극적으로 수용하여 프로젝트가 원활하게 진행될 수 있도록 배려함. 프로젝트 막바지에 팀원들의 고생을 덜어주기 위해 직접 나서서 문제를 해결하고자 하였음. |
| 권민수 | 좋은 프로젝트를 함께 만들고자 하는 욕심과, 완성도 높은 기능에 대한 열정이 고스란히 느껴졌던 팀원입니다. 많은 의견을 열정적으로 제안해 주신 만큼 의견 충돌도 있었습니다. 돌이켜보면, 의견 충돌이 있을 때 제가 충분히 성숙하게 대응하지 못한 점들이 보여 아쉬움과 죄송함이 남습니다.<br>이러한 상황에서 먼저 손을 건네시고 서로를 이해하고 성장할 기회로 삼으려 해주셔서 감사한 마음이 큽니다. 열정은 회의에 국한되지 않고 실제 개발에서도 높은 완성도로 드러났습니다. |
| 박지원 | 모르는 부분이 있거나 헤매고 있으면 옆에서 바로 바로 도와주시고 많은 도움을 받아서 정말 감사했습니다. 깃 문제 생겼을 때는 열심히 도와주시고 또 마지막 날 문제 생겼을 때는 팀원들과 소통하며 적극적으로 해결하려고 노력해주시고 밤새워서 해결하는 데 애써주셔서 프로젝트를 마무리하는 데 큰 도움이 되었습니다.<br>식사 게시글과 시큐리티를 맡아주셨는데 시큐리티를 붙이는 과정에서 오류가 계속 나는 상황에서도 포기하지 않고 끝까지 해주신 덕분에 수월하게 프로젝트를 진행할 수 있었습니다. |
| 이성준 | 우리 팀의 큰형님이자 데이터베이스 팀장!<br>항상 든든한 존재감으로 팀을 이끌어주었고, 특히 누구나 어렵다고 느낄 만한 문제에 스스로 먼저 도전하려는 태도가 정말 인상 깊었습니다.<br>다양한 방식으로 시도하고, 끝까지 해답을 찾아내려는 끈질긴 노력은 팀원들에게 큰 자극이 되었고, 실질적으로도 많은 문제를 해결해 주셨습니다.<br>DB 설계와 최적화 같은 눈에 띄지 않는 부분까지도 세심하게 챙겨 프로젝트의 기초를 단단히 다져주셨습니다. |

---

### 👤 권민수

| Member | Review |
| ------ | ------ |
| 강수지 | 신박한 아이디어와 그것을 곧 현실로 만들어 줄 수 있는 세세한 구상도가 머릿속에 그려져 있는 팀원입니다. 주말을 마다 않고 프로젝트에 임하는 모습이 귀감이 되었습니다. 팀원들의 의견에 섬세한 피드백을 해 주었으며, 구현 방법에 대한 가이드 라인을 제시해 주어 개발의 방향성을 잃지 않도록 해 주었습니다.<br>그리고 가장 중요하고 어려운 발표를 맡아, 다른 팀 부럽지 않은 스피치 실력을 뽐내 주어 프로젝트의 마지막을 빛내 주었습니다. |
| 고도연 | PM으로써 팀원들이 프로젝트를 위해 해야 할 일들을 미리 정해주어 기한 내에 프로젝트가 잘 진행될 수 있게 함. 리더십을 발휘하여 작업을 효과적으로 분배하여 일정에 맞게 마무리 할 수 있게 팀을 이끔. 발표 준비를 할 시간이 부족했음에도 불구하고 완벽하게 해내어 우리가 준비한 프로젝트의 내용을 잘 전달했음. |
| 고윤석 | 마지막까지 팀적인 여러 이슈로 발표를 준비하는 와중에 부담이 될 만한 상황이었음에도 불구하고 개발부터 발표까지 맡은 부분을 잘 수행해주었습니다. 색깔이 뚜렷한 팀원들 사이에서 의견 조율부터 협업을 하면서 PM으로서 프로젝트를 이끄는 과정이 힘들었을 만한데도 마지막까지 자신의 역할을 잘 책임졌습니다.<br>아이디어부터 개발까지 여러 방면에서 자신이 책임진 부분은 확실히 잘 해내는 믿을 수 있는 팀원입니다. |
| 박지원 | 저희 팀의 PM 맡으셔서 책임감을 갖고 적극적으로 팀을 이끌어 주셔서 정말 감사했습니다. 팝업스토어 운영 경험을 바탕으로 뛰어난 아이디어들을 내주시고 또 그 아이디어를 바탕으로 팀원들이 나아가야 할 방향을 정해주셔서 편했고 프로젝트를 수월하게 진행할 수 있었습니다.<br>맡아주신 유저 데이터 파트는 책임감 있게 모든 부분을 구현해주셔서 더 나은 결과물을 만들어 낼 수 있었습니다. 또 발표는 말해 뭐해 정말 완벽했습니다. |
| 이성준 | 우리의 PM이자 팀장!<br>팀 회의를 주도적으로 이끌어가는 모습이 매우 인상 깊었습니다. 회의 때마다 명확한 목적과 흐름을 가지고 이끌어 주셨고, 각 팀원의 의견을 경청하면서도 프로젝트의 큰 방향성을 놓치지 않고 균형 있게 조율하는 모습이 기억에 남습니다.<br>리더로서의 책임감뿐만 아니라, 팀원 한 사람 한 사람을 존중하는 태도에서 팀 전체의 분위기와 몰입도에도 긍정적인 영향을 주었다고 생각합니다. |

---

### 👤 박지원

| Member | Review |
| ------ | ------ |
| 강수지 | 교통 정리 역할을 톡톡히 해 준 팀원이라고 생각합니다. 회의가 방향성을 잃을 때마다 환기를 시켜 바로잡아 주고, 늦은 시각까지 프로젝트 완성도를 높이기 위해 문제를 해결하려고 노력하는 모습이 인상 깊었습니다.<br>질문을 두려워하지 않고, 문제에 대한 해답을 찾고자 하는 열정을 통해 한층 더 발전할 수 있었던 것 같습니다. |
| 고도연 | 의견을 적극적으로 제시하여 효과적인 아이디어를 제시하였음. 맡은 일을 열심히 해오고 궁금한 점들에 대해 적극적으로 질문하여 모르는 것을 알아가려고 노력함. 또한 자신이 아는 내용에 대해서는 아낌 없이 알려주려 하며 팀원들이 어려움을 느낄 때 같이 해내고자 하는 마음으로 프로젝트에 임하였음. |
| 고윤석 | 개발 단계부터 비슷한 파트를 맡아서 서로 도움을 주고 받았던 팀원으로서 팀 분위기를 부드럽게 이어갈 수 있게 윤활제 역할을 잘 했던 것 같습니다.<br>서비스의 핵심 기능인 식단 파트를 맡아 잘 개발하여 프로젝트가 잘 마무리되는데 기여하였습니다. |
| 권민수 | 프로젝트 기간 동안 팀의 소금 같은 존재가 되어준 팀원입니다. 묵묵하게 자기 역할을 수행하면서도, 꼭 필요한 순간에는 빠짐없이 제 역할을 해내는 모습이 인상 깊었습니다.<br>특히 바쁜 상황에서도 갑작스럽게 추가 기능 구현을 요청했을 때 소화해내는 모습이 인상 깊었습니다. 덕분에 많은 부분에서 걱정을 덜어낼 수 있었습니다. |
| 이성준 | 우리의 깃허브 팀장!<br>깃허브 충돌이나 머지 이슈가 생기는 상황에서도 당황하지 않고 끝까지 원인을 파악하고 해결책을 찾으려 애쓰는 모습이 인상 깊었습니다.<br>문제 해결뿐 아니라 팀원들과 함께 브랜치 전략이나 커밋 룰을 정비하며 협업을 이끌어가는 모습에서 진짜 '깃허브 팀장'다운 책임감이 느껴졌습니다. 구현 실력도 눈에 띄게 향상되었습니다. |

---

### 👤 이성준

| Member | Review |
| ------ | ------ |
| 강수지 | 없어서는 안 되는, 팀의 핵심 인재라고 생각합니다. 팀원들에게 문제가 생기면 아낌 없이 도와주고, 기능들을 구현하는 데에 높은 기여를 하였으며, 미비한 부분까지 세심하게 캐치하여 보완해 주었습니다. 가끔 엉뚱한 발상으로 웃음을 주며 팀의 감초 역할을 했다고 생각합니다. |
| 고도연 | 제일 어려운 security 부분을 맡아 책임감 있게 해냄. 아이디어부터 기능 구현까지 가장 많은 과제들을 수행했음. 또한 맡은 부분 외에도 필요한 기능들을 빠르게 구현하였음.<br>팀원들이 어려움을 겪을 때 흔쾌히 나서서 많은 도움을 주고 이해하기 쉽게 설명해주어 많은 도움을 줌. 개발이 밀리지 않도록 묵묵히 진행해주어 프로젝트를 잘 끝마칠 수 있었다고 생각함. |
| 고윤석 | 가장 까다로웠던 spring security를 이용한 회원가입 - 로그인 파트를 맡아서 책임감 있게 잘 개발하였으며, 팀원들이 개발하는 과정에서 어려움을 겪을 때 가장 많이 도와줬던 팀원입니다.<br>프로젝트 전반에 걸쳐 많은 역할을 하였고, 꼼꼼한 개발 덕분에 팀원들이 자신의 역할에 집중할 수 있었습니다. |
| 권민수 | 가장 어려운 기능을 맡았음에도 빠르고 완벽하게 구현해낸 뛰어난 개발 역량을 가진 팀원입니다. 단순한 해결을 넘어 높은 완성도와 효율성까지 고려하여 마무리하는 모습이 인상적이었습니다.<br>복잡한 문제 상황에서도 묵묵히 해결하며, 팀원들의 업무도 도와주는 이타적인 태도가 돋보였습니다. 설명 능력도 뛰어나 프로젝트 전반의 이해도를 높여주었습니다. |
| 박지원 | 저희 팀의 캐리 머신!<br>오류가 나면 세세하게 잘 알려주시고, 직접 해결도 도와주시는 든든한 존재였습니다. 회원가입, 로그인 같은 어려운 기능을 완벽하게 구현해주셨고, 이후에도 팀원들을 도와 프로젝트 진행에 큰 기여를 하셨습니다. |



