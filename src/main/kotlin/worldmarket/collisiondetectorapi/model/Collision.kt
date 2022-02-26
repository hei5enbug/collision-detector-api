package worldmarket.collisiondetectorapi.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity(name = "collisions")
data class Collision(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collision_id")
    val id: Long?,

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "detection_time")
    var detectionTime: LocalDateTime? = null,

    @Column(name = "acc_x") val accX: Double,
    @Column(name = "acc_y") val accY: Double,
    @Column(name = "acc_z") val accZ: Double,
    @Column(name = "gyro_x") val gyroX: Double,
    @Column(name = "gyro_y") val gyroY: Double,
    @Column(name = "gyro_z") val gyroZ: Double,
)
