package com.example.user.hw8;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner mItemSpn;
    private Button mInputBtn, mRecBtn;
    private TextView mDataOut;
    private EditText mCostEdt;
    private DatePicker mDatePicker;

    private int itemNum;
    private String date;
    private ArrayList<String> itemList = new ArrayList<String>();

    private Intent intent;
    private Intent intent_bgm;

    private AdapterView.OnClickListener recBtnOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            intent = new Intent(MainActivity.this, RecordActivity.class);
            intent.putStringArrayListExtra("itemList", itemList);
            startActivity(intent);
        }
    };
    private AdapterView.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String cost = mCostEdt.getText().toString();
            if (cost.matches("")) {
                Toast.makeText(MainActivity.this, "You didn't enter how much you cost!", Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                String itemNumStr = String.valueOf(itemNum);
                String item = "項目" + itemNumStr;
                String oneItem = item;
                Toast.makeText(MainActivity.this, cost, Toast.LENGTH_SHORT).show();
                date = mDatePicker.getYear() + "/" + (mDatePicker.getMonth() + 1) + "/" + mDatePicker.getDayOfMonth();
                oneItem += "            " + date + "           " + mItemSpn.getSelectedItem().toString() + "           " + cost;
                itemList.add(oneItem);
                itemNum++;
            }
        }
    };
    private DatePicker.OnDateChangedListener onChanged = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String dataSelected = mDatePicker.getYear() + "/" + mDatePicker.getMonth() + "/" + mDatePicker.getDayOfMonth();
            mDataOut.setText(dataSelected);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItemSpn = (Spinner) findViewById(R.id.TimeSpinner);
        mInputBtn = (Button) findViewById(R.id.BtnEnter);
        mRecBtn = (Button) findViewById(R.id.BtnRecord);
        mDataOut = (TextView) findViewById(R.id.EdtDate);
        mCostEdt = (EditText) findViewById(R.id.EdtMoney);
        mDatePicker = (DatePicker) findViewById(R.id.datePicker);

        mDatePicker.setOnDateChangedListener(onChanged);
        mInputBtn.setOnClickListener(onClick);
        mRecBtn.setOnClickListener(recBtnOnClick);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        onOptionsItemSelected(item);
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_playMusic:
                intent_bgm = new Intent(this, MusicService.class);
                startService(intent_bgm);
                break;
            case R.id.action_stopPlaying:
                stopService(intent_bgm);
                break;
            case R.id.action_about:
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("關於這個程式")
                        .setMessage("選單範例程式")
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
                break;
            case R.id.action_finish:
                finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
