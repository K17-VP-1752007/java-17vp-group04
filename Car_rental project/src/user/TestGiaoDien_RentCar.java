package user;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import vehicle.Car;
import vehicle.VehicleList;

class GiaoDien extends JFrame {
	JLabel pic;
	int current;
	int i, y;
	JLabel finalpic;
	String value;
	String id;
	String model;
	String color;
	String pas;
	String brand;
	String res;
	String cos;
	String type;
	String km, total, lastrent, income;;
	JLabel lbkm, lbtotal, lblast, lbin;
	JLabel lbkms, lbtotals, lblasts, lbins;
	JLabel IDvl, Modelvl, Colorvl, Pasvl, Brvl, Resvl, costvl, typevl;
	JLabel IDvls, Modelvls, Colorvls, Pasvls, Brvls, Resvls, costvls, typevls;
	JLabel rn;
	JScrollPane tab1, tab2;
	JCheckBox week, month;
    JLabel lbweek, lbmonth;
    boolean check;
    JList<String> weekls, monthls; 
    int cmon,cwek;
    static int countDay;
    String weeklist[] = {"1 week", "2 weeks", "3 weeks", "5 weeks", "7 weeks", "9 weeks", "11 weeks"};
    String monthlist[] = {"1 month", "2 months", "3 months", "4 months", "5 months", "6 months", "7 months", "8 months", "9 months", "10 months", "11 months", "12 months"};
	VehicleList A = new VehicleList();
	
	JFrame frame = new JFrame("CGO - Rent Car");
	//Lay gia tri countDay de tinh tien
	static int getValue() {
		return countDay;
	}
	
	public GiaoDien()
	{
		frame.setSize(1500, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocationRelativeTo(null);
		addControl();
		frame.setVisible(true);
		frame.setResizable(false);
		A.ReadAllCar();
		i = 999;
		y = 1000 + A.getCarlist().size();
	}
	
	public void addControl() 
	{
		JPanel Border=new JPanel();
		Border.setLayout(new BorderLayout());
		
		JPanel top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));
		JLabel cont = new JLabel("        Making you most comfortable is our obligation", JLabel.CENTER);
		cont.setSize(450, 450);
		cont.setFont(new Font("Times New Roman", Font.ITALIC, 28));
		cont.setForeground(Color.BLACK);
		
		JLabel minitext = new JLabel("-- Click the |start from| button to start looking --");
		minitext.setSize(450, 450);
		minitext.setFont(new Font("Times New Roman", Font.BOLD, 22));
		minitext.setForeground(Color.BLACK.brighter());
		
		JLabel logo = new JLabel("CGO", JLabel.LEFT);
		logo.setSize(100, 135);
		logo.setFont(new Font("Arial", Font.BOLD, 35));
		logo.setForeground(Color.ORANGE);
		
		top.add(logo);
		top.add(cont);
		
		JPanel bot = new JPanel(new FlowLayout());
		
		JButton previous = new JButton("< Previous");
		previous.setFont(new Font("Arial", Font.ITALIC, 13));
		previous.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton next = new JButton("Next >");
		next.setFont(new Font("Arial", Font.ITALIC, 13));
		next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton rent = new JButton("Rent now!");
		rent.setFont(new Font("Arial", Font.ITALIC, 13));
		rent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		bot.add(previous);
		bot.add(rent);
		bot.add(next);
		
		Border.add(top, BorderLayout.NORTH);
		Border.add(bot, BorderLayout.SOUTH);
		setPicture(logo, "src/user/logocar.png");
		
		pic = new JLabel();
		pic.setSize(1500, 800);
		setPicture(pic, "src/user/sky.jpg");
		
		frame.add(minitext);
		frame.add(pic);
		minitext.setBounds(525, 260, 550, 100);
		pic.setBounds(0, 100, 1500, 500);
		
		final JPanel Center = new JPanel();
		final JPanel Middle = new JPanel();
		
		Center.setLayout(new CardLayout());
		Center.setVisible(false);
		
