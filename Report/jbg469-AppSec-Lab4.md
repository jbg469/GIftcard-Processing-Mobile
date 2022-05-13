# Part 1

We follow the instructions to succesfully launch our emulator in the host OS. No VM's were used best effort is made to include time. 

<img width="1503" alt="Screen Shot 2022-05-10 at 1 46 58 AM" src="https://user-images.githubusercontent.com/72175659/167745674-232b7008-44a4-4156-8940-c06585042190.png">
## 1A
1. What are the two types of Intents?

 Intents start an activity, like opening an text message or opening a link. The two types of intents are implicit and explicit intent. Implicit intents allow for interaction between two activities from different applications. When you want to perform a certain action you can't be sure of wether the implicit intent will perform as expected. Explicit intents aid interaction of two activities from the same application or facilitate switchtching from one running one activity to another. Explicit intents are more secure because you know what is going on at all times.

2. Which of the two types of Intents are more secure?

Implicit intents have been shown to have security vulnerabilities like spoofing . Explicit intents leave no doubt about the recipients or the end results of the acitivity. Hence Explicit intents are more secure. Implicit intents are like calling for volunteers.   

3. What type of Intent is shown on lines 69 to 73 of SecondFragment.kt?

<img width="1520" alt="Screen Shot 2022-05-10 at 11 09 15 PM" src="https://user-images.githubusercontent.com/72175659/167761242-24f79cfb-6ccf-4802-af4b-f1434dcf4847.png">

It's an implicit intent because the link at line 71 is misleading clicking it you would think its a security page for nyu appsec but the API just shows details of different items for sale in giftcardsite.


4. What type of Intent is shown on lines 68 to 70 of ThirdFragment.kt?

Lines 68 to 70 is an explicit intent an action within the same application is being triggered. The application displays switching an activity after a user has been logged in. We can see that the class thats being called limiting the recipient of the intent. 

<img width="1484" alt="Screen Shot 2022-05-10 at 11 04 04 PM" src="https://user-images.githubusercontent.com/72175659/167760674-4dcae7e8-abd3-44c9-bff2-3766e097c993.png">


5. Between #4 and #5, which incorporates the more secure technique for implementing an Intent?
The proper way to do an intent is an explicit intent because there will be fewer attacks vectors since you are executing within the application. The code fragment in SecondFragment.kt opens an external API. 

## 1B 

There is no reason to call the API after a register login so we can simply comment out the lines shown below 69-71.The expected behavior of the app is 
to execute ProductScrollingActivity after successfully logging in. With Implicit intent, other components that satisfies the intent
could display data in unexpected ways. After the change we now have an explicit intent


<img width="1471" alt="Screen Shot 2022-05-11 at 2 13 30 AM" src="https://user-images.githubusercontent.com/72175659/167780994-4dcbe6fb-94b4-43c6-878b-a7b9042d8386.png">


## 1C


We comment out all 'intent-filter' fields in the xml as such with <!-- -->. The app works as intended 
 
  ```
 <!--<intent-filter>
            <action android:name="android.intent.action.VIEW" />

            <category android:name="android.intent.category.DEFAULT" />

            <data android:mimeType="text/giftcards_use" />
                <data android:scheme="giftcard" />
                <data android:host="nyuappsec.com"/>
            </intent-filter>-->
  ```
 <img width="1474" alt="Screen Shot 2022-05-11 at 2 44 10 AM" src="https://user-images.githubusercontent.com/72175659/167785530-0d66d610-1f3d-4e9d-90a4-a9b3a72fa526.png">

 
# 2 Stoppin' the Eavesdroppin'
 
We do a REPLACE ALL on http://nyuappsec and replace it with https://nyuappsec in the following files
 
```
SecondFragment.kt
ThirdFragment.kt
CardScrollingActivity.kt
ProductScrollingActivity.kt
UseCard.kt
GetCard.kt
CardRecyclerViewAdapter.kt
RecyclerViewAdapter.kt
```
This secures all communication with the REST API using HTTPS. 
 
 
<img width="1080" alt="Screen Shot 2022-05-11 at 1 31 43 AM" src="https://user-images.githubusercontent.com/72175659/167785648-8aef1463-fa80-47b3-b76b-76fbcf2b3372.png">
 
 
 
 <img width="470" alt="Screen Shot 2022-05-11 at 5 42 10 PM" src="https://user-images.githubusercontent.com/72175659/167952814-5ea1f1b8-dbf8-4cbb-a202-3bda593f4e52.png">
 
