package com.hunseong.al_prac

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val array = MutableList(9) { 0 }

    for (i in 0 until 9) {
        array[i] = nextInt()
    }
    val sum = array.sum()

    for (i in 0 until 9) {
        for (j in i+1 until 9) {
            if (sum - array[i] - array[j] == 100) {
                array.apply {
                    removeAt(i)
                    removeAt(j-1)
                    sort()
                    forEach {
                        println(it)
                    }
                }
                return
            }
        }
    }
}