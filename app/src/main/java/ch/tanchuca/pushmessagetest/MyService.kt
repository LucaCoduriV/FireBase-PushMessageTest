package ch.tanchuca.pushmessagetest


import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.media.session.MediaSession.Token
import android.util.Log
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlin.math.log


class MyService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.i("MYTAG", token)
    }


    override fun onMessageReceived(message: RemoteMessage) {
        val title: String = message.notification?.title.toString()
        val text: String = message.notification?.body.toString()

        Log.i("MYTAG", title)
        Log.i("MYTAG", text)

        val CHANNEL_ID = "HEADS_UP_NOTIFICATION"

        val channel = NotificationChannel(
            CHANNEL_ID,
            "Heads Up Notification",
            NotificationManager.IMPORTANCE_HIGH
        )

        val notification: Notification.Builder = Notification.Builder(this, CHANNEL_ID)
            .setContentTitle("c'est mon truc à moi")
            .setContentText(text)
            .setSmallIcon(R.drawable.ic_launcher_background)

        NotificationManagerCompat.from(this).notify(1, notification.build())

        super.onMessageReceived(message)
    }
}