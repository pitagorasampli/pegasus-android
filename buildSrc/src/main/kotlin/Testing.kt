object Testing {
    private const val junit4Version = "4.12"
    private const val testCoreVersion = "1.4.0-beta01"
    private const val testRunnerVersion = "1.2.0"
    private const val espressoVersion = "3.2.0"
    private const val mockkVersion = "1.13.2"
    private const val truthVersion = "1.0"
    private const val testExtVersion = "1.1.3"

    //Android Test Core
    const val junit4 = "junit:junit:$junit4Version"
    const val testRunner = "androidx.test:runner:$testRunnerVersion"
    const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
    const val testCore = "androidx.test:core:$testCoreVersion"

    //Needed to avoid manifest merge for instrumented tests on Android 12
    const val testExt = "androidx.test.ext:junit:$testExtVersion"

    const val androidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"

    //Coroutines test

    //Mockk For Android Instrumented Testing
    const val mockkAndroid = "io.mockk:mockk-android:$mockkVersion"

    //Mockk For Unit Testing
    const val mockk = "io.mockk:mockk:$mockkVersion"

    const val truth = "com.google.truth:truth:$truthVersion"
}