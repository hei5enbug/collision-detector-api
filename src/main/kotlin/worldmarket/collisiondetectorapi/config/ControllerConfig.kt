package worldmarket.collisiondetectorapi.config

import org.apache.coyote.Response
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
class ControllerConfig {
    private val logger: Logger = LoggerFactory.getLogger(LogAspect::class.java)

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handle(e: HttpMessageNotReadableException?): ResponseEntity<String> {
        logger.warn("Returning HTTP 400 Bad Request", e)
        return ResponseEntity.badRequest().body(e?.localizedMessage)
    }
}