import org.gradle.kotlin.dsl.DependencyHandlerScope

object Modules{

   fun DependencyHandlerScope.appDependencies(){
      implementation(AppDependencies.coreAndroidLibraries)
      implementation(AppDependencies.coreUiLibraries)
      implementation(AppDependencies.concurrency)
      implementation(AppDependencies.di)
      implementation(AppDependencies.database)
      kapt(AppDependencies.kapt)
      implementation(AppDependencies.networkCall)
      implementation(AppDependencies.marshaling)
      implementation(AppDependencies.coreLogger)
      implementation(AppDependencies.testLibraries)
      implementation(AppDependencies.androidTestLibraries)
   }
}