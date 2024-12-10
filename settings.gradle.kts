plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "product-service"
include("apigateway")
include("apigateway:infrastructure")
findProject(":apigateway:infrastructure")?.name = "infrastructure"
include("ms-products")
include("ms-products:domain")
findProject(":ms-products:domain")?.name = "domain"
include("ms-products:application")
findProject(":ms-products:application")?.name = "application"
include("ms-products:infrastructure")
findProject(":ms-products:infrastructure")?.name = "infrastructure"
include("ms-users")
include("ms-users:application")
findProject(":ms-users:application")?.name = "application"
include("ms-users:domain")
findProject(":ms-users:domain")?.name = "domain"
include("ms-users:infrastructure")
findProject(":ms-users:infrastructure")?.name = "infrastructure"
