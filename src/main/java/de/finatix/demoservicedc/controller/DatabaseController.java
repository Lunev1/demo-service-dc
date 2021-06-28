package de.finatix.demoservicedc.controller;

import de.finatix.demoservicedc.database.model.Register;
import de.finatix.demoservicedc.database.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    @Autowired
    private RegisterRepository registerRepository;

    @GetMapping("/greeting")
    public Register getRegister() {
        return new Register();
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewRegister(@RequestParam String name, @RequestParam String type) {
        Register n = new Register();
        n.setName(name);
        n.setType(type);
        registerRepository.save(n);
        return "Saved successfully";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Register> getAllRegister() {
        // This returns a JSON or XML with the registers
        return registerRepository.findAll();
    }
}
