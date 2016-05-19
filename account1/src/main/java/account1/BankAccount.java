package account1;

//import static java.awt.SequencedEvent.list;

/**
 * Created by nurudeenlawal on 5/18/16.
 */
public class BankAccount {
    private String accountType;
    private int accountNumber;
    private double balance;
    private String holderName;
    private double interestRate;
    private String status;
    private String overDraftProtection;
    //private list<String>records;

    public  String getAccountType(){
        return accountType;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }
    public String getHolderName(){
        return holderName;
    }
    public void setHolderName(String newName){
        this.holderName = newName;
    }
    public double getInterestRate(){
        return interestRate;
    }
    public void setInterestRate(double newInterestRate){
        this.interestRate = newInterestRate;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String newStatus){
        this.status = newStatus;
    }
    public String getOverDraftProtection(){
        return overDraftProtection;
    }
    public void setOverDraftProtection(String oDStatus){
        this.overDraftProtection = oDStatus;
    }

    public double balanceInquiry(){
        double readout = 0000000.0;
        if(this.status != "Frozen"){
            readout = getBalance();
        }
        return readout;
    }
    public String credit(double moneyToAdd){
        double temporaryMoney = (moneyToAdd + this.getBalance());
        String approval = "DENIED";
        if(this.status == "Open"){
            this.setBalance(temporaryMoney);
            approval = "APPROVED";
        }
        return approval;
    }
    public String debit(double moneyToRemove){
        String approval = "DENIED";
        String oDProtection = getOverDraftProtection();
        if(this.status == "Open"&& (oDProtection!="Enabled"||moneyToRemove<=balance)){
            setBalance(balance -= moneyToRemove);
            approval = "APPROVED";
        }
        return approval;
    }


    public BankAccount(String type, int number){
        this.accountType = type;
        this.accountNumber =number;
    }


}
