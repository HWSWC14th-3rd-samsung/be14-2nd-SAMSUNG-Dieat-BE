# be14-2nd-SAMSUNG-Dieat-BE
# 🥗 식단 다이어트 매니저(DIEAT)

**"지속 가능한 식단, 체계적인 관리"**  
식단 기록부터 추천, 배열까지 한 번에!  
건강한 다이어트를 위한 맞춤형 식단 관리 서비스입니다.

---

## 📌 프로젝트 개요

- **프로젝트명**: Dieat
- **목표**: 사용자의 체중 감량을 도움까지 위해 식단을 기록하고, 맞추형 식단을 추천 및 배열하는 웹 서비스 개발
- **기간**: 2025.XX.XX ~ 2025.03.26
- **기술스택**: html, Spring boot, Spring Security, MariaDB, Docker, Redis, IntelliJ

---

## 🧱 도메인 주도 설계 (DDD)

| 도메인 | 설명 |
|--------|------|
| 사용자 (User) | 회원가입, 로그인, 개인 신체 정보 입력 |
| 식단 (Diet) | 음식 정보 기록, 하루 식단 요조 |
| 식품 DB (Food) | 음식명, 영양소 정보 저장 |
| 배열 (Analysis) | 하루 섬치량 배열, 권장 섬치 기준과 비교 |
| 추천 (Recommendation) | 사용자 맞추 식단 추천 알고리즘 적용 |

> 📌 각 도메인은 독립적인 Bounded Context로 나누며, Aggregate Root를 기준으로 엔터트리 관계를 구성했습니다.

---

## 🧠 논리 모델링 (ERD)

`료 평가 (Peer Review)

| 팀원 | 기억도 | 강점 | 감정점 |
|------|--------|------|--------|
| A | 30% | 도메인 설계 및 구조화 능력 | 일정 관리 필요 |
| B | 25% | 백엔드 API 구현 속도 | 코드 리파트론 여지 |
| C | 25% | UI/UX 디자인 감각 | 디버극 능력 향상 필요 |
| D | 20% | 배열 알고리즘 구현 | 카미니켜션 적귀성 감정 |

---

## 📒 기타

- Figma 디자인 링크: [바로가기](#)
- Notion 문서 링크: [바로가기](#)
- 시연 영상: [바로가기](#)

