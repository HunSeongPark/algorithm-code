package com.hunseong.al_prac

import java.util.*
import kotlin.math.abs

var N = 0
var count = 0
var cols = emptyArray<Int>()
fun main() {
    val scanner = Scanner(System.`in`)
    N = scanner.nextInt()

    cols = Array(N+1) { 0 }
    queens(1)
    println(count)
}

fun queens(level: Int) {
    if (level == N+1) count++
    else {
        for (i in 1..N) {
            cols[level] = i
            if (promising(level)) queens(level+1)
        }
    }
}

fun promising(level: Int) : Boolean {
    for (i in 1 until level) {
        if (cols[i] == cols[level] || level - i == abs(cols[level] - cols[i])) return false
    }
    return true
}