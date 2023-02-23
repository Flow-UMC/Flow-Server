# 📜Flow-Server
제대로 기록하는 당신의 지출 흐름, Flow✍🏻의 Server Repository입니다.

![](https://user-images.githubusercontent.com/100260416/220561044-df2a16d8-2180-43dd-8e75-d3056265c415.png)

## 💡 팀원 소개
| Name | [류서영](https://github.com/seoyoee) | [이다운](https://github.com/dawoon08) | [조윤진](https://github.com/cyjadela) | [최윤지](https://github.com/choiyounji) |
| ------- | :---: | :---: | :---: | :---: |
| Profile | ![](https://user-images.githubusercontent.com/81751862/220785900-43cba513-97a1-459d-b5c6-9dc3a95fda82.png) | 사진 | 사진 | ![](https://user-images.githubusercontent.com/100260416/220534231-c01cad9b-7a63-433d-b114-33378163978c.png) |
| Role | [로그인] 구글, 카카오, 네이버 소셜 로그인/회원 가입<br> [설정] 회원 정보 조회 | 역할 | 역할 | [내역] 내역 조회, 추가, 삭제, 통합 기능<br> [키워드] 키워드 조회, 추가, 삭제, 수정 기능<br> |

## 💡 API 명세서
### LogIn
| Method | Description | URI |
| ------- | --- | --- |
| POST | 회원가입 |/join|
| GET |구글, 카카오, 네이버 로그인 | /oauth/login |
| POST | 토큰 재발급 | /oauth/refresh |

### Calendar
| Method | Description | URI |
| ------- | --- | --- |
| GET | 날짜별 총 지출, 수입 금액 조회 | /calendar/{year}/{month} |
| GET | 날짜별 전체 내역 조회 | /calendar/{year}/{month}/{date} |

### Setting
| Method | Description | URI |
| ------- | --- | --- |
| GET | 회원 조회 | /users/{userId} |
| GET | 은행앱 추가 선택 | /users/selectForms |
| PATCH | 예산 금액과 시작일 수정 | /users/modifyBudget |
| DELETE | 모든 데이터 삭제 | /users/reset/{userId} |
| DELETE | 회원 탈퇴 | /users/deleteUser/{userId} |

### Home
| Method | Description | URI |
| ------- | --- | --- |
| GET | 홈 메인 화면 | /home/{userId}/{month} |
| GET | 카테고리별 상세 분석 화면 | /home/{userId}/{month}/{categoryId} |

### Category
| Method | Description | URI |
| ------- | --- | --- |
| GET | 카테고리 조회 | /category/add/{userId} |
| POST | 카테고리 추가 | /category/{userId} |
| DELETE | 카테고리 삭제 | /category/{userId}/{categoryId} |
| PATCH | 카테고리 수정 | /category/{userId}/{categoryId} |

### Detail
| Method | Description | URI |
| ------- | --- | --- |
| GET | 전체 거래내역 조회 | /details/{userId}?year=all&month=all&page=1 |
| POST | 거래내역 추가 | /details/{userId} |
| DELETE | 거래내역 삭제 | /details/{userId} |
| PATCH | 거래내역 통합 | /details/{userId}/join |
| GET | 거래내역 상세화면 | /details/{userId}/{detailId} |
| PATCH | 거래내역 상세화면 수정 | /details/{userId}/{detailId} |

### Keyword
| Method | Description | URI |
| ------- | --- | --- |
| GET | 키워드 조회 | /keywords/{userId} |
| POST | 키워드 추가 | /keywords/{userId} |
| DELETE | 키워드 삭제 | /keywords/{userId}/{keywordId} |
| PATCH | 키워드 수정 | /keywords/{userId}/{keywordId} |

## 💡 프로젝트 구조
```
📦src  
 ┣ 📂main  
 ┃ ┣ 📂java  
 ┃ ┃ ┗ 📂com  
 ┃ ┃ ┃ ┗ 📂flow  
 ┃ ┃ ┃ ┃ ┣ 📂calendar  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CalendarController.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CalendarDao.java  
 ┃ ┃ ┃ ┃ ┃ ┗ 📜CalendarProvider.java  
 ┃ ┃ ┃ ┃ ┣ 📂category  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CategoryController.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CategoryDao.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CategoryProvider.java  
 ┃ ┃ ┃ ┃ ┃ ┗ 📜CategoryService.java  
 ┃ ┃ ┃ ┃ ┣ 📂config  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseException.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseResponse.java  
 ┃ ┃ ┃ ┃ ┃ ┗ 📜BaseResponseStatus.java  
 ┃ ┃ ┃ ┃ ┣ 📂detail  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DetailController.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DetailDao.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DetailProvider.java  
 ┃ ┃ ┃ ┃ ┃ ┗ 📜DetailService.java  
 ┃ ┃ ┃ ┃ ┣ 📂home  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜HomeController.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜HomeDao.java  
 ┃ ┃ ┃ ┃ ┃ ┗ 📜HomeProvider.java  
 ┃ ┃ ┃ ┃ ┣ 📂keyword  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜KeywordController.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜KeywordDao.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜KeywordProvider.java  
 ┃ ┃ ┃ ┃ ┃ ┗ 📜KeywordService.java  
 ┃ ┃ ┃ ┃ ┣ 📂model  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Category.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CategoryDetail.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Detail.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Expenditure.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Form.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜GetCalendarRes.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜GetCategoryDetailRes.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜GetCategoryRes.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜GetDeleteDetailReq.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜GetDeleteDetailRes.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜GetDetailRes.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜GetFormReq.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜GetFormRes.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜GetHomeRes.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜GetJoinDetailReq.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜GetJoinDetailRes.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜GetTotalAmount.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜GetTranByDateRes.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Keyword.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ModifyKeyword.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Pagination.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PatchBudgetReq.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PatchCategoryReq.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PatchDetailReq.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PostCategoryReq.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PostDetailReq.java  
 ┃ ┃ ┃ ┃ ┃ ┗ 📜PostDetailRes.java  
 ┃ ┃ ┃ ┃ ┣ 📂oauth  
 ┃ ┃ ┃ ┃ ┃ ┣ 📂config  
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SecurityConfig.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller  
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OAuthController.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto  
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OAuthAttributes.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SessionUser.java  
 ┃ ┃ ┃ ┃ ┃ ┗ 📂service  
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OAuthService.java  
 ┃ ┃ ┃ ┃ ┣ 📂setting  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SettingController.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SettingDao.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SettingProvider.java  
 ┃ ┃ ┃ ┃ ┃ ┗ 📜SettingService.java  
 ┃ ┃ ┃ ┃ ┣ 📂user  
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller  
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserController.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📂domain  
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Budget.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜User.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto  
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserResponseDto.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📂repository  
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepository.java  
 ┃ ┃ ┃ ┃ ┃ ┗ 📂service  
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserService.java  
 ┃ ┃ ┃ ┃ ┗ 📜FlowApplication.java  
 ┃ ┗ 📂resources  
 ┃ ┃ ┣ 📂static  
 ┃ ┃ ┃ ┗ 📜index.html  
 ┃ ┃ ┗ 📜application.yml  
 ┗ 📂test  
 ┃ ┗ 📂java  
 ┃ ┃ ┗ 📂com  
 ┃ ┃ ┃ ┗ 📂flow  
 ┃ ┃ ┃ ┃ ┗ 📜FlowApplicationTests.java  
 ```

## 💡 ERD
![ ](https://user-images.githubusercontent.com/100260416/220533458-98b64708-d0d1-40a8-bc7f-39648fa33922.png)
