import java.io.*;
import java.net.*;
public class Server{
        public static void main(String[] args){
                try{
                       
                        int port = Integer.parseInt(args[0]);
                      
                        ServerSocket ss = new ServerSocket(port);
                      
                        Socket server = ss.accept();
                     
                        System.out.println("Connected...");
                        
                        DataInputStream in = new DataInputStream(server.getInputStream());
                       
                        DataOutputStream out = new DataOutputStream(server.getOutputStream());
                       
                        String data = (String)in.readUTF();
                        
                        String numbers[] = data.split(" ");
                        String operation = numbers[0];
                        int num1 = Integer.parseInt(numbers[1]);
                        int num2 = Integer.parseInt(numbers[2]);
                        int num3 = Integer.parseInt(numbers[3]);
                        
                        System.out.println("Received numbers : "+num1+" "+num2+" "+num3);
                        System.out.println("Operation        : "+operation);
                       
                        if(operation.equals("findMin"))
                        {
                                int min = Math.min(num1,Math.min(num2,num3));
                                
                                out.writeUTF(String.valueOf(min));

                        }else if(operation.equals("findMax"))
                        {
                                int max = Math.max(num1,Math.max(num2,num3));
                             
                                out.writeUTF(String.valueOf(max));
                        }
                        
                        in.close();
                        out.close();
                        server.close();
                }catch(Exception e)
                {
                        System.out.println(e);
                }
        }
}