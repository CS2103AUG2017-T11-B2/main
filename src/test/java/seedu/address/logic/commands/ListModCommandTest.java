package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_CS2101;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_CS2103;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_GER1000;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.AMY;
import static seedu.address.testutil.TypicalPersons.BOB;
import static seedu.address.testutil.TypicalPersons.BOB_EDITED;
import static seedu.address.testutil.TypicalPersons.CARRIE;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.UndoRedoStack;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.Mod;
import seedu.address.model.person.ReadOnlyPerson;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;

public class ListModCommandTest {
    private Model model;
    private Model expectedModel;
    private ListModCommand listModCommand;
    private ArrayList<Mod> modList;
    private ArrayList<String> tempList;
    private String expectedMessage;

    public final String listModMessage = listModCommand.MESSAGE_SUCCESS + "\n" + "Module names: ";

    @Before
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        modList = new ArrayList<>();
        tempList = new ArrayList<>();
        listModCommand = new ListModCommand();
        listModCommand.setData(model, new CommandHistory(), new UndoRedoStack());
        for (ReadOnlyPerson person : model.getAddressBook().getPersonList()) {
            for (Mod mod : person.getMods()) {
                if (!modList.contains(mod)) {
                    modList.add(mod);
                }
            }
        }
        for (Mod t : modList) {
            tempList.add(t.modName);
        }
        Collections.sort(tempList);

        expectedMessage = listModMessage + tempList.toString().replace(",", "]").replace(" ", " [");

    }

    @Test
    public void execute_showsCorrectModList() {
        assertCommandSuccess(listModCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_addNewPersonWithNewMod_showsCorrectModList()
            throws DuplicatePersonException {
        model.addPerson(AMY);
        expectedModel.addPerson(AMY);
        tempList.add(VALID_MOD_CS2101);
        Collections.sort(tempList);
        expectedMessage = listModMessage + tempList.toString().replace(",", "]").replace(" ", " [");
        assertCommandSuccess(listModCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_addNewPersonWithNoMod_showsCorrectModList()
            throws DuplicatePersonException {
        model.addPerson(CARRIE);
        expectedModel.addPerson(CARRIE);
        expectedMessage = listModMessage + tempList.toString().replace(",", "]").replace(" ", " [");
        assertCommandSuccess(listModCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_editPersonWithPresentMod_showsCorrectModList()
            throws DuplicatePersonException, PersonNotFoundException {
        model.addPerson(BOB);
        expectedModel.addPerson(BOB);
        tempList.add(VALID_MOD_GER1000);
        tempList.add(VALID_MOD_CS2101);

        model.updatePerson(BOB, BOB_EDITED);
        expectedModel.updatePerson(BOB, BOB_EDITED);
        tempList.remove(VALID_MOD_GER1000);
        tempList.add(VALID_MOD_CS2103);
        Collections.sort(tempList);
        expectedMessage = listModMessage + tempList.toString().replace(",", "]").replace(" ", " [");
        assertCommandSuccess(listModCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_deletePersonWithUniqueMod_showsCorrectModList()
            throws DuplicatePersonException, PersonNotFoundException {
        model.addPerson(AMY);
        model.addPerson(BOB);
        model.addPerson(CARRIE);
        expectedModel.addPerson(AMY);
        expectedModel.addPerson(BOB);
        expectedModel.addPerson(CARRIE);
        tempList.add(VALID_MOD_CS2101);
        tempList.add(VALID_MOD_GER1000);

        model.deletePerson(BOB);
        expectedModel.deletePerson(BOB);
        tempList.remove(VALID_MOD_GER1000);
        Collections.sort(tempList);
        expectedMessage = listModMessage + tempList.toString().replace(",", "]").replace(" ", " [");
        assertCommandSuccess(listModCommand, model, expectedMessage, expectedModel);
    }
}
