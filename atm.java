import java.util.Scanner;
class Bankaccount{
    String name;
    String userName;
    String password;
    String accountNo;
    float balance=10000f;
    int transactions=0;
    String transactionHistory="";

    public void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n Enter your Name=");
        this.name=sc.nextLine();
        System.out.println("\n Enter your username=");
        this.userName=sc.nextLine();
        System.out.println("\n Enter your password=");
        this.password=sc.nextLine();
        System.out.println("\n Enter your accountno=");
        this.accountNo=sc.nextLine();
        System.out.println("\nRegistration Successful.Please Log in to your Bank Account");
    }
    public boolean login () {
        boolean isLogin=false;
        Scanner sc=new Scanner(System.in);
           while (!isLogin) {
              System.out.println("\n Enter your username:");
              String Username=sc.nextLine();
              if (Username.equals(userName)) {
                while (!isLogin) {
                    System.out.println("\nEnter your Password:");
                    String Password=sc.nextLine();
                    if(Password.equals(password)){
                        System.out.println("\nLogin Successful");
                        isLogin=true;
                    }
                    else{
                        System.out.println("\nIncorrect Password");
                    }  
                }
              }else{
                System.out.println("\n Username not found");
              }
           }
           return isLogin;
    }
     public void withdraw(){
        System.out.println("\n Enter AMOUNT to Withdraw");
        Scanner sc =new Scanner(System.in);
        float amount =sc.nextFloat();
        try{
            if(balance >= amount){
                transactions++;
                balance -= amount;
                System.out.println("\n Withdrawal Successful.");
                String str =amount + "Rs Withdrawan\n";
                transactionHistory = transactionHistory.concat(str);
            }else{
                System.out.println("Insufficent Balance.");
            }
        }catch( Exception e){

        }
        
     }
     public void deposit(){
        System.out.println("\n Enter AMOUNT to Deposit");
        Scanner sc =new Scanner(System.in);
        float amount =sc.nextFloat();
        try{
            if(balance <= 10000f){
                transactions++;
                balance += amount;
                System.out.println("\n Deposit Successful.");
                String str =amount + "Rs deposited\n";
                transactionHistory = transactionHistory.concat(str);
            }else{
                System.out.println("The Limit is 10000.");
            }
        }catch( Exception e){
            
        }
        
     }

     public void transfer(){
        Scanner sc =new Scanner(System.in);
        System.out.println("\n Enter Recepitents Name:");
        String receipent=sc.nextLine();
        System.out.println("\n Enter AMOUNT to transfer");
        
        float amount =sc.nextFloat();
        try{
            if (balance >= amount) {
            if(amount <= 50000f){
                transactions++;
                balance -= amount;
                System.out.println("\n  Successfully Transferred to "+receipent);
                String str =amount + "Rs Transferred to "+receipent+"\n";
                transactionHistory = transactionHistory.concat(str);
            }else{
                System.out.println("The Limit is 50000.");
            }
        }else{
            System.out.println("\n Insufficent Balance.");
        }}catch( Exception e){
            
        }
        
     }

     public void checkBalance(){
        System.out.println("\n"+balance + "Rs");
     }

    public void transHistory(){
      if(transactions == 0){
        System.out.println("No Transactions happened");
      }else{
        System.out.println("\n"+transactionHistory);
      }
    }
}
public class atm {
    public static int takenIntegerInput(int limit){
        int input =0;
        boolean flag =false;

        while (!flag) {
            try{
                Scanner sc= new Scanner(System.in);
                input= sc.nextInt();
                flag=true;
                if ( flag && input> limit || input<1) {
                    System.out.println("Choose the number between 1 to "+limit);
                    flag=false;
                }
            }catch(Exception e ){
                System.out.println("Enter only integer value.");
                flag=false;

            }
        }
        return input;
    }
    public static void main(String[] args) {
        System.out.println("\n************WELCOME TO GOVARDAN ATM INTERFACE****************");
        System.out.println("\n1.Register \n2 .Exit ");
        System.out.println("Choose one option ");
        int choose =takenIntegerInput(2);

        if (choose ==1) {
            Bankaccount b =new Bankaccount();
            b.register();
            while (true) {
                System.out.println("\n1.login \n2 .Exit ");
                System.out.println("Enter your choice");
                int ch = takenIntegerInput(2);
                if (ch==1) {
                    if (b.login()) {
                        System.out.println("\n************WELCOME BACK**"  +b.name  +"**************");  
                        boolean isFinished=false;
                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2 .Deposit \n3.Transfer \n4.check balance \n5.TransactionHistory \n6.Exit");
                            System.out.println("Enter your choice:");
                            int c = takenIntegerInput(6);
                            switch (c) {
                                   case 1:
                                    b.withdraw();
                                    case 2:
                                      b.deposit();
                                    case 3:
                                      b.transfer();
                                    case 4:
                                      b.checkBalance();
                                    case 5:
                                      b.transHistory();
                                    case 6:
                                      isFinished = true;
                                       break;
                            }
                        }
                    }
                }else{
                    System.exit(0);
                }
        
            }
        }else{
            System.exit(0);;
        }
    }
}
