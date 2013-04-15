package com.f2prateek;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * An example to observe how ListView recycling works.
 */
public class RecyclingListActivity extends Activity {

    private static String TAG = "RecyclingListActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycling_list_activity);
        ListView mListView = (ListView) findViewById(android.R.id.list);
        mListView.setAdapter(new SimpleTextAdapter(this, 40));
    }

    private class SimpleTextAdapter extends BaseAdapter {

        private final int count;
        private final Context context;

        private SimpleTextAdapter(Context context, int count) {
            this.context = context;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                view = LayoutInflater.from(context).inflate(R.layout.recycling_list_item, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) view.findViewById(R.id.textView);
                viewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
                view.setTag(viewHolder);
                viewHolder.textView.setText(context.getString(R.string.unrecycled_text, position));
                viewHolder.imageView.setImageResource(R.drawable.ic_action_unrecycled);
            } else {
                view = convertView;
                ViewHolder viewHolder = (ViewHolder) view.getTag();
                viewHolder.textView.setText(context.getString(R.string.recycled_text, position));
                viewHolder.imageView.setImageResource(R.drawable.ic_action_recycled);
            }
            return view;
        }

        private class ViewHolder {
            TextView textView;
            ImageView imageView;
        }
    }

}