<img width="1629" alt="Screen Shot 2022-05-11 at 6 00 00 PM" src="https://user-images.githubusercontent.com/72175659/167954747-33dfb23c-5229-4112-a65d-392dbf6e7a99.png">
 
 As we can see connection is secured with https.
 
 <img width="1629" alt="Screen Shot 2022-05-11 at 6 00 00 PM" src="https://user-images.githubusercontent.com/72175659/167973739-8f86801b-dc58-41bd-ad94-7fe2478b075a.png">


# 3 Oops! Was that card yours?

The bug is  in the HTTP PUT method used in the CardInterface.kt file which allows the user to log in with a token and have access to someone else's card. HTTP PUT will always give a successful response even when the card was already used.
 
 <img width="1337" alt="Screen Shot 2022-05-11 at 7 25 38 PM" src="https://user-images.githubusercontent.com/72175659/167963397-ab3b4f75-eef2-4cf2-b9d5-d645277c05af.png">
 
 If we capture the traffic we can see that cards are created with a cronologically predictable id. There is no mitigation preventing someone from intercepting a request changing a value and using a giftcard that's not yours. The only other idetifier is the session token.
 
<img width="1690" alt="Screen Shot 2022-05-11 at 6 38 42 PM" src="https://user-images.githubusercontent.com/72175659/167960449-0ae612e2-f3ac-4d86-8c5f-44aad84d9c2b.png">
 
 We are able to intercept traffic and use giftcard one with an ok 200 repsonse.
 <img width="1393" alt="Screen Shot 2022-05-11 at 6 53 44 PM" src="https://user-images.githubusercontent.com/72175659/167960792-6f24cc08-4e53-4490-bdd1-a897a7d84c87.png">

 We are able to do the same with card number 800
 
<img width="1533" alt="Screen Shot 2022-05-11 at 6 53 21 PM" src="https://user-images.githubusercontent.com/72175659/167960931-766df097-9613-44a4-880c-0b393190e004.png">
 
 With this view you can see the 200 OK status. 
 
 <img width="1233" alt="Screen Shot 2022-05-11 at 7 02 04 PM" src="https://user-images.githubusercontent.com/72175659/167961218-4068e89a-c630-4ff0-b606-8a1e57c84339.png">

An HTTP POST method could be used to create a update request to the server so the server will reply with an error if the same method is called more than once, this prevents repeated use from the same request. Furthermore there are further checks that could be performed to link the gift card to a user and make it so that only users with the cards credentials can use it. You could link the login credentials to the card so that the user has to input their user name and password to use the card. This way we have to know more than just what giftcard number it is. 
 
# 4 Please Hold... Your Privacy Is Very Important To Us!
## 4a 
 For this task we look inside the manifest file and comment out permissions one by one seeing they dont crash the app on build.
 <img width="1512" alt="Screen Shot 2022-05-11 at 9 13 51 PM" src="https://user-images.githubusercontent.com/72175659/167980135-c969d94e-af41-4dae-9827-f9b3fcf67fdd.png">

<img width="1513" alt="Screen Shot 2022-05-11 at 9 15 18 PM" src="https://user-images.githubusercontent.com/72175659/167980145-5129a2df-a90b-472f-a49b-18f80ce284a7.png">
<img width="1520" alt="Screen Shot 2022-05-11 at 9 17 50 PM" src="https://user-images.githubusercontent.com/72175659/167980147-41a79797-8e4c-48e9-ae90-ba971a9ce850.png">

 ACCESS_FINE_LOCATION Causes promblems on removal but it's not necessary so we CTRL+SHIFT+F "permissions" and "FINE_LOCATION" to remove any reference to permissions in the app code.
 
