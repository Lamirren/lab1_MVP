package com.example.demo.servlets;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.example.demo.DateFormatter;
import com.example.demo.almostdatabase.User;
import com.example.demo.almostdatabase.UserDatabase;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.JSONObject;

@WebServlet(name = "timeServlet", value = "/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String weatherData = getWeatherData();

        JSONObject json = new JSONObject(weatherData);

        JSONObject currentWeather = json.getJSONObject("current");
        //System.out.println("Current: " + currentWeather);
        String timeDate = currentWeather.getString("time");
        System.out.println("Current time: " + timeDate);
        String[] bTimeDate = DateFormatter.formatDateTime(timeDate);
        System.out.println("Beautiful current time: " + bTimeDate[0]);
        System.out.println("Beautiful current date: " + bTimeDate[1]);
        double temperature = currentWeather.getDouble("temperature_2m");
        System.out.println("Current weather: " + temperature);

        request.setAttribute("time", bTimeDate[0]);
        request.setAttribute("date", bTimeDate[1]);
        request.setAttribute("temperature", temperature);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/time-weather.jsp");
        dispatcher.forward(request, response);
    }

    private String getWeatherData() throws IOException {
        // API open-meteo для получения погоды и времени
        URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=55.7558&longitude=37.6173&current=temperature_2m");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Проверка, что ответ успешен (код 200)
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code: " + responseCode);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }

            String responseData = response.toString();
            System.out.println("Received Data: " + responseData);
            return responseData;
        } catch (IOException e) {
            System.out.println("Error during HTTP request: " + e.getMessage());
            throw e;
        }
    }

}