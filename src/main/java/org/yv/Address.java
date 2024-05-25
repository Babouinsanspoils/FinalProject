package org.yv;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    /**
     * @param postalCode String input containing a postal code
     * @return boolean true or false depending on the validity of the input
     */
    public static boolean isPostalCodeValid(String postalCode) {
        // Check if the length is either 6 or 7
        if (postalCode.length() != 6 && postalCode.length() != 7) {
            return false;
        }

        // Check if the postal code of length 6 contains a space and respects the valid format
        if (postalCode.length() == 6) {
            for (int i = 0; i < postalCode.length(); i++) {
                char CorD = postalCode.charAt(i);
                if (i % 2 == 0 && !Character.isLetter(CorD)) {
                    return false;
                } else if (i % 2 == 1 && !Character.isDigit(CorD)) {
                    return false;
                }
            }
            // If the format is right, return true
            return true;
        }

        // Check if the postal code of length 7 is respecting the format
        if (postalCode.length() == 7) {
            for (int i = 0; i < postalCode.length(); i++) {
                char CorD = postalCode.charAt(i);
                if (i == 3 && CorD != ' ') {
                    return false; // Index 3 should be a space
                } else if (i % 2 == 0 && !Character.isLetter(CorD)) {
                    return false; // Even index (except 3) should be a letter
                } else if (i != 3 && i % 2 == 1 && !Character.isDigit(CorD)) {
                    return false; // Odd index (except 3) should be a digit
                }
            }
            // If the format is right, return true
            return true;
            // returns false, when both length don't respect the valid format
        } return false;
    }

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase(); // Convert to uppercase
            this.country = country;
        } else {
            this.streetNo = Integer.parseInt(null);
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            this.country = null;
        }
    }
}
