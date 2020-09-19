class FloydWarshall {
    val number: Int = 4
    val INF: Int = 1000000000
    val a = arrayOf(
            arrayOf(0, 5, INF, 8),
            arrayOf(7, 0, 9, INF),
            arrayOf(2, INF, 0, 4),
            arrayOf(INF, INF, 3, 0)
    )

    fun floydWarshall() {
        val d = Array(number) { IntArray(number) }
        for (i in 0 until number) {
            for (j in 0 until number) {
                d[i][j] = a[i][j]
            }
        }

        // k = 거쳐 가는 노드
        for (k in 0 until number) {
            // i = 출발 노드
            for (i in 0 until number) {
                // j = 도착 노드
                for (j in 0 until number) {
                    if (d[i][k] + d[k][j] < d[i][j])
                        d[i][j] = d[i][k] + d[k][j]
                }
            }
        }

        for (arr in d) {
            for (i in arr) {
                print("$i ")
            }
            println()
        }

    }


}

fun main(args: Array<String>) {
    val floydWarshall = FloydWarshall()
    floydWarshall.floydWarshall()
}