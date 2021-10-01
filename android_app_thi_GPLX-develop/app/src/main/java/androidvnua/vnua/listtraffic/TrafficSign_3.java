package androidvnua.vnua.listtraffic;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import androidvnua.vnua.thi_gplx_21.R;


public class TrafficSign_3 extends AppCompatActivity {

    ListView listView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_sign3);
        listView3=findViewById(R.id.listView3);

        int[] image = { R.drawable.bienbao27, R.drawable.bienbao28, R.drawable.bienbao29, R.drawable.bienbao30, R.drawable.bienbao31,
                        R.drawable.bienbao32, R.drawable.bienbao33, R.drawable.bienbao34, R.drawable.bienbao35, R.drawable.bienbao36,
                        R.drawable.bienbao37};

        String[] name = {"Bắt đầu đường ưu tiên","Hết đường ưu tiên","Đường cụt","Đường cụt","Nơi đỗ xe",
                         "Đường cụt","Được ưu tiên qua đường hẹp","Đường một chiều","Nơi đỗ xe trên hè phố","Chỗ quay xe",
                         "Khu vực quay xe"};

        String[] des = {"Chi tiết báo hiệu: Để biểu thị ưu tiên cho các phương tiện trên đường có đặt biển này được đi trước. Biển đặt tại vị trí thích hợp trước khi đường nhánh sắp nhập vào trục đường chính, yêu cầu phương tiện từ đường nhánh ra phải dừng lại nhường cho phương tiện trên đường chính đi trước","Chi tiết báo hiệu: Báo hiệu hết đoạn đường được ưu tiên","Để chỉ dẫn đường cụt, lối rẽ vào đường cụt phía bên trái","Để chỉ dẫn phía trước là đường cụt, đặt trước đường cụt 300m đến 500m và cứ 100m phải đặt thêm một biển","Biển báo đường cấm tất cả các loại oto rẽ trái","Để chỉ dẫn những nơi được phép đỗ xe, những bãi đỗ xe, bến xe v.v...",
                        "Để chỉ dẫn đường cụt, lối rẽ vào đường cụt phía bên phải ","Để chỉ dẫn cho người lái xe cơ giới biết mình được quyền ưu tiên đi trước trên đoạn đường hẹp. Nếu trên hướng đi ngược chiều có xe (cơ giới hoặc thô sơ) đã đi vào phạm vi đường hẹp  thì xe đi theo chiều ưu tiên cũng phải nhường đường"," Biển đặt sau ngã ba và ngã tư, biển chỉ dẫn những đoạn đường xe chạy một chiều, chỉ cho phép các loại phương tiện giao thông đường bộ đi vào theo chiều mũi tên chỉ (đi thẳng), cấm quay đầu ngược lại (trừ các xe được quyền ưu tiên theo Luật Giao thông đường bộ)"," Biển chỉ dẫn cho người lái xe biết có làn đường dành riêng cho xe ôtô con. Biển được đặt ở đầu đường theo hướng đi của xe ôtô con. Các loại xe khác không được đi vào làn đường có đặt biển này (trừ các xe được quyền ưu tiên theo Luật Giao thông đường bộ.)",
                        "Biển chỉ dẫn khu vực cho phép quay đầu xe kiểu chữ U nhưng không cho phép rẽ trái, trừ các xe được quyền ưu tiên theo Luật Giao thông đường bộ"};

        ArrayList<Traffic> TrafficArrayList = new ArrayList<>();
        for(int i = 0;i< image.length;i++){

            Traffic traffic = new Traffic(name[i],des[i],image[i]);
            TrafficArrayList.add(traffic);

        }

        Adapter adapter=new Adapter(this, R.layout.list_row,TrafficArrayList);
        listView3.setAdapter(adapter);
        listView3.setClickable(true);
        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(TrafficSign_3.this,TrafficInfor.class);
                i.putExtra("name",name[position]);
                i.putExtra("des",des[position]);
                i.putExtra("image",image[position]);
                startActivity(i);

            }
        });


    }

}