import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.*
import data.variable.CliArgs
import data.variable.ConfigFile
import model.TimesSendModel

class TimesCLI : CliktCommand() {
    val message : String by option("-m",help = "Message for send.").required()
    val reply   : Boolean by option("-r",help = "Set reply").flag()

    val targetList by option("-t").split(",")
    val notTargetList by option("-n").split(",")

    override fun run() {
        // SendMsg
        if(true){
            TimesSendModel().onSend(
                args = CliArgs(
                    msg = message,
                    replyMode = reply,
                    allowList = targetList ?: listOf(),
                    denyList = notTargetList ?: listOf()
                ),
                entries = ConfigFile("${System.getProperty("user.home")}/.config/times-cli/config").hostEntries
            )
            echo("[times] $message")
        }
    }
}
fun main(args: Array<String>) = TimesCLI().main(args)
