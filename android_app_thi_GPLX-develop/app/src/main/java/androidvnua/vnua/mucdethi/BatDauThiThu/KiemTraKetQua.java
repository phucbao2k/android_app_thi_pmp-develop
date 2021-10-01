package androidvnua.vnua.mucdethi.BatDauThiThu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import androidvnua.vnua.mucdethi.MainActivity_dethi;
import androidvnua.vnua.thi_gplx_21.Home;
import androidvnua.vnua.thi_gplx_21.R;

public class KiemTraKetQua extends AppCompatActivity {

    private String maDe, cauSai;
    private int soCauDung;
    private boolean isPass;
    private TextView txtDiem, txtMsg, txtMsg2, txtPass;
    private ImageView imgKetQua;
    private Button btnBackHome, btnContinue;

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiem_tra_ket_qua);
        Intent intent = getIntent();
        maDe = intent.getStringExtra("ma_de");
        soCauDung = intent.getIntExtra("so_cau_dung", 0);
        cauSai = intent.getStringExtra("cau_sai");
        isPass = intent.getBooleanExtra("isPass", false);

        anhxa();
        txtDiem.setText("Điểm của bạn là: "+soCauDung+"/20");
        if (isPass) {
            txtPass.setVisibility(View.GONE);
            if (soCauDung >= 16) {
                imgKetQua.setImageResource(R.drawable.winner);
                txtMsg.setTextColor(Color.GREEN);
                txtMsg.setText("Bạn đã thi đậu");
                randomMsgSuccess();
            } else {
                imgKetQua.setImageResource(R.drawable.book);
                txtMsg.setTextColor(Color.RED);
                txtMsg.setText("Bạn đã trượt");
                randomMsgFailed();
            }
        } else {
            imgKetQua.setImageResource(R.drawable.book);
            txtMsg.setTextColor(Color.RED);
            txtMsg.setText("Bạn đã trượt");
            txtPass.setText("(Sai câu điểm liệt)");
            randomMsgFailed();
        }

        BtnBack();
    }

    // Xử lý khi người dùng click quay trở lại trên thanh cứng android
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent = new Intent(KiemTraKetQua.this, Home.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void anhxa() {
        txtMsg2 = findViewById(R.id.txtMsg2);
        txtDiem = findViewById(R.id.txtDiem);
        txtPass = findViewById(R.id.txtIsPass);
        txtMsg = findViewById(R.id.txtMsg);
        imgKetQua = findViewById(R.id.imgKetQua);
        btnBackHome = findViewById(R.id.btnHome);
        btnContinue = findViewById(R.id.btnContinue);
    }

    private void randomMsgSuccess() {
        Random random = new Random();
        int randomMsg = random.nextInt(5)+1;
        switch (randomMsg) {
            case 1:
                txtMsg2.setText("Hãy không ngừng nỗ lực nổ đạt kết quả cao nhất bạn nhé!");
                break;
            case 2:
                txtMsg2.setText("Chúc mừng bạn!");
                break;
            case 3:
                txtMsg2.setText("Vnua team sẽ giúp bạn vượt qua kì thi sắp tới!");
                break;
            case 4:
                txtMsg2.setText("Hãy ôn tập thật tốt nhé!");
                break;
            default:
                txtMsg2.setText("Cố lên nào!");
        }
    }

    private void randomMsgFailed() {
        Random random = new Random();
        int randomMsg = random.nextInt(5)+1;
        switch (randomMsg) {
            case 1:
                txtMsg2.setText("Không sao cả hãy cố hết sức nào!");
                break;
            case 2:
                txtMsg2.setText("Bạn nên ôn tập lại kiến thức!");
                break;
            case 3:
                txtMsg2.setText("Có lẽ kiến thức của bạn vẫn còn thiếu!");
                break;
            case 4:
                txtMsg2.setText("Hãy ôn tập thật tốt nhé!");
                break;
            default:
                txtMsg2.setText("Chỉ là thi thử thôi cố gắng lên nào!");
        }
    }

    private void BtnBack() {
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KiemTraKetQua.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KiemTraKetQua.this, MainActivity_dethi.class);
                startActivity(intent);
                finish();
            }
        });
    }
}