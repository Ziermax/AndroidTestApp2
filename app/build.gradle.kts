plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)

	/*	Dagg er Hilt: plugin para el implementation	*/
	id("kotlin-kapt")
	id("com.google.dagger.hilt.android")

	/*	Safe Args	*/
	id("androidx.navigation.safeargs.kotlin")

}

android {
	namespace = "com.ziermax.horoscopapp"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.ziermax.horoscopapp"
		minSdk = 24
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		viewBinding = true
	}
}

dependencies {


	/*	Navigation Component: Navegacion de fragmentos	*/
	val navVersion:String = "2.7.7"
	implementation("androidx.navigation:navigation-fragment:$navVersion")
	implementation("androidx.navigation:navigation-ui:$navVersion")

	/*	Dagger Hilt: Inyeccion de Dependencias	*/
	implementation("com.google.dagger:hilt-android:2.48")
	kapt("com.google.dagger:hilt-android-compiler:2.48")

	/*	Retro Fit	*/
	implementation("com.squareup.retrofit2:retrofit:2.11.0")
	implementation("com.squareup.retrofit2:converter-gson:2.11.0")

	/*	CameraX	*/
	val camerax_version: String = "1.3.3"
	implementation ("androidx.camera:camera-core:${camerax_version}")
	implementation ("androidx.camera:camera-camera2:${camerax_version}")
	implementation ("androidx.camera:camera-lifecycle:${camerax_version}")
	implementation ("androidx.camera:camera-video:${camerax_version}")
	implementation ("androidx.camera:camera-view:${camerax_version}")
	implementation ("androidx.camera:camera-extensions:${camerax_version}")

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	implementation(libs.androidx.activity)
	implementation(libs.androidx.constraintlayout)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}