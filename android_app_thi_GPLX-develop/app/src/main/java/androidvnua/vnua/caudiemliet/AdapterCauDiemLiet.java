package androidvnua.vnua.caudiemliet;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import androidvnua.vnua.thi_gplx_21.R;

public class AdapterCauDiemLiet extends ArrayAdapter<ListQuesPass> {
    Toast t = null;
    private Activity activity;
    private ArrayList<ListQuesPass> listQuestions;

    public AdapterCauDiemLiet(Activity activity, ArrayList<ListQuesPass> mAnswerList) {
        super(activity, R.layout.custom_view_passques, mAnswerList);
        this.activity = activity;
        this.listQuestions = mAnswerList;
    }

    @Override
    public int getCount() {
        return listQuestions.size();
    }

    @Override
    public ListQuesPass getItem(int position) {
        return listQuestions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater mInflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_view_passques, null);

            holder.txtQues = (TextView) convertView.findViewById(R.id.txtQuesPass);
            holder.imgHinh = (ImageView) convertView.findViewById(R.id.imgQuesPass);
            holder.txtAns = (TextView) convertView.findViewById(R.id.txtAnsPass);
            convertView.setTag(holder);
        } else {
            holder=(ViewHolder)convertView.getTag();
        }
        ListQuesPass question = listQuestions.get(position);

        if (question.getHinhAnh() != 0) {
            holder.imgHinh.getLayoutParams().height = 300;
            holder.imgHinh.setImageResource(question.getHinhAnh());
        } else {
            holder.imgHinh.setImageResource(question.getHinhAnh());
            holder.imgHinh.getLayoutParams().height = 1;
        }
        holder.txtQues.setText("Câu hỏi: "+question.getQues());
        if (question.getAns().equals("A")) {
            holder.txtAns.setText("Đáp án: "+question.getA());
        } else if (question.getAns().equals("B")) {
            holder.txtAns.setText("Đáp án: "+question.getB());
        } else if (question.getAns().equals("C")) {
            holder.txtAns.setText("Đáp án: "+question.getC());
        } else if (question.getAns().equals("D")) {
            holder.txtAns.setText("Đáp án: "+question.getD());
        }


        return convertView;
    }

    private static class ViewHolder {
        private TextView txtQues, txtAns;
        private ImageView imgHinh;
    }

    void showToast(String text) {

        if (t != null)
            t.cancel();

        t = Toast.makeText(activity, text, Toast.LENGTH_SHORT);
        t.show();
    }
}
