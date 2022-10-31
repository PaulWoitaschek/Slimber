plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
  `maven-publish`
}

android {
  namespace = "slimber"
  compileSdk = 33

  publishing {
    singleVariant("release") {
      withSourcesJar()
    }
  }

  lint {
    warningsAsErrors = true
    checkAllWarnings = true
  }

  defaultConfig {
    minSdk = 16
  }
  buildTypes {
    release {
      isMinifyEnabled = false
    }
  }
}

publishing {
  publications {
    register<MavenPublication>("release") {
      groupId = "de.paul-woitaschek"
      artifactId = "slimber"
      version = libs.versions.slimber.get()
      pom {
        developers {
          developer {
            id.set("PaulWoitaschek")
            name.set("Paul Woitaschek")
          }
        }
        description.set("A library for Kotlin that reduces the overhead when sending logs with Timber.")
        url.set("https://github.com/PaulWoitaschek/Slimber")
        licenses {
          license {
            name.set("The Apache Software License, Version 2.0")
            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
          }
        }
      }

      afterEvaluate {
        from(components["release"])
      }
    }
  }
}

dependencies {
  api(libs.timber)
  testImplementation(libs.truth)
  testImplementation(libs.junit)
}
