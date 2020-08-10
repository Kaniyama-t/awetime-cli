package data.api.Entry

import java.util.*

/***
 * @property name ユーザが定義するエントリ名（単なるID）
 * @property option time-cli上でhostEntry単体を指すユーザ定義の名前
 * @property system Hostのシステム名(Slack-Incomming等)
 */

abstract class HostEntry {
    abstract val name: String
    abstract val option: String
    abstract val system: String

    abstract fun sendMsg(msg: String, params: Map<String,String>?)
}