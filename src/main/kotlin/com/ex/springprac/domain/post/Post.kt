package com.ex.springprac.domain.post

import com.ex.springprac.domain.AuditingEntity
import com.ex.springprac.domain.member.Member
import com.ex.springprac.domain.member.toDto
import jakarta.persistence.*

@Entity
@Table(name="post")
class Post(
        title:String,
        content:String,
        member:Member
): AuditingEntity() {

        @Column(name = "title", nullable = false)
        var title: String = title
                private set

        @Column(name = "content", nullable = true)
        var content: String = content
                private set

        @ManyToOne(fetch = FetchType.LAZY, targetEntity = Member::class)
        var member:Member = member
                private set

        override fun toString(): String {
                return "Post(id=$id, title=$title, content=$content, member=$member)"
        }
}
fun Post.toDto(): PostRes{
       return PostRes(
                id = this.id!!,
                title = this.title,
                content = this.content,
                member = this.member.toDto()
        )
}