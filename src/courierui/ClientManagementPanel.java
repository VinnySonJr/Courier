package courierui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import courierpd.Client;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientManagementPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6553392431507855432L;

	/**
	 * Create the panel.
	 */
	public ClientManagementPanel(JFrame currentFrame) {
		setLayout(null);
		
		JList<Client> list = new JList<Client>();
		list.setBounds(84, 108, 791, 406);
		add(list);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(152, 547, 97, 25);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdate.setBounds(450, 547, 97, 25);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(732, 547, 97, 25);
		add(btnDelete);
		
		JLabel lblClientList = new JLabel("Client List");
		lblClientList.setBounds(465, 41, 56, 16);
		add(lblClientList);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(329, 79, 56, 16);
		add(lblName);
		
		JLabel lblNewLabel = new JLabel("Account Number");
		lblNewLabel.setBounds(105, 79, 118, 16);
		add(lblNewLabel);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(541, 79, 97, 16);
		add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(788, 79, 56, 16);
		add(lblEmail);

	}
}