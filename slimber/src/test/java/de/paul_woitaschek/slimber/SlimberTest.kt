package de.paul_woitaschek.slimber

import com.google.common.truth.Truth.assertThat
import d
import e
import i
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

  @Before
  @After
  fun setUpAndTearDown() {
    // clear timber after each test
    Timber.uprootAll()
  }

  /** Tests that the log messages arrive */
  @Test
  fun testLogs() {
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
  @Test
  fun testBlockNotExecuted() {
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