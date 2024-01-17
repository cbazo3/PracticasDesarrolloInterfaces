package apartadoA;

import java.io.Serializable;

public class Libro implements Serializable{
	private static final long serialVersionUID = 1L;

    private String titulo;
    private String autor;
    private int anioPublicacion;
    
    public Libro() {}
    

	public Libro(String titulo, String autor, int anioPublicacion) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
    

}
