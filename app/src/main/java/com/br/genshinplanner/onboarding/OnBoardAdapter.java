package com.br.genshinplanner.onboarding;

import android.content.Context;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.br.genshinplanner.R;

import java.util.ArrayList;

class OnBoardAdapter extends PagerAdapter {

    private Context context;
    ArrayList<OnBoardItem> onBoardItems = new ArrayList<>();


    public OnBoardAdapter(Context mContext, ArrayList<OnBoardItem> items) {
        this.context = mContext;
        this.onBoardItems = items;
    }

    @Override
    public int getCount() {
        return onBoardItems.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.onboard_item, container, false);

        OnBoardItem item = onBoardItems.get(position);

        ImageView imageView = itemView.findViewById(R.id.iv_onboard);
        imageView.setImageResource(item.getImageID());

        TextView header = itemView.findViewById(R.id.header);
        header.setText(item.getTitle());

        TextView description = itemView.findViewById(R.id.description);
        description.setText(item.getDescription());

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
