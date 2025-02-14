plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.codesthetic.devcon_koin"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.codesthetic.devcon_koin"
        minSdk = 24
        targetSdk = 33
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
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Koin
    implementation("io.insert-koin:koin-core:3.2.2")
    implementation("io.insert-koin:koin-android:3.2.2")
    // Koin Test features
    testImplementation("io.insert-koin:koin-test:3.2.2")
    // Koin for JUnit 4
    testImplementation("io.insert-koin:koin-test-junit4:3.2.2")
    // Koin for JUnit 5
    testImplementation("io.insert-koin:koin-test-junit5:3.2.2")

    // Java Compatibility
    implementation("io.insert-koin:koin-android-compat:3.2.2")
    // Jetpack WorkManager
    implementation("io.insert-koin:koin-androidx-workmanager:3.2.2")
    // Navigation Graph
    implementation("io.insert-koin:koin-androidx-navigation:3.2.2")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.1")

    // Picasso
    implementation("com.squareup.picasso:picasso:2.8")

    implementation("io.coil-kt:coil:2.4.0")


}
