import java.io.Serializable;

public class Book implements Serializable{

    private String title;
    private String author;
    private String ISBN;
    private boolean isLent = false;

    Book(String title, String author, String ISBN){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getISBN(){
        return this.ISBN;                                                                                                                                                                                                                                                                                                                   
    }

    public boolean isLent(){
        return this.isLent;
    }

    public void setLent(boolean lent){
        this.isLent = lent;
    }

    public String toString(){
        return "Title: " + this.title + "\nAuthor: " + this.author 
        +"\nISBN: " + this.ISBN + "\nStatus: " + (this.isLent ? "Lent" : "Available");
    }
}

class DigitalBook extends Book{
    private String downloadLink;
    DigitalBook(String title, String author, String ISBN, String downloadLink){
        super(title, author, ISBN);
        this.downloadLink = downloadLink;
    }

    public String getDownloadLink(){
        return this.downloadLink;
    }

    public String toString(){
        return super.toString() + "\nDownload link: " + this.downloadLink;
    }
}

class PhysicalBook extends Book{
    private double weight;
    PhysicalBook(String title, String author, String ISBN, double weight){
        super(title, author, ISBN);
        this.weight = weight;
    }

    public double getWeight(){
        return this.weight;
    }

    public String toString(){
        return super.toString() + "\nWeight: " + this.weight+ "grams";
    }
}