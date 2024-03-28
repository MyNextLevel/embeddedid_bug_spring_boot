package com.abbosidev.embeddedid_bug_demo_spring

import jakarta.persistence.*

@Entity
@Table(name = "companies")
class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    lateinit var name: String

}