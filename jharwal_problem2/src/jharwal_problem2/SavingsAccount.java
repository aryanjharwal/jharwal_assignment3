	package jharwal_problem2;
	
	public class SavingsAccount {

		   //variable to store annual interest rate
		static private double annualInterestRate;
		        private double savingBalance;

		        //constructor method
		        public SavingsAccount()
		        {

		        }

		        //Constructor method
		        public SavingsAccount(double savingBalance)
		        {
		                this.savingBalance=savingBalance;
		        }

		        //Get saving balance
		        public double getSavingBalance()
		        {
		                return this.savingBalance;
		        }
		      
		         // Modify interest rate by setting annual interest rate to a new value
		        public static void modifyInterestRate(double newInterestRate)
		        {
		                annualInterestRate=newInterestRate;
		        }

		        //Method to calculate monthly interest
		        public void calculateMonthlyInterest()
		        {
		                double monthlyI;
		                monthlyI= (double)(this.savingBalance*annualInterestRate/12);
		                this.savingBalance+=monthlyI;
		        }}


