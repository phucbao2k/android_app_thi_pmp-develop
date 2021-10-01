package androidvnua.vnua.thi_gplx_21;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import androidvnua.vnua.listtraffic.TrafficSign;
import androidvnua.vnua.CauTraLoiSai.MainActivity_CauTraLoiSai;
import androidvnua.vnua.caudiemliet.CauDiemLiet;
import androidvnua.vnua.mucdethi.MainActivity_dethi;
import androidvnua.vnua.database.dbCauHoi;
import androidvnua.vnua.ontapcauhoi.OnTapCauHoi;

public class Home extends AppCompatActivity {

    //  Khai báo button
    ConstraintLayout
            btnThiThu,
            btnCauDiemLiet,
            btnHocBienBao,
            btnCauSai,
            btnOnTap,
            btnMeoThi;

    //Menu bar
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;


    // Database
    private dbCauHoi db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        callbutton();

        // Menu
        renderMenu();

        // Database (Khởi tạo và tạo bảng)
        connectDB();
    }

    //  Ánh xạ button
    public void callbutton() {
        btnThiThu = findViewById(R.id.btnBatDauThi);
        btnCauDiemLiet = findViewById(R.id.btnCauDiemLiet);
        btnHocBienBao = findViewById(R.id.btnCacBienBao);
        btnCauSai = findViewById(R.id.btnCauSai);
        btnOnTap = findViewById(R.id.btnThiSaHinh);
        btnMeoThi = findViewById(R.id.btnMeoThi);
    }

    // Đóng ứng dụng
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                diaLog("Bạn muốn đóng ứng dụng?", 1);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void diaLog(String title, int option) {
        //Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(false);
        //Thiết lập tiêu đề
        b.setTitle("Xác nhận");
        b.setMessage(title);
        // Nút Ok
        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (option == 1) {
                    Home.this.finishAffinity();
                }
            }
        });
        //Nút Cancel
        b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        //Tạo dialog
        AlertDialog al = b.create();
        //Hiển thị
        al.show();
    }

    //  Hàm sự kiện Click
    public void onClick(View v) {
        if (v == btnThiThu) {
            Intent intent = new Intent(Home.this, MainActivity_dethi.class);
            startActivity(intent);
        }else if (v == btnCauDiemLiet) {
            Intent intent = new Intent(Home.this, CauDiemLiet.class);
            startActivity(intent);
        }else if (v == btnCauSai) {
            Intent intent = new Intent(Home.this, MainActivity_CauTraLoiSai.class);
            startActivity(intent);
        }else if (v == btnHocBienBao) {
            Intent intent = new Intent(Home.this, TrafficSign.class);
            startActivity(intent);
        }else if (v == btnOnTap) {
            Intent intent = new Intent(Home.this, OnTapCauHoi.class);
            startActivity(intent);
        }else if (v == btnMeoThi) {
            Intent intent = new Intent(Home.this, Tutorial.class);
            startActivity(intent);
        }
    }

    // Hàm menu
    private void renderMenu() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navc_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(Home.this, drawerLayout, toolbar, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    // Khởi tạo, tạo tạo bảng database
    private void connectDB() {
        db = new dbCauHoi(this, "CauHoiDataBase.sqlite", null, 1);
    }
}