package jva.cloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MsProductsApplication

fun main(args: Array<String>) {
    runApplication<MsProductsApplication>(*args)
}