
public class Berth
{
    private String pNR;
    private int berthNo;
    private String status;
    private String type;
    private String name;
    private int age;




    public Berth(String pNR, int berthNo, String status, String type, String name, int age) {
        super();
        this.pNR = pNR;
        this.berthNo = berthNo;
        this.status = status;
        this.type = type;
        this.name = name;
        this.age = age;
    }
    public String getPNR() {
        return pNR;
    }
    public void setPNR(String pNR) {
        this.pNR = pNR;
    }
    public int getBerthNo() {
        return berthNo;
    }
    public void setBerthNo(int berthNo) {
        this.berthNo = berthNo;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


}
