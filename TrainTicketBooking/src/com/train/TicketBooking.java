package com.train;

import java.util.*;

public class TicketBooking {
    static  Scanner sc= new Scanner(System.in);
    static HashMap<Integer,ArrayList<Object>> customerDetails= new HashMap<>();
    static int PNRnumber=45000;
    static ArrayList<Integer> waitingList= new ArrayList<>();
    static ArrayList<Integer> racList= new ArrayList<>();
    public static void main(String[] args) {

        Train train= new Train();

        Coach firstCoach= new Coach(1);

        Cabin cabin1= new Cabin(1);

        firstCoach.addCabin(cabin1);

        train.addCoach(firstCoach);

        HashMap<Integer,Coach> trainHashMap= train.coaches;
        System.out.println();
        System.out.println("           Welcome to train ticket booking application");
        while (true)
        {
            System.out.println("1.Initialization");
            System.out.println("2.Book ticket");
            System.out.println("3.Get PNR details");
            System.out.println("4.Book group PNR");
            System.out.println("5.Cancel ticket");
            System.out.println("6.Add new cabin");
            System.out.println("7.Add new coach");
            int action = sc.nextInt();
            switch (action)
            {
                case 1:
                    initialization(trainHashMap);
                    break;
                case 2:
                    bookTicket(trainHashMap,-1,-1);
                    break;
                case 3:
                    getPNRdetails(trainHashMap);
                    break;
                case 4:
                    bookGroupTicket(trainHashMap);
                    break;
                case 5:
                    cancelTicket(trainHashMap);
                    break;
                case 6:
                    addCabin(trainHashMap);
                    break;
                case 7:
                    addCoach(trainHashMap);
                    break;
            }
        }
    }

    private static void addCoach(HashMap<Integer, Coach> trainHashMap) {

        System.out.print("Enter number of Coaches to add : ");
        int numOfCoaches= sc.nextInt();
        int previousCoaches=trainHashMap.size();
        for(int i=previousCoaches+1;i<=previousCoaches+numOfCoaches;i++)
        {
            Coach coach= new Coach(i);
            Cabin cabin= new Cabin(1);
            coach.addCabin(cabin);
            trainHashMap.put(i,coach);
        }
    }

    private static void addCabin(HashMap<Integer, Coach> trainHashMap) {
        System.out.println("Enter the coach number to add cabin");
        int coach= sc.nextInt();
        if(trainHashMap.get(coach)!=null)
        {
            System.out.print("Enter number of cabins to add : ");
            int numOfCabins= sc.nextInt();
            int previousCabins=trainHashMap.get(coach).cabins.size();
            for(int i=previousCabins+1;i<=previousCabins+numOfCabins;i++)
            {
                Cabin cabin= new Cabin(i);
                trainHashMap.get(coach).cabins.put(cabin.cabinNumber,cabin);
            }
        }
        else {
            System.out.println("Your entered coach is not available");
        }
    }

    private static void cancelTicket(HashMap<Integer, Coach> trainHashMap) {

        System.out.print("Enter your pnr number to cancel : ");
        int pnrNumber = sc.nextInt();
        if(customerDetails.get(pnrNumber)!=null)
        {
            for(int i=0;i<customerDetails.get(pnrNumber).size();i++)
            {
                System.out.println(customerDetails.get(pnrNumber));

                HashMap<String,Object> map= (HashMap<String, Object>) customerDetails.get(pnrNumber).get(i);
                int coach= (int) map.get("Coach");
                int cabin= (int) map.get("Cabin");
                int berthNumber= (int) map.get("berthNumber");
                String  berthType= (String) map.get("berthType");
                Berth b= new Berth(0,berthNumber,berthType,"AVL","--",0);
                trainHashMap.get(coach).cabins.get(cabin).berths.put(berthType+"_"+berthNumber,b);
            }

        }
        else {
            System.out.println("Your entered pnr is not available");
        }

//        if(racList.size()>0)
//        {
//            cancelWaitingListTicket(trainHashMap,racList.get(0));
//            bookTicket(trainHashMap,0,racList.get(0));
//            racList.remove(0);
//            if(waitingList.size()>0)
//            {
//                cancelWaitingListTicket(trainHashMap,waitingList.get(0));
//                bookTicket(trainHashMap,0,waitingList.get(0));
//                waitingList.remove(0);
//            }
//        }
//        if(waitingList.size()>0)
//        {
//            cancelWaitingListTicket(trainHashMap,waitingList.get(0));
//            bookTicket(trainHashMap,0,waitingList.get(0));
//            waitingList.remove(0);
//        }

    }
    private static void cancelWaitingListTicket(HashMap<Integer, Coach> trainHashMap, int pnrNumber) {
        for(int i=0;i<customerDetails.get(PNRnumber).size();i++)
        {
            HashMap<String,Object> map= (HashMap<String, Object>) customerDetails.get(PNRnumber).get(i);
            int coach= (int) map.get("Coach");
            int cabin= (int) map.get("Cabin");
            int berthNumber= (int) map.get("berthNumber");
            String  berthType= (String) map.get("berthType");
            Berth b= new Berth(0,berthNumber,berthType,"AVL","--",0);
            trainHashMap.get(coach).cabins.get(cabin).berths.put(berthType+"_"+berthNumber,b);
        }
    }

