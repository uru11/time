package time.com.time;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView mTextView;
    EditText mEditText;
    int Day;
    int minute;
    int HourOfDay;
    int Minute;
    String Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);


        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            TextView button1 = (TextView) findViewById(R.id.textView);
            button1.setText(Text);
        } else if (v.getId() == R.id.button3) {
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog() {

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        HourOfDay = hourOfDay;
                        Text="";
                        if((hourOfDay >= 2) && (hourOfDay < 10)){
                            Text = "おはよう";
                        } else if((hourOfDay >= 10) && (hourOfDay < 18)){
                            Text = "こんにちは";
                        }else{
                            Text = "こんばんは";
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}