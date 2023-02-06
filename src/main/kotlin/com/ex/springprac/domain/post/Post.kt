package com.ex.springprac.domain.post

import com.ex.springprac.domain.AuditingEntity
import jakarta.persistence.*

@Entity
@Table(name="post")
class Post(
        title:String,
        content:String
): AuditingEntity() {

        @Column(name = "title", nullable = false)
        var title: String = title
                private set

        @Column(name = "content", nullable = true)
        var content: String = content
                private set

}