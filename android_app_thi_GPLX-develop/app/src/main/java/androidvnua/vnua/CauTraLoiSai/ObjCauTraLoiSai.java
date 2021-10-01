package androidvnua.vnua.CauTraLoiSai;

public class ObjCauTraLoiSai {
    private String CauHoiSai, dapAn;
    private int IdCauHoiSai;

    public ObjCauTraLoiSai(String cauHoiSai, String dapAn, int idCauHoiSai) {
        CauHoiSai = cauHoiSai;
        this.dapAn = dapAn;
        IdCauHoiSai = idCauHoiSai;
    }

    public String getCauHoiSai() {
        return CauHoiSai;
    }

    public void setCauHoiSai(String cauHoiSai) {
        CauHoiSai = cauHoiSai;
    }

    public String getDapAn() {
        return dapAn;
    }

    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }

    public int getIdCauHoiSai() {
        return IdCauHoiSai;
    }

    public void setIdCauHoiSai(int idCauHoiSai) {
        IdCauHoiSai = idCauHoiSai;
    }
}
