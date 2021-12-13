package com.hunseong.al_prac

import java.util.*


fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    println(fi(n))
}

fun fi(n: Int): Int {
    if (n == 0 || n == 1) {
        return n
    }

    return fi(n-1) + fi(n-2)
}