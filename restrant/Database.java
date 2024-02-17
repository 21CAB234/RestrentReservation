package restrant;
import  java.sql.*;
public class Database {
    public static void main(String[] args) {
        Database db=new Database();
        String url="jdbc:mysql://localhost:3306/restrent";
        try
        {
            String sql="select * from hotellist";
            Connection con = DriverManager.getConnection(url, "root", "21CAB234");
            Statement st=con.createStatement();
            ResultSet result=st.executeQuery(sql);
            while (result.next()){
                System.out.println("Customer Id :"+result.getInt(1)+"   Customer Name :"+result.getString(2)+"  Customer Number :"+ result.getString(3)+"   Gender :"+result.getString(4)+"  Customer Age :"+result.getInt(5)+"    Comfort :"+result.getInt(6) +"   Total Room Book "+ result.getInt(7)+"   Paying Amount :"+result.getInt(8) +"    Customer Room No : "+ result.getString(9)+"    Customer Address "+ result.getString(10)  );}
        }
        catch (Exception e){

        }

    }
    private void data(int id,String name,String moblie,String Gender,int age,int comfort,int roomcount,int roomamount,String rooms,String address) {
        String url="jdbc:mysql://localhost:3306/restrant";
        String SQl=" INSERT INTO HotelList VALUES (?,?,?,?,?,?,?,?,?,?) ";
        try {
            Connection con = DriverManager.getConnection(url, "root", "21CAB234");
            PreparedStatement pre=con.prepareStatement(SQl);
            pre.setInt(1,id);
            pre.setString(2,name);
            pre.setString(3,moblie);
            pre.setString(4,Gender);
            pre.setInt(5,age);
            pre.setInt(6,comfort);
            pre.setInt(7,roomcount);
            pre.setInt(8,roomamount);
            pre.setString(9,rooms);
            pre.setString(10,address);
            int rs=pre.executeUpdate();

            System.out.println("Your id Number is :"+id);
            System.out.println("Your Name is :"+name);
            System.out.println("Your Moblie Number is :"+moblie);
            System.out.println("Yor Gender is :"+Gender);
            System.out.println("Your age is :"+age);
            System.out.println("Your Are Booking :"+comfort+" Class");
            System.out.println("Your Room count is :"+roomcount);
            System.out.println("Your Payment amount is :"+Hotel.multiple+" Balance Amount is :"+Hotel.multiple);
            System.out.println("Your room Number is :"+rooms);
            System.out.println("Your Address is :"+address);
            System.out.println("Room Booked SuccessFully ");

        }
        catch (Exception e){
            System.out.println("Some error  Sorry "+name+" Please Again Upload Your  Data"+e);
        }
    }


    public void setdata(){data(Hotel.CustmerID,Hotel.custmerName,Hotel.moblie,Hotel.gender, Hotel.age,Hotel.roomComfort,Hotel.roomcount,Hotel.multiple,Hotel.rooms,Hotel.address);

    }
}
