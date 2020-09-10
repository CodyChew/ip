package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Represents a Command to exit the program.
 */
public class ExitCommand extends Command {

    /**
     * Exits the program for the user. Returns a String response.
     *
     *  @param tasks   TaskList object containing the list of tasks.
     * @param ui      Ui object to output messages to the user.
     * @param storage Storage object to interact and manipulate data from the hard disk.
     * @return String response to user.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        String output = ui.printExit();
        return output;
    }

    /**
     * Returns true to indicate that the Command exits the program.
     *
     * @return Exit program indicator.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
