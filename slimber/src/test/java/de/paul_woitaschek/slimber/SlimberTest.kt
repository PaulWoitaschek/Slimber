package de.paul_woitaschek.slimber

import d
import e
import i
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import timber.log.Timber
import timber.log.Timber.tag
import v
import w
import wtf


/**
 * JUnit tests for Slimber
 *
 * @author Paul Woitaschek
 */
class SlimberTest {

  @Before @After fun setUpAndTearDown() {
    // clear timber after each test
    Timber.uprootAll()
  }

  /** Tests that the log messages arrive */
  @Test fun testLogs() {
    val loggingTree = LoggingTree()
    Timber.plant(loggingTree)

    tag("i")
    i { "info" }

    tag("d")
    d { "debug" }

    tag("w")
    w { "warn" }

    tag("e")
    e { "error" }

    tag("v")
    v { "verbose" }

    tag("wtf")
    wtf { "assert" }

    assertThat(loggingTree.logs())
      .containsExactly(
        LogItem.i("i", "info"),
        LogItem.d("d", "debug"),
        LogItem.w("w", "warn"),
        LogItem.e("e", "error"),
        LogItem.v("v", "verbose"),
        LogItem.wtf("wtf", "assert")
      )
  }

  /** test that the blocks are not executed when there are no trees planted */
  @Test fun testBlockNotExecuted() {
    val logThrowable = RuntimeException()

    i { throw AssertionError() }
    i(logThrowable) { throw AssertionError() }

    d { throw AssertionError() }
    d(logThrowable) { throw AssertionError() }

    w { throw AssertionError() }
    w(logThrowable) { throw AssertionError() }

    e { throw AssertionError() }
    e(logThrowable) { throw AssertionError() }

    v { throw AssertionError() }
    v(logThrowable) { throw AssertionError() }

    wtf { throw AssertionError() }
    wtf(logThrowable) { throw AssertionError() }
  }
}