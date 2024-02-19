package samuelesimeone.esercizioU5w3d1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelesimeone.esercizioU5w3d1.dto.EmployeeLoginDTO;
import samuelesimeone.esercizioU5w3d1.entities.Employee;
import samuelesimeone.esercizioU5w3d1.exceptions.UnauthorizedException;
import samuelesimeone.esercizioU5w3d1.security.JWTools;

@Service
public class AuthService {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    JWTools jwTools;

    public String authEmployeeAndGenerateToken(EmployeeLoginDTO body) throws UnauthorizedException{
        // CONTROLLA L'ESISTENZA DELL'UTENTE E LA CORRETTEZZA DELLE CREDENZIALI
        // PASSATI I CONTROLLI GENERA IL TOKE E LO RITORNA COME STRINGA
        Employee user = employeeService.findByEmail(body.email());
        if (user.getPassword().equals(body.password())){
            return jwTools.generateToken(user);
        }else {
            throw new UnauthorizedException("Credenziali errate; Riprovare!");
        }
    }
}
