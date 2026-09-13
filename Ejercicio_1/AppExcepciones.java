package Ejercicio_1;

import java.io.IOException;

public class AppExcepciones {
    
    private LeerEntrada lector;

    public AppExcepciones() {
        this.lector = new LeerEntrada(System.in);
    }

    public void procesar() throws ExcepcionVocal, ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida, IOException {
        char c = lector.getChar();

        if (c == '\r' || c == '\n') {
            return;
        }

        char cLower = Character.toLowerCase(c);

        if (cLower == 'q') {
            throw new ExcepcionSalida("Se detectó el carácter de salida ('q').");
        }
        else if (cLower == 'a' || cLower == 'e' || cLower == 'i' || cLower == 'o' || cLower == 'u') {
            throw new ExcepcionVocal("Se ha ingresado una VOCAL: '" + c + "'");
        }
        else if (Character.isDigit(c)) {
            throw new ExcepcionNumero("Se ha ingresado un NÚMERO: '" + c + "'");
        }
        else if (c == ' ' || c == '\t') {
            throw new ExcepcionBlanco("Se ha ingresado un ESPACIO EN BLANCO.");
        }
    }
}
