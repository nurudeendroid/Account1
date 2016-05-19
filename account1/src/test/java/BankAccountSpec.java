import account1.BankAccount;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nurudeenlawal on 5/18/16.
 */
public class BankAccountSpec {
    double delta = Math.pow(1,-10);
    @Test
    public void getAccountNumberTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        int expectedAccountNumber = 12;
        int actualAccountNumber = bankAccount.getAccountNumber();
        Assert.assertEquals(expectedAccountNumber,actualAccountNumber);
    }
    @Test
    public void getAccountTypeTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        String expectedAccountType = "Test";
        String actualAccountType = bankAccount.getAccountType();
        Assert.assertEquals(expectedAccountType,actualAccountType);
    }
    @Test
    public void getBalanceTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setBalance(230.00);
        double expectedBalance = 230.00;
        double actualBalance = bankAccount.getBalance();
        Assert.assertEquals(expectedBalance,actualBalance,delta);
    }
    @Test
    public void setBalanceTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setBalance(210.00);
        double expectedBalance = 210.00;
        double actualBalance = bankAccount.getBalance();
        Assert.assertEquals(expectedBalance,actualBalance,delta);
    }
    @Test
    public void getHolderNameTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setHolderName("Nurudeen");
        String expectedName = "Nurudeen";
        String actualName = bankAccount.getHolderName();
        Assert.assertEquals(expectedName,actualName);
    }
    @Test
    public void setHolderNameTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setHolderName("Lawal");
        String expectedName = "Lawal";
        String actualName = bankAccount.getHolderName();
        Assert.assertEquals(expectedName,actualName);
    }
    @Test
    public void getInterestRateTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setInterestRate(2.0);
        double expectedInterestRate = 2.0;
        double actualInterestRate = bankAccount.getInterestRate();
        Assert.assertEquals(expectedInterestRate,actualInterestRate,delta);
    }
    @Test
    public void setInterestRateTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setInterestRate(5.0);
        double expectedInterestRate = 5.0;
        double actualInterestRate = bankAccount.getInterestRate();
        Assert.assertEquals(expectedInterestRate,actualInterestRate,delta);
    }
    @Test
    public void getStatusTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setStatus("Closed");
        String expectedStatus = "Closed";
        String actualStatus = bankAccount.getStatus();
        Assert.assertEquals(expectedStatus,actualStatus);
    }
    @Test
    public void setStatusTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setStatus("Open");
        String expectedStatus = "Open";
        String actualStatus = bankAccount.getStatus();
        Assert.assertEquals(expectedStatus,actualStatus);
    }
    @Test
    public void setOverDraftTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setOverDraftProtection("Enabled");
        String expectedOverDraftProtection = "Enabled";
        String actualOverDraftProtection = bankAccount.getOverDraftProtection();
        Assert.assertEquals(expectedOverDraftProtection,actualOverDraftProtection);
    }
    @Test
    public void getOverDraftTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setOverDraftProtection("Transfer");
        String expectedOverDraftProtection = "Transfer";
        String actualOverDraftProtection = bankAccount.getOverDraftProtection();
        Assert.assertEquals(expectedOverDraftProtection,actualOverDraftProtection);
    }
    @Test
    public void getRecordTest(){

    }
    @Test
    public void goodDebitTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setOverDraftProtection("Enabled");
        bankAccount.setStatus("Open");
        bankAccount.setBalance(500.00);
        String actualApproval = bankAccount.debit(200.00);
        String expectedApproval = "APPROVED";
        double expectedBalanceAfter = 300.00;
        double balanceAfter = bankAccount.getBalance();
        Assert.assertEquals(expectedBalanceAfter,balanceAfter,delta);
        Assert.assertEquals(expectedApproval,actualApproval);

    }
    @Test
    public void badDebitTest(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setOverDraftProtection("Enabled");
        bankAccount.setStatus("Open");
        bankAccount.setBalance(100.00);
        String actualApproval = bankAccount.debit(200.00);
        String expectedApproval = "DENIED";
        double expectedBalanceAfter = 100.00;
        double balanceAfter = bankAccount.getBalance();
        Assert.assertEquals(expectedBalanceAfter,balanceAfter,delta);
        Assert.assertEquals(expectedApproval,actualApproval);
    }
    @Test
    public void goodCredit(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setStatus("Open");
        bankAccount.setBalance(100.00);
        String actualApproval = bankAccount.credit(200.00);
        String expectedApproval = "APPROVED";
        double expectedBalanceAfter = 300.00;
        double balanceAfter = bankAccount.getBalance();
        Assert.assertEquals(expectedBalanceAfter,balanceAfter,delta);
        Assert.assertEquals(expectedApproval,actualApproval);
    }
    @Test
    public void badCredit(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setStatus("Closed");
        bankAccount.setBalance(100.00);
        String actualApproval = bankAccount.credit(200.00);
        String expectedApproval = "DENIED";
        double expectedBalanceAfter = 100.00;
        double balanceAfter = bankAccount.getBalance();
        Assert.assertEquals(expectedBalanceAfter,balanceAfter,delta);
        Assert.assertEquals(expectedApproval,actualApproval);
    }
    @Test
    public void regularBalanceInquiry(){
        BankAccount bankAccount = new BankAccount("Test",12);
        bankAccount.setStatus("Open");
        bankAccount.setBalance(100.00);
        double actualReadout = bankAccount.balanceInquiry();
        double expectedReadout = 100.00;
        Assert.assertEquals(expectedReadout,actualReadout,delta);

    }
    @Test
    public void frozenBalanceInquiry(){
        
    }
    @Test
    public void serRecordTest(){}
}
