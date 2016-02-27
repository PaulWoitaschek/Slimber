import timber.log.Timber

object Slimber {

    /** Invokes an action if any trees are planted */
    inline fun ifPlanted(action: () -> Any) {
        if (Timber.treeCount() != 0) {
            action.invoke()
        }
    }

    /** Delegates the provided message to [Timber.e]  if any trees are planted. */
    inline fun e(message: () -> String) = ifPlanted { Timber.e(message.invoke()) }

    /** Delegates the provided message to [Timber.e]  if any trees are planted. */
    inline fun e(throwable: Throwable, message: () -> String) = ifPlanted { Timber.e(throwable, message.invoke()) }

    /** Delegates the provided message to [Timber.w]  if any trees are planted. */
    inline fun w(message: () -> String) = ifPlanted { Timber.w(message.invoke()) }

    /** Delegates the provided message to [Timber.w]  if any trees are planted. */
    inline fun w(throwable: Throwable, message: () -> String) = ifPlanted { Timber.w(throwable, message.invoke()) }

    /** Delegates the provided message to [Timber.i]  if any trees are planted. */
    inline fun i(message: () -> String) = ifPlanted { Timber.i(message.invoke()) }

    /** Delegates the provided message to [Timber.i]  if any trees are planted. */
    inline fun i(throwable: Throwable, message: () -> String) = ifPlanted { Timber.i(throwable, message.invoke()) }

    /** Delegates the provided message to [Timber.d]  if any trees are planted. */
    inline fun d(message: () -> String) = ifPlanted { Timber.d(message.invoke()) }

    /** Delegates the provided message to [Timber.d]  if any trees are planted. */
    inline fun d(throwable: Throwable, message: () -> String) = ifPlanted { Timber.d(throwable, message.invoke()) }

    /** Delegates the provided message to [Timber.v]  if any trees are planted. */
    inline fun v(message: () -> String) = ifPlanted { Timber.v(message.invoke()) }

    /** Delegates the provided message to [Timber.v]  if any trees are planted. */
    inline fun v(throwable: Throwable, message: () -> String) = ifPlanted { Timber.v(throwable, message.invoke()) }

    /** Delegates the provided message to [Timber.wtf]  if any trees are planted. */
    inline fun wtf(message: () -> String) = ifPlanted { Timber.wtf(message.invoke()) }

    /** Delegates the provided message to [Timber.wtf]  if any trees are planted. */
    inline fun wtf(throwable: Throwable, message: () -> String) = ifPlanted { Timber.wtf(throwable, message.invoke()) }

    /** Delegates the provided message to [Timber.log]  if any trees are planted. */
    inline fun log(priority: Int, t: Throwable, message: () -> String) = ifPlanted { Timber.log(priority, t, message.invoke()) }

    /** Delegates the provided message to [Timber.log]  if any trees are planted. */
    inline fun log(priority: Int, message: () -> String) = ifPlanted { Timber.log(priority, message.invoke()) }
}