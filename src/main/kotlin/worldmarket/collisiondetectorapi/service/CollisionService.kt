package worldmarket.collisiondetectorapi.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import worldmarket.collisiondetectorapi.`interface`.CollisionRepository
import worldmarket.collisiondetectorapi.model.Collision

@Service
class CollisionService {

    @Autowired
    lateinit var collisionRepository: CollisionRepository

    fun getCollisions(): MutableList<Collision> {
        return collisionRepository.findAll()
    }

    fun save(insertData: Collision) {
        collisionRepository.save(insertData)
    }

}