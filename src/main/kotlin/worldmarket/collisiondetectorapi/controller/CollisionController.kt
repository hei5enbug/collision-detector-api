package worldmarket.collisiondetectorapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import worldmarket.collisiondetectorapi.model.Collision
import worldmarket.collisiondetectorapi.service.CollisionService

@RestController
@RequestMapping("/collision")
class CollisionController(val collisionService: CollisionService) {


    @GetMapping(produces = ["application/json"])
    fun getCollisions(): ResponseEntity<MutableList<Collision>> {
        return ResponseEntity.ok().body(collisionService.getCollisions())
    }

    @PostMapping
    fun postCollision(@RequestBody collision: Collision): ResponseEntity<Boolean> {
        collisionService.save(collision)
        return ResponseEntity.ok().body(true)
    }

}