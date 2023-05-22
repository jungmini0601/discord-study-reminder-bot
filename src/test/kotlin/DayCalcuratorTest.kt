import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month

class DayCalcuratorTest {

    val nextStudyDayCalcurator = NextStudyDayCalcurator()

    @Test
    fun `2023-05-22일에서 가장 가까운 화요일은 2023-05-23`() {
        val base = LocalDate.of(2023, Month.MAY, 22)
        val ret = nextStudyDayCalcurator.findNearestTuesday(base)

        Assertions.assertEquals("2023-05-23", ret)
    }

    @Test
    fun `2023-05-23일에서 가장 가까운 화요일은 2023-05-23`() {
        val base = LocalDate.of(2023, Month.MAY, 23)
        val ret = nextStudyDayCalcurator.findNearestTuesday(base)

        Assertions.assertEquals("2023-05-23", ret)
    }

    @Test
    fun `2023-05-24일에서 가장 가까운 화요일은 2023-05-30`() {
        val base = LocalDate.of(2023, Month.MAY, 24)
        val ret = nextStudyDayCalcurator.findNearestTuesday(base)

        Assertions.assertEquals("2023-05-30", ret)
    }

    @Test
    fun `2023-05-22일에서 가장 가까운 화요일은 2023-05-23 date-time`() {
        val base = LocalDateTime.of(2023, Month.MAY, 22, 0, 0)
        val ret = nextStudyDayCalcurator.generateNearestTuesdayLocalDateTime(base)

        Assertions.assertEquals(LocalDateTime.of(2023, Month.MAY, 23, 12, 0), ret)
    }

    @Test
    fun `2023-05-23일에서 가장 가까운 화요일은 2023-05-23 date-time`() {
        val base = LocalDateTime.of(2023, Month.MAY, 23, 0, 0)
        val ret = nextStudyDayCalcurator.generateNearestTuesdayLocalDateTime(base)

        Assertions.assertEquals(LocalDateTime.of(2023, Month.MAY, 23, 12, 0), ret)
    }

    @Test
    fun `2023-05-24일에서 가장 가까운 화요일은 2023-05-30 date-time`() {
        val base = LocalDateTime.of(2023, Month.MAY, 24, 0, 0)
        val ret = nextStudyDayCalcurator.generateNearestTuesdayLocalDateTime(base)

        Assertions.assertEquals(LocalDateTime.of(2023, Month.MAY, 30, 12, 0), ret)
    }
}