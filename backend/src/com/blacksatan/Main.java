package com.blacksatan;

import com.blacksatan.server.QuestServer;
import java.net.UnknownHostException;


public class Main {


    public static void main(String[] args) {
        try {
            QuestServer server = new QuestServer(5006);
            server.run();
        } catch (UnknownHostException e) {
            System.out.println(e);
        }
    }
}
