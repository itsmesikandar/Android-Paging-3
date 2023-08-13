plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
    id("kotlin-kapt")
}

android {
    namespace = "com.dev.android.paging"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dev.android.paging"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug{

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val hiltVersion = "2.44"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")

    val lifecycleVersion = "2.7.0-alpha01"
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

    val retrofitVersion = "2.9.0"
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    val roomVersion = "2.5.2"
    implementation ("androidx.room:room-runtime:$roomVersion")
    implementation ("androidx.room:room-ktx:$roomVersion")
    ksp ("androidx.room:room-compiler:$roomVersion")

    val coroutinesVersion = "1.7.1"
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    val pagingVersion = "3.2.0"
    implementation ("androidx.paging:paging-runtime-ktx:$pagingVersion")

}

kapt {
    correctErrorTypes = true
}