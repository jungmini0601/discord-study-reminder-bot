import java.time.LocalDate

class StudyReminderMessageGenerator(
    val nextStudyDayCalcurator: NextStudyDayCalcurator) {

    fun generateReminderMessage(): String {
        val nextStudyDayString = nextStudyDayCalcurator.findNearestTuesday(LocalDate.now())
        return """
            @everyone
            🔊 이번주 스터디 일정 알림입니다. 
            
            스터디 시간: ${nextStudyDayString} 22시
            장소: <#${studyChannel}>
        """.trimIndent()
    }
}