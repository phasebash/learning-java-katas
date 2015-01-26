import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpAnswer {
    
    public static void main(String[] args) throws Exception {
        System.out.println(get202Response());
        System.out.println(get404Response());
    }
    
    private static String get202Response() throws Exception {
        final HttpURLConnection connection = openConnectionTo("http://httpstat.us/200");
        
        connection.connect();
        
        if (connection.getResponseCode() != 200) {
            throw new IllegalStateException("Non 200 from request.");
        }

        return consumeInput(connection);
    }

    private static void setTimeouts(HttpURLConnection connection, int connectTimeout, int readTimeout) {
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
    }

    private static String get404Response() throws Exception {
        final HttpURLConnection connection = openConnectionTo("http://httpstat.us/500");

        connection.connect();

        if (connection.getResponseCode() != 500) {
            throw new IllegalStateException("Non 500 from request.");
        }

        return consumeError(connection);
    }
    
    private static HttpURLConnection openConnectionTo(String s) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(s).openConnection();
        
        setTimeouts(connection, 1000, 5000);
        setUserAgent(connection);
        
        return connection;
    }

    private static void setUserAgent(HttpURLConnection connection) {
        connection.addRequestProperty("User-Agent", "LOL-Client");        
    }
    
    private static String consumeInput(HttpURLConnection connection) throws IOException {
        StringBuilder builder = new StringBuilder();
        
        try(InputStream stream = connection.getInputStream()) {
            readLines(builder, stream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return builder.toString();
    }
    
    private static String consumeError(HttpURLConnection connection) throws IOException {
        StringBuilder builder = new StringBuilder();

        try(InputStream stream = connection.getInputStream()) {
            readLines(builder, stream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return builder.toString();
    }

    private static void readLines(StringBuilder builder, InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));

        String line = reader.readLine();
        while(line != null){
            builder.append(line).append("\n");
            line = reader.readLine();
        }
    }

}