package com.chilatesoftware.codechallenges_android.model

object SampleData {
    val challenges = listOf(
        CodeChallenge(
            id = "1",
            title = "Two Sum",
            difficulty = Difficulty.EASY,
            question = "Dado un arreglo de enteros y un target, retorna los índices de los dos números que suman el target.",
            starterCode = "fun twoSum(nums: IntArray, target: Int): IntArray {\n    \n}",
            solution = "fun twoSum(nums: IntArray, target: Int): IntArray {\n    val map = mutableMapOf<Int, Int>()\n    for ((i, num) in nums.withIndex()) {\n        val complement = target - num\n        if (map.containsKey(complement)) return intArrayOf(map[complement]!!, i)\n        map[num] = i\n    }\n    return intArrayOf()\n}",
            userAttempt = ""
        ),
        CodeChallenge(
            id = "2",
            title = "Reverse String",
            difficulty = Difficulty.EASY,
            question = "Escribe una función que invierta un string dado.",
            starterCode = "fun reverseString(s: String): String {\n    \n}",
            solution = "fun reverseString(s: String): String {\n    return s.reversed()\n}",
            userAttempt = ""
        ),
        CodeChallenge(
            id = "3",
            title = "Valid Parentheses",
            difficulty = Difficulty.MEDIUM,
            question = "Dado un string con paréntesis '()', '[]' y '{}', determina si es válido. Un string es válido si cada apertura tiene su cierre correspondiente en el orden correcto.",
            starterCode = "fun isValid(s: String): Boolean {\n    \n}",
            solution = "fun isValid(s: String): Boolean {\n    val stack = ArrayDeque<Char>()\n    for (c in s) {\n        when (c) {\n            '(', '[', '{' -> stack.addLast(c)\n            ')' -> if (stack.isEmpty() || stack.removeLast() != '(') return false\n            ']' -> if (stack.isEmpty() || stack.removeLast() != '[') return false\n            '}' -> if (stack.isEmpty() || stack.removeLast() != '{') return false\n        }\n    }\n    return stack.isEmpty()\n}",
            userAttempt = ""
        )
    )
}