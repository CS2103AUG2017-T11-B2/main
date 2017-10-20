package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.commons.exceptions.DuplicateDataException;
import seedu.address.commons.util.CollectionUtil;

public class PhoneList implements Iterable<Phone> {

    private final ObservableList<Phone> internalList = FXCollections.observableArrayList();

    /**
     * Constructs an empty PhoneList
     */
    public PhoneList() {

    }

    /**
     * Creates a PhoneList using given phones.
     * Enforces no nulls.
     */
    public PhoneList(Set<Phone> phones) {
        requireAllNonNull(phones);
        internalList.addAll(phones);

        assert CollectionUtil.elementsAreUnique(internalList);
    }

    /**
     * Returns all phones in this list as a Set.
     * This set is mutable and change-insulated against the internal list.
     */
    public Set<Phone> toSet() {
        assert CollectionUtil.elementsAreUnique(internalList);
        return new HashSet<>(internalList);
    }

    /**
     * Adds a Phone to the list.
     *
     * @throws PhoneList.DuplicatePhoneException if the Phone to add is a duplicate of an existing Phone in the list.
     */
    public void add(Phone toAdd) throws PhoneList.DuplicatePhoneException {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new PhoneList.DuplicatePhoneException();
        }
        internalList.add(toAdd);

        assert CollectionUtil.elementsAreUnique(internalList);
    }

    @Override
    public Iterator<Phone> iterator() {
        assert CollectionUtil.elementsAreUnique(internalList);
        return internalList.iterator();
    }

    /**
     * Returns true if the list contains an equivalent Phone as the given argument.
     */
    public boolean contains(Phone toCheck) {
        requireNonNull(toCheck);
        return internalList.contains(toCheck);
    }

    @Override
    public boolean equals(Object other) {
        assert CollectionUtil.elementsAreUnique(internalList);
        return other == this // short circuit if same object
                || (other instanceof PhoneList // instanceof handles nulls
                && this.internalList.equals(((PhoneList) other).internalList));
    }

    /**
     * Returns true if the element in this list is equal to the elements in {@code other}.
     * The elements do not have to be in the same order.
     */
    public boolean equalsOrderInsensitive(PhoneList other) {
        assert CollectionUtil.elementsAreUnique(internalList);
        assert CollectionUtil.elementsAreUnique(other.internalList);
        return this == other || new HashSet<>(this.internalList).equals(new HashSet<>(other.internalList));
    }

    @Override
    public String toString() {
        StringBuilder phoneList = new StringBuilder();
        for (Phone phone : internalList) {
            phoneList.append(phone.toString() + "\n");
        }
        return phoneList.toString();
    }

    /**
     * Signals that an operation would have violated the 'no duplicates' property of the list.
     */
    public static class DuplicatePhoneException extends DuplicateDataException {
        protected DuplicatePhoneException() {
            super("Operation would result in duplicate tags");
        }
    }
}
