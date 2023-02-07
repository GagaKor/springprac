package com.ex.springprac.api

import com.ex.springprac.service.PostService
import com.ex.springprac.util.CmResDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController(
        private val postService: PostService
) {

    @GetMapping("/posts")
    fun findPosts():CmResDto<*>{
        return CmResDto(HttpStatus.OK, resultMsg = "find posts", postService.findPosts())
    }


}