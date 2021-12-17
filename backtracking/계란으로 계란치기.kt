package com.hunseong.al_prac

import java.util.*
import kotlin.math.max


var N = 0
var max = Int.MIN_VALUE
var eggs: Array<Egg>? = null
fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    eggs = Array(N) { Egg(0, 0) }

    for (i in 0 until N) {
        eggs!![i] = Egg(nextInt(), nextInt())
    }

    dfs(0, 0)
    println(max)
}

fun dfs(k: Int, brokenCount: Int) {
    if (k >= N) {
        max = max(max, brokenCount)
        return
    }

    // 만약 손에 든 계란이 깨져있다면, 다음 계란으로 이동
    if (eggs!![k].hp <= 0) {
        dfs(k + 1, brokenCount)
        // 손에 든 계란이 깨져있으므로, 더 이상 깨진 계란을 들고 다른 계란을 탐색할 필요가 없음. break
    } else {
        var isAttack = false
        // 모든 계란 친구들 순회
        for (i in 0 until N) {

            if (k == i || eggs!![i].hp <= 0) {
                // 손에 든 계란과 치려는 계란이 같거나, 치려는 계란이 이미 깨져있으면 continue
                continue
            }

            // 손에 든 계란과 치려는 계란이 서로 다르고, 둘 다 깨져있지 않을 때 부딪힌다
            eggs!![k].hp -= eggs!![i].weight
            eggs!![i].hp -= eggs!![k].weight

            // 깨진 계란 count하여 재귀함수 호출
            isAttack = true
            var newBrokenCount = 0
            if (eggs!![k].hp <= 0) newBrokenCount++
            if (eggs!![i].hp <= 0) newBrokenCount++
            dfs(k + 1, brokenCount + newBrokenCount)
            // 경우의 수를 마쳤을 때, 기존에 변경한 값 복구 **
            eggs!![k].hp += eggs!![i].weight
            eggs!![i].hp += eggs!![k].weight

        }

        // 모든 계란이 깨져있어 부딪히지 않았다면, k=N 호출하여 해당 경우의 수 return
        if (!isAttack) dfs(N, brokenCount)
    }

}

// 계란!
data class Egg(
    var hp: Int,
    var weight: Int,
)