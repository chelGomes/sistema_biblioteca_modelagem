// JOÃO PAULO DE CARVALHO ARAÚJO - 202065564C

package ufjf.dcc025.sistema.biblioteca;

import ufjf.dcc025.sistema.biblioteca.layouts.Login;
import ufjf.dcc025.sistema.biblioteca.services.BibliotecaService;


public class Program {
    
    public static void main(String[] args) {
        
        BibliotecaService.startUp();
        
        Login login = new Login();
        login.setVisible(true);
    }    
}
