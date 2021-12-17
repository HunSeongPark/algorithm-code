package com.hunseong.al_prac

import java.util.*

var N = 0
var S = 0
var result = 0
var nums: Array<Int>? = null
fun main() = with(Scanner(System.`in`)){
    N = nextInt()
    S = nextInt()
    nums = Array(N) { 0 }
    for (i in 0 until N) {
        nums!![i] = nextInt()
    }
    // 진 부분수열이므로 S=0일 시 공집합의 결과는 미리 제외
    if (S == 0) result --

    dfs(0, 0)
    println(result)
}

fun dfs(index: Int, value: Int) {
    if (index >= N) {
        if (S == value) result++
        return
    }

    // 각 nums[index]를 포함 / 포함하지 않은 상태로 재귀함수 호출
    dfs(index + 1, value)
    dfs(index + 1, value + nums!![index])
}

