import kotlin.math.roundToInt

fun main() {
    val standardSale = 100
    val withFivePercentSale = 0.95
    val withExtraSale = 0.99
    val isMeloman: Boolean
    var withSaleSum: Double

    println("Введите сумму предыдущих покупок (если их не было, введите 0)")
    var totalSum = readLine()!!.toInt()

    while (true) {
        println("Вы покупаете у нас музыку каждый месяц?")
        val response = readLine()!!
        if (response == "да") {
            isMeloman = true
            break
        } else if (response == "нет") {
            isMeloman = false
            break
        } else {
            println("Введите 'да' или 'нет'")
        }
    }

    println("Введите сумму покупки")
    val purchaseSum: Int = readLine()!!.toInt()
    println("Покупка $purchaseSum")

    if (totalSum <= 1000) {
        if (isMeloman) {
            withSaleSum = purchaseSum * withExtraSale
            round(withSaleSum)
            printMelomanSale(withSaleSum)
        } else {
            println("К оплате $purchaseSum")
        }
    } else if (totalSum in 1001..10_000) {
        withSaleSum = (purchaseSum - standardSale).toDouble()
        println("К оплате $withSaleSum после применения скидки 100 рублей")
        if (isMeloman) {
            withSaleSum *= withExtraSale
            round(withSaleSum)
            printMelomanSale(withSaleSum)
        }
    } else if (totalSum > 10_000) {
        withSaleSum = purchaseSum * withFivePercentSale
        round(withSaleSum)
        println("К оплате $withSaleSum после применения скидки 5%")
        if (isMeloman) {
            withSaleSum *= withExtraSale
            round(withSaleSum)
            printMelomanSale(withSaleSum)
        }
    }

    totalSum += purchaseSum
}

fun round(withSaleSum: Double) = (withSaleSum * 100).roundToInt().toDouble() / 100

fun printMelomanSale(withSaleSum: Double) = println("К оплате $withSaleSum после применения скидки меломана 1%")