package Music_System;



import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PlayList {
    private String name;
    private LinkedList<Song> pl;//doubly linked list
    Database db = new Database();

    Scanner sc = new Scanner(System.in);

    PlayList(){
        pl=new LinkedList<>();
        name="none";
    }
    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    public LinkedList<Song> getPl(){
        return this.pl;
    }

    public void addSongsToPlayList() {


        char ch;

        do {
            System.out.print("Enter tracknumber to be added");
            int num=sc.nextInt();
//
            if(num-1>=db.allSongs.size() || num-1<0){
                System.out.println("Invalid response");
                return;
            }
            boolean res=searchSongInPlaylist(db.allSongs.get(num-1).gettitle());
            if(res==true){
                System.out.println("This Song already exists in playlist");
                return;
            }
            pl.add(db.allSongs.get(num-1));




            System.out.println("Do you want to more Songs?(Y/N)");
            ch = sc.next().charAt(0);
        } while (ch != 'N');
    }
    public void addSongsByGenre(String genre){
        char ch;
        do{
            System.out.println("Enter tracknumber to be added");
            int num=sc.nextInt();
            if(genre.equals("Sad")){
                num=num+11;
            }
            if(genre.equals("Motivation")){
                num=num+13;
            }
            if(num-1>=db.allSongs.size() || num-1<0){
                System.out.println("Invalid response");
                return;
            }
            boolean res=searchSongInPlaylist(db.allSongs.get(num-1).gettitle());
            if(res==true){
                System.out.println("This Song already exists in playlist");
                return;
            }
            pl.add(db.allSongs.get(num-1));
            System.out.println("Do you want to more Songs?(Y/N)");
            ch = sc.next().charAt(0);
        } while (ch != 'N');


    }
    public boolean searchSongInPlaylist(String name){
        ListIterator<Song> l = pl.listIterator();
        while(l.hasNext()){
            Song obj=l.next();
            if(obj.gettitle().equals(name)) return true;

        }
        return false;
    }

    public void deleteSongFromPlaylist() {//for particular
        System.out.println("Enter track number to be deleted");
        int trackNum=sc.nextInt();
        if(trackNum-1>=pl.size() || trackNum-1<0){
            System.out.println("Invalid response");
            return;
        }
        pl.remove(trackNum-1);


    }
    public void addAlbumSongsToPlayList(Album e){
        char ch;
        do {
            e.printAlbumSongs();
            System.out.println("Enter tracknumber to be added");
            int trackNum = sc.nextInt();
            if (trackNum - 1 >= e.album.size() || trackNum - 1 < 0) {
                System.out.println("Invalid response.");
                return;
            }
            Song obj = e.album.get(trackNum - 1);
            boolean res=searchSongInPlaylist(obj.gettitle());
            if(res==true){
                System.out.println("This Song already exists in playlist");
                return;
            }
            pl.add(obj);
            System.out.println("Do you want to add more Songs(Y/N)?");
            ch=sc.next().charAt(0);
        }while(ch!='N');


    }

    public void displayAllSongsInPlayList() {
        ListIterator<Song> l = pl.listIterator();
        int i = 1;
        while (l.hasNext()) {
            Song obj = l.next();
            System.out.println(i + " " + obj);
            i++;
        }
        // System.out.println(pl);
    }

    public void play() throws IOException, LineUnavailableException {
        //bich e koi track pend

        System.out.println("Enter tracknumber to get started");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ListIterator<Song> l = pl.listIterator(num - 1);
        Song currobj = l.next();
        l.previous();


        System.out.println("Current Song is : " + currobj);
        try {
            File file = new File(currobj.getPath());

            AudioInputStream as = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            //open clip
            clip.open(as);


            //creating audioinputstream
            //for this
            //Creating Clip obj

//        clip.start();

            String response = "";
            System.out.println("P=play current song.\nS=Stop current song\nR=Reset current song\nN=Play Next Song\nPR=Play previous song\nQ=Quit");
            System.out.println("Enter your choice");
            response = sc.next();
            response = response.toUpperCase();
            do {

                switch (response) {
                    case "P":

                        clip.start();
                        break;
                    case "S":
                        clip.stop();
                        break;
                    case "R":

                        clip.setMicrosecondPosition(5);
                        break;
                    case "N":
                        clip.stop();
                        l.next();
                        if (!l.hasNext()) {
//                        System.out.println("inN1");
//                        System.out.println("No next song exists");

                            while (l.hasPrevious()) {
                                l.previous();
                            }
                            currobj = l.next();

                            l.previous();

                        } else {


                            currobj = l.next();
                            l.previous();
//                        currobj = l.previous();
//                   }     l.next();
                        }

                        file = new File(currobj.getPath());
                        as = AudioSystem.getAudioInputStream(file);
                        clip = AudioSystem.getClip();
                        clip.open(as);
                        clip.start();


                        break;
                    case "PR":
                        clip.stop();
                        if (!l.hasPrevious()) {
                            //System.out.println("No prev song exists");
                            while (l.hasNext()) {
                                l.next();
                            }
                            currobj = l.previous();

                        } else {

                            currobj = l.previous();


                        }
                        file = new File(currobj.getPath());
                        as = AudioSystem.getAudioInputStream(file);
                        clip = AudioSystem.getClip();
                        clip.open(as);
                        clip.start();
                        break;

                    default:
                        System.out.println("Invalid response");
                }
                System.out.println("P=play current song.\nS=Stop current song\nR=Reset current song\nN=Play Next Song\nPR=Play previous song\nQ=Quit");
                System.out.println("Enter your choice");
                response = sc.next();
                response = response.toUpperCase();


            } while (!response.equals("Q"));


            clip.stop();

        }
        catch(NullPointerException e){
            System.out.println("Song is unavailable currently");
            return;
        }
        catch (LineUnavailableException e){
            System.out.println("Song is unavailable currently");
            return;
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("Song is unavailable currently");
            return;
        }



    }
    @Override
    public String toString(){
        return (this.name);
    }
}


    //to string of playlist bana


