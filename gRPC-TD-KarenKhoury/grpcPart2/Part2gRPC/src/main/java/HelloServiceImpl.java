import MyLab1.HelloRequest;
import MyLab1.HelloResponse;
import MyLab1.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;


private static class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    /**
     * Handles the SayHello RPC method.
     *
     * This method takes a HelloRequest message as input and responds with a HelloResponse message.
     *
     * @param request The HelloRequest message containing the greeting.
     * @param responseObserver The response observer to send the HelloResponse message.
     */
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        // Get the greeting from the request message
        String greeting = request.getGreeting();

        // Create the reply message with the greeting
        String reply = "Hello, " + greeting + "!";

        // Build the HelloResponse message
        HelloResponse response = HelloResponse.newBuilder().setReply(reply).build();

        // Send the response message to the client
        responseObserver.onNext(response);

        // Complete the RPC call
        responseObserver.onCompleted();
    }
}
