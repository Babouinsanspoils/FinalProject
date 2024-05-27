import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yv.Address;

public class TestAddress {

    @Test
    public void testIsPostalCodeValid1() {
        String postalCode = "H3R 1Z2";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIsPostalCodeValid2() {
        String postalCode = "H3R1Z2";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIsPostalCodeValid3() {
        String postalCode = "HR3 1Z2";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIsPostalCodeValid4() {
        String postalCode = "HR31Z2";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIsPostalCodeValid5() {
        String postalCode = "H3R 1Z";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIsPostalCodeValid6() {
        String postalCode = " ";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIsPostalCodeValid7() {
        String postalCode = "H3R 1Z2 ";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIsPostalCodeValid8() {
        String postalCode = null;
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIsPostalCodeValid9() {
        String postalCode = "h3r 1z2";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIsPostalCodeValid10() {
        String postalCode = "hr3 1z2";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }
}
