package ShowEntriesWindow;

import java.time.LocalDate;

public class Entry {
    private LocalDate Date;
    private double Weight;
    private String PhotoPath;
    Entry(
            LocalDate date,
            double weight,
            String photoPath
    ){
        this.Date = date;
        this.Weight = weight;
        this.PhotoPath = photoPath;
    }
    public LocalDate getDate(){return Date;}
    public double getWeight(){return Weight;}
    public String getPhotoPath(){return PhotoPath;}

    public void setDate(LocalDate date){this.Date = date;}
    public void setWeight(double weight){this.Weight = weight;}
    public void setPhotoPath(String photoPath){this.PhotoPath = photoPath;}
}
