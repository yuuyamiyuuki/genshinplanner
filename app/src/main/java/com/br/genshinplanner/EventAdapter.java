package com.br.genshinplanner;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Optional;

public class EventAdapter extends ArrayAdapter<EventEntity>
{
    public EventAdapter(@NonNull Context context, List<EventEntity> events)
    {
        super(context, 0, events);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        EventEntity event = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_cell, parent, false);

        TextView eventCellTV = convertView.findViewById(R.id.eventCellTV);
        ImageView eventCellIV = convertView.findViewById(R.id.eventCellIV);

        Optional<Domain> domain = Domain.getDomains().stream().filter(d -> d.getDomainName().equals(event.getDomain())).findFirst();
        if(domain.isPresent()) {
            String eventTitle = domain.get().getDomainName() + " @ " + CalendarUtils.formattedTime(event.getTime()) + ": Resin -> " + event.getResinSpent();
            eventCellTV.setText(eventTitle);
            eventCellIV.setImageResource(domain.get().getDomainImage());
        }
        return convertView;
    }
}
