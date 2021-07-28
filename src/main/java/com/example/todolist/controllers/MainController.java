package com.example.todolist.controllers;


import com.example.todolist.entities.Tasks;
import com.example.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/")
    public String index(Model model){
        List<Tasks> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks );
        return "index";
    }

    @PostMapping(value = "/deletetask/{itemId}")
    public String deleteUser(Model model, @PathVariable(name = "itemId") Long id){

        taskService.deleteTask(id);


        return "redirect:/";
    }

    @PostMapping(value = "/addtask")
    public String addUser(@RequestParam(name = "name")String name,
                          @RequestParam(name = "date") String date,
                          @RequestParam(name = "priority") String priority,
                          @RequestParam(name = "description") String description,
                          @RequestParam(name = "status") String status){

        Tasks task = new Tasks();
        task.setName(name);
        task.setDate(date);
        task.setPriority(priority);
        task.setDescription(description);
        task.setStatus(status);


        taskService.addTask(task);

        return "redirect:/";

    }

    @GetMapping(value = "/details/{itemId}")
    public String getItem(Model model, @PathVariable(name = "itemId") Long id){
        Tasks task = taskService.getItem(id);
        model.addAttribute("task", task);

        return "details";
    }


    @PostMapping(value = "/savetask")
    public String saveTask(@RequestParam(name = "id") Long id,
                           @RequestParam(name="name") String name_,
                           @RequestParam(name="date") String date,
                           @RequestParam(name="priority") String priority,
                           @RequestParam(name = "description") String description,
                           @RequestParam(name = "status") String status){



        Tasks task = taskService.getItem(id);
        if(task!=null){

            task.setName(name_);
            task.setDate(date);
            task.setPriority(priority);
            task.setDescription(description);
            task.setStatus(status);

            taskService.saveTask(task);
            return "redirect:/";
        }

        return "redirect:/";
    }

}
