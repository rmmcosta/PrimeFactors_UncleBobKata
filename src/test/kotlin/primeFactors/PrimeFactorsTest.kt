package primeFactors

import org.junit.jupiter.api.Assertions.*
import org.rmmcosta.primeFactors.calculate
import kotlin.test.Test

class PrimeFactorsTest {
    private val testCases = mapOf(
        // Edge cases
        1 to emptyList(),  // 1 has no prime factors
        0 to emptyList(),  // 0 is undefined for prime factorization (depends on your function)
        -1 to emptyList(), // Negative numbers (depends on your function’s behavior)

        // Prime numbers (should return themselves)
        2 to listOf(2),
        3 to listOf(3),
        5 to listOf(5),
        7 to listOf(7),
        11 to listOf(11),
        13 to listOf(13),
        17 to listOf(17),
        19 to listOf(19),
        23 to listOf(23),

        // Composite numbers
        4 to listOf(2, 2),
        6 to listOf(2, 3),
        8 to listOf(2, 2, 2),
        9 to listOf(3, 3),
        10 to listOf(2, 5),
        12 to listOf(2, 2, 3),
        15 to listOf(3, 5),
        16 to listOf(2, 2, 2, 2),
        18 to listOf(2, 3, 3),
        20 to listOf(2, 2, 5),
        25 to listOf(5, 5),
        30 to listOf(2, 3, 5),
        50 to listOf(2, 5, 5),
        100 to listOf(2, 2, 5, 5),

        // Large primes (testing performance)
        101 to listOf(101),
        199 to listOf(199),
        997 to listOf(997),

        // Large composite numbers
        1024 to List(10) { 2 }, // 2^10
        999 to listOf(3, 3, 3, 37),
        1000 to listOf(2, 2, 2, 5, 5, 5)
    )


    @Test
    fun `test prime factors calculation`() {
        testCases.forEach { (number, expected) ->
            println("Testing, number: $number, expected: $expected")
            val result = calculate(number)
            println("result: $result")
            assertEquals(expected, result, "Failed for number: $number, expected: $expected, result: $result")
        }
    }
}