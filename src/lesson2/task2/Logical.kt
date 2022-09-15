@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.max
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая (2 балла)
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val sum_end = (number % 10) + (number % 100 / 10)
    val sum_begin = (number / 1000) + (number / 100 % 10)
    if (sum_end == sum_begin) {
        return true
    }
    return false
}

/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    return when {
        (x1 == x2 || y1 == y2) -> true
        (sqr(x2 - x1) == sqr(y2 - y1)) -> true
        else -> false
    }
}



/**
 * Простая (2 балла)
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    if (month in listOf(1, 3, 5, 7, 8, 10, 12)) {
        return 31
    }
    if (year % 4 == 0 && month == 2) {
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                return 29
            }
            else return 28
        }
        else return 29
    }
    else if (month == 2) return 28
    return 30
}

/**
 * Простая (2 балла)
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    val O1O2 = sqr(x2 - x1) + sqr(y2 - y1)
    if (O1O2 < sqr(r2)) {
        if (r1 <= r2 - sqrt(O1O2)) {
            return true
        }
        else return false
    }
    else return false
}


/**
 * Средняя (3 балла)
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    return when {
        (a <= r && b <= s || a <= s && b <= r) -> true
        (a <= r && c <= s || a <= s && c <= r) -> true
        (b <= r && c <= s || b <= s && c <= r) -> true
        else -> false
    }
}