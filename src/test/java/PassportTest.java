import static org.junit.jupiter.api.Assertions.*;

class PassportTest {

    @org.junit.jupiter.api.Test
    void validate() {
        Passport passport = new Passport();

        assertTrue(passport.validate("byr", "1990"));
        assertFalse(passport.validate("byr", "1900"));
        assertFalse(passport.validate("byr", "2010"));

        assertTrue(passport.validate("iyr", "2015"));
        assertFalse(passport.validate("iyr", "2000"));
        assertFalse(passport.validate("iyr", "2030"));

        assertTrue(passport.validate("eyr", "2025"));
        assertFalse(passport.validate("eyr", "2010"));
        assertFalse(passport.validate("eyr", "2040"));

        assertTrue(passport.validate("hgt", "70in"));
        assertFalse(passport.validate("hgt", "50in"));
        assertFalse(passport.validate("hgt", "90in"));
        assertTrue(passport.validate("hgt", "170cm"));
        assertFalse(passport.validate("hgt", "100cm"));
        assertFalse(passport.validate("hgt", "200cm"));
        assertFalse(passport.validate("hgt", "20"));

        assertTrue(passport.validate("hcl", "#ff1f0f"));
        assertFalse(passport.validate("hcl", "ff1f0f"));
        assertFalse(passport.validate("hcl", "#gggggg"));
        assertFalse(passport.validate("hcl", "#1111111"));

        assertTrue(passport.validate("ecl", "grn"));
        assertTrue(passport.validate("ecl", "oth"));
        assertFalse(passport.validate("ecl", "org"));

        assertTrue(passport.validate("pid", "123456789"));
        assertTrue(passport.validate("pid", "012345678"));
        assertFalse(passport.validate("pid", "abcd12345"));
        assertFalse(passport.validate("pid", "1234567890"));
    }
}