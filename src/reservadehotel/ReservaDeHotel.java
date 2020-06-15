package reservadehotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReservaDeHotel {
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
            
            Date agora = new Date();
            
            if (checkIn.before(agora) || checkOut.before(agora)){
                System.out.println("Erro na reserva: para atualizar é preciso digitar datas futuras.");
            }
            else if (!checkOut.after(checkIn)){
                System.out.println("Erro na reserva: é preciso digitar datas futuras.");
            }
            else{
            reserva.atualizarDatas(checkIn, checkOut);
            System.out.println("\nReserva: \n" + reserva);
            }
        }
        teclado.close();
    }
    
}
