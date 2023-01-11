public class BankAccount{
    private double amount;

    public double getAmount() {
        return amount;
    }
    public void deposit(double sum){
        amount += sum;
        System.out.println("Ваш счет дополнен, ваш текущий счет: " + getAmount());
    }
    public void withDraw(double sum) throws LimitException{
        if((amount - sum) < 0){
            throw new LimitException("С вашего счета нельзя снять сумму больше чем ваш счет: " + getAmount(), getAmount());
        }
        amount -= sum;
    }
}
