package data.api.Entry

import ConfigResource
import com.google.gson.Gson
import data.api.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SlackIncomingEntry (
    override val name: String,
    override val option: String,
    val targetChannel: String?,
    val specificUsername: String?,
    val iconEmoji: String?,
    val incomingURL: String
) : HostEntry () {

    override val system = ConfigResource.SYSTEM_SLACKINCOMING

    override fun sendMsg(msg: String, params: Map<String, String>?) {

        // --- post URL -------------------
        val url =
            if(incomingURL.contains("https://hooks.slack.com/")) {
                incomingURL.substring(24+9)
            } else {
                incomingURL
            }
        println(url)

        // --- Query ----------------------
        // TODO ここ実装
        var queryJson = hashMapOf<String,String>(Pair("text", msg))

        if (specificUsername is String)
            queryJson["username"] = specificUsername
        if (targetChannel is String)
            queryJson["channel"] = targetChannel
        if (iconEmoji is String)
            queryJson["icon_emoji"] = iconEmoji

        // --- Query Send ----------------
        val gson = Gson()
//        val responce = API.SlackIncomingAPI.sendMessage(url,gson.toJson(queryJson))
        API.SlackIncomingAPI().sendMessage(url,gson.toJson(queryJson)).enqueue(
            object : Callback<String?> {
                override fun onResponse(
                    call: Call<String?>?,
                    response: Response<String?>
                ) {
                    println("body: ${response.body()}")
                }

                override fun onFailure(call: Call<String?>?, t: Throwable?) {
                    if (t is Throwable)
                       throw t
                }
            }
        )
    }

}