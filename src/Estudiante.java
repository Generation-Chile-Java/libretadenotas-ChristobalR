import java.util.ArrayList;
import java.util.HashMap;

class Estudiante{
    private String name;
    private String apellido;
    private int numero;
    private String rut;
    private String direccion;
    private String correo;
    private String biografia;
    private ArrayList<Double> notas = new ArrayList<>();


    Double promedio(){
        double suma = 0;
        if(notas.size() == 0){
            return -1.0 ;
        }else{

            for(Double nota: notas){
                suma += nota;
            }
            double promedio = suma / notas.size();
            return promedio;


        }
    }

    void agregarNota(double[] nota) {
        for(int i = 0; i < nota.length; i++){
            notas.add(nota[i]);

        }
    }

    ArrayList<Double> obtenerNotas(){
        return notas;
    }

    String obtenerNombre(){
        return name;
    }

    String[] obtenerDatos(){
        String aprueba;
        if (promedio() > 4.0){
            aprueba = "Si";
        }else if(promedio() < 0) {
            aprueba = "Sin notas";
        }else {
            aprueba = "no";
        }

        String[] array = {name + " " + apellido, "" + numero, rut, aprueba};
        return array;

    };

    HashMap<String, Object> obtenerData(){
        HashMap<String,Object> datos = new HashMap<>();
        datos.put("Nombre",name);
        datos.put("Apellido", apellido);
        datos.put("Numero", numero);
        datos.put("Rut", rut);
        datos.put("Direccion", direccion );
        datos.put("Biografia", biografia);
        return datos;

    };

    Estudiante(String name, String apellido, int numero, String rut) {
        this.name = name;
        this.apellido = apellido;
        this.numero = numero;
        this.rut = rut;

    }

}

