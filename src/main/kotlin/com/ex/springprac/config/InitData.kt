package com.ex.springprac.config

import com.ex.springprac.domain.member.*
import com.ex.springprac.domain.post.Post
import com.ex.springprac.domain.post.PostRepository
import com.ex.springprac.domain.post.PostSaveReq
import com.ex.springprac.domain.post.toEntity
import io.github.serpro69.kfaker.faker
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

@Configuration
class InitData (
        private val memberRepository: MemberRepository,
        private val postRepository: PostRepository
){

    val faker = faker { }

    @EventListener(ApplicationReadyEvent::class)
    private fun init(){
        val members = generateMembers(100)
        memberRepository.saveAll(members)
        val posts = generatePosts(100)
        postRepository.saveAll(posts)
    }

    private  fun generatePosts(cnt: Int): MutableList<Post>{
        val posts = mutableListOf<Post>()


        for(i in 1..100) {
            val post = generatePost()
            print(post)
            posts.add(post)

        }
        return posts
    }
    private fun generatePost(): Post{
        return PostSaveReq(
                title = faker.animal.name(),
                content = faker.food.fruits(),
                memberId = 1,
        ).toEntity()
    }
    private  fun generateMembers(cnt: Int): MutableList<Member>{
        val members = mutableListOf<Member>()


        for(i in 1..100) {
            val member = generateMember()
            members.add(member)
        }

        return members
    }
    private fun generateMember(): Member{
        return MemberSaveReq(
                email = faker.internet.safeEmail(),
                password = "1234",
                role = Role.USER
        ).toEntity()
    }
}