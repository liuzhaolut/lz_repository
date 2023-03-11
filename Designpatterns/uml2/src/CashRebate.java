public class CashRebate implements CashSuper{
    public double moneryRebate=1;

    public CashRebate(double moneryRebate) {
        this.moneryRebate=moneryRebate;
    }

    @Override
    public double acceptCash(double monery) {
        return monery * moneryRebate;
    }
}
