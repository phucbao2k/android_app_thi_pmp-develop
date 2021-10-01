package androidvnua.vnua.caudiemliet;

public class ListQuesPass {
    private String Ques;
    private String A;
    private String B;
    private String C;
    private String D;
    private String Ans;
    private int HinhAnh;

    public ListQuesPass(String ques, String a, String b, String c, String d, String ans, int hinhanh) {
        Ques = ques;
        A = a;
        B = b;
        C = c;
        D = d;
        Ans = ans;
        HinhAnh = hinhanh;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getQues() {
        return Ques;
    }

    public void setQues(String ques) {
        Ques = ques;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getAns() {
        return Ans;
    }

    public void setAns(String ans) {
        Ans = ans;
    }
}
