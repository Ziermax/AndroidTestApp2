// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
	alias(libs.plugins.android.application) apply false
	alias(libs.plugins.jetbrains.kotlin.android) apply false

	/*	Dagger Hilt: plugin para el implementation	*/
	id("com.google.dagger.hilt.android") version "2.48" apply false

	/*	Safe Args: plugin para el implementation	*/
	id("androidx.navigation.safeargs.kotlin") version "2.7.7" apply false

}