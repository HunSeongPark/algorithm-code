package com.hunseong.al_prac

import java.util.*

var N = 0
var M = 0
var nums: Array<Int>? = null
var sb = StringBuilder()
var selected: Array<Int>? = null
fun main() = with(Scanner(System.`in`)) {

    N = nextInt()
    M = nextInt()
    nums = Array(N) { 0 }
    selected = Array(M + 1) { 0 }
    for (i in 0 until N) {
        nums!![i] = nextInt()
    }

    // 사전 순서로 출력하기 위해 nums 오름차순 정렬
    nums!!.sort()

    recur(1)
    print(sb.toString())

}

fun recur(k: Int) {
    if (k > M) {
        for (i in 1..M) sb.append(selected!![i]).append(' ')
        sb.append("\n")
        return
    }

    // nums 순회
    for (i in 0 until N) {
        // 오름차순, 중복 예외처리
        if (selected!![k-1] >= nums!![i]) continue

        // 각 값 selected에 setting
        selected!![k] = nums!![i]
        recur(k + 1)
    }
}