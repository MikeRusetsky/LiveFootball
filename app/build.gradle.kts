plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
}

android {
    namespace = "com.mikerusetsky.livefootball"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mikerusetsky.livefootball"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //ui
    implementation ("androidx.fragment:fragment-ktx:1.6.2")
    implementation ("com.google.android.material:material:1.11.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.11.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("com.google.android.material:material:<version>")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0-alpha13")
    implementation ("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.9")
    
    // splashScreen
    implementation ("androidx.core:core-splashscreen:1.0.0-alpha02")

    //Tests
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.hamcrest:hamcrest-library:1.3")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.test.espresso:espresso-contrib:3.4.0")

    //pagination
    implementation ("androidx.paging:paging-runtime:3.1.0")

    //ui
    implementation ("com.airbnb.android:lottie:6.1.0")

    //navigation
    implementation ("androidx.navigation:navigation-fragment-ktx:2.3.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.3.3")

    //di
    implementation ("com.google.dagger:dagger:2.50")
    kapt ("com.google.dagger:dagger-compiler:2.50")

    //network
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.6.0")
    implementation ("com.google.code.gson:gson:2.10.1")
}