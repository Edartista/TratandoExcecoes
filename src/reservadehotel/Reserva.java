package reservadehotel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    
    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Reserva(){
    }
    
    public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numero_quarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }
    
    public long duração(){
        long diferença = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diferença, TimeUnit.MILLISECONDS);
    }
    
    public String atualizarDatas(Date checkIn, Date checkOut){
        Date agora = new Date();
            if (checkIn.before(agora) || checkOut.before(agora)){
                return "Erro na reserva: para atualizar é preciso digitar datas futuras.";
            }
            if (!checkOut.after(checkIn)){
                return "Erro na reserva: a data de entrada é preciso ser anterior à saída.";
            }
        
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Quarto nº " + numeroQuarto + "\n");
        sb.append("Check-in: " + sdf.format(checkIn) + "\n");
        sb.append("Check-out: " + sdf.format(checkOut) + "\n");
        sb.append("Duração: " + duração() + " noites.");
        return sb.toString();
    }
    
}
