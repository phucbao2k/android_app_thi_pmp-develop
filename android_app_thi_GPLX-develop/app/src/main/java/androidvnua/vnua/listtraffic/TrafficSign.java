package androidvnua.vnua.listtraffic;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import androidvnua.vnua.thi_gplx_21.R;


public class TrafficSign extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_sign);
        listView=findViewById(R.id.listView);

        int [] image={R.drawable.bienbao1, R.drawable.bienbao10, R.drawable.bienbao34, R.drawable.bienbao16, R.drawable.bienbao41};
        String [] name={"Biển báo cấm","Biển báo hiệu lệnh","Biển báo chỉ dẫn","Biển báo nguy hiểm","Biển báo phụ"};
        String [] des={"Biển báo cấm là đường tròn màu đỏ, nền màu trắng, trên nền có hình vẽ màu đen đặc trưng cho điều cấm hoặc hạn chế sự đi lại",
                       "Biển báo có dạng hình tròn, màu xanh với hình vẽ màu trắng. Chúng đưa ra những hiệu lệnh mà người đi đường phải thực hiện",
                       "Biển báo chỉ dẫn có dạng hình vuông hoặc hình chữ nhật, nền xanh, hình vẽ màu trắng. Biển chỉ dẫn để chỉ dẫn hướng đi hoặc các điều cần biết nhằm thông báo cho những định hướng cần thiết hoặc những điều có ích khác",
                       "Biển báo có dạng hình tam giác đều, viền đỏ, nền màu vàng, trên hình có hình vẽ màu đen mô tả sự việc báo hiệu nhằm báo cho người sử dụng biết trước tính chất nguy hiểm trên đường để có biện pháp phòng ngừa, xử trí",
                       "Biên báo có dạng hình chữ nhật hoặc vuông, các biển phụ đều được đặt ngay phía dưới biển chính trừ biển số S.507 sử dụng độc lập được đặt ở phía lưng đường cong đối diện với hướng đi hoặc đặt ở giữa đảo an toàn nơi đường giao nhau"};

        ArrayList<Traffic> TrafficArrayList = new ArrayList<>();
        for(int i = 0;i< image.length;i++){

            Traffic traffic = new Traffic(name[i],des[i],image[i]);
            TrafficArrayList.add(traffic);

        }

        Adapter adapter=new Adapter(this, R.layout.list_row,TrafficArrayList);
        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(TrafficSign.this, TrafficSign_1.class);
                    startActivity(intent);
                }
                if (position==1){

                    Intent intent=new Intent(TrafficSign.this, TrafficSign_2.class);
                    startActivity(intent);
                }
                if (position==2){
                    Intent intent=new Intent(TrafficSign.this, TrafficSign_3.class);
                    startActivity(intent);
                }
                if (position==3){
                    Intent intent=new Intent(TrafficSign.this, TrafficSign_4.class);
                    startActivity(intent);
                }
                if (position==4){
                    Intent intent=new Intent(TrafficSign.this, TrafficSign_5.class);
                    startActivity(intent);
                }



            }
        });

    }

}