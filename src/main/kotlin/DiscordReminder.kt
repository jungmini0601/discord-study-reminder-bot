import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import kotlin.system.exitProcess

class DiscordReminder(
    val studyReminderMessageGenerator: StudyReminderMessageGenerator,
    val nextStudyDayCalcurator: NextStudyDayCalcurator,
) : ListenerAdapter() {

    override fun onReady(event: ReadyEvent) {
        println("봇 시작")
        scheduleWeeklyNotification(event.jda)
    }

    private fun scheduleWeeklyNotification(jda: JDA) {
        val scheduler = Timer()
        val today = LocalDateTime.now(ZoneId.of("Asia/Seoul"))
        val notificationTime = nextStudyDayCalcurator.generateNearestTuesdayLocalDateTime(today)

        scheduler.schedule(object : TimerTask() {
            override fun run() {
                val channel = jda.getTextChannelById(noticeChannel)
                if (channel == null) {
                    println("채널 접속 실패")
                    exitProcess(0)
                }

                channel.sendMessage(studyReminderMessageGenerator.generateReminderMessage()).queue()
            }
        }, Date.from(notificationTime.atZone(ZoneId.of("Asia/Seoul")).toInstant()), 7 * 24 * 60 * 60 * 1000)
    }
}