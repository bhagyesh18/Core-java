import java.io.*;
import java.util.*;
import java.net.*;
class IAmServer{
	public static void main(String args[]){
		try{
			Random r = new Random();
			int port = Integer.parseInt(args[0]);
			ServerSocket ss = new ServerSocket(port);
			while(true){
				Socket s = ss.accept();
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeInt(r.nextInt());
				s.close();
			}
		}
		catch(Exception e){

		}
	}
}