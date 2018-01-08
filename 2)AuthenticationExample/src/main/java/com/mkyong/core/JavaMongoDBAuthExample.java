package com.mkyong.core;

import java.net.UnknownHostException;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * Java + MongoDB in Secure Mode
 */
public class JavaMongoDBAuthExample {
    public static void main(String[] args) {

        try {
            Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("mkyong");

            boolean auth = db.authenticate("testdb", "password".toCharArray());
            if (auth) {
                DBCollection table = db.getCollection("user");

                BasicDBObject document = new BasicDBObject();
                document.put("name", "mkyong");
                table.insert(document);

                System.out.println("Login is successful!");
            } else {
                System.out.println("Login is failed!");
            }
            System.out.println("Done");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
