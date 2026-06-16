package EJ11_Ej12;

import java.util.ArrayList;

public class Ej12_ProbarConsultaCategorias {
    public static void main(String[] args) {
        CategoriaDAO dao = new CategoriaDAO();
        ArrayList<Categoria>categorias=dao.obtenerTodasLasCategorias();
        for(Categoria categoria: categorias){
            System.out.println(categoria.getId()+ " - " +categoria.getNombre());
        }
    }
    
}
