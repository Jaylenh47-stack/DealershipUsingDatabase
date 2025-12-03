package models;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = getVehicleSold().getPrice() * 0.5;
        this.leaseFee = getVehicleSold().getPrice() * 0.07;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        return Calculations.calculateMonthlyPayment(getVehicleSold().getPrice(), 0.04f, 36);
    }

    @Override
    public double getTotalPrice() {
        return this.leaseFee + getVehicleSold().getPrice();
    }

    public String toEncodedString(){
        Vehicle v = this.getVehicleSold();

        return String.format("Lease|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f",
                this.getDate(),this.getCustomerName(),this.getCustomerEmail(),v.getVin(),v.getYear(),v.getMake(),v.getModel(),
                v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice(), this.expectedEndingValue, this.leaseFee, this.getTotalPrice(), this.getMonthlyPayment());
    }
}
