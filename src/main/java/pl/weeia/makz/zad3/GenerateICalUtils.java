package pl.weeia.makz.zad3;


import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.RandomUidGenerator;
import net.fortuna.ical4j.util.UidGenerator;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GenerateICalUtils {

    private static final String BASE_PATH = "http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php?rok=";
    private static final String MONTH = "&miesiac=";
    private static final String LANG = "&lang=1";

    public void generateICal(int month, int year) {
        Document doc = null;
        List<String> pStrings = new ArrayList<>();
        List<Integer> dayInt = new ArrayList<>();
        try {
            doc = Jsoup.connect(BASE_PATH + year + MONTH  + month + LANG).get();
            doc.select("p").forEach(element -> pStrings.add(element.text()));
            pStrings.forEach(System.out::println);
            doc.select("tr").select("td").select("a.active").forEach(element -> dayInt.add(Integer.parseInt(element.text())));
            dayInt.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!dayInt.isEmpty() || pStrings.isEmpty()){
        try {
            generateCalendar(pStrings, dayInt, year, month);
        } catch (IOException e) {
            e.printStackTrace();
        }}
    }


    private void generateCalendar(List<String> eventNames, List<Integer> dayInt, int year, int month) throws IOException {
        Calendar calendar = new Calendar();
        calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
        calendar.getProperties().add(Version.VERSION_2_0);
        calendar.getProperties().add(CalScale.GREGORIAN);
        UidGenerator ug = new RandomUidGenerator();


        for (int i = 0; i < dayInt.size(); i++) {
            java.util.Calendar c = java.util.Calendar.getInstance();
            c.set(java.util.Calendar.YEAR, year);
            c.set(java.util.Calendar.MONTH, month-1);
            c.set(java.util.Calendar.DATE, dayInt.get(i));
            DateTime dateTime = new DateTime(c.getTime());
            VEvent event = new VEvent(dateTime, eventNames.get(i));
            event.getProperties().add(ug.generateUid());
            calendar.getComponents().add(event);
        }

        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("mycalendar.ics");
            CalendarOutputter outputter = new CalendarOutputter();
            outputter.output(calendar, fout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void responseWithIcsFile(HttpServletResponse response) {
        try {
            String filePathToBeServed = "/Users/makz/Desktop/Politechnika/Pkwu/zad3/mycalendar.ics";
            File fileToDownload = new File(filePathToBeServed);
            InputStream inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename=mycalendar.ics");
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
