package com.example.test978;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.CheckBox;

import java.util.Calendar;

public class SecondActivity extends Activity {

    Calendar cal = Calendar.getInstance(); // 캘린더 값 얻어오기
    int dayOfWeek= cal.get(Calendar.DAY_OF_WEEK); // DAY_OF_WEEK 일주일 값 얻어오기 (월=1, 화=2, ..., 토=7)

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        CheckBox checkBox = (CheckBox) findViewById(R.id.Check1) ;  // 체크박스 눌렀을때 실행하게 하는코드

        checkBox.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {     //이 안에서 체크박스를 눌렀을때 실행되게하는 코드 작성
                if(dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4 || dayOfWeek == 5 || dayOfWeek == 6 || dayOfWeek == 0) {

                    String channelId = "channel";         //푸시알림시작
                    String channelName = "Channel Name";

                    NotificationManager notifManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

                        int importance = NotificationManager.IMPORTANCE_HIGH;

                        NotificationChannel mChannel = new NotificationChannel(channelId, channelName, importance);

                        notifManager.createNotificationChannel(mChannel);

                    }

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channelId);

                    Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);

                    notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

                    int requestID = (int) System.currentTimeMillis();

                    PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext()
                            , requestID
                            , notificationIntent
                            , PendingIntent.FLAG_UPDATE_CURRENT);

                    builder.setContentTitle("월, 화, 수, 목, 금, 일 일반쓰레기 배출입니다.") // required
                            .setContentText("배출 시간은 18:00입니다.")  // required
                            .setDefaults(Notification.DEFAULT_ALL) // 알림, 사운드 진동 설정
                            .setAutoCancel(true) // 알림 터치시 반응 후 삭제
                            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                            .setSmallIcon(android.R.drawable.btn_star)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.image))
                            .setBadgeIconType(R.drawable.image)
                            .setContentIntent(pendingIntent);

                    notifManager.notify(0, builder.build());
//푸시알림 끝
                }
            }
        }) ;
    }
}
