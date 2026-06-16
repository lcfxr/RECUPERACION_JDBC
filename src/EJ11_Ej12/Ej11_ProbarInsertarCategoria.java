package EJ11_Ej12;

public class Ej11_ProbarInsertarCategoria {
    public static void main(String[] args) {
        Categoria categoria = new Categoria(1, "Informática");
        CategoriaDAO dao = new CategoriaDAO();
        dao.insertarCategoria(categoria);
    }
    
}
