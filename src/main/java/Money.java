class Money {
    protected int amount;
    protected String currency;

    Money(int amount, String currency){
        this.currency = currency;
        this.amount = amount;
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public boolean equals(Object object) {
        Money another = (Money) object;
        return this.amount == another.amount && currency.equals(another.currency);
    }
    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public String currency() {
        return currency;
    }
}
