/*
    Author -> Wasim Ansari
    Date -> 17/10/2023
*/
import java.util.Scanner;
class Atm{
    Scanner sc = new Scanner(System.in);
    private int pin;
    private double balance;

    // For creating New pin
    Atm(int pin){
        this.pin = pin;
    }

    // Check Balance
    public Object getBalance(int pin){
        if(pin==this.pin){
            return this.balance;
        }
        return "Sorry Invalid pin!";
    }

    // Withdraw amount
    public void withdraw(double amount,int pin){
        if(pin==this.pin){
            if(this.balance>amount){
                this.balance-=amount;
                System.out.println("Amount Withdraw successfully");
                System.out.print("Do you want to check balance:- ");
                String yes = sc.nextLine();
                if(yes.equalsIgnoreCase("Yes")){
                    System.out.println(getBalance(pin));
                }
            }else{
                System.out.println("Insufficent Balance!");
            }
        }else{
            System.out.println("Invalid pin!");
        }
    }

    // Deposite amount
    public void deposite(double amount,int pin){
        if(pin==this.pin){
            this.balance+=amount;
            System.out.println("Amount Diposite successfully!");
            System.out.print("Do you want to check Balance:- ");
            String yes = sc.nextLine();
            if(yes.equalsIgnoreCase("yes")){
                System.out.println(getBalance(pin));
            }
        }else{
            System.out.println("Invalid Pin!");
        }
    }

    // Pin Change
    public void pinChange(int pin){
        if(pin==this.pin){
            System.out.print("Enter your 4 digit new pin:- ");
            pin = sc.nextInt();
            this.pin = pin;
            System.out.print("Pin has been Changed\n your new pin is:- "+this.pin);
        }else{
            System.out.println("Invalid Pin!");
        }
    }
    

}
public class AtmMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pin;
        double amount;
        String proceedAgain;
        do{
            System.out.print("Create 4 digit pin:- ");
            pin =sc.nextInt();
        }while(!(pin>999 && pin<10000));
        Atm sbi = new Atm(pin);
        do{
            int choice;
            System.out.println("1) Check Balance\t2) Withdraw");
            System.out.println("3) Diposite\t\t4) Pin Change");
            System.out.print("Enter your choice:- ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter your 4 digit pin:- ");
                    pin = sc.nextInt();
                    System.out.println(sbi.getBalance(pin));
                    break;
                case 2:
                    System.out.print("Enter your 4 digit pin:- ");
                    pin = sc.nextInt();
                    System.out.print("Enter Withdraw amount:- ");
                    amount = sc.nextDouble();
                    sbi.withdraw(amount,pin);
                    break;
                case 3:
                    System.out.print("Enter your 4 digit pin:- ");
                    pin = sc.nextInt();
                    System.out.print("Enter Deposite amount:- ");
                    amount = sc.nextDouble();
                    sbi.deposite(amount,pin);
                    break;
                case 4:
                    System.out.print("Enter your 4 digit pin:- ");
                    pin = sc.nextInt();
                    sbi.pinChange(pin);
                    break;
                default:
                    System.out.println("Invalid Choice!!!");
            }
            sc.nextLine();
            System.out.print("Do you want to proceed again:- ");
            proceedAgain = sc.nextLine();
            if(proceedAgain.equalsIgnoreCase("No")){
                sc.close();
                break;
            }
        }while(true);
    }
}