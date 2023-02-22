import java.util.Random;
public class Fumador implements Runnable {
    public int numFumador;
    public String NombreFumador;
    public Ingredientes ingredientes;
    public Ingredientes ingredientesAgente;
    public Thread hilo;
    Fumador(int IngredienteDefault, Ingredientes ing){
        hilo= new Thread(this);
        this.ingredientes = new Ingredientes();
        this.ingredientesAgente = ing;
        this.numFumador = IngredienteDefault -1;
        switch (IngredienteDefault){
            case 1:
                ingredientes.fosforos = true;
                break;
            case 2:
                ingredientes.papel = true;
                break;
            case 3:
                ingredientes.tabaco = true;
                break;
        }
    }

    public static Fumador InicializaHilo (int IngredienteDefault, Ingredientes ing){
        Fumador miHilo=new Fumador(IngredienteDefault,ing);
        miHilo.hilo.start();
        return miHilo;
    }
    boolean Fumar(){
        Random rand = new Random(); // Esto crea una instancia de la Clase Random
        System.out.println("Fumador #"+numFumador+" - Enrollando cigarrillo      /___****___/");
        this.esperarXsegundos(rand.nextInt(3));
        System.out.println("Fumador #"+numFumador+" - Fumando cigarrillo         /_______/~~~");
        this.esperarXsegundos(rand.nextInt(7));
        System.out.println("Fumador #"+numFumador+" - Termino de fumar           /_/~");
        this.esperarXsegundos(rand.nextInt(3));
        return true;
    }
    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public boolean validarIngredientes(Ingredientes ing){
        System.out.println("Fumador #"+numFumador+" Tiene "+(this.ingredientes.tabaco?"Tabaco":"")+(this.ingredientes.fosforos?"Fosforos":"")+(this.ingredientes.papel?"Papel":""));
        if(this.ingredientes.tabaco != ing.tabaco && this.ingredientes.papel!= ing.papel && this.ingredientes.fosforos != ing.fosforos){
            System.out.println("Fumador #"+numFumador+" - Si va a fumar");
            Fumar();
            return true;
        }
        else{
            System.out.println("Fumador #"+numFumador+" - No va a fumar");
            return false;
        }
    }

    public void run() {
        //synchronized (ingredientesAgente) {
            validarIngredientes(ingredientesAgente);
      //  }
    }
}

