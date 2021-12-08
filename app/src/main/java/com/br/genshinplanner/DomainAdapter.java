package com.br.genshinplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class DomainAdapter extends BaseAdapter
{
    private Context context;
    private List<Domain> domainList;
    private int layout;


    @Override
    public int getCount() {
        return Objects.nonNull(domainList) ? domainList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context).inflate(layout, viewGroup,false);

        TextView name = rootView.findViewById(R.id.itemName);
        ImageView image = rootView.findViewById(R.id.itemImage);

        name.setText(domainList.get(i).getDomainName());
        name.setTooltipText(domainList.get(i).getDomainLocation());
        image.setImageResource(domainList.get(i).getDomainImage());
        return rootView;
    }
}
