package data.local

import data.api.Entry.HostEntry
import data.api.Entry.SlackIncomingEntry

data class HostEntryConfig (val slackIncoming: Array<SlackIncomingEntry>)