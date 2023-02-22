import java.util.Scanner;
public class Main {
    public static Fumador[] fumadores = new Fumador[3];
    public static Agente agente = new Agente();
    public static void main(String[] args) {
        System.out.println("" +
                "EL AGENTE Y LOS FUMADORES" +"\n" +
                "/////////////////////////////////////////////////////"+"\n" +
                "//                                                  //"+"\n"  +
                "//   ////////      ()()           //                //"+"\n"  +
                "//   /      /      ||||           ()                //"+"\n"  +
                "//   /      /      ||||          (    )             //"+"\n"  +
                "//   ////////      ||||         ////////            //"+"\n"  +
                "//    Papel       Fosforos        Tabaco            //"+"\n"  +
                "//                                                  //"+"\n" +
                "/////////////////////////////////////////////////////" +"\n" +
                "" +
                "");

        System.out.println("Ingrese cantidad de rondas: ");
        Scanner leer=new Scanner(System.in);
        int num=leer.nextInt();
        int count = 0;
        while (count <num){
            Ingredientes ingredientes = agente.ColocarSobreMesaIngredientes();

            fumadores[0] = Fumador.InicializaHilo(3,ingredientes);
            fumadores[1] = Fumador.InicializaHilo(1,ingredientes);
            fumadores[2] = Fumador.InicializaHilo(2,ingredientes);


            try {
                fumadores[0].hilo.join();
                fumadores[1].hilo.join();
                fumadores[2].hilo.join();
            }catch (InterruptedException exc){
                System.out.println("end");
            }
            System.out.println("Numero Ronda: "+count);
            agente.LimpiarMesa();
            count ++;

        }
    }


}