    private static void bookGroupTicket(HashMap<Integer, Coach> trainHashMap) {

        System.out.println("Enter the number of tickets to book");
        int numOfTickets = sc.nextInt();
        PNRnumber++;
        for(int i=0;i<numOfTickets;i++)
        {
            bookTicket(trainHashMap,PNRnumber,-1);
        }
    }

    private static void getPNRdetails(HashMap<Integer, Coach> trainHashMap) {
        System.out.print("Enter your Pnr : ");
        int pnr = sc.nextInt();
        int count=0;
        if(customerDetails.get(pnr)!=null)
        {
            for(int i=0;i<customerDetails.get(pnr).size();i++)
            {
                    System.out.println("Pnr    Name   age  BerthType   BerthNumber    Status");
                    HashMap<String, Object> data= (HashMap<String, Object>) customerDetails.get(pnr).get(i);
                    System.out.println(pnr+"    "+data.get("name")+"   "+data.get("age")+"   "+data.get("berthType")+"    "+data.get("berthNumber")+"   "+data.get("status"));

            }
        }

        else
        {
            System.out.println("Your PNR is not available");
        }
        System.out.println("===========================================================================");
    }

    private static void bookTicket(HashMap<Integer, Coach> trainHashMap,int groupPnr,int waitingListPnr) {
        String customerName="";
        int customerAge=0;
        String berthPreference = "";
        String bookAny="n";
        String rac="n";
        String wl="n";

        if(waitingListPnr!=-1)
        {
            for(int i=0;i<customerDetails.get(waitingListPnr).size();i++)
            {
                HashMap<String, Object> data = (HashMap<String, Object>) customerDetails.get(waitingListPnr).get(i);
                customerName = (String) data.get("name");
                customerAge = (int) data.get("age");
                bookAny = "y";
            }
        }
        else
        {
            System.out.print("Enter your name : ");
            customerName= sc.next();
            System.out.print("Enter your age : ");
            customerAge=sc.nextInt();
            System.out.print("Enter your berth preference (LB/UB/MB) : ");
            berthPreference= sc.next();
        }
        
        int permission=0;
        
        loop: while (true)
        {
            for(Map.Entry<Integer,Coach> coaches: trainHashMap.entrySet())
            {
                for(Map.Entry<Integer,Cabin> cabins: coaches.getValue().cabins.entrySet())
                {
                    for(Map.Entry<String,Berth> berths: cabins.getValue().berths.entrySet())
                    {
                        Berth berth= berths.getValue();
                        if(berth.berthType.equals(berthPreference) && berth.status.equals("AVL") && !berth.berthType.contains("RAC") && bookAny.equals("n"))
                        {
                            permission++;
                            int i = groupPnr == -1 ? PNRnumber++ : PNRnumber;
                            HashMap<String, Object> details= new HashMap<>();
                            details.put("name",customerName);
                            details.put("age",customerAge);
                            details.put("berthType",berthPreference);
                            details.put("berthNumber",berth.berthNumber);
                            details.put("status","CNF");
                            details.put("Coach",coaches.getKey());
                            details.put("Cabin",cabins.getKey());
                            details.put("Berth",berths.getKey());
//                            customerDetails.put(coaches.getKey()+"_"+cabins.getKey()+"_"+berths.getKey(), details);
                            ArrayList<Object> list=new ArrayList<>();
                            if(customerDetails.get(PNRnumber)!=null)
                            {
                                list= customerDetails.get(PNRnumber);
                                list.add(details);
                            }
                            else {
                                list.add(details);
                            }
                            customerDetails.put(PNRnumber,list);
                            Berth b= new Berth(PNRnumber,berth.berthNumber,berth.berthType,"BOOKED",customerName,customerAge);
                            cabins.getValue().berths.put(berths.getKey(),b);
                            break loop;
                        }
                        else if(bookAny.equals("y") && berth.status.equals("AVL")&& !berth.berthType.contains("RAC")){
                            permission++;
                            int i = groupPnr == -1 ? PNRnumber++ : PNRnumber;
                            HashMap<String, Object> details= new HashMap<>();
                            details.put("name",customerName);
                            details.put("age",customerAge);
                            details.put("berthType",berth.berthType);
                            details.put("berthNumber",berth.berthNumber);
                            details.put("status","CNF");
                            details.put("Coach",coaches.getKey());
                            details.put("Cabin",cabins.getKey());
                            details.put("Berth",berths.getKey());
                            ArrayList<Object> list=new ArrayList<>();
                            if(customerDetails.get(PNRnumber)!=null)
                            {
                                list= customerDetails.get(PNRnumber);
                                list.add(details);
                            }
                            else {
                                list.add(details);
                            }

                            customerDetails.put(PNRnumber,list);
                            Berth b= new Berth(PNRnumber,berth.berthNumber,berth.berthType,"BOOKED",customerName,customerAge);
                            cabins.getValue().berths.put(berths.getKey(),b);
                            break loop;
                        }
                        else if(bookAny.equals("y") && rac.equals("y") && wl.equals("n")&& berth.berthType.contains("RAC") && berth.status.contains("--")){
                            permission++;
                            int i = groupPnr == -1 ? PNRnumber++ : PNRnumber;
                            HashMap<String, Object> details= new HashMap<>();
                            details.put("name",customerName);
                            details.put("age",customerAge);
                            details.put("berthType",berth.berthType);
                            details.put("berthNumber",berth.berthNumber);
                            details.put("status","CNF");
                            details.put("Coach",coaches.getKey());
                            details.put("Cabin",cabins.getKey());
                            details.put("Berth",berths.getKey());
                            ArrayList<Object> list=new ArrayList<>();
                            if(customerDetails.get(PNRnumber)!=null)
                            {
                                list= customerDetails.get(PNRnumber);
                                list.add(details);
                            }
                            else {
                                list.add(details);
                            }
                            customerDetails.put(PNRnumber,list);
                            racList.add(PNRnumber);
                            Berth b= new Berth(PNRnumber,berth.berthNumber,berth.berthType,"BOOKED",customerName,customerAge);
                            cabins.getValue().berths.put(berths.getKey(),b);
                            break loop;
                        }
                        else if(bookAny.equals("y") && rac.equals("y") && wl.equals("y") && berth.berthType.contains("WL") && berth.status.equals("--")){
                            int i = groupPnr == -1 ? PNRnumber++ : PNRnumber;
                            HashMap<String, Object> details= new HashMap<>();
                            details.put("name",customerName);
                            details.put("age",customerAge);
                            details.put("berthType",berth.berthType);
                            details.put("berthNumber",berth.berthNumber);
                            details.put("status","CNF");
                            details.put("Coach",coaches.getKey());
                            details.put("Cabin",cabins.getKey());
                            details.put("Berth",berths.getKey());
                            ArrayList<Object> list=new ArrayList<>();
                            if(customerDetails.get(PNRnumber)!=null)
                            {
                                list= customerDetails.get(PNRnumber);
                                list.add(details);
                            }
                            else {
                                list.add(details);
                            }
                            customerDetails.put(PNRnumber,list);
                            waitingList.add(PNRnumber);
                            Berth b= new Berth(PNRnumber,berth.berthNumber,berth.berthType,"BOOKED",customerName,customerAge);
                            cabins.getValue().berths.put(berths.getKey(),b);
                            break loop;
                        }
                    }
                }
            }
            if (permission==0&& bookAny.equals("n"))
            {
                System.out.println("Your preferred Berth is not available, shall i book available berth (y/n)?");
                String yesOrno= sc.next();
                if(yesOrno.equals("y"))
                    bookAny="y" ;
                else
                    break loop;
            }
            else if(permission==0 && bookAny.equals("y") && rac.equals("n"))
            {
                rac="y";
            }
            else if(permission==0 && bookAny.equals("y") && rac.equals("y") && wl.equals("n"))
            {
                wl="y";
            }
            else
            {
                System.out.println("Sorry, All tickets are filled");
                break loop;
            }

        }
    }

    private static void initialization(HashMap<Integer,Coach>  trainHashMap) {
        for(Map.Entry<Integer,Coach> coaches: trainHashMap.entrySet())
        {
            for(Map.Entry<Integer,Cabin> cabins: coaches.getValue().cabins.entrySet())
            {
                for(Map.Entry<String,Berth> berths: cabins.getValue().berths.entrySet())
                {
                    Berth berth= berths.getValue();
                    System.out.println(berth.PNRnumber+"    "+berth.berthNumber+"      "+berth.berthType+"    "+berth.status+"     "+berth.name+"    "+berth.age);
                }
            }
        }
    }
}
