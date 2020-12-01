package graphicalElements;

import javax.imageio.ImageIO;
import javax.swing.*;

import gameCommons.IFrog;
import util.Direction;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class FroggerGraphic extends JPanel implements IFroggerGraphics, KeyListener {
	private ArrayList<Element> elementsToDisplay;
	private int pixelByCase = 32;
	private int width;
	private int height;
	private IFrog frog;
	private JFrame frame;

	/*private BufferedImage frogSprit = null;
	private BufferedImage rightCar = null;
	private BufferedImage leftCar = null;
	private BufferedImage rightCar2 = null;
	private BufferedImage leftCar2 = null;
	private BufferedImage rightCar3 = null;
	private BufferedImage leftCar3 = null;*/

	public FroggerGraphic(int width, int height) {
		this.width = width;
		this.height = height;
		elementsToDisplay = new ArrayList<Element>();

		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(width * pixelByCase, height * pixelByCase));

		JFrame frame = new JFrame("Frogger");
		this.frame = frame;
		//ImageIcon logo = new ImageIcon("/frogger.ico");/src/image
		//ImageIcon logo = new ImageIcon("/src/image/frogger.ico");
		ImageIcon logo = new ImageIcon("frog.png");
		frame.setIconImage(logo.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(this);


		/*try {
			frogSprit = ImageIO.read(new File("frog.png"));
			rightCar = ImageIO.read(new File("rightCar.png"));
			leftCar = ImageIO.read(new File("leftCar.png"));
			rightCar2 = ImageIO.read(new File("rightCar2.png"));
			leftCar2 = ImageIO.read(new File("leftCar2.png"));
			rightCar3 = ImageIO.read(new File("rightCar3.png"));
			leftCar3 = ImageIO.read(new File("leftCar3.png"));
		} catch (IOException ioException) {
			System.out.println(ioException);
		}*/
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Random randomGen = new Random();
		for (Element e : elementsToDisplay) {

			//ImageIcon spriteFrog = new ImageIcon("frog.png");
			/*BufferedImage frofro = ImageIO.read(new File("frog.png"));
			g.drawImage(frofro, e.absc, e.ord);*/

			Graphics2D g2d = (Graphics2D) g;
			//g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


			//g2d.drawImage(image, 0,0, pixelByCase, pixelByCase, null);



			//g.setColor(e.color);
			//g.fillRect(pixelByCase * e.absc, pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase - 1);

			/*if (e.color == Color.green) {
				g2d.drawImage(frogSprit, pixelByCase * e.absc,pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase, null);
			}
			else if (e.color == Color.black) { //Voiture venant de la gauche
				int ran = randomGen.nextInt(2);
				/*if (ran == 0) {
					g2d.drawImage(leftCar, pixelByCase * e.absc,pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase, null);
				}
				else if (ran == 1) {
					g2d.drawImage(leftCar2, pixelByCase * e.absc,pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase, null);
				}
				else if (ran == 2) {
					g2d.drawImage(leftCar3, pixelByCase * e.absc,pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase, null);
				}*/
			/*	g2d.drawImage(leftCar, pixelByCase * e.absc,pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase, null);

			}
			else if (e.color == Color.blue) { //Voiture venant de la droite
				int ran = randomGen.nextInt(2);
				/*if (ran == 0) {
					g2d.drawImage(rightCar, pixelByCase * e.absc,pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase, null);
				}
				else if (ran == 1) {
					g2d.drawImage(rightCar2, pixelByCase * e.absc,pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase, null);
				}
				else if (ran == 2) {
					g2d.drawImage(rightCar3, pixelByCase * e.absc,pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase, null);
				}*/
				/*g2d.drawImage(rightCar, pixelByCase * e.absc,pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase, null);
			}*/
			g2d.drawImage(e.sprit, pixelByCase * e.absc,pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase, null);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			frog.move(Direction.up);
			break;
		case KeyEvent.VK_DOWN:
			frog.move(Direction.down);
			break;
		case KeyEvent.VK_LEFT:
			frog.move(Direction.left);
			break;
		case KeyEvent.VK_RIGHT:
			frog.move(Direction.right);
		}
	}

	public void clear() {
		this.elementsToDisplay.clear();
	}

	public void add(Element e) {
		this.elementsToDisplay.add(e);
	}

	public void setFrog(IFrog frog) {
		this.frog = frog;
	}

	public void endGameScreen(String s) {
		frame.remove(this);
		JLabel label = new JLabel(s);
		label.setFont(new Font("Verdana", 1, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setSize(this.getSize());

		JButton button = new JButton("Replay Classique");
		button.setBounds(150,50,150,40);
		JButton button2 = new JButton("Replay Infinity");
		button2.setBounds(150,100,150,40);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Appuie sur le bouton replay classique");
				//frame.getDefaultCloseOperation();
				try {
					Runtime.getRuntime().exec("java -jar out/artifacts/projetFrogger_jar/projetFrogger.jar");
					//Pour la version Runable avec le .JAR
					//Runtime.getRuntime().exec("java -jar projetFrogger.jar");
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
				//System.out.println("Working Directory = " + System.getProperty("user.dir"));
				/*try {
					PrintWriter writer = new PrintWriter("name.txt", StandardCharsets.UTF_8);
					System.out.println("ok");
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}*/
				System.exit (0);
			}
		});
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Appuie sur le bouton replay infinity");

				try {
					Runtime.getRuntime().exec("java -jar out/artifacts/projetFrogger_jar/projetFrogger.jar infinity");
					//Pour la version Runable avec le .JAR
					//Runtime.getRuntime().exec("java -jar projetFrogger.jar infinity");
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		});
		frame.add(button);
		frame.add(button2);
		frame.getContentPane().add(label);
		frame.repaint();

	}

}
