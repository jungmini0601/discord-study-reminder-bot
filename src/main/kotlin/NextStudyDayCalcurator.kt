import java.time.DayOfWeek
import java.time.LocalDate

class NextStudyDayCalcurator {

    /**
     *  월(0) 화(1) 수(2) 목(3) 금(4) 토(5) 일(6)
     *
     *  화요일 보다 숫자가 큰 경우 (1 - 6 + 7) % 7 -> 2
     *  화요일 보다 숫자가 작은 경우 (1 - 0 + 7) % 7 -> 1
     *  화요일인 경우 -> (1 - 1 + 7) % 7 -> 0
     */
    fun findNearestTuesday(base: LocalDate):String {
        val currentDayOfWeek = base.dayOfWeek.value
        val daysUntilNextTuesday = (DayOfWeek.TUESDAY.value - currentDayOfWeek + 7) % 7
        val nearestTuesday = base.plusDays(daysUntilNextTuesday.toLong())
        return makeDateString(nearestTuesday)
    }

    private fun makeDateString(localDate: LocalDate): String {
        val year = localDate.year
        val month = localDate.monthValue
        val day = localDate.dayOfMonth
        return String.format("%04d-%02d-%02d", year, month, day)
    }
}