DiffBotJavaAPI
==============

DiffBot provides its API in only JSON format, so I created this integrity API in Java to integrate diffBot API in java very quickly and easy.
Please Note :
DiffBot Java API 0.1 BETA version.


Used Other Library integrated in code :
Json, 
commons-httpclient-2.0, 
commons-logging-1.1.1



DiffBotAPI jar :

Jar file to use as API in other projects

Q. How To use jar file in other projects?


A.
-- Add Jar file as lib in project.
-- No need to add any other extra lib in project for our API support.(Json code also added to our jar)
-- Java Code Example in Java File :

import com.DiffBot.Api.DiffBot;
import com.DiffBot.Json.JSONObject;


JSONObject jsonObject = new JSONObject();
jsonObject = DiffBot.APICall(url, token, api, fields, version);

For more details please visit : http://diffbot.com


