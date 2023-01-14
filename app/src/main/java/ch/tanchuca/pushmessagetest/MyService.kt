package ch.tanchuca.pushmessagetest


import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.media.session.MediaSession.Token
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.i("MYTAG", token)
    }


    override fun onMessageReceived(message: RemoteMessage) {

        if(message.data["test"] != null){
            Log.i("MYTAG", message.data["test"].toString())
            return super.onMessageReceived(message);
        }

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

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)


        val notification: Notification.Builder = Notification.Builder(this, CHANNEL_ID)
            .setContentTitle("c'est mon truc à moi")
            .setContentText(text)
            .setSmallIcon(R.drawable.ic_launcher_background)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(this).notify(1, notification.build())
        }


        super.onMessageReceived(message)
    }
}