package user;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import user.Image;
import vehicle.Truck;
import vehicle.VehicleList;

class RentTruck extends JFrame{
	JLabel pic;
	int i = 3000;
	int current;
	JLabel finalpic;
	String value;
	String id;
	String model;
	String color;
	String pas;
	String brand;
	String cos;
	String max;
	String resr;
	String km, total, lastrent, income;
	JLabel lbkm, lbtotal, lblast, lbin;
	JLabel lbkms, lbtotals, lblasts, lbins;
	JLabel IDvl, Modelvl, Colorvl, Pasvl, Brvl, costvl, maxwvl, re;
	JLabel IDvls, Modelvls, Colorvls, Pasvls, Brvls, costvls, maxwvls, res;
	JScrollPane tab1, tab2;
	JCheckBox week, month;
    JLabel lbweek, lbmonth;
    JButton fini;
    JList<String> weekls, monthls; 
    String weeklist[] = {"1 week", "2 weeks", "3 weeks", "5 weeks", "7 weeks", "9 weeks", "11 weeks"};
    String monthlist[] = {"1 month", "2 months", "3 months", "4 months", "5 months", "6 months", "7 months", "8 months", "9 months", "10 months", "11 months", "12 months"};
	int weekValue, monthValue;
	boolean check;
    VehicleList A = new VehicleList();
	
	JFrame frame = new JFrame("CGO - Rent truck");
	String getV() {
		return value;
	}
	public RentTruck(){
		frame.setSize(450, 600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addControl();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);	
	}
	
