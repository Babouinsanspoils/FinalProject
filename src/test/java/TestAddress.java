import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yv.Address;

public class TestAddress {

    @Test
    public void testisPostalCodeValid1() {
        String postalCode = "H3R 1Z2";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testisPostalCodeValid2() {
        String postalCode = "H3R1Z2";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testisPostalCodeValid3() {
        String postalCode = "HR3 1Z2";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testisPostalCodeValid4() {
        String postalCode = "HR31Z2";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testisPostalCodeValid5() {
        String postalCode = "H3R 1Z";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testisPostalCodeValid6() {
        String postalCode = " ";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testisPostalCodeValid7() {
        String postalCode = "H3R 1Z2 ";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testisPostalCodeValid8() {
        String postalCode = null;
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testisPostalCodeValid9() {
        String postalCode = "h3r 1z2";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testisPostalCodeValid10() {
        String postalCode = "hr3 1z2";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }
}
