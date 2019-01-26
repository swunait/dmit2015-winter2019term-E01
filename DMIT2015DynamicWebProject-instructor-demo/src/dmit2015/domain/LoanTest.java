package dmit2015.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoanTest {

	@Test
	void testGetMonthlyPayment() {
		Loan loan1 = new Loan();
		loan1.setMortgageAmount(250000);
		loan1.setAnnualInterestRate(5.29);
		loan1.setAmortizationPeriod(25);

		assertEquals(1495.56, loan1.getMonthlyPayment());
	}
	
	@Test
	void testGetLoanScheduleArray() {
		Loan loan1 = new Loan();
		loan1.setMortgageAmount(250000);
		loan1.setAnnualInterestRate(5.29);
		loan1.setAmortizationPeriod(25);
		
		assertEquals(1, loan1.getLoanScheduleArray()[0].getPaymentNumber());
		assertEquals(1090.13, loan1.getLoanScheduleArray()[0].getInterestPaid());
		assertEquals(405.43, loan1.getLoanScheduleArray()[0].getPrincipalPaid());
		assertEquals(249594.57, loan1.getLoanScheduleArray()[0].getRemainingBalance());
		
		assertEquals(2, loan1.getLoanScheduleArray()[1].getPaymentNumber());
		assertEquals(1088.36, loan1.getLoanScheduleArray()[1].getInterestPaid());
		assertEquals(407.20, loan1.getLoanScheduleArray()[1].getPrincipalPaid());
		assertEquals(249187.37, loan1.getLoanScheduleArray()[1].getRemainingBalance());
		
		assertEquals(299, loan1.getLoanScheduleArray()[298].getPaymentNumber());
		assertEquals(12.95, loan1.getLoanScheduleArray()[298].getInterestPaid());
		assertEquals(1482.61, loan1.getLoanScheduleArray()[298].getPrincipalPaid());
		assertEquals(1487.71, loan1.getLoanScheduleArray()[298].getRemainingBalance());
		
		assertEquals(300, loan1.getLoanScheduleArray()[299].getPaymentNumber());
		assertEquals(6.49, loan1.getLoanScheduleArray()[299].getInterestPaid());
		assertEquals(1487.71, loan1.getLoanScheduleArray()[299].getPrincipalPaid());
		assertEquals(0.00, loan1.getLoanScheduleArray()[299].getRemainingBalance());
		
	}

	
	
	
	
	
	
	
	
}
