package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.multisplitpane.DefaultSplitPaneModel;

//import database.*;
//import entities.ChiTietHoaDon;
//import entities.KhachHang;
//import entities.Thuoc;

import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;

//import dao.LapHoaDonDAO;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import javax.swing.JMenuItem;

public class FrmPhanCongLaoDong extends JFrame implements ActionListener,MouseListener,TableModelListener,KeyListener{

	JTabbedPane tabbedPane;
	public static JPanel jp1,pnTab2,pnTab3,pnTab4;
	JLabel lblThongTinKhachHang,lblDiaChi,lblMaNV,lblTenKH,lblSDT,lblNN,lblMakh,lblLHD ;
	JTextField txtHD;
	JButton btnTim,btnThem;

	public static DefaultTableModel tablemodel;
	public static JTextField txtNgay;
	private JLabel lblNhanVien;
	public static JTextField txtNhanVien;
	public static JRadioButton radKeDon;
	public static JRadioButton radKhongKeDon;
	public static JTextField txtHoKh;
	public static JTextField txtTenkh;
	public static JTextField txtCMND;
	private JLabel lblDC;
	public static JTextField txtDChi;
	private JLabel lblSdt;
	public static JTextField txtSdt;
	private JTable table;
	private JLabel lblTongTienThuoc;
	public static JTextField txtTongTienThuoc;
	private JLabel lblGiamGia;
	private JLabel lblTongThanhToan;
	private JTextField txtThue;
	public static JTextField txtTongThanhToan;
	private JLabel lblMHd;
	private JPanel jp2;
	private JComboBox cboDVT;
	private JComboBox<Integer> cboSoLuong;
	private JComboBox cboGiamGia;
	public static JComboBox cboTimKiemThuoc ;
	private JButton btnThemThuocTim;
	private JButton btnInHd;
	private JButton btnXoa;
	public static DefaultComboBoxModel cboModeTimKiemThuoc= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModelTableThuoc = new DefaultComboBoxModel();
	private JSpinner spinner = new JSpinner(new SpinnerNumberModel(new Integer(1),new Integer(1),null,new Integer(1)));
	public static int i =0;
	private JTextField txtTienNhan;
	private JTextField txtTienThoiLai;
	private JButton btnMayTinh;
	private static JComboBox cboGiamGia1;
	public static JTextField txtSoLuong;
	public static JLabel lblThongBao;
	private static float tongThanhToan=0;
	public static String setLoaiThuoc = "";
	private JButton btnThemHoaDon;
	private JMenuItem mntmSoLuong;
	private JMenuItem mntmXoa;
	public static JComboBox cboGioiTinh ;
	public static JDateChooser txtNgaySinh ;
	private JButton btnThemDiaChi;
//	private	FrmXuatHD frmXuatHD = new FrmXuatHD();
//	private FrmThemDiaChiKhachHang frmThemDiaChiKhachHang = new FrmThemDiaChiKhachHang();
//	private FrmChonThuoc frmChonThuoc = new FrmChonThuoc();
//	private static LapHoaDonDAO lapHoaDonDAO = new LapHoaDonDAO();
	
	
	public FrmPhanCongLaoDong() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Hinh\\D01014613-p1.jpg"));
		setTitle("QU???N L?? QU???Y THU???C B???NH VI???N T??Y NAM");
		setSize(1354, 733);

		setLocationRelativeTo(null);
		setResizable(true);
		tabbedPane=new JTabbedPane();
		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));

		jp1=new JPanel();
		jp1.setBackground(new Color(176, 224, 230));
		pnTab2=new JPanel();


		ImageIcon icon=new ImageIcon("leaves-icon.png");
		tabbedPane.addTab("Ph??n c??ng lao ?????ng",(Icon) null,jp1);



		jp1.add(lblLHD = new JLabel("PH??N C??NG"));
		lblLHD.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblLHD.setForeground(Color.RED);


		jp1.add(lblMaNV = new JLabel("M?? NV:"));
		lblMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMaNV.setForeground(new Color(0, 0, 0));
		jp1.add(lblMakh=new JLabel("Nh???p m?? kh??ch h??ng:"));



		jp1.add(txtHD = new JTextField());
		txtHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));


		lblLHD.setBounds(574,11 , 247, 38);
		lblMaNV.setBounds(10,55 , 74, 20);


		txtHD.setBounds(82,55, 178, 20);
		txtHD.setEditable(false);

		JLabel lblNgay = new JLabel("Ng??y:");
		lblNgay.setForeground(new Color(0, 0, 0));
		lblNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNgay.setBounds(304, 55, 74, 20);
		jp1.add(lblNgay);

		txtNgay = new JTextField();
		txtNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtNgay.setEditable(false);
		txtNgay.setBounds(388, 54, 152, 20);
		jp1.add(txtNgay);

		lblNhanVien = new JLabel("Nh??n Vi??n:");
		lblNhanVien.setForeground(new Color(0, 0, 0));
		lblNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNhanVien.setBounds(564, 60, 147, 20);
		jp1.add(lblNhanVien);

		txtNhanVien = new JTextField();
		txtNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtNhanVien.setEditable(false);
		txtNhanVien.setBounds(718, 63, 236, 20);
		jp1.add(txtNhanVien);

		


		JLabel lblTnKh = new JLabel("H??? NV:");
		lblTnKh.setForeground(new Color(0, 0, 0));
		lblTnKh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTnKh.setBounds(301, 86, 79, 20);
		jp1.add(lblTnKh);

		txtHoKh = new JTextField();
		txtHoKh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			
		txtHoKh.setBounds(390, 86, 152, 20);
		jp1.add(txtHoKh);

		JLabel lblTenkh = new JLabel("T??n NV:");
		lblTenkh.setForeground(new Color(0, 0, 0));
		lblTenkh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenkh.setBounds(564, 91, 147, 20);
		jp1.add(lblTenkh);

		txtTenkh = new JTextField();
		txtTenkh.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtTenkh.setBounds(718, 94, 236, 20);
		jp1.add(txtTenkh);
		
		

		JLabel lblCMND = new JLabel("S??? CMND:");
		lblCMND.setForeground(new Color(0, 0, 0));
		lblCMND.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCMND.setBounds(301, 125,100, 20);
		jp1.add(lblCMND);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtCMND.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
		txtCMND.setBounds(389, 125, 155, 20);
		jp1.add(txtCMND);
          JTextField txtSoNC = new JTextField();
		JLabel lblSoNC = new JLabel("S??? ng??y c??ng:");
		lblSoNC.setForeground(new Color(0, 0, 0));
		lblSoNC.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSoNC.setBounds(564, 125, 147, 20);
		jp1.add(lblSoNC);

		txtSoNC = new JTextField();
		txtSoNC.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtSoNC.setBounds(718, 125, 236, 20);
		jp1.add(txtSoNC);
	

		

		lblSdt = new JLabel("SDT:");
		lblSdt.setForeground(new Color(0, 0, 0));
		lblSdt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSdt.setBounds(10, 86, 62, 20);
		jp1.add(lblSdt);

		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
			
		
		txtSdt.setBounds(82, 86, 178, 20);
		jp1.add(txtSdt);


		javax.swing.border.Border southborder=BorderFactory.createLineBorder(Color.blue,Font.BOLD);
		TitledBorder southTitleBorder=new TitledBorder(southborder,"Th??ng tin chung");
		southTitleBorder.setTitleColor(Color.blue);


		JScrollPane scroll = new  JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		String[] tb = new String[] {"STT","M?? Nh??n vi??n","H???","T??n","Ng??y sinh",
				"S??? CMND","S???DT","M?? c??ng tr??nh","S??? ng??y c??ng"};

		tablemodel = new DefaultTableModel(tb, 0) ;


		table = new JTable(tablemodel);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//table.setFillsViewportHeight(true);
		table.setBackground(Color.WHITE);
		scroll.setViewportView(table);
		
		
		//getContentPane().add(scroll);
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);

		mntmSoLuong = new JMenuItem("S???a s??? l?????ng");
		popupMenu.add(mntmSoLuong);

		mntmXoa = new JMenuItem("X??a");
		popupMenu.add(mntmXoa);

		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(200);
		tablemodel.addTableModelListener(this);






		// disable edit trong table
		table.setDefaultEditor(Object.class, null);

		txtSoLuong = new JTextField();
		txtSoLuong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
		txtSoLuong.setEditable(false);
		DefaultCellEditor colSoLuong = new DefaultCellEditor(txtSoLuong);
		//		table.getColumnModel().getColumn(6).setCellEditor(col6);
		table.getColumnModel().getColumn(7).setCellEditor(colSoLuong);



		


		javax.swing.border.Border southborder2=BorderFactory.createLineBorder(Color.blue);
		TitledBorder southTitleBorder2=new TitledBorder(southborder2,"Th??ng tin nh??n vi??n");
		southTitleBorder2.setTitleColor(Color.blue);
		scroll.setBorder(southTitleBorder2);

		jp1.add(scroll);
		scroll.setPreferredSize(new Dimension(0,250));
		jp1.setLayout(null);

		scroll.setBounds(20, 202, 1299, 248);
		getContentPane().add(tabbedPane);

		btnXoa = new JButton("X??a ");
		btnXoa.setHorizontalAlignment(SwingConstants.LEFT);
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoa.setBackground(new Color(32, 178, 170));
		btnXoa.setIcon(new ImageIcon("Hinh\\iconDeleteRow.png"));
		btnXoa.setBounds(20, 167, 105, 23);
		jp1.add(btnXoa);

		btnThemThuocTim = new JButton("Th??m");
		btnThemThuocTim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThemThuocTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnThemThuocTim.setBackground(new Color(32, 178, 170));
		btnThemThuocTim.setIcon(new ImageIcon("Hinh\\iconSearch.png"));
		btnThemThuocTim.setBounds(1177, 158, 120, 23);
		jp1.add(btnThemThuocTim);



		

		cboTimKiemThuoc = new JComboBox();
		cboTimKiemThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));


		cboTimKiemThuoc.setEditable(true);
		cboTimKiemThuoc.setBounds(886, 158, 267, 23);
		jp1.add(cboTimKiemThuoc);

		lblMHd = new JLabel("M?? c??ng tr??nh:");
		lblMHd.setForeground(new Color(0, 0, 0));
		lblMHd.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMHd.setBounds(763, 159, 113, 20);
		jp1.add(lblMHd);
		jp2 = new JPanel();
		jp2.setBackground(new Color(176, 224, 230));
		jp2.setForeground(Color.BLUE);
		jp2.setBounds(10, 455, 1309, 166);
		jp1.add(jp2);

		javax.swing.border.Border southborder3=BorderFactory.createLineBorder(Color.blue);
		TitledBorder southTitleBorder3=new TitledBorder(southborder3,"Th??ng tin chi ti???t");
		southTitleBorder3.setTitleColor(Color.BLUE);
		jp2.setBorder(southTitleBorder3);
		jp1.add(jp2);
		jp2.setLayout(null);

		

	
			
		



	
		AutoCompleteDecorator.decorate(cboTimKiemThuoc);
		lblThongBao = new JLabel("");
		lblThongBao.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setBackground(Color.RED);
		lblThongBao.setBounds(10, 143, 436, 20);

		jp1.add(lblThongBao);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy , hh:mm");
		txtNgay.setText(LocalDateTime.now().format(formatter));

		//txtNhanVien.setText(lapHoaDonDAO.tenNhanVien(FrmDangNhap.taiKhoan.getTenTaiKhoan()));

		cboGioiTinh = new JComboBox();
		cboGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cboGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "N???", "Kh??c"}));
		cboGioiTinh.setBounds(1158, 60, 95, 22);
		jp1.add(cboGioiTinh);

		JLabel lblGoiTinh = new JLabel("Gi???i t??nh:");
		lblGoiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGoiTinh.setBounds(1050, 60, 86, 26);
		jp1.add(lblGoiTinh);

		JLabel lblNgaySinh = new JLabel("Ng??y sinh:");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNgaySinh.setBounds(1050, 86, 86, 33);
		jp1.add(lblNgaySinh);

		/*
		 * 
		 * ngay
		 * 
		 * 
		 * */
		txtNgaySinh = new JDateChooser();
		txtNgaySinh.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtNgaySinh.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtNgaySinh.setBounds(1157, 89, 162, 20);
		txtNgaySinh.setLocale(Locale.forLanguageTag("vi-VN"));
		txtNgaySinh.setDateFormatString("dd/MM/yyyy");
		jp1.add(txtNgaySinh);



		btnThemDiaChi = new JButton("");
		btnThemDiaChi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				frmThemDiaChiKhachHang.setVisible(true);
//				frmThemDiaChiKhachHang.setLocationRelativeTo(null);
			}
		});
		JButton btnThoat = new JButton("Tho??t");
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnThoat.setBounds(1159, 110, 129, 45);
		jp2.add(btnThoat);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmManHinhChinh.tabbedPane.remove(jp1);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThoat.setBackground(new Color(32, 178, 170));
		btnThoat.setIcon(new ImageIcon("Hinh\\iconDelete.png"));
		jp1.add(btnThemDiaChi);
		txtSdt.addKeyListener(this);

		mntmSoLuong.addActionListener(this);
		mntmXoa.addActionListener(this);
		cboTimKiemThuoc.removeAllItems();
		//updateComboxTenThuoc();

	}
//	public void themHoaDonKeDon() {
//
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//
//		String soNha = frmThemDiaChiKhachHang.txtSoNha.getText();
//		String tenDuong = frmThemDiaChiKhachHang.txtTenDuong.getText();
//		String phuong = frmThemDiaChiKhachHang.txtPhuong.getText();
//		String Quan =frmThemDiaChiKhachHang.txtQuan.getText();
//		String thanhPho = frmThemDiaChiKhachHang.txtThanhPho.getText();
//		String quocGia =frmThemDiaChiKhachHang.txtQuocGia.getText();
//		String ten=txtTenkh.getText();
//		String ho=txtHoKh.getText();
//		String ngaySinhtxt = simpleDateFormat.format(txtNgaySinh.getDate());
//		System.out.println(ngaySinhtxt);
//		Date ngaySinhSQL = null;
//		try {
//			java.util.Date ngaySinh = simpleDateFormat.parse(ngaySinhtxt);
//			ngaySinhSQL = new Date(ngaySinh.getTime());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String gioiTinh = cboGioiTinh.getSelectedItem().toString();
//		String cmnd= txtCMND.getText();
//		String soDienThoai=txtSdt.getText();
//		// ma nhan vien
//		int maNhanVien = Integer.parseInt(lapHoaDonDAO.maNhanVien(FrmDangNhap.taiKhoan.getTenTaiKhoan()));
//
//		// tim ma khach hang boi so dien thoai
//		int maKhachHang = lapHoaDonDAO.maKhachHangBySDT(soDienThoai);
//		//them dia chi cua khach hang moi dat
//		lapHoaDonDAO.addDiaChi(soNha, tenDuong, phuong, Quan, thanhPho, quocGia);
//		//them khach hang moi lap hoa don
//		lapHoaDonDAO.addKhachHang(ten, ho, ngaySinhSQL, gioiTinh, cmnd, soDienThoai, lapHoaDonDAO.maDiaChiMax());
//
//		// get tong tien tu form 
//		float tongTien = 0;
//		tongTien = tongThanhToan;
//		// them hoa don loai thuoc ke don
//		lapHoaDonDAO.addHoaDonLoaiKeDon(maNhanVien, maKhachHang, tongTien);
//		// them frm xuathd
//		String loaiHoaDon="";
//		if(radKeDon.isSelected()) {
//			loaiHoaDon = "Thu???c k?? ????n";
//		}
//		else if(radKhongKeDon.isSelected()) {
//			loaiHoaDon = "Kh??ng k?? ????n";
//		}
//
//		setDuLieuFrmInHd(lapHoaDonDAO.maHoaDon(String.valueOf(maNhanVien)),loaiHoaDon , txtNgay.getText(), ho+" " +ten, ngaySinhtxt,gioiTinh, soDienThoai,txtDChi.getText(),"", txtTongTienThuoc.getText(), txtTongThanhToan.getText(), txtNhanVien.getText(), txtTenkh.getText());
//		frmXuatHD.lblSL.setText(i +"");
//	}


//	public void timKhachHangBySDT(String sdt) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		try {
//			for(KhachHang khachHang : lapHoaDonDAO.timKhachHangBySDT(sdt)) {
//				String ho = khachHang.getHo();
//				String ten = khachHang.getTen();
//				String gioiTinh = khachHang.getGioiTinh();
//				String CMND = khachHang.getCmnd();
//				String ngaySinh = khachHang.getNgaySinh().toString();
//				String soNha = khachHang.getDiaChi().getSoNha();
//				String tenDuong = khachHang.getDiaChi().getTenDuong();
//				String phuong = khachHang.getDiaChi().getPhuong();
//				String quan = khachHang.getDiaChi().getQuan();
//				String thanhPho = khachHang.getDiaChi().getThanhPho();
//				String quocGia = khachHang.getDiaChi().getQuocGia();
//
//				frmThemDiaChiKhachHang.txtSoNha.setText(soNha);
//				frmThemDiaChiKhachHang.txtTenDuong.setText(tenDuong);
//				frmThemDiaChiKhachHang.txtPhuong.setText(phuong);
//				frmThemDiaChiKhachHang.txtQuan.setText(quan);
//				frmThemDiaChiKhachHang.txtQuocGia.setText(quocGia);
//				txtHoKh.setText(ho);
//				txtTenkh.setText(ten);
//				cboGioiTinh.setSelectedItem(gioiTinh);
//				txtCMND.setText(CMND);
//				txtDChi.setText(soNha+" " +tenDuong+","+phuong+","+quan+","+thanhPho+","+quocGia);
//				Date date = Date.valueOf(ngaySinh);
//				txtNgaySinh.setDate(date);
//
//			}  
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//
//	String tenThuocSoSanh="";
//	public  void updateComboxTenThuoc() {
//		cboTimKiemThuoc.removeAllItems();
//		try {
//			cboModeTimKiemThuoc.addElement(null);
//			String tenThuoc ="";
//			for(Thuoc thuoc : lapHoaDonDAO.updateComboxTenThuoc()) {
//				if(thuoc.getTenThuoc().equalsIgnoreCase(tenThuocSoSanh)==false) {
//					tenThuoc = thuoc.getTenThuoc();
//					cboModeTimKiemThuoc.addElement(tenThuoc);
//					cboTimKiemThuoc.setModel(cboModeTimKiemThuoc);
//				}
//				tenThuocSoSanh = tenThuoc;
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//
//
//	public boolean addHoaDon() {
//		int maNhanVien = Integer.parseInt(lapHoaDonDAO.maNhanVien(FrmDangNhap.taiKhoan.getTenTaiKhoan()));
//		float tongTien = 0;
//		tongTien = tongThanhToan;
//		Connection con = ConectDatabase.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		int n =0;
//		try {
//			stmt = con.prepareStatement("insert into dbo.HoaDon(MaNhanVien,TongTien) values\r\n" + 
//					"(?,?)");
//			stmt.setInt(1,maNhanVien);
//			stmt.setFloat(2, tongThanhToan);
//			n= stmt.executeUpdate();
//		} catch (Exception e3) {
//			// TODO: handle exception
//		}
//		return n>0;
//	}
//
//
//	public static void danhSachThuocTheoMaThuoc(int maThuoc) {
//		if(lapHoaDonDAO.soLuongThuocDaBan(maThuoc) > lapHoaDonDAO.soLuongNhap(maThuoc)) {
//			JOptionPane.showMessageDialog(jp1, "Thu???c ???? t???m h???t thu???c trong kho ! \n Vui l??ng ch???n lo???i thu???c kh??c");
//		}
//		else {
//			try {
//				Thuoc thuoc = new Thuoc();
//				thuoc = lapHoaDonDAO.ThuocTheoMa(maThuoc);
//				if(thuoc != null) {
//					int maThuocInt = thuoc.getMaThuoc();
//					String tenThuocs = thuoc.getTenThuoc();
//					String loaiThuoc = thuoc.getPhanLoai();
//					String donViTinhs = thuoc.getDonViTinh();
//					String hamLuong = thuoc.getHamLuong();
//					String donGia = thuoc.getDonGia() + "";
//					double thanhTien = Integer.parseInt(txtSoLuong.getText()) * Double.parseDouble(donGia);
//					if(loaiThuoc.equalsIgnoreCase("Thu???c k?? ????n")) {
//						radKeDon.setSelected(true);
//						radKhongKeDon.setSelected(false);
//						setLoaiThuoc = "Thu???c k?? ????n";
//						lblThongBao.setText("Thu???c k?? ????n vui l??ng nh???p th??ng tin kh??ch h??ng!");
//						txtSdt.requestFocus();
//
//					}
//					else if(loaiThuoc.equalsIgnoreCase("Kh??ng k?? ????n") && setLoaiThuoc.equalsIgnoreCase("Thu???c k?? ????n")==false) {
//						radKhongKeDon.setSelected(true);
//						radKeDon.setSelected(false);
//						lblThongBao.setText("");
//					}
//					tablemodel.addRow(new Object[] {
//							++i,maThuocInt,tenThuocs,loaiThuoc,donViTinhs,hamLuong,donGia,txtSoLuong.getText(),0,thanhTien
//					});
//					updateTongTien();
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//	}
//	
//	public boolean updateTableChonThuoc(String tenThuoc) {
//		try {
//			frmChonThuoc.xoaDuLieuTableModel();
//			frmChonThuoc.lblThuocCoTen.setText("THU???C C?? T??N "+tenThuoc);
//			if(lapHoaDonDAO.danhSachThuocTimKiemTheoTen_TimKiemTuongDoi(tenThuoc).isEmpty() == false) {
//				for(Thuoc thuoc: lapHoaDonDAO.danhSachThuocTimKiemTheoTen_TimKiemTuongDoi(tenThuoc)) {
//					frmChonThuoc.tableModel.addRow(new Object[] {
//							thuoc.getMaThuoc(),thuoc.getNhomThuoc(),thuoc.getTenThuoc(),thuoc.getPhanLoai(),thuoc.getHamLuong(),thuoc.getDangBaoChe(),thuoc.getDonViTinh(),thuoc.getDonGia(),thuoc.getNhaCungcap().getTenNCC()
//					});
//					frmChonThuoc.table.setModel(frmChonThuoc.tableModel);
//				}
//				frmChonThuoc.table.setRowSelectionInterval(0, 0);
//				return true;
//			}
//			else
//				JOptionPane.showMessageDialog(null, "Kh??ng c?? d??? li???u!");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return false;
//	}
//
//	public boolean kiemTraThongTinKhachHang() {
//		if(txtSdt.getText().equalsIgnoreCase("")) {
//			txtSdt.requestFocus();
//			lblThongBao.setText("Vui l??ng nh???p s??? ??i???n tho???i!");
//			return false;
//		}
//		else if(txtTenkh.getText().equalsIgnoreCase("")) {
//			txtTenkh.requestFocus();
//			lblThongBao.setText("Vui l??ng nh???p v??o t??n kh??ch h??ng!");
//			return false;
//		}
//		else if(txtHoKh.getText().equalsIgnoreCase("")) {
//			txtHoKh.requestFocus();
//			lblThongBao.setText("Vui l??ng nh???p v??o h??? kh??ch h??ng!");
//			return false;
//		}
//		else if(txtDChi.getText().equalsIgnoreCase("")) {
//			txtDChi.requestFocus();
//			lblThongBao.setText("Vui l??ng nh???p v??o ?????a ch???!");
//			return false;
//		}
//		return true;
//	}
//	public boolean kiemTraThuocKeDon() {
//		List data = tablemodel.getDataVector();
//		Object[] list1 = data.toArray();
//		for(int k=0;k<list1.length;k++) {
//			String loaiThuoc = tablemodel.getValueAt(k, 3).toString();
//			if(loaiThuoc.equalsIgnoreCase("Thu???c k?? ????n")) {
//				radKeDon.setSelected(true);
//				radKhongKeDon.setSelected(false);
//				lblThongBao.setText("Thu???c k?? ????n vui l??ng nh???p th??ng tin kh??ch h??ng!");
//				return true;
//			}
//		}
//		return false;
//	}
//	public boolean kiemTraTrungThuoc(String tenThuoc) {
//		List data = tablemodel.getDataVector();
//		Object[] list1 = data.toArray();
//		for(int k=0;k<list1.length;k++) {
//			String tenThuocTable = tablemodel.getValueAt(k, 2).toString();
//
//			if(tenThuoc.equalsIgnoreCase(tenThuocTable)) {
//				table.setRowSelectionInterval(k, k);
//				return true;
//			}
//		}
//		return false;
//	}
//	public boolean kiemTraNhapKhachHangThuocKeDon() {
//		if(radKeDon.isSelected()) {
//			if(txtSdt.getText().equalsIgnoreCase("")) {
//				JOptionPane.showMessageDialog(this, "Nh???p s??? ??i???n tho???i c???a kh??ch h??ng.");
//				txtSdt.requestFocus();
//				return false;
//			}
//			else if(txtTenkh.getText().equalsIgnoreCase("")) {
//				JOptionPane.showMessageDialog(this, "Nh???p t??n c???a kh??ch h??ng.");
//				txtTenkh.requestFocus();
//				return false;
//			}
//			else if(txtDChi.getText().equalsIgnoreCase("")) {
//				JOptionPane.showMessageDialog(this,"Nh???p ?????a ch??? c???a kh??ch h??ng.");
//				txtDChi.requestFocus();
//				return false;
//			}
//		}
//		else if(radKeDon.isSelected()==false) {
//			return false;
//		}
//		return true;
//	}
//	public void xoaHetDuLieuTrenTableModel() {
//		tablemodel.addRow(new Object[] {
//
//		});
//		tablemodel = (DefaultTableModel) table.getModel();
//		tablemodel.getDataVector().removeAllElements();
//	}
//	public void xoaTrangTxt() {
//		txtSdt.setText("");
//		txtHoKh.setText("");
//		txtTenkh.setText("");
//		txtDChi.setText("");
//		txtCMND.setText("");
//	}
//	public void setDuLieuFrmInHd(String maHoaDon,String loaiHoaDon,String ngayLap,String hoTenKh,String namSinh,String gioiTinh,String soDT,String diaChi,String soLuong,String tongTienThuoc,String tongTienThanhToan,String tenNguoiBan,String tenKhachHang) {
//
//		frmXuatHD.lblMaNV.setText(maHoaDon);
//		frmXuatHD.lblLoaiHD1.setText(loaiHoaDon);
//		frmXuatHD.lblNgayLap1.setText(ngayLap);
//		frmXuatHD.lblTenKH1.setText(tenKhachHang);
//		frmXuatHD.lblGTinh1.setText(gioiTinh);
//		frmXuatHD.lblDCKH1.setText(diaChi);
//		frmXuatHD.lblNamSinh1.setText(namSinh);
//		frmXuatHD.lblsdtkh1.setText(soDT);
//		frmXuatHD.lblTongTThuoc.setText(tongTienThuoc);
//		frmXuatHD.lblTongT.setText(tongTienThanhToan);
//		frmXuatHD.lblNguoiBan.setText(tenNguoiBan);
//		frmXuatHD.lblNguoiMuaHang1.setText(tenKhachHang);
//	}
//	public void themHoaDonVaChiTietHoaDonKeDon() {
//		themHoaDonKeDon();
//		ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
//		ArrayList<ChiTietHoaDon> listCT_HD = new ArrayList<ChiTietHoaDon>();
//		List data = tablemodel.getDataVector();
//		Object[] list1 = data.toArray();
//		String maHoaDon =lapHoaDonDAO.maHoaDon(lapHoaDonDAO.maNhanVien(FrmDangNhap.taiKhoan.getTenTaiKhoan()));
//		int stt=0;
//		for(int k=0;k<list1.length;k++) {
//
//			try {
//				chiTietHoaDon = new ChiTietHoaDon(maHoaDon,Integer.parseInt(tablemodel.getValueAt(k,1).toString()),Float.parseFloat(tablemodel.getValueAt(k, 6).toString()),Float.parseFloat(tablemodel.getValueAt(k, 8).toString()),Integer.parseInt(tablemodel.getValueAt(k, 7).toString()),tablemodel.getValueAt(k, 4).toString());
//				listCT_HD.add(chiTietHoaDon);
//				//
//
//				frmXuatHD.tableModel.addRow(new Object[] {
//						++stt,tablemodel.getValueAt(k, 2).toString(),tablemodel.getValueAt(k,4),tablemodel.getValueAt(k, 6),tablemodel.getValueAt(k, 7),tablemodel.getValueAt(k, 8),tablemodel.getValueAt(k, 9)
//				});
//			} catch (Exception e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}
//		for(ChiTietHoaDon hoaDon: listCT_HD) {
//			lapHoaDonDAO.addCT_HoaDon(hoaDon.getMaHoaDon(), hoaDon.getMaThuoc(), hoaDon.getDonGia(), hoaDon.getGiamGia(), hoaDon.getSoLuong(), hoaDon.getDonViTinh());
//		}
//		btnInHd.setEnabled(false);
//		//	frmXuatHD.setVisible(true);
//
//		// set table chi tiet hoa don
//
//		this.frmXuatHD.setVisible(true);
//		frmXuatHD.setLocationRelativeTo(null);
//		// ham in hoa don
//		frmXuatHD.printingHoaDon();
//	}
//	public void themHoaDonVaChiTietHoaDonKhongKeDon() {
//		addHoaDon();
//		ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
//		ArrayList<ChiTietHoaDon> listCT_HD = new ArrayList<ChiTietHoaDon>();
//		List data = tablemodel.getDataVector();
//		Object[] list1 = data.toArray();
//		String maHoaDon =lapHoaDonDAO.maHoaDon(lapHoaDonDAO.maNhanVien(FrmDangNhap.taiKhoan.getTenTaiKhoan()));
//		System.out.println(list1.length);
//		int stt=0;
//		for(int k=0;k<list1.length;k++) {
//
//			try {
//				chiTietHoaDon = new ChiTietHoaDon(maHoaDon,Integer.parseInt(tablemodel.getValueAt(k,1).toString()),Float.parseFloat(tablemodel.getValueAt(k, 6).toString()),Float.parseFloat(tablemodel.getValueAt(k, 8).toString()),Integer.parseInt(tablemodel.getValueAt(k, 7).toString()),tablemodel.getValueAt(k, 4).toString());
//				listCT_HD.add(chiTietHoaDon);
//
//				frmXuatHD.tableModel.addRow(new Object[] {
//						++stt,tablemodel.getValueAt(k, 2).toString(),tablemodel.getValueAt(k,4),tablemodel.getValueAt(k, 6),tablemodel.getValueAt(k, 7),tablemodel.getValueAt(k, 8),tablemodel.getValueAt(k, 9)
//				});
//			} catch (Exception e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}
//		for(ChiTietHoaDon hoaDon: listCT_HD) {
//			lapHoaDonDAO.addCT_HoaDon(hoaDon.getMaHoaDon(), hoaDon.getMaThuoc(), hoaDon.getDonGia(), hoaDon.getGiamGia(), hoaDon.getSoLuong(), hoaDon.getDonViTinh());
//		}
//		btnInHd.setEnabled(false);
//		int maNhanVien = Integer.parseInt(lapHoaDonDAO.maNhanVien(FrmDangNhap.taiKhoan.getTenTaiKhoan()));
//		setDuLieuFrmInHd(lapHoaDonDAO.maHoaDon(String.valueOf(maNhanVien)),"Kh??ng k?? ????n", txtNgay.getText(), "", "", "", "", "", "", txtTongTienThuoc.getText(),txtTongThanhToan.getText(), lapHoaDonDAO.tenNhanVien(txtNhanVien.getText()), "");
//		frmXuatHD.lblSL.setText(i + "");
//		this.frmXuatHD.setVisible(true);
//		frmXuatHD.setLocationRelativeTo(null);
//		// ham in hoa don 
//		frmXuatHD.printingHoaDon();
//	}
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub 
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object obj = e.getSource();
//		ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
//		ArrayList<ChiTietHoaDon> listCT_HD = new ArrayList<ChiTietHoaDon>();
//		if(obj.equals(btnThemThuocTim)) {
//			Object objTenThuoc = cboTimKiemThuoc.getSelectedItem();
//			String tenThuoc = String.valueOf(objTenThuoc);
//			System.out.println(tenThuoc);
//			if(kiemTraTrungThuoc(tenThuoc)==false) {
//				//hien frmChonThuoc
//				if(updateTableChonThuoc(tenThuoc)==true) {
//					frmChonThuoc.setVisible(true);
//					frmChonThuoc.setLocationRelativeTo(null);
//				}
//				//	timKiemThuocTheoTen(tenThuoc);
//
//			}
//			else {
//				JOptionPane.showMessageDialog(this, "Thu???c ???? c?? trong b???ng ! Vui l??ng nh???p s??? l?????ng.");
//				boolean check = true;
//				int row = table.getSelectedRow();
//				int maThuoc = (int) table.getValueAt(row, 1);
//				while(check) {
//					try {
//						String soLuongThuocObj = JOptionPane.showInputDialog("Nh???p s??? l?????ng thu???c mua.",JOptionPane.YES_NO_CANCEL_OPTION);
//						if(soLuongThuocObj == null) {
//							check = false;
//						}
//						else if(soLuongThuocObj != null) {
//							if(soLuongThuocObj.matches("^[0-9]+$")) {
//								int soLuongThuocMoi = Integer.parseInt(soLuongThuocObj.toString());
//								int soLuongThuocCu = Integer.parseInt(table.getValueAt(row, 7).toString());
//								if((lapHoaDonDAO.soLuongThuocDaBan(maThuoc) + (soLuongThuocMoi+soLuongThuocCu)) <= lapHoaDonDAO.soLuongNhap(maThuoc)) {
//
//									int soLuongThuocCuMoi = soLuongThuocMoi + soLuongThuocCu;
//									table.setValueAt(soLuongThuocCuMoi, row, 7);
//
//									check = false;
//								}
//								else
//									JOptionPane.showMessageDialog(this, "S??? L?????ng Thu???c C???n Mua V?????t Gi???i H???n Thu???c Trong Kho!\n Nh???p S??? L?????ng ??t H??n "+(lapHoaDonDAO.soLuongNhap(maThuoc)-(lapHoaDonDAO.soLuongThuocDaBan(maThuoc)+soLuongThuocCu)));
//							}
//							else {
//								JOptionPane.showMessageDialog(null, "S??? L?????ng Ph???i Nh???p B???ng Ch???!");
//								check = true;
//							}
//						}
//					} catch (NullPointerException e2) {
//						// TODO: handle exception
//
//					}catch (NumberFormatException e3) {
//						// TODO: handle exception
//						e3.printStackTrace();
//						JOptionPane.showMessageDialog(null, "S??? L?????ng Nh???p Qu?? L???n!");
//						//					check = true;
//					}
//				}
//			}
//		}
//		else if(obj.equals(btnInHd)) {
//			Object o =JOptionPane.showConfirmDialog(this, "B???n c?? ch??c ch???n in h??a ????n?");
//			String chon = o.toString();
//			if(chon.equalsIgnoreCase("0")) {
//				if(kiemTraNhapKhachHangThuocKeDon()) {
//					themHoaDonVaChiTietHoaDonKeDon();
//				}
//				else if(radKhongKeDon.isSelected() && txtSdt.getText().equalsIgnoreCase("")==false) {
//					themHoaDonVaChiTietHoaDonKeDon();
//				}
//				else if(radKhongKeDon.isSelected() && txtSdt.getText().equalsIgnoreCase("")) {
//					themHoaDonVaChiTietHoaDonKhongKeDon();
//				}
//			}
//		}
//		else if(obj.equals(btnXoa)) {
//			try {
//				int row = table.getSelectedRow();
//				if(row != -1) {
//					tablemodel.removeRow(row);
//					i--;
//					//
//					if(kiemTraThuocKeDon()==false) {
//						radKhongKeDon.setSelected(true);
//						radKeDon.setSelected(false);
//						lblThongBao.setText("");
//					}
//					//
//					double tongTien =0;
//					List data = tablemodel.getDataVector();
//					Object[] list1 = data.toArray();
//					for(int k=0;k<list1.length;k++) {
//						double tong =Double.parseDouble(tablemodel.getValueAt(k, 9).toString());
//						tongTien += tong;
//					}
//					txtTongTienThuoc.setText(String.valueOf(tongTien));
//				}
//
//			} catch (Exception e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}
//		else if(obj.equals(cboGiamGia1)) {
//			DecimalFormat tien = new DecimalFormat("#,##0.00");
//			double tongTien =Double.parseDouble(txtTongTienThuoc.getText());
//			int giamGia1 =Integer.parseInt(cboGiamGia1.getSelectedItem().toString());
//			if(giamGia1==0) {
//				tongThanhToan = (float) (tongTien + (tongTien*(0.05)));
//				txtTongThanhToan.setText(tien.format(tongThanhToan)+" VN??");
//			}
//			else if(giamGia1!=0) {
//				tongThanhToan = (float) ((tongTien - (tongTien*giamGia1/100)) + ((tongTien - (tongTien*giamGia1/100))*(0.05))) ;
//				txtTongThanhToan.setText(tien.format(tongThanhToan)+" VN??");
//			}
//
//		}
//		else if(obj.equals(btnThemHoaDon)) {
//			tablemodel.addRow(new Object[] {
//
//			});
//			tablemodel = (DefaultTableModel) table.getModel();
//			tablemodel.getDataVector().removeAllElements();
//			btnInHd.setEnabled(true);
//			radKeDon.setSelected(false);
//			radKhongKeDon.setSelected(false);
//			xoaTrangTxt();
//			frmXuatHD.lblMaNV.setText("");
//			frmXuatHD.lblLoaiHD1.setText("");
//			frmXuatHD.lblNgayLap1.setText("");
//			frmXuatHD.lblTenKH1.setText("");
//			frmXuatHD.lblGioiTinh.setText("");
//			frmXuatHD.lblDCKH1.setText("");
//			frmXuatHD.lblNamSinh1.setText("");
//			frmXuatHD.lblsdtkh1.setText("");
//			frmXuatHD.lblTongTThuoc.setText("");
//			frmXuatHD.lblTongT.setText("");
//			frmXuatHD.lblNguoiBan.setText("");
//			frmXuatHD.lblNguoiMuaHang1.setText("");
//			frmXuatHD.tableModel.addRow(new Object[] {
//
//			});
//			frmXuatHD.tableModel = (DefaultTableModel) frmXuatHD.table.getModel();
//			frmXuatHD.tableModel.getDataVector().removeAllElements();
//			i=0;
//			txtTongTienThuoc.setText("");
//			txtTongThanhToan.setText("");
//			setLoaiThuoc = "";
//		}
//		else if(obj.equals(mntmSoLuong)) {
//			boolean check = true;
//			int row = table.getSelectedRow();
//			int maThuoc = (int) table.getValueAt(row, 1);
//			while(check) {
//				try {
//					String soLuongThuocObj = JOptionPane.showInputDialog("Nh???p s??? l?????ng thu???c mua.",JOptionPane.YES_NO_CANCEL_OPTION);
//					if(soLuongThuocObj == null) {
//						check = false;
//					}
//					else if(soLuongThuocObj != null) {
//						if(soLuongThuocObj.matches("^[0-9]+$")) {
//							int soLuongThuocMoi = Integer.parseInt(soLuongThuocObj.toString());
//							int soLuongThuocCu = Integer.parseInt(table.getValueAt(row, 7).toString());
//							if((lapHoaDonDAO.soLuongThuocDaBan(maThuoc) + (soLuongThuocMoi+soLuongThuocCu)) <= lapHoaDonDAO.soLuongNhap(maThuoc)) {
//
//								int soLuongThuocCuMoi = soLuongThuocMoi + soLuongThuocCu;
//								table.setValueAt(soLuongThuocCuMoi, row, 7);
//
//								check = false;
//							}
//							else
//								JOptionPane.showMessageDialog(this, "S??? L?????ng Thu???c C???n Mua V?????t Gi???i H???n Thu???c Trong Kho!\n Nh???p S??? L?????ng ??t H??n "+(lapHoaDonDAO.soLuongNhap(maThuoc)-(lapHoaDonDAO.soLuongThuocDaBan(maThuoc)+soLuongThuocCu)));
//						}
//						else {
//							JOptionPane.showMessageDialog(null, "S??? L?????ng Ph???i Nh???p B???ng Ch???!");
//							check = true;
//						}
//					}
//				} catch (NullPointerException e2) {
//					// TODO: handle exception
//
//				}catch (NumberFormatException e3) {
//					// TODO: handle exception
//					e3.printStackTrace();
//					JOptionPane.showMessageDialog(null, "S??? L?????ng Nh???p Qu?? L???n!");
//					check = true;
//				}catch (ArrayIndexOutOfBoundsException e4) {
//					// TODO: handle exception
//					JOptionPane.showMessageDialog(this, "Ch???n V??o Thu???c C???n Th??m S??? L?????ng!");
//				}
//			}
//		}
//		else if(obj.equals(mntmXoa)) {
//			try {
//				int row = table.getSelectedRow();
//				if(row != -1) {
//					tablemodel.removeRow(row);
//					i--;
//					//
//					if(kiemTraThuocKeDon()==false) {
//						radKhongKeDon.setSelected(true);
//						radKeDon.setSelected(false);
//						lblThongBao.setText("");
//					}
//					//
//					double tongTien =0;
//					List data = tablemodel.getDataVector();
//					Object[] list1 = data.toArray();
//					for(int k=0;k<list1.length;k++) {
//						double tong =Double.parseDouble(tablemodel.getValueAt(k, 9).toString());
//						tongTien += tong;
//					}
//					txtTongTienThuoc.setText(String.valueOf(tongTien));
//				}
//
//			} catch (Exception e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}
//
//	}
//	public static  void updateTongTien() {
//		DecimalFormat tien = new DecimalFormat("#,##0.00");
//		int soLuong=0;
//		double donGia=0;
//		double thanhTien=0 ;
//
//		double tongTien =0;
//		int giamGia1 =Integer.parseInt(cboGiamGia1.getSelectedItem().toString());
//		List data = tablemodel.getDataVector();
//		Object[] list1 = data.toArray();
//		for(int k=0;k<list1.length;k++) {
//			double tong =Double.parseDouble(tablemodel.getValueAt(k, 9).toString());
//			tongTien += tong;
//		}
//		txtTongTienThuoc.setText(String.valueOf(tongTien));
//		if(giamGia1==0) {
//			tongThanhToan = (float) (tongTien + (tongTien*(0.05)));
//
//			txtTongThanhToan.setText(tien.format(tongThanhToan)+" VN??");
//		}
//		else if(giamGia1!=0) {
//			tongThanhToan = (float) ((tongTien - (tongTien*giamGia1/100)) + ((tongTien - (tongTien*giamGia1/100))*(0.05))) ;
//			txtTongThanhToan.setText(tien.format(tongThanhToan)+" VN??");
//		}
//
//	}


	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		DecimalFormat tien = new DecimalFormat("#,##0.00");
		int row = e.getFirstRow();
		int col = e.getColumn();
		int soLuong=0;
		double donGia=0;
		double thanhTien=0 ;


		try {
			int giamGia = Integer.parseInt( tablemodel.getValueAt(row,8).toString());
			if((col==7 || col==8) && giamGia==0) {
				soLuong =Integer.parseInt( tablemodel.getValueAt(row,7).toString());
				donGia = Double.parseDouble( tablemodel.getValueAt(row,6).toString());
				thanhTien = soLuong*donGia;
				tablemodel.setValueAt(thanhTien, row, 9);

			}
			else if((col==7 || col==8) && giamGia!=0){
				soLuong =Integer.parseInt( tablemodel.getValueAt(row,7).toString());
				donGia = Double.parseDouble( tablemodel.getValueAt(row,6).toString());
				thanhTien = soLuong*donGia -(soLuong*donGia*giamGia/100);
				tablemodel.setValueAt(thanhTien, row, 9);
			}
			else if(col==9) {
				double tongTien =0;
				int giamGia1 =Integer.parseInt(cboGiamGia1.getSelectedItem().toString());
				List data = tablemodel.getDataVector();
				Object[] list1 = data.toArray();
				for(int k=0;k<list1.length;k++) {
					double tong =Double.parseDouble(tablemodel.getValueAt(k, 9).toString());
					tongTien += tong;
				}
				txtTongTienThuoc.setText(String.valueOf(tongTien));
				if(giamGia1==0) {
					tongThanhToan = (float) (tongTien + (tongTien*(0.05)));

					txtTongThanhToan.setText(tien.format(tongThanhToan)+" VN??");
				}
				else if(giamGia1!=0) {
					tongThanhToan = (float) ((tongTien - (tongTien*giamGia1/100)) + ((tongTien - (tongTien*giamGia1/100))*(0.05))) ;
					txtTongThanhToan.setText(tien.format(tongThanhToan)+" VN??");
				}

			}
		} catch (Exception e2) {
			// TODO: handle exception
			//			table.setRowSelectionInterval(row, row);
			//	JOptionPane.showMessageDialog(this, "S??? l?????ng ph???i nh???p s??? !");

		}

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new FrmPhanCongLaoDong().setVisible(true);
	}
}

