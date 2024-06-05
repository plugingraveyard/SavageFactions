import com.ryderbelserion.feather.enums.Repository
import org.gradle.accessors.dm.LibrariesForLibs

val libs = the<LibrariesForLibs>()

plugins {
    id("com.ryderbelserion.feather-core")

    java
}

java {
    withJavadocJar()
    withSourcesJar()
}

dependencies {

}

feather {
    repository("https://repo.codemc.io/repository/maven-public")

    repository(Repository.CrazyCrewReleases.url)

    repository(Repository.Jitpack.url)

    configureJava {
        javaSource(JvmVendorSpec.ADOPTIUM)

        javaVersion(21)
    }
}