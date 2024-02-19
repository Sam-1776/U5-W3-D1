package samuelesimeone.esercizioU5w3d1.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
	public NotFoundException(UUID id) {
		super("L'Elemento con id " + id + " non è stato trovato");
	}
}
