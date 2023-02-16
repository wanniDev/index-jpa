package com.example.jpaindex

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
class ItemNoIndex(
    val name: String,
    val description: String,
    val category: String,
    val price: Int,
    val stock: Int,
    val createTime: LocalDate
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long ?= null
}