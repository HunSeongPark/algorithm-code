package com.hunseong.al_prac

import java.util.*

var N = 0
var M = 0
var result = 0
var visited: Array<Array<Boolean>>? = null
fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    M = nextInt()
    visited = Array(N + 1) { Array(M + 1) { false } }
    dfs(1, 1)
    println(result)
}

fun dfs(n: Int, m: Int) {

    // 마지막 도달 시 result++ 후 return
    if (n == N && m == M + 1) {
        result++
        return
    }

    for (i in n..N) {
        // i loop의 첫 번째 loop일 경우 기존 j 위치에서 시작
            // 첫 번째 loop가 아닐 경우 새로운 행에 진입한 것이므로 1부터 시작
        val startJ = if (i == n) m else 1
        for (j in startJ..M) {
            if (checkNemo(i, j)) continue

            visited!![i][j] = true
            dfs(i, j + 1)
            visited!![i][j] = false
        }
    }
    result++
}

fun checkNemo(i: Int, j: Int): Boolean {
    // 현재 오른쪽 - 아래 방향으로 네모 이동 중이므로
    // 현재 위치에서 왼쪽 위 방향의 네모만 확인하면 됨
    return visited!![i][j - 1] && visited!![i - 1][j - 1] && visited!![i - 1][j]
}
