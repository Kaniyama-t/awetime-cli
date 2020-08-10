package data.variable

data class CliArgs(
    val msg: String,
    val replyMode: Boolean,
    val allowList: List<String>,
    val denyList: List<String>
)