package samuelesimeone.esercizioU5w3d1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelesimeone.esercizioU5w3d1.entities.Employee;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, UUID> {
    Optional<Employee> findByEmail(String email);

}
