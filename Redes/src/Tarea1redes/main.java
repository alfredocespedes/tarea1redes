package Tarea1redes;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class main {
	public static void main(String args[]) throws
	UnknownHostException, IOException{
		
		byte[] buffer = new byte[1024];
		int bytes;
		int Puerto=8000;
		ServerSocket servidor = new ServerSocket(Puerto);
		
		while(true){
			System.out.println("Esperando cliente");
			Socket cliente = servidor.accept();
			System.out.println("Cliente conectado");
			System.setProperty("line.separador","\r\n");
			Scanner lee = new Scanner(cliente.getInputStream());
			PrintWriter escribe = new PrintWriter(cliente.getOutputStream(),true);
			
			String metodo = lee.next();
			System.out.println(metodo);
			
			String fichero = "." + lee.next(); 
		
			FileInputStream fis = null; 
			boolean existe = true; 
			
			int i = 0;
			
			try { 
				fis = new FileInputStream(fichero); 
			} 
			catch (FileNotFoundException e) { 
				existe = false; 
			} 
				 
			if (existe && fichero.length()>2) 
				while((bytes = fis.read(buffer)) != -1 )
					cliente.getOutputStream().write(buffer, 0, bytes); 
			else {
				escribe.println("HTTP/1.0 404 Not Found"); 
				escribe.println(); 
			}
			String aRemplazar = null;
			cliente.close();
			//lee.close();
			//escribe.close();
			//fis.close();
			if(metodo.equals("POST")){
				while(i<34){
					aRemplazar = lee.next();
					  
					
					//System.out.println(escribe);
					i++;
					
				}
			}
			
			FileWriter fichero1 = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero1 = new FileWriter("archivo.txt",true);
	            pw = new PrintWriter(fichero1);
	            
	            //String aRemplazar = null;
		        //String remplazado1 = null;
		        //String remplazado2 = null;
		        //String remplazado3 = null;
		        //String remplazado4 = null;
		        //String remplazado5 = null;
		        //String remplazadoFinal = null;
	            
	           
	 			String remplazado1=aRemplazar.replace("username", "");
	 			String remplazado2=remplazado1.replace("=", " ");
	 			String remplazado3=remplazado2.replace("&", "");
	 			String remplazado4=remplazado3.replace("send_button", "");
	 			String remplazado5=remplazado4.replace("ip", "");
	 			String remplazadoFinal=remplazado5.replace("port", "");

	            
	            pw.append(remplazadoFinal);
	            
	            File archivo = null;
	  	      	FileReader fr = null;
	  	      	BufferedReader br = null;
	            
	            archivo = new File ("archivo.txt");
		        fr = new FileReader (archivo);
		        br = new BufferedReader(fr);
		 
		         // Lectura del fichero

		         	 
	        

	            
	            
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero1)
	              fichero1.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }

			
			
			
			  
			
			
			
		}
	}

}
