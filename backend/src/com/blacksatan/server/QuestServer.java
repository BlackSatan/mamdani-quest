package com.blacksatan.server;

import java.io.BufferedReader;
import java.nio.ByteBuffer;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import com.blacksatan.dev.FuzzyAlgorithmBuilder;
import org.java_websocket.WebSocket;
import org.java_websocket.server.WebSocketServer;
import org.java_websocket.handshake.ClientHandshake;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.Collection;
import com.blacksatan.fuzzy.MamdaniAlgorithm;
import java.util.Map;


public class QuestServer extends WebSocketServer {

    public QuestServer( int port ) throws UnknownHostException {
        super( new InetSocketAddress( port ) );
    }

    @Override
    public void onMessage( WebSocket conn, ByteBuffer message ) {
        broadcast( message.array() );
        System.out.println( conn + ": " + message );
    }

    @Override
    public void onMessage( WebSocket conn, String message ) {
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> answers = gson.fromJson(message, mapType);

        FuzzyAlgorithmBuilder b = new FuzzyAlgorithmBuilder();
        MamdaniAlgorithm algorithm = b.build(new double[]{
                Integer.parseInt(answers.get("start")),
                Integer.parseInt(answers.get("prop")),
                Integer.parseInt(answers.get("level")),
                Integer.parseInt(answers.get("manage")),
                Integer.parseInt(answers.get("load")),
                Integer.parseInt(answers.get("plan")),
                Integer.parseInt(answers.get("salary")),
                Integer.parseInt(answers.get("zone")),
                Integer.parseInt(answers.get("change")),
                Integer.parseInt(answers.get("workers")),
        });
        Double result = algorithm.run().get(0);
        Integer numResult = result.isNaN() ? 1 : result.intValue();
        conn.send(gson.toJson(numResult));
        System.out.println( conn + ": " + message );
        System.out.println(result);
    }

    @Override
    public void onOpen( WebSocket conn, ClientHandshake handshake ) {
        conn.send("Welcome to the server!"); //This method sends a message to the new client
        broadcast( "new connection: " + handshake.getResourceDescriptor() ); //This method sends a message to all clients connected
        System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + " entered the room!" );
    }

    @Override
    public void onClose( WebSocket conn, int code, String reason, boolean remote ) {
        broadcast( conn + " has left the room!" );
        System.out.println( conn + " has left the room!" );
    }

    @Override
    public void onError( WebSocket conn, Exception ex ) {
        ex.printStackTrace();
        if ( conn != null ) {
            // some errors like port binding failed may not be assignable to a specific websocket
        }
    }

    @Override
    public void onStart() {
        System.out.println("Server started!");
    }
}
