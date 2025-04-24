import java.util.ArrayList;

class LibretaNotas {

    private static int indiceNotas = 0;
    private static ArrayList<Estudiante> notas = new ArrayList<>();

    static void agregarEstudiante  ( String name, String apellido, int numero, String rut){
        Estudiante estudiante = new Estudiante(name, apellido, numero , rut);
        notas.add(estudiante);
        indiceNotas += 1;


    }

    static Estudiante estudiante( int id){
        return  notas.get(id);
    }

    static void notasCurso(){
        ArrayList<Double> nota = new ArrayList<>();
        for(Estudiante target: notas) {
            if(target.promedio() == -1.0){

            }else{
                nota.add(target.promedio());
            }

        }
        double suma = 0;
        for(int i = 0; i < nota.size(); i++){
            suma += nota.get(i);
        }

        System.out.println("Estudiantes: " + (nota.size()));
        System.out.println("Promedio de notas curso: " + (suma / notas.size()));

    }

    static void mostrarEstudiantes() {
        int total = 0;
        if (indiceNotas != 0) {

            ArrayList<Integer> filasLength = new ArrayList<>();


            for (int i = 0; i < indiceNotas; i++) {
                Estudiante estudiante = notas.get(i);
                String[] test = estudiante.obtenerDatos();
                for (int z = 0; z < test.length; z++) {
                    if (filasLength.size() <= z) {
                        filasLength.add(test[z].length());
                    } else if (filasLength.get(z) < test[z].length()) {
                        filasLength.set(z, test[z].length());
                    }
                }
            }


            String[] nombres = { "Nombre", "Celular", "Rut", "Aprueba" };


            for (int i = 0; i < nombres.length; i++) {
                if (filasLength.get(i) < nombres[i].length()) {
                    filasLength.set(i, nombres[i].length());
                }
            }


            String lineaDivisoria = "+----+";
            for (int len : filasLength) {
                lineaDivisoria += "-".repeat(len + 2) + "+";
            }


            System.out.println(lineaDivisoria);


            String mensajeIndex = "| ID |";
            for (int i = 0; i < nombres.length; i++) {
                mensajeIndex += " " + nombres[i];
                int diferencia = filasLength.get(i) - nombres[i].length();
                mensajeIndex += " ".repeat(diferencia) + " |";
            }

            System.out.println(mensajeIndex);
            System.out.println(lineaDivisoria);


            for (int x = 0; x < notas.size(); x++) {
                String fila = String.format("| %2d |", x);
                Estudiante estudianteX = notas.get(x);
                String[] testX = estudianteX.obtenerDatos();
                for (int f = 0; f < testX.length; f++) {
                    fila += " " + testX[f];
                    int diferencia = filasLength.get(f) - testX[f].length();
                    fila += " ".repeat(diferencia) + " |";
                }
                System.out.println(fila);
            }


            System.out.println(lineaDivisoria);

        } else {
            System.out.println("No hay registros de notas estudiantiles");
        }
    }


    static int numeroEstudiantes(){
       return notas.size();
    }

    static void agregarNotas(Integer id, double[] nota){
        Estudiante target = notas.get(id);
        target.agregarNota(nota);
    }

    static void infoLibreta(){

    }

    static void mostrarNotas(Integer id){
        Estudiante target = notas.get(id);
        ArrayList<Double> arrays = target.obtenerNotas();
        System.out.println(arrays);

    }


}

