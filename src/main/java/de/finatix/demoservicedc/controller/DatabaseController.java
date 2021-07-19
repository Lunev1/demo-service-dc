package de.finatix.demoservicedc.controller;

import de.finatix.demoservicedc.database.model.Register;
import de.finatix.demoservicedc.database.repository.RegisterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    Logger logger = LoggerFactory.getLogger(DatabaseController.class);

    @Autowired
    private RegisterRepository registerRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewRegister(@RequestParam String name, @RequestParam String type) {
        Register n = new Register();
        n.setName(name);
        n.setType(type);
        registerRepository.save(n);
        logger.info(String.format("dataset added: %s, %s", name, type));
        return "Saved successfully";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Register> getAllRegister() {
        logger.info("all registered datasets requested");
        return registerRepository.findAll();
    }
}
