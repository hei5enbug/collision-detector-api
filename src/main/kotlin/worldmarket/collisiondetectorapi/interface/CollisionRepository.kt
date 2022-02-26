package worldmarket.collisiondetectorapi.`interface`

import org.springframework.data.jpa.repository.JpaRepository
import worldmarket.collisiondetectorapi.model.Collision

interface CollisionRepository : JpaRepository<Collision, Long>