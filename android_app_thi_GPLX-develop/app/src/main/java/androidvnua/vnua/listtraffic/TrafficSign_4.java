package androidvnua.vnua.listtraffic;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import androidvnua.vnua.thi_gplx_21.R;


public class TrafficSign_4 extends AppCompatActivity {

    ListView listView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_sign4);
        listView4=findViewById(R.id.listView4);

        int[] image = { R.drawable.bienbao16, R.drawable.bienbao17, R.drawable.bienbao18, R.drawable.bienbao19, R.drawable.bienbao20,
                        R.drawable.bienbao21, R.drawable.bienbao22, R.drawable.bienbao23, R.drawable.bienbao24, R.drawable.bienbao25};

        String[] name = {"Gió ngang","Nguy hiểm khác","Giao nhau với đường hai chiều","Hết đường đôi","Cầu vòng",
                         "Đường cao tốc phía trước"," Đường cáp điện ở phía trên","Đường hầm","Ùn tắc giao thông","Đi chậm"};

        String[] des = {"Để báo trước gần tới đoạn đường thường có gió ngang thổi mạnh nguy hiểm. Người lái xe cần phải điều chỉnh tốc độ xe chạy cho thích hợp, đề phòng tình huống gió thổi lật xe","Để báo trên đường có những nguy hiểm khác","Trên đường một chiều, biển này để báo trước sắp đến chỗ giao nhau với đường hai chiều","Để báo trước sắp kết thúc đoạn đường đôi (đoạn đường hết giải phân cách). Đường đôi chỉ được chia bằng vạch sơn không phải đặt biển này","Biển báo đường cấm tất cả các loại oto rẽ trái","Dùng để nhắc nhở lái xe cho cẩn thận. Biển đặt ở nơi thích hợp trên đoạn đường sắp sửa đến chiếc cầu có độ vồng rất lớn ảnh hưởng tới tầm nhìn",
                        "Biển này nhằm để báo cho các phương tiện đi trên đường biết có \"Đường cao tốc phía trước"," Biển này để cảnh báo nơi có đường dây điện cắt ngang phía trên tuyến đường, thường kèm theo biển phụ 509 \"Chiều cao an toàn\" ở phía dưới","Dùng để nhắc lái xe chú ý đi chậm lại, biển đặt ở nơi thích hợp mà đường sắp sửa đi vào đường hầm chạy hai chiều, mà chiếu sáng lại không tốt","Báo đoạn đường hay xảy ra ùn tắc giao thông"," Dùng để nhắc lái xe giảm tốc độ đi chậm. Biển đặt ở vị trí thích đáng trước khi đến đoạn đường yêu cầu đi chậm"};

        ArrayList<Traffic> TrafficArrayList = new ArrayList<>();
        for(int i = 0;i< image.length;i++){

            Traffic traffic = new Traffic(name[i],des[i],image[i]);
            TrafficArrayList.add(traffic);

        }

        Adapter adapter=new Adapter(this, R.layout.list_row,TrafficArrayList);
        listView4.setAdapter(adapter);
        listView4.setClickable(true);
        listView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(TrafficSign_4.this,TrafficInfor.class);
                i.putExtra("name",name[position]);
                i.putExtra("des",des[position]);
                i.putExtra("image",image[position]);
                startActivity(i);

            }
        });


    }

}