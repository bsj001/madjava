//package org.example.network.multicastSocket;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.net.DatagramPacket;
//import java.net.InetSocketAddress;
//import java.net.SocketAddress;
//import java.text.DateFormat;
//import java.util.Date;
//
//public class LanChat extends JFrame {
//    private DefaultListModel listModel = new DefaultListModel();
//    private JList friendsList = new JList(listModel);
//    private DateFormat formatter= DateFormat.getDateTimeInstance();
//    public LanChat(){
//        super("局域网聊天");
//        friendsList.setCellRenderer(new ImageCellRender());
//        listModel.addElement(new UserInfo("all","所有人",null,-2000));
//        friendsList.addMouseListener(new ChangeMusicListener());
//        add(new JScrollPane(friendsList));
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(2,2,160,600);
//    }
//    public void addUser(UserInfo user){
//        listModel.addElement(user);
//    }
//    
//    public void removeUser(int pos){
//        listModel.removeElement(pos);
//    }
//    
//    public UserInfo getUserBySocketAddress(SocketAddress address){
//        for (int i = 0; i < getUserNum(); i++) {
//            UserInfo user = getUser(i);
//            if(user.getAddress() != null
//            && user.getAddress().equals(address)){
//                return user;
//            }
//        }
//        return null;
//    }
//    
//    //---------------下面两个方法是对ListModel的包装
//    //获取该聊天的用户数量
//    public int getUserNum(){
//        return listModel.size();
//    }
//    public UserInfo getUser(int pos){
//        return (UserInfo) listModel.elementAt(pos);
//    }
//    class ChangeMusicListener extends MouseAdapter{
//        public void mouseClicked(MouseEvent e){
//            if(e.getClickCount() >= 2){
//                UserInfo user = (UserInfo) friendsList.getSelectedValue();
//                if(user.getChatFrame() == null){
//                    user.setChatFrame(new ChatFrame(null,user));
//                }
//                if(!user.getChatFrame().isShowing()){
//                    user.getChatFrame().setVisible(true);
//                }
//            }
//        }
//    }
//    /**
//     * 
//     */
//    public void processMsg(DatagramPacket packet,boolean single){
//        InetSocketAddress srcAddress = (InetSocketAddress) packet.getSocketAddress();
//        if(single){
//            srcAddress = new InetSocketAddress(srcAddress.getHostName(),
//                    srcAddress.getPort() - 1);
//            UserInfo srcUser = getUserBySocketAddress(srcAddress);
//            if(srcUser != null){
//                UserInfo alertUser = single ? srcUser : getUser(0);
//                if(alertUser.getChatFrame() == null){
//                    alertUser.setChatFrame(new ChatFrame(null,alertUser));
//                }
//                String tipMsg = single ? "对您说：" : "对大家说";
//                alertUser.getChatFrame().addString(srcUser.getName() + tipMsg
//                +"..............("+formatter.format(new Date()+")\n")+
//                        new String(packet.getData(),0,packet.getLength())+"\n");
//                if(!alertUser.getChatFrame().isShowing()){
//                    alertUser.getChatFrame().setVisible(true);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        LanChat lc = new LanChat();
//        new LoginFrame(lc,"请输入用户名、头像后登录");
//    }
//}
//class ImageCellRender extends JPanel implements ListCellRenderer{
//    private ImageIcon icon;
//    private String name;
//    private Color background;
//    private Color foreground;
//
//    @Override
//    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//        UserInfo userInfo = (UserInfo) value;
//        icon = new ImageIcon("icon/"+userInfo.getIcon()+".gif");
//        name = userInfo.getName();
//        background = isSelected ? list.getSelectionBackground() : list.getBackground();
//        foreground = isSelected ? list.getSelectionForeground() : list.getForeground();
//        return this;
//    }
//    
//    public void paintComponent(Graphics g){
//        int imageWidth = icon.getImage().getWidth(null);
//        int imageHeight = icon.getImage().getHeight(null);
//        g.setColor(background);
//        g.fillRect(0,0, getWidth(),getHeight());
//        g.setColor(foreground);
//        g.drawImage(icon.getImage(),getWidth()/2 - imageWidth/2,10,null);
//        g.setFont(new Font("SansSerif",Font.BOLD,18));
//        g.drawString(name,getWidth()/2 - name.length() * 10,imageHeight + 30);
//    }
//    public Dimension getPreferredSize(){
//        return new Dimension(60,80);
//    }
//}
//
