import java.io.*;
import java.net.*;
class IAmClient{
	public static void main(String args[]){
		try{
			int port = Integer.parseInt(args[1]);
			String server = args[0];
			Socket s = new Socket(server, port);
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			int i = dis.readInt();
			System.out.println(i);
			s.close();
		}
		catch(Exception e){

		}
	}
}