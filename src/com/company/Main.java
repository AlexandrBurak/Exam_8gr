package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Book {
    public String NameOfBook;
    public Integer PublishYear;
    public String Author;
    public Integer Stars;

    public Book(){
        this.NameOfBook = "";
        this.PublishYear = 0;
        this.Author = "";
        this.Stars = 0;
    }
    public Book(String NameOfBook, Integer PublishYear, String Author, Integer Stars){
        this.NameOfBook = NameOfBook;
        this.PublishYear = PublishYear;
        this.Author = Author;
        this.Stars = Stars;
    }

    public Book(Scanner sc){
        this.NameOfBook = sc.next();
        this.PublishYear = sc.nextInt();
        this.Author = sc.next();
        this.Stars = sc.nextInt();
    }

    public String toString(){
        String sb = new String("");
        sb = this.NameOfBook + " " + this.PublishYear.toString() + " " + this.Author + " " + this.Stars.toString();
        return sb.toString();
    }
    public String getNameOfBook(){
        return this.NameOfBook;
    }
    public String getPublishYear(){
        return String.valueOf(this.PublishYear);
    }
    public String getAuthor(){
        return this.Author;
    }
    public String getStars(){
        return String.valueOf(this.Stars);
    }

}

public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        ArrayList<Book> lst = new ArrayList<>();
        while(sc.hasNext()){
            lst.add(new Book(sc));
        }
        //Comparator<Book> comparator = (o1, o2) -> o1.getStars().compareTo(o2.getStars());
        Comparator<Book> comparator = new Comparator<Book>(){
            public int compare(Book o1, Book o2) {
                int res = o1.getNameOfBook().compareTo(o2.getNameOfBook());
                if (res == 0){
                    return o1.getStars().compareTo(o2.getStars());
                }
                return res;
            }
        };
        Collections.sort(lst, comparator);
        System.out.println(lst);

    }
}
