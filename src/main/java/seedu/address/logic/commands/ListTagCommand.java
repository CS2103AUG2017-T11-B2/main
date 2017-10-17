package seedu.address.logic.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javafx.collections.ObservableList;
import seedu.address.model.person.ReadOnlyPerson;

/**
 * Lists all tags in the address book to the user.
 */
public class ListTagCommand extends Command {

    public static final String COMMAND_WORD = "listTag";
    public static final String COMMAND_ALIAS = "lt";

    public static final String MESSAGE_SUCCESS = "Listed all tags";

    private ArrayList<String> tagList = new ArrayList<>();
    private String tagString = "Tag names: ";


    @Override
    public CommandResult execute() {
        return new CommandResult(MESSAGE_SUCCESS + "\n" +  getAllTags());
    }

    public String getAllTags() {
        String temp = "";
        String[] str;
        ArrayList<String> tempList = new ArrayList<>();
        ObservableList<ReadOnlyPerson> personList = model.getAddressBook().getPersonList();

        for (int i = 0; i < personList.size(); i++) {
            ReadOnlyPerson person = personList.get(i);
            tagList.add(person.getTags().toString().replace("[", " ").replace("]", " "));
        }

        for (int j = 0; j < tagList.size(); j++) {
            tempList.add(tagList.get(j).trim());
        }

        for (int k = 0; k < tempList.size(); k++) {
            temp += tempList.get(k).trim().replace(",", "") + " ";
        }

        str = temp.split(" ");
        tempList.clear();

        for (int m = 0; m < str.length; m++) {
            tempList.add(m, str[m]);
        }

        Collections.sort(tempList);

        for (int n = 0; n < tempList.size() - 1; n++) {
            for (int p = n + 1; p < tempList.size(); p++) {
                if (tempList.get(n).equals(tempList.get(p))) {
                    tempList.remove(p);
                }
            }
        }

        for (int q = 0; q < tempList.size(); q++) {
            if (!tempList.get(q).trim().equals("")) {
                tagString += "[" + tempList.get(q) + "]";
            }
        }

        return tagString;
    }

}
