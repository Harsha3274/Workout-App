pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) // This will prevent repositories in the project build files
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "WorkoutApp"
include(":app")
