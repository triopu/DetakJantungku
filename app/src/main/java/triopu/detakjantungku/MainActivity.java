package triopu.detakjantungku;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothSocket;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by trio_pu on 3/19/18.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    TextView heartRate;
    ToggleButton measureHR;
    Boolean HR = false;
    Boolean successConnect = true;
    Integer numberHR = 6;

    public void onBackPressed(){
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Keluar")
                .setMessage("Yakin akan keluar?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener(){
                    @Override
                    public  void onClick(DialogInterface dialog, int which){
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        System.exit(0);
                    }
                }).setNegativeButton("Tidak", null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        heartRate = (TextView) findViewById(R.id.heartRate);
        heartRate.setMovementMethod(new ScrollingMovementMethod());

        measureHR = (ToggleButton)findViewById(R.id.measureHR);
        measureHR.setOnClickListener(this);

        Bluetooth.gethandler(mHandler);
    }

    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case Bluetooth.SUCCESS_CONNECT:
                    Bluetooth.connectedThread = new Bluetooth.ConnectedThread((BluetoothSocket)msg.obj);
                    Toast.makeText(getApplicationContext(),"Tersambung!",Toast.LENGTH_SHORT).show();
                    String s = "Sukses Tersambung";
                    successConnect = true;
                    Bluetooth.connectedThread.start();
                    break;
                case Bluetooth.MESSAGE_READ:
                    byte[] readBuf = (byte[])msg.obj;
                    int i = 0;
                    for (i = 0; i < readBuf.length && readBuf[i] != 0; i++) {
                    }
                    final String Income = new String(readBuf,0,i);
                    String[] items = Income.split("\\*");
                    for(String item : items){
                        if(item.length() == 3 || item.length() == 4){
                            //Blank
                        }
                        else if(item.length() == 5){
                            Integer HRVal = Integer.parseInt(item);
                            if(HR){
                                heartRate.setText(String.valueOf(HRVal));
                                numberHR = numberHR + 1;
                            }
                            if (HRVal > 100 || HRVal < 60) {
                                heartRate.setTextColor(Color.RED);
                            } else heartRate.setTextColor(Color.BLACK);
                        }
                    }
                    break;
            }
        }
    };


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.measureHR:
                if (measureHR.isChecked()) {
                    startActivity(new Intent("android.intent.action.BT"));
                    if(!successConnect){
                        measureHR.setChecked(false);
                    }else{
                        HR = true;
                        numberHR = 0;
                        Toast.makeText(this, "Menghitung detak jantung", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if(numberHR<5){
                        measureHR.setChecked(true);
                    }else{
                        String valHR    = heartRate.getText().toString();
                        Integer HRVal = Integer.parseInt(valHR);
                        if(HRVal > 100){
                            startActivity(new Intent("android.intent.action.AN"));
                        }else if(HRVal < 60){
                            startActivity(new Intent("android.intent.action.UN"));
                        }else if(HRVal >= 60 || HRVal <= 100){
                            startActivity(new Intent("android.intent.action.N"));
                        }

                    }
                    HR = false;
                    Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
