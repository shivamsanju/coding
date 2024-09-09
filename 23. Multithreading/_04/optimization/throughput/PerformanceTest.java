package _04.optimization.throughput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PerformanceTest {

    private static final String API_URL = "http://localhost:8000/search?word=";
    private static final int NUM_REQUESTS = 100;
    private static final int THREAD_COUNT = 10;

    public static void main(String[] args) {
        String[] words = {
                "acceptable", "accessible", "accidental", "accurate", "acid", "acidic", "acoustic", "acrid", "actually",
                "ad hoc", "adamant", "adaptable", "addicted", "adhesive", "adjoining", "adorable", "adventurous",
                "afraid", "aggressive", "agonizing", "agreeable", "ahead", "ajar", "alcoholic", "alert", "alike", "alive",
                "alleged", "alluring", "aloof", "amazing", "ambiguous", "ambitious", "amuck", "amused", "amusing",
                "ancient", "angry", "animated", "annoyed", "annoying", "anxious", "apathetic", "aquatic", "aromatic",
                "arrogant", "ashamed", "aspiring", "assorted", "astonishing", "attractive", "auspicious", "automatic",
                "available", "average", "awake", "aware", "awesome", "awful", "axiomatic", "bad", "barbarous", "bashful",
                "bawdy", "beautiful", "befitting", "belligerent", "beneficial", "bent", "berserk", "best", "better",
                "bewildered", "big", "billowy", "bite-sized", "bitter", "bizarre", "black", "black-and-white", "bloody",
                "blue", "blue-eyed", "blushing", "boiling", "boorish", "bored", "boring", "bouncy", "boundless", "brainy",
                "brash", "brave", "brawny", "breakable", "breezy", "brief", "bright", "broad", "broken", "brown", "bumpy",
                "burly", "bustling", "busy", "cagey", "calculating", "callous", "calm", "capable", "capricious", "careful",
                "careless", "caring", "cautious", "ceaseless", "certain", "changeable", "charming", "cheap", "cheerful",
                "chemical", "chief", "childlike", "chilly", "chivalrous", "chubby", "chunky", "clammy", "classy", "clean",
                "clear", "clever", "cloistered", "cloudy", "closed", "clumsy", "cluttered", "coherent", "cold", "colorful",
                "colossal", "combative", "comfortable", "common", "complete", "complex", "concerned", "condemned", "confused",
                "conscious", "cooing", "cool", "cooperative", "coordinated", "courageous", "cowardly", "crabby", "craven",
                "crazy", "creepy", "crooked", "crowded", "cruel", "cuddly", "cultured", "cumbersome", "curious", "curly",
                "curved", "curvy", "cut", "cute", "cynical", "daffy", "daily", "damaged", "damaging", "damp", "dangerous",
                "dapper", "dark", "dashing", "dazzling", "dead", "deadpan", "deafening", "dear", "debonair", "decisive",
                "decorous", "deep", "deeply", "defeated", "defective", "defiant", "delicate", "delicious", "delightful",
                "demonic", "delirious", "dependent", "depressed", "deranged", "descriptive"
        };


        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUM_REQUESTS; i++) {
            final String word = words[i % words.length]; // Use words cyclically
            executor.submit(() -> {
                try {
                    long requestStartTime = System.nanoTime();
                    sendRequest(word);
                    long requestEndTime = System.nanoTime();
                    double latency = (requestEndTime - requestStartTime) / 1_000_000.0; // Convert to milliseconds
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        double totalTime = (endTime - startTime) / 1000.0; // Convert to seconds
        double throughput = NUM_REQUESTS / totalTime;

        System.out.println("Total time: " + totalTime + " seconds");
        System.out.println("throughput: " + throughput + " requests per second");
    }

    private static void sendRequest(String word) throws Exception {
        URL url = new URL(API_URL + word);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            // Read response (not used in this example)
            while (reader.readLine() != null) {}
        } finally {
            connection.disconnect();
        }
    }
}
