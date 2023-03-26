package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginPage
{
	
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	
	public void loginPanel()
     {
    	  try
    	  {   Scanner sc = new Scanner(System.in);
    		  Class.forName("oracle.jdbc.driver.OracleDriver");
    		  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##coder","coder");
    		  PreparedStatement Ps1 = con.prepareStatement("insert into USERDETAILS51 values (?,?,?,?,?,?,?)");
    		  PreparedStatement Ps2 = con.prepareStatement("select * from USERDETAILS51 where username =? AND password=?");
    		  PreparedStatement Ps3 = con.prepareStatement("select * from USERDETAILS51 where username =? ");
    		  PreparedStatement Ps4 = con.prepareStatement("UPDATE  USERDETAILS51  SET  CITY = ? WHERE username=?");
    		  PreparedStatement Ps5 = con.prepareStatement("UPDATE  USERDETAILS51  SET  GMAILID = ? WHERE username=?");
    		  PreparedStatement Ps6 = con.prepareStatement("UPDATE  USERDETAILS51  SET  PNONENO = ? WHERE username=?");
    		  PreparedStatement Ps7 = con.prepareStatement("select * from USERDETAILS51 where PNONENO = ? AND GMAILID = ?");

    		  while(true)
    		  {
   			   System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
   			   System.out.println(String.format("%80s","Choice"));
   			   System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
               System.out.println(String.format("%83s","[1] Register"));
               System.out.println(String.format("%80s","[2] Login"));
               System.out.println(String.format("%101s","[3] Forgot Username & Password"));
               System.out.println(String.format("%79s","[4] Exit"));
   			   System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
               System.out.print("Enter The Option For Task : ");
               int opt = Integer.parseInt(sc.nextLine());
   			   System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
   			   switch(opt)
   			   {
   			   case 1:
   				System.out.print("Enter The Username : ");
         	   String uN=sc.nextLine();
         	   System.out.print("Enter The First Name Of The User : ");
         	   String fN=sc.nextLine();
         	   System.out.print("Enter The Last Name Of The User : ");
         	   String lN=sc.nextLine();
         	   System.out.print("Enter The Password Of The User : ");
         	   String uP=sc.nextLine();
         	   System.out.print("Enter The G-Mail Of The User : ");
         	   String uG=sc.nextLine();
         	   System.out.print("Enter The Phone Number Of The User : ");
         	   Long pN=Long.parseLong(sc.nextLine());
         	   System.out.print("Enter The City Of The User : ");
         	   String uC = sc.nextLine();
         	   
         	   
         	   Ps1.setString(1,uN);
         	   Ps1.setString(2,fN);
         	   Ps1.setString(3,lN);
           	   Ps1.setString(4,uP);
         	   Ps1.setString(5,uG);
         	   Ps1.setLong(6,pN);
         	   Ps1.setString(7,uC);
         	   
         	   int k = Ps1.executeUpdate();
         	   if(k>0)
         	   {
       			   System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
          		   System.out.println("Registration Done !!!!!");
         	   }
         	   else
         	   {
         		   System.out.println("Registration Failed !!!!!");
         	   }
   				   break;
   			   case 2:
   				System.out.print("Enter Your Username : ");
        	    String username = sc.nextLine();
        	    System.out.print("Enter Your Password : ");
        	    String pass=sc.nextLine();
        	    
        	    Ps2.setString(1, username);
        	    Ps2.setString(2, pass);
        	    
        	    ResultSet rs = Ps2.executeQuery();
        	    if(rs.next())
        	    {
        	    	System.out.println("Login SuccessFull !!!!!!!");
        	    while(true)
        	    {
        	    	   
        			   System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        			   System.out.println(String.format("%80s","Choice"));
        			   System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        			   System.out.println("WELCOME ---> "+rs.getString(1)+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t Username : "+rs.getString(2)+" "+rs.getString(3));
 				       System.out.println(String.format("%86s","[1] View User Profile"));
 		               System.out.println(String.format("%81s","[2] Edit Profile"));
 		               System.out.println(String.format("%75s","[3] LogOut"));
 				    
 		               System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
 		               System.out.print("Enter The Option For Task : ");
 		               int opt1 = Integer.parseInt(sc.nextLine());
 		               switch(opt1)
 		               {
 		               case 1:
 		            	   System.out.print("Enter The Username : ");
 		            	   String username1 = sc.nextLine();
 		            	   Ps3.setString(1,username1);
 		            	   ResultSet rs1 =Ps3.executeQuery();
 		            	   if(rs1.next())
 		            	   {
       						System.out.println("Name : "+rs1.getString(2)+" "+rs1.getString(3)+"\nPassword : "+rs1.getString(4)+"\nE-Mail : "+rs1.getString(5)+"\nMobile No : "+rs1.getLong(6)+"\nAddress : "+rs1.getString(7));

 		            	   }
 		            	   else
 		            	   {
 		            		   System.out.println("Invalid Username !!!!!!!!!");
 		            	   }
 		            	   
 		            	   break;
 		               case 2:
 		            	   System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
 		            	   System.out.println(String.format("%80s","Choice"));
 	 		               System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
 	        			   System.out.println("WELCOME ---> "+rs.getString(1)+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t Username : "+rs.getString(2)+" "+rs.getString(3));
 	 		               System.out.println(String.format("%80s","[1] City"));
 	 		               System.out.println(String.format("%82s","[2] E-Mail"));
 	 		               System.out.println(String.format("%84s","[3] Phone No"));
 	 		               System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
 		            	   System.out.print("Enter The Option For Task : ");
 		            	   int opt2 = Integer.parseInt(sc.nextLine());
 		            	   switch(opt2)
 		            	   {
 		            	   case 1:
 		            		   System.out.print("Enter Your Username : ");
       					       String username2=sc.nextLine();
       					       Ps3.setString(1, username2);
       					       ResultSet rs2 = Ps3.executeQuery();
       					       if(rs2.next())
       					       {
       					       Ps3.setString(1, username2);
 		            		   ResultSet rs3=Ps3.executeQuery();
 		            		   if(rs3.next())
 		            		   {
 		            			   System.out.println("Old City : "+rs3.getString(7));
 		            		   }
 		            		   System.out.print("Enter New City : ");
 		            		   String ncity = sc.nextLine();
 		            		   Ps4.setString(1, ncity);
 		            		   Ps4.setString(2,username2);
 		            		   int k1 = Ps4.executeUpdate();
 		            		   if(k1>0)
 		            		   {
 		            			   System.out.println("Recard Updated !!!!!!!!!!");
 		            		   }
 		            		   else
 		            		   {
 		            			   System.out.println("Record Not Updated !!!!!!!!!!!");
 		            		   }
       					       }
       					       else
       					       {
       					    	System.out.println("Invalid Username !!!!!!!!!!!!!!!!");   
       					       }
 		            				   
 		            		   break;
 		            	   case 2:
 		            		   System.out.print("Enter Your Username : ");
      					       String username3=sc.nextLine();
      					       Ps3.setString(1, username3);
      					       ResultSet rs4 = Ps3.executeQuery();
      					       if(rs4.next())
      					       {
      					       Ps3.setString(1, username3);
		            		   ResultSet rs5=Ps3.executeQuery();
		            		   if(rs5.next())
		            		   {
		            			   System.out.println("Old E-Mail : "+rs5.getString(5));
		            		   }
		            		   System.out.print("Enter New E-Mail : ");
		            		   String nemail = sc.nextLine();
		            		   Ps5.setString(1, nemail);
		            		   Ps5.setString(2,username3);
		            		   int k2 = Ps5.executeUpdate();
		            		   if(k2>0)
		            		   {
		            			   System.out.println("Recard Updated !!!!!!!!!!");
		            		   }
		            		   else
		            		   {
		            			   System.out.println("Record Not Updated !!!!!!!!!!!");
		            		   }
      					       }
      					       else
      					       {
      					    	System.out.println("Invalid Username !!!!!!!!!!!!!!!!");   
      					       }
		            				   
 		            		   break;
 		            	   case 3:
 		            		  System.out.print("Enter Your Username : ");
     					       String username4=sc.nextLine();
     					       Ps3.setString(1, username4);
     					       ResultSet rs6 = Ps3.executeQuery();
     					       if(rs6.next())
     					       {
     					       Ps3.setString(1, username4);
		            		   ResultSet rs7=Ps3.executeQuery();
		            		   if(rs7.next())
		            		   {
		            			   System.out.println("Old Phone No : "+rs7.getString(6));
		            		   }
		            		   System.out.print("Enter New Phone No : ");
		            		   long mobile = Long.parseLong(sc.nextLine());
		            		   Ps6.setLong(1, mobile);
		            		   Ps6.setString(2,username4);
		            		   int k3 = Ps6.executeUpdate();
		            		   if(k3>0)
		            		   {
		            			   System.out.println("Recard Updated !!!!!!!!!!");
		            		   }
		            		   else
		            		   {
		            			   System.out.println("Record Not Updated !!!!!!!!!!!");
		            		   }
     					       }
     					       else
     					       {
     					    	System.out.println("Invalid Username !!!!!!!!!!!!!!!!");   
     					       }
 		            		   break;
 		            		   
 		            	   default :
 		            			   System.out.println("Invalid Choice !!!!!!!!!!!!");
 		            	   }
 		            	   
 		            	   break;
 		               case 3:
 		            	   System.out.println("LogOut Successfull.............");
                           new LoginPage().loginPanel();
 		            	   break;
 		               default :
 		            		System.out.println("Invalid Choice !!!!!!!!!!!!!");
 		               }
        	    }
        	    }
        	    else
        	    {
        	    	System.out.println("Invalid Username Or Password !!!!!!!!!!!!!!!");
        	    }
				  break;
   			case 3:
          	   System.out.print("Enter Your Contact Number : ");
          	   long number = Long.parseLong(sc.nextLine());
          	   System.out.print("Enter Your E-Mail ID : ");
          	   String emailid = sc.nextLine();
          	   
          	   Ps7.setLong(1,number);
          	   Ps7.setString(2,emailid);
          	   
          	   ResultSet rs8 = Ps7.executeQuery();
          	   if(rs8.next())
          	   {
          		   System.out.println("Username : "+rs8.getString(1)+"\t Password : "+rs8.getString(4));
          	   }
          	   else
          	   {
          		   System.out.println("Account Not Found !!!!!!!!!!!!!");
          	   }
          	   
          	   break;
   			   case 4:
   				   System.out.println("Operation Stoped !!!!!!!!!!!!!!!!!!!!!!");
				   System.exit(0);
				   break;
   			   default :
					   System.out.println("Invalid Choice !!!!!!!!!!!!!!");
   				   
   			   }
    		  }
    	  }
    	  catch(Exception e )
    	  {
    		  e.printStackTrace();
    	  }
     }
     
     public static void main(String[] args) 
     {
    	 
    	System.out.print(ANSI_GREEN+"====================================================================================================================================================================================================");
		System.out.println(ANSI_RED+"\r\n"
				+ " \r\n"
				+ "\t\t\t\t\t            __               _          _____            __               \r\n"
				+ "\t\t\t\t\t           / /  ____  ____ _(_____     / ___/__  _______/ /____  ____ ___ \r\n"
				+ "\t\t\t\t\t          / /  / __ \\/ __ `/ / __ \\    \\__ \\/ / / / ___/ __/ _ \\/ __ `__ \\\r\n"
				+ "\t\t\t\t\t         / /__/ /_/ / /_/ / / / / /   ___/ / /_/ (__  / /_/  __/ / / / / /\r\n"
				+ "\t\t\t\t\t        /_____\\____/\\__, /_/_/ /_/   /____/\\__, /____/\\__/\\___/_/ /_/ /_/ \r\n"
				+ "\t\t\t\t\t                  /____/                 /____/                          \r\n"
				+ " \r\n"
				+ "");
    	System.out.println(ANSI_GREEN+"====================================================================================================================================================================================================");
        
    	LoginPage lobj = new LoginPage();
    	lobj.loginPanel();
	 }
}
