package br.com.solutiontrue;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteHorarioVerao {

    public static void main (String[] args) {
        int saida = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        ZonedDateTime ref = ZonedDateTime.of(2019,11,2,23,0,0,0, ZoneId.systemDefault());
        Calendar cal = GregorianCalendar.from(ref);

        System.out.printf("[ZDT] representacao -> %s\n", ref);
        System.out.printf("[ZDT] offset -> %s\n", ref.getOffset());
        ref = ref.plus(1, ChronoUnit.HOURS);
        System.out.printf("[ZDT] apos adicionar uma hora -> %s com offset %s\n", ref, ref.getOffset());

        if (ZoneOffset.of("-03:00").equals(ref.getOffset())) {
            System.out.println("[ZDT] Problema com horario de verao resolvido");
        } else {
            System.err.printf("[ZDT] Ainda ha problema com horario de verao: esperado[%s] obtido[%s]\n", ZoneOffset.of("-03:00"), ref.getOffset());
            saida = -1;
        }

        System.out.printf("[Calendar] representacao -> %s\n", sdf.format(cal.getTime()));
        System.out.printf("[Calendar] offset -> %s\n", cal.get(Calendar.DST_OFFSET));
        cal.add(Calendar.HOUR, 1);
        System.out.printf("[Calendar] apos adicionar uma hora -> %s com offset %s\n", sdf.format(cal.getTime()), cal.get(Calendar.DST_OFFSET));



        if (cal.get(Calendar.DST_OFFSET) == 0) {
            System.out.println("[Calendar] Problema com horario de verao resolvido");
        } else {
            System.err.printf("[Calendar] Ainda ha problema com horario de verao: esperado[0] obtido[%s]\n", cal.get(Calendar.DST_OFFSET));
            saida = -1;
        }

        System.exit(saida);

    }
}
