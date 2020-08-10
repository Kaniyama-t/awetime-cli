package data.variable

import com.google.gson.Gson
import data.api.Entry.HostEntry
import data.local.HostEntryConfig
import java.io.File

class ConfigFile(private val configFilePath: String) {
    var hostEntries: Array<HostEntry> = arrayOf()

    init {
        val gson = Gson()
        val configFile = File(configFilePath).readText()
        hostEntries += gson.fromJson(configFile, HostEntryConfig::class.java).slackIncoming
//        for ((i,entry) in hostEntries.withIndex()){
//            when (entry.system) {
//                "slack" -> {
//                }
//            }
//        }
    }
}