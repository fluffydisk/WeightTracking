import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ShowGraph{
    public ShowGraph(){
        try {
            CreatePng();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

    private void CreatePng() throws IOException {
        List<String>Commands = List.of(
                "python3",
                "src/CsvGraph.py",
                "/home/omer/projects/WeightTracking/Data/data.csv",
                "/home/omer/projects/WeightTracking/Data/graph.png");
        ProcessBuilder pb = new ProcessBuilder(Commands);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        try {
            process.waitFor();
        } catch (InterruptedException e) {
            System.err.println(e.toString());
        }
    }
}
