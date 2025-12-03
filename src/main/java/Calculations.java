public class Calculations {

    public static double calculateMonthlyPayment(double principal, float annualInterestRate, int numberOfPayments ){
      float monthlyInterestRate = annualInterestRate/12;

       return principal *
               ((monthlyInterestRate *
                       (Math.pow(
                        (1 + monthlyInterestRate), numberOfPayments)))
               /
               (Math.pow(
                       (1 + monthlyInterestRate), (numberOfPayments)) -1 ));




    }
}
