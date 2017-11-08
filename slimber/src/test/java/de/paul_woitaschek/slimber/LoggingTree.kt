package de.paul_woitaschek.slimber

import timber.log.Timber
import java.util.ArrayList

class LoggingTree : Timber.DebugTree() {

  private val logItems = ArrayList<LogItem>()

  override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
    val item = LogItem(priority, tag, message, t)
    logItems.add(item)
  }

  fun logs() = ArrayList(logItems)
}
