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
	int i,y;
	int current;
	String test_ID;
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
    JList<String> weekls, monthls; 
    int cmon,cwek;
    static int countDay;
    String weeklist[] = {"1 week", "2 weeks", "3 weeks", "5 weeks", "7 weeks", "9 weeks", "11 weeks"};
    String monthlist[] = {"1 month", "2 months", "3 months", "4 months", "5 months", "6 months", "7 months", "8 months", "9 months", "10 months", "11 months", "12 months"};
	int weekValue, monthValue;
	boolean check;
    VehicleList A = new VehicleList();
    Member user = new Member();
	
	JFrame frame = new JFrame("CGO - Rent truck");
	
	static int getValue() {
		return countDay;
	}
	
	String getV() {
		return value;
	}
	public RentTruck(){
		frame.setSize(450, 600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		user.CopyMem(LoginForm.getMem());
		addControl();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);	
		A.ReadAllTruck();
		i = 2999;
		y = 3000 + A.getTruckList().size();
	}
	
	public void addControl(){
		pic = new JLabel();
		pic.setPreferredSize(new Dimension(300, 200));
		pic.setSize(400, 600);
		setPicture(pic, "src/user/truck.jpg");
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
		getKey(previous, "< Previous", KeyEvent.VK_LEFT); 
		
		JButton next = new JButton("Next >");
		getKey(next, "Next >", KeyEvent.VK_RIGHT); 
		
		JButton rent = new JButton("Rent now!");
		getKey(rent, "Rent now!", KeyEvent.VK_ENTER); 
		
		previous.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel cont = new JLabel("                               ", JLabel.CENTER);
		cont.setSize(200, 400);
		
		JLabel logo = new JLabel("CGO");
		logo.setSize(55, 55);
		logo.setFont(new Font("Arial", Font.BOLD, 17));
		setPicture(logo, "src/user/logocar.png");

		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.addMouseListener(new MouseAdapter() {
    		public void mouseClicked (MouseEvent e) {
    			Image Thr = new Image();
    			Thr.start();
    			frame.dispose();
    		} 
    	});
		
		//////
		JLabel text = new JLabel("Making you most comfortable is our obligation ");
		JLabel intro = new JLabel("-- Use |< previous| or |next >| to start looking --");
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
		
		logo.setBounds(10, -25, 300, 100);
		text.setBounds(30, 7, 550, 100);
		intro.setBounds(80, 30, 500, 130);
		pic.setBounds(17, 150, 650, 300);
		
		frame.add(text);
		frame.add(intro);
		frame.add(logo);
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
		
		JButton fini = new JButton("Finish");
		fini.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fini.setPreferredSize(new Dimension(80,27));
		getKey(fini, "Finish", KeyEvent.VK_ENTER); 
		
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
		//Middle la panel chua hinh, center chua thong tin 
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
			
			i--;
			if(i < 3000)
				i = 3000 + A.getTruckList().size() -1;
			y = i;
			
			CardLayout cl=(CardLayout)Center.getLayout();
			cl.show(Center, "C1");
			CardLayout m1=(CardLayout)Middle.getLayout();
		
			findPic(i);
			setPicture(finalpic,value);
			test_ID = id.substring(1);
			i = Integer.parseInt(test_ID);
			m1.show(Middle, "C1");
			current = i;
			
			if(resr.equals("yes")) {
				rent.setEnabled(false);
				rent.setText("Not available now");
			}
			else {
				rent.setEnabled(true);
				rent.setText("Rent now!");
			}
		}
		});
		
		next.addActionListener(new ActionListener() {
		
		@Override
		
		public void actionPerformed(ActionEvent ae) {
			check = true;
			Center.setVisible(true);
			Middle.setVisible(true);
			
			y++;
			/*if(y > 3009)
				y = 3000;
			i = y;*/
			if(y > (3000 + A.getTruckList().size() -1)){
				y = 3000;
			}
			i = y;
			
			CardLayout c2=(CardLayout)Center.getLayout();
			c2.show(Center, "C2");
			CardLayout m2=(CardLayout)Middle.getLayout();
			findPic(i);
			setPicture(finalpic,value);
			
			test_ID = id.substring(1);
			i = Integer.parseInt(test_ID);
			m2.show(Middle, "C2");
			current = i;
			
			if(resr.equals("yes")) {
				rent.setEnabled(false);
				rent.setText("Not available now");
			}
			else {
				rent.setEnabled(true);
				rent.setText("Rent now!");
			}
			
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
					Truck t = A.searchTruckByID(IDvl.getText());
					if(weekls.getSelectedIndex() != -1)
					{	
						Center.setVisible(true);
						Middle.setVisible(true);
						CardLayout c4 = (CardLayout)Center.getLayout();
						c4.show(Center, "C4");
						chooseW();
						countDay = cwek;
						weekls.clearSelection();
						
						user.Rent(t, "Week");
						JOptionPane.showMessageDialog(frame, "Rent successfully");
						rent.setEnabled(false);
						rent.setText("Already rented!");
						A.ReadAllTruck();
					}
					else if(monthls.getSelectedIndex() != -1)
					{	
						Center.setVisible(true);
						Middle.setVisible(true);
						CardLayout c4 = (CardLayout)Center.getLayout();
						c4.show(Center, "C4");
						chooseM();
						countDay = cmon;
						monthls.clearSelection();
						System.out.println("Days : " + countDay);
						user.Rent(t, "Month");
						JOptionPane.showMessageDialog(frame, "Rent successfully");
						rent.setEnabled(false);
						rent.setText("Already rented!");
						A.ReadAllTruck();
					}
						else
							JOptionPane.showMessageDialog(frame, "You can't rent");
					}
			});
	}
	
	public static void getKey(final AbstractButton button, String actionName, int key) 
	{ 
		 button.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key, 0), actionName); 

		 button.getActionMap().put(actionName, new AbstractAction() 
		 { 
		 @Override 
		  public void actionPerformed(ActionEvent e) 
		  { 
		    button.doClick(); 
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

	public void findPic(int i) {
		Truck t = new Truck();
		String id_truck = "T" + Integer.toString(i);
		t = A.searchTruckByID(id_truck);
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