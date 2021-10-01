package androidvnua.vnua.mucdethi;

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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import androidvnua.vnua.CauTraLoiSai.MainActivity_CauTraLoiSai;
import androidvnua.vnua.database.dbCauHoi;
import androidvnua.vnua.mucdethi.BatDauThiThu.MainActivity_start;
import androidvnua.vnua.thi_gplx_21.Home;
import androidvnua.vnua.thi_gplx_21.R;

public class MainActivity_dethi extends AppCompatActivity {

    dbCauHoi db;

    private ImageView btnBack, btnHelp;
    private GridView gridView;
    private ArrayList<titleStack> listTitle;
    private AdapterGridView adapter;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dethi);
        connectDB();
        getData();
        customTitle();
        anhXa();
        click();
    }

    private void connectDB() {
        db = new dbCauHoi(this, "CauHoiDataBase.sqlite", null, 1);
    }

    private void getData() {

        Cursor dataCauHoi = db.GetData("SELECT * FROM CauHoi");

        while (dataCauHoi.moveToNext()) {
            count++;
        }
    }

    private void customTitle() {
        gridView = (GridView) findViewById(R.id.grView);

        listTitle = new ArrayList<>();

        for (int i = 1; i <= count/20; i++) {
            listTitle.add(new titleStack(String.valueOf(i)));
        }

        adapter = new AdapterGridView( MainActivity_dethi.this, R.layout.custom_btn_dethi, listTitle);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity_dethi.this, MainActivity_start.class);
                intent.putExtra("ma_de", String.valueOf(position+1));
                startActivity(intent);
                finish();
            }
        });
    }

    private void anhXa() {
        btnBack = findViewById(R.id.btnBackStart);
        btnHelp = findViewById(R.id.btnHelpStart);
    }

    private void click() {
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity_dethi.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_tutorial);
                TextView title = dialog.findViewById(R.id.txtTitleTutorial);
                TextView text = dialog.findViewById(R.id.txtTutorial);

                title.setText("Lưu ý khi làm bài!");
                text.setText("Với số lượng câu hỏi 20 câu thời gian làm bài 15 phút. Yêu cầu đúng 16/21 câu.\n" +
                        "Lưu ý: Tuyệt đối không được sai câu diểm liệt!");

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