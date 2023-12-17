package presentacion;

import java.util.ArrayList;

import negocio.Tienda;
import negocio.Camiseta;

/**
 *
 */
public class interfazUsuario {
	private static String negrita = "\u001B[1m";
	private static String normal = "\033[0m";
	private static String rojo = "\u001B[31m";
	private static String blanco = "\u001B[37m";

	public static void ejecutar(String[] instruccion) {

		Tienda tienda = new Tienda();
		if (instruccion.length == 0) {
			ayuda();
		} else if (instruccion[0].equalsIgnoreCase("mostrar") && instruccion.length == 1) {
			mostrarcamiseta(tienda);

		} else if (instruccion[0].equalsIgnoreCase("añadir") && instruccion.length == 4) {
			int instruccion3 = Integer.parseInt(instruccion[3]);
			Camiseta camiseta = new Camiseta(instruccion[1], instruccion[2], (instruccion[3]));
			tienda.annadir(camiseta);

		} else if (instruccion[0].equalsIgnoreCase("borrar") && instruccion.length == 2) {
			Camiseta camiseta = new Camiseta(Integer.parseInt(instruccion[1]));
			tienda.borrar(camiseta);

		} else if (instruccion[0].equalsIgnoreCase("modificar") && instruccion.length == 5) {
			int instruccion1 = Integer.parseInt(instruccion[1]);
			int instruccion5 = Integer.parseInt(instruccion[4]);
			Camiseta camisetaModificada = new Camiseta(Integer.parseInt(instruccion[1]), instruccion[2], instruccion[3],
					Integer.parseInt(instruccion[4]));

			tienda.modificar(camisetaModificada);
		} else if (instruccion[0].equalsIgnoreCase("ayuda") && instruccion.length == 1) {
			ayuda();
		} else {
			System.out.println(rojo + "El formato utilizado en la entrada es incorrecto" + blanco);
			ayuda();
		}

	}

	private static void mostrarcamiseta(Tienda tienda) {
		ArrayList<Camiseta> listacamiseta = tienda.getcamisetasTienda();
		for (Camiseta camiseta : listacamiseta) {
			System.out.println(camiseta);
		}
	}

	private static void ayuda() {
		System.out.println("\n" + negrita + "DESCRIPCIÓN" + normal);
		System.out.println("\t Menu:\n\n" +
				"\t-  añadir camiseta \n" +
				"\t- mostrar camisetas \n" +
				"\t- borrar camisetas\n" +
				"\t- modificar l ");
		System.out.println(negrita + "FORMATO" + normal);
		System.out.println("\tPara añadir una camiseta, escribe:\n");
		System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal añadir <marca> <color> <talla>"
				+ normal + "\n");
		System.out.println("\tPara mostrar las camisetas  teclea:\n");
		System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal mostrar" + normal + "\n");
		System.out.println("\tPara mostrar  ayuda escribe:\n");
		System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal ayuda" + normal + "\n");
		System.out.println("\tPara borrar  camisetas , teclea:\n");
		System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal borrar <id>" + normal + "\n");
		System.out.println("\tPara modificar camisetas,teclea:\n");
		System.out.println("\t\t" + negrita
				+ "java -cp bin puntoEntrada.Principal modificar <id> <marca> <color> <talla>" + normal + "\n");
		System.out.println(negrita + "EJEMPLOS" + normal);
		System.out.println("\tEjemplo 1\n");
		System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal añadir nike roja M" + normal + "\n");
		System.out.println("\tEjemplo 2\n");
		System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal borrar 3" + normal + "\n");
		System.out.println("\tEjemplo 3\n");
		System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal mostrar" + normal + "\n");
		System.out.println("\tEjemplo 4\n");
		System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal ayuda" + normal + "\n");
		System.out.println("\tEjemplo 5\n");
		System.out.println(
				"\t\t" + negrita + "java -cp bin puntoEntrada.Principal modificar 1 nike roja M" + normal + "\n");

	}
}
