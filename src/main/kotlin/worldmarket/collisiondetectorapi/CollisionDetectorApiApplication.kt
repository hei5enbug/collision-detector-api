package worldmarket.collisiondetectorapi

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@Configuration
@EnableEncryptableProperties
@EnableAspectJAutoProxy
@EnableJpaAuditing
@SpringBootApplication
class CollisionDetectorApiApplication

fun main(args: Array<String>) {
    runApplication<CollisionDetectorApiApplication>(*args)
}
