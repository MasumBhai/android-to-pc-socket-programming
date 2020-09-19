import org.ietf.jgss.GSSCredential;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class reZeroKara{
	private JPanel rootpanel;
	private JButton buttonforhelp;
	private JButton buttonforcommand;
	private JTextField textField1;
	private JButton buttonforip;
	private JTextField textField2;
	private JButton buttonforgetresult;
	private JTextArea textAreaforrsult;
	private JButton buttonforsave;
	private JScrollPane scroll;

	public static final int socket_port = 8080;
	//public static final String Server = ""
	private static Socket s;
	private static BufferedReader br;
	private static InputStreamReader isr;
	private static ServerSocket ss;
	private static String message = null;

	public reZeroKara() {
		
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				reZeroKara obj1 = new reZeroKara();
				JFrame rootFrame = new JFrame();
//				obj1.scroll = new JScrollPane(obj1.textAreaforrsult, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//				rootFrame.add(obj1.scroll);
				rootFrame.add(obj1.rootpanel);
				rootFrame.setVisible(true);
				rootFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				rootFrame.setSize(500, 400);
				rootFrame.setLocationRelativeTo(null);
			}
		});

		try {
			while(true) {
				try {
					ss = new ServerSocket(socket_port);
				} catch (BindException e) {
					e.printStackTrace();
				}
				s = ss.accept();
				isr = new InputStreamReader(s.getInputStream());
				br = new BufferedReader(isr);
				message = br.readLine();
				System.out.println(message);
				if(message.equals("")){
					System.out.println("android " + message);
				}else{
					System.out.println("\n" + message); // TODO: 9/18/2020 some modification needed here 
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
