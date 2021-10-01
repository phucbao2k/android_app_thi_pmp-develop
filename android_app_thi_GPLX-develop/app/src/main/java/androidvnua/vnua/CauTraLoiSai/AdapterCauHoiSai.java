package androidvnua.vnua.CauTraLoiSai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import androidvnua.vnua.thi_gplx_21.R;

public class AdapterCauHoiSai extends RecyclerView.Adapter<AdapterCauHoiSai.CauHoiSaiViewHolder>{

    Context context;
    List<ObjCauTraLoiSai> mList;

    public AdapterCauHoiSai(Context context, List<ObjCauTraLoiSai> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public CauHoiSaiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_cauhoisai, parent, false);
        return new CauHoiSaiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterCauHoiSai.CauHoiSaiViewHolder holder, int position) {
        ObjCauTraLoiSai objCauTraLoiSai = mList.get(position);
        if (objCauTraLoiSai == null) {
            return;
        }
        holder.tvCauHoiSai.setText(objCauTraLoiSai.getCauHoiSai());
        holder.tvId.setText("Mã câu: " + objCauTraLoiSai.getIdCauHoiSai());
        holder.tvDapAn.setText("Đáp án đúng: " + objCauTraLoiSai.getDapAn());
    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    public class CauHoiSaiViewHolder extends RecyclerView.ViewHolder {

        TextView tvCauHoiSai, tvId, tvDapAn;

        public CauHoiSaiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCauHoiSai = itemView.findViewById(R.id.tv_cauhoisai);
            tvId = itemView.findViewById(R.id.tv_id);
            tvDapAn = itemView.findViewById(R.id.tv_dapan);
        }
    }
}
