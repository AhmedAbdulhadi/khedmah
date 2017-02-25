package com.example.bassam.khedmaapp.user.brodcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bassam.khedmaapp.user.activitys.VerificationCodeActivity;

/**
 * Created by bassam on 2/2/17.
 */

public class SmsReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {


        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {


                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();

                   // Toast.makeText(context, senderNum, Toast.LENGTH_SHORT).show();


//                    Intent hhtpIntent = new Intent(context, VerificationCodeActivity.class);
//                    hhtpIntent.putExtra("otp", message);
//                   // contestartActivity(hhtpIntent);



                    //el.setText(senderNum);


                } // end for loop
            } // bundle is null

        } catch (Exception e) {

        }

    }
}
