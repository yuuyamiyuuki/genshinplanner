package com.br.genshinplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.br.genshinplanner.sqlite.DAO;

import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class EventEditActivity extends AppCompatActivity
{
    private EditText resinToSpendET;
    private TextView eventDateTV;
    private TextView eventTimeTV;
    private Spinner eventSpinner;
    private DomainAdapter domainAdapter;
    private Button timePickerButton;
    int mHour, mMin;
    private LocalTime time;
    private DAO dao = new DAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        eventTimeTV.setText("Time: " + CalendarUtils.formattedTime(time));
        CalendarUtils.selectedTime = time;
    }

    private void initWidgets()
    {
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeTV = findViewById(R.id.eventTimeTV);
        resinToSpendET = findViewById(R.id.eventResin);
        eventSpinner = findViewById(R.id.eventSpinner);
        timePickerButton = findViewById(R.id.timePicker);
        List<Domain> dateDomains = Domain.getDailyDomains(CalendarUtils.selectedDate, this);
        domainAdapter = new DomainAdapter(this, dateDomains);
        eventSpinner.setAdapter(domainAdapter);

        eventSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        timePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                TimePickerDialog timePickerDialog = new TimePickerDialog(EventEditActivity.this, R.style.TimePickerTheme, new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
                        time = LocalTime.of(hourOfDay, minute, 0);
                        eventTimeTV.setText("Time: " + CalendarUtils.formattedTime(time));
                        CalendarUtils.selectedTime = time;
                    }
                }, mHour, mMin, true);
                timePickerDialog.show();
            }
        });

    }

    public void saveEventAction(View view) throws SQLException {

        if(Objects.isNull(resinToSpendET.getText().toString()) || "".equals(resinToSpendET.getText().toString())){
            Toast.makeText(this, "Please, add the resin to be spent.", Toast.LENGTH_SHORT).show();
            return;
        }
        String resinToSpend = resinToSpendET.getText().toString();
        Integer itemSelected =  (Integer) eventSpinner.getSelectedItem();
        Domain domain = Domain.getDailyDomains(CalendarUtils.selectedDate, this).get(itemSelected);

        EventEntity event = dao.addOne(EventEntity.builder()
                .date(CalendarUtils.selectedDate)
                .time(CalendarUtils.selectedTime)
                .resinSpent(Integer.parseInt(resinToSpend))
                .domain(domain.getDomainName())
                .build());

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR, CalendarUtils.selectedTime.getHour());
        intent.putExtra(AlarmClock.EXTRA_DAYS, "");
        intent.putExtra(AlarmClock.EXTRA_MINUTES, CalendarUtils.selectedTime.getMinute());
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, event.getId() +"!"+domain.getDomainName() + " - Resin: " + resinToSpend);
        intent.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        intent.putExtra(AlarmClock.EXTRA_LENGTH, true);
        startActivity(intent);

        finish();
    }


}