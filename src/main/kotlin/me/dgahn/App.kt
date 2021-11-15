package me.dgahn

import me.dgahn.app.config.AppV1Config
import me.dgahn.app.config.AppV2Config
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(value = [AppV1Config::class, AppV2Config::class])
@SpringBootApplication(scanBasePackages = ["me.dgahn.app"])
class App

fun main(arg: Array<String>) {
    runApplication<App>(*arg)
}
