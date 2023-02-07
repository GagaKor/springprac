package com.ex.springprac.service

import com.ex.springprac.domain.member.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
        private val memberRepository: MemberRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<MemberRes> =
        memberRepository.findAll().map{
            it.toDto()
        }



}