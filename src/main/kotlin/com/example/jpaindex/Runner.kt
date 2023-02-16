package com.example.jpaindex

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class Runner(private val itemIdxRepository: ItemIdxRepository,
             private val itemNoIdxRepository: ItemNoIdxRepository
) : ApplicationRunner {
    @Throws(Exception::class)
    override fun run(args: ApplicationArguments) {
        for (i in 0..1000) {
            itemIdxRepository.save(ItemIndex(
                name = "item$i",
                description = "description $i",
                category = "category ${i % 5}",
                price = 1000,
                stock = 9,
                LocalDate.now()
            ))
        }

        for (i in 0..1000) {
            itemNoIdxRepository.save(ItemNoIndex(
                name = "item$i",
                description = "description $i",
                category = "category ${i % 5}",
                price = 1000,
                stock = 9,
                LocalDate.now()
            ))
        }
        println("-------------------------")
        val start2 = System.currentTimeMillis()
        val findCategoryGroupNoIdx = itemNoIdxRepository.findCategoryGroup()
        val end2 = System.currentTimeMillis()
        println("findCategoryGroupNoIdx ${end2 - start2}")

        val start1 = System.currentTimeMillis()
        val findCategoryGroupIdx = itemIdxRepository.findCategoryGroup()
        val end1 = System.currentTimeMillis()
        println("findCategoryGroupIdx ${end1 - start1}")
    }
}