package restrant;
import java.util.Scanner;
public class Hotel {
    public static int roomcount = 0, room = 0, CustmerID = 0, Gender, age, multiple, count = 0, First = 0, Second = 0, roomcharge = 0, Third = 0, roomamount = 0, roomComfort = 0;
    public static String custmerName = "", rooms=" ", moblie, gender, address;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Thread t = new Thread();
        int[] hotel = new int[100];
        Database db = new Database();
        boolean next = false;
        System.out.println("Did You Have A Id 1.Yes,2.No");
        First = sc.nextInt();
        if (First == 1) {
            System.out.println("Enter Your Id Number :");
            CustmerID = sc.nextInt();
            System.out.println("Enter Your Name :");
            sc.nextLine();
            custmerName = sc.nextLine();
            System.out.println("Enter Your Gender :");
            System.out.println("1.Male , 2.Female ,3.Other");
            int Gender = sc.nextInt();
            if (Gender == 1) {
                gender = "Male";
            } else if (Gender == 2) {
                gender = "FeMale";
            } else if (Gender == 3) {
                gender = "Other";
            }
            System.out.println("Enter Your Age :");
            age=sc.nextInt();
            System.out.println("Enter Your Mobile Number :");
            sc.nextLine();
            moblie = sc.nextLine();
            System.out.println("Enter Your Address");
            address=sc.nextLine();
            System.out.println("You are Pay  Part payment 1.Yes,2.No");
            Second = sc.nextInt();

            if (Second == 1) {
                System.out.println("Please Booking Your Comfort 1.FirstClass,2.SecondClass,3.ThirdClass");
                roomComfort = sc.nextInt();
                if (roomComfort == 1) {
                    roomamount = 1000;
                } else if (roomComfort == 2) {
                    roomamount = 500;
                } else if (roomComfort == 3) {
                    roomamount = 100;
                }
                System.out.println("How may Rooms Are Do You Want :");
                roomcount = sc.nextInt();
                while (true) {
                    System.out.println("Please Choose  Your room ");
                    room = sc.nextInt();
                    if (hotel[room] == 0) {

                        System.out.println("Room is Sucess Fully Booked");
                        count++;
                        rooms=room+" / "+rooms;
                        hotel[room] = 1;
                    } else {
                        System.out.println("Room is Already Booked");
                    }
                    if (count == roomcount) {
                        break;
                    }
                }
                next = roomcount == count;
                if (next) {
                    multiple = count * roomamount;
                    System.out.println(" Your Comfort of class is  " + roomComfort + " :  Your booking " + count + " Rooms " + " Send The Amount " + multiple);

                    System.out.println("Conform The Booking The Room : ");

                    System.out.println("1.Yes ,2.NO ");
                    int conform = sc.nextInt();
                    if (conform == 1) {
                        System.out.println("Please Pay The 50% Amount " + multiple);
                        roomcharge = sc.nextInt();
                        if (roomamount <= roomcharge) {
                            System.out.println("Amount received Successfully");
                            db.setdata();
                            for (int hour = 24; hour >= 0; hour--) {
                                for (int minute = 60; minute >= 0; minute--) {
                                    for (int second = 60; second >= 0; second--) {
                                        try {
                                            t.sleep(1000);
                                            System.out.println("Hour " + hour + " Minute " + minute + " seconds " + second);
                                        } catch (Exception e) {
                                            System.out.println("Timer Error");
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println("Not Received Part Payment " + multiple);
                        }
                    } else {
                        System.out.println("Okay Please ReUpload Your Data :");
                    }
                } else {
                    System.out.println("Sorry Part Payment is complesary");

                }
            } else {
                System.out.println("Sorry' Id Is Must ");
            }
        }
    }
}
