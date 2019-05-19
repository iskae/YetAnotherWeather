package de.iskae.data.factory

import java.util.*
import kotlin.random.Random

object DataFactory {

    fun randomString(): String {
        return UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return Random.nextInt()
    }

    fun randomLong(): Long {
        return Random.nextLong()
    }

    fun randomBoolean(): Boolean {
        return Random.nextBoolean()
    }
}