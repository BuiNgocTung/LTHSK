package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.Label;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import com.toedter.components.JSpinField;

//import dao.HoaDonDAO;
//import entities.ChiTietHoaDon;
//import entities.HoaDon;

import javax.swing.SpinnerNumberModel;

public class FrmXemPhanCong extends JFrame {

	public static JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtNgayKC;
	private JTextField txtNgayDKHT,txtTenCT,txtDiaDiem;
	private JTable tblHoaDon;
	private JTextField txtNVLap;
	private JTable tblChiTiet;
	private DefaultTableModel tblModelHoaDon = new DefaultTableModel();
	private DefaultTableModel tblModelChiTiet = new DefaultTableModel();
	//private HoaDonDAO dao= new HoaDonDAO();
	private JTextField txtNgayCPXD;
	private JComboBox cmbTim;
	private JRadioButton radMaCT,radTenCongTrinh,radNgayKC,radNgayDKHT;
	private DefaultComboBoxModel cboModetenKH= new DefaultComboBoxModel();
	private List<String> listtenKH = new ArrayList<String>();
	private DefaultComboBoxModel cboModetenNV= new DefaultComboBoxModel();
	private List<String> listtenNV = new ArrayList<String>();
	private DefaultComboBoxModel cboModema= new DefaultComboBoxModel();
	private List<String> listma = new ArrayList<String>();
	private DefaultComboBoxModel cboModeNgayLap= new DefaultComboBoxModel();
	private List<String> listNgayLap = new ArrayList<String>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmXemPhanCong frame = new FrmXemPhanCong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmXemPhanCong() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("Hinh\\pm.png"));
		setType(Type.POPUP);
		setResizable(false);
		setForeground(new Color(176, 224, 230));
		setBackground(new Color(176, 224, 230));
		setTitle("Ph???n m???m qu???n l?? ph??n c??ng lao ?????ng c??ng ty Thi??n T??m");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 662);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlThongTinCT = new JPanel();
		pnlThongTinCT.setBackground(new Color(176, 224, 230));
		pnlThongTinCT.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th??ng tin c??ng tr??nh",
						TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 0, 0)));
		pnlThongTinCT.setBounds(10, 75, 643, 208);
		contentPane.add(pnlThongTinCT);
		pnlThongTinCT.setLayout(null);

		JLabel lblMCT = new JLabel("M?? C??ng Tr??nh :");
		lblMCT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMCT.setBounds(10, 22, 200, 20);
		pnlThongTinCT.add(lblMCT);

		txtMa = new JTextField();
		txtMa.setEnabled(false);
		txtMa.setBounds(220, 22, 150, 30);
		pnlThongTinCT.add(txtMa);
		txtMa.setColumns(10);
		
		JLabel lblTenCT = new JLabel("T??n CT:");
		lblTenCT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenCT.setBounds(380, 22, 200, 20);
		pnlThongTinCT.add(lblTenCT);

		txtTenCT = new JTextField();
		txtTenCT.setBounds(450, 22, 190, 30);
		pnlThongTinCT.add(txtTenCT);
		txtTenCT.setColumns(10);
		

		JLabel lblNgayCPXD = new JLabel("Ng??y c???p ph??p x??y d???ng:");
		lblNgayCPXD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgayCPXD.setBounds(10, 58, 200, 30);
		pnlThongTinCT.add(lblNgayCPXD);
		
		txtNgayCPXD = new JTextField();
		txtNgayCPXD.setColumns(10);
		txtNgayCPXD.setBounds(220, 58, 150, 30);
		pnlThongTinCT.add(txtNgayCPXD);
		
		JLabel lblDiaDiem = new JLabel("????i???m:");
		lblDiaDiem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDiaDiem.setBounds(380, 58, 200, 20);
		pnlThongTinCT.add(lblDiaDiem);

		txtDiaDiem = new JTextField();
		txtDiaDiem.setBounds(450, 58, 190, 30);
		pnlThongTinCT.add(txtDiaDiem);
		txtDiaDiem.setColumns(10);
		
		JLabel lblNgayKC = new JLabel("Ng??y kh???i c??ng:");
		lblNgayKC.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgayKC.setBounds(10, 98, 200, 30);
		pnlThongTinCT.add(lblNgayKC);
		
		txtNgayKC = new JTextField();
		txtNgayKC.setBounds(220, 98, 420, 30);
		pnlThongTinCT.add(txtNgayKC);
		txtNgayKC.setColumns(10);
		

		

		JLabel lblNgayDKHT = new JLabel("Ng??y d??? ki???n HT :");
		lblNgayDKHT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgayDKHT.setBounds(10, 132, 200, 30);
       	pnlThongTinCT.add(lblNgayDKHT);

		
       	txtNgayDKHT = new JTextField();
		txtNgayDKHT.setBounds(220, 132, 420, 30);
		pnlThongTinCT.add(txtNgayDKHT);
		txtNgayDKHT.setColumns(10);
		
		
		JLabel lblNVLap = new JLabel("Nh??n vi??n l???p:");
		lblNVLap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNVLap.setBounds(10, 167, 200, 30);
		pnlThongTinCT.add(lblNVLap);
		
		txtNVLap = new JTextField();
		txtNVLap.setColumns(10);
		txtNVLap.setBounds(220, 165, 420, 30);
		pnlThongTinCT.add(txtNVLap);
		
		

		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(176, 224, 230));
		pnlChucNang.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "C??c ch???c n??ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		pnlChucNang.setBounds(10, 476, 1270, 150);
		contentPane.add(pnlChucNang);
		pnlChucNang.setLayout(null);
		ImageIcon iconAdd = new ImageIcon("Hinh/add.png");
		ImageIcon iconDelete = new ImageIcon("Hinh/delete.png");
		ImageIcon iconUpdate = new ImageIcon("Hinh/update.png");
		ImageIcon iconSearch = new ImageIcon("Hinh/search.png");
		ImageIcon iconSave = new ImageIcon("Hinh/save.png");
		ImageIcon iconExit = new ImageIcon("Hinh/exit.png");
		ImageIcon iconExcel = new ImageIcon("Hinh/excel.png");

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(176, 224, 230));
		pnlTimKiem.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"T??m ki???m c??ng tr??nh", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(255, 0, 0)));
		pnlTimKiem.setBounds(12, 13, 1265, 96);
		pnlChucNang.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		JButton btnTimKiem = new JButton("T??m ki???m");
		btnTimKiem.setBounds(979, 21, 136, 30);
		pnlTimKiem.add(btnTimKiem);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnTimKiem.setIcon(iconSearch);

		JLabel lblNhpThngTin = new JLabel("Nh???p th??ng tin t??m ki???m:");
		lblNhpThngTin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNhpThngTin.setBounds(20, 18, 162, 30);
		pnlTimKiem.add(lblNhpThngTin);

		JLabel lblTmTheo = new JLabel("T??m theo:");
		lblTmTheo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTmTheo.setBounds(20, 61, 63, 30);
		pnlTimKiem.add(lblTmTheo);

		radTenCongTrinh = new JRadioButton("T??n c??ng tr??nh ");
		radTenCongTrinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radTenCongTrinh.setBounds(401, 60, 207, 29);
		pnlTimKiem.add(radTenCongTrinh);

		radNgayDKHT = new JRadioButton("Ng??y d??? ki???n ho??n th??nh");
		radNgayDKHT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radNgayDKHT.setBounds(841, 60, 207, 29);
		pnlTimKiem.add(radNgayDKHT);
		
				radMaCT = new JRadioButton("M?? C??ng Tr??nh");
				radMaCT.setBounds(174, 59, 207, 30);
				pnlTimKiem.add(radMaCT);
				radMaCT.setFont(new Font("Tahoma", Font.PLAIN, 15));
				radMaCT.setSelected(true);
				
				radNgayKC = new JRadioButton("Ng??y kh???i c??ng");
				radNgayKC.setFont(new Font("Tahoma", Font.PLAIN, 15));
				radNgayKC.setBounds(617, 60, 207, 29);
				pnlTimKiem.add(radNgayKC);

		JButton btnThoat = new JButton("Tho??t");
		btnThoat.setBackground(Color.LIGHT_GRAY);
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon iconThoat = new ImageIcon("Hinh/exit.png");
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnThoat.setBounds(1124, 112, 136, 30);
		pnlChucNang.add(btnThoat);

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlTitle.setBackground(new Color(176, 224, 230));
		pnlTitle.setBounds(0, 0, 1300, 68);
		contentPane.add(pnlTitle);
		pnlTitle.setLayout(null);

		JLabel lblQunLNhn = new JLabel("XEM PH??N C??NG");
		lblQunLNhn.setForeground(Color.RED);
		lblQunLNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLNhn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblQunLNhn.setBounds(10, 11, 1278, 53);
		pnlTitle.add(lblQunLNhn);

		JPanel pnlHoaDon = new JPanel();
		pnlHoaDon.setLayout(null);
		pnlHoaDon.setForeground(Color.BLACK);
		pnlHoaDon.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Danh s??ch c??ng tr??nh", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		pnlHoaDon.setBackground(new Color(176, 224, 230));
		pnlHoaDon.setBounds(10, 290, 1270, 187);
		contentPane.add(pnlHoaDon);

		JScrollPane scrHoaDon = new JScrollPane();
		scrHoaDon.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrHoaDon.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrHoaDon.setBounds(12, 22, 1250, 154);
		pnlHoaDon.add(scrHoaDon);
		String[] col= {"STT", "M?? c??ng tr??nh","T??n c??ng tr??nh" ,"??ia ??i???m","Ng??y c???p ph??p x??y d???ng","Ng??y kh???i c??ng" ,"Ng??y d??? ki???n ho??n th??nh", "Nh??n vi??n l???p"};
		tblModelHoaDon = new DefaultTableModel(col,0);
		tblHoaDon = new JTable(tblModelHoaDon);
		
		scrHoaDon.setViewportView(tblHoaDon);

		JPanel pnlChiTiet = new JPanel();
		pnlChiTiet.setBackground(new Color(176, 224, 230));
		pnlChiTiet.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Th??ng tin chi ti???t c??ng tr??nh", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(255, 0, 0)));
		pnlChiTiet.setBounds(664, 75, 618, 208);
		contentPane.add(pnlChiTiet);
		pnlChiTiet.setLayout(null);
		
		JScrollPane scrChiTiet = new JScrollPane();
		scrChiTiet.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrChiTiet.setBounds(10, 21, 596, 176);
		pnlChiTiet.add(scrChiTiet);
		String[] col2= {
				"STT", "M?? NV", "H???", "T??n","Ng??y sinh", "SDT","S??? ng??y c??ng"
		};
		tblModelChiTiet = new DefaultTableModel(col2, 0);
		tblChiTiet = new JTable(tblModelChiTiet);
		scrChiTiet.setViewportView(tblChiTiet);
		ButtonGroup group = new ButtonGroup();
		group.add(radMaCT);
		group.add(radNgayDKHT);
		group.add(radNgayKC);
		group.add(radTenCongTrinh);
		
		cmbTim = new JComboBox();
		cmbTim.setBounds(184, 22, 771, 22);
		pnlTimKiem.add(cmbTim);
		
		JButton btnLamMoi = new JButton("L??m m???i");
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		btnLamMoi.setHorizontalAlignment(SwingConstants.LEFT);
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnLamMoi.setBounds(543, 112, 136, 30);
		pnlChucNang.add(btnLamMoi);
		
		//docDuLieuHD();
		tblHoaDon.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				cilckMouse();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnLamMoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lamMoi();
			//	docDuLieuHD();
			}
		});
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TimKiem();
			}
		});
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FrmManHinhChinh.tabbedPane.remove(contentPane);
			}
		});
		radMaCT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cmbTim.setModel(cboModema);
			}
		});
		radTenCongTrinh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cmbTim.setModel(cboModetenKH);
			}
		});
		radNgayKC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cmbTim.setModel(cboModetenNV);
			}
		});
		radNgayDKHT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cmbTim.setModel(cboModeNgayLap);
			}
		});
		//docDuLieuCmb();
	}
