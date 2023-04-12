object Compose {
    const val composeCompilerVersion = "1.4.2"
    private const val composeAnimationVersion = "1.4.0-beta01"
    private const val composeFoundationVersion = "1.4.0-beta01"
    private const val composeMaterialVersion = "1.4.0-beta01"
    private const val composeMaterial3Version = "1.1.0-alpha06"
    private const val composeRuntimeVersion = "1.4.0-beta01"
    private const val composeUiVersion = "1.4.0-beta01"
    private const val constraintLayoutComposeVersion = "1.0.0"
    private const val composeActivitiesVersion = "1.6.0"
    private const val composeNavigationVersion = "2.5.2"
    private const val composeBomVersion = "2023.03.00"


    const val compiler = "androidx.compose.compiler:compiler:$composeCompilerVersion"
    const val runtime = "androidx.compose.runtime:runtime:$composeRuntimeVersion"
    const val foundation = "androidx.compose.foundation:foundation:$composeFoundationVersion"

    const val composeAnimation = "androidx.compose.animation:animation:$composeAnimationVersion"

    const val ui = "androidx.compose.ui:ui:$composeUiVersion"
    const val uiTooling = "androidx.compose.ui:ui-tooling:$composeUiVersion"
    const val viewBinding = "androidx.compose.ui:ui-viewbinding:$composeUiVersion"

    const val material = "androidx.compose.material:material:$composeMaterialVersion"
    const val materialIcons =
        "androidx.compose.material:material-icons-core:$composeMaterialVersion"
    const val materialIconsExtended =
        "androidx.compose.material:material-icons-extended:$composeMaterialVersion"
    const val material3 = "androidx.compose.material3:material3:$composeMaterial3Version"

    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:${constraintLayoutComposeVersion}"

    const val activity = "androidx.activity:activity-compose:${composeActivitiesVersion}"

    const val navigation = "androidx.navigation:navigation-compose:${composeNavigationVersion}"

    const val composeBom = "androidx.compose:compose-bom:$composeBomVersion"

}