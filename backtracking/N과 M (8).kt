package com.hunseong.al_prac

import java.lang.StringBuilder
import java.util.*

var N = 0
var M = 0
var nums: Array<Int>? = null
var selected: Array<Int>? = null
var sb = StringBuilder()
fun main() = with(Scanner(System.`in`)){
    N = nextInt()
    M = nextInt()
    nums = Array(N + 1) { 0 }
    selected = Array(M + 1) { 0 }
    for (i in 1..N) {
        nums!![i] = nextInt()
    }

    nums!!.sort()

    dfs(1)
    println(sb.toString())

}

fun dfs(k: Int) {
    if (k > M) {
        for (i in 1..M) { sb.append(selected!![i]).append(' ') }
        sb.append("\n")
        return
    }

    for (i in 1..N) {
        if(selected!![k-1] > nums!![i]) continue
        selected!![k] = nums!![i]
        dfs(k + 1)
    }
}