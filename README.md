# Slimber
*Like [Timber](https://github.com/JakeWharton/timber), only slim. Uses Kotlin to extend Timber.*

Timber is a great library that makes logging very easy. However traditional logging like
```java
if (BuildConfig.DEBUG) {
    String reason = ...
    Log.e(TAG, "There was an error " +reason + " while state was " +state, throwbable);
}
```
has one big advantage: The whole block will only be executed when you are in debug mode. If you pass anything to Timber, the String itself and the precalculations will be created. Even if you never planted a tree.

And this is where Slimber comes into play: It uses [Kotlin](https://kotlinlang.org/)s `inline` capabilities so we can archieve the **no-cost-effect**.

# How to use
You just replace each call like `Timber.e(throwable, "Logmessage")` with a function call: `Slimber.e(throwable, {"Logmessage"})`.

Remember: In Kotlin you specify the last function in an arugment of a function outside the parentheses. So you can do it like this:
```kotlin
val ob = "String"
val number = 5
Slimber.e (throwable) {
    "There was a serious issue with $ob at $number"
}
// or just
Slimber.d { "onCreate called" }
```

# Installation
Add this to your root `build.gradle`
```gradle
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
And then this dependency to your project:
```gradle
dependencies {
    compile 'com.github.PaulWoitaschek:Slimber:1.0.1'
}
```
