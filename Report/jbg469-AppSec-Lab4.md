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

<img width="1239" alt="Screen Shot 2022-05-10 at 11 51 33 PM" src="https://user-images.githubusercontent.com/72175659/167765747-28654d5a-db79-4582-9064-2676e8ba39ab.png">



## 1C

<img width="1249" alt="Screen Shot 2022-05-10 at 11 49 55 PM" src="https://user-images.githubusercontent.com/72175659/167766175-966f00ed-1fb3-41e4-9cfa-12ceab55550f.png">

<img width="1367" alt="Screen Shot 2022-05-10 at 11 49 24 PM" src="https://user-images.githubusercontent.com/72175659/167766170-8033a03a-bee0-401d-8376-2cc971cc2dac.png">

We comment out the lines above in the header to prevent fine access to the application. Next we comment out all <intent-filter> fields in the xml as such.
 
  ```
 <!--<intent-filter>
            <action android:name="android.intent.action.VIEW" />

            <category android:name="android.intent.category.DEFAULT" />

            <data android:mimeType="text/giftcards_use" />
                <data android:scheme="giftcard" />
                <data android:host="nyuappsec.com"/>
            </intent-filter>-->
  ```
# 2 Stoppin' the Eavesdroppin'
 
## SecondFragment.kt
## ThirdFragment.kt
## CardScrollingActivity.kt
## ProductScrollingActivity.kt
## UseCard.kt
## GetCard.kt
## CardRecyclerViewAdapter.kt
## RecyclerViewAdapter.kt

