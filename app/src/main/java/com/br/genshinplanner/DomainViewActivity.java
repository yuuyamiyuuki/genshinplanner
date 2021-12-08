package com.br.genshinplanner;

import static com.br.genshinplanner.CalendarUtils.daysInWeekArray;
import static com.br.genshinplanner.CalendarUtils.monthYearFromDate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.br.genshinplanner.sqlite.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DomainViewActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener
{
    private RecyclerView domainWeekRecycleView;
    private ListView domainListView;
    public TextView weekResin;
    private final DAO dao = new DAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domain_view);
        initWidgets();
        initDomains();
    }

    private void initWidgets()
    {
        domainWeekRecycleView = findViewById(R.id.domainWeekRecycleView);
        domainListView = findViewById(R.id.domainListView);
    }

    private void initDomains()
    {
        ArrayList<LocalDate> days = daysInWeekArray(LocalDate.now());
        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        domainWeekRecycleView.setLayoutManager(layoutManager);
        domainWeekRecycleView.setAdapter(calendarAdapter);
        calendarAdapter.notifyDataSetChanged();
        setDomainAdapter();
    }


    @Override
    public void onItemClick(int position, LocalDate date)
    {
        CalendarUtils.selectedDate = date;
        initDomains();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setDomainAdapter();
        initDomains();
    }

    private void setDomainAdapter()
    {
        List<Domain> domains = Domain.getDailyWeaponDomains(CalendarUtils.selectedDate, this);
        domains.addAll(Domain.getDailyTalentDomains(CalendarUtils.selectedDate, this));
        DomainAdapter domainAdapter = new DomainAdapter(getApplicationContext(), domains, R.layout.spinner_with_map);
        domainListView.setAdapter(domainAdapter);
    }


}