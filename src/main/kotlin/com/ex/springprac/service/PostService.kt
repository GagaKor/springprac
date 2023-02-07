package com.ex.springprac.service

import com.ex.springprac.domain.post.Post
import com.ex.springprac.domain.post.PostRepository
import com.ex.springprac.domain.post.PostRes
import com.ex.springprac.domain.post.toDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
        private val postsRepository: PostRepository
) {
    @Transactional(readOnly = true)
    fun findPosts():List<PostRes>{
        return postsRepository.findAll().map{
            it.toDto()
        };
    }
}