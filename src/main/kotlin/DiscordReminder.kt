import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import kotlin.system.exitProcess

class DiscordReminder(
    val studyReminderMessageGenerator: StudyReminderMessageGenerator
) : ListenerAdapter() {

    override fun onReady(event: ReadyEvent) {
        val channel = event.jda.getTextChannelById(noticeChannel)

        if (channel == null) {
            println("채널 연결 실패")
            return
        }

        channel.sendMessage(studyReminderMessageGenerator.generateReminderMessage())
            .queue {
                println("메세지 전송 완료")
                println("프로세스 종료")
                exitProcess(0)
            }
    }
}