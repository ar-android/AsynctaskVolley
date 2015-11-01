package com.ocit.asynctaskvolley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ar-android on 01/11/2015.
 */
public class AdapterListview extends BaseAdapter{

    private LayoutInflater inflater;
    private ArrayList<DataResponse> data;

    public AdapterListview(Context context, ArrayList<DataResponse> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tvTitle,tvThumbnail, tvGenere,tvdesc;

        convertView = inflater.inflate(R.layout.list_item, null);

        tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
        tvThumbnail = (TextView)convertView.findViewById(R.id.tvTumbnail);
        tvGenere = (TextView)convertView.findViewById(R.id.tvGenere);
        tvdesc = (TextView)convertView.findViewById(R.id.tvDesc);

        tvTitle.setText(data.get(position).title);
        tvThumbnail.setText(data.get(position).thumbnail);
        tvGenere.setText(data.get(position).genere);
        tvdesc.setText(data.get(position).desc);

        return convertView;
    }
}