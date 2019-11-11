package pl.weeia.makz.zad3.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.weeia.makz.zad3.GenerateICalUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class ICalFileGenerationController {



    private GenerateICalUtils generateICalUtils = new GenerateICalUtils();

    @GetMapping("/generate")
    public void generateForCurrentMonth(HttpServletResponse response) {
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        generateICalUtils.generateICal(month, year);
        generateICalUtils.responseWithIcsFile(response);
    }

    @GetMapping("/generate-for-month")
    public void generateForSpecificMonth(@RequestParam(value = "month") String month,
                                         HttpServletResponse response) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        generateICalUtils.generateICal(Integer.parseInt(month), year);
        generateICalUtils.responseWithIcsFile(response);
    }

    @GetMapping("/generate-for-year-and-month")
    public void generateForSpecificYear(@RequestParam(value = "year") String year,@RequestParam(value = "month") String month,
                                         HttpServletResponse response) {
        generateICalUtils.generateICal(Integer.parseInt(month), Integer.parseInt(year));
        generateICalUtils.responseWithIcsFile(response);
    }








}
