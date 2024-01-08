package com.example.server;

import com.example.StudentServiceGrpc;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GRpcService
public class Server extends StudentServiceGrpc.StudentServiceImplBase {
    public void getStudent(com.example.StudentRequest request,
                           io.grpc.stub.StreamObserver<com.example.StudentResponse> responseObserver) {
        Logger logger = LoggerFactory.getLogger(Server.class);
        logger.info("got request ========================= = " + request.getId());
        com.example.StudentResponse studentResponse = com.example.StudentResponse.newBuilder()
                .setAge(30).setName("Mihir")
                .build();

        responseObserver.onNext(studentResponse);
        responseObserver.onCompleted();
    }
}