<img width="1528" alt="Screen Shot 2022-05-11 at 10 27 29 PM" src="https://user-images.githubusercontent.com/72175659/167980659-06f58e2b-5c6e-47e6-bd80-2100537c6a0c.png">
 
 
<img width="1535" alt="Screen Shot 2022-05-11 at 10 27 47 PM" src="https://user-images.githubusercontent.com/72175659/167980674-4c8c637c-ea2f-4670-8c7c-0c06ac66f034.png">

 ## 4b 
 
 Capturing web traffic we can see that the app collects data and sends to a server. This is unnecessary and not a good practice. 
 
 <img width="1481" alt="Screen Shot 2022-05-12 at 12 14 35 AM" src="https://user-images.githubusercontent.com/72175659/167990982-0500d89c-a559-4c6e-92ff-e592dd30055d.png">
It seems like "metric" is related to location data. We will try to remove all references to both from the app. We already removed the permissions that were triggering the location data prompt at login. Now we will remove all traces of location use. 
<img width="1405" alt="image" src="https://user-images.githubusercontent.com/72175659/168208327-917adf2b-bc66-4491-a88e-f8fbd58158fb.png">

In CardScrollingActivity import com.example.giftcardsite.api.service.UserInfo- this library sounds suspect so we remove it.
 we remove all references and function related to the places that output something with metric in the string. We see that these functions once removed were causing problems and unresolved references. The keywords sensor and location are blended amongst the stuff we seemmingly don't want / need. Once we comment out everything the app logs us in and we can use cards. We comment out some imports to some suspicious looking packages dealing with sensory data and references to the API. 


<img width="1712" alt="Screen Shot 2022-05-13 at 12 28 56 AM" src="https://user-images.githubusercontent.com/72175659/168211403-d05a2cfb-c297-4107-aeaf-4de69449cd9e.png">

In ProductScrollingActivity.kt is very similar to CardScrollingActivity we remove the same imports. We  remove references and functions associated to "metric", sensor, and location. Lines 99-169 are commented out as all this code seems to just handle metric data and sensory information we remove the same imports we did in CardScrolling. 


<img width="1673" alt="Screen Shot 2022-05-13 at 12 54 57 AM" src="https://user-images.githubusercontent.com/72175659/168213784-7a494569-bc29-404e-903b-537222b2eee0.png">

Upon changing the file and rebuilding the app, we can login successfully and use the app. 


 <img width="1194" alt="Screen Shot 2022-05-13 at 1 31 29 AM" src="https://user-images.githubusercontent.com/72175659/168217424-6a39e523-65a7-43ba-9b07-3cd69d0f0191.png">
 
 We see that there are still references to location and metric left in the source code, but the files we edited deal with what is collected and exported by the device so it's enough to stop the device from collecting data and sending it. We verify by the fact that we no longer see this mess when capturing traffic.  
<img width="1481" alt="Screen Shot 2022-05-12 at 12 14 35 AM" src="https://user-images.githubusercontent.com/72175659/168217636-3b0d2346-7ccd-4087-a894-79e9e68ba2ce.png">

We now don't see any extra api calls we now
It was important to comment out the //@POST("/api/metrics") in UserInfo.kt as that stops the metric api from sending a request from the device. If you do not remove this there is a lag and you won't be able to use the card.
<img width="1602" alt="Screen Shot 2022-05-13 at 2 03 18 AM" src="https://user-images.githubusercontent.com/72175659/168221069-bf02b37d-4446-46e1-bf31-d0636bdf4590.png">

<img width="1214" alt="Screen Shot 2022-05-13 at 1 34 50 AM" src="https://user-images.githubusercontent.com/72175659/168217778-ebb23d3d-b466-4ded-9f07-4a472118a14b.png">

## 4c

In the same 
ProductScrollingActivity.kt and CardScrollingActivity we comment out the last remaining references to anything "sensor" related that we didn't get for part 4c. Getting rid of all sensor functions in these two files is enough to remove all unnecessary sensor interactions from the mobile application, leaving only those necessary for the application to function and serve its purpose.


<img width="1618" alt="Screen Shot 2022-05-13 at 1 55 52 AM" src="https://user-images.githubusercontent.com/72175659/168221558-4c0134a3-8f6d-430f-81ab-800adc286187.png">

<img width="1299" alt="Screen Shot 2022-05-13 at 1 56 40 AM" src="https://user-images.githubusercontent.com/72175659/168221592-ce023fd4-9c44-4e35-87ca-472e87b177f4.png">

