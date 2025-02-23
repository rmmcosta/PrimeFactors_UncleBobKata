package org.rmmcosta.primeFactors

fun calculateV2(number: Int): List<Int> = calculateIterate(number, 2, emptyList())

private tailrec fun calculateIterate(number: Int, candidate: Int, acc: List<Int>): List<Int> = when {
    number <= 1 -> acc
    number % candidate == 0 -> calculateIterate(number / candidate, candidate, acc + listOf(candidate))
    else -> calculateIterate(number, candidate + 1, acc)
}
