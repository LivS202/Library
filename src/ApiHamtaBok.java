import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ApiHamtaBok {

    public static Bok sokBok(String sokord){

        try{
       String encoded = URLEncoder.encode(sokord, StandardCharsets.UTF_8);

        URL url = new URL("https://openlibrary.org/search.json?q=" + encoded +"&limit=1");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                StringBuilder response = new StringBuilder();
                String line;

                while((line = reader.readLine()) != null){
                    response.append(line);
                }
                reader.close();

                String json = response.toString();

            String titel = hamtaVarde(json, "\"title\":\"", "\"");
                String forfattare = hamtaForfattare(json);
                int ar = hamtaAr(json);

                if(titel==null || titel.isEmpty()){
                    return null;
                }
                return new Bok(titel, ar, forfattare);
    } catch(Exception e){
        System.out.println("Fel vid API-anrop: " + e.getMessage());
        return null;
    }
}

private static String hamtaVarde(String text, String start, String end) {
    int startIndex = text.indexOf(start);
    if (startIndex == -1) {
        return null;
    }
    startIndex += start.length();

    int endIndex = text.indexOf(end, startIndex);
    if (endIndex== -1){
        return null;
    }
    return text.substring(startIndex, endIndex);
}
private static String hamtaForfattare(String json) {
    String forfattare = hamtaVarde(json, "\"author_name\":[\"", "\"");

    if (forfattare == null) {
        return "Okänd författare";
    }
    return forfattare;
}
    private static int hamtaAr(String json){
        try {
            String arText = hamtaVarde(json,"\"first_publish_year\":", ",");
            if (arText == null){
                return 0;
            }
            return Integer.parseInt(arText);
        } catch (Exception e){
            return 0;
        }
    }
}

