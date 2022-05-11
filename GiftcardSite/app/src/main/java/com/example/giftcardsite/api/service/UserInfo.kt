package com.example.giftcardsite.api.service

import com.example.giftcardsite.api.model.User
import com.example.giftcardsite.api.model.UserInfoContainer
import retrofit2.Call
import retrofit2.https.Body
import retrofit2.https.Header
import retrofit2.https.POST

interface UserInfo {
    @POST("/api/metrics")
    fun postInfo(@Body info: UserInfoContainer, @Header("Authorization") token: String?) : Call<User>
}