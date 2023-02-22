import java.util.Random;

public class Agente {
    public Ingredientes ingredientes;

    public Ingredientes ColocarSobreMesaIngredientes(){
        Random rand = new Random();
        int ingrediente1 = rand.nextInt(3);
        int ingrediente2 = 0;
        String nombreIngrediente1 = "";
        String nombreIngrediente2 = "";
        do {
            ingrediente2 = rand.nextInt(3);
        }while(ingrediente2 ==ingrediente1);
        Ingredientes ingredientes = new Ingredientes();
        switch (ingrediente1){
            case 0:
                ingredientes.fosforos = true;
                nombreIngrediente1 = "Fosforos";
                break;
            case 1:
                ingredientes.papel = true;
                nombreIngrediente1 = "Papel";
                break;
            case 2:
                ingredientes.tabaco = true;
                nombreIngrediente1 = "Tabaco";
                break;
        }
        switch (ingrediente2){
            case 0:
                ingredientes.fosforos = true;
                nombreIngrediente2 = "Fosforos";
                break;
            case 1:
                ingredientes.papel = true;
                nombreIngrediente2 = "Papel";
                break;
            case 2:
                ingredientes.tabaco = true;
                nombreIngrediente2 = "Tabaco";
                break;
        }

        System.out.println("El agente coloca sobre la mesa los ingredientes:" );

        if((ingrediente1 ==0 && ingrediente2 ==1) || (ingrediente2==0 && ingrediente1 ==1)){
            System.out.println("" +
                    "/////////////////////////////////////////////////////"+"\n" +
                    "//                                                  //"+"\n"  +
                    "//   ////////      ()()                             //"+"\n"  +
                    "//   /      /      ||||                             //"+"\n"  +
                    "//   /      /      ||||                             //"+"\n"  +
                    "//   ////////      ||||                             //"+"\n"  +
                    "//    Papel       Fosforos                          //"+"\n"  +
                    "//                                                  //"+"\n" +
                    "/////////////////////////////////////////////////////" +"\n" +
                    "" +
                    "");
        }
        if((ingrediente1 ==0 && ingrediente2 ==2)|| (ingrediente1 ==2 && ingrediente2==0)){
            System.out.println("" +
                    "/////////////////////////////////////////////////////"+"\n" +
                    "//                                                  //"+"\n"  +
                    "//                 ()()           //                //"+"\n"  +
                    "//                 ||||           ()                //"+"\n"  +
                    "//                 ||||          (    )             //"+"\n"  +
                    "//                 ||||         ////////            //"+"\n"  +
                    "//                Fosforos        Tabaco            //"+"\n"  +
                    "//                                                  //"+"\n" +
                    "/////////////////////////////////////////////////////" +"\n" +
                    "" +
                    "");
        }
        if((ingrediente1 ==1 && ingrediente2 ==2)|| (ingrediente1 ==2 && ingrediente2==1)){

            System.out.println("" +
                    "/////////////////////////////////////////////////////"+"\n" +
                    "//                                                  //"+"\n"  +
                    "//   ////////                     //                //"+"\n"  +
                    "//   /      /                     ()                //"+"\n"  +
                    "//   /      /                    (    )             //"+"\n"  +
                    "//   ////////                   ////////            //"+"\n"  +
                    "//    Papel                       Tabaco            //"+"\n"  +
                    "//                                                  //"+"\n" +
                    "/////////////////////////////////////////////////////" +"\n" +
                    "" +
                    "");
        }



        return ingredientes;
    }
    public void LimpiarMesa(){
        this.ingredientes = new Ingredientes();
    }

}
