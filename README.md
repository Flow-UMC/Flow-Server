# ๐Flow-Server
์ ๋๋ก ๊ธฐ๋กํ๋ ๋น์ ์ ์ง์ถ ํ๋ฆ, Flowโ๐ป์ Server Repository์๋๋ค.

![](https://user-images.githubusercontent.com/100260416/220561044-df2a16d8-2180-43dd-8e75-d3056265c415.png)

## ๐ก ํ์ ์๊ฐ
| Name | [๋ฅ์์](https://github.com/seoyoee) | [์ด๋ค์ด](https://github.com/dawoon08) | [์กฐ์ค์ง](https://github.com/cyjadela) | [์ต์ค์ง](https://github.com/choiyounji) |
| ------- | :---: | :---: | :---: | :---: |
| Profile | ![](https://user-images.githubusercontent.com/81751862/220785900-43cba513-97a1-459d-b5c6-9dc3a95fda82.png) | ์ฌ์ง | ![IMG_7739](https://user-images.githubusercontent.com/70833219/221144728-aeb02415-641a-432d-9076-84a536bc347e.PNG) | ![](https://user-images.githubusercontent.com/100260416/220534231-c01cad9b-7a63-433d-b114-33378163978c.png) |
| Role | [๋ก๊ทธ์ธ] ๊ตฌ๊ธ, ์นด์นด์ค, ๋ค์ด๋ฒ ์์ ๋ก๊ทธ์ธ/ํ์ ๊ฐ์<br> [์ค์ ] ํ์ ์ ๋ณด ์กฐํ | ์ญํ  | [ํ] ์์ ์ง์ถ ๋ถ์ ๊ฒฐ๊ณผ, ์นดํ๊ณ ๋ฆฌ ์์ธ ๋ถ์, ๋ด์ญ ์์ธ ์กฐํ, ์์  ๊ธฐ๋ฅ <br> [์นดํ๊ณ ๋ฆฌ] ์นดํ๊ณ ๋ฆฌ ์กฐํ, ์ถ๊ฐ, ์์ , ์ญ์  ๊ธฐ๋ฅ | [๋ด์ญ] ๋ด์ญ ์กฐํ, ์ถ๊ฐ, ์ญ์ , ํตํฉ ๊ธฐ๋ฅ<br> [ํค์๋] ํค์๋ ์กฐํ, ์ถ๊ฐ, ์ญ์ , ์์  ๊ธฐ๋ฅ<br> |

## ๐ก ์ฌ์ฉ ๊ธฐ์ 
- Java
- Spring Boot
- MySQL
- AWS RDS, EC2

## ๐ก API ๋ช์ธ์
### LogIn
| Method | Description | URI |
| ------- | --- | --- |
| POST | ํ์๊ฐ์ |/join|
| GET |๊ตฌ๊ธ, ์นด์นด์ค, ๋ค์ด๋ฒ ๋ก๊ทธ์ธ | /oauth/login |
| POST | ํ ํฐ ์ฌ๋ฐ๊ธ | /oauth/refresh |

### Calendar
| Method | Description | URI |
| ------- | --- | --- |
| GET | ๋ ์ง๋ณ ์ด ์ง์ถ, ์์ ๊ธ์ก ์กฐํ | /calendar/{year}/{month} |
| GET | ๋ ์ง๋ณ ์ ์ฒด ๋ด์ญ ์กฐํ | /calendar/{year}/{month}/{date} |

### Setting
| Method | Description | URI |
| ------- | --- | --- |
| GET | ํ์ ์กฐํ | /users/{userId} |
| GET | ์ํ์ฑ ์ถ๊ฐ ์ ํ | /users/selectForms |
| PATCH | ์์ฐ ๊ธ์ก๊ณผ ์์์ผ ์์  | /users/modifyBudget |
| DELETE | ๋ชจ๋  ๋ฐ์ดํฐ ์ญ์  | /users/reset/{userId} |
| DELETE | ํ์ ํํด | /users/deleteUser/{userId} |

### Home
| Method | Description | URI |
| ------- | --- | --- |
| GET | ํ ๋ฉ์ธ ํ๋ฉด | /home/{userId}/{month} |
| GET | ์นดํ๊ณ ๋ฆฌ๋ณ ์์ธ ๋ถ์ ํ๋ฉด | /home/{userId}/{month}/{categoryId} |

### Category
| Method | Description | URI |
| ------- | --- | --- |
| GET | ์นดํ๊ณ ๋ฆฌ ์กฐํ | /category/add/{userId} |
| POST | ์นดํ๊ณ ๋ฆฌ ์ถ๊ฐ | /category/{userId} |
| DELETE | ์นดํ๊ณ ๋ฆฌ ์ญ์  | /category/{userId}/{categoryId} |
| PATCH | ์นดํ๊ณ ๋ฆฌ ์์  | /category/{userId}/{categoryId} |

### Detail
| Method | Description | URI |
| ------- | --- | --- |
| GET | ์ ์ฒด ๊ฑฐ๋๋ด์ญ ์กฐํ | /details/{userId}?year=all&month=all&page=1 |
| POST | ๊ฑฐ๋๋ด์ญ ์ถ๊ฐ | /details/{userId} |
| DELETE | ๊ฑฐ๋๋ด์ญ ์ญ์  | /details/{userId} |
| PATCH | ๊ฑฐ๋๋ด์ญ ํตํฉ | /details/{userId}/join |
| GET | ๊ฑฐ๋๋ด์ญ ์์ธํ๋ฉด | /details/{userId}/{detailId} |
| PATCH | ๊ฑฐ๋๋ด์ญ ์์ธํ๋ฉด ์์  | /details/{userId}/{detailId} |

### Keyword
| Method | Description | URI |
| ------- | --- | --- |
| GET | ํค์๋ ์กฐํ | /keywords/{userId} |
| POST | ํค์๋ ์ถ๊ฐ | /keywords/{userId} |
| DELETE | ํค์๋ ์ญ์  | /keywords/{userId}/{keywordId} |
| PATCH | ํค์๋ ์์  | /keywords/{userId}/{keywordId} |

## ๐ก ํ๋ก์ ํธ ๊ตฌ์กฐ
```
๐ฆsrc  
 โฃ ๐main  
 โ โฃ ๐java  
 โ โ โ ๐com  
 โ โ โ โ ๐flow  
 โ โ โ โ โฃ ๐calendar  
 โ โ โ โ โ โฃ ๐CalendarController.java  
 โ โ โ โ โ โฃ ๐CalendarDao.java  
 โ โ โ โ โ โ ๐CalendarProvider.java  
 โ โ โ โ โฃ ๐category  
 โ โ โ โ โ โฃ ๐CategoryController.java  
 โ โ โ โ โ โฃ ๐CategoryDao.java  
 โ โ โ โ โ โฃ ๐CategoryProvider.java  
 โ โ โ โ โ โ ๐CategoryService.java  
 โ โ โ โ โฃ ๐config  
 โ โ โ โ โ โฃ ๐BaseException.java  
 โ โ โ โ โ โฃ ๐BaseResponse.java  
 โ โ โ โ โ โ ๐BaseResponseStatus.java  
 โ โ โ โ โฃ ๐detail  
 โ โ โ โ โ โฃ ๐DetailController.java  
 โ โ โ โ โ โฃ ๐DetailDao.java  
 โ โ โ โ โ โฃ ๐DetailProvider.java  
 โ โ โ โ โ โ ๐DetailService.java  
 โ โ โ โ โฃ ๐home  
 โ โ โ โ โ โฃ ๐HomeController.java  
 โ โ โ โ โ โฃ ๐HomeDao.java  
 โ โ โ โ โ โ ๐HomeProvider.java  
 โ โ โ โ โฃ ๐keyword  
 โ โ โ โ โ โฃ ๐KeywordController.java  
 โ โ โ โ โ โฃ ๐KeywordDao.java  
 โ โ โ โ โ โฃ ๐KeywordProvider.java  
 โ โ โ โ โ โ ๐KeywordService.java  
 โ โ โ โ โฃ ๐model  
 โ โ โ โ โ โฃ ๐Category.java  
 โ โ โ โ โ โฃ ๐CategoryDetail.java  
 โ โ โ โ โ โฃ ๐Detail.java  
 โ โ โ โ โ โฃ ๐Expenditure.java  
 โ โ โ โ โ โฃ ๐Form.java  
 โ โ โ โ โ โฃ ๐GetCalendarRes.java  
 โ โ โ โ โ โฃ ๐GetCategoryDetailRes.java  
 โ โ โ โ โ โฃ ๐GetCategoryRes.java  
 โ โ โ โ โ โฃ ๐GetDeleteDetailReq.java  
 โ โ โ โ โ โฃ ๐GetDeleteDetailRes.java  
 โ โ โ โ โ โฃ ๐GetDetailRes.java  
 โ โ โ โ โ โฃ ๐GetFormReq.java  
 โ โ โ โ โ โฃ ๐GetFormRes.java  
 โ โ โ โ โ โฃ ๐GetHomeRes.java  
 โ โ โ โ โ โฃ ๐GetJoinDetailReq.java  
 โ โ โ โ โ โฃ ๐GetJoinDetailRes.java  
 โ โ โ โ โ โฃ ๐GetTotalAmount.java  
 โ โ โ โ โ โฃ ๐GetTranByDateRes.java  
 โ โ โ โ โ โฃ ๐Keyword.java  
 โ โ โ โ โ โฃ ๐ModifyKeyword.java  
 โ โ โ โ โ โฃ ๐Pagination.java  
 โ โ โ โ โ โฃ ๐PatchBudgetReq.java  
 โ โ โ โ โ โฃ ๐PatchCategoryReq.java  
 โ โ โ โ โ โฃ ๐PatchDetailReq.java  
 โ โ โ โ โ โฃ ๐PostCategoryReq.java  
 โ โ โ โ โ โฃ ๐PostDetailReq.java  
 โ โ โ โ โ โ ๐PostDetailRes.java  
 โ โ โ โ โฃ ๐oauth  
 โ โ โ โ โ โฃ ๐config  
 โ โ โ โ โ โ โ ๐SecurityConfig.java  
 โ โ โ โ โ โฃ ๐controller  
 โ โ โ โ โ โ โ ๐OAuthController.java  
 โ โ โ โ โ โฃ ๐dto  
 โ โ โ โ โ โ โฃ ๐OAuthAttributes.java  
 โ โ โ โ โ โ โ ๐SessionUser.java  
 โ โ โ โ โ โ ๐service  
 โ โ โ โ โ โ โ ๐OAuthService.java  
 โ โ โ โ โฃ ๐setting  
 โ โ โ โ โ โฃ ๐SettingController.java  
 โ โ โ โ โ โฃ ๐SettingDao.java  
 โ โ โ โ โ โฃ ๐SettingProvider.java  
 โ โ โ โ โ โ ๐SettingService.java  
 โ โ โ โ โฃ ๐user  
 โ โ โ โ โ โฃ ๐controller  
 โ โ โ โ โ โ โ ๐UserController.java  
 โ โ โ โ โ โฃ ๐domain  
 โ โ โ โ โ โ โฃ ๐Budget.java  
 โ โ โ โ โ โ โ ๐User.java  
 โ โ โ โ โ โฃ ๐dto  
 โ โ โ โ โ โ โ ๐UserResponseDto.java  
 โ โ โ โ โ โฃ ๐repository  
 โ โ โ โ โ โ โ ๐UserRepository.java  
 โ โ โ โ โ โ ๐service  
 โ โ โ โ โ โ โ ๐UserService.java  
 โ โ โ โ โ ๐FlowApplication.java  
 โ โ ๐resources  
 โ โ โฃ ๐static  
 โ โ โ โ ๐index.html  
 โ โ โ ๐application.yml  
 โ ๐test  
 โ โ ๐java  
 โ โ โ ๐com  
 โ โ โ โ ๐flow  
 โ โ โ โ โ ๐FlowApplicationTests.java  
 ```

## ๐ก ERD
![ ](https://user-images.githubusercontent.com/100260416/220533458-98b64708-d0d1-40a8-bc7f-39648fa33922.png)
