package server;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.fp.dam.naipes.blackjack.Blackjack;

public class Partidas {

	private Map<String, Blackjack> partidas = new HashMap<>();
	
	public synchronized String crear() {
		UUID uuid = UUID.randomUUID();
		String uuidBase64 = Base64.getEncoder().encodeToString(uuid.toString().getBytes());
		partidas.put(uuidBase64, new Blackjack());
		return uuidBase64;
	}
	
	public synchronized Blackjack get(String hash) {
		return partidas.get(hash);
	}
	
	public synchronized void borrar(String hash) {
		partidas.remove(hash);
	}
}
