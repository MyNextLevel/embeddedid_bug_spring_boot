package com.abbosidev.embeddedid_bug_demo_spring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CompanyUserTest {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var companyRepository: CompanyRepository

    @Autowired
    private lateinit var companyUserRepository: CompanyUserRepository

    @Test
    fun testFetchingCompanyUser() {
        var tempUser = User().apply {
            firstname = "Abbas"
            lastname = "Donaboyev"
        }
        tempUser = userRepository.save(tempUser)
        var tempCompany = Company().apply {
            name = "Githubit"
        }
        tempCompany = companyRepository.save(tempCompany)

        var tempCompanyUser = CompanyUser(tempCompany, tempUser)
        tempCompanyUser = companyUserRepository.save(tempCompanyUser)

        val cu = companyUserRepository.getCompanyUserByCompanyIdAndUserId(tempCompany.id, tempUser.id)
        assertEquals(tempUser.id, cu.id.user.id)
        assertEquals(tempCompany.id, cu.id.company.id)
        assertEquals(tempCompanyUser.id, cu.id)
    }
}