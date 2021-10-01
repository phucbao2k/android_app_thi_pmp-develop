package androidvnua.vnua.listtraffic;

public class Traffic {

    String name, des;
    int image;

    public Traffic(String name, String des, int image) {
        this.name = name;
        this.des = des;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
    public String getDes() {
        return des;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setImage(int image) {
        this.image = image;
    }
}