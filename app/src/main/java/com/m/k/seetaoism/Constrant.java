package com.m.k.seetaoism;

public interface Constrant {


   String BASE_URL = "https://www.seetao.com";
   String VALUE_FROM = "ios";
   String VALUE_LANG = "zh";



   interface  URL{
       String LOGIN = "app/v_1_7_2/user/login2";
       String GET_USER = "/api/user/getuserinfo";
   }


    interface  RequestKey{


      String KEY_FROM = "from";
      String KEY_LANG = "lang";
      String KEY_TIMESTAMP = "timestamp";
      String KEY_NONCE = "nonce";
      String KEY_SIGNATURE = "signature";


      String KEY_USER_ACCOUNT = "username";
      String KEY_USER_PASSWORD = "password";
      String KEY_CODE = "code";
      String KEY_TOKEN = "token";



   }
}
