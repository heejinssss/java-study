package prob05;

public class Account {
	private String accountNo;
	private int balance = 0;

	Account(String a) {
		this.accountNo = a;
	}

	void save(int s) {
		this.balance = balance + s;
	}

	void deposit(int d) {
		this.balance = balance - d;
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
