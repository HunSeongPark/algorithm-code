import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, K) = br.readLine().split(" ").map { it.toInt() }

    // 경우의 수가 불가능한 K < 5 일 때 바로 return
    // 모든 경우의 수가 가능한 K == 26일 때 바로 return
    if (K < 5) {
        bw.write("0")
        bw.flush()
        br.close()
        bw.close()
        return
    } else if (K == 26) {
        bw.write(N.toString())
        bw.flush()
        br.close()
        bw.close()
        return
    }

    val words = Array(N) { "" }

    // "anta", "tica"에 필수적으로 들어가야 하는 a,i,c,t,n true로 설정
    val visited = Array(26) { false }
    visited['a' - 'a'] = true
    visited['i' - 'a'] = true
    visited['c' - 'a'] = true
    visited['t' - 'a'] = true
    visited['n' - 'a'] = true

    var max = Int.MIN_VALUE

    // word 순회 cost 줄이기 위해 anta, tica 제거
    for (i in 0 until N) {
        val str = br.readLine()
        str.replace("anta", "")
        str.replace("tica", "")
        words[i] = str
    }

    fun dfs(k: Int, start: Int) {
        if (k >= K) {
            var result = 0
            for (i in 0 until N) {
                var isReadable = true
                val word = words[i]

                // 각 word 별 문자 순회하며 문자 하나라도 visited에 포함되어 있지 않다면 false
                for (j in word.indices) {
                    if (!visited[word[j] - 'a']) {
                        isReadable = false
                        break
                    }
                }
                if (isReadable) result++
            }
            max = max(max, result)
            return
        }

        for (i in start until 26) {
            // 기본적으로 들어가있는 5개 문자가 아닌 경우만 대입
            if (!visited[i]) {
                visited[i] = true
                // 문자 오름차순으로 대입하여 불필요하게 중복되는 경우의 수가 없도록 (ex. abc와 bca)
                dfs(k + 1, i + 1)
                visited[i] = false
            }
        }
    }

    dfs(5, 0)
    bw.write(max.toString())
    bw.flush()
    br.close()
    bw.close()
}
