package reservadehotel;

import Excecoes.DomínioExceção;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            System.out.print("Número do quarto: ");
            int numero = teclado.nextInt();
            System.out.print("Check-in [dd/MM/aaaa]: ");
            Date checkIn = sdf.parse(teclado.next());
            System.out.print("Check-out [dd/MM/aaaa]: ");
            Date checkOut = sdf.parse(teclado.next());

            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println("\nReserva: \n" + reserva);

            System.out.println();
            System.out.println("Para atualizar a reserva, entre com os novos dados:");
            System.out.print("Check-in [dd/MM/aaaa]: ");
            checkIn = sdf.parse(teclado.next());
            System.out.print("Check-out [dd/MM/aaaa]: ");
            checkOut = sdf.parse(teclado.next());

            reserva.atualizarDatas(checkIn, checkOut);
            System.out.println("\nReserva atualizada: \n" + reserva);
        }
        catch (ParseException e){
            System.out.println("Formato de data inválido");
        }
        catch (DomínioExceção e){
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Aconteceu um erro inesperado. Tente novamente mais tarde.");
        }
        
        teclado.close();
    }
}
