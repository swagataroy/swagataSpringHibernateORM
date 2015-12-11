package com.swagata.web;

import com.swagata.entity.Task;
import com.swagata.entity.User;
import com.swagata.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TaskController {


    @Autowired
    private TaskService taskService;

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "getTaskList")
    public String getTaskList(ModelMap model, @RequestParam Long userId) {

        List<Task> tasks = taskService.getTaskList(userId);

        model.addAttribute("tasks", tasks);
        model.addAttribute("userId", userId);

        return "task/tasksShow";
    }

    @RequestMapping(value = "getFilterTaskList")
    public String getFilterTaskList(ModelMap model, @RequestParam Long userId, @RequestParam Date firstDate, @RequestParam Date SecondDate) {

        List<Task> tasks = taskService.getFilterTaskList(userId, firstDate, SecondDate);

        model.addAttribute("tasks", tasks);
        model.addAttribute("userId", userId);

        return "task/tasksShow";
    }

    @RequestMapping(value = "renderTask")
    public String renderTask(ModelMap model, @RequestParam Long userId,  @RequestParam Long taskId) {

        Task task = (Task) taskService.getTaskById(taskId);
        task.setUser(new User(userId));
        model.addAttribute("task", task);
        model.addAttribute("userId", userId);

        return "task/addOrEdit";

    }

    @RequestMapping(value = "saveOrUpdateTask", method = RequestMethod.POST)
    public String saveOrUpdateTask(@ModelAttribute Task task) {

        taskService.saveOrUpdate(task);

        return redirectTo("getTaskList?userId=", task.getUser().getUserId());
    }

    @RequestMapping(value = "deleteTask")
    public String deleteTask(@RequestParam Long userId, @RequestParam Long taskId) {

        taskService.delete(taskId);

        return redirectTo("getTaskList?userId=", userId);
    }

    public String redirectTo(String url, Long userId) {
        return "redirect:/".concat(url).concat(String.valueOf(userId));
    }


}
