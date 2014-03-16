package erm.model.business.manager;

import erm.model.business.exception.ServiceLoadException;
import erm.model.domain.Comment;
import erm.model.domain.Interaction;
import erm.model.domain.Task;
import erm.model.svc.comment.ICommentService;
import erm.model.svc.task.ITaskService;
import erm.service.endpoint.InteractionService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Business Manager : facade handles the processing of question work flow for
 * presentation tier 1. Loads properties file using the PropertyManager 2.
 * Executes work flow of the application using services and domain value objects
 *
 * @author Daniel.Jones
 * @version 1.0
 */
public class InteractionManager extends Manager implements InteractionService {

    private static InteractionManager _managerInstance;

    private InteractionManager() {
    }

    /**
     * Implements the singleton pattern
     *
     * @return InteractionManager : a single instance | new only if currently
     * null
     */
    public static synchronized InteractionManager getInstance() {
        if (_managerInstance == null) {
            _managerInstance = new InteractionManager();
        }
        return _managerInstance;
    }

    /**
     * @param id : id of the interaction to retrieve
     * @return : Interaction from data source
     */
    @Override
    public Interaction getInteraction(long id) {

        Interaction interaction = new Interaction();

        try {

            ICommentService commentService = (ICommentService) getService(ICommentService.NAME);
            Comment comment = commentService != null ? commentService.getComment(id) : null;

            ITaskService taskService = (ITaskService) getService(ITaskService.NAME);
            List<Task> tasks = taskService != null ? taskService.getAllTasks() : null;

            interaction.setComment(comment);
            interaction.setTasks(tasks);

        } catch (ServiceLoadException sle) {

            Logger.getLogger("Fatal Error : Comment Service failed to load").
                    log(Level.SEVERE, null, sle);

            System.exit(1);

        }

        return interaction;

    }

    @Override
    public List<Interaction> getAllInteractions() {

        Interaction interaction1 = new Interaction();
        Interaction interaction2 = new Interaction();

        try {

            ICommentService commentService = (ICommentService) getService(ICommentService.NAME);
            Comment comment = commentService != null ? commentService.getComment(1) : null;

            ITaskService taskService = (ITaskService) getService(ITaskService.NAME);
            List<Task> tasks = taskService != null ? taskService.getAllTasks() : null;

            interaction1.setComment(comment);
            interaction1.setTasks(tasks);

            interaction2.setComment(comment);
            interaction2.setTasks(tasks);

        } catch (ServiceLoadException sle) {

            Logger.getLogger("Fatal Error : Comment Service failed to load").
                    log(Level.SEVERE, null, sle);

            System.exit(1);

        }

        List<Interaction> interactions = new ArrayList<>();
        interactions.add(interaction1);
        interactions.add(interaction2);

        return interactions;

    }

    @Override
    public boolean saveInteraction(Interaction interaction) {

        boolean result = false;
        boolean comResult = true;
        boolean taskResult = true;

        try {

            ICommentService commentService = (ICommentService) getService(ICommentService.NAME);
            if (interaction.getComment() != null) {

                comResult = commentService != null
                        ? commentService.saveComment(interaction.getComment()) : null;
            }

            ITaskService taskService = (ITaskService) getService(ITaskService.NAME);
            if (interaction.getTasks() != null) {

                for (Task task : interaction.getTasks()) {

                    taskResult = taskService != null
                            ? taskService.saveTask(task) : null;

                }

            }

            result = comResult && taskResult;

        } catch (ServiceLoadException sle) {

            Logger.getLogger("Fatal Error : Comment Service failed to load").
                    log(Level.SEVERE, null, sle);

            System.exit(1);

        }

        return result;

    }

    @Override
    public long createInteraction(Interaction interaction) {

        return 1L;

    }

    @Override
    public boolean deleteInteraction(long id) {

        return true;

    }

}
