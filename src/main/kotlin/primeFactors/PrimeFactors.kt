package org.rmmcosta.primeFactors

fun calculate(number: Int): List<Int> = when {
    number <= 1 -> emptyList()
    isPrime(number) -> listOf(number)
    else -> {
        val primeFactor = nextPrimeFactor(number)
        listOf(primeFactor) + calculate(number / primeFactor)
    }
}

private fun nextPrimeFactor(number: Int): Int {
    return if (isPrime(number)) number else {
        var primeCandidate = nextPrime()
        while (number % primeCandidate != 0) {
            primeCandidate = nextPrime(primeCandidate + 1)
        }
        primeCandidate
    }
}

private fun nextPrime(primeCandidate: Int = 2): Int =
    if (isPrime(primeCandidate)) primeCandidate else nextPrime(primeCandidate + 1)

private fun isPrime(primeCandidate: Int): Boolean {
    var isPrime = true
    for (i in 2 until primeCandidate) {
        if (primeCandidate % i == 0) {
            isPrime = false
            break
        }
    }
    return isPrime
}
