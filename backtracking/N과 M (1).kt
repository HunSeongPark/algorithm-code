package com.hunseong.al_prac

import java.util.*

var N = 0
var M = 0
val sb = StringBuilder()
var selected: Array<Int>? = null
var used: Array<Int>? = null

fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    M = nextInt()
    selected = Array(M + 1) { 0 }
    used = Array(N + 1) { 0 }
    recur(1)
    println(sb.toString())
}

fun recur(k: Int) {
    // M번째까지 값이 저장되었을 경우 재귀 탈출
    if (k > M) {
        for (i in 1..M) sb.append(selected!![i]).append(' ')
        sb.append("\n")
    } else {
        for (i in 1..N) {
            // 만약 해당 숫자가 이미 사용되었다면 continue
            if (used!![i] == 1) continue
            selected!![k] = i
            // 해당 숫자가 사용됨
            used!![i] = 1
            recur(k + 1)
            // 출력 완료 후 used 값 초기화
            used!![i] = 0
        }
    }
}