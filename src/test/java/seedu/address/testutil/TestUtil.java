package seedu.address.testutil;

import java.io.File;
import java.io.IOException;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.FileUtil;
import seedu.address.model.Model;
import seedu.address.model.person.ReadOnlyPerson;
import seedu.address.model.task.ReadOnlyTask;

/**
 * A utility class for test cases.
 */
public class TestUtil {

    /**
     * Folder used for temp files created during testing. Ignored by Git.
     */
    private static final String SANDBOX_FOLDER = FileUtil.getPath("./src/test/data/sandbox/");

    /**
     * Appends {@code fileName} to the sandbox folder path and returns the resulting string.
     * Creates the sandbox folder if it doesn't exist.
     */
    public static String getFilePathInSandboxFolder(String fileName) {
        try {
            FileUtil.createDirs(new File(SANDBOX_FOLDER));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return SANDBOX_FOLDER + fileName;
    }

    /**
     * Returns the middle index of the person in the {@code model}'s person list.
     */
    public static Index getMidPersonIndex(Model model) {
        return Index.fromOneBased(model.getAddressBook().getPersonList().size() / 2);
    }

    /**
     * Returns the last index of the person in the {@code model}'s person list.
     */
    public static Index getLastPersonIndex(Model model) {
        return Index.fromOneBased(model.getAddressBook().getPersonList().size());
    }

    /**
     * Returns the person in the {@code model}'s person list at {@code index}.
     */
    public static ReadOnlyPerson getPerson(Model model, Index index) {
        return model.getAddressBook().getPersonList().get(index.getZeroBased());
    }

    /**
     * Returns the middle index of the task in the {@code model}'s task list.
     */
    public static Index getMidTaskIndex(Model model) {
        return Index.fromOneBased(model.getAddressBook().getTaskList().size() / 2);
    }

    /**
     * Returns the last index of the task in the {@code model}'s task list.
     */
    public static Index getLastTaskIndex(Model model) {
        return Index.fromOneBased(model.getAddressBook().getTaskList().size());
    }

    /**
     * Returns the task in the {@code model}'s task list at {@code index}.
     */
    public static ReadOnlyTask getTask(Model model, Index index) {
        return model.getAddressBook().getTaskList().get(index.getZeroBased());
    }
}
