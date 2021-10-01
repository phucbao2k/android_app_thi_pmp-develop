package androidvnua.vnua.mucdethi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidvnua.vnua.thi_gplx_21.R;

public class AdapterListQues extends ArrayAdapter<ListQuestion> {

    private Activity activity;
    private ArrayList<ListQuestion> listQuestions;
    Toast t = null;
    private SparseIntArray mSpCheckedState = new SparseIntArray();
    public boolean ans[] = new boolean[20];
    public ArrayList<Integer> Id = new ArrayList<>();
    private boolean tienDo[] = new boolean[20];
    public boolean isPass[] = new boolean[20];
    private int countSeek = 0;
    private int countChecked = 0;

    public AdapterListQues(Activity activity, ArrayList<ListQuestion> mAnswerList) {
        super(activity, R.layout.custom_view_question, mAnswerList);
        this.activity = activity;
        this.listQuestions = mAnswerList;
    }

    @Override
    public int getCount() {
        return listQuestions.size();
    }

    @Override
    public ListQuestion getItem(int position) {
        return listQuestions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        SeekBar seekBarTienDo = activity.findViewById(R.id.tiendo);
        TextView txtTienDo = activity.findViewById(R.id.txtTienDo);
        seekBarTienDo.setEnabled(false);

        ViewHolder holder = null;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater mInflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_view_question, null);

            holder.txtQues = (TextView) convertView.findViewById(R.id.txtQuestion);
            holder.imgHinh = (ImageView) convertView.findViewById(R.id.imgQuestion);
            holder.rdGroup = (RadioGroup) convertView.findViewById(R.id.rdgQuestion);
            holder.btnA = (RadioButton) convertView.findViewById(R.id.btnA);
            holder.btnB = (RadioButton) convertView.findViewById(R.id.btnB);
            holder.btnC = (RadioButton) convertView.findViewById(R.id.btnC);
            holder.btnD = (RadioButton) convertView.findViewById(R.id.btnD);
            holder.txtPass = (TextView) convertView.findViewById(R.id.txtPass);
            convertView.setTag(holder);
        } else {
            holder=(ViewHolder)convertView.getTag();
        }

        holder.rdGroup.setOnCheckedChangeListener(null);
        holder.rdGroup.clearCheck();

        if(mSpCheckedState.indexOfKey(position)>-1){
            holder.rdGroup.check(mSpCheckedState.get(position));
        }else{
            holder.rdGroup.clearCheck();
        }

        ListQuestion question = listQuestions.get(position);
        int number = position+1;
        if (question.getIsSpecial().equals("true")) {
            isPass[position] = true;
            holder.txtPass.setTextSize(14);
            holder.txtPass.setText("*Câu điểm liệt!");
        } else {
            holder.txtPass.setTextSize(0);
            holder.txtPass.setText("");
        }

        //id[position] = question.getID();
        Id.add(question.getID());

        holder.rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId > -1){
                    mSpCheckedState.put(position, checkedId);
                }else{
                    if(mSpCheckedState.indexOfKey(position)>-1)
                        mSpCheckedState.removeAt(mSpCheckedState.indexOfKey(position));
                }

                switch (checkedId) {
                    case R.id.btnA:
                        ans[position] = question.getAns().equals("A");
                        showToast("Check btn A" + ans[position]);
                        tienDo[position] = true;
                        if (question.getIsSpecial().equals("true")) {
                            isPass[position] = !question.getAns().equals("A");
                        }
                        break;
                    case R.id.btnB:
                        ans[position] = question.getAns().equals("B");
                        showToast("Check btn B" + ans[position]);
                        tienDo[position] = true;
                        if (question.getIsSpecial().equals("true")) {
                            isPass[position] = !question.getAns().equals("B");
                        }
                        break;
                    case R.id.btnC:
                        ans[position] = question.getAns().equals("C");
                        showToast("Check btn C" + ans[position]);
                        if (question.getC().equals("null")) {
                            tienDo[position] = false;
                        } else {
                            tienDo[position] = true;
                        }

                        if (question.getIsSpecial().equals("true")) {
                            isPass[position] = !question.getAns().equals("C");
                        }
                        break;
                    case R.id.btnD:
                        ans[position] = question.getAns().equals("D");
                        showToast("Check btn D" + ans[position]);
                        if (question.getD().equals("null")) {
                            tienDo[position] = false;
                        } else {
                            tienDo[position] = true;
                        }

                        if (question.getIsSpecial().equals("true")) {
                            isPass[position] = !question.getAns().equals("D");
                        }
                        break;
                    default:
                        tienDo[position] = false;
                }

                for (int i = 0; i < tienDo.length; i++) {
                    if (tienDo[i]) {
                        countSeek = countSeek +5;
                        countChecked++;
                    }
                }
                txtTienDo.setText(countChecked+"/20");
                seekBarTienDo.setProgress(countSeek);
                countSeek = 0;
                countChecked = 0;
            }
        });

        if (question.getHinhAnh() != 0) {
            holder.imgHinh.getLayoutParams().height = 300;
            holder.imgHinh.setImageResource(question.getHinhAnh());
        } else {
            holder.imgHinh.setImageResource(question.getHinhAnh());
            holder.imgHinh.getLayoutParams().height = 1;
        }
        holder.txtQues.setText( "Câu " +number+": "+  question.getQues());

        holder.btnA.setText("A. "+getItem(position).getA());
        holder.btnB.setText("B. "+question.getB());

        if (question.getC().equals("null")) {
            holder.btnC.setButtonDrawable(null);
            holder.btnC.setText(" ");
        } else {
            holder.btnC.setButtonDrawable(R.drawable.custom_radio);
            holder.btnC.setText("C. "+question.getC());
        }

        if (question.getD().equals("null")) {
            holder.btnD.setButtonDrawable(null);
            holder.btnD.setText(" ");
        } else {
            holder.btnD.setButtonDrawable(R.drawable.custom_radio);
            holder.btnD.setText("D. "+question.getD());
        }

        return convertView;
    }

    private static class ViewHolder {
        private TextView txtQues, txtPass;
        private RadioButton btnA, btnB, btnC, btnD;
        private ImageView imgHinh;
        private RadioGroup rdGroup;
    }

    void showToast(String text) {

        if (t != null)
            t.cancel();

        t = Toast.makeText(activity, text, Toast.LENGTH_SHORT);
        t.show();
    }
}