//	public void docDuLieuHD() {
//		int d=1;
//		List<HoaDon> list = dao.getHoaDons();
//		for(HoaDon x : list) {
//			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//			String nhanVien= dao.getTenNV(x.getNhanVien());
//			String khachHang= dao.getTenKH(x.getKhachHang());
//			tblModelHoaDon.addRow(new Object[] {
//					d++,x.getMa(),df.format(x.getNgayLap()),x.getTongTien(),khachHang,nhanVien
//			});
//			
//		}
//	}
//	/**
//	 * D??ng ?????c d??? li???u t??? c?? s??? d??? li???u l??n b???ng
//	 */
//	public void docDuLieuCmb() {
//		int d=1;
//		List<HoaDon> list = dao.getHoaDons();
//		for(HoaDon x : list) {
//			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//			String nhanVien= dao.getTenNV(x.getNhanVien());
//			String khachHang= dao.getTenKH(x.getKhachHang());
//			if(listtenKH.contains(khachHang)==false) {
//				cboModetenKH.addElement(khachHang);	
//				listtenKH.add(khachHang);
//			}
//			if(listtenNV.contains(nhanVien)==false) {
//				cboModetenNV.addElement(nhanVien);	
//				listtenNV.add(nhanVien);
//			}
//			if(listma.contains(x.getMa())==false) {
//				cboModema.addElement(x.getMa());	
//				listma.add(x.getMa());
//			}
//			if(listNgayLap.contains(df.format(x.getNgayLap()))==false) {
//				cboModeNgayLap.addElement(df.format(x.getNgayLap()));	
//				listNgayLap.add(df.format(x.getNgayLap()));
//			}
//		}
//	}
	/**
	 * X??a d??? li??u b???ng chi ti???t
	 */
	public void xoaTableChiTiet() {
		tblModelChiTiet.addRow(new Object[] {
				
		});
		DefaultTableModel tblModel1 = (DefaultTableModel) tblChiTiet.getModel();
		tblModel1.getDataVector().removeAllElements();	
	}
	/**
	 * X??a d??? li???u b???ng h??a ????n
	 */
	public void xoaTableHoaDon() {
		tblModelHoaDon.addRow(new Object[] {
				
		});
		DefaultTableModel tblModel2 = (DefaultTableModel) tblHoaDon.getModel();
		tblModel2.getDataVector().removeAllElements();	
	}
	/**
	 * l??m m???i l???i giao di???n
	 */
	public void lamMoi() {
		txtMa.setText("");
		txtNgayCPXD.setText("");
		txtNgayDKHT.setText("");
		txtNgayKC.setText("");
		txtNVLap.setText("");
		xoaTableChiTiet();
		xoaTableHoaDon();
		
	}
	/**
	 * b???t s??? ki???n chu???t trong b???ng ????a d??? li???u t??? b???ng l??n c??c text
	 */
	public void cilckMouse() {
//		int d=1;
//		int row= tblHoaDon.getSelectedRow();
//		txtMa.setText(tblHoaDon.getValueAt(row, 1).toString());
//		txtNgayCPXD.setText(tblHoaDon.getValueAt(row, 2).toString());
//		txtNgayDKHT.setText(tblHoaDon.getValueAt(row, 5).toString());
//		txtNgayKC.setText(tblHoaDon.getValueAt(row, 4).toString());
//		txtNVLap.setText(tblHoaDon.getValueAt(row, 3).toString());
//		List<ChiTietHoaDon> list = dao.getChiTiets(tblHoaDon.getValueAt(row, 1).toString());
//		xoaTableChiTiet();
//		for(ChiTietHoaDon ct : list) {
//			String thuoc = dao.gettenThuoc(ct.getMaThuoc());
//			double tongTien= ct.getDonGia()*ct.getSoLuong()-ct.getGiamGia();
//			tblModelChiTiet.addRow(new Object[] {
//					d++,thuoc,ct.getDonViTinh(),ct.getDonGia(),ct.getSoLuong(),ct.getGiamGia(),tongTien
//			});
//		}
	}
	/**
	 * D??ng ????? t??m ki???m d??? li???u
	 */
	public void TimKiem() {
//		if(radMaCT.isSelected()) {
//			int d=1;
//			String ma= cmbTim.getSelectedItem().toString();
//			HoaDon hd= dao.getHoaDonByMa(ma);
//			lamMoi();
//			String nhanVien= dao.getTenNV(hd.getNhanVien());
//			String khachHang= dao.getTenKH(hd.getKhachHang());
//			tblModelHoaDon.addRow(new Object[] {
//					d,hd.getMa(),hd.getNgayLap(),hd.getTongTien(),khachHang,nhanVien
//			});
//		}
//		if(radTenCongTrinh.isSelected()) {
//			int d=1;
//			String ten= cmbTim.getSelectedItem().toString();
//			List<HoaDon> hds= dao.getHoaDonsByKhachHang(ten);
//			lamMoi();
//			for(HoaDon hd: hds) {
//				String nhanVien= dao.getTenNV(hd.getNhanVien());
//				String khachHang= dao.getTenKH(hd.getKhachHang());
//				tblModelHoaDon.addRow(new Object[] {
//						d++,hd.getMa(),hd.getNgayLap(),hd.getTongTien(),khachHang,nhanVien
//				});
//			}
//			
//		}
//		if(radNgayKC.isSelected()) {
//			int d=1;
//			String ten= cmbTim.getSelectedItem().toString();
//			System.out.println(ten);
//			List<HoaDon> hds= dao.getHoaDonsByNhanVien(ten);
//			lamMoi();
//			for(HoaDon hd: hds) {
//				String nhanVien= dao.getTenNV(hd.getNhanVien());
//				String khachHang= dao.getTenKH(hd.getKhachHang());
//				tblModelHoaDon.addRow(new Object[] {
//						d++,hd.getMa(),hd.getNgayLap(),hd.getTongTien(),khachHang,nhanVien
//				});
//			}
//		}
//		if(radNgayDKHT.isSelected()) {
//			int d=1;
//			String nl= cmbTim.getSelectedItem().toString();
//			String[] ngaylap = nl.split("-");
//			int ngay = Integer.parseInt(ngaylap[0]);
//			int thang = Integer.parseInt(ngaylap[1]);
//			int nam = Integer.parseInt(ngaylap[2]);
//			
//			List<HoaDon> hds= dao.getHoaDonsByNgayLap(ngay, thang, nam);
//			lamMoi();
//			for(HoaDon hd: hds) {
//				String nhanVien= dao.getTenNV(hd.getNhanVien());
//				String khachHang= dao.getTenKH(hd.getKhachHang());
//				tblModelHoaDon.addRow(new Object[] {
//						d++,hd.getMa(),hd.getNgayLap(),hd.getTongTien(),khachHang,nhanVien
//				});
//			}
//		}
//		
	}
}
