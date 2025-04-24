import java.util.*;

//  for(HashMap.Entry<Integer, Estudiante> entrada : notas.entrySet()){

//        System.out.println(entrada.getKey());
  //      System.out.println(entrada.getValue().obtenerNotas());

    //    }

public class Main {

     static void fizzBuzz() {


        for(int i = 0; i < 100; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("fizBuz");
            }else if(i % 3 == 0) {
                System.out.println("Fizz");
            }else if( i % 5 == 0){
                System.out.println("buzz");
            }else {
                System.out.println(i);
            }
        }



    }



    static void despegue(){
        int numero = sc.nextInt();
        System.out.println("Ha iniciado el despegue!!!");
        for(int i = numero; i >= 0; i --){
            if(i == 0){
                System.out.println("Despegue!!!!");
            }else {
                System.out.println("Cuenta regresiva!: " + i);
            }

        }

    }


    public static void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    static Scanner sc = new Scanner(System.in);





    public static void main(String[] args){








        System.out.println("Bienvenido a la libreta de notas!");







        while(true){

            limpiarConsola();
            System.out.println("1- Lista de estudiantes");
            System.out.println("2- Agregar Estudiante");
            System.out.println("3- Notas curso");
            System.out.println("4- Agregar Notas");

            int caso = sc.nextInt();
            sc.nextLine();

            switch(caso){
                case 1: {

                    boolean stateA = true;
                    while(stateA){


                        limpiarConsola();
                        System.out.println("");
                        LibretaNotas.mostrarEstudiantes();

                        System.out.println("");
                        System.out.println(" ¿Le gustaria ver un estudiante en especifico? y/n");

                        String input = sc.nextLine();




                        if(input.equals("y")){
                            limpiarConsola();
                            System.out.println("Ingrese el id del Estudiante: ");

                            boolean stateIdEstudiante = true;
                            while(stateIdEstudiante){
                                Integer idEstudiante = sc.nextInt();
                                sc.nextLine();

                                if(idEstudiante < LibretaNotas.numeroEstudiantes() && idEstudiante >= 0){
                                    Estudiante estudiante = LibretaNotas.estudiante(idEstudiante);
                                    limpiarConsola();
                                    System.out.println(estudiante.obtenerData().get("Nombre"));

                                    stateIdEstudiante = false;




                                }else {
                                    System.out.println("Ingrese un Id valido");
                                    continue;
                                }
                            }






                        }else if(input.equals("n")){
                            System.out.println("logica para preguntar si quiere volver al menu principal");
                            stateA = false;
                        }else {
                            stateA = true;
                        }

                    }
                    break;




                }

                case 2: {
                    limpiarConsola();

                    System.out.println("Escribe el nombre:");
                    String nombre = sc.nextLine();

                    System.out.println("Escribe el Apellido:");
                    String apellido = sc.nextLine();

                    System.out.println("Escribe el numero");
                    Integer numero = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Escribe el rut");
                    String rut = sc.nextLine();

                    LibretaNotas.agregarEstudiante(nombre,apellido,numero,rut);



                }
                break;

                case 3: {
                    limpiarConsola();
                    LibretaNotas.notasCurso();
                    String lineaNotas3 = sc.nextLine();
                }
                break;
                case 4: {
                    limpiarConsola();
                    System.out.println("Ingrese el id del estudiante: ");
                    Integer id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Ingrese las notas que desea agregar al estudiante:");
                    System.out.println("Puede ser más de una ingresada en este formato '2.5 5.5 5.0' etc:");

                    String lineaNotas = sc.nextLine();
                    String[] partes = lineaNotas.split(" ");

                    double[] notas = new double[partes.length];

                    for (int i = 0; i < partes.length; i++) {
                        try {
                            notas[i] = Double.parseDouble(partes[i]);
                        } catch (NumberFormatException e) {
                            System.out.println("Formato inválido en: " + partes[i]);

                        }
                    }
                    LibretaNotas.agregarNotas(id, notas);
                    LibretaNotas.mostrarNotas(id);
                }



                    break;


                default: {
                    System.out.println("xd");
                    break;
                }
            }

        }


    }

}




