import java.util.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val dice = Dice()
        var lado = dice.sides()

        var guess: Int
        do {
            System.out.printf("Qual lado o dado ira rolar? ")
            guess = scanner.nextInt()

            if (dice.comparar(lado, guess) == 0) {
                println("Voce acertou o lado correto: $lado")
                return
            } else {
                println("Erroooouu! Rolando novamente")
                lado = dice.sides()
            }
        } while (dice.comparar(lado, guess) == 1)
    }
}

class Dice {
    fun sides(): Int {
        val random = Random()

        val side = random.nextInt(6)

        return side + 1
    }

    fun comparar(side: Int, guess: Int): Int {
        return if (guess == side) 0
        else 1
    }
}