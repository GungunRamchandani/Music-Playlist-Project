package Music_System;

import java.util.ArrayList;
import java.util.Scanner;

public class Album {
    private String albumName;
    private String artist;
    public ArrayList<Song> album;
    public Album(){
        albumName ="null";
        artist="null";
    }
    public Album(String name,String artist){
        this.albumName =name;
        this.artist=artist;
        album=new ArrayList(50);
    }
    public Album(String name){
        this.albumName =name;
        album=new ArrayList(50);
    }
    Scanner sc=new Scanner(System.in);
    public void addSong(){
        Database db=new Database();
        char choice;
        do{
            System.out.println("Enter name of song to be added in album");
            String temp=sc.nextLine();
            Song obj=db.searchSong(temp);
            if(obj==null){

                System.out.println("OOPS!No such songs exists");

            }
            else{
                //album every idx will point to same song object
                this.album.add(obj);
            }
            System.out.println("Do you want to add more songs?(Y/N)");
            choice=sc.next().charAt(0);
        }while(choice!='N');

    }
    
    @Override
    public String toString(){
        return albumName+" "+artist;

    }
    public void printAlbumSongs(){
        System.out.println(this.toString());
        for(int i=0;i<album.size();i++){
            System.out.println(i+1+" "+album.get(i).toString());
        }
    }


}
