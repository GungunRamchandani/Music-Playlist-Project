package Music_System;
import java.util.ArrayList;
public class Database {
    public static ArrayList<Song> allSongs;

    public static Album[] albums;
    public static ArrayList<User> allUsers;


    public void insert(){
        Song s1=new Song("Dil diya gallan",4.20, "Happy","Atif Aslam");
        s1.setPath("C:\\Users\\DELL\\Desktop\\vsjava\\MusicSystem\\Music\\Dil Diyan Gallan Tiger Zinda Hai 128 Kbps.wav.crdownload");
        Song s2=new Song("Tera hone laga hoon",4.59,"Happy","Atif Aslam");
        s2.setPath("C:\\Users\\DELL\\Desktop\\vsjava\\MusicSystem\\Music\\Tera Hone Laga Hoon Ajab Prem Ki Ghazab Kahani 128 Kbps.wav");
        Song s3=new Song("Tere Sang yaara",4.55,"Happy","Atif Aslam");
        Song s4=new Song("Darasal",4.34,"Happy","Atif Aslam");
        Song s5=new Song("Tu Janne Na",5.41,"Happy","Arijit Singh");
        s5.setPath("C:\\Users\\DELL\\Desktop\\vsjava\\MusicSystem\\Music\\Tu-Jaane-Na-(Slowed-Reverb)(PagalWorld).wav");
        Song s6=new Song("Gorgeous",3.29,"Happy","Taylor Swift");
        s6.setPath("C:\\Users\\DELL\\Desktop\\vsjava\\MusicSystem\\Music\\Gorgeous - SamWep.wav");
        Song s7=new Song("Harleys in Hawai",3.05,"Happy","Katy Perry");
        s7.setPath("C:\\Users\\DELL\\Desktop\\vsjava\\MusicSystem\\Music\\Harleys-In-Hawaii(musicdownload.cc).wav (1).crdownload");
        Song s8=new Song("What Jumka",3.33,"Happy","Arijit Singh");
        s8.setPath("C:\\Users\\DELL\\Desktop\\vsjava\\MusicSystem\\Music\\What Jhumka(PagalWorld.com.pe).wav.crdownload");
        Song s9=new Song("Calm Down",3.59,"Happy","Selena Gomez");
        s9.setPath("C:\\Users\\DELL\\Desktop\\vsjava\\MusicSystem\\Music\\Calm-Down-Calm-Down(PaglaSongs).wav");
        Song s10=new Song("Hawa Banke",4.59,"Happy","Darshan Raval");
        Song s11=new Song("Tere Naal",3.18,"Happy","Darshan Raval");
        s11.setPath("C:\\Users\\DELL\\Desktop\\vsjava\\MusicSystem\\Music\\Terenaal.wav");
        Song s12=new Song("Tu Har Lamha",4.33,"Sad","Arijit Singh");
       // s12.setPath();
        Song s13=new Song("Asal mein",3.44,"Sad","Darshan Raval");
        s13.setPath("C:\\Users\\DELL\\Desktop\\vsjava\\MusicSystem\\Music\\Asal Mein.wav");


        Song s14=new Song("Bandeya re Bandeya",4.14,"Motivation","Arijit Singh");
        //s14.setPath();
        Song s15=new Song("Unstoppable",3.37,"Motivation","Cia");
        s15.setPath("C:\\Users\\DELL\\Desktop\\vsjava\\MusicSystem\\Music\\Unstoppable_64-(PagalWorld).wav");

        Song s16=new Song("Besabriyaan",4.15,"Motivation","Armaan Malik");
        s16.setPath("C:\\Users\\DELL\\Desktop\\vsjava\\MusicSystem\\Music\\Besabriyaan (MS Dhoni - The Untold Story).wav");
        Song s17=new Song("Aashayein",4.20,"Motivation","KK");
        s17.setPath("");
        allSongs=new ArrayList<>(50);
        this.allSongs.add(s1);
        this.allSongs.add(s2);
        this.allSongs.add(s3);
        this.allSongs.add(s4);
        this.allSongs.add(s5);
        this.allSongs.add(s6);
        this.allSongs.add(s7);
        this.allSongs.add(s8);
        this.allSongs.add(s9);
        this.allSongs.add(s10);
        this.allSongs.add(s11);
        this.allSongs.add(s12);
        this.allSongs.add(s13);
        this.allSongs.add(s14);
        this.allSongs.add(s15);
        this.allSongs.add(s16);
        this.allSongs.add(s17);


        //0th idx->by darshan
        //1st idx->by Arijit
        //2nd idx->by Atif
        albums=new Album[3];
        albums[0]=new Album("byDarshan","Darshan Raval");
        albums[1]=new Album("byArijit","Arijit Singh");
        albums[2]=new Album("byAtif","Atif Aslam");



        albums[0].album.add(s4);


        albums[0].album.add(s6);

        albums[0].album.add(s12);

        albums[0].album.add(s15);

        albums[2].album.add(s1);

        albums[2].album.add(s2);

        albums[2].album.add(s3);

        albums[1].album.add(s5);

        albums[1].album.add(s13);

        albums[1].album.add(s7);

        albums[1].album.add(s10);


    }
    public void displayAllSongs(){
        for(int i=0;i<allSongs.size();i++){
            System.out.println(i+1+" "+allSongs.get(i));
        }
    }
    public void printByGenre(String gen){
        int k=1;
        for(int i=0;i<this.allSongs.size();i++){
            if(this.allSongs.get(i).getGenre().equals(gen)){
                System.out.println(k+" "+this.allSongs.get(i).toString());
                k++;

            }

        }
    }

    public void existinguser() {
        allUsers=new ArrayList<>(10);
        User user1 = new User("Sakshi", "Sakshi2609");
        User user2 = new User("Gungun", "Gungun1911");
        User user3 = new User("Neha", "Neha2609");
        User user4 = new User("Supriya", "Supriya2609");
        User user5 = new User("Sam", "Sam2609");
        User user6 = new User("Om", "Om2609");
        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);
        allUsers.add(user4);
        allUsers.add(user5);
        allUsers.add(user6);
    }
    public Song searchSong(String temp){
        boolean flag=false;
        for(int i=0;i<this.allSongs.size();i++){
            System.out.println(temp+" "+this.allSongs.get(i).gettitle());
            if(this.allSongs.get(i).gettitle().equals(temp)){
                return allSongs.get(i);

            }
        }
        return null;
    }

}
