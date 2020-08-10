package model

import data.variable.CliArgs
import data.api.Entry.HostEntry

class TimesSendModel {
    fun onSend(args: CliArgs, entries: Array<HostEntry>){
        var sendTargets = entries.toList()

        // --- [Host] filter --------------------------------------------------------------------------------------------------
        if(args.denyList.isNotEmpty())
            sendTargets = sendTargets.filter { !args.denyList.contains(it.option) }
        if(args.allowList.isNotEmpty())
            sendTargets = sendTargets.filter { args.allowList.contains(it.option) }

        // --- [Request] attach reply id -----------------------------------------------------------------------------------------
        // TODO; ここ実装

        // --- [Request] parameter for only this request ---------------------------------------------------------------
        val dictionary = mapOf<String,String>()
        // TODO("ここ実装")

        // --- make requests & send -----------------------------------------------------------------------------------------
        for (target in sendTargets)
            target.sendMsg(args.msg,dictionary) // targetオブジェクトは，実際はHostEntryクラスを継承したdata.api.Entry.***Entryクラスです．
    }
}