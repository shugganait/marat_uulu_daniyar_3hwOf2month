public class Main {
    public static void main(String[] args){
        BankAccount account = new BankAccount();
        account.deposit(20000.0);
        boolean end = false;
        while(end == false){
            try{
                account.withDraw(6000.0);
                System.out.println("Было снято, ваш текущий счет: " + account.getAmount());
            }catch (LimitException le){
                System.out.println(le.getMessage());
                try {
                    account.withDraw(le.getRemainingAmount());
                } catch (LimitException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Было снято отсавшая сумма, текущий счет: " + account.getAmount());
                end = true;
            }

        }
    }
}