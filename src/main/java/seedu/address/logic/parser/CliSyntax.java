package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    //@@author viviantan95
    public static final Prefix PREFIX_BIRTHDAY = new Prefix("b/");
    //@@author
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_MODULE = new Prefix("m/");
    //@@author viviantan95
    public static final Prefix PREFIX_PHOTO = new Prefix("u/");
    //@@author
    public static final Prefix PREFIX_APPOINTMENT = new Prefix("t/");
    public static final Prefix PREFIX_DATE = new Prefix("d/");
    public static final Prefix PREFIX_STARTTIME = new Prefix("s/");
}
