package com.company;

import java.util.Scanner;

public class Qa {
    public Integer qa_id;
    public String qa_surname;
    public String qa_name;

    public Qa(Scanner sc){
        this.qa_id = Integer.valueOf(sc.next());
        this.qa_surname = sc.next();
        this.qa_name = sc.next().split("$")[0];

    }
    @Override
    public String toString() {
        return qa_id + ";" + qa_surname + ";" + qa_name;
    }
}
