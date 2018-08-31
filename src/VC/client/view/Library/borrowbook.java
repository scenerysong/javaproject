package VC.client.view.Library;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import java.awt.Container;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class borrowbook extends JFrame implements ActionListener {
	
	//DefaultTableModel defaultModel = null;
	JTable table = null;
	JPanel panel = new JPanel();
	Vector v1 = new Vector();
	JFrame f = new JFrame();

	String[] bookName = { "History", "Science", "Future", "Policy", "Furture" };

	public borrowbook() {
		//JFrame f = new JFrame();
		MyTable18 mt = new MyTable18();
		final JTable table = new JTable(mt);
		JCheckBox jc1 = new JCheckBox();
		table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jc1));
		table.setPreferredScrollableViewportSize(new Dimension(400, 150));
		
		Object[][] p = {
                { "History", "987", "Mike",false },
                { "Science", "124", "Dan", false }, 
                {"Future","246","Peter",false},
                {"Policy","768","Markus",false},
                {"Furture","111","Song",false},};
		
		String[] n = { "����", "������", "����", "�Ƿ�����鵥" };
		

		//defaultModel = new DefaultTableModel(p, n);
        JScrollPane s = new JScrollPane(table);
        f.getContentPane().add(s, BorderLayout.CENTER);
		// ����һ��Ĭ�ϵı��ģ��

		//defaultModel = new DefaultTableModel(p, n);
		//table = new JTable(defaultModel);
		//table.setPreferredScrollableViewportSize(new Dimension(400, 80));
        
        table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();

				int column = table.getSelectedColumn();
				Object obj = table.getValueAt(row, column);
				Object obj1 = true;
				if (table.isCellSelected(row, column)) {
					System.out.println(obj);
					if (obj.equals(obj1)) {
						//System.out.println(row);
						v1.add(row);
					}
				}
			}
		});

		// JPanel panel = new JPanel();
		JButton b = new JButton("�����鵥");
		panel.add(b);
		b.addActionListener(this);
		b = new JButton("�ҵ��鵥");
		panel.add(b);
		b.addActionListener(this);
		b = new JButton("����");
		panel.add(b);
		b.addActionListener(this);

		Container contentPane = f.getContentPane();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(s, BorderLayout.CENTER);
		f.getContentPane().add(s, BorderLayout.CENTER);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setLocation(200, 200);
		f.setResizable(false);
        f.setTitle("����У԰ͼ��ݽ������");
        f.pack();
        f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("�����鵥")) {
			for (int i = 0; i < v1.size(); i++) {
				int a = v1.indexOf(i);
				System.out.println(bookName[a]);
				// �Ժ�������ݿ�
			
			}

		}
		if (e.getActionCommand().equals("����")) {
			new mainFrame();
			f.setVisible(false);
			//setVisible(false);
		}
		if (e.getActionCommand().equals("�ҵ��鵥")) {
			new mybook();
			f.setVisible(false);
		}
		//table.revalidate();
	}

	public static void main(String[] args) {
		new borrowbook();
	}

}

class MyTable18 extends AbstractTableModel {
	Object[][] p = {
            { "History", "987", "Mike",false },
            { "Science", "124", "Dan", false }, 
            {"Future","246","Peter",false},
            {"Policy","768","Markus",false},
            {"Furture","111","Song",false},};

	String[] n = { "����", "������", "����", "�Ƿ�����鵥" };

	@Override
	public int getRowCount() {
		return p.length;
	}

	@Override
	public int getColumnCount() {
		return n.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return p[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return n[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		//p[rowIndex][columnIndex] = aValue;
		fireTableCellUpdated(rowIndex, columnIndex);
	}
}