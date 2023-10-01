import java.util.*;
public class Train
{
    HashMap<Integer,Coach>coachs=new LinkedHashMap<Integer,Coach>();

    public HashMap<Integer, Coach> getCoachs() {
        return coachs;
    }

    public void setCoachs(HashMap<Integer, Coach> coachs) {
        this.coachs = coachs;
    }

    public void addCoach(Coach c)
    {
        this.coachs.put(c.getCoachNo(), c);
    }
}
