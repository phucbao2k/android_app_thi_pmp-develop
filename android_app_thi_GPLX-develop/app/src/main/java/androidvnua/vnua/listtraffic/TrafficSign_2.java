package androidvnua.vnua.listtraffic;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import androidvnua.vnua.thi_gplx_21.R;


public class TrafficSign_2 extends AppCompatActivity {

    ListView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_sign2);
        listView2=findViewById(R.id.listView2);

        int[] image = {R.drawable.bienbao10, R.drawable.bienbao11, R.drawable.bienbao12,
                       R.drawable.bienbao13, R.drawable.bienbao14, R.drawable.bienbao15};

        String[] name = {"Các xe chỉ được rẽ phải","Các xe chỉ được rẽ trái","Các xe chỉ được rẽ phải",
                         "Các xe chỉ được rẽ trái","Các xe chỉ được đi thẳng và phải","Các xe chỉ được đi thẳng và trái"};

        String[] des = {"Được đặt sau ngã ba, ngã tư. Các xe chỉ được rẽ phải ở khu vực trước mặt","Được đặt sau ngã ba, ngã tư. Các xe chỉ được rẽ trái ở khu vực trước mặt", "Được đặt sau ngã ba, ngã tư. Các xe chỉ được rẽ phải ở phạm vi ngã ba, ngã tư đằng sau mặt biển",
                        "Được đặt sau ngã ba, ngã tư. Các xe chỉ được rẽ trái ở phạm vi ngã ba, ngã tư đằng sau mặt biển","Được đặt sau ngã ba, ngã tư. Các xe chỉ được rẽ trái, quay đầu hoặc rẽ phải ở phạm vi ngã ba, ngã tư đằng sau mặt biển", "Được đặt sau ngã ba, ngã tư. Các xe chỉ được rẽ trái, quay đầu hoặc rẽ phải ở phạm vi ngã ba, ngã tư đằng sau mặt biển"};



        ArrayList<Traffic> TrafficArrayList = new ArrayList<>();
        for(int i = 0;i< image.length;i++){

            Traffic traffic = new Traffic(name[i],des[i],image[i]);
            TrafficArrayList.add(traffic);

        }

        Adapter adapter=new Adapter(this, R.layout.list_row,TrafficArrayList);
        listView2.setAdapter(adapter);
        listView2.setClickable(true);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(TrafficSign_2.this,TrafficInfor.class);
                i.putExtra("name",name[position]);
                i.putExtra("des",des[position]);
                i.putExtra("image",image[position]);
                startActivity(i);

            }
        });


    }

}