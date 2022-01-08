import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    var isFinished = false

    fun checkValid(num: String): Boolean {

        // index에 따른 반복횟수 설정
        for (i in 1 .. num.length / 2) {
            val left = num.substring(num.length-i*2, num.length-i)
            val right = num.substring(num.length-i, num.length)
            if (left == right) return false
        }
        return true
    }

    fun dfs(k: Int, num: String) {
        if (k >= N) {
            bw.write(num)
            isFinished = true
            return
        }

        for (i in 1..3) {
            // 값이 invalid 하다면 continue
            if (!checkValid(num + i)) continue
            dfs(k + 1, num + i)
            if (isFinished) return
        }
    }

    dfs(1, "1")
    bw.flush()
    bw.close()
    br.close()
}
