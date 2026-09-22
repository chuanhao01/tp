package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidRemark(String)}
 */
public class Remark {

    public static final String MESSAGE_CONSTRAINTS =
            "Remark should be empty or contain only alphanumeric characters and spaces";

    public static final String VALIDATION_REGEX = "([\\p{Alnum}][\\p{Alnum} ]*)?";

    public final String value;

    /**
     * Constructs a {@code Remark}.
     *
     * @param remark A valid name.
     */
    public Remark(String remark) {
        requireNonNull(remark);
        checkArgument(isValidRemark(remark), MESSAGE_CONSTRAINTS);
        this.value = remark;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidRemark(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Remark otherRemark)) {
            return false;
        }

        return this.value.equals(otherRemark.value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

}
