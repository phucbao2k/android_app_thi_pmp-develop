package androidvnua.vnua.CauTraLoiSai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidvnua.vnua.caudiemliet.CauDiemLiet;
import androidvnua.vnua.database.dbCauHoi;
import androidvnua.vnua.thi_gplx_21.Home;
import androidvnua.vnua.thi_gplx_21.R;

public class MainActivity_CauTraLoiSai extends AppCompatActivity {

    private RecyclerView rcv;
    private View layoutMsg;
    private AdapterCauHoiSai adapterCauHoiSai;
    private ArrayList<ObjCauTraLoiSai> arrayList;
    private dbCauHoi db;
    private ImageView btnBack, btnHelp, btnDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cau_tra_loi_sai);

        // kết nối db
        connectDB();

        // ánh xạ
        init ();

        // Khởi tạo hàm + adapter
        InitArrayAndAdapter();
        click();
    }

    private void connectDB() {
        db = new dbCauHoi(this, "CauHoiDataBase.sqlite", null, 1);
    }

    private void init () {
        rcv = (RecyclerView) findViewById(R.id.rcv);
        layoutMsg = findViewById(R.id.layoutErMsg);
        btnBack = findViewById(R.id.btnBackEr);
        btnHelp = findViewById(R.id.btnTutorialEr);
        btnDel = findViewById(R.id.btnDelEr);
    }

    private void InitArrayAndAdapter() {
        arrayList = new ArrayList<>();

        // add item từ database
        arrayList.clear();
        addArrayList();
        if (arrayList.size() >= 1) {
            rcv.setVisibility(View.VISIBLE);
            layoutMsg.setVisibility(View.GONE);
            adapterCauHoiSai = new AdapterCauHoiSai(this, arrayList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            rcv.setLayoutManager(linearLayoutManager);
            rcv.setAdapter(adapterCauHoiSai);
        } else {
            layoutMsg.setVisibility(View.VISIBLE);
            rcv.setVisibility(View.GONE);
        }
    }

    private void addArrayList () {
        Cursor cursorCauHoiSai = db.GetData("SELECT * FROM CauHoiSai");
        while (cursorCauHoiSai.moveToNext()) {
            int id = cursorCauHoiSai.getInt(0);
            int idCauHoiSai = cursorCauHoiSai.getInt(1);

            Cursor cursorCauHoi = db.GetData("SELECT * FROM CauHoi WHERE ID = '"+idCauHoiSai+"'");
            while (cursorCauHoi.moveToNext()) {
                int idCauHoi = cursorCauHoi.getInt(0);
                String CauHoi = cursorCauHoi.getString(1);
                String dapAn = cursorCauHoi.getString(8);
                String textDapAn ="";
                if (dapAn.equals("A")) {
                    textDapAn = cursorCauHoi.getString(2);
                } else if (dapAn.equals("B")) {
                    textDapAn = cursorCauHoi.getString(3);
                } else if (dapAn.equals("C")) {
                    textDapAn = cursorCauHoi.getString(4);
                } else if (dapAn.equals("D")) {
                    textDapAn = cursorCauHoi.getString(5);
                }
                String value = dapAn +". "+ textDapAn;
                arrayList.add(new ObjCauTraLoiSai(CauHoi.trim(), value.trim(), idCauHoi));
            }
            System.out.println("Câu hỏi sai là: " + idCauHoiSai);
        }
    }

    private void click() {
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity_CauTraLoiSai.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_tutorial);
                TextView title = dialog.findViewById(R.id.txtTitleTutorial);
                TextView text = dialog.findViewById(R.id.txtTutorial);

                title.setText("Chú ý!");
                text.setText("Đây là phần những câu bạn đã trả lời sai, hãy ôn tập lại những kiến thức này!");

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

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrayList.size() >=1 ) {
                    diaLog("Bạn có muốn xóa danh sách các câu đã trả lời sai không?");
                } else {
                    Toast.makeText(MainActivity_CauTraLoiSai.this, "Không có gì để xóa cả :((", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void diaLog(String title) {
        //Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(false);
        //Thiết lập tiêu đề
        b.setTitle("Xác nhận");
        b.setMessage(title);
        // Nút Ok
        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                db.QueryData("Delete from CauHoiSai");
                InitArrayAndAdapter();
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
}