import java.io.*;
import java.util.*;
import java.net.*;
class S{
	public static void main(String args[]){
		try{
			int port = Integer.parseInt(args[0]);
			ServerSocket ss = new ServerSocket(port);
			while(true){
				Socket s = ss.accept();
				InputStream is = s.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				int i = dis.readInt();
				i = i*i;
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeInt(i);
				s.close();
			}
		}
		catch(Exception e){

		}
	}
}