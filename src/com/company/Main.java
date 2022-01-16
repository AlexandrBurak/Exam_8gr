package com.company;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner sc1 = new Scanner(new File("input1.txt"));
        Scanner sc2 = new Scanner(new File("input2.txt"));
        Scanner sc3 = new Scanner(new File("input3.txt"));
        Scanner sc3_1 = new Scanner(new File("input3.txt"));
        Scanner sc4 = new Scanner(new File("input4.txt"));
        Scanner sc4_1 = new Scanner(new File("input4.txt"));
        sc1.useDelimiter("[;\\n]");
        sc2.useDelimiter("[;\\n]");
        sc3.useDelimiter("[;\\n]");
        sc3_1.useDelimiter("[;\\n]");
        sc4.useDelimiter("[;\\n]");
        sc4_1.useDelimiter("[;\\n]");
        ArrayList<Bug> bugs = new ArrayList<>();
        ArrayList<Qa> qas = new ArrayList<>();
        while(sc1.hasNextLine()){
            bugs.add(new Bug(sc1));
        }
        while(sc2.hasNextLine()){
            qas.add(new Qa(sc2));
        }
        HashMap<Integer, Integer> bug_idAndqa_id = new HashMap<>();
        HashMap<String, Integer> priority_id_idAndpriority = new HashMap<>();
        HashMap<Integer, String> priority_id_idAndpriority_1 = new HashMap<>();
        while(sc3.hasNext()){
            bug_idAndqa_id.put(Integer.valueOf(sc3.next()), Integer.valueOf(sc3.next().split("")[0]));
        }


        while(sc4.hasNext()){
            String tmp = "";
            tmp = sc4.next();
            priority_id_idAndpriority.put(sc4.next().split("$")[0], Integer.valueOf(tmp));
        }
        while(sc4_1.hasNext()){
            priority_id_idAndpriority_1.put(Integer.valueOf(sc4_1.next()), sc4_1.next().split("$")[0]);
        }
        Scanner sc5 = new Scanner(new File("input5.txt"));
        String priority_in = sc5.next();
        Integer priority_id = priority_id_idAndpriority.get(priority_in);
        PrintWriter pw1 = new PrintWriter(new File("output1.txt"));
        for(int i = 0; i < bugs.size(); i++){
            Integer tmp = 0;
            tmp = bugs.get(i).getPriority_id();
            if (tmp == priority_id){
                if(i == bugs.size() - 1){
                    pw1.print(bugs.get(i).bug_title);
                    break;
                }
                pw1.println(bugs.get(i).bug_title);
            }
        }
        pw1.flush();

        Comparator<Bug> cmp = new Comparator<Bug>() {
            @Override
            public int compare(Bug o1, Bug o2) {
                int o1_id = o1.priority_id;
                int o2_id = o2.priority_id;
                Integer frst_pr = Integer.valueOf(priority_id_idAndpriority_1.get(o1_id).split("")[1]);
                Integer scnd_pr = Integer.valueOf(priority_id_idAndpriority_1.get(o2_id).split("")[1]);
                return frst_pr.compareTo(scnd_pr);

            }
        };

        Collections.sort(bugs, cmp);


        PrintWriter pw2 = new PrintWriter(new File("output2.txt"));
        for(int i = 0; i < bugs.size(); i++){
                if(i == bugs.size() - 1){
                    pw2.print(bugs.get(i).bug_title + ";P" + bugs.get(i).priority_id);
                    break;
                }
                pw2.println(bugs.get(i).bug_title + ";P" + bugs.get(i).priority_id);

        }
        pw2.flush();
        Scanner sc6 = new Scanner(new File("input6.txt"));
        Integer qa_id = Integer.valueOf(sc6.next());
        ArrayList<Integer> bugs_ids = new ArrayList<>();
        while(sc3_1.hasNext()){
            Integer tmp1 = Integer.valueOf(sc3_1.next());
            Integer tmp2 = Integer.valueOf(sc3_1.next().split("")[0]);
            if (tmp2 == qa_id){
                bugs_ids.add(tmp1);
            }
        }
        PrintWriter pw3 = new PrintWriter(new File("output3.txt"));
        for(int i = 0; i < bugs_ids.size(); i++){
            for(int j = 0; j < bugs.size(); j++){
                if(bugs_ids.get(i) == bugs.get(j).bug_id){
                    if(i == bugs_ids.size() - 1){
                        pw3.print(bugs.get(j).bug_title);
                        break;
                    }
                    pw3.println(bugs.get(j).bug_title);
                }
            }
        }
        pw3.flush();
    }

}
