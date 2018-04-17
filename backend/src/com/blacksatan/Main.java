package com.blacksatan;

import com.blacksatan.dev.FuzzyAlgorithmBuilder;
import com.blacksatan.fuzzy.*;
import com.blacksatan.server.QuestServer;
import com.blacksatan.dev.FuzzySetTrapezoid;
import com.blacksatan.dev.FuzzySetTrapezoidIntervals;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        //{"start":"1","prop":true,"level":"1","manage":"1","load":"10","plan":"2","salary":"500","zone":"1","change":"4","workers":"1"}
        System.out.println("Hello world");
        FuzzyAlgorithmBuilder b = new FuzzyAlgorithmBuilder();
        System.out.println(b.build(new double[] {2, 2, 2, 2, 10, 2, 1500, 2, 2, 4}).run());
//        try {
//            QuestServer server = new QuestServer(5005);
//            server.run();
//        } catch (UnknownHostException e) {
//            System.out.println(e);
//        }
//        MamdaniAlgorithm algorithm = new MamdaniAlgorithm(getRules(), new double[] {8, 80});
//        List<Double> result = algorithm.run();
//        System.out.println("Algorithm result: " + Arrays.toString(result.toArray()));
    }
}
