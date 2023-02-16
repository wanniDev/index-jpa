package com.example.jpaindex

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ItemNoIdxRepository: JpaRepository<ItemNoIndex, Long> {
    @Query("select new com.example.jpaindex.CategoryReport(" +
            "ii.category, count(ii.name)) from ItemNoIndex ii " +
            "group by ii.category")
    fun findCategoryGroup(): List<CategoryReport>
}