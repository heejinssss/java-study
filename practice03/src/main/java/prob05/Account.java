package prob05;

public class Account {
	private String accountNo;
	private int balance = 0;

	Account(String accountNo) {
		this.accountNo = accountNo;
	}

	void save(int save) {
		this.balance = balance + save;
	}

	void deposit(int deposit) {
		this.balance = balance - deposit;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
