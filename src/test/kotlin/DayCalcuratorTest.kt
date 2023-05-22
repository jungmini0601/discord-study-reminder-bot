import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate
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
}