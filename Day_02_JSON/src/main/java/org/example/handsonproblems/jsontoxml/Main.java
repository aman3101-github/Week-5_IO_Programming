package org.example.handsonproblems.jsontoxml;

import org.json.JSONObject;
import org.json.XML;

public class Main {

    public static String convertJsonToXml(String jsonString) {
        // Convert JSON to JSONObject
        JSONObject jsonObject = new JSONObject(jsonString);

        // Convert JSON to XML
        return XML.toString(jsonObject);
    }

    public static void main(String[] args) {
        // Sample JSON
        String json = "{ \"name\": \"Aman\", \"age\": 25, \"email\": \"aman@example.com\" }";

        // Convert to XML
        String xml = convertJsonToXml(json);

        // Print XML output
        System.out.println("Converted XML:\n" + xml);
    }
}