	public void addControl(){
		pic = new JLabel();
		pic.setPreferredSize(new Dimension(300, 200));
		pic.setSize(400, 600);
		setPicture(pic, "src/user/bentley.jpg");
		JPanel Border=new JPanel();
		Border.setLayout(new BorderLayout());
		Border.setBackground(Color.WHITE);
	    
	    JPanel start = new JPanel();
	    start.setLayout(new FlowLayout());
	    
	    JPanel content = new JPanel();
		JPanel down = new JPanel();
		JPanel log = new JPanel();
		JPanel texts = new JPanel();
		
		JButton previous = new JButton("< Previous");
		JButton next = new JButton("Next >");
		JButton rent = new JButton("Rent now!");
		
		JLabel cont = new JLabel("                               ", JLabel.CENTER);
		cont.setSize(200, 400);
		
		JButton out = new JButton("Log out");
		
		JLabel logo = new JLabel("CGO");
		logo.setSize(55, 55);
		logo.setFont(new Font("Arial", Font.BOLD, 17));
		setPicture(logo, "src/user/logocar.png");
		//////
		JLabel text = new JLabel("Making you most comfortable is our obligation ");
		JLabel intro = new JLabel("-- Click the |start from| button to start looking --");
		text.setSize(200,200);
		text.setFont(new Font("Arial", Font.BOLD, 17));
		text.setForeground(Color.DARK_GRAY);
		intro.setSize(200,200);
		intro.setFont(new Font("Arial", Font.BOLD, 13));
		intro.setForeground(Color.DARK_GRAY);
		
		JLabel box = new JLabel();
		box.setSize(200,200);
		box.setPreferredSize(new Dimension(200, 200));
		box.setBorder(LineBorder.createBlackLineBorder());
		
		down.add(previous);
		down.add(rent);
		down.add(next);
		log.add(logo,BorderLayout.EAST);
		texts.add(text,BorderLayout.SOUTH);
		content.add(cont);
		
		Border.add(start,BorderLayout.NORTH);
		start.add(log);
		start.add(content);
		
		Border.add(down,BorderLayout.SOUTH);
		
		out.setBounds(357, 2, 77, 30);
		logo.setBounds(10, -25, 300, 100);
		text.setBounds(30, 7, 550, 100);
		intro.setBounds(80, 30, 500, 130);
		pic.setBounds(17, 150, 650, 300);
		
		frame.add(text);
		frame.add(intro);
		frame.add(logo);
		frame.add(out);
		frame.add(pic);
	
		final JPanel Center = new JPanel();
		final JPanel Middle = new JPanel();
		
		Center.setLayout(new CardLayout());
		Center.setVisible(false);
		
		Middle.setLayout(new CardLayout());
		Middle.setVisible(false);
		
		
		final JPanel Mid = new JPanel();
	
		finalpic = new JLabel();
		finalpic.setSize(400,900);
		value ="src/user/logocar.png";
		setPicture(finalpic,value);
		Mid.add(finalpic);
		Mid.setBackground(Color.DARK_GRAY.darker());
		
		JLabel ID = new JLabel("     Truck ID : ");
	    ID.setFont(new Font("Arial", Font.BOLD, 15));
	    IDvl = new JLabel("");
	    
		JLabel Model = new JLabel("     Truck model : ");
		Modelvl = new JLabel("");
		Model.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Color = new JLabel("     Color");
		Colorvl = new JLabel("");
		Color.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel Pas = new JLabel("     Passenger : ");
		Pasvl = new JLabel("");
		Pas.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Br = new JLabel("     Brand : ");
		Brvl = new JLabel("");
		Br.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel cost = new JLabel("     Cost");
		costvl = new JLabel("");
		cost.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel maxw = new JLabel("     Maximum weight : ");
		maxwvl = new JLabel("");
		maxw.setFont(new Font("Arial", Font.BOLD, 15));
		// lbkm, lbtotal, lblast, lbin;
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
		
		JLabel reserved = new JLabel("     Reserved : ");
		re = new JLabel("");
		reserved.setFont(new Font("Arial", Font.BOLD, 15));
		
		////
		JLabel ID2 = new JLabel("     Truck ID : ");
	    ID2.setFont(new Font("Arial", Font.BOLD, 15));
	    IDvls = new JLabel("");
	    
		JLabel Model2 = new JLabel("     Truck model : ");
		Modelvls = new JLabel("");
		Model2.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Color2 = new JLabel("     Color : ");
		Colorvls = new JLabel("");
		Color2.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel Pas2 = new JLabel("     Passenger : ");
		Pasvls = new JLabel("");
		Pas2.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Br2 = new JLabel("     Brand : ");
		Brvls = new JLabel("");
		Br2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel cost2 = new JLabel("     Cost : ");
		costvls = new JLabel("");
		cost2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel maxw2 = new JLabel("     Maximum weight : ");
		maxwvls = new JLabel("");
		maxw2.setFont(new Font("Arial", Font.BOLD, 15));
		
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
		
		JLabel reserveds = new JLabel("     Reserved : ");
		res = new JLabel("");
		reserveds.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel Choose = new JLabel("     Choose type : ");
		Choose.setFont(new Font("Arial", Font.BOLD, 15));
		
		JPanel Bigbox = new JPanel(new GridLayout(1, 0));
		JPanel panelCheckBox = new JPanel(new GridLayout(1, 0));
		
	    panelCheckBox.add(week = createCheckBox("WEEK"));
	    panelCheckBox.add(month = createCheckBox("MONTH"));
	
	    Bigbox.add(panelCheckBox, BorderLayout.WEST);
	    
	    JPanel listday = new JPanel(new GridLayout(1, 0));
	    weekls = new JList<String>(weeklist);
		weekls.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tab1 = new JScrollPane(weekls);
		tab1.setPreferredSize(new Dimension(100, 50));
		tab1.setVisible(false);
		//////////////////////////////////////
		monthls = new JList<String>(monthlist);
		monthls.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tab2 = new JScrollPane(monthls);
		tab2.setPreferredSize(new Dimension(150, 50));
		tab2.setVisible(false);
		
		ButtonGroup gr = new ButtonGroup();
		gr.add(week);
		gr.add(month);
		
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
	    //int wek = countlist.getSelectedIndex();
	    //weeklist[wek];
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
		Card1.add(cost);
		Card1.add(costvl);
		Card1.add(maxw);
		Card1.add(maxwvl);
		Card1.add(kilo);
		Card1.add(lbkm);
		Card1.add(tot);
		Card1.add(lbtotal);
		Card1.add(last);
		Card1.add(lblast);
		Card1.add(inc);
		Card1.add(lbin);
		Card1.add(reserved);
		Card1.add(re);

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
		Card2.add(cost2);
		Card2.add(costvls);
		Card2.add(maxw2);
		Card2.add(maxwvls);
		Card2.add(kilo2);
		Card2.add(lbkms);
		Card2.add(tot2);
		Card2.add(lbtotals);
		Card2.add(last2);
		Card2.add(lblasts);
		Card2.add(inc2);
		Card2.add(lbins);
		Card2.add(reserveds);
		Card2.add(res);
		
		final JPanel Card3 = new JPanel(new BorderLayout());
		JPanel Gloc = new JPanel(new GridLayout(2, 0, -150, 0));
		JPanel End = new JPanel(new FlowLayout());
		End.add(Box.createRigidArea(new Dimension(18, 10)));
		fini = new JButton("Finish");
		fini.setPreferredSize(new Dimension(80,27));
		Gloc.add(Choose);
		Gloc.add(Bigbox);
		Gloc.add(Choose2);
		Gloc.add(listday);
		End.add(fini);
		Card3.add(Gloc, BorderLayout.CENTER);
		Card3.add(End, BorderLayout.SOUTH);
		
		final JPanel Card4 = new JPanel(new GridLayout(2,0));
		JPanel W = new JPanel();
		
		JLabel Warning = new JLabel("Please choose previous or next to rent another car.");
		W.add(Warning);
		Card4.add(Box.createRigidArea(new Dimension(40, 0)));
		Card4.add(W);
		
		Center.add(Card1,"C1");
		Center.add(Card2,"C2");
		Center.add(Card3,"C3");
		Center.add(Card4,"C4");
		
		Middle.add(Mid, "C1");
		JPanel Flow = new JPanel();
		Flow.setLayout(new GridLayout(2, 1));
		Flow.add(Middle);
		Flow.add(Center);

		Border.add(Flow,BorderLayout.CENTER);
		Container con = frame.getContentPane();
		con.add(Border);
		
		check = false;
		
		previous.addActionListener(new ActionListener() {
		
		@Override
		
		public void actionPerformed(ActionEvent ae) {
			check = true;
			Center.setVisible(true);
			Middle.setVisible(true);
			CardLayout cl=(CardLayout)Center.getLayout();
			cl.show(Center, "C1");
			CardLayout m1=(CardLayout)Middle.getLayout();
		
			findPic(i);
			setPicture(finalpic,value);
			i = Integer.parseInt(id);
			m1.show(Middle, "C1");
			current = i;
			
			if(i == 3000)
			{
				i = 3010;
			}
			i = i - 1;
		}
		});
		
		next.addActionListener(new ActionListener() {
		
		@Override
		
		public void actionPerformed(ActionEvent ae) {
			check = true;
			Center.setVisible(true);
			Middle.setVisible(true);
			CardLayout c2=(CardLayout)Center.getLayout();
			c2.show(Center, "C2");
			CardLayout m2=(CardLayout)Middle.getLayout();
			findPic(i);
			setPicture(finalpic,value);
			i = Integer.parseInt(id);
			m2.show(Middle, "C2");
			current = i;
			
			if(i == 3009)
			{
				i = 2999;

			}
			i = i + 1;
		}
		});
		
		rent.addActionListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent ae) {
				if(check == false)
				{
					JOptionPane.showMessageDialog(frame, "You haven't choose any truck yet, please try again.");
				}
				else if(check == true)
				{
					Center.setVisible(true);
					Middle.setVisible(true);
					CardLayout c3 = (CardLayout)Center.getLayout();
					c3.show(Center, "C3");
					CardLayout m2=(CardLayout)Middle.getLayout();
					findPic(current);
					m2.show(Middle, "C3");
				}
			}
			});
		
		fini.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent ae) {
					if(weekls.getSelectedIndex() != -1 || monthls.getSelectedIndex() != -1)
					{
						JOptionPane.showMessageDialog(frame, "Rent successfully");
						Center.setVisible(true);
						Middle.setVisible(true);
						CardLayout c4 = (CardLayout)Center.getLayout();
						c4.show(Center, "C4");
					}
					else
						JOptionPane.showMessageDialog(frame, "You can't rent");
				}
			});
	}

	public void findPic(int i) {
		A.ReadAllTruck();
		Truck t = new Truck();
		t = A.searchTruckByID(String.valueOf(i));
		t.ViewRecord();

		id = t.getID();
		value = t.getImg();
		model = t.getModel();
		color = t.getColor();
		pas = String.valueOf(t.getPassenger());
		brand = t.getBrand();
		cos = String.valueOf(t.getCost());
		max = String.valueOf(t.getWeight());
		if(t.isReserved() == true)
			resr = "yes";
		else if(t.isReserved() == false)
			resr = "no";
		
		km = String.valueOf(t.getRecord().getKm_travel()); 
		total = String.valueOf(t.getRecord().getTotalRent());
		lastrent = t.getRecord().getLast_date_rent();
		income = String.valueOf(t.getRecord().getIncome_generate());
		
		IDvl.setText(id);
		Modelvl.setText(model);
		Colorvl.setText(color);
		Pasvl.setText(pas);
		Brvl.setText(brand);
		costvl.setText(cos);
		maxwvl.setText(max);
		lbkm.setText(km);
		lbtotal.setText(total);
		lblast.setText(lastrent);		
		lbin.setText(income);
		re.setText(resr);
		
		IDvls.setText(id);
		Modelvls.setText(model);
		Colorvls.setText(color);
		Pasvls.setText(pas);
		Brvls.setText(brand);
		costvls.setText(cos);
		maxwvls.setText(max);
		lbkms.setText(km);
		lbtotals.setText(total);
		lblasts.setText(lastrent);		
		lbins.setText(income);
		res.setText(resr);
	}
	
	private JCheckBox createCheckBox(String name) {
        JCheckBox checkBox = new JCheckBox(name);
        return checkBox;
    }
    
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

public class RentTruck_Page{
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RentTruck();
			}
			});
	}
}