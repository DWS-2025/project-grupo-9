package com.gym_admin.controllers;

import com.gym_admin.models.Class;
import com.gym_admin.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classes") // Todas las rutas empiezan con /classes
public class ClassController {

    @Autowired
    private ClassService classService;

    // 📌 Mostrar la lista de clases en la vista Thymeleaf
    @GetMapping
    public String showClasses(Model model) {
        List<Class> classList = classService.getAllClasses();
        model.addAttribute("classes", classList);
        return "ManageClass"; // Carga el archivo Thymeleaf "classes.html"
    }

    // 📌 Mostrar formulario para crear una nueva clase
    @GetMapping("/new")
    public String showCreateClassForm(Model model) {
        model.addAttribute("classForm", new Class()); // Se pasa un objeto vacío
        return "class-form"; // Carga el formulario en "class-form.html"
    }

    // 📌 Guardar una nueva clase desde el formulario
    @PostMapping("/save")
    public String saveClass(@ModelAttribute Class classEntity) {
        classService.saveClass(classEntity);
        return "redirect:/classes"; // Redirige a la lista de clases
    }

    // 📌 Mostrar formulario para editar una clase
    @GetMapping("/edit/{id}")
    public String showEditClassForm(@PathVariable Long id, Model model) {
        Class classEntity = classService.getClassById(id).orElse(null);
        model.addAttribute("class", classEntity);
        return "class-form"; // Usa la misma vista del formulario
    }

    // 📌 Eliminar una clase
    @GetMapping("/delete/{id}")
    public String deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return "redirect:/classes";
    }
}







/*package com.gym_admin.controllers;

import com.gym_admin.models.Class;
import com.gym_admin.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/classes")
    public String showClasses(Model model) {
        List<Class> classList = classService.getAllClasses();
        model.addAttribute("classes", classList); // Pasamos las clases a la vista
        return "classes"; // Thymeleaf buscará templates/classes.html
    }
}*/





/*package com.gym_admin.controllers;

import com.gym_admin.models.Class;
import com.gym_admin.models.Equipment;
import com.gym_admin.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    // Get all classes
    @GetMapping
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    // Get a class by ID
    @GetMapping("/{id}")
    public Optional<Class> getClassById(@PathVariable Long id) {
        return classService.getClassById(id);
    }

    // Create a new class
    @PostMapping
    public Class createClass(@RequestBody Class classEntity) {
        return classService.saveClass(classEntity);
    }

    // Update a class
    @PutMapping("/{id}")
    public Class updateClass(@PathVariable Long id, @RequestBody Class classEntity) {
        return classService.updateClass(id, classEntity);
    }

    // Delete a class
    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
    }

    // Get the equipment associated with a class
    @GetMapping("/{id}/equipment")
    public List<Equipment> getClassEquipment(@PathVariable Long id) {
        return classService.getClassEquipment(id);
    }
}*/




