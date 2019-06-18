package lifegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class LifeGame extends JFrame {
private final static World world = new World();

public LifeGame(int rows, int columns) {
	new Thread(world).start();
	add(world);
}

	public static void main(String[] args) {
		LifeGame frame = new LifeGame(40, 50);
		frame.addMouseListener(new MouseListener() { // Ϊ�����������¼�������
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (world.click == true) {
					if (e.getButton() == e.BUTTON3) { // �жϻ�ȡ�İ�ť�Ƿ�Ϊ�����һ�
						if (world.currentGeneration[e.getY() / 20 - 2][e.getX() / 20] == 0)
							world.set(e.getY() / 20 - 2, e.getX() / 20, 1);
						else
							world.set(e.getY() / 20 - 2, e.getX() / 20, 0);
						world.repaint();
					}
				}
			}

@Override
public void mouseClicked(MouseEvent e) {
// TODO Auto-generated method stub

}

@Override
public void mouseReleased(MouseEvent e) {
// TODO Auto-generated method stub

}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		JMenuBar menu = new JMenuBar();
		frame.setJMenuBar(menu);

		JMenu options = new JMenu("����");
		menu.add(options);

		JMenuItem stop = options.add("��ͣ");
		stop.addActionListener(frame.new stopActionListener());

		JMenuItem start = options.add("��ʼ");
		start.addActionListener(frame.new startActionListener());

		JMenu shape = new JMenu("��ʼ��״");
		menu.add(shape);
		JMenuItem restart = shape.add("�����״");
		restart.addActionListener(frame.new restartActionListener());
		JMenuItem rand = shape.add("�������ģʽ");
		rand.addActionListener(frame.new RandActionListener());
		JMenuItem click = shape.add("�����Ҽ����ģʽ");
		click.addActionListener(frame.new clickActionListener());
		JMenuItem unclick = shape.add("ȡ���Ҽ����ģʽ");
		unclick.addActionListener(frame.new unclickActionListener());

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1007, 859);
		frame.setTitle("������Ϸ");
		frame.setVisible(true);
		frame.setResizable(false);
	}

	class stopActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			world.isChanging = false;
		}
	}

	class startActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			world.isChanging = true;
		}
	}

	class clickActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			world.click = true;
		}
	}

	class unclickActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			world.click = false;
		}
	}

	class restartActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j < 50; j++) {
					world.set(i, j, 0);

				}
			}
			world.repaint();
		}
	}

	class RandActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			double x = 0;
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j < 50; j++) {
					x = Math.random();
					if (x <= 0.5)
						world.set(i, j, 0);
					if (x > 0.5)
						world.set(i, j, 1);
				}

			}
			world.repaint();

		}
	}
}
