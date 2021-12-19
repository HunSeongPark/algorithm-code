package com.hunseong.al_prac

import java.util.*

var t = ""
var t2 = ""
val sb = StringBuilder()
fun main() = with(Scanner(System.`in`)) {
    t = next()
    t2 = next()

    if (t == t2) {
        println("24:00:00")
        return@with
    }

    val time1 = t.split(":").map {
        it.toInt()
    }.toMutableList()

    val time2 = t2.split(":").toMutableList().map {
        it.toInt()
    }.toMutableList()

    val result = MutableList(3) { 0 }

    if (time1[0] > time2[0]) {
        time2[0] += 24
    }

    for (i in 2 downTo 0) {
        if (time2[i] < time1[i]) {
            time2[i] += 60
            time2[i - 1] -= 1
        }

        result[i] = time2[i] - time1[i]
    }

    for (i in 0..2) {
        if (i != 2) {
            sb.append(String.format("%02d:", result[i]))
        } else {
            sb.append(String.format("%02d", result[i]))
        }
    }
    println(sb.toString())

}