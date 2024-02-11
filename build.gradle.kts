plugins {
	java
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
	id("com.diffplug.spotless") version "6.25.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

spotless {
	java {
		palantirJavaFormat()
		configurations {
			compileOnly {
				extendsFrom(configurations.annotationProcessor.get())
			}
		}
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.mockito:mockito-core:5.10.0")
	runtimeOnly("com.h2database:h2")
	implementation("org.modelmapper:modelmapper:3.2.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
