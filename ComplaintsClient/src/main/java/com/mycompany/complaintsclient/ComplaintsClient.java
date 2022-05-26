/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.complaintsclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import entities.Complaint;
import java.util.ArrayList;
import java.util.Arrays;
import javax.jms.Message;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;


/**
 *
 * @author user
 */
public class ComplaintsClient
{
        public static void main(String[] args) {
        
        ClientConfig config = new ClientConfig();
        config.register(new ObjectMapper().registerModule(new JavaTimeModule()));
        Client client = ClientBuilder.newClient(config);
        String count
                = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints/count")
                        .request(MediaType.TEXT_PLAIN)
                        .get(String.class);

        System.out.println("Count: " + count);
        
       Complaint[] allComplaints = client.target("http://localhost:8080/Complaints/"
               + "resources/complaints")
                .request(MediaType.APPLICATION_JSON)
                .get(Complaint[].class);
        System.out.println("All complaints: \n" + Arrays.toString(allComplaints));
        
        
         Complaint openComplaint = null;
         for (Complaint c:allComplaints)
         {
             if(("open").equals(c.getStatus()))
             {
                openComplaint= client.target("http://localhost:8080/Complaints/"
               + "resources/complaints/"+c.getId())
                .request(MediaType.APPLICATION_JSON)
                .get(Complaint.class);
                 break;
             }
         }
         
         System.out.println("Open complaint: "+ openComplaint);
        
         Complaint closedComplaint = openComplaint;
         closedComplaint.setStatus("closed");
        
        client.target("http://localhost:8080/Complaints/"
               + "resources/complaints/"+closedComplaint.getId())
                .request()
                .put(Entity.entity(closedComplaint, MediaType.APPLICATION_JSON));
        
        System.out.println("Closed complaint: "+ closedComplaint.toString());
       
        
        Complaint[] openComplaints = client.target("http://localhost:8080/Complaints/"
               + "resources/complaints")
                .queryParam("status", "open")
                .request(MediaType.APPLICATION_JSON)
                .get(Complaint[].class);
                
            System.out.println("Open complaints:\n"+ Arrays.toString(openComplaints));            
             
        client.close();
    }
    
}
