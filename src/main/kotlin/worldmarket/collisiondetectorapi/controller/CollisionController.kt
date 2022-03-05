package worldmarket.collisiondetectorapi.controller

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import worldmarket.collisiondetectorapi.model.Collision
import worldmarket.collisiondetectorapi.service.CollisionService
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/collision")
class CollisionController(val collisionService: CollisionService) {

    private final val logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping
    fun getCollisions(): ResponseEntity<MutableList<Collision>> {
        return ResponseEntity.ok().body(collisionService.getCollisions())
    }

    @PostMapping
    fun postCollision(request: HttpServletRequest,
                      @RequestBody collision: Collision): ResponseEntity<HashMap<String, String>> {
        var resultMsg = "DB save Success"
        try {
            collisionService.save(collision)
        } catch (e: Exception) {
            logger.error(e.localizedMessage)
            resultMsg = "DB save Failed"
        }

        val resultMap = hashMapOf("result_msg" to resultMsg, "collision_data" to collision.toString())
        return ResponseEntity.ok().body(resultMap)
    }

}