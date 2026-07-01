package org.example.app
import io.ktor.http.ContentType
import java.net.http.HttpClient
import org.example.utils.Printer
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.receiveText
import io.ktor.server.response.respondBytes
import io.ktor.server.response.respondText
import io.ktor.server.http.content.*
import org.example.app.QrService

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    embeddedServer(Netty, 8080) {
        routing {
            staticResources("/", "static")
            post("/generate"){
                val url = call.receiveText()
                val imageBytes = QrService.generate(url)
                call.respondBytes(imageBytes, ContentType.Image.PNG)
            }
        }
    }.start(wait = true)

}
