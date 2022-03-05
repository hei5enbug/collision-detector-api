package worldmarket.collisiondetectorapi.config

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HttpRequestConfig {

    @Bean
    fun requestFilter(): FilterRegistrationBean<ContentCachingFilter> {
        val filterRegistrationBean = FilterRegistrationBean(ContentCachingFilter())
        filterRegistrationBean.urlPatterns = listOf("/*")
        return filterRegistrationBean
    }
}