import java.util.HashMap;
import java.util.LinkedHashMap;

public class Coach
{
    private int coachNo;
    private HashMap<Integer,Cabin> cabins=new LinkedHashMap<Integer,Cabin>();

    public Coach(int n)
    {
        this.coachNo=n;
    }

    public int getCoachNo() {
        return coachNo;
    }

    public void setCoachNo(int coachNo) {
        this.coachNo = coachNo;
    }

    public HashMap<Integer, Cabin> getCabins() {
        return cabins;
    }

    public void setCabins(HashMap<Integer, Cabin> cabins) {
        this.cabins = cabins;
    }

    public void addCabin(Cabin c)
    {
        this.cabins.put(c.getCabinNo(), c);
    }
}
