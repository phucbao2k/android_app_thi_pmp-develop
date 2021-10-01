package androidvnua.vnua.mucdethi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import androidvnua.vnua.thi_gplx_21.R;

public class AdapterGridView extends BaseAdapter {
    private final Context context;
    private final int layout;
    private final List<titleStack> listTitle;

    public AdapterGridView(Context context, int layout, List<titleStack> listTitle) {
        this.context = context;
        this.layout = layout;
        this.listTitle = listTitle;
    }

    @Override
    public int getCount() {
        return listTitle.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class viewHolder {
        TextView title;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        viewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new viewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.txtTitle);
            convertView.setTag(holder);
        }else {
            holder = (viewHolder) convertView.getTag();
        }

        titleStack question = listTitle.get(position);
        holder.title.setText("Đề số " +question.getDe());

        return convertView;
    }
}
