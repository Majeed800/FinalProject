package org.example;

import lombok.EqualsAndHashCode;

import lombok.Setter;
import lombok.ToString;

@Setter
@EqualsAndHashCode
@ToString

public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
            this.country = country;
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            this.country = null;
        }
    }

    /**
     * checks if a postcode is valid or not. The length of a postal code can either be `6` or `7`
     * if the length is `6`, then it must follow the format: `CDCDCD`,
     * if the length is `7`, then it must follow the format: `CDC DCD`.
     * where `C` is a character, while `D` is a digit. Case-insensitive;
     *
     * @param postalCode
     * @return true if it is valid, else false
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null) {
            return false;
        }

        int length = postalCode.length();

        if (length == 6) {
            for (int i = 0; i < 6; i++) {
                if (i % 2 == 0) {
                    if (!Character.isLetter(postalCode.charAt(i))) {
                        return false;
                    }
                } else {
                    if (!Character.isDigit(postalCode.charAt(i))) {
                        return false;
                    }
                }
            }
            return true;
        } else if (length == 7) {
            if (postalCode.charAt(3) != ' ') {
                return false;
            }

            for (int i = 0; i < 7; i++) {
                if (i == 3) {
                    continue;
                }

                if (i < 3) {
                    if (i % 2 == 0) {
                        if (!Character.isLetter(postalCode.charAt(i))) {
                            return false;
                        }
                    } else {
                        if (!Character.isDigit(postalCode.charAt(i))) {
                            return false;
                        }
                    }
                } else {
                    if ((i - 1) % 2 == 0) {
                        if (!Character.isLetter(postalCode.charAt(i))) {
                            return false;
                        }
                    } else {
                        if (!Character.isDigit(postalCode.charAt(i))) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        return false;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }
}
