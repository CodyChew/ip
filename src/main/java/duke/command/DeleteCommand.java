package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Represents a Command to delete an existing object in the TaskList
 */
public class DeleteCommand extends Command {


    private final String markItem;

    /**
     * Constructor takes in a String value of the instruction to be further processed.
     *
     * @param secondArg String argument to specify the Task to delete.
     */
    public DeleteCommand(String secondArg) {
        markItem = secondArg;
    }

    /**
     * Processes the String attribute markItem to make sure that a valid Task number
     * is given. The Task will be deleted from the TaskList if it is valid. Otherwise a
     * DukeException will be thrown. The Storage is updated with this deletion and the
     * Ui Object will print out a relevant message to notify the user on this deletion
     * or exception.
     *
     * @param tasks   TaskList object containing the list of tasks.
     * @param ui      Ui object to output messages to the user.
     * @param storage Storage object to interact and manipulate data from the hard disk.
     * @throws DukeException If number is not a valid item number in the task list.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {

        //check if second argument is integer & valid
        try {
            if ((Integer.parseInt(this.markItem) < 1) || (Integer.parseInt(this.markItem) > tasks.getSize())) {
                throw new DukeException("Please enter a valid item number from the list!");
            }
        } catch (NumberFormatException e) { //second argument wrong format
            throw new DukeException("Please only input 'delete <item number>' with no other inputs!");
        }
        int deleteIndex = Integer.parseInt(this.markItem);

        //delete task
        Task deletedItem = tasks.delete(deleteIndex);

        //print output
        ui.printTaskDeleted(tasks, deletedItem);

        //update storage
        storage.saveListToHardDisk(tasks);
    }

    /**
     * Returns false to indicate that the Command does not exit the program.
     *
     * @return Exit program indicator
     */
    @Override
    public boolean isExit() {
        return false;
    }
}


