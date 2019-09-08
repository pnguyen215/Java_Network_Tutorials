package com.phuocnguyen012.ManagingAsynchronousCommunicationServer;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class Method implements Serializable {

    private static final long serialVersionUID = 1L;

    public void asynchronousCommunicationServer() {
        try {
            final AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel
                    .open();
            InetSocketAddress address = new InetSocketAddress("localhost", 5000);
            asynchronousServerSocketChannel.bind(address);
            asynchronousServerSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {

                @Override
                public void completed(AsynchronousSocketChannel result, Void attachment) {
                    try {
                        System.out.println("Server: completed method executing!");
                        while (true) {
                            ByteBuffer byteBuffer = ByteBuffer.allocate(32);
                            System.out.println("Server: message received: " + new String(byteBuffer.array()));

                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                @Override
                public void failed(Throwable exc, Void attachment) {
                    System.out.println("Server: CompletionHandler exception");
                    System.out.println(exc.getMessage());
                }

            });
            /*
			 * waiting
             */
            while (true) {
                ///
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
