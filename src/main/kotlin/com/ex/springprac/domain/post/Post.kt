package com.ex.springprac.domain.post

import com.ex.springprac.domain.AuditingEntity
import com.ex.springprac.domain.member.Member
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

}