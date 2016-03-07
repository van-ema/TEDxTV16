package com.example.group.tedxtv16.listViewAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group.tedxtv16.R;
import com.example.group.tedxtv16.item.Item;

import java.util.ArrayList;

/**
 * Created by emanuele on 04/03/16.
 */
public class NewsAdapter extends BaseAdapter {

    private ArrayList list;
    private static LayoutInflater inflater = null;

    //Constructor.
    public NewsAdapter(Context context, ArrayList list) {
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (convertView == null)
            view = inflater.inflate(R.layout.fragment_news_sample_layout, null);

        ImageView photo = (ImageView) view.findViewById(R.id.photo);
        TextView newsText = (TextView) view.findViewById(R.id.speaker);
        TextView description = (TextView) view.findViewById(R.id.tvNewsDescription);

        if (list != null) {
            if (!list.isEmpty()) {
                Item newsItem = (Item) list.get(position);

                if (newsItem != null) {
                    if (newsItem.getName() != null)
                        newsText.setText(newsItem.getName());
                    else {
                        newsText.setText("NON DISPONIBILE");
                    }
                    if (newsItem.getPhoto() != null)
                        photo.setImageBitmap(Bitmap.createScaledBitmap(newsItem.getPhoto(), 300, 300, false));
                    else{photo.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeFile("/res/drawable/no_image_available.png"), 300, 300, false));}
                    if (newsItem.getDescription() != null)
                        description.setText(newsItem.getDescription());
                    else{
                        description.setText("NON DISPONIBILE");
                    }
                }
            }
        }

        return view;
    }

}