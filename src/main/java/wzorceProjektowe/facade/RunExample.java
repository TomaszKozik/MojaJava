package wzorceProjektowe.facade;

/**
 * Fasada służy do umożliwienia wywołania wielu wspólnych ze sobą klas za pomocą jednej klasy integrującej.
 * Poniższy przykład jest dla obsługi konta bankowego, gdzie:
 * - bank nas wita przed realizacją usługi
 * - weryfikujemy poprawność numeru konta
 * - weryfikujemy poprawność kodu autoryzacji
 * - wykonujemy zmiany na depozycie
 */
public class RunExample {

    public static void main(String[] args) {
        BankAccountFacade accessingBank = new BankAccountFacade(12345678, 1234);
        accessingBank.withdrawCash(100.00);
        accessingBank.withdrawCash(1000.00);
        accessingBank.depositCash(200.00);
    }
}

/**
 * Klasa powitalna
 */
class WelcomeToBank {
    public WelcomeToBank() {
        System.out.println("Welcome to ABC Bank");
        System.out.println("We're happy to give you your money if we can find it\n");
    }
}

/**
 * Klasa walidująca numert konta
 */
class AccountNumber {

    public boolean isAccountNumberCorrect(int expAccountNumber) {
        return expAccountNumber == 12345678;
    }
}

/**
 * Klasa walidująca numer konta
 */
class SecurityCode {

    public boolean isSecurityCodeCorrect(int expSecurityCode) {
        return expSecurityCode == 1234;
    }
}

/**
 * Klasa weryfikująca operacje na koncie
 */
class FundsCheck {
    private double cashInAccount = 1000.00;

    public double getCashInAccount() {
        return cashInAccount;
    }

    public void decreaseCashInAccount(double cashWithdrawn) {
        this.cashInAccount -= cashWithdrawn;
    }

    public void increaseCashInAccount(double cashDeposit) {
        this.cashInAccount += cashDeposit;
    }

    public boolean haveEnoughMoney(double cashToWithdrawal) {
        if (cashToWithdrawal > cashInAccount) {
            System.out.println("Error: You don't have enough money");
            System.out.println("Current balance is: " + cashInAccount);
            return false;
        } else {
            decreaseCashInAccount(cashToWithdrawal);
            System.out.println("Withdrawal Complete: Current balance is " + cashInAccount);
            return true;
        }
    }

    public void makeDeposit(double cashToDeposit) {
        increaseCashInAccount(cashToDeposit);
        System.out.println("Deposit Complete: Current balance is " + getCashInAccount());
    }
}

/**
 * Fasada - klasa integrująca wszystkie klasy służące do obsługi konta
 */
class BankAccountFacade {
    private final int expAccountNumber;
    private final int expSecurityCode;

    private final AccountNumber accountNumber;
    private final SecurityCode securityCode;
    private final FundsCheck fundsCheck;

    public BankAccountFacade(int newAccountNumber, int newSecurityCode) {
        this.expAccountNumber = newAccountNumber;
        this.expSecurityCode = newSecurityCode;

        new WelcomeToBank();

        this.accountNumber = new AccountNumber();
        this.securityCode = new SecurityCode();
        this.fundsCheck = new FundsCheck();
    }

    public int getExpAccountNumber() {
        return expAccountNumber;
    }

    public int getExpSecurityCode() {
        return expSecurityCode;
    }

    public void withdrawCash(double cashToGet) {
        if (accountNumber.isAccountNumberCorrect(getExpAccountNumber()) &&
                securityCode.isSecurityCodeCorrect(getExpSecurityCode()) &&
                fundsCheck.haveEnoughMoney(cashToGet)) {
            System.out.println("Transaction complete\n");
        } else {
            System.out.println("Transaction faild\n");
        }
    }

    public void depositCash(double cashToDeposit) {
        if (accountNumber.isAccountNumberCorrect(getExpAccountNumber()) &&
                securityCode.isSecurityCodeCorrect(getExpSecurityCode())) {
            fundsCheck.makeDeposit(cashToDeposit);
            System.out.println("Transaction complete\n");
        } else {
            System.out.println("Transaction faild\n");
        }
    }
}