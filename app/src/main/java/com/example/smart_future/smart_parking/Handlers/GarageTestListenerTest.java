package com.example.smart_future.smart_parking.Handlers;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.example.smart_future.smart_parking.Util.GarageListener;

import com.example.smart_future.smart_parking.Crypto.CryptoUtils;
import com.example.smart_future.smart_parking.Crypto.CryptoException;

/**
 * Created by Nate Houlihan on 1/29/2018.
 */

public class GarageTestListenerTest {
    @SuppressWarnings("resource")
        public static void main(String[] args) throws Exception {
            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);

            Scanner scanner = new Scanner(new File("res/resources.cfg"));

            String key = scanner.nextLine();
            String pwd = "";

            File encryptedFile = new File("res/mongosrv.conf");
            try {
                pwd = CryptoUtils.decrypt(key, encryptedFile);
            } catch (CryptoException ex) {
            }

            MongoClientURI uri = new MongoClientURI("mongodb+srv://n8houl:" + pwd + "@seniordesign2-ssssl.mongodb.net/");

            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase db = mongoClient.getDatabase("Garages");
            MongoCollection<Document> collectionTest = db.getCollection("GarageTest");

            Thread threadTest = new Thread(new GarageListener(collectionTest), "ThreadTest");
            threadTest.start();
        }

    public static String encrypt(String strClearText, String strKey) throws Exception{
        String strData="";

        try {
            SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
            Cipher cipher=Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
            byte[] encrypted=cipher.doFinal(strClearText.getBytes());
            strData=new String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }

    public static String decrypt(String strEncrypted,String strKey) throws Exception{
        String strData="";

        try {
            SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
            Cipher cipher=Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, skeyspec);
            byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
            strData=new String(decrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }
}
