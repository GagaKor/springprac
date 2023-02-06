package com.ex.springprac.domain.comment

import com.ex.springprac.domain.AuditingEntity
import com.ex.springprac.domain.post.Post
import jakarta.persistence.*

@Entity
@Table(name="comment")
class Comment(
        content:String,
        post : Post
):AuditingEntity() {

    @Column(name = "content", nullable = false)
    var content : String = content
        private set

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post::class)
    var post: Post = post
        private set
}