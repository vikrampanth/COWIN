package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableScheduling
public class CowinApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CowinApiApplication.class, args);
	}

	@Scheduled(initialDelay = 0, fixedRate = 100000)
	public void run() throws IOException {
		System.out.println("Current time is :: " + Calendar.getInstance().getTime());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		LocalDate now = LocalDate.now();  
		System.out.println(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(LocalDateTime.now()) );
        appointmentDetails(dtf.format(now));	
//      appointmentDetails(dtf.format(now.plusDays(1)));
//      appointmentDetails(dtf.format(now.plusDays(2)));
//      appointmentDetails(dtf.format(now.plusDays(3)));
//      appointmentDetails(dtf.format(now.plusDays(4)));
//      appointmentDetails(dtf.format(now.plusDays(5)));
//      appointmentDetails(dtf.format(now.plusDays(6)));        
	}
	public static void appointmentDetails(String date) throws IOException{
		String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id=188&date="+date;

		HttpURLConnection con;
		
        URL myurl = new URL(url);
        con = (HttpURLConnection) myurl.openConnection();
		
        try {

            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
//            con.setRequestProperty("Content-Type","application/json; charset=utf-8");
            con.setRequestProperty("Accept","application/json");
//            con.setRequestProperty("Authorization","Basic c3VyYWowNzA4MTk5NTp4a2V5c2liLWUyNDI3MzA4NjcyOWFlMTg5MzkyOGExNmI5MDU1NGI5MTAxMDliZmJmNjJjNzQyOWY5ZjQyNzZhZmJjZmQwNjgtc2Y0M3ZhU25Ga1Uwd3RkOQ==");
            
            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {

                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }

//            System.out.println(content.toString());
            
            Session session = new ObjectMapper().readValue(content.toString(), Session.class);
            
            for(int i=0; i< session.getSessions().size(); i++) {
            	if( session.getSessions().get(i).getMin_age_limit() == 18)
            		System.out.println(session.getSessions().get(i).toString() );
            }
//            System.out.println(session.toString());
            
        } finally {

            con.disconnect();
        }
	}
	
	
}
