package com.sapient;

import java.util.ArrayList;
import java.util.List;

public class OptionalClassDemo {

    public static void main(String[] args) {
        List<Trainer> trainerList = new ArrayList<Trainer>();

        trainerList.add(new Trainer(100,"ABCD","abcd@sapient.com"));
        trainerList.add(new Trainer(101,"MNO","mno@sapient.com"));
        trainerList.add(new Trainer(102,"XYZ","xyz@sapient.com"));
        trainerList.add(new Trainer(103,"PQR","pqr@sapient.com"));
        trainerList.add(new Trainer(104,"STU","stu@sapient.com"));
        trainerList.add(new Trainer());

        trainerList.set(5,null);

        for (Trainer tnr: trainerList) {
            System.out.println(tnr.getId());
        }

    }


}
