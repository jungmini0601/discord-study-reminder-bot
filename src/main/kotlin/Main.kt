import net.dv8tion.jda.api.JDABuilder

fun main(args: Array<String>) {
    val nextStudyDayCalcurator = NextStudyDayCalcurator()
    val studyReminderMessageGenerator = StudyReminderMessageGenerator(nextStudyDayCalcurator)
    val jda = JDABuilder.createDefault(token).build()
    jda.addEventListener(DiscordReminder(studyReminderMessageGenerator))
}