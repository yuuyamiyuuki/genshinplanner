package com.br.genshinplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.br.genshinplanner.sqlite.DAO;

import java.sql.SQLException;
import java.time.LocalTime;

public class EventEditActivity extends AppCompatActivity
{
    private EditText resinToSpendET;
    private TextView eventDateTV;
    private TextView eventTimeTV;
    private Spinner eventSpinner;
    private DomainAdapter domainAdapter;
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
    }

    private void initWidgets()
    {
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeTV = findViewById(R.id.eventTimeTV);
        resinToSpendET = findViewById(R.id.eventResin);
        eventSpinner = findViewById(R.id.eventSpinner);
        domainAdapter = new DomainAdapter(this, Domain.getDomains());
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

    }

    public void saveEventAction(View view) throws SQLException {
        String resinToSpend = resinToSpendET.getText().toString();
        Integer itemSelected =  (Integer) eventSpinner.getSelectedItem();
        Domain domain = Domain.getDomains().get(itemSelected);

        dao.addOne(EventEntity.builder()
                .date(CalendarUtils.selectedDate)
                .resinSpent(Integer.parseInt(resinToSpend))
                .domain(domain.getDomainName())
                .build());
        finish();
    }


}