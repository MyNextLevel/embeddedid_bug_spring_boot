package com.abbosidev.embeddedid_bug_demo_spring

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    lateinit var firstname: String
    lateinit var lastname: String

}