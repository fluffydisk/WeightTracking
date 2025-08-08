import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvData {
    static private File CsvFile;
    private Date _date;
    private String _photoPath;
    private int _weight;
    private String data;
    public CsvData(
            Date date,
            String photoPath,
            int weight
    ){
        _date = date; _photoPath = photoPath; _weight = weight;
        data = setData();

        createFileIfNotExist();
        writeFile(data);
    }

    private String setData(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return "\n"+dateFormat.format(_date) + "," + _weight + "," + _photoPath;
    }


    private void createFileIfNotExist(){
        CsvFile = new File(System.getProperty("user.dir"), "/Data/data.csv");
        CsvFile.getParentFile().mkdirs();

        try{
            if(CsvFile.createNewFile()){
                writeFile("DATE,WEIGHT,PHOTO_PATH");
            }
        }catch (IOException e){
            System.err.println(e.toString());
        }
    }

    private void writeFile(String write){
        try(FileWriter fileWriter = new FileWriter(CsvFile.getPath(), true)){
            fileWriter.write(write);
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}
