package jpcap;
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.PacketReceiver;
import jpcap.packet.*;

import java.io.IOException;
import java.util.Scanner;
/**
 * @PackgeName: jpcap
 * @ClassName: Jpcap
 * @Author: XuWen
 * Date: 2020/11/9 19:06
 * Introduce:
 */
public class Jpcap {
    private static int model;

    public static void main(String[] args) throws IOException {
        System.out.println("网络设备:");
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();


        for (NetworkInterface n : devices) {
            System.out.print(n.name + "     |     " + n.description + "       |       ");

            for (NetworkInterfaceAddress a : n.addresses) {


                System.out.print(" address:" + a.address);

            }

            System.out.println();
        }
        System.out.println("-------------------------------------------");


        System.out.println("请输入你需要抓取的类型包:");
        System.out.println("TCP包输入‘1’");
        System.out.println("UDP包输入‘2’");
        System.out.println("ICMP包输入‘3’");
        System.out.println("ARP包输入‘4’");
        Scanner in=new Scanner(System.in);
        model = in.nextInt();

        JpcapCaptor jpcap = JpcapCaptor.openDevice(devices[1], 2000, true, 20);

        System.out.println("开始抓取数据:");
        startCapThread(jpcap);

    }



    public static void startCapThread(final JpcapCaptor jpcap){
        JpcapCaptor jp=jpcap;
        java.lang.Runnable rnner=new Runnable(){         //创建线程
            public void run(){
                //使用接包处理器循环抓包
                jpcap.loopPacket(-1, new TestPacketReceiver(model));   //-1无限抓取包，抓包监听器获取包
            }
        };
        new Thread(rnner).start();//启动抓包线程
    }

    static class TestPacketReceiver  implements PacketReceiver {

        public int model;

        public TestPacketReceiver (int n)
        {
            this.model = n;
        }
        /**
         * 实现的接包方法:
         */
        public void receivePacket(Packet packet) {
            //Tcp包
            if(packet instanceof jpcap.packet.TCPPacket && model== 1){
                TCPPacket p=(TCPPacket)packet;
                String s="TCPPacket:| 目的ip及端口 "+p.dst_ip+":"+p.dst_port
                        +"|源ip及端口 "+p.src_ip+":"+p.src_port
                        +" |数据长度: "+p.len;
                System.out.println(s);
            }
            //UDP包
            else if(packet instanceof jpcap.packet.UDPPacket && model== 2){
                UDPPacket p=(UDPPacket)packet;
                String s="UDPPacket:| 目的ip及端口 "+p.dst_ip+":"+p.dst_port
                        +"||源ip及端口 "+p.src_ip+":"+p.src_port
                        +" |数据长度: "+p.len;
                System.out.println(s);
            }
            //ICMPPacket包
            else if(packet instanceof jpcap.packet.ICMPPacket && model== 3){
                ICMPPacket p=(ICMPPacket)packet;
                //ICMP包的路由链
                String router_ip="";
                for(int i=0;i<p.router_ip.length;i++){
                    router_ip+=" "+p.router_ip[i].getHostAddress();
                }
                String s="@ @ @ ICMPPacket:| 路由IP: "+router_ip
                        +" |redir_ip: "+p.redir_ip
                        +" |最大传输单元: "+p.mtu
                        +" |长度: "+p.len;
                System.out.println(s);
            }
            //ARP请求包
            else if(packet instanceof jpcap.packet.ARPPacket && model== 4){
                ARPPacket p=(ARPPacket)packet;
                //Returns the hardware address (MAC address) of the sender
                Object  saa=   p.getSenderHardwareAddress();
                Object  taa=p.getTargetHardwareAddress();
                String s="* * * ARPPacket:| 发送硬件地址： "+saa
                        +"|目标硬件地址： "+taa
                        +" |长度: "+p.len;
                System.out.println(s);

            }


        }


    }
}
