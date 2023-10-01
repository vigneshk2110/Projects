import java.util.*;
public class Cabin
{
    private int cabinNo;
    private HashMap<String,Berth> berths=new HashMap<String,Berth>();

    public Cabin(int n)
    {
        this.cabinNo=n;
        int i=(n*8)-7;
        Berth b=new Berth("--",i,"AVL","LB","--",0);
        berths.put(b.getType()+"_"+b.getBerthNo(),b);

        b=new Berth("--",i+1,"AVL","MB","--",0);
        berths.put(b.getType()+"_"+b.getBerthNo(),b);

        b=new Berth("--",i+2,"AVL","UB","--",0);
        berths.put(b.getType()+"_"+b.getBerthNo(),b);

        b=new Berth("--",i+3,"AVL","LB","--",0);
        berths.put(b.getType()+"_"+b.getBerthNo(),b);

        b=new Berth("--",i+4,"AVL","MB","--",0);
        berths.put(b.getType()+"_"+b.getBerthNo(),b);

        b=new Berth("--",i+5,"AVL","UB","--",0);
        berths.put(b.getType()+"_"+b.getBerthNo(),b);

        b=new Berth("--",i+6,"--","RAC1","--",0);
        berths.put(b.getType()+"_"+b.getBerthNo(),b);

        b=new Berth("--",i+6,"--","RAC2","--",0);
        berths.put(b.getType()+"_"+b.getBerthNo(),b);

        b=new Berth("--",0,"--","WL","--",0);
        berths.put(b.getType(),b);
    }

    public int getCabinNo() {
        return cabinNo;
    }

    public void setCabinNo(int cabinNo) {
        this.cabinNo = cabinNo;
    }

    public HashMap<String, Berth> getBerths() {
        return berths;
    }

    public void setBerths(HashMap<String, Berth> berths) {
        this.berths = berths;
    }

}
