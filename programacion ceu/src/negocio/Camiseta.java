
package negocio;

/**
 * crea la clase camiseta
 */
public class Camiseta {
    private int id;
    private String marca;
    private String color;
    private String talla;

    /**
     * Constructor con un ID, marca, color y talla específicos.
     *
     * @param id
     * @param marca
     * @param color
     * @param talla
     */
    public Camiseta(int id, String marca, String color, String talla) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
    }

    /**
     * Constructor con una marca, color y talla específicos.
     *
     * @param marca
     * @param color
     * @param talla
     */
    public Camiseta(String marca, String color, String talla) {
        this.marca = marca;
        this.color = color;
        this.talla = talla;
    }

    /**
     * Constructor de una camiseta con un ID específico.
     *
     * @param id
     */
    public Camiseta(int id) {
        this.id = id;
    }

    public Camiseta(int int1, String next, String next2, int int2) {
    }

    @Override
    /**
     * compara si el id que estás dando es igual al id de la camiseta
     */
    public boolean equals(Object obj) {
        Camiseta zap = (Camiseta) obj;
        return id == zap.id;
    }

    /**
     * @return
     * 
     */
    @Override
    public String toString() {
        return getId() + "," + getMarca() + "," + getColor() + "," + getTalla() + ",";
    }

    /**
     * Obtiene el ID
     *
     * @return El ID
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene la marca
     *
     * @return La marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Obtiene el color
     *
     * @return El color
     */
    public String getColor() {
        return color;
    }

    /**
     * Obtiene la talla
     *
     * @return La talla
     */
    public String getTalla() {
        return talla;
    }

    /**
     * Establece el ID
     *
     * @param id El nuevo ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece la marca
     *
     * @param marca La nueva marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Establece el color
     *
     * @param color El nuevo color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Establece la talla
     *
     * @param talla La nueva talla
     */
    public void setTalla(String talla) {
        this.talla = talla;
    }
}
