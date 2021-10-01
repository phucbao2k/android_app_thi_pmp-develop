package androidvnua.vnua.mucdethi.BatDauThiThu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;

import androidvnua.vnua.database.dbCauHoi;
import androidvnua.vnua.mucdethi.AdapterListQues;
import androidvnua.vnua.mucdethi.ListQuestion;
import androidvnua.vnua.mucdethi.MainActivity_dethi;
import androidvnua.vnua.thi_gplx_21.Home;
import androidvnua.vnua.thi_gplx_21.R;

public class MainActivity_start extends AppCompatActivity {

    private dbCauHoi db;
    private String maDe;
    private ArrayList<ListQuestion> listQuestions;
    private AdapterListQues adapter;
    private ListView listView;
    private TextView txtCountDown, txtDe;
    private Button btnBack;
    private CountDownTimer mcountDownTimer;
    private long timeLeftInMilliseconds = 1261000;
    private boolean isUnique = true;
    private int count = 0;
    private int countPass = 0;
    private String msg = "";
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);
        Intent intent = getIntent();
        maDe = intent.getStringExtra("ma_de");

        connectDB();
        anhxa();
        getCauHoi();
        CountDown();
        CreateBtn();
        ClickBtnBack();

        adapter = new AdapterListQues(this, listQuestions);
        listView.setAdapter(adapter);

        txtDe.setText("Đề số "+maDe);
    }

    private void connectDB() {
        db = new dbCauHoi(this, "CauHoiDataBase.sqlite", null, 1);
    }

    private void getCauHoi() {
        listQuestions.clear();

        Cursor dataCauHoi = db.GetData("SELECT * FROM CauHoi WHERE soDe ="+ maDe);
        int id = dataCauHoi.getColumnIndex("ID");
        int cauhoi = dataCauHoi.getColumnIndex("CauHoi");
        int sode = dataCauHoi.getColumnIndex("soDe");
        int cauHoiA = dataCauHoi.getColumnIndex("CauHoiA");
        int cauHoiB = dataCauHoi.getColumnIndex("CauHoiB");
        int cauHoiC = dataCauHoi.getColumnIndex("CauHoiC");
        int cauHoiD = dataCauHoi.getColumnIndex("CauHoiD");
        int image = dataCauHoi.getColumnIndex("Image");
        int dapAn = dataCauHoi.getColumnIndex("DapAn");
        int cauDiemLiet = dataCauHoi.getColumnIndex("CauDiemLiet");

        while (dataCauHoi.moveToNext()) {
            int idCauHoi= dataCauHoi.getInt(id);
            String isSpecial = dataCauHoi.getString(cauDiemLiet);
            String Ques = dataCauHoi.getString(cauhoi);
            String A = dataCauHoi.getString(cauHoiA);
            String B = dataCauHoi.getString(cauHoiB);
            String C = dataCauHoi.getString(cauHoiC);
            String D = dataCauHoi.getString(cauHoiD);
            String img = dataCauHoi.getString(image);
            String Ans = dataCauHoi.getString(dapAn);
            int resID = getResId(img, R.drawable.class);
            listQuestions.add(new ListQuestion(idCauHoi, isSpecial, ""+Ques, ""+A, ""+B, ""+C, ""+D, resID, ""+Ans));
        }

    }

    private void anhxa() {
        listView = findViewById(R.id.listStart);
        txtCountDown = findViewById(R.id.txtCountDown);
        btnBack = findViewById(R.id.back);
        txtDe = findViewById(R.id.txtSoDe);
        listQuestions = new ArrayList<>();
    }

    public static int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Function xử lý CountDownTimer
    public void CountDown() {
        mcountDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {

                scrollMyListViewToBottom();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialogHetGio();
                    }
                }, 800);
            }
        }.start();
    }

    // Function Update timer xử lý thời gian và setText
    public void updateTimer() {
        long second = (timeLeftInMilliseconds % 60000) / 1000;

        // minutes = 120000 / 60000 = 2 (m)
        int minutes = (int) timeLeftInMilliseconds / 60000;

        // seconds = (120000 % 60000) / 1000 = 0;
        int seconds = (int) second;

        // Thời gian còn lại
        String timeLeftText;

        // 2:
        timeLeftText = "" + minutes;
        timeLeftText += ":";

        // nếu seconds(s) < 10
        if (seconds < 10) {
            //2:0
            timeLeftText += "0";
        }

        // 2:00
        timeLeftText += seconds;

        txtCountDown.setText(timeLeftText);
    }

    private void dialogHetGio() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom_thi);
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        Button btnKiemTraInDiaLOg = dialog.findViewById(R.id.btnXemKQ);
        btnKiemTraInDiaLOg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli();
            }
        });
    }


    // Xử lý khi người dùng click quay trở lại trên thanh cứng android
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                diaLog("Xác nhận","Bài thi của bạn chưa hoàn thành, bạn có muốn đóng ứng dụng?","Đồng ý", "không đồng ý", 1);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // Function DiaLogBack xử lý thông báo
    public void diaLog(String title, String msg, String txtYes, String txtNo, int option) {
        //Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(false);
        //Thiết lập tiêu đề
        b.setTitle(title);
        b.setMessage(msg);
        // Nút Ok
        b.setPositiveButton(txtYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                mcountDownTimer.cancel();
                if (option == 1) {
                    MainActivity_start.this.finishAffinity();
                }
                else if (option == 2) {
                    xuli();
                }
                else {
                    Intent intent = new Intent(MainActivity_start.this, MainActivity_dethi.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        //Nút Cancel
        b.setNegativeButton(txtNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        //Tạo dialog
        AlertDialog al = b.create();
        //Hiển thị
        al.show();
    }

    public void CreateBtn () {
        Button btnChecked = new Button(this);

        btnChecked.setText("Nộp Bài");
        btnChecked.setGravity(Gravity.CENTER);

        btnChecked.setTextColor(getApplication().getResources().getColor(R.color.white));
        Drawable custom = getDrawable(R.drawable.button_check);

        btnChecked.setBackground(custom);

        if (btnChecked != null) {
           listView.addFooterView(btnChecked);
        }

        btnChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diaLog("Xác nhận nộp bài","Vẫn còn thời gian bạn muốn nộp bài không?","Đồng ý", "Chưa nộp", 2 );
            }
        });
    }

    public void ClickBtnBack() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diaLog("Xác nhận","Bạn có muốn dừng làm bài không?","Đồng ý", "Không đồng ý", -1);
            }
        });
    }

    private void xuli() {
        for (int i = 0; i < adapter.ans.length; i++) {
            if (adapter.ans[i]) {
                count++;
            } else {
                // Insert (table)
                InsertTableDB(i);
            }
        }

        for (int i = 0; i < adapter.isPass.length; i++) {
            if (adapter.isPass[i]) {
                countPass++;
            }
        }

        Intent intent = new Intent(MainActivity_start.this, KiemTraKetQua.class);
        mcountDownTimer.cancel();
        intent.putExtra("ma_de", maDe);
        intent.putExtra("so_cau_dung", count);
        intent.putExtra("cau_sai", msg);
        if (countPass > 0) {
            intent.putExtra("isPass", false);
        } else {
            intent.putExtra("isPass", true);
        }
        startActivity(intent);
        finish();
    }

    // insert
    private void InsertTableDB (int i) {
        Cursor dataCauSai = db.GetData("SELECT * FROM CauHoiSai WHERE IdCauHoiSai ="+ adapter.Id.get(i));
        while (dataCauSai.moveToNext()) {
            isUnique = false;
        }

        if (isUnique) {
            db.QueryData("INSERT INTO CauHoiSai VALUES (null, '"+adapter.Id.get(i)+"') ");
        }
    }

    // hàm auto cuộn xuống dưới
    void scrollMyListViewToBottom() {
        listView.post(new Runnable() {
            @Override
            public void run() {
                listView.smoothScrollToPosition(adapter.getCount()-1);
            }
        });
    }
}