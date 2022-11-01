package slimber.log

import com.google.common.truth.Truth
import org.junit.After
import org.junit.Before
import org.junit.Test
import timber.log.Timber

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

      Timber.tag("i")
      i { "info" }

      Timber.tag("d")
      d { "debug" }

      Timber.tag("w")
      w { "warn" }

      Timber.tag("e")
      e { "error" }

      Timber.tag("v")
      v { "verbose" }

      Timber.tag("wtf")
      wtf { "assert" }

    Truth.assertThat(loggingTree.logs())
      .containsExactly(
        LogItem.i("i", "info"),
        LogItem.d("d", "debug"),
        LogItem.w("w", "warn"),
        LogItem.e("e", "error"),
        LogItem.v("v", "verbose"),
        LogItem.wtf("wtf", "assert"),
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
