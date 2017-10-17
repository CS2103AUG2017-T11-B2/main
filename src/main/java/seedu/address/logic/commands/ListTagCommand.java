package seedu.address.logic.commands;

import java.util.ArrayList;
import java.util.Collections;

import seedu.address.model.person.ReadOnlyPerson;
import seedu.address.model.tag.Tag;

/**
 * Lists all tags in the address book to the user.
 */
public class ListTagCommand extends Command {

    public static final String COMMAND_WORD = "listTag";
    public static final String COMMAND_ALIAS = "lt";

    public static final String MESSAGE_SUCCESS = "Listed all tags";

    private ArrayList<Tag> tagList = new ArrayList<>();
    private ArrayList<String> tempList = new ArrayList<>();
    private String tagString = "Tag names: ";


    @Override
    public CommandResult execute() {
        extractAllTags();
        sortTags();
        return new CommandResult(MESSAGE_SUCCESS + "\n" + tagString + formatTagString());
    }

    private String formatTagString() {
        return tempList.toString().replace(",", "]").replace(" ", " [");
    }

    private void sortTags() {
        for (Tag t : tagList) {
            tempList.add(t.tagName);
        }

        Collections.sort(tempList);
    }

    private void extractAllTags() {
        for (ReadOnlyPerson person : model.getAddressBook().getPersonList()) {
            for (Tag tag : person.getTags()) {
                if (!tagList.contains(tag)) {
                    tagList.add(tag);
                }
            }
        }
    }

}
