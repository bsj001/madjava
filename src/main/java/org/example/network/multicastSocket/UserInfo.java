package org.example.network.multicastSocket;

import java.net.SocketAddress;

public class UserInfo {
    private String icon;
    private String name;
    //该用户的MulticastAddress 所在的IP 和 端口
    private SocketAddress address;
    //该用户失去联系的次数
    private int lost;
    //该用户对应的交谈窗口
    private ChatFrame chatFrame;
    public UserInfo(){}

    public UserInfo(String icon, String name, SocketAddress address, int lost) {
        this.icon = icon;
        this.name = name;
        this.address = address;
        this.lost = lost;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SocketAddress getAddress() {
        return address;
    }

    public void setAddress(SocketAddress address) {
        this.address = address;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public ChatFrame getChatFrame() {
        return chatFrame;
    }

    public void setChatFrame(ChatFrame chatFrame) {
        this.chatFrame = chatFrame;
    }

    public int hashCode(){
        return address.hashCode();
    }
    public boolean equals(Object obj){
        if(obj != null && obj.getClass() == UserInfo.class){
            return ((UserInfo)obj).getAddress().equals(address);
        }
        return false;
    }
}
