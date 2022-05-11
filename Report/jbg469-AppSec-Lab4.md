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


We comment out all <intent-filter> fields in the xml as such with <!-- -->. The app works as intended 
 
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



