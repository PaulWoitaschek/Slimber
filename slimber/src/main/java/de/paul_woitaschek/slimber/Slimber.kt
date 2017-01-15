@file:Suppress("unused")

import timber.log.Timber

/** Invokes an action if any trees are planted */
inline fun ifPlanted(action: () -> Any) {
  if (Timber.treeCount() != 0) {
    action()
  }
}

/** Delegates the provided message to [Timber.e]  if any trees are planted. */
inline fun e(message: () -> String) = ifPlanted { Timber.e(message()) }

/** Delegates the provided message to [Timber.e]  if any trees are planted. */
inline fun e(throwable: Throwable, message: () -> String) = ifPlanted { Timber.e(throwable, message()) }

/** Delegates the provided message to [Timber.w]  if any trees are planted. */
inline fun w(message: () -> String) = ifPlanted { Timber.w(message()) }

/** Delegates the provided message to [Timber.w]  if any trees are planted. */
inline fun w(throwable: Throwable, message: () -> String) = ifPlanted { Timber.w(throwable, message()) }

/** Delegates the provided message to [Timber.i]  if any trees are planted. */
inline fun i(message: () -> String) = ifPlanted { Timber.i(message()) }

/** Delegates the provided message to [Timber.i]  if any trees are planted. */
inline fun i(throwable: Throwable, message: () -> String) = ifPlanted { Timber.i(throwable, message()) }

/** Delegates the provided message to [Timber.d]  if any trees are planted. */
inline fun d(message: () -> String) = ifPlanted { Timber.d(message()) }

/** Delegates the provided message to [Timber.d]  if any trees are planted. */
inline fun d(throwable: Throwable, message: () -> String) = ifPlanted { Timber.d(throwable, message()) }

/** Delegates the provided message to [Timber.v]  if any trees are planted. */
inline fun v(message: () -> String) = ifPlanted { Timber.v(message()) }

/** Delegates the provided message to [Timber.v]  if any trees are planted. */
inline fun v(throwable: Throwable, message: () -> String) = ifPlanted { Timber.v(throwable, message()) }

/** Delegates the provided message to [Timber.wtf]  if any trees are planted. */
inline fun wtf(message: () -> String) = ifPlanted { Timber.wtf(message()) }

/** Delegates the provided message to [Timber.wtf]  if any trees are planted. */
inline fun wtf(throwable: Throwable, message: () -> String) = ifPlanted { Timber.wtf(throwable, message()) }

/** Delegates the provided message to [Timber.log]  if any trees are planted. */
inline fun log(priority: Int, t: Throwable, message: () -> String) = ifPlanted { Timber.log(priority, t, message()) }

/** Delegates the provided message to [Timber.log]  if any trees are planted. */
inline fun log(priority: Int, message: () -> String) = ifPlanted { Timber.log(priority, message()) }