package worldmarket.collisiondetectorapi.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import org.springframework.web.util.ContentCachingRequestWrapper


@Aspect
@Component
class LogAspect {
    private val logger: Logger = LoggerFactory.getLogger(LogAspect::class.java)

    @Pointcut("within(worldmarket.collisiondetectorapi.controller..*)")
    fun onRequest() {
    }

    @AfterThrowing("worldmarket.collisiondetectorapi.config.LogAspect.onRequest()")
    fun logging(joinPoint: JoinPoint) {
        try {
            val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
            var params = getRequestParams()
            if ("POST" == request.method) {
                params = ObjectMapper()
                    .readTree((request as ContentCachingRequestWrapper).contentAsByteArray).toString()
            }

            logger.info(
                "REQUEST - {}({}) = {}", joinPoint.signature.declaringTypeName, joinPoint.signature.name, params
            )
        } catch (e: Exception) {
            throw e
        }
    }

    // get requset value
    private fun getRequestParams(): String {
        var params = ""
        val requestAttribute = RequestContextHolder.getRequestAttributes()

        if (requestAttribute != null) {
            val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes?)!!.request
            val paramMap = request.parameterMap
            if (paramMap.isNotEmpty()) {
                params = " [" + paramMapToString(paramMap) + "]"
            }
        }
        return params
    }

    private fun paramMapToString(paramMap: Map<String, Array<String>>): String {
        return paramMap.entries.joinToString(" ,") { entry -> "${entry.key} : ${entry.value}" }
    }

}