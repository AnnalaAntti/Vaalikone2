package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kysymys {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private String kysymys;
	private int numero;
	
	public Kysymys() {
		
	}
	public Kysymys(String kysymys, int numero) {
		this.kysymys=kysymys;
		this.numero=numero;
	}
	public Kysymys(int id, String kysymys, int numero) {
		this.id=id;
		this.kysymys=kysymys;
		this.numero=numero;
	}
	public Kysymys(String kysymys, String numero) {
		this.kysymys=kysymys;
		this.setNumero(numero);
	}
	public Kysymys(String id, String kysymys, String numero) {
		this.setId(id);
		this.kysymys=kysymys;
		this.setNumero(numero);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setNumero(String numero) {
		try {
			this.numero = Integer.parseInt(numero);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}
	public String toString() {
		return this.id+": "+this.kysymys+" / "+this.numero;
	}
}
