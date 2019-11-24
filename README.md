# Slimber - Android Logging with Kotlin  
[![CI Status](https://circleci.com/gh/PaulWoitaschek/Slimber.svg?&style=shield&circle-token=1f53aecb74520d158b6586d177647e6400981dc1)](https://circleci.com/gh/PaulWoitaschek/Slimber)

Timber is a great library that makes logging very easy. However traditional logging like
```java
if (BuildConfig.DEBUG) {
    String message = ...
    Log.d(TAG, message);
}
```
has one big advantage: The whole block will only be executed when you are in debug mode. If you pass anything to Timber, the String itself and the precalculations will be created. Even if you never planted a tree.

And this is where Slimber comes into play: It uses [Kotlin](https://kotlinlang.org/)s `inline` capabilities so we can archieve the **no-cost-effect** because the whole block is executed only when there are trees planted. And remember: In Kotlin you can specify the last function in an arugment of a function outside the parentheses.

 So you can do it like this:
```kotlin
d { "onCreate called with $expensiveToStringObject" }
```
There are also functions that take a throwable as the first paramter, so you can use them like
```kotlin
e(throwable) { "there was a severe error" }
```

Besides from that just use Timber for planting trees like you normally do
```kotlin
Timber.plant(DebugTree())
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
    compile 'com.github.PaulWoitaschek:Slimber:x.y.z'
}
```
