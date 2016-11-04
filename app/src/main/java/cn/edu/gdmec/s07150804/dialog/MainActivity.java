package cn.edu.gdmec.s07150804.dialog;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
private TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.uidate);
        t2=(TextView)findViewById(R.id.uitime);
        t3=(TextView)findViewById(R.id.charactor);
    }
    public void characterpickerdialog(View v){
        final String options="34297100#65*";
        CharacterPickerDialog cpd=new CharacterPickerDialog(this,new View(this),null,options,false){
            @Override
            public void onClick(View v) {
              t3.append(((Button)v).getText().toString());
                if(((Button)v).getText().toString().equals("")){
                    dismiss();
                }
            }
        };
        cpd.show();
    }
    @TargetApi(Build.VERSION_CODES.N)
    public  void datepickerdialog(View v){
        DatePickerDialog dpd=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                t1.setText("日期："+year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
            }
        },2016,10,28);
        dpd.show();
    }
    public void timepickerdialog(View v){
        TimePickerDialog tpd=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                t2.setText(hourOfDay+":"+minute);
            }
        },9,15,true);
        tpd.show();
    }
    public void progressdialog(View v){
       final ProgressDialog pg=ProgressDialog.show(this,"加载","加载中，请稍后。。。 ",true);
    new Thread(){
        public void run(){
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                pg.dismiss();
            }

        }
    }.start();
    }
}
