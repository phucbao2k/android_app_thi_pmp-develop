package androidvnua.vnua.caudiemliet;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;

import androidvnua.vnua.database.dbCauHoi;
import androidvnua.vnua.mucdethi.AdapterListQues;
import androidvnua.vnua.mucdethi.ListQuestion;
import androidvnua.vnua.thi_gplx_21.Home;
import androidvnua.vnua.thi_gplx_21.R;

public class CauDiemLiet extends AppCompatActivity {

    dbCauHoi db;
    private ArrayList<ListQuesPass> listQuestions;
    private AdapterCauDiemLiet adapter;
    private ListView listView;
    private ImageView btnHelp, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau_diem_liet);
        listQuestions = new ArrayList<>();

        connectDB();
        getCauDiemLiet();
        anhXa();
        click();

        adapter = new AdapterCauDiemLiet(CauDiemLiet.this,listQuestions);
        listView.setAdapter(adapter);
    }

    private void connectDB() {
        db = new dbCauHoi(this, "CauHoiDataBase.sqlite", null, 1);
    }

    private void getCauDiemLiet() {
        listQuestions.clear();

        Cursor dataCauHoi = db.GetData("SELECT * FROM CauHoi WHERE CauDiemLiet = 'true'");
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
        listView = findViewById(R.id.lvQuesPass);
        btnHelp = findViewById(R.id.btnHelpPass);
        btnBack = findViewById(R.id.btnBackPass);
    }

    private void click() {
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(CauDiemLiet.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_tutorial);
                TextView title = dialog.findViewById(R.id.txtTitleTutorial);
                TextView text = dialog.findViewById(R.id.txtTutorial);

                title.setText("Chú ý!");
                text.setText("Câu điểm liệt là phần rất quan trọng, bạn không được phép sai câu điểm liệt, hãy tập trung ghi nhớ để có thể tự tin vượt qua kì thi.");

                Window window = dialog.getWindow();
                if (window == null) {
                    return;
                }

                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                WindowManager.LayoutParams windowAttribute = window.getAttributes();
                windowAttribute.gravity = Gravity.CENTER;
                window.setAttributes(windowAttribute);

                dialog.show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}