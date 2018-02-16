package testPipe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import consumatori.Consumator;
import producatori.Producator;

public class TestPipe {
public static void main(String[] args) throws IOException{
	PipedOutputStream pipeOut=new PipedOutputStream();
	PipedInputStream pipeIn=new PipedInputStream(pipeOut);
	DataOutputStream out=new DataOutputStream(pipeOut);
	DataInputStream in=new DataInputStream(pipeIn);
	Producator p1=new Producator(out);
	Consumator c1=new Consumator(in);
	p1.start();
	c1.start();
	}
}