		Middle.setLayout(new CardLayout());
		Middle.setVisible(false);
		
		final JPanel Mid = new JPanel();
		
		finalpic = new JLabel();
		finalpic.setSize(750,500);
		value = "src/user/logocar.png";
		setPicture(finalpic,value);
		Mid.add(finalpic);
		Mid.setBackground(Color.DARK_GRAY.darker());
		//Tao cac label thong tin xe cho card 1
		JLabel ID = new JLabel("     Car ID");
	    ID.setFont(new Font("Arial", Font.BOLD, 15));
	    IDvl = new JLabel("");
	    
		JLabel Model = new JLabel("     Car model");
		Modelvl = new JLabel("");
		Model.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Color = new JLabel("     Color");
		Colorvl = new JLabel("");
		Color.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel Pas = new JLabel("     Passenger");
		Pasvl = new JLabel("");
		Pas.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Br = new JLabel("     Brand");
		Brvl = new JLabel("");
		Br.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel reserved = new JLabel("     Reserved");
		Resvl = new JLabel("");
		reserved.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel cost = new JLabel("     Cost");
		costvl = new JLabel("");
		cost.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel type = new JLabel("     Type");
		typevl = new JLabel("");
		type.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel kilo = new JLabel("     Total km : ");
		lbkm = new JLabel("");
		kilo.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel tot = new JLabel("     Total rent : ");
		lbtotal = new JLabel("");
		tot.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel last = new JLabel("     Last rent : ");
		lblast = new JLabel("");
		last.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel inc = new JLabel("     Income : ");
		lbin = new JLabel("");
		inc.setFont(new Font("Arial", Font.BOLD, 15));
		
		//Tao cac label thong tin xe cho card 2
		JLabel ID2 = new JLabel("     Car ID");
	    ID2.setFont(new Font("Arial", Font.BOLD, 15));
	    IDvls = new JLabel("");
	    
		JLabel Model2 = new JLabel("     Car model");
		Modelvls = new JLabel("");
		Model2.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Color2 = new JLabel("     Color");
		Colorvls = new JLabel("");
		Color2.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel Pas2 = new JLabel("     Passenger");
		Pasvls = new JLabel("");
		Pas2.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Br2 = new JLabel("     Brand");
		Brvls = new JLabel("");
		Br2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel reserved2 = new JLabel("     Reserved");
		Resvls = new JLabel("");
		reserved2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel cost2 = new JLabel("     Cost");
		costvls = new JLabel("");
		cost2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel type2 = new JLabel("     Type");
		typevls = new JLabel("");
		type2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel kilo2 = new JLabel("     Total km : ");
		lbkms = new JLabel("");
		kilo2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel tot2 = new JLabel("     Total rent : ");
		lbtotals = new JLabel("");
		tot2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel last2 = new JLabel("     Last rent : ");
		lblasts = new JLabel("");
		last2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel inc2 = new JLabel("      Income : ");
		lbins = new JLabel("");
		inc2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel Choose = new JLabel("     Choose type : ");
		Choose.setFont(new Font("Arial", Font.BOLD, 15));
		//Tao Panel chua 2 checkbox
		JPanel Bigbox = new JPanel(new GridLayout(1, 0));
		JPanel panelCheckBox = new JPanel(new GridLayout(1, 0));
		
	    panelCheckBox.add(week = createCheckBox("WEEK"));
	    panelCheckBox.add(month = createCheckBox("MONTH"));
	
	    Bigbox.add(panelCheckBox, BorderLayout.WEST);
	    
	    JPanel listday = new JPanel(new GridLayout(1, 0));
	    //Tao list cac tuan
	    weekls = new JList<String>(weeklist);
		weekls.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tab1 = new JScrollPane(weekls);
		tab1.setPreferredSize(new Dimension(100, 50));
		tab1.setVisible(false);
		//Tao list cac thang
		monthls = new JList<String>(monthlist);
		monthls.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tab2 = new JScrollPane(monthls);
		tab2.setPreferredSize(new Dimension(150, 50));
		tab2.setVisible(false);
		
