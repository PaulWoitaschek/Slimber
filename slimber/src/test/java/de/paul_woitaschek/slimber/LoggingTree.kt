package de.paul_woitaschek.slimber

import timber.log.Timber
import java.util.ArrayList

/**
 * A tree that stores messages as log items
 *
 * @author Paul Woitaschek
 */
class LoggingTree : Timber.DebugTree() {

  private val logItems = ArrayList<LogItem>()

  override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
    val item = LogItem(priority, tag, message, t)
    logItems.add(item)
  }

  fun logs() = ArrayList(logItems)
}
