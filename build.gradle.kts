plugins {
    java
}

group = "jpaBasic"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
    implementation("org.hibernate", "hibernate-gradle-plugin", "5.3.10.Final")
    implementation("com.h2database", "h2", "1.4.200")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
}

