import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yv.Address;

public class TestAddress {

    @Test
    public void TestisPostalCodeValid1() {
        String postalCode = "H3R 1Z2";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestisPostalCodeValid2() {
        String postalCode = "H3R1Z2";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestisPostalCodeValid3() {
        String postalCode = "HR3 1Z2";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestisPostalCodeValid4() {
        String postalCode = "HR31Z2";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestisPostalCodeValid5() {
        String postalCode = "H3R 1Z";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestisPostalCodeValid6() {
        String postalCode = " ";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestisPostalCodeValid7() {
        String postalCode = "H3R 1Z2 ";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestisPostalCodeValid8() {
        String postalCode = null;
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestisPostalCodeValid9() {
        String postalCode = "h3r 1z2";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestisPostalCodeValid10() {
        String postalCode = "hr3 1z2";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }
}
