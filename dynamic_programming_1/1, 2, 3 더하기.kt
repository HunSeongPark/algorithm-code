package com.hunseong.al_prac

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val result = arrayListOf<Int>()
    for (i in 0 until n) {
        result.add(cases(nextInt()))
    }
    result.forEach {
        println(it)
    }
}

fun cases(n: Int): Int {
    return when {
        n <= 2 -> {
            n
        }
        n == 3 -> {
            4
        }
        else -> {
            cases(n-1) + cases(n-2) + cases(n-3)
        }
    }
}