package com.hunseong.al_prac

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var money = nextInt()

//    if (money == 1 || money == 3) {
//        println(-1)
//        return@with
//    }
//
//    while (money % 5 != 0) {
//        money -= 2
//        coinCount++
//    }
//    println(coinCount + money / 5)


    // 반복문 제거
    val arr = arrayOf(0, -1, 1, -1, 2, 1)

    if (money < 6) {
        println(arr[money])
        return@with
    }

    var fiveCoin = money / 5

    if (money % 5 % 2 != 0) {
        fiveCoin --
    }
    money -= fiveCoin * 5
    println(fiveCoin + money / 2)
}