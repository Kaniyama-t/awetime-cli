package data.api

import retrofit2.Call
import retrofit2.http.*

interface ISlackIncomingAPI {

    @FormUrlEncoded
    @POST("services/{id}")
    fun sendMessage(
        @Path("id", encoded = true) groupId : String,
        @Field("payload") payload: String
    ): Call<String>
}