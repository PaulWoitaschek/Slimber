package de.paul_woitaschek.slimber

import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import timber.log.Timber
import timber.log.Timber.Forest.tag

class SlimberTest {

  @Before
  @After
  fun uproot() {
    // clear timber after each test
    Timber.uprootAll()
  }

  /** Tests that the log messages arrive */
  @Test
  fun logs() {
    val loggingTree = LoggingTree()
    Timber.plant(loggingTree)

    tag("i")
    i { "info" }

    tag("d")
    d { "debug" }

    tag("de.paul_woitaschek.slimber.w")
    w { "warn" }

    tag("e")
    e { "error" }

    tag("de.paul_woitaschek.slimber.v")
    v { "verbose" }

    tag("de.paul_woitaschek.slimber.wtf")
    wtf { "assert" }

    assertThat(loggingTree.logs())
      .containsExactly(
        LogItem.i("i", "info"),
        LogItem.d("d", "debug"),
        LogItem.w("de.paul_woitaschek.slimber.w", "warn"),
        LogItem.e("e", "error"),
        LogItem.v("de.paul_woitaschek.slimber.v", "verbose"),
        LogItem.wtf("de.paul_woitaschek.slimber.wtf", "assert")
      )
  }

  /** test that the blocks are not executed when there are no trees planted */
  @Test
  fun blockNotExecuted() {
    val logThrowable = RuntimeException()

    val throwAssertionError = { throw AssertionError() }

    i(throwAssertionError)
    i(logThrowable, throwAssertionError)

    d(throwAssertionError)
    d(logThrowable, throwAssertionError)

    w(throwAssertionError)
    w(logThrowable, throwAssertionError)

    e(throwAssertionError)
    e(logThrowable, throwAssertionError)

    v(throwAssertionError)
    v(logThrowable, throwAssertionError)

    wtf(throwAssertionError)
    wtf(logThrowable, throwAssertionError)
  }
}