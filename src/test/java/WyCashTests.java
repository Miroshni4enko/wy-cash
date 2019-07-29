import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WyCashTests {
    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduce = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduce);
    }

    @Test
    public void testPlusReturnsSum(){
        Money five = Money.dollar(5);
        Expression exp = five.plus(five);
        Sum sum = (Sum) exp;
        assertEquals(sum.augend, five);
        assertEquals(sum.addend, five);
    }

    @Test
    public void testReduceSum(){
        Expression sum = Money.dollar(3).plus(Money.dollar(4));
        Bank bank = new Bank();
        Money money = bank.reduce(sum, "USD");
        assertEquals(money, Money.dollar(7));
    }

    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money money = bank.reduce(Money.dollar(5), "USD");
        assertEquals(money, Money.dollar(5));
    }
}
