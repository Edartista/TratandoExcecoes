package reservadehotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Número do quarto: ");
        int numero = teclado.nextInt();
        System.out.print("Check-in [dd/MM/aaaa]: ");
        Date checkIn = sdf.parse(teclado.next());
        System.out.print("Check-out [dd/MM/aaaa]: ");
        Date checkOut = sdf.parse(teclado.next());
        
        if (!checkOut.after(checkIn)){
            System.out.println("Erro na reserva: a data de check-out deve ser após a data de check-in.");
        }
        else{
            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println("\nReserva: \n" + reserva);
  
            System.out.println();
            System.out.println("Para atualizar a reserva, entre com os novos dados:");
            System.out.print("Check-in [dd/MM/aaaa]: ");
            checkIn = sdf.parse(teclado.next());
            System.out.print("Check-out [dd/MM/aaaa]: ");
            checkOut = sdf.parse(teclado.next());
            

            String erro = reserva.atualizarDatas(checkIn, checkOut);
            if(erro != null){
                System.out.println(erro);
            }
            else{
            System.out.println("\nReserva atualizada: \n" + reserva);
            }
        
        teclado.close();
    }
    }
}
