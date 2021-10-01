package androidvnua.vnua.listtraffic;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidvnua.vnua.CauTraLoiSai.MainActivity_CauTraLoiSai;
import androidvnua.vnua.thi_gplx_21.Home;
import androidvnua.vnua.thi_gplx_21.R;

public class TrafficInfor extends AppCompatActivity {
    TextView nameTraffic;
    TextView desTraffic;
    ImageView imgTraffic, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_infor);

        Intent intent = this.getIntent();

        if (intent != null) {

            String name = intent.getStringExtra("name");
            String des = intent.getStringExtra("des");
            int image = intent.getIntExtra("image", R.drawable.bienbao1);

            nameTraffic = findViewById(R.id.nameTraffic);
            desTraffic = findViewById(R.id.desTraffic);
            imgTraffic = findViewById(R.id.imgTraffic);
            btnBack = findViewById(R.id.btnBackTfInfo);

            nameTraffic.setText(name);
            desTraffic.setText(des);
            imgTraffic.setImageResource(image);

            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}