package org.example.network.noBlock;

import org.example.network.yeek.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

public class NServer {
    private Selector selector = null;
    private Charset charset = Charset.forName("UTF-8");
    public void init() throws IOException {
        selector = Selector.open();
        ServerSocketChannel server = ServerSocketChannel.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 30000);
        //绑定
        server.socket().bind(isa);
        //设置非阻塞方式工作
        server.configureBlocking(false);
        //将server注册到指定Selector对象
        server.register(selector, SelectionKey.OP_ACCEPT);
        while(selector.select()>0){
            for(SelectionKey sk : selector.selectedKeys()){
                selector.selectedKeys().remove(sk);
                if(sk.isAcceptable()){
                    SocketChannel sc = server.accept();
                    sc.configureBlocking(false);
                    sc.register(selector,SelectionKey.OP_READ);
                    sk.interestOps(SelectionKey.OP_ACCEPT);
                }
                if(sk.isReadable()){
                    SocketChannel sc = (SocketChannel) sk.channel();
                    ByteBuffer buff = ByteBuffer.allocate(1024);
                    String content = "";
                    try{
                        while (sc.read(buff) > 0){
                            buff.flip();
                            content += charset.decode(buff);
                        }
                        System.out.println("=====" + content);
                        sk.interestOps(SelectionKey.OP_READ);
                    }catch (IOException e){
                        sk.channel();
                        if(sk.channel() != null){
                            sk.channel().close();
                        }
                    }
                    if(content.length() > 0){
                        for(SelectionKey key : selector.keys()){
                            SelectableChannel targetChannel = key.channel();
                            if(targetChannel instanceof SocketChannel){
                                SocketChannel dest = (SocketChannel) targetChannel;
                                dest.write(charset.encode(content));
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new NServer().init();
    }
}