		ButtonGroup gr = new ButtonGroup();
		gr.add(week);
		gr.add(month);
		
		//Khoi tao chuc nang cho checkbox week
	    week.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                if(ae.getStateChange() == 1)
                {
                	tab1.setVisible(true);
                }
                else
                {
                	tab1.setVisible(false);
                }
            }
        });
	  //Khoi tao chuc nang cho checkbox month
	    month.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                if(ae.getStateChange() == 1)
                {
                	tab2.setVisible(true);
                }
                else 
                {
                	tab2.setVisible(false);
                }
            }
        });
	    
		listday.add(tab1);
		listday.add(tab2);
		
		JLabel Choose2 = new JLabel("     Choose one : ");
		Choose2.setFont(new Font("Arial", Font.BOLD, 15));
		//Khoi tao card thong tin xe thu 1
		final JPanel Card1 = new JPanel();
		Card1.setLayout(new GridLayout(12, 1));
		Card1.add(ID);
		Card1.add(IDvl);
		Card1.add(Model);
		Card1.add(Modelvl);
		Card1.add(Color);
		Card1.add(Colorvl);
		Card1.add(Pas);
		Card1.add(Pasvl);
		Card1.add(Br);
		Card1.add(Brvl);
		Card1.add(reserved);
		Card1.add(Resvl);
		Card1.add(cost);
		Card1.add(costvl);
		Card1.add(type);
		Card1.add(typevl);
		Card1.add(kilo);
		Card1.add(lbkm);
		Card1.add(tot);
		Card1.add(lbtotal);
		Card1.add(last);
		Card1.add(lblast);
		Card1.add(inc);
		Card1.add(lbin);
		//Khoi tao card thong tin xe thu 2
		final JPanel Card2 = new JPanel();
		Card2.setLayout(new GridLayout(12, 1));
		Card2.add(ID2);
		Card2.add(IDvls);
		Card2.add(Model2);
		Card2.add(Modelvls);
		Card2.add(Color2);
		Card2.add(Colorvls);
		Card2.add(Pas2);
		Card2.add(Pasvls);
		Card2.add(Br2);
		Card2.add(Brvls);
		Card2.add(reserved2);
		Card2.add(Resvls);
		Card2.add(cost2);
		Card2.add(costvls);
		Card2.add(type2);
		Card2.add(typevls);
		Card2.add(kilo2);
		Card2.add(lbkms);
		Card2.add(tot2);
		Card2.add(lbtotals);
		Card2.add(last2);
		Card2.add(lblasts);
		Card2.add(inc2);
		Card2.add(lbins);
		//Khoi tao card thue xe
		final JPanel Card3 = new JPanel(new BorderLayout());
		JPanel Gloc = new JPanel(new GridLayout(3, 0, -150, 0));
		JPanel End = new JPanel(new FlowLayout());
		End.add(Box.createRigidArea(new Dimension(18, 10)));
		JButton fini = new JButton("Finish");
		fini.setPreferredSize(new Dimension(80,27));
		Gloc.add(Choose);
		Gloc.add(Bigbox);
		Gloc.add(Choose2);
		Gloc.add(listday);
		End.add(fini);
		Card3.add(Gloc, BorderLayout.CENTER);
		Card3.add(End, BorderLayout.SOUTH);
		//Khoi tao card thong bao 
		final JPanel Card4 = new JPanel(new GridLayout(2,0));
		JPanel W = new JPanel();
		
		JLabel Warning = new JLabel("Please choose previous or next to rent another car.");
		W.add(Warning);
		Card4.add(Box.createRigidArea(new Dimension(40, 0)));
		Card4.add(W);
		//Add cac card vao Panel Center	, Middle, sau do Panel Flow add 2 Panel nay
		Center.add(Card1,"C1");
		Center.add(Card2,"C2");
		Center.add(Card3,"C3");
		Center.add(Card4, "C4");
		
		Middle.add(Mid, "C1");
		JPanel Flow = new JPanel();
		Flow.setLayout(new GridLayout(1, 1));
		Flow.add(Center);
		Flow.add(Middle);
		//Add border chinh vao container
		Border.add(Flow,BorderLayout.CENTER);
		Container con = frame.getContentPane();
		con.add(Border);
		
		check  = false;
		//Khoi tao chuc nang cua button previous
		previous.addActionListener(new ActionListener() {
		
		@Override
		
			public void actionPerformed(ActionEvent ae) {
				check  = true;
				Center.setVisible(true);
				Middle.setVisible(true);
				
				i--;
				if(i < 1000)
					i = 1019;
				y = i;
				
				CardLayout cl=(CardLayout)Center.getLayout();
				cl.show(Center, "C1");
				CardLayout m1=(CardLayout)Middle.getLayout();
			
				findPic(i);
				setPicture(finalpic,value);
				i = Integer.parseInt(id);
				m1.show(Middle, "C1");
				current = i;
			}
		});
		//Khoi tao chuc nang cua button next
		next.addActionListener(new ActionListener() {
		
		@Override
		
			public void actionPerformed(ActionEvent ae) {
				check  = true;
				Center.setVisible(true);
				Middle.setVisible(true);
				
				y++;
				if(y > 1019)
					y = 1000;
				i = y;
				
				CardLayout c2=(CardLayout)Center.getLayout();
				c2.show(Center, "C2");
				CardLayout m2=(CardLayout)Middle.getLayout();
				
				findPic(y);
				setPicture(finalpic,value);
				y = Integer.parseInt(id);
				m2.show(Middle, "C2");
				current = y;
			}
		});
		//Khoi tao chuc nang cua button rent now
		rent.addActionListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent ae) {
				if(check == false)
				{
					JOptionPane.showMessageDialog(frame, "You haven't choose any car yet, please try again.");
				}
				else if(check == true)
				{
					Center.setVisible(true);
					Middle.setVisible(true);
					//Renting.setVisible(true);
					CardLayout c3 = (CardLayout)Center.getLayout();
					c3.show(Center, "C3");
					CardLayout m2=(CardLayout)Middle.getLayout();
					findPic(current);
					m2.show(Middle, "C3");
				}
			}
			});
		//Khoi tao chuc nang cua button finish
		fini.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent ae) {
					if(weekls.getSelectedIndex() != -1)
					{	
						JOptionPane.showMessageDialog(frame, "Rent successfully");
						Center.setVisible(true);
						Middle.setVisible(true);
						CardLayout c4 = (CardLayout)Center.getLayout();
						c4.show(Center, "C4");
						chooseW();
						countDay = cwek;
						weekls.clearSelection();
					}
					else if(monthls.getSelectedIndex() != -1)
					{	
						JOptionPane.showMessageDialog(frame, "Rent successfully");
						Center.setVisible(true);
						Middle.setVisible(true);
						CardLayout c4 = (CardLayout)Center.getLayout();
						c4.show(Center, "C4");
						chooseM();
						countDay = cmon;
						monthls.clearSelection();
					}
					else
						JOptionPane.showMessageDialog(frame, "You can't rent");
					
				}
			});
	}
	
	//Lay gia tri tuan tu JList
		public void chooseW()
		{
			if(weekls.getSelectedIndex() == 0)
			{
				cwek = 7;
			}
			else if(weekls.getSelectedIndex() == 1)
			{
				cwek = 14;
			}
			else if(weekls.getSelectedIndex() == 2)
			{
				cwek = 21;
			}
			else if(weekls.getSelectedIndex() == 3)
			{
				cwek = 35;
			}
			else if(weekls.getSelectedIndex() == 4)
			{
				cwek = 49;
			}
			else if(weekls.getSelectedIndex() == 5)
			{
				cwek = 63;
			}
			else if(weekls.getSelectedIndex() == 6)
			{
				cwek = 77;
			}
			else
			{
				cwek = 0;
			}
		}
		//Lay gia tri thang tu Jlist
		public void chooseM()
		{
			if(monthls.getSelectedIndex() == 0)
			{
				cmon = 31;
			}
			else if(monthls.getSelectedIndex() == 1)
			{
				cmon = 28;
			}
			else if(monthls.getSelectedIndex() == 2)
			{
				cmon = 31;
			}
			else if(monthls.getSelectedIndex() == 3)
			{
				cmon = 30;
			}
			else if(monthls.getSelectedIndex() == 4)
			{
				cmon = 31;
			}
			else if(monthls.getSelectedIndex() == 5)
			{
				cmon = 30;
			}
			else if(monthls.getSelectedIndex() == 6)
			{
				cmon = 31;
			}
			else if(monthls.getSelectedIndex() == 7)
			{
				cmon = 31;
			}
			else if(monthls.getSelectedIndex() == 8)
			{
				cmon = 30;
			}
			else if(monthls.getSelectedIndex() == 9)
			{
				cmon = 31;
			}
			else if(monthls.getSelectedIndex() == 10)
			{
				cmon = 30;
			}
			else if(monthls.getSelectedIndex() == 11)
			{
				cmon = 31;
			}
			else 
			{
				cmon = 0;
			}
		}
		//Tim thong tin cua 1 doi tuong xe va gan vao cac bien khoi tao
		public void findPic(int i) {
			Car c = new Car();
			c = A.searchCarByID(String.valueOf(i));
			c.ViewRecord();
	//Gan vao cac bien
			id = c.getID();
			value = c.getImg();
			model = c.getModel();
			color = c.getColor();
			pas = String.valueOf(c.getPassenger());
			brand = c.getBrand();
			if(c.isReserved() == true)
				res = "Yes";
			else
				res = "No";
			cos = String.valueOf(c.getCost());
			type = c.getType(); 
			
			km = String.valueOf(c.getRecord().getKm_travel()); 
			total = String.valueOf(c.getRecord().getTotalRent());
			lastrent = c.getRecord().getLast_date_rent();
			income = String.valueOf(c.getRecord().getIncome_generate());
			//Dua gia tri cac bien tren vao cac label
			IDvl.setText(id);
			Modelvl.setText(model);
			Colorvl.setText(color);
			Pasvl.setText(pas);
			Brvl.setText(brand);
			Resvl.setText(res);
			costvl.setText(cos);
			typevl.setText(type);
			lbkm.setText(km);
			lbtotal.setText(total);
			lblast.setText(lastrent);		
			lbin.setText(income);
			
			IDvls.setText(id);
			Modelvls.setText(model);
			Colorvls.setText(color);
			Pasvls.setText(pas);
			Brvls.setText(brand);
			Resvls.setText(res);
			costvls.setText(cos);
			typevls.setText(type);
			lbkms.setText(km);
			lbtotals.setText(total);
			lblasts.setText(lastrent);		
			lbins.setText(income);
		}
		//Ham tao checkbox
		private JCheckBox createCheckBox(String name) {
	        JCheckBox checkBox = new JCheckBox(name);
	        return checkBox;
	    }
	    //Ham lay hinh anh
		public void setPicture(JLabel label ,String filename){
	       try {
	         BufferedImage image = ImageIO.read(new File(filename));
	         int x = label.getSize().width;
	         int y = label.getSize().height;
	         int ix = image.getWidth();
	         int iy = image.getHeight();

	         int dx = 0;
	         int dy = 0;

	         if(x/y > ix/iy){
	             dy = y;
	             dx = dy*ix/iy;
	         }
	         else{
	             dx = x;
	             dy = dx*iy/ix;
	         }

	         ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, BufferedImage.SCALE_SMOOTH));
	         label.setIcon(icon);
	     } catch (IOException ex) {
	         Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
	     }
	       }
 }

public class TestGiaoDien_RentCar{
	 public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new GiaoDien();
				}
				});
	 }
}