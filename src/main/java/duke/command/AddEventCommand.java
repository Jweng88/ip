package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;
import duke.task.Event;

/**
 * Represents a command to add an event task.
 * Inherits from the Command class.
 */
public class AddEventCommand extends Command {

    /** The description of the event to add */
    private final String description;

    /** The start time of the event to add */
    private final String from;

    /** The end time of the event to add */
    private final String to;

    /**
     * Constructs an AddEventCommand object with the given description, start time, and end time.
     *
     * @param description The description of the event task.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public AddEventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    /**
     * Executes the AddEventCommand by adding the event task to the task list.
     *
     * @param tasks The task list.
     * @param ui The user interface.
     * @param storage The storage component.
     * @throws DukeException If an error occurs while executing the command.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (description.isEmpty() || from.isEmpty() || to.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The format of an event should be: event DESCRIPTION /from DATE /to DATE");
        }
        tasks.addTask(new Event(description, from, to));
        ui.showTaskAddedMessage(tasks);
    }

    /**
     * Returns a boolean indicating whether the command is an exit command.
     *
     * @return A boolean indicating whether the command is an exit command.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
