package com.hunseong.al_prac

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()

    val arr = Array(n) { "" }
    for (i in 0 until n) {
        arr[i] = next()
    }

    val len = arr[0].length

    var result = ""

    for (i in 0 until len) {
        var isReplace = false
        for(j in 0 until n-1) {
            if (arr[j][i] != arr[j+1][i]) {
                isReplace = true
                break
            }
        }
        if (isReplace) result += "?" else result += arr[0][i]
    }

    println(result)

}