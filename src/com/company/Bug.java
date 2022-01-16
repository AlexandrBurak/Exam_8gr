package com.company;

import java.util.Scanner;

public class Bug {
    public Integer bug_id;
    public Integer page;
    public String bug_title;
    public Integer priority_id;
    public String report_date;

    public Bug(Integer bug_id, Integer page, String bug_title, Integer priority_id, String report_date){
        this.bug_id = bug_id;
        this.page = page;
        this.bug_title = bug_title;
        this.priority_id = priority_id;
        this.report_date = report_date;
    }
    public Bug(Scanner sc){
        this.bug_id = Integer.valueOf(sc.next());
        this.page = Integer.valueOf(sc.next());
        this.bug_title = sc.next();
        this.priority_id = Integer.valueOf(sc.next());
        this.report_date = sc.next().split("$")[0];
    }

    public Integer getBug_id() {
        return bug_id;
    }

    public Integer getPriority_id() {
        return priority_id;
    }

    @Override
    public String toString() {
        return bug_id + ";" + page + ";" + bug_title + ";" + priority_id + ";" + report_date;
    }
}
