package edu.ntut.user.myhw3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpnAge;
    private Spinner mSpnAge2;
    private RadioGroup mRadGrp;
    private RadioButton mRadBtnMale;
    private RadioButton mRadBtnFemale;
    private RadioButton mRadBtnAgeRange3;
    private TextView mTxtNumFamily;
    private Button mBtnOK;
    private TextView mTxtSug;
    private CheckBox mcheBox1;
    private CheckBox mcheBox2;
    private CheckBox mcheBox3;
    private CheckBox mcheBox4;
    private CheckBox mcheBox5;
    private CheckBox mcheBox6;
    private CheckBox mcheBox7;
    private CheckBox mcheBox8;
    private CheckBox mcheBox9;
    private CheckBox mcheBox10;

    private String selectedAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpnAge=(Spinner)findViewById(R.id.SpinnerAge);
        mSpnAge2=(Spinner)findViewById(R.id.SpinnerAge2);
        mRadBtnMale=(RadioButton)findViewById(R.id.RadioMale);
        mRadBtnFemale=(RadioButton)findViewById(R.id.RadioFemale);
        mRadGrp = (RadioGroup) findViewById(R.id.radGrpSex);
        mBtnOK = (Button) findViewById(R.id.btnOK);
        mTxtSug = (TextView) findViewById(R.id.txtSug);
        mcheBox1= (CheckBox) findViewById(R.id.CheckClimbing);
        mcheBox2= (CheckBox) findViewById(R.id.CheckMusic);
        mcheBox3= (CheckBox) findViewById(R.id.CheckDance);
        mcheBox4= (CheckBox) findViewById(R.id.CheckDrawing);
        mcheBox5= (CheckBox) findViewById(R.id.CheckEating);
        mcheBox6= (CheckBox) findViewById(R.id.CheckReading);
        mcheBox7= (CheckBox) findViewById(R.id.CheckSing);
        mcheBox8= (CheckBox) findViewById(R.id.CheckSwim);
        mcheBox9= (CheckBox) findViewById(R.id.CheckTravel);
        mcheBox10= (CheckBox) findViewById(R.id.CheckWriting);

        mBtnOK.setOnClickListener(btnOKOnClick);
    }


    private NumberPicker.OnValueChangeListener numPkrFamilyOnValueChange = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            mTxtNumFamily.setText(String.valueOf(newVal));
        }
    };

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            MarriageSuggestion ms = new MarriageSuggestion();

            String strSex = mSpnAge.getSelectedItem().toString();
            String strSug = "建議：";
            int iAgeRange = 0;
                switch (mRadGrp.getCheckedRadioButtonId()) {
                    case R.id.RadioMale:
                        strSug+="男性　";
                        strSug+=mSpnAge.getSelectedItem().toString()+" ";
                        break;
                    case R.id.RadioFemale:
                        strSug+="女性　";
                        strSug+=mSpnAge2.getSelectedItem().toString()+" ";
                        break;
                }
                strSug+="興趣:";
            if(mcheBox1.isChecked()){
                strSug+=mcheBox1.getText()+" ";
            }
            if(mcheBox2.isChecked()){
                strSug+=mcheBox2.getText()+" ";
            }
            if(mcheBox3.isChecked()){
                strSug+=mcheBox3.getText()+" ";
            }
            if(mcheBox4.isChecked()){
                strSug+=mcheBox4.getText()+" ";
            }
            if(mcheBox5.isChecked()){
                strSug+=mcheBox5.getText()+" ";
            }
            if(mcheBox6.isChecked()){
                strSug+=mcheBox6.getText()+" ";
            }
            if(mcheBox7.isChecked()){
                strSug+=mcheBox7.getText()+" ";
            }
            if(mcheBox8.isChecked()){
                strSug+=mcheBox8.getText()+" ";
            }
            if(mcheBox9.isChecked()){
                strSug+=mcheBox1.getText()+" ";
            }
            if(mcheBox10.isChecked()){
                strSug+=mcheBox10.getText()+" ";
            }
            mTxtSug.setText(strSug);
        }
    };
}
