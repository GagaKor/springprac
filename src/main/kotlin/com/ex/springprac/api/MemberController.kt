package com.ex.springprac.api

import com.ex.springprac.domain.member.Member
import com.ex.springprac.service.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
        private val memberService: MemberService
) {
    @GetMapping("/members")
    fun findAll():MutableList<Member> = memberService.findAll()
}