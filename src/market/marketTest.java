package market;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class marketTest {

	private JFrame frame;
	private JTextField textQuantity;
	private JPanel panelCustomer;
	private JPanel panelCashier;
	private JLabel lblProduct;
	private JTextField textProductName;
	private JTextField textProductPrice;
	private JTextField textProductQuantity;
	private JTextField textCashierName;
	private JTextField textCashierSurName;
	private JTextField textCashierId;
	private JPanel panelSystemManager;
	private static JTextArea textListProduct;
	private JPanel panelAddCashier;
	private JPanel panelProduct;
	private JButton btnAdd;
	private JButton btnQuantityUpdate;
	private JButton btnDelete;
	private JButton btnPriceUpdate;
	private static JLabel lblError;
	private static JComboBox comboBoxProducts;
	private JTextArea textAllList;
	//private  rdbtnDeleteCashier;
	
	private static double totalAmount;
	
	
	private JLabel labelMiktarUyari;
	private JLabel lblTotalAmount;
	private JButton btnPayment;
	private JLabel lblGiriIinIsminizi;
	private JLabel lblIsimGiriniz;
	private JLabel lblIsimGiriniz_1;
	private JLabel lblifreGiriniz;
	private JLabel lblifreGiriniz_1;
	private JTextField managerName;
	private JButton btnGiris;
	private JPanel managerPassPanel;
	private JPanel cashierPassPanel;
	private JTextField managerPassword;
	private JTextArea textListCashier;
	
	private JTextField cashierPassword;
	private JTextField cashierName;
	
	static Customer cus=new Customer("","",111);;
	static Cashier cas=new Cashier("","",1230,123);
	static shopList shop=new shopList();
	static Payment pay=new Payment(cus.getName(),cus.getSurName(),cus.getCustomerId(),"kredi");;
	static ProductList stok=new ProductList();
	static Products pro=new Products();
	static SystemManager sym=new SystemManager("admin","BBB",123,123);
	static CashierList casList=new CashierList();
	private JLabel lblHataliSveyaI;
	private JLabel lblHataliSveyaI2;;
	private JLabel lblCashierPass;
	private JTextField textCashierPass;
	private JLabel lblCashierWarning;
	private JButton btnAddCashier;
	private JButton btnUpdatePassword;
	private JButton btnDeleteCashier;
	private JTextField textCustomerName;
	private JTextField textSurName;
	private JLabel lblAndSurnameFor;
	private JLabel lblTheInvoice;
	private JComboBox comboBoxPayKin;
	private JTextArea textUrunler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marketTest window = new marketTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public marketTest() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		stok.addProducts(new Products("Ekmek",1.25,5));
		stok.addProducts(new Products("Süt",2.65,10));
		stok.addProducts(new Products("Su",5,15));
		stok.addProducts(new Products("Yað",10,15));
		stok.addProducts(new Products("Þeker",5,15));
		stok.addProducts(new Products("Un",3,15));
		
		frame = new JFrame();
		frame.setBounds(100, 100, 676, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnMteri = new JButton("Customer");
		btnMteri.setBackground(Color.RED);
		btnMteri.setForeground(Color.BLACK);
		btnMteri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panelCustomer.setVisible(true);
				cashierPassPanel.setVisible(false);
				managerPassPanel.setVisible(false);
				panelCashier.setVisible(false);
				panelSystemManager.setVisible(false);
				textUrunler.setText("");
				textListProduct.setVisible(false);
				textListProduct.setText("");
				textAllList.setText("");
				textAllList.setVisible(false);
			}
		});
		btnMteri.setBounds(51, 11, 102, 23);
		frame.getContentPane().add(btnMteri);
		
		JButton btnKasiyer = new JButton("Cashier");
		btnKasiyer.setBackground(Color.RED);
		btnKasiyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCashier.setVisible(false);
				cashierPassPanel.setVisible(true);
				managerPassPanel.setVisible(false);
				panelCustomer.setVisible(false);
				panelSystemManager.setVisible(false);
				textListProduct.setVisible(false);
				textAllList.setVisible(false);
			}
		});
		btnKasiyer.setBounds(201, 11, 89, 23);
		frame.getContentPane().add(btnKasiyer);
		
		JButton btnYnetici = new JButton("Manager");
		btnYnetici.setBackground(Color.RED);
		btnYnetici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashierPassPanel.setVisible(false);
				textListProduct.setVisible(false);
				managerPassPanel.setVisible(true);
				panelCustomer.setVisible(false);
				panelSystemManager.setVisible(false);
				panelCashier.setVisible(false);
				textAllList.setVisible(false);
				
			}
		});
		btnYnetici.setBounds(376, 11, 89, 23);
		frame.getContentPane().add(btnYnetici);
		
		//MANAGER KISMI
		
		panelSystemManager = new JPanel();
		panelSystemManager.setBounds(10, 50, 640, 403);
		frame.getContentPane().add(panelSystemManager);
		panelSystemManager.setLayout(null);
		panelSystemManager.setVisible(false);
		
		JRadioButton rdbtnAddProduct = new JRadioButton("Add Product");
		rdbtnAddProduct.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				panelProduct.setVisible(true);
				textListProduct.setVisible(true);
				textProductName.setEnabled(true);
				textProductPrice.setEnabled(true);
				textProductQuantity.setEnabled(true);
				btnAdd.setEnabled(true);
				panelAddCashier.setVisible(false);
				btnPriceUpdate.setEnabled(false);
				btnQuantityUpdate.setEnabled(false);
				btnDelete.setEnabled(false);
				textListCashier.setVisible(false);
			}
		});
		rdbtnAddProduct.setBounds(6, 26, 109, 23);
		panelSystemManager.add(rdbtnAddProduct);
		
		JRadioButton rdbtnAddCashier = new JRadioButton("Add Cashier");
		rdbtnAddCashier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelProduct.setVisible(false);
				panelAddCashier.setVisible(true);
				textCashierPass.setEnabled(true);
				textCashierId.setEnabled(true);
				btnAddCashier.setEnabled(true);
				btnUpdatePassword.setEnabled(false);
				btnDeleteCashier.setEnabled(false);
				textListCashier.setVisible(true);
				textListProduct.setVisible(false);
				
			}
		});
		rdbtnAddCashier.setBounds(6, 208, 109, 23);
		panelSystemManager.add(rdbtnAddCashier);
		
		JRadioButton rdbtnUpdatePrice = new JRadioButton("Update Price");
		rdbtnUpdatePrice.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				panelProduct.setVisible(true);
				panelAddCashier.setVisible(false);
				textListProduct.setVisible(true);
				btnPriceUpdate.setEnabled(true);
				textProductPrice.setEnabled(true);
				btnQuantityUpdate.setEnabled(false);
				textProductQuantity.setEnabled(false);
				panelAddCashier.setVisible(false);
				btnAdd.setEnabled(false);
				btnDelete.setEnabled(false);
				textListCashier.setVisible(false);
				
			}
		});
		rdbtnUpdatePrice.setBounds(6, 108, 109, 23);
		panelSystemManager.add(rdbtnUpdatePrice);
		
		JRadioButton rdbtnUpdateQuantity = new JRadioButton("Update Quantity");
		rdbtnUpdateQuantity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				panelProduct.setVisible(true);
				panelAddCashier.setVisible(false);
				textListProduct.setVisible(true);
				btnPriceUpdate.setEnabled(false);
				textProductQuantity.setEnabled(true);
				btnQuantityUpdate.setEnabled(true);
				textProductPrice.setEnabled(false);
				panelAddCashier.setVisible(false);
				btnAdd.setEnabled(false);
				btnDelete.setEnabled(false);
				textListCashier.setVisible(false);
			}
		});
		rdbtnUpdateQuantity.setBounds(6, 68, 109, 23);
		panelSystemManager.add(rdbtnUpdateQuantity);
		
		panelProduct = new JPanel();
		panelProduct.setBounds(186, 11, 444, 170);
		panelSystemManager.add(panelProduct);
		panelProduct.setLayout(null);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setBounds(10, 11, 120, 14);
		panelProduct.add(lblProductName);
		
		textProductName = new JTextField();
		textProductName.setBounds(140, 8, 86, 20);
		panelProduct.add(textProductName);
		textProductName.setColumns(10);
		
		JLabel lblProductPrice = new JLabel("Product Price:");
		lblProductPrice.setBounds(10, 52, 120, 14);
		panelProduct.add(lblProductPrice);
		
		textProductPrice = new JTextField();
		textProductPrice.setBounds(140, 49, 86, 20);
		panelProduct.add(textProductPrice);
		textProductPrice.setColumns(10);
		
		JLabel lblProductQuantity = new JLabel("Product Quantity");
		lblProductQuantity.setBounds(10, 87, 120, 14);
		panelProduct.add(lblProductQuantity);
		
		textProductQuantity = new JTextField();
		textProductQuantity.setBounds(140, 84, 86, 20);
		panelProduct.add(textProductQuantity);
		textProductQuantity.setColumns(10);
		
		btnAdd = new JButton(" Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productName=textProductName.getText();
				double productPrice=Double.parseDouble(textProductPrice.getText()); 
				addProoduct(textProductName.getText(),Double.parseDouble(textProductPrice.getText()),Integer.parseInt(textProductQuantity.getText()));
				comboUpdate();
				textProductName.setText("");
				textProductPrice.setText("");
				textProductQuantity.setText("");
				textListProduct.setText(stok.displayAllProducts());
			}
		});
		btnAdd.setBounds(279, 7, 113, 23);
		btnAdd.setEnabled(false);
		panelProduct.add(btnAdd);
		
		btnQuantityUpdate = new JButton("Update Quantity");
		btnQuantityUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				textListProduct.setVisible(true);
					String productName=textProductName.getText();
					int productQuantity=Integer.parseInt(textProductQuantity.getText());
					for(int i=0;i<stok.getProductsList().size();i++) {
						if(stok.getProductsList().get(i).getName().equalsIgnoreCase(productName)) {
							stok.getProductsList().get(i).setQuantity(productQuantity);
						}
					}
					
				
		
				textProductQuantity.setText("");
				
				textListProduct.setText(stok.displayAllProducts());
				}
		});
		btnQuantityUpdate.setBounds(279, 48, 113, 23);
		btnQuantityUpdate.setEnabled(false);
		panelProduct.add(btnQuantityUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				String productName=textProductName.getText();
				for(int i=0;i<stok.getProductsList().size();i++) {
					if(stok.getProductsList().get(i).getName().equalsIgnoreCase(productName)) {
						stok.productDelete(stok.getProductsList().get(i));
						lblError.setText("Ürün silindi..");
					}
				}textListProduct.setText(stok.displayAllProducts());
				deleteListProduct(productName);}
		});
		btnDelete.setBounds(279, 119, 113, 23);
		btnDelete.setEnabled(false);
		panelProduct.add(btnDelete);
		
		btnPriceUpdate = new JButton("Update Price");
		btnPriceUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productName=textProductName.getText();
				double productPrice=Double.parseDouble(textProductPrice.getText());
				for(int i=0;i<stok.getProductsList().size();i++) {
					if(stok.getProductsList().get(i).getName().equalsIgnoreCase(productName)) {
						stok.getProductsList().get(i).setPrice(productPrice);
					}
				}
				textProductPrice.setText("");
				textListProduct.setText(stok.displayAllProducts());
			}
		});
		btnPriceUpdate.setBounds(279, 83, 115, 23);
		btnPriceUpdate.setEnabled(false);
		panelProduct.add(btnPriceUpdate);
		
		lblError = new JLabel("");
		lblError.setBounds(10, 112, 192, 46);
		panelProduct.add(lblError);
		
		textListCashier = new JTextArea();
		textListCashier.setBounds(186,11,374,158);
		panelSystemManager.add(textListCashier);
		
		panelAddCashier = new JPanel();
		panelAddCashier.setBounds(186, 195, 444, 170);
		panelSystemManager.add(panelAddCashier);
		panelAddCashier.setLayout(null);
		
		JLabel lblCashierName = new JLabel("Cashier Name:");
		lblCashierName.setBounds(10, 11, 109, 14);
		panelAddCashier.add(lblCashierName);
		
		textCashierName = new JTextField();
		textCashierName.setBounds(148, 8, 86, 20);
		panelAddCashier.add(textCashierName);
		textCashierName.setColumns(10);
		
		JLabel lblCashierSurname = new JLabel("Cashier Surname:");
		lblCashierSurname.setBounds(10, 47, 109, 14);
		panelAddCashier.add(lblCashierSurname);
		
		textCashierSurName = new JTextField();
		textCashierSurName.setBounds(148, 44, 86, 20);
		panelAddCashier.add(textCashierSurName);
		textCashierSurName.setColumns(10);
		
		JLabel lblCashierId = new JLabel("Cashier ID:");
		lblCashierId.setBounds(10, 78, 95, 14);
		panelAddCashier.add(lblCashierId);
		
		textCashierId = new JTextField();
		textCashierId.setBounds(148, 75, 86, 20);
		panelAddCashier.add(textCashierId);
		textCashierId.setColumns(10);
		
		lblCashierPass = new JLabel("Cashier Password:");
		lblCashierPass.setBounds(10, 105, 109, 14);
		panelAddCashier.add(lblCashierPass);
		
		textCashierPass = new JTextField();
		textCashierPass.setBounds(148, 106, 86, 20);
		panelAddCashier.add(textCashierPass);
		textCashierPass.setColumns(10);
		
		btnAddCashier = new JButton("Add Cashier");
		btnAddCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textCashierName.getText();
				String surName=textCashierSurName.getText();
				String id=textCashierId.getText();
				String pass=textCashierPass.getText();
				addCashier(name,surName,Integer.parseInt(id),Integer.parseInt(pass));
				
				textCashierName.setText("");
				textCashierSurName.setText("");
				textCashierId.setText("");
				textCashierPass.setText("");
				textListCashier.setVisible(true);
				textListCashier.setText(casList.displayAllCashier());
				

			}
		});
		btnAddCashier.setBounds(284, 7, 117, 23);
		btnAddCashier.setEnabled(false);
		panelAddCashier.add(btnAddCashier);
		
		btnUpdatePassword = new JButton("Update Password");
		btnUpdatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textCashierName.getText();
				String surName=textCashierSurName.getText();
				String pass=textCashierPass.getText();
				
				for(int i=0;i<casList.getCasList().size();i++) {
					if(casList.getCasList().get(i).getName().equalsIgnoreCase(name)&&casList.getCasList().get(i).getSurName().equalsIgnoreCase(surName)) {
						casList.getCasList().get(i).setPassword(Integer.parseInt(pass));
					}
				}
				textCashierName.setText("");
				textCashierSurName.setText("");
				textCashierId.setText("");
				textCashierPass.setText("");
				textListCashier.setVisible(true);
				textListCashier.setText(casList.displayAllCashier());
			}
		});
		btnUpdatePassword.setBounds(284, 43, 117, 23);
		btnUpdatePassword.setEnabled(false);
		panelAddCashier.add(btnUpdatePassword);
		
		btnDeleteCashier = new JButton("Delete Cashier");
		btnDeleteCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblCashierWarning.setText("");
				String name=textCashierName.getText();
				String surName=textCashierSurName.getText();
				for(int i=0;i<casList.getCasList().size();i++) {
					if(casList.getCasList().get(i).getName().equalsIgnoreCase(name)&&casList.getCasList().get(i).getSurName().equalsIgnoreCase(surName)) {
						casList.getCasList().remove(i);
					}
				}
				textCashierName.setText("");
				textCashierSurName.setText("");
				textCashierId.setText("");
				textCashierPass.setText("");
				textListCashier.setVisible(true);
				textListCashier.setText(casList.displayAllCashier());
			}
		});
		btnDeleteCashier.setBounds(284, 74, 117, 23);
		btnDeleteCashier.setEnabled(false);
		panelAddCashier.add(btnDeleteCashier);
		
		lblCashierWarning = new JLabel("");
		lblCashierWarning.setBounds(219, 105, 46, 14);
		panelAddCashier.add(lblCashierWarning);
		
		JRadioButton rdbtnCashierUpdatePassword = new JRadioButton("Cashier Update password");
		rdbtnCashierUpdatePassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAddCashier.setEnabled(false);
				btnDeleteCashier.setEnabled(false);
				btnUpdatePassword.setEnabled(true);
				textCashierName.setEnabled(true);
				textCashierSurName.setEnabled(true);
				textCashierPass.setEnabled(true);
				textCashierId.setEnabled(false);
				textListCashier.setVisible(true);
				textListProduct.setVisible(false);
				
			}
		});
		rdbtnCashierUpdatePassword.setBounds(6, 243, 174, 23);
		panelSystemManager.add(rdbtnCashierUpdatePassword);
		
		JRadioButton rdbtnListProduct = new JRadioButton("List Product");
		rdbtnListProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				textListProduct.setVisible(false);
				panelSystemManager.setVisible(false);
			
				textAllList.setVisible(true);
				textAllList.setText(stok.displayAllProducts());
				
			}
		});
		rdbtnListProduct.setBounds(6, 326, 109, 23);
		panelSystemManager.add(rdbtnListProduct);
		
		JRadioButton rdbtnDeleteProduct = new JRadioButton("Delete Product");
		rdbtnDeleteProduct.setForeground(Color.BLACK);
		rdbtnDeleteProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				panelProduct.setVisible(true);
				textListProduct.setVisible(true);
				btnPriceUpdate.setEnabled(false);
				textProductQuantity.setEnabled(false);
				btnQuantityUpdate.setEnabled(false);
				textProductPrice.setEnabled(false);
				panelAddCashier.setVisible(false);
				btnAdd.setEnabled(false);
				btnDelete.setEnabled(true);
				textListCashier.setVisible(false);
			}
		});
		
		rdbtnDeleteProduct.setBounds(6, 146, 109, 23);
		panelSystemManager.add(rdbtnDeleteProduct);
		
		JRadioButton rdbtnDeleteCashier = new JRadioButton("Delete Cashier");
		rdbtnDeleteCashier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				panelProduct.setVisible(false);
				textCashierName.setEnabled(true);
				textCashierId.setEnabled(false);
				textCashierPass.setEnabled(false);
				textCashierSurName.setEnabled(true);
				btnAddCashier.setEnabled(false);
				btnUpdatePassword.setEnabled(false);
				btnDeleteCashier.setEnabled(true);
				textListCashier.setVisible(true);
				
				
			}
		});
		rdbtnDeleteCashier.setBounds(6, 274, 109, 23);
		panelSystemManager.add(rdbtnDeleteCashier);
		

		JRadioButton rdbtnListCashier = new JRadioButton("List Cashier");
		rdbtnListCashier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textListProduct.setVisible(false);
				panelSystemManager.setVisible(false);
				textAllList.setVisible(true);
				textAllList.setText(casList.displayAllCashier());
				
			}
		});
		rdbtnListCashier.setBounds(6, 300, 109, 23);
		panelSystemManager.add(rdbtnListCashier);
		
		ButtonGroup btnGroup=new ButtonGroup();
		btnGroup.add(rdbtnDeleteProduct);
		btnGroup.add(rdbtnCashierUpdatePassword);
		btnGroup.add(rdbtnUpdateQuantity);
		btnGroup.add(rdbtnUpdatePrice);
		btnGroup.add(rdbtnAddCashier);
		btnGroup.add(rdbtnAddProduct);
		btnGroup.add(rdbtnListProduct);
		btnGroup.add(rdbtnDeleteCashier);
		btnGroup.add(rdbtnListCashier);
		
		panelCustomer = new JPanel();
		panelCustomer.setBounds(10,44,618,409);
		frame.getContentPane().add(panelCustomer);
		panelCustomer.setLayout(null);
		panelCustomer.setVisible(false);
		
		lblProduct = new JLabel("Products");
		lblProduct.setBounds(0, 28, 56, 14);
		panelCustomer.add(lblProduct);
		
		comboBoxProducts = new JComboBox();
		comboBoxProducts.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboNew();
		comboBoxProducts.setBounds(65, 25, 86, 20);
		panelCustomer.add(comboBoxProducts);
		
		JLabel lblMiktar = new JLabel("Quantity");
		lblMiktar.setBounds(0, 66, 56, 14);
		panelCustomer.add(lblMiktar);
		
		textQuantity = new JTextField();
		textQuantity.setBounds(65, 63, 86, 20);
		panelCustomer.add(textQuantity);
		textQuantity.setColumns(10);
		
		textUrunler = new JTextArea();
		textUrunler.setBounds(204, 28, 372, 261);
		panelCustomer.add(textUrunler);
		
		JButton btnAddCart = new JButton("Add Cart");
		btnAddCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				labelMiktarUyari.setText("");
				String select=(String) comboBoxProducts.getSelectedItem();
				int quantity=Integer.parseInt(textQuantity.getText());
				for(int i=0;i<stok.getProductsList().size();i++) {
					if(stok.getProductsList().get(i).getName().equalsIgnoreCase(select)) {
						if(stok.getProductsList().get(i).getQuantity()>=quantity) {
							shop.addShopProduct(new Products(select,stok.getProductsList().get(i).getPrice(),quantity));
							int guncelStok=stok.getProductsList().get(i).getQuantity();
							guncelStok=guncelStok-quantity;
							stok.productStockUpdate(select, guncelStok);
						}
						else if(stok.getProductsList().get(i).getQuantity()<quantity) {
							labelMiktarUyari.setText("Stoktaki üründen fazla ürün girdiniz.En fazla:"+stok.getProductsList().get(i).getQuantity()+" kadar girebilirsiniz.");
						}
					}
				}
				textQuantity.setText("");
				textUrunler.setText(shop.displayShopList());
				
			}
		});
		btnAddCart.setBounds(62, 94, 89, 23);
		panelCustomer.add(btnAddCart);
		
		JButton btnTotalAmount = new JButton("Total Amount for click");
		btnTotalAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				totalAmount=cas.totalAmount(shop.getShopList());
				String total2=Double.toString(totalAmount);
				
				lblTotalAmount.setText(total2);
			}
		});
		btnTotalAmount.setBounds(200, 294, 163, 23);
		panelCustomer.add(btnTotalAmount);
		
		labelMiktarUyari = new JLabel("");
		labelMiktarUyari.setBounds(164, 11, 376, 14);
		panelCustomer.add(labelMiktarUyari);
		
		lblTotalAmount = new JLabel("");
		lblTotalAmount.setBounds(446, 294, 46, 20);
		panelCustomer.add(lblTotalAmount);
		
		btnPayment = new JButton("Payment ");
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cus=new Customer(textCustomerName.getText(),textSurName.getText(),111);
				String kind=(String) comboBoxPayKin.getSelectedItem();
				pay=new Payment(cus.getName(),cus.getSurName(),cus.getCustomerId(),kind);
				panelCustomer.setVisible(false);
				textAllList.setVisible(true);
				textAllList.setText(pay.invoiceWrite(totalAmount));
				
				textCustomerName.setText("");
				textSurName.setText("");
				
			}
		});
		btnPayment.setBounds(330, 322, 89, 23);
		panelCustomer.add(btnPayment);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(61, 179, 100, 14);
		panelCustomer.add(lblCustomerName);
		
		textCustomerName = new JTextField();
		textCustomerName.setBounds(61, 204, 86, 20);
		panelCustomer.add(textCustomerName);
		textCustomerName.setColumns(10);
		
		JLabel lblCustomerSurname = new JLabel("Customer Surname");
		lblCustomerSurname.setBounds(55, 235, 118, 20);
		panelCustomer.add(lblCustomerSurname);
		
		textSurName = new JTextField();
		textSurName.setBounds(62, 266, 86, 23);
		panelCustomer.add(textSurName);
		textSurName.setColumns(10);
		
		JLabel lblEnterTheName = new JLabel("Enter the name\r\n");
		lblEnterTheName.setForeground(Color.RED);
		lblEnterTheName.setBounds(65, 128, 86, 14);
		panelCustomer.add(lblEnterTheName);
		
		lblAndSurnameFor = new JLabel("and surname for");
		lblAndSurnameFor.setForeground(Color.RED);
		lblAndSurnameFor.setBounds(65, 142, 86, 14);
		panelCustomer.add(lblAndSurnameFor);
		
		lblTheInvoice = new JLabel("the invoice.");
		lblTheInvoice.setForeground(Color.RED);
		lblTheInvoice.setBounds(65, 153, 86, 20);
		panelCustomer.add(lblTheInvoice);
		
		comboBoxPayKin = new JComboBox();
		comboBoxPayKin.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Credit Card"}));
		comboBoxPayKin.setBounds(65, 323, 86, 20);
		panelCustomer.add(comboBoxPayKin);
		
		JLabel lblPaymentKind = new JLabel("Payment Kind");
		lblPaymentKind.setBounds(61, 296, 100, 19);
		panelCustomer.add(lblPaymentKind);
		
		
		textListProduct = new JTextArea();
		textListProduct.setBounds(151,217,389,187);
		frame.getContentPane().add(textListProduct);
		textListProduct.setVisible(false);
				
		textAllList = new JTextArea();
		textAllList.setBounds(171,41,406,379);
		frame.getContentPane().add(textAllList);
		
		managerPassPanel = new JPanel();
		managerPassPanel.setBackground(Color.CYAN);
		managerPassPanel.setBounds(20,44,608,409);
		frame.getContentPane().add(managerPassPanel);
		managerPassPanel.setLayout(null);
		managerPassPanel.setVisible(false);
		
		lblGiriIinIsminizi = new JLabel("G\u0130R\u0130\u015E i\u00C7\u0130N \u0130SM\u0130N\u0130Z\u0130 VE \u015E\u0130FREN\u0130Z\u0130 G\u0130R\u0130N\u0130Z");
		lblGiriIinIsminizi.setBackground(Color.CYAN);
		lblGiriIinIsminizi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblGiriIinIsminizi.setForeground(Color.RED);
		lblGiriIinIsminizi.setBounds(155, 40, 263, 29);
		managerPassPanel.add(lblGiriIinIsminizi);
		
		lblIsimGiriniz = new JLabel("\u0130sim giriniz:");
		lblIsimGiriniz.setBounds(132, 104, 89, 22);
		managerPassPanel.add(lblIsimGiriniz);
		
		lblifreGiriniz = new JLabel("\u015Eifre giriniz:");
		lblifreGiriniz.setBounds(131, 159, 90, 29);
		managerPassPanel.add(lblifreGiriniz);
		
		managerName = new JTextField();
		managerName.setBounds(240, 105, 98, 20);
		managerPassPanel.add(managerName);
		managerName.setColumns(10);
		
		managerPassword = new JTextField();
		managerPassword.setBounds(234, 163, 104, 20);
		managerPassPanel.add(managerPassword);
		managerPassword.setColumns(10);
		
		lblHataliSveyaI2 = new JLabel("");
		lblHataliSveyaI2.setBounds(167, 260, 138, 14);
		managerPassPanel.add(lblHataliSveyaI2);
		
		btnGiris = new JButton("Giri\u015F");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  name=managerName.getText();
				String pass=managerPassword.getText();
				if(name.equalsIgnoreCase(sym.getName()) && Integer.parseInt(pass)==sym.getPassword()) {
					managerPassPanel.setVisible(false);
					panelSystemManager.setVisible(true);
					
				}
				else {
					lblHataliSveyaI2.setText("Hatalý þifre veya isim...");
					managerName.setText("");
					managerPassword.setText("");
				}
			}
		});
		btnGiris.setBounds(231, 215, 89, 23);
		managerPassPanel.add(btnGiris);
		
		JLabel lblGeerliIsimadmin = new JLabel("Ge\u00E7erli isim : admin");
		lblGeerliIsimadmin.setForeground(Color.MAGENTA);
		lblGeerliIsimadmin.setBounds(365, 108, 138, 18);
		managerPassPanel.add(lblGeerliIsimadmin);
		
		JLabel lblGeerliifre = new JLabel("Ge\u00E7erli \u015Fifre : 123");
		lblGeerliifre.setForeground(Color.MAGENTA);
		lblGeerliifre.setBounds(365, 166, 104, 22);
		managerPassPanel.add(lblGeerliifre);
		
		//CASHÝER PANEL
		
		panelCashier = new JPanel();
		panelCashier.setBounds(10,44,618,396);
		frame.getContentPane().add(panelCashier);
		panelCashier.setLayout(null);
		
		JButton btnGiveInvoice = new JButton("Give Invoice");
		btnGiveInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelCashier.setVisible(false);
				textAllList.setVisible(true);
				textAllList.setText(shop.displayInvoice());
				shop.getShopList().clear();
				
			}
		});
		btnGiveInvoice.setBounds(256, 91, 112, 23);
		panelCashier.add(btnGiveInvoice);
		
		JButton btnListProduct = new JButton("List Product ");
		btnListProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCashier.setVisible(false);
				textAllList.setVisible(true);
				textAllList.setText(stok.displayAllProducts());
			}
		});
		btnListProduct.setBounds(256, 185, 112, 23);
		panelCashier.add(btnListProduct);
		panelCashier.setVisible(false);
		
		
		cashierPassPanel = new JPanel();
		cashierPassPanel.setBackground(Color.YELLOW);
		cashierPassPanel.setBounds(30, 44, 604, 396);
		frame.getContentPane().add(cashierPassPanel);
		cashierPassPanel.setLayout(null);
		cashierPassPanel.setVisible(false);
		
		lblGiriIinIsminizi = new JLabel("G\u0130R\u0130\u015E i\u00C7\u0130N \u0130SM\u0130N\u0130Z\u0130 VE \u015E\u0130FREN\u0130Z\u0130 G\u0130R\u0130N\u0130Z");
		lblGiriIinIsminizi.setBackground(Color.CYAN);
		lblGiriIinIsminizi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblGiriIinIsminizi.setForeground(Color.RED);
		lblGiriIinIsminizi.setBounds(173, 40, 287, 29);
		cashierPassPanel.add(lblGiriIinIsminizi);
		
		lblIsimGiriniz_1 = new JLabel("\u0130sim giriniz:");
		lblIsimGiriniz_1.setForeground(Color.RED);
		lblIsimGiriniz_1.setBounds(132, 104, 77, 22);
		cashierPassPanel.add(lblIsimGiriniz_1);
		
		lblifreGiriniz_1 = new JLabel("\u015Eifre giriniz:");
		lblifreGiriniz_1.setForeground(Color.RED);
		lblifreGiriniz_1.setBounds(131, 159, 78, 29);
		cashierPassPanel.add(lblifreGiriniz_1);
		
		cashierName = new JTextField();
		cashierName.setBounds(235, 105, 105, 20);
		cashierPassPanel.add(cashierName);
		cashierName.setColumns(10);
		
		cashierPassword = new JTextField();
		cashierPassword.setBounds(235, 163, 105, 20);
		cashierPassPanel.add(cashierPassword);
		cashierPassword.setColumns(10);
		
		btnGiris = new JButton("Giri\u015F");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  name=cashierName.getText();
				String pass=cashierPassword.getText();
				for(int i=0;i<casList.getCasList().size();i++) {
					if(name.equalsIgnoreCase(casList.getCasList().get(i).getName())&&Integer.parseInt(pass)==casList.getCasList().get(i).getPassword()) {
						cashierPassPanel.setVisible(false);
						panelCashier.setVisible(true);
						break;
					}	
				}
				
					lblHataliSveyaI.setText("Hatalý þifre veya isim...");
					cashierName.setText("");
					cashierPassword.setText("");
			}
		});
		btnGiris.setBounds(216, 216, 89, 23);
		cashierPassPanel.add(btnGiris);
		
		lblHataliSveyaI = new JLabel("");
		lblHataliSveyaI.setBounds(167, 260, 138, 14);
		cashierPassPanel.add(lblHataliSveyaI);
		
		JLabel lblIlknceYneticinin = new JLabel("\u0130lk \u00F6nce y\u00F6neticinin bir kasiyer eklemesi ve \u015Fifre vermesi gerekiyor");
		lblIlknceYneticinin.setForeground(Color.BLUE);
		lblIlknceYneticinin.setBackground(Color.RED);
		lblIlknceYneticinin.setBounds(102, 80, 358, 14);
		cashierPassPanel.add(lblIlknceYneticinin);
		
		
		textAllList.setVisible(false);
		
	}
	public static void comboUpdate() {
		boolean flag=true;
		for(int i=0;i<stok.getProductsList().size();i++) {
			for(int k=0;k<comboBoxProducts.getItemCount();k++) {
				if(stok.getProductsList().get(i).getName().equals(comboBoxProducts.getItemAt(k))) {
					flag=false;
					break;
				}
				else {
					flag=true;
				}
			}
			if(flag==true) {
				comboBoxProducts.addItem(stok.getProductsList().get(i).getName());
			}
		}
	}
	public static void comboNew() {
		for(int i=0;i<stok.getProductsList().size();i++) {
			comboBoxProducts.addItem(stok.getProductsList().get(i).getName());
			}
	}
	public static void addProoduct(String name,double price,int quantity) {
		int k=0;
		for(int i=0;i<stok.getProductsList().size();i++) {
			if(stok.getProductsList().get(i).getName().equalsIgnoreCase(name)) {
				lblError.setText("Bu ürün stokta bulunuyor ekleyemezsiniz...");
				k=1;
				break;
			}
		}
		if(k==0) {
			stok.addProducts(new Products(name,price,quantity));
			lblError.setText("Ürün stoga eklendi..");
		}
	}
	public static void deleteListProduct(String name) {
		char c = Character . toUpperCase ( name . charAt ( 0 ));
		 
			name = c + name . substring ( 1 );
		   String bosluk=" ";
		   for (int i = 1 ; i<name.length();i++)
		      {
		          if (name.charAt(i)==' ')
		          {
		              c=Character.toUpperCase(name.charAt (i+1));
		              name = name.substring(0,i)+bosluk +c  + name.substring(i+2);
		         
		          }
		         
		      }

		for(int i=0;i<comboBoxProducts.getItemCount();i++) {
			if(comboBoxProducts.getItemAt(i).equals(name)) {
				comboBoxProducts.removeItem(name);
			}
			
		}
	}
	public static void addCashier(String name, String surName,int cashierId,int password) {
		int k=0;
		for(int i=0;i<casList.getCasList().size();i++) {
			if(casList.getCasList().get(i).getName().equalsIgnoreCase(name)&&casList.getCasList().get(i).getSurName().equalsIgnoreCase(surName)) {
				lblError.setText("Bu kiþi sistemde tanýmlý ekleyemezsiniz...");
				k=1;
				break;
			}
		}
		if(k==0) {
			casList.addCashier(new Cashier(name,surName,cashierId,password));
			lblError.setText("Kiþi sisteme eklendi..");
		}
	}
}
