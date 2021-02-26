package meniuprincipal;

public class Carte {
	
	private String denumire;
	private String autor;
	private String cod;
	private String form;
	private int an;
	
	private String locatie;

	public Carte(String denumire, String autor, String cod, String form, int an, String locatie) {
		super();
		this.denumire = denumire;
		this.autor = autor;
		this.cod = cod;
		this.form = form;
		this.an = an;
		this.locatie = locatie;
	}

	public Carte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public int getAn() {
		return an;
	}

	public void setAn(int string) {
		this.an = string;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}
	
	@Override
	public String toString() {
		return "Carte [denumire=" + denumire + ", autor=" + autor + ", cod=" + cod + ", form=" + form + ", an=" + an
				+ ", locatie=" + locatie + "]";
	}

}
