plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")}

android {
    namespace = "com.naama.movieapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.naama.movieapp"
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("com.google.code.gson:gson:2.11.0") // Verifique se a versão está correta de acordo com seu arquivo libs.versions.toml
    //implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")
    //Room
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    kapt("androidx.room:room-compiler:$room_version")

    //Retrofit
   //val retrofit_version = "2.11.0"
    //implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")
    //implementation ("com.squareup.retrofit2:converter-gson$retrofit_version")
   // implementation ("com.google.code.gson:gson:2.11.0")
    //implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation(libs.retrofit)
    implementation(libs.gsonConverter)
    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

}
