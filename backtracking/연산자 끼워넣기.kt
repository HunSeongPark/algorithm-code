package com.hunseong.al_prac

import java.util.*

var N = 0
var nums: Array<Int>? = null
var operators = Array(4) { 0 }
var max = Int.MIN_VALUE
var min = Int.MAX_VALUE
fun main() = with(Scanner(System.`in`)) {

    // Input
    N = nextInt()
    nums = Array(N) { 0 }
    for (i in 0 until N) {
        nums!![i] = nextInt()
    }
    for (i in 0 until 4) {
        operators[i] = nextInt()
    }

    recur(0, nums!![0])
    println(max)
    println(min)
}

fun recur(k: Int, value: Int) {

    // 마지막 num에 도달했을 때 max, min값 업데이트 후 return
    if (k >= N - 1) {
        if (max < value) max = value
        if (min > value) min = value
        return
    }

    // 각 연산자에 대한 순회
    for (i in 0 until 4) {
        // 연산자의 사용횟수가 0일 경우 continue
        if (operators[i] == 0) continue
        // 연산자 사용 --
        operators[i] --
        // 재귀함수를 통해 다음 position의 operator 설정
        recur(k + 1, calc(value, i, nums!![k+1]))
        // 결과 도출 후 연산자 사용 횟수 되돌림
        operators[i] ++
    }
}

fun calc(val1: Int, operator: Int, val2: Int): Int {
    return when (operator) {
        0 -> val1 + val2
        1 -> val1 - val2
        2 -> val1 * val2
        else -> val1 / val2
    }
}