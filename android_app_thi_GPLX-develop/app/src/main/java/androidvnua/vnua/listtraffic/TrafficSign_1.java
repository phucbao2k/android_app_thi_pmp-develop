package androidvnua.vnua.listtraffic;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import androidvnua.vnua.thi_gplx_21.R;


public class TrafficSign_1 extends AppCompatActivity {

    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_sign1);
        listView1=findViewById(R.id.listView1);

        int[] image = { R.drawable.bienbao1, R.drawable.bienbao2, R.drawable.bienbao3, R.drawable.bienbao4, R.drawable.bienbao5,
                        R.drawable.bienbao6, R.drawable.bienbao7, R.drawable.bienbao8, R.drawable.bienbao9};

        String[] name = {"Đường cấm","Cấm đi ngược chiều","Cấm oto","Cấm oto rẽ phải","Cấm oto rẽ trái",
                         "Cấm moto","Cấm oto và moto","Cấm oto tải","Cấm oto tải theo trọng lượng"};

        String[] des = {"Biển báo đường cấm tất cả các loại phương tiện tham gia giao thông đi lại cả hai hướng","Biển báo đường cấm tất cả các loại phương tiện tham gia giao thông đi ngược chiều","Biển báo đường cấm tất cả các loại oto","Biển báo đường cấm tất cả các loại oto rẽ phải","Biển báo đường cấm tất cả các loại oto rẽ trái","Biển cấm tất cả các xe máy thồ đi qua",
                        "Biển báo đường cấm tất cả các loại moto đi qua, trừ các loại moto được ưu tiên theo luật giao thông đường bộ","Biển báo đường cấm tất cả các loại xe cơ giới đi qua, trừ các loại moto được ưu tiên theo luật giao thông đường bộ","Biển báo đường cấm tất cả các loại otot tải đi qua, trừ các loại moto được ưu tiên theo luật giao thông đường bộ","Trọng lượng được tính theo tấn ghi trên biển"};

        ArrayList<Traffic> TrafficArrayList = new ArrayList<>();
        for(int i = 0;i< image.length;i++){

            Traffic traffic = new Traffic(name[i],des[i],image[i]);
            TrafficArrayList.add(traffic);

        }

        Adapter adapter=new Adapter(this, R.layout.list_row,TrafficArrayList);
        listView1.setAdapter(adapter);
        listView1.setClickable(true);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(TrafficSign_1.this,TrafficInfor.class);
                i.putExtra("name",name[position]);
                i.putExtra("des",des[position]);
                i.putExtra("image",image[position]);
                startActivity(i);

            }
        });


    }

}