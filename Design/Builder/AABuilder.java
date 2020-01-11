package Design.Builder;

class BankAccount{
    
    private long accountNumber;
    private double balance;
    
    private BankAccount(){
        //Constructor is now private.
    }
    
    static class Builder{
    
        private long accountNumber;//This is important, so we'll pass it to the constructor.MUST HAVE VARIABLES
        private double balance;
        
        public Builder(long accountNumber){
            this.accountNumber = accountNumber;
        }

        public Builder openingBalance(double balance){
            this.balance = balance;
            return this; //By returning the builder each time, we can create a fluent interface.
        }
        
        //IMPORTANT
        public BankAccount build(){
            BankAccount account = new BankAccount();  //Since the builder is in the BankAccount class, we can invoke its private constructor.
            account.accountNumber = this.accountNumber;
            account.balance = this.balance;
            return account;
        }
        
       
    }
    
    
    @Override
    public String toString(){
        return this.accountNumber + "-" + this.balance;
    }
}

public class AABuilder {
    public static void main(String args[]) {
            BankAccount account = new BankAccount.Builder(12345678)
                            .openingBalance(100.00d)
                            .build();
            System.out.println(account.toString());
    }
}