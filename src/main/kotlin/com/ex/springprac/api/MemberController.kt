package com.ex.springprac.api

import com.ex.springprac.domain.member.Member
import com.ex.springprac.service.MemberService
import com.ex.springprac.util.CmResDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
        private val memberService: MemberService
) {
    @GetMapping("/members")
    fun findAll():CmResDto<*>{
      return CmResDto(HttpStatus.OK, resultMsg = "find All Members", memberService.findAll())
    }
}