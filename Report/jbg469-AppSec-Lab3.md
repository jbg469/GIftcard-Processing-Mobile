# Part 1
1. What are the two types of Intents?

An activity is an application that contains a specific code; a user interface. There needs to be a component to communicate between the activities, and this is where intent comes in to be a messaging component. The two types of intents are explicit intent and implicit intent. Explicit intent allows you to communicate between two activities of the same application or if you want to jump from one activity to another. Implicit intent allows communication between two activities of different applications. Intents are used to start an activity/service, such as opening an email and calling. You can pass data in the same application or different applications. Intent is used for broadcasting messages like communicating to other applications that the battery is low.


2. Which of the two types of Intents are more secure?

Explicit intent is more secure because implicit intent leads to spoofing and interception on Android. they are frequently overused or used inappropriately, with negative consequences for security. Explicit intents are a much better choice for this situation, because they are simpler and they leave no doubt about the recipient of an intent.




3. What type of Intent is shown on lines 69 to 73 of SecondFragment.kt?

The type of intent is implicit because there are different activities in line 71 for the attached link. The API shows other things going on with items and prices.

4. What type of Intent is shown on lines 68 to 70 of ThirdFragment.kt?

Lines 68 to 70 show an explicit intent due to it being in the same application. The application displays an extra user being added and starting the activity without switching to another activity.

5. Which of these two Intents is the proper way to do an Intent?

Secondfragment.kt needs to be modified by only being in the same application. The proper way to do an intent is explicit because there will be fewer attacks like spoofing and interception since you are solely on the same application. Similar to what we do on postman, we went on different URL's by using a token. However, that token was not suitable since it was a permanent token. All tokens should be changed so that there won't be a security issue.
