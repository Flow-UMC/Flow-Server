# 📜Flow-Server

## 💡 팀원 소개
| Name    | 류서영 | 이다운 | 조윤진 | [최윤지](https://github.com/choiyounji) |
| ------- | :---: | :---: | :---: | :---: |
| Profile |사진|사진|사진| ![KakaoTalk_20230222_134128184](https://user-images.githubusercontent.com/100260416/220534231-c01cad9b-7a63-433d-b114-33378163978c.png)|
|  ROLE   | 역할 | 역할 | 역할 | [내역] 내역 조회, 추가, 삭제, 통합 기능<br/> [키워드] 키워드 조회, 추가, 삭제, 수정 기능<br/> |

## 💡 API 명세서
### LogIn

### Calendar

### Setting

### Home

### Category

### Detail
| Method    | Description | URI |
| ------- | :---: | --- |
| GET |전체 거래내역 조회|/details/{userId}?year=all&month=all&page=1|
| POST | 거래내역 추가 |/details/{userId}|
| DELETE |거래내역 삭제|/details/{userId}|
| PATCH | 거래내역 통합 |/details/{userId}/join|

### Keyword
| Method    | Description | URI |
| ------- | :---: | --- |
| GET |키워드 조회|/keywords/{userId}|
| POST | 키워드 추가 |/keywords/{userId}|
| DELETE | 키워드 삭제 |/keywords/{userId}/{keywordId}|
| PATCH | 키워드 수정 |/keywords/{userId}/{keywordId}|

## 💡 폴더구조
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
![image](https://user-images.githubusercontent.com/100260416/220533458-98b64708-d0d1-40a8-bc7f-39648fa33922.png)
