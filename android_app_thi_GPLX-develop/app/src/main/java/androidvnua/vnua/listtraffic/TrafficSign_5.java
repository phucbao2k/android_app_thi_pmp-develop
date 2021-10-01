package androidvnua.vnua.listtraffic;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import androidvnua.vnua.thi_gplx_21.R;


public class TrafficSign_5 extends AppCompatActivity {

    ListView listView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_sign5);
        listView5=findViewById(R.id.listView5);

        int[] image = { R.drawable.bienbao41, R.drawable.bienbao42, R.drawable.bienbao43, R.drawable.bienbao44, R.drawable.bienbao45,
                        R.drawable.bienbao46, R.drawable.bienbao47, R.drawable.bienbao48, R.drawable.bienbao49, R.drawable.bienbao50};

        String[] name = {"Phạm vi tác dụng của biển","Khoảng cách đến đối tượng báo hiệu","Hướng tác dụng của biển","Hướng tác dụng của biển","Hướng tác dụng của biển",
                         "Hướng tác dụng của biển","Hướng tác dụng của biển","Hướng tác dụng của biển","Làn đường","Loại xe"};

        String[] des = {"Để thông báo chiều dài đoạn đường nguy hiểm hoặc cấm hoặc hạn chế bên dưới một số biển báo nguy hiểm, biển báo cấm hoặc hạn chế, chẳng hạn như: Nhiều chỗ ngoặt nguy hiểm liên tiếp; Dốc xuống nguy hiểm...","Bên dưới các loại biển báo nguy hiểm, biển báo cấm, biển hiệu lệnh và chỉ dẫn, thông báo khoảng cách thực tế từ vị trí đặt biển đến đối tượng báo hiệu ở phía trước","Đặt bên dưới các biển báo cấm, biển hiệu lệnh để chỉ hướng tác dụng của biển là hướng vuông góc với chiều đi","Biển báo đường cấm tất cả các loại oto rẽ trái","Đặt bên dưới các biển báo cấm, biển hiệu lệnh để chỉ hướng tác dụng của biển là hướng vuông góc với chiều đi",
                        "Để chỉ hướng tác dụng của biển là hướng song song với chiều đi","Để chỉ đồng thời 2 hướng tác dụng (xuôi và ngược) của biển báo nhắc lại lệnh cấm dừng và cấm đỗ xe","Để chỉ hướng tác dụng của biển là hướng song song với chiều đi.","Biển được đặt bên dưới các biển báo cấm và biển hiệu lệnh hay bên dưới đèn hiệu để chỉ làn đường chịu hiệu lực của biển (hay đèn hiệu) báo lệnh cấm - và hiệu lệnh trên làn đường đó","Biển được đặt bên dưới các biển báo cấm và biển hiệu lệnh hay biển chỉ dẫn để chỉ loại xe chịu hiệu lực của biển báo cấm, biển hiệu lệnh hay biển chỉ dẫn đối với riêng loại xe đó"};

        ArrayList<Traffic> TrafficArrayList = new ArrayList<>();
        for(int i = 0;i< image.length;i++){

            Traffic traffic = new Traffic(name[i],des[i],image[i]);
            TrafficArrayList.add(traffic);

        }

        Adapter adapter=new Adapter(this, R.layout.list_row,TrafficArrayList);
        listView5.setAdapter(adapter);
        listView5.setClickable(true);
        listView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(TrafficSign_5.this,TrafficInfor.class);
                i.putExtra("name",name[position]);
                i.putExtra("des",des[position]);
                i.putExtra("image",image[position]);
                startActivity(i);

            }
        });


    }

}