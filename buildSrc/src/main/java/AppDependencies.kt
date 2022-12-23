object AppDependencies {
    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${DependencyVersions.kotlin}"

    //android ui
    private val appcompat = "androidx.appcompat:appcompat:${DependencyVersions.appcompat}"
    private val coreKtx = "androidx.core:core-ktx:${DependencyVersions.coreKtx}"
    private val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${DependencyVersions.constraintLayout}"
    private val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${DependencyVersions.lifecycle_version}"
    private val material = "com.google.android.material:material:${DependencyVersions.material}"

    //Concurrency


    //Logger
    private val timber_logger = "com.jakewharton.timber:timber:${DependencyVersions.timber}"

    //test libs
    private val junit = "junit:junit:${DependencyVersions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${DependencyVersions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${DependencyVersions.espresso}"

    //Storage
    private val room_runtime = "androidx.room:room-runtime:${DependencyVersions.room_version}"
    private val room_ktx = "androidx.room:room-ktx:${DependencyVersions.room_version}"
    private val room_rxJava = "androidx.room:room-rxjava2:${DependencyVersions.room_version}"
    private val room_kapt = "androidx.room:room-compiler:${DependencyVersions.room_version}"

    // Network
    private val retrofit_gson_converter =
        "com.squareup.retrofit2:converter-gson:${DependencyVersions.retrofit}"
    private val retrofix_rxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${DependencyVersions.retrofit}"
    private val retrofit_http_logger =
        "com.squareup.okhttp3:logging-interceptor:${DependencyVersions.retrofit_logger}"

    //Gson
    private val gson = "com.google.code.gson:gson:${DependencyVersions.gson}"

    //Di
    private val dagger_hilt ="com.google.dagger:hilt-android:2.44"
    private val dagger_hilt_kapt = "com.google.dagger:hilt-android-compiler:2.44"


    val database = arrayListOf<String>().apply {
        add(room_runtime)
        add(room_ktx)
        add(room_rxJava)
    }

    val kapt = arrayListOf<String>().apply {
        add(room_kapt)
        add(dagger_hilt_kapt)
    }

    val coreAndroidLibraries = arrayListOf<String>().apply {
        add(coreKtx)
        add(appcompat)
    }

    val kotlin = arrayListOf<String>().apply {
        add(kotlinStdLib)
    }

    val di = arrayListOf<String>().apply {
        add(dagger_hilt)
    }

    val coreUiLibraries = arrayListOf<String>().apply {
        add(constraintLayout)
        add(viewModel)
        add(material)

    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(junit)
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }

    val coreLogger = arrayListOf<String>().apply {
        add(timber_logger)
    }

    val concurrency = arrayListOf<String>().apply {

    }

    val networkCall = arrayListOf<String>().apply {
        add(retrofix_rxjava2)
        add(retrofit_http_logger)
        add(retrofit_gson_converter)
    }
    val marshaling = arrayListOf<String>().apply {
        add(gson)
    }
}
