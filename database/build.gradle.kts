plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp) // Cambiamos KAPT por KSP para mejor rendimiento
}

android {
    namespace = "com.luciadcf.checkly.core.database"
    compileSdk = 35 // Cambiado a 35 (el estándar actual estable, 36 es Preview)

    defaultConfig {
        minSdk = 26
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Configuración para que Room exporte el esquema (útil para migraciones)
        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
}

dependencies {
    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler) // KSP en lugar de kapt

    // Coroutines (Vienen del catálogo)
    implementation(libs.kotlinx.coroutines.android)

    // Inyección de dependencias (Koin) para la BBDD
    implementation(libs.koin.android)
}