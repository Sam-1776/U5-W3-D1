package samuelesimeone.esercizioU5w3d1.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelesimeone.esercizioU5w3d1.entities.Device;

import java.util.UUID;

@Repository
public interface DeviceDAO extends JpaRepository<Device, UUID> {
}
