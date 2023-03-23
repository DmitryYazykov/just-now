const val MIN: Int = 60
const val HOUR: Int = 60 * 60
const val DAY: Int = 24 * 60 * 60
const val WAS_ONLINE: String = "был(а) в сети "
fun main() {
    println(WAS_ONLINE + agoToText(50))
    println(WAS_ONLINE + agoToText(1 * MIN + 1))
    println(WAS_ONLINE + agoToText(2 * MIN))
    println(WAS_ONLINE + agoToText(5 * MIN))
    println(WAS_ONLINE + agoToText(1 * HOUR + 1 * MIN))
    println(WAS_ONLINE + agoToText(2 * HOUR))
    println(WAS_ONLINE + agoToText(5 * HOUR))
    println(WAS_ONLINE + agoToText(1 * DAY + 10 * HOUR))
    println(WAS_ONLINE + agoToText(2 * DAY + 15 * HOUR))
    println(WAS_ONLINE + agoToText(4 * DAY))
}

//считаем, сколько времени прошло с последнего визита
fun agoToText(sec: Int): String {
    val text = when {
        sec in (MIN + 1)..HOUR -> {
            val minutes: Int = (sec / (MIN))
            "$minutes минут${endingMinutes(minutes)} назад"
        }

        sec in (HOUR + 1)..DAY -> {
            val hours: Int = (sec / (HOUR))
            "$hours час${endingHours(hours)} назад"
        }

        sec <= 2 * DAY && sec > 1 * DAY -> "вчера"
        sec <= 3 * DAY && sec > 2 * DAY -> "позавчера"
        sec > 3 * DAY -> "давно"
        else -> "только что"
    }
    return text
}

//окончания у минут
fun endingMinutes(min: Int) = when (min % 10) {
    1 -> if (min == 11) "" else "у"
    2, 3, 4 -> "ы"
    else -> ""
}

//окончания у часов
fun endingHours(hours: Int) = when (hours % 10) {
    1 -> if (hours == 11) "ов" else ""
    2, 3, 4 -> "а"
    else -> "ов"
}