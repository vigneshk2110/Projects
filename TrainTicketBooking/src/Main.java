import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        initialize();
        // TODO Auto-generated method stub
    }
    public static void initialize()
    {
        Train tr=new Train();
        Coach coach1=new Coach(1);
        Cabin c1=new Cabin(1);
        Cabin c2=new Cabin(2);
        Cabin c3=new Cabin(3);
        coach1.addCabin(c1);
        coach1.addCabin(c2);
        coach1.addCabin(c3);
        tr.addCoach(coach1);

        Coach coach2=new Coach(2);
        Cabin c4=new Cabin(1);
        Cabin c5=new Cabin(2);
        coach2.addCabin(c4);
        coach2.addCabin(c5);
        tr.addCoach(coach2);

        System.out.println(tr.getCoachs().get(1));
//
//        System.out.println(c2.getBerths());
        while(true)
        {
            System.out.println("1.Initialization");
            System.out.println("2.Book ticket");
            System.out.println("3.Print details for PNR");
            System.out.println("4.Book Group ticket");

            int action = sc.nextInt();
            if(action==1)
            {
                for(Map.Entry<Integer, Coach> coach: tr.coachs.entrySet())
                {
                    for(Map.Entry<Integer, Cabin> cabin: coach.getValue().getCabins().entrySet())
                    {
                        for(Map.Entry<String, Berth> berth: cabin.getValue().getBerths().entrySet())
                        {
                            System.out.println(berth.getValue().getPNR()+" "+berth.getValue().getBerthNo()+" "+berth.getValue().getType()+" "+berth.getValue().getStatus()+" "+berth.getValue().getName()+" "+berth.getValue().getAge());
                        }
                    }
                }
            }

            else if (action==2)
            {
                HashMap<Integer,Coach> coachHashMap= tr.coachs;
                for(int i=0;i<coachHashMap.size();i++)
                {
                    Coach coach=coachHashMap.get(i+1) ;
                    System.out.println(coach);
                }
            }

        }


    }

}
