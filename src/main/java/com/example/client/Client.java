package com.example.client;

import com.example.StudentRequest;
import com.example.StudentResponse;
import com.example.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Client {
    static Logger logger = LoggerFactory.getLogger(Client.class);
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();
       // StudentServiceGrpc.StudentServiceStub nonBlockingStub = StudentServiceGrpc.newStub(managedChannel);
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
       StudentResponse studentResponse= blockingStub.getStudent(StudentRequest.newBuilder().setId(1).build());
        logger.info("response = " + studentResponse.getName() + " " + studentResponse.getAge());
    }
}
