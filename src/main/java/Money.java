abstract class Money {
    protected int amount;

    public static Franc franc(int amount) {
        return new Franc(amount);
    }

    public boolean equals(Object object) {
        Money another = (Money) object;
        return this.amount == another.amount && getClass().equals(another.getClass());
    }
    abstract Money times(int amount);

    static Dollar dollar(int amount) {
        return new Dollar(amount);
    }
}
