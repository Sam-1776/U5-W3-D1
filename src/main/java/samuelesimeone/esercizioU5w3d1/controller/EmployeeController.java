package samuelesimeone.esercizioU5w3d1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import samuelesimeone.esercizioU5w3d1.dto.EmployeeDTO;
import samuelesimeone.esercizioU5w3d1.entities.Employee;
import samuelesimeone.esercizioU5w3d1.exceptions.BadRequestException;
import samuelesimeone.esercizioU5w3d1.services.EmployeeService;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping
    public Page<Employee> getAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(defaultValue = "id") String order){
        return this.employeeService.getAll(page, size, order);
    }

    @GetMapping("/{id}")
    public Employee getAutoreById(@PathVariable UUID id){
        return this.employeeService.findById(id);
    }


    @PutMapping("/{id}")
    public Employee update(@PathVariable UUID id, @RequestBody EmployeeDTO employeeUp){
        return this.employeeService.update(id, employeeUp);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        this.employeeService.delete(id);
    }

    @PostMapping("/{id}/device/{deviceId}")
    public Employee assignDevice(@PathVariable UUID id, @PathVariable UUID deviceId) throws Exception {
        return this.employeeService.assignDevice(id, deviceId);
    }
}
