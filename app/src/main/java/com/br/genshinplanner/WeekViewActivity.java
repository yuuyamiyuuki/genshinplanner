package com.br.genshinplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.br.genshinplanner.CalendarUtils.daysInWeekArray;
import static com.br.genshinplanner.CalendarUtils.monthYearFromDate;

import com.br.genshinplanner.sqlite.DAO;

public class WeekViewActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener
{
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView eventListView;
    public TextView weekResin;
    private final DAO dao = new DAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);
        initWidgets();
        setWeekView();
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
        eventListView = findViewById(R.id.eventListView);
        weekResin = findViewById(R.id.weekResin);
    }

    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);
        updateWeekResin();
        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
        calendarAdapter.notifyDataSetChanged();
        setEventAdpater();
    }


    public void previousWeekAction(View view)
    {
        weekResin.setText(R.string.week_resin_resin);
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusWeeks(1);
        setWeekView();
    }

    public void nextWeekAction(View view)
    {
        weekResin.setText(R.string.week_resin_resin);
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusWeeks(1);
        setWeekView();
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        CalendarUtils.selectedDate = date;
        setWeekView();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setEventAdpater();
        setWeekView();
    }

    private void setEventAdpater()
    {
        List<EventEntity> dailyEvents;
        if(Objects.nonNull(CalendarUtils.selectedDate)) {
            dailyEvents = dao.getAllByDate(CalendarUtils.selectedDate);
        }
        else{
            dailyEvents = dao.getAllByDate(LocalDate.now());
        }

        if(Objects.isNull(dailyEvents)){
            dailyEvents = new ArrayList<>();
        }

        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), dailyEvents);
        eventListView.setAdapter(eventAdapter);
    }

    public void newEventAction(View view)
    {
        startActivity(new Intent(this, EventEditActivity.class));
    }


    private void updateWeekResin(){
        weekResin = findViewById(R.id.weekResin);
        weekResin.setText(R.string.week_resin_resin);
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);
        List<EventEntity> weekEvents = new ArrayList<>();
        Integer resin = 0;
        String resinCounter = weekResin.getText().toString();
        days.forEach(day -> weekEvents.addAll(dao.getAllByDate(day)));
        for(EventEntity event : weekEvents){
            resin += event.getResinSpent();
        }
        resinCounter = resinCounter.replace("{{resin}}", resin.toString());
        weekResin.setText(resinCounter);
    }

}