package custom_exception;

@SuppressWarnings("serial")
public class BankingExecption extends Exception{

	public BankingExecption(String errMesg) {
		super(errMesg);

	}
}
