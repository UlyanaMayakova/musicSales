import kotlin.math.roundToInt

fun main() {
    val standardSale = 100
    val withFivePercentSale = 0.95
    val withExtraSale = 0.99

    println("Введите сумму предыдущих покупок (если их не было, введите 0)")
    var totalSum = readLine()!!.toDouble()

    println("Введите сумму покупки")
    var purchaseSum = readLine()!!.toDouble()
    println("Покупка $purchaseSum")

    if (totalSum <= 1000) {
            println("К оплате $purchaseSum")
    } else if (totalSum > 1001 && totalSum <= 10_000) {
        purchaseSum -= standardSale
        println("К оплате $purchaseSum после применения скидки 100 рублей")
    } else if (totalSum > 10_000) {
        purchaseSum *= withFivePercentSale
        purchaseSum = round(purchaseSum)
        println("К оплате $purchaseSum после применения скидки 5%")
    }

    while (true) {
        println("Вы покупаете у нас музыку каждый месяц?")
        val response = readLine()!!
        if (response == "да") {
            purchaseSum *= withExtraSale
            purchaseSum = round(purchaseSum)
            println("К оплате $purchaseSum после применения скидки меломана 1%")
            break
        } else if (response == "нет") {
            break
        } else {
            println("Введите 'да' или 'нет'")
        }
    }

    totalSum += purchaseSum
}

fun round(purchaseSum: Double) = (purchaseSum * 100).roundToInt().toDouble() / 100