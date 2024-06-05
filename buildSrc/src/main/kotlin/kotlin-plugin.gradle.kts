import com.ryderbelserion.feather.enums.Repository

plugins {
    id("com.ryderbelserion.feather-core")

    kotlin("jvm")
}

repositories {
    mavenCentral()
}

feather {
    repository("https://repo.codemc.io/repository/maven-public")

    repository(Repository.CrazyCrewReleases.url)

    repository(Repository.Jitpack.url)

    configureKotlin {
        javaSource(JvmVendorSpec.ADOPTIUM)

        javaVersion(21)
    }
}