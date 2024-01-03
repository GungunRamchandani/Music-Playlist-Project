package Music_System;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.*;

import java.util.ArrayList;

class User{

    private String name;
    private String password;
    ArrayList<PlayList> myPlaylists;
    static Database db=new Database();
    User(String name,String password) {
        this.name=name;
        this.password=password;
        myPlaylists=new ArrayList<>();
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public void setPassword(String pwd){
        this.name=pwd;
    }
    public String getPassword(){
        return this.password;
    }
    Scanner sc=new Scanner(System.in);
    public void createPlayList(String name){
        PlayList obj;

        int i=searchPlaylist(name);
        if(i!=-1){
            System.out.println("Playlist with this name already exists.Do you want to replace it?(Y/N)");
            char ch=sc.next().charAt(0);
            if(ch=='Y'){
                myPlaylists.get(i).getPl().clear();
                obj=myPlaylists.get(i);
            }
            else{
                while(i!=-1){
                    System.out.println("Enter some another name");
                    name=sc.nextLine();
                    i=searchPlaylist(name);
                }
                obj=new PlayList();
                obj.setName(name);
            }
        }
        else{
            obj=new PlayList();
            obj.setName(name);
        }

        System.out.println("On what basis do you want to make playlist");
        System.out.println("1.By Genre\n2.By any particular artist.\n3.Choosing song from available songs");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                int ch;
                System.out.println("List of Genres are");
                System.out.println("1.Happy\n2.Sad\n3.Motivation\n");
                ch=sc.nextInt();
                if(ch==1){
                    db.printByGenre("Happy");
                    obj.addSongsByGenre("Happy");
                }
                else if(ch==2){
                    db.printByGenre("Sad");
                    obj.addSongsByGenre("Sad");
                }
                else {
                    db.printByGenre("Motivation");
                    obj.addSongsByGenre("Motivation");
                }
//                this.setpl(new LinkedList<>());


                break;
            case 2:
                System.out.println("List of ALbums are");
                //pending
                System.out.println("1.byDarshan\n2.byArijit\n3.byAtif");
                ch=sc.nextInt();
                if(ch>=4 || ch<0){
                    System.out.println("Invalid response");
                    return;
                }
                Album temp;
//                if(ch==1){
//                    temp=db.albums[ch-1];
//                    temp.printAlbumSongs();
//
//                }
//                else if(ch==2){
//                    temp=db.albums.get(1);
//                    temp.printAlbumSongs();
//
//                }
//                else{
//                    temp=db.albums.get(2);
//                    temp.printAlbumSongs();
//                }
                temp=db.albums[ch-1];
                obj.addAlbumSongsToPlayList(temp);

                break;

            case 3:
                db.displayAllSongs();
                obj.addSongsToPlayList();
                break;
            default:
                System.out.println("Invalid response");
                break;

        }
        this.myPlaylists.add(obj);


    }
    public void displayAllPlaylists(){
        if(myPlaylists.size()==0){
            System.out.println("You dont have any playlist currently");
        }
        for(int i=0;i<myPlaylists.size();i++){
            PlayList p=myPlaylists.get(i);
            System.out.println((i+1)+" "+p);
        }
    }
    public void deletePlayList(){
        //Scanner sc=new Scanner (System.in);
        if(myPlaylists.size()==0){
            System.out.println("No playlists exists.");
            return;
        }
        displayAllPlaylists();
        System.out.println("Enter playlist to be deleted");
        int num=sc.nextInt();//strage static mai sc error aara
        //ListIterator<Song> ls=myPlaylist.listIterator();
//        int i=searchPlaylist(name);
//        if(i!=-1) myPlaylists.remove(i);
//        else{
//            System.out.println("OOPS!!No Playlist with this name exists");
//        }
        if(num-1>=myPlaylists.size() || num-1<0){
            System.out.println("Invalid response");
            return;
        }
        myPlaylists.remove(num-1);
    }
    public void playPlaylist() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        displayAllPlaylists();
        System.out.println("Enter Playlist to be played");
        String name=sc.next();
        int i=searchPlaylist(name);
        if(i==-1){
            System.out.println("Playlist with this name doesnt exist");
            return;
        }
        PlayList obj=myPlaylists.get(i);
        obj.displayAllSongsInPlayList();
        obj.play();

    }
    public int searchPlaylist(String name){
        for(int i=0;i<myPlaylists.size();i++){
            if(myPlaylists.get(i).getName().equals(name)){
                return i;

            }
        }
        return -1;//No such playlist exists
    }
    public void addSongsInPlaylist(){
        if(myPlaylists.size()==0){
            System.out.println("You dont have any playlists");
            return;
        }
        displayAllPlaylists();
        System.out.println("Enter Playlist where Songs are to be added");
        int num=sc.nextInt();
        if(num-1>=myPlaylists.size() || num-1<0){
            System.out.println("Invalid response");return;
        }
        db.displayAllSongs();
        myPlaylists.get(num-1).addSongsToPlayList();
    }

    public void deleteSongsFromplaylist(){
        displayAllPlaylists();
        if(myPlaylists.size()==0) return;
        System.out.println("Enter Playlist from where Songs are to be deleted");
        int num=sc.nextInt();
        if(num-1>=myPlaylists.size() || num-1<0){
            System.out.println("Invalid response.");
            return;
        }
        PlayList currentPlaylist=myPlaylists.get(num-1);

        currentPlaylist.displayAllSongsInPlayList();
        currentPlaylist.deleteSongFromPlaylist();

        System.out.println("Updated Playlist is");
        currentPlaylist.displayAllSongsInPlayList();

    }
    public void displaySongsOfParticularPlaylist(){
        Scanner sc=new Scanner(System.in);
        displayAllPlaylists();
        System.out.println("Enter playlist number whose songs are to be displayed");
        int num=sc.nextInt();
        if(num-1>=myPlaylists.size() || num<0){
            System.out.println("Invalid response");
            return;
        }
        else{
            PlayList obj=myPlaylists.get(num-1);
            obj.displayAllSongsInPlayList();

        }
    }
    public static void main(String[]args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        Scanner sc = new Scanner(System.in);
        String name, password;
        System.out.println("Enter your username");
        name = sc.next();
        System.out.println("Enter your password");
        password = sc.next();
        User u = new User(name, password);
        db.insert();
        db.existinguser();
        for (int i = 0; i < 6; i++) {
            if (u.getName().equals(db.allUsers.get(i).getName())) {
                System.out.println("Logged in");
            }

        }

        System.out.println("Hello " + u.name);
        //do while mai kr
        int choice;
        System.out.println("What do you want to do?");
        do {

            System.out.println("1.Create New Playlist.\n2.Display all existing playlists.\n3.Delete playlist.\n4.Play a Playlist\n5.Add songs in playlist.\n6.Delete songs from playlist.\n7.Display Songs of particular Playlist.\n8.Exit ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter name of your playlist: ");
                    String n=sc.next();
                    u.createPlayList(n);//done:glitch
                    break;
                case 2:
                    u.displayAllPlaylists();//done
                    break;
                case 3:
                    u.deletePlayList();
                    break;
                case 4:
                    u.playPlaylist();//done
                    break;
                case 5:
                    u.addSongsInPlaylist();//done
                    break;
                case 6:
                    u.deleteSongsFromplaylist();//done
                    break;
                case 7:
                    u.displaySongsOfParticularPlaylist();
                    break;
                case 8:
                    System.out.println("Thankyou "+u.getName());

                    break;
//display songs of particular playlist?


            }
        }while(choice!=8);
    }

    }//new opt:display given pl songs


//genre,playlist num

