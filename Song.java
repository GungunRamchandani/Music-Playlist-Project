package Music_System;



public class Song

{

    private String title;

    private double duration;
    private String genre;
    private String artist;
    Database db=new Database();
    private String path;
    Song(String title,double duration)

    {

        this.title=title;

        this.duration=duration;
        this.path="";

    }
    Song(String title,double duration,String genre,String artist){
        this.title=title;
        this.duration=duration;
        this.genre=genre;
        this.artist=artist;
        //this.path=path; pending
    }

    Song()

    {
        title="null";
        duration=-1;



    }

    String gettitle()

    {

        return title;

    }

    double getDuration(){
        return duration;
    }
    public void setTitle(String title){
        this.title=title;

    }
    public void setPath(String p){
        this.path=p;
    }
    public String getPath(){
        return this.path;
    }
    public void setDuration(double duration){
        this.duration=duration;
    }
    public String getGenre(){
        return this.genre;
    }
    public void setGenre(String gen){
        this.genre=gen;
    }

    @Override
    public String toString(){
        return (title+"    "+duration+"    "+genre+"    "+artist);
    }



}

