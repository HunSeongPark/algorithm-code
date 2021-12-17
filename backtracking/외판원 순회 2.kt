package com.hunseong.al_prac

import java.lang.Integer.min
import java.util.*

var N = 0
var min = Int.MAX_VALUE
var visited: Array<Int>? = null
var W: Array<Array<Int>>? = null
fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    W = Array(N) { Array(N) { 0 } }
    visited = Array(N + 1) { -1 }
    for (i in 0 until N) {
        for (j in 0 until N) {
            W!![i][j] = nextInt()
        }
    }

    dfs(1, 0)
    println(min)
}

fun dfs(k: Int, value: Int) {

    // 초기 vertex로 돌아오기 전까지 모두 순회한 경우
    if (k > N) {
        // 마지막 vertex에서 초기 vertex의 경로가 없을 경우 return
        if (W!![visited!!.last()][visited!![1]] == 0) return

        // 마지막 vertex에서 초기 vertex의 weight 까지 더함
        val result = value + W!![visited!!.last()][visited!![1]]
        min = min(min, result)
        return
    }

    for (i in 0 until N) {
        // 초기 vertex 이후 vertex에 대해 조건 확인
        if (k > 1) {
            // 이미 순회한 vertex인 경우, 초기 vertex인 경우, 이전 vertex에서 해당 vertex의 경로가 없을 경우 continue
            if (visited!!.contains(i) || i == visited!![1] || W!![visited!![k - 1]][i] == 0) continue
        }

        // visited에 추가
        visited!![k] = i

        // 초기값이 아닌 경우 이전 vertex와의 weight을 추가한 후 재귀 호출
        if (k > 1) {
            dfs(k + 1, value + W!![visited!![k-1]][i])
        }
        else dfs(k + 1, value)

        // visited Reset
        visited!![k] = -1
    }
}