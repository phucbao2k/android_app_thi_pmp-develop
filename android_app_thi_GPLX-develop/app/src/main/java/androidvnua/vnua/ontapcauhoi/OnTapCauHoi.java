package androidvnua.vnua.ontapcauhoi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;

import androidvnua.vnua.CauTraLoiSai.MainActivity_CauTraLoiSai;
import androidvnua.vnua.caudiemliet.AdapterCauDiemLiet;
import androidvnua.vnua.caudiemliet.CauDiemLiet;
import androidvnua.vnua.caudiemliet.ListQuesPass;
import androidvnua.vnua.database.dbCauHoi;
import androidvnua.vnua.thi_gplx_21.Home;
import androidvnua.vnua.thi_gplx_21.R;

public class OnTapCauHoi extends AppCompatActivity {

    dbCauHoi db;
    private ArrayList<ListQuesPass> listQuestions;
    private AdapterCauDiemLiet adapter;
    private ListView listView;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_tap_cau_hoi);
        listQuestions = new ArrayList<>();
        connectDB();
        getCauHoi();
        anhXa();
        click();

        adapter = new AdapterCauDiemLiet(OnTapCauHoi.this,listQuestions);
        listView.setAdapter(adapter);
    }

    private void connectDB() {
        db = new dbCauHoi(this, "CauHoiDataBase.sqlite", null, 1);
    }

    private void getCauHoi() {
        listQuestions.clear();

        Cursor dataCauHoi = db.GetData("SELECT * FROM CauHoi");
        int id = dataCauHoi.getColumnIndex("ID");
        int cauhoi = dataCauHoi.getColumnIndex("CauHoi");
        int cauHoiA = dataCauHoi.getColumnIndex("CauHoiA");
        int cauHoiB = dataCauHoi.getColumnIndex("CauHoiB");
        int cauHoiC = dataCauHoi.getColumnIndex("CauHoiC");
        int cauHoiD = dataCauHoi.getColumnIndex("CauHoiD");
        int image = dataCauHoi.getColumnIndex("Image");
        int dapAn = dataCauHoi.getColumnIndex("DapAn");

        while (dataCauHoi.moveToNext()) {
            int idCauHoi= dataCauHoi.getInt(id);
            String Ques = dataCauHoi.getString(cauhoi);
            String A = dataCauHoi.getString(cauHoiA);
            String B = dataCauHoi.getString(cauHoiB);
            String C = dataCauHoi.getString(cauHoiC);
            String D = dataCauHoi.getString(cauHoiD);
            String img = dataCauHoi.getString(image);
            String Ans = dataCauHoi.getString(dapAn);
            int resID = getResId(img, R.drawable.class);
            listQuestions.add(new ListQuesPass(""+Ques, ""+A, ""+B, ""+C, ""+D, ""+Ans, resID));
        }
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

    private void anhXa() {
        listView = findViewById(R.id.lvAllQues);
        btnBack = findViewById(R.id.btnBackQues);
    }

    private void click() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}