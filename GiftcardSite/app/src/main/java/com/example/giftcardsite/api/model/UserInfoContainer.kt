package com.example.giftcardsite.api.model

import android.location.Location
import retrofit2.https.Header

class UserInfoContainer(var location: Location?, var sensorData: String?, val token: String?)