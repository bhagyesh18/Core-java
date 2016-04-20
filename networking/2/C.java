import java.io.*;
import java.net.*;
class C{
	public static void main(String args[]){
		try{
			String server = args[0];
			int port = Integer.parseInt(args[1]);
			int send = Integer.parseInt(args[2]);
			Socket s = new Socket(server, port);
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeInt(send);
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			int receive = dis.readInt();
			System.out.println("Received "+receive);
			s.close();
		}
		catch(Exception e){

		}
	}
}