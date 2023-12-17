package negocio;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

/**
 * la clase Tienda
 */
public class Tienda {
	private ArrayList<Camiseta> camisetasTienda = new ArrayList<>();

	public Tienda() {
		cargarcamisetas();
	}

	/**
	 * Añade una camiseta a la tienda
	 *
	 * @param camiseta
	 */
	public void annadir(Camiseta camiseta) {
		if (!camisetasTienda.isEmpty())
			camiseta.setId(camisetasTienda.get(camisetasTienda.size() - 1).getId() + 1);
		else
			camiseta.setId(1);
		camisetasTienda.add(camiseta);
		volcarcamisetasTienda();
	}

	/**
	 * Elimina una camiseta y actualiza las camisetas en la tienda.
	 *
	 * @param camiseta
	 */

	public void borrar(Camiseta camiseta) {
		camisetasTienda.remove(camiseta);
		volcarcamisetasTienda();
	}

	/**
	 * Obtiene la lista de camisetas.
	 *
	 * @return
	 */

	public ArrayList<Camiseta> getcamisetasTienda() {
		return camisetasTienda;
	}

	private void volcarcamisetasTienda() {
		try {
			FileWriter fw = new FileWriter("tienda.csv");
			for (Camiseta camiseta : camisetasTienda) {
				fw.write(camiseta.getId() + "," +
						camiseta.getMarca() + "," +
						camiseta.getColor() + "," +
						camiseta.getTalla() + ",");
			}
			fw.close();
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	private void cargarcamisetas() {
		try {
			File fichero = new File("tienda.csv");
			/**
			 * Crea el fichero si no existe
			 */
			fichero.createNewFile();
			Scanner sc = new Scanner(fichero);
			sc.useDelimiter(",|\n");
			while (sc.hasNext()) {
				Camiseta camiseta = new Camiseta(Integer.parseInt(sc.next()),
						sc.next(),
						sc.next(),
						Integer.parseInt(sc.next()));
				camisetasTienda.add(camiseta);

			}
			sc.close();
		} catch (IOException ex) {
			System.err.println("No hay camisetas inscritas");
		}
	}

	/**
	 * Modifica una camiseta de la lista de camisetas y lo guarda .
	 * 
	 * @param camisetaModificada:
	 */

	public void modificar(Camiseta camisetaModificada) {
		for (Camiseta camiseta : camisetasTienda) {
			if (camiseta.getId() == camisetaModificada.getId()) {
				camiseta.setMarca(camisetaModificada.getMarca());
				camiseta.setColor(camisetaModificada.getColor());
				camiseta.setTalla(camisetaModificada.getTalla());
				volcarcamisetasTienda();
				return;
			}
		}
	}
}
