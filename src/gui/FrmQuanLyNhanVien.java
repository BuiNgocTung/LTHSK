package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;


//import dao.NhanVienDAO;
import entities.DiaChi;
import entities.NhanVien;
import entities.TaiKhoan;

import java.awt.SystemColor;

public class FrmQuanLyNhanVien extends JFrame{ //implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5201032984984305728L;
	private JTextField txtTimKiem;
	private JTextField txtMaNV;
	private static JTextField txtHo;
	private static JTextField txtTen;
	private static JTextField txtSoDT;
	public static JTextField txtMaDiaChi;
	private static JTextField txtCMND;
	public static JTextField txtTenTK;
	private static DefaultTableModel model;
	private static JTable table;
	private JButton btnTimKiem;
	public static JPanel pnlTabQLNV;
	private JRadioButton radMa;
	private JRadioButton radTen;
	private JRadioButton radSoDT;
	private JRadioButton radCaLamViec;
	public static JButton btnThem;
	private JButton btnXoa;
	private JButton btnThoat;
	private JButton btnXoaRong;
	private JButton btnCapNhat;
	private JButton btnLamMoi;
	@SuppressWarnings("rawtypes")
	private static JComboBox cboGioiTinh;
	@SuppressWarnings("rawtypes")
	private static JComboBox cboMaPBan;
	@SuppressWarnings("rawtypes")
	private JComboBox cboTrangThai;
	@SuppressWarnings("rawtypes")
	private static JComboBox cboLoaiNV;
	private static JDateChooser dateChooser;
	public static boolean check = false;
//	static NhanVienDAO nvDao = new NhanVienDAO();
//	FrmThemTaiKhoan frmThemTaiKhoan = new FrmThemTaiKhoan();
//	FrmThemDiaChi frmThemDiaChi = new FrmThemDiaChi();
	public static JTextField txtDiaChi;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FrmQuanLyNhanVien() {
		pnlTabQLNV = new JPanel();
		pnlTabQLNV.setLayout(null);
		ButtonGroup buttonGroup = new ButtonGroup();

		/**
		 * Thoat tab quan ly nhan vien
		 */

		String[] tb = new String[] { "STT", "M?? NV", "H???", "T??n", "Ng??y sinh", "Gi???i t??nh", "CMND", "S??? ??T",
				"M?? ph??ng ban", "M?? ?????a ch???", "T??n TK", "Lo???i NV", "Tr???ng th??i" };
		model = new DefaultTableModel(tb, 0);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1317, 642);
		pnlTabQLNV.add(panel);
		panel.setLayout(null);

		JLabel lblMaNV = new JLabel("M?? NV:");
		lblMaNV.setBounds(25, 73, 50, 25);
		panel.add(lblMaNV);
		lblMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMaNV.setBounds(103, 73, 185, 25);
		panel.add(txtMaNV);
		txtMaNV.setToolTipText("Nh???p m?? nh??n vi??n");
		txtMaNV.setColumns(10);

		txtMaNV.setEditable(false);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCMND.setBounds(452, 109, 185, 25);
		panel.add(txtCMND);
		txtCMND.setEditable(false);
		txtCMND.setToolTipText("Nh???p ch???ng minh nh??n d??n");
		txtCMND.setColumns(10);
		txtCMND.setEditable(true);
		txtCMND.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});

		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setBounds(375, 109, 50, 25);
		panel.add(lblCMND);
		lblCMND.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		JLabel lblTenTK = new JLabel("T??n TK:");
		lblTenTK.setBounds(682, 147, 84, 25);
		panel.add(lblTenTK);
		lblTenTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		JLabel lblHo = new JLabel("H???:");
		lblHo.setBounds(375, 73, 24, 25);
		panel.add(lblHo);
		lblHo.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		txtHo = new JTextField();
		txtHo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtHo.setBounds(452, 73, 185, 25);
		panel.add(txtHo);
		txtHo.setEditable(false);
		txtHo.setToolTipText("Nh???p h???");
		txtHo.setColumns(10);

		txtHo.setEditable(true);

		txtTenTK = new JTextField();
		txtTenTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTenTK.setBounds(775, 147, 185, 25);
		panel.add(txtTenTK);
		txtTenTK.setEditable(false);
		txtTenTK.setColumns(10);

		JLabel lblLoaiNV = new JLabel("Lo???i NV:");
		lblLoaiNV.setBounds(1000, 109, 73, 25);
		panel.add(lblLoaiNV);
		lblLoaiNV.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		JLabel lblTen = new JLabel("T??n:");
		lblTen.setBounds(682, 75, 53, 25);
		panel.add(lblTen);
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTen.setBounds(775, 75, 185, 25);
		panel.add(txtTen);
		txtTen.setEditable(false);
		txtTen.setToolTipText("Nh???p t??n");
		txtTen.setColumns(10);
		txtTen.setEditable(true);

		cboLoaiNV = new JComboBox<String>();
		cboLoaiNV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboLoaiNV.setBounds(1101, 109, 185, 25);
		panel.add(cboLoaiNV);
		cboLoaiNV.setToolTipText("Ch???n lo???i nh??n vi??n");
		cboLoaiNV.addItem("Nh??n vi??n");
		cboLoaiNV.addItem("Qu???n l??");

		JLabel lblNgaySinh = new JLabel("Ng??y sinh:");
		lblNgaySinh.setBounds(1000, 73, 73, 25);
		panel.add(lblNgaySinh);
		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		dateChooser = new JDateChooser();
		dateChooser.setBounds(1101, 73, 185, 25);
		panel.add(dateChooser);
		dateChooser.getCalendarButton().setEnabled(false);
		dateChooser.setLocale(Locale.forLanguageTag("vi-VN"));
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.getCalendarButton().setEnabled(true);

		txtMaDiaChi = new JTextField();
		txtMaDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMaDiaChi.setBounds(1101, 147, 185, 25);
		panel.add(txtMaDiaChi);
		txtMaDiaChi.setEditable(false);
		txtMaDiaChi.setToolTipText("Nh???p ?????a ch???");
		txtMaDiaChi.setColumns(10);

		JLabel lblMaDiaChi = new JLabel("M?? ?????a ch???:");
		lblMaDiaChi.setBounds(1000, 147, 80, 25);
		panel.add(lblMaDiaChi);
		lblMaDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		JLabel lblGioiTinh = new JLabel("Gi???i t??nh:");
		lblGioiTinh.setBounds(682, 111, 84, 25);
		panel.add(lblGioiTinh);
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		JLabel lblTrangThai = new JLabel("Tr???ng th??i:");
		lblTrangThai.setBounds(375, 145, 73, 25);
		panel.add(lblTrangThai);
		lblTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		cboTrangThai = new JComboBox();
		cboTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboTrangThai.setBounds(452, 145, 185, 25);
		panel.add(cboTrangThai);
		cboTrangThai.addItem("??ang l??m vi???c");
		cboTrangThai.addItem("Ngh??? vi???c");
		cboTrangThai.addItem("T???m ngh??? vi???c");

		cboGioiTinh = new JComboBox<String>();
		cboGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboGioiTinh.setBounds(775, 111, 185, 25);
		panel.add(cboGioiTinh);
		cboGioiTinh.setToolTipText("Ch???n gi???i t??nh");
		cboGioiTinh.addItem("Nam");
		cboGioiTinh.addItem("N???");
		cboGioiTinh.addItem("Kh??c");

		JLabel lblSoDT = new JLabel("S??? ??T:");
		lblSoDT.setBounds(25, 109, 50, 25);
		panel.add(lblSoDT);
		lblSoDT.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		txtSoDT = new JTextField();
		txtSoDT.setBounds(103, 109, 185, 25);
		panel.add(txtSoDT);
		txtSoDT.setEditable(false);
		txtSoDT.setToolTipText("Nh???p s??? ??i???n tho???i");
		txtSoDT.setColumns(10);
		txtSoDT.setEditable(true);
		txtSoDT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});

		JLabel lblCaLamViec = new JLabel("M?? PBan:");
		lblCaLamViec.setBounds(25, 147, 84, 25);
		panel.add(lblCaLamViec);
		lblCaLamViec.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		cboMaPBan = new JComboBox<String>();
		cboMaPBan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboMaPBan.setBounds(104, 147, 185, 25);
		panel.add(cboMaPBan);
		cboMaPBan.setToolTipText("Ch???n m?? ph??ng ban");
		cboMaPBan.addItem("PHONG_KTOAN");
		cboMaPBan.addItem("PHONG_KDOANH");
		cboMaPBan.addItem("PHONG_KTHUAT");
		cboMaPBan.addItem("PHONG_TCHUC");
		cboMaPBan.addItem("PHONG_DUAN");
		cboMaPBan.addItem("PHONG_CMON");
		cboMaPBan.addItem("PHONG_PVU");
		JLabel lblTitle = new JLabel("QU???N L?? NH??N VI??N");
		lblTitle.setBounds(512, 11, 278, 38);
		panel.add(lblTitle);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTitle.setForeground(Color.RED);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel pnlDanhSachNhanVien = new JPanel();
		pnlDanhSachNhanVien.setBounds(10, 237, 1297, 257);
		panel.add(pnlDanhSachNhanVien);
		pnlDanhSachNhanVien.setLayout(null);
		pnlDanhSachNhanVien.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachNhanVien.setBackground(SystemColor.control);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 20, 1277, 226);
		pnlDanhSachNhanVien.add(scrollPane);
		table = new JTable(model);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane.setViewportView(table);

		JLabel lblDiaChi = new JLabel("?????a ch???:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDiaChi.setBounds(682, 181, 72, 25);
		panel.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds(775, 182, 509, 25);
		panel.add(txtDiaChi);
		txtDiaChi.setColumns(10);

		btnThem = new JButton("Th??m");
		btnThem.setBounds(103, 196, 120, 30);
		panel.add(btnThem);
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnThem.setIcon(new ImageIcon("Hinh\\add.png"));

		btnXoa = new JButton("X??a");
		btnXoa.setBounds(233, 196, 120, 30);
		panel.add(btnXoa);
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnXoa.setIcon(new ImageIcon("Hinh\\delete.png"));

		btnCapNhat = new JButton("C???p nh???t");
		btnCapNhat.setBounds(363, 196, 120, 30);
		panel.add(btnCapNhat);
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCapNhat.setIcon(new ImageIcon("Hinh\\edit.png"));

		btnXoaRong = new JButton("X??a Tr???ng");
		btnXoaRong.setBounds(493, 196, 131, 30);
		panel.add(btnXoaRong);
		btnXoaRong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnXoaRong.setIcon(new ImageIcon("Hinh\\empty.png"));

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 505, 1297, 114);
		panel.add(panel_3);
		panel_3.setBorder(
				new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setLayout(null);

		JLabel lblTimKiem = new JLabel("Nh???p th??ng tin t??m ki???m:");
		lblTimKiem.setBounds(10, 11, 161, 30);
		panel_3.add(lblTimKiem);
		lblTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblTimTheo = new JLabel("T??m theo:");
		lblTimTheo.setBounds(10, 56, 63, 30);
		panel_3.add(lblTimTheo);
		lblTimTheo.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		radMa = new JRadioButton("M??");
		radMa.setBounds(79, 48, 63, 23);
		panel_3.add(radMa);
		radMa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonGroup.add(radMa);

		radTen = new JRadioButton("T??n");
		radTen.setBounds(79, 74, 63, 23);
		panel_3.add(radTen);
		radTen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonGroup.add(radTen);

		radCaLamViec = new JRadioButton("M?? ph??ng ban");
		radCaLamViec.setBounds(144, 76, 120, 23);
		panel_3.add(radCaLamViec);
		radCaLamViec.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonGroup.add(radCaLamViec);

		radSoDT = new JRadioButton("S??? ??T");
		radSoDT.setBounds(144, 48, 94, 23);
		panel_3.add(radSoDT);
		radSoDT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonGroup.add(radSoDT);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(165, 15, 232, 25);
		panel_3.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		btnTimKiem = new JButton("T??m ki???m");
		btnTimKiem.setBounds(277, 56, 120, 30);
		panel_3.add(btnTimKiem);
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnTimKiem.setIcon(new ImageIcon("Hinh\\search.png"));

		btnLamMoi = new JButton("L??m M???i");
		btnLamMoi.setBounds(407, 56, 120, 30);
		panel_3.add(btnLamMoi);
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLamMoi.setIcon(new ImageIcon("Hinh\\refresh.png"));
		btnThoat = new JButton("Tho??t");
		btnThoat.setBounds(537, 56, 120, 30);
		panel_3.add(btnThoat);
		btnThoat.setForeground(Color.BLACK);
		btnThoat.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnThoat.setIcon(new ImageIcon("Hinh\\close.png"));

		JLabel lblXinChao = new JLabel("Xin ch??o !");
		lblXinChao.setForeground(Color.RED);
		lblXinChao.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblXinChao.setBounds(1028, 44, 84, 22);
		panel.add(lblXinChao);

		JLabel lblTenNV = new JLabel("");
		lblTenNV.setForeground(Color.RED);
		lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTenNV.setBounds(1122, 44, 185, 23);
		panel.add(lblTenNV);

//		String tenNhanVienHienTai = nvDao.getTenNhanVienByTenTaiKhoan(FrmDangNhap.taiKhoan.getTenTaiKhoan());
//		lblTenNV.setText(tenNhanVienHienTai);

//		btnThoat.addActionListener(this);
//		btnLamMoi.addActionListener(this);
//		btnTimKiem.addActionListener(this);
//		btnXoaRong.addActionListener(this);
//
//		btnCapNhat.addActionListener(this);
//		btnXoa.addActionListener(this);
//		btnThem.addActionListener(this);
//		table.addMouseListener(this);

		//docDuLieu();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuanLyNhanVien frame = new FrmQuanLyNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	public static void themNhanVien() {
//		NhanVienDAO nhanVienDAO = new NhanVienDAO();
//		NhanVien nhanVien = new NhanVien();
//		nhanVien.setCaLamViec(cboMaPBan.getSelectedItem().toString());
//		nhanVien.setTen(txtTen.getText().trim());
//		nhanVien.setHo(txtHo.getText().trim());
//
//		Date ngaySinhsql = null;
//		try {
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			String ngaySinhtxt = dateFormat.format(dateChooser.getDate());
//			java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
//			ngaySinhsql = new Date(ngaySinh.getTime());
//		} catch (Exception e2) {
//			e2.printStackTrace();
//		}
//
//		nhanVien.setNgaySinh(ngaySinhsql);
//		nhanVien.setGioiTinh(cboGioiTinh.getSelectedItem().toString());
//		nhanVien.setCmnd(txtCMND.getText().trim());
//		nhanVien.setSoDienThoai(txtSoDT.getText().trim());
//		DiaChi diaChi = new DiaChi();
//		diaChi.setMaDiaChi(Integer.parseInt(txtMaDiaChi.getText()));
//
//		nhanVien.setDiaChi(diaChi);
//		TaiKhoan taiKhoan = new TaiKhoan();
//		taiKhoan.setTenTaiKhoan(txtTenTK.getText());
//		nhanVien.setTaiKhoan(taiKhoan);
//		String loaiNhanVien = cboLoaiNV.getSelectedItem().toString().trim();
//		if (loaiNhanVien.equalsIgnoreCase("Nh??n vi??n")) {
//			nhanVien.setLoaiNhanVien("NV");
//
//		} else {
//			nhanVien.setLoaiNhanVien("QL");
//		}
//		nhanVien.setTrangThai("??ang l??m vi???c");
//		try {
//			nhanVienDAO.themNhanVien(nhanVien);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object obj = e.getSource();
//		/**
//		 * add employee
//		 */
//		if (obj.equals(btnThoat)) {
//			if (JOptionPane.showConfirmDialog(this, "B???n c?? ch???c mu???n tho??t !") == JOptionPane.YES_OPTION) {
//				FrmManHinhChinh.tabbedPane.remove(pnlTabQLNV);
//			}
//		}
//		/**
//		 * btn Them
//		 */
//		else if (obj.equals(btnThem)) {
//			String invalid = "";
//			String ho = txtHo.getText().trim();
//			String ten = txtTen.getText().trim();
//			String sdt = txtSoDT.getText().trim();
//			String cMND = txtCMND.getText().trim();
//			Date ngaySinhsql = null;
//			try {
//
//			} catch (Exception e2) {
//			}
//
//			if (ho.equalsIgnoreCase("")) {
//				invalid += "Vui l??ng nh???p h??? !\n";
//			} else if (ho.length() > 30) {
//				invalid += "H??? kh??ng h???p l??? !\n";
//			}
//			if (ten.equalsIgnoreCase("")) {
//				invalid += "Vui l??ng nh???p t??n !\n";
//			} else if (ten.length() > 10) {
//				invalid += "T??n kh??ng h???p l??? !\n";
//			}
//			try {
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//				String ngaySinhtxt = null;
//				java.util.Date ngaySinh = null;
//				int yearsql = 0;
//				String year = null;
//				try {
//					ngaySinhtxt = dateFormat.format(dateChooser.getDate());
//					ngaySinh = dateFormat.parse(ngaySinhtxt);
//					ngaySinhsql = new Date(ngaySinh.getTime());
//
//					year = ngaySinhsql.toString().substring(0, 4);
//					yearsql = Integer.parseInt(year);
//
//				} catch (Exception e2) {
//					// TODO: handle exception
//				}
//
//				try {
//					if (year == null) {
//						invalid += "Vui l??ng nh???p ng??y sinh !\n";
//					}
//					else if (LocalDate.now().getYear() - yearsql > 60 || LocalDate.now().getYear() - yearsql < 18) {
//						invalid += "Tu???i ph???i t??? 18->60 !\n";
//					} 
//				} catch (Exception e2) {
//					invalid += "Ng??y sinh kh??ng h???p l??? !\n";
//				}
//				
//				
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//			if (sdt.equalsIgnoreCase("")) {
//				invalid += "Vui l??ng nh???p s??? ??i???n tho???i !\n";
//			} else if (!sdt.matches("^0[0-9]{9}$")) {
//				invalid += "S??? ??i???n tho???i kh??ng h???p l??? !(10 s??? v?? b???t l?? 0)\n";
//			}
//			if (cMND.equalsIgnoreCase("")) {
//				invalid += "Vui l??ng nh???p s??? CMND !\n";
//			} else if (!cMND.matches("^[0-9]{9}$")) {
//				invalid += "S??? CMND kh??ng h???p l??? ! (9 s???)\n";
//			}
//			try {
//				if (invalid.equalsIgnoreCase("")) {
//					new FrmThemTaiKhoan().setVisible(true);
//				} else {
//					JOptionPane.showMessageDialog(this, invalid, "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
//							new ImageIcon("Hinh\\warning.png"));
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}




		}
		/**
		 * delete empty
		 */
	//	else if (obj.equals(btnXoaRong)) {
			//xoaRong();
//			try {
//				nvDao.getAllMaNV().forEach(n -> {
//					System.out.println(n);
//				});
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}
		/**
		 * delete employee
		 */
//		else if (obj.equals(btnXoa)) {
//			// =================================
//			// delete 1 row selected old
//			int row = table.getSelectedRow();
//			if (row == -1) {
//				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n nh??n vi??n c???n x??a !", "Th??ng b??o !",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//			} else {
//				try {
//					String tenNhanVienHienTai = nvDao
//							.getTenNhanVienByTenTaiKhoan(FrmDangNhap.taiKhoan.getTenTaiKhoan());
//					String tenNhanVienXoa = (String) table.getValueAt(row, 2) + " " + table.getValueAt(row, 3);
//					if (tenNhanVienHienTai.equalsIgnoreCase(tenNhanVienXoa)) {
//						JOptionPane.showMessageDialog(this, "Nh??n vi??n ??ang ????ng nh???p v??o h??? th???ng.\nKh??ng th??? x??a !",
//								"Th??ng b??o !", JOptionPane.CLOSED_OPTION, new ImageIcon("Hinh\\warning.png"));
//					} else {
//						try {
//							int maNhanVien = Integer.parseInt(txtMaNV.getText());
//							NhanVien nv = nvDao.layThongTinNhanVien(maNhanVien);
//							int yes = JOptionPane.showConfirmDialog(null, "B???n c?? ch???c mu???n x??a !", "Th??ng b??o !",
//									JOptionPane.YES_NO_CANCEL_OPTION);
//							if (yes == JOptionPane.YES_OPTION) {
//								if (nvDao.xoaNhanVien(nv)) {
//									table.setValueAt(nv.getTrangThai(), row, 12);
//									JOptionPane.showMessageDialog(this,
//											"???? x??a !\nNh??n vi??n s??? ???????c c???p nh???t l???i tr???ng th??i \"Ngh??? vi???c\".",
//											"Th??ng b??o !", JOptionPane.CLOSED_OPTION, new ImageIcon("Hinh\\yes.png"));
//									xoaAllDataTable();
//									docDuLieu();
//								}
//							}
//						} catch (Exception e2) {
//							e2.printStackTrace();
//							JOptionPane.showMessageDialog(this, "X??a th???t b???i !", "Th??ng b??o !",
//									JOptionPane.CLOSED_OPTION, new ImageIcon("Hinh\\warning.png"));
//						}
//					}
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//
//			}
			// ========================

			// =======================
			// delete rows selected sai sai sai
			//			int rows[] = new int[100000];
			//			rows = table.getSelectedRows();
			////			int numRows = table.getSelectedRows().length;
			////			for(int i=0; i<numRows ; i++ ) {
			////
			//////			    m_tableModel.removeRow(table.getSelectedRow());
			////			}
			//
			//			ListSelectionListener listSelectionListener=new ListSelectionListener() {
			//				
			//				@Override
			//				public void valueChanged(ListSelectionEvent e) {
			//					
			//					
			//				}
			//			};
			//			
			//			for (int i : rows) {
			//				if (nvDao.deleteNhanVien(Integer.parseInt(txtMaNV.getText()), "Ngh??? vi???c")) {
			//					JOptionPane.showMessageDialog(this,
			//							"X??a th??nh c??ng !\n Tr???ng th??i nh??n vi??n s??? ???????c c???p nh???t th??nh \"Ngh??? vi???c\".",
			//							"Th??ng b??o", JOptionPane.CLOSED_OPTION);
			//					table.setValueAt("Ngh??? vi???c", i, 12);
			//				}
			//			}
			////			List<Integer> listMaNV=nvDao.getAllMaNV()->{
			////				
			////			}
			//
			//			if (rows == null) {
			//				JOptionPane.showMessageDialog(this, "C???n ch???n d??ng ????? x??a !", "Th??ng b??o", JOptionPane.ERROR_MESSAGE);
			//			} else {
			//				try {
			//					for (int i : rows) {
			//						if (nvDao.deleteNhanVien(Integer.parseInt(txtMaNV.getText()), "Ngh??? vi???c")) {
			//							JOptionPane.showMessageDialog(this,
			//									"X??a th??nh c??ng !\n Tr???ng th??i nh??n vi??n s??? ???????c c???p nh???t th??nh \"Ngh??? vi???c\".",
			//									"Th??ng b??o", JOptionPane.CLOSED_OPTION);
			//							table.setValueAt("Ngh??? vi???c", i, 12);
			//						}
			//					}
			//				} catch (Exception e1) {
			//					e1.printStackTrace();
			//				}
			//			}
			// ====================

		//}
		/**
		 * Update staff
		 */
//		else if (obj.equals(btnCapNhat)) {
//			try {
//				int row = table.getSelectedRow();
//				if (row >= 0) {
//					Date ngaySinhsql = null;
//					String ngaySinhtxt = "";
//					try {
//						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//						ngaySinhtxt = dateFormat.format(dateChooser.getDate());
//						java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
//						ngaySinhsql = new Date(ngaySinh.getTime());
//					} catch (Exception e2) {
//						e2.printStackTrace();
//					}
//					String loaiNV = cboLoaiNV.getSelectedItem().toString();
//					if (loaiNV.equals("Nh??n vi??n")) {
//						loaiNV = "NV";
//					} else if (loaiNV.equals("Qu???n l??")) {
//						loaiNV = "QL";
//					}
//					if (nvDao.updateNhanVien(Integer.parseInt(txtMaNV.getText()), txtHo.getText(), txtTen.getText(),
//							ngaySinhsql, cboGioiTinh.getSelectedItem().toString(), txtCMND.getText(), txtSoDT.getText(),
//							cboMaPBan.getSelectedItem().toString(), loaiNV,
//							cboTrangThai.getSelectedItem().toString())) {
//						JOptionPane.showMessageDialog(this, "C???p nh???t th??nh c??ng.", "Th??ng b??o",
//								JOptionPane.CLOSED_OPTION, new ImageIcon("Hinh\\yes.png"));
//						table.setValueAt(txtHo.getText(), row, 2);
//						table.setValueAt(txtTen.getText(), row, 3);
//						table.setValueAt(ngaySinhsql, row, 4);
//						table.setValueAt(cboGioiTinh.getSelectedItem().toString(), row, 5);
//						table.setValueAt(txtCMND.getText(), row, 6);
//						table.setValueAt(txtSoDT.getText(), row, 7);
//						table.setValueAt(cboMaPBan.getSelectedItem().toString(), row, 8);
//
//						table.setValueAt(loaiNV, row, 11);
//						table.setValueAt(cboTrangThai.getSelectedItem().toString(), row, 12);
//
//					}
//				} else {
//					JOptionPane.showMessageDialog(this, "Vui l??ng ch???n d??ng ????? c???p nh???t !", "Th??ng b??o",
//							JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//				}
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}
//		/**
//		 * staff search
//		 */
//		else if (obj.equals(btnTimKiem)) {
//			if (radMa.isSelected() == false && radTen.isSelected() == false && radSoDT.isSelected() == false
//					&& radCaLamViec.isSelected() == false && txtTimKiem.getText().trim().equals("")) {
//				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p th??ng tin v?? ch???n lo???i t??m ki???m !", "Th??ng b??o",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//			} else if (txtTimKiem.getText().trim().equals("")) {
//				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p th??ng tin t??m ki???m !", "Th??ng b??o",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//			} else if (radMa.isSelected() == false && radTen.isSelected() == false && radSoDT.isSelected() == false
//					&& radCaLamViec.isSelected() == false) {
//				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n lo???i t??m ki???m !", "Th??ng b??o",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//			} else {
//				if (radMa.isSelected()) {
//					try {
//						int ma = Integer.parseInt(txtTimKiem.getText().trim());
//						getTimKiemNhanVienById(ma);
//					} catch (Exception e2) {
//						if (!txtMaNV.getText().equalsIgnoreCase("")) {
//							JOptionPane.showMessageDialog(this, "Vui l??ng nh???p s??? nguy??n !", "Th??ng b??o",
//									JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//							txtTimKiem.requestFocus();
//							txtTimKiem.selectAll();
//						} else {
//							JOptionPane.showMessageDialog(this, "???? x???y ra l???i !", "Th??ng b??o",
//									JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//							txtTimKiem.requestFocus();
//							txtTimKiem.selectAll();
//						}
//					}
//				} else if (radTen.isSelected()) {
//					String ten = txtTimKiem.getText().trim();
//					getTimKiemNhanVienByTen(ten);
//				} else if (radSoDT.isSelected()) {
//					String sdt = txtTimKiem.getText().trim();
//					getTimKiemNhanVienBySDT(sdt);
//				} else if (radCaLamViec.isSelected()) {
//					String caLamViec = txtTimKiem.getText().trim();
//					getTimKiemNhanVienByCaLamViec(caLamViec);
//				}
//			}
//		} else if (obj.equals(btnLamMoi)) {
//			xoaAllDataTable();
//			docDuLieu();
//			txtTimKiem.requestFocus();
//			txtTimKiem.selectAll();
//		}
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		int row = table.getSelectedRow();
//		int maNV = Integer.parseInt(model.getValueAt(row, 1).toString());
//		try {
//			NhanVien nv = nvDao.layThongTinNhanVien(maNV);
//			txtMaNV.setText(maNV + "");
//			txtHo.setText(nv.getHo());
//			txtTen.setText(nv.getTen());
//			dateChooser.setDate(nv.getNgaySinh());
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			String ngaySinhtxt = dateFormat.format(dateChooser.getDate());
//			Date ngaySinhsql = null;
//			try {
//				java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
//				ngaySinhsql = new Date(ngaySinh.getTime());
//				dateChooser.setDate(ngaySinhsql);
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//
//			cboGioiTinh.getModel().setSelectedItem(nv.getGioiTinh());
//			txtSoDT.setText(nv.getSoDienThoai());
//			txtCMND.setText(nv.getCmnd());
//			txtTenTK.setText(nv.getTaiKhoan().getTenTaiKhoan());
//			String loaiNV = nv.getLoaiNhanVien().trim();
//			if (loaiNV.equalsIgnoreCase("NV")) {
//				cboLoaiNV.getModel().setSelectedItem("Nh??n vi??n");
//			} else {
//				cboLoaiNV.getModel().setSelectedItem("Qu???n l??");
//			}
//			txtMaDiaChi.setText(nv.getDiaChi().getMaDiaChi() + "");
//			cboTrangThai.getModel().setSelectedItem(nv.getTrangThai());
//			cboMaPBan.getModel().setSelectedItem(nv.getCaLamViec());
//
//			String diaChi = "";
//			int maDC = Integer.parseInt(model.getValueAt(row, 9).toString());
//			DiaChi dc = nvDao.layThongTinDiaChi(maDC);
//			String soNha = dc.getSoNha();
//			String tenDuong = dc.getTenDuong().trim();
//			String phuong = dc.getPhuong().trim();
//			String quan = dc.getQuan().trim();
//			String thanhPho = dc.getThanhPho().trim();
//			String quocGia = dc.getQuocGia().trim();
//			if (!soNha.equalsIgnoreCase("") && !tenDuong.equalsIgnoreCase("")) {
//				diaChi = soNha + ", " + tenDuong + ", " + phuong + ", " + quan + ", " + thanhPho + ", " + quocGia;
//			} else {
//				diaChi = phuong + ", " + quan + ", " + thanhPho + ", " + quocGia;
//			}
//			txtDiaChi.setText(diaChi);
//		} catch (Exception e2) {
//			//			e2.printStackTrace();
//		}
//
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//	}
//
//	public void getTimKiemNhanVienById(int id) {
//		NhanVienDAO dao = new NhanVienDAO();
//		ArrayList<NhanVien> list = null;
//		try {
//			list = (ArrayList<NhanVien>) dao.timkiemNhanVienByMa(id);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (NhanVien nhanVien : list) {
//			model.addRow(nhanVien.toVector()); /// ??????
//		}
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.setValueAt(i + 1, i, 0);
//		}
//	}
//
//	public void getTimKiemNhanVienBySDT(String sdt) {
//		NhanVienDAO dao = new NhanVienDAO();
//		ArrayList<NhanVien> list = null;
//		try {
//			list = (ArrayList<NhanVien>) dao.timkiemNhanVienBySDT(sdt);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (NhanVien nhanVien : list) {
//			model.addRow(nhanVien.toVector());
//		}
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.setValueAt(i + 1, i, 0);
//		}
//	}
//
//	public void getTimKiemNhanVienByTen(String ten) {
//		NhanVienDAO dao = new NhanVienDAO();
//		ArrayList<NhanVien> list = null;
//		try {
//			list = (ArrayList<NhanVien>) dao.timkiemNhanVienByTen(ten);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (NhanVien nhanVien : list) {
//			model.addRow(nhanVien.toVector());
//		}
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.setValueAt(i + 1, i, 0);
//		}
//	}
//
//	public void getTimKiemNhanVienByCaLamViec(String caLamViec) {
//		NhanVienDAO dao = new NhanVienDAO();
//		ArrayList<NhanVien> list = null;
//		try {
//			list = (ArrayList<NhanVien>) dao.timkiemNhanVienByCalamViec(caLamViec);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (NhanVien nhanVien : list) {
//			model.addRow(nhanVien.toVector());
//		}
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.setValueAt(i + 1, i, 0);
//		}
//	}
//
//	//	private boolean ktTonTai(int ma) {
//	//		NhanVienDAO dao = null;
//	//		try {
//	//			dao = new NhanVienDAO();
//	//
//	//			List<NhanVien> list;
//	//			list = dao.getAllNhanVien();
//	//			for (NhanVien nhanVien : list) {
//	//				if (nhanVien.getMaNV() == ma) {
//	//					JOptionPane.showMessageDialog(this, "M?? nh??n vi??n ???? t???n t???i");
//	//					txtMaNV.requestFocus();
//	//					txtMaNV.selectAll();
//	//					return false;
//	//				}
//	//			}
//	//
//	//		} catch (Exception e) {
//	//			e.printStackTrace();
//	//			return false;
//	//		}
//	//		return true;
//	//	}
//
//	public static void docDuLieu() {
//		try {
//			List<NhanVien> list = nvDao.getAllNhanVien();
//			int i = 0;
//			for (NhanVien nhanVien : list) {
//				i++;
//				model.addRow(new Object[] { i + "", nhanVien.getMaNhanVien() + "", nhanVien.getHo().trim(),
//						nhanVien.getTen().trim(), nhanVien.getNgaySinh(), nhanVien.getGioiTinh().trim(),
//						nhanVien.getCmnd().trim(), nhanVien.getSoDienThoai().trim(), nhanVien.getCaLamViec(),
//						nhanVien.getDiaChi().getMaDiaChi() + "".trim(), nhanVien.getTaiKhoan().getTenTaiKhoan(),
//						nhanVien.getLoaiNhanVien(), nhanVien.getTrangThai().trim() });
//			}
//			table.setModel(model);
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//	}
//
//	public boolean kiemTraDuLieu() {
//		try {
//			String ho = txtHo.getText().trim();
//			if (ho.equals("")) {
//				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p h??? !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
//						new ImageIcon("Hinh\\warning.png"));
//				txtHo.requestFocus();
//				txtHo.selectAll();
//				return false;
//			}
//			//			else if (ho.matches("") == false) {
//			//				JOptionPane.showMessageDialog(this, "H??? g???m c??c k?? t??? ch???, k?? t??? ?????u m???i t??? vi???t hoa !");
//			//				txtHo.requestFocus();
//			//				txtHo.selectAll();
//			//				return false;
//			//			}
//		} catch (Exception e2) {
//			JOptionPane.showMessageDialog(this, "H??? kh??ng h???p l??? !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
//					new ImageIcon("Hinh\\warning.png"));
//			return false;
//		}
//
//		try {
//			String ten = txtTen.getText().trim();
//			if (ten.equals("")) {
//				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p t??n !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
//						new ImageIcon("Hinh\\warning.png"));
//				txtTen.requestFocus();
//				txtTen.selectAll();
//				return false;
//			}
//			//			else if (ten.matches("/^[A-Z][a-z]*$/") == false) {
//			//				JOptionPane.showMessageDialog(this, "T??n g???m 1 ch???, k?? t??? ?????u vi???t hoa !");
//			//				txtTen.requestFocus();
//			//				txtTen.selectAll();
//			//				return false;
//			//			}
//		} catch (Exception e) {
//		}
//		try {
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			String ngaySinhtxt = dateFormat.format(dateChooser.getDate());
//			Date ngaySinhsql = null;
//			String year = "";
//			int yearsql = 0;
//			try {
//				java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
//				ngaySinhsql = new Date(ngaySinh.getTime());
//				//				System.out.println(ngaySinhsql);
//				year = ngaySinhsql.toString().substring(0, 4);
//				yearsql = Integer.parseInt(year);
//				//				System.out.print("ngaySinhsql:" + ngaySinhsql);
//				//				System.out.print("ngaySinhtxt:"+ngaySinhtxt);
//				//				System.out.print("ngaySinh:"+ngaySinh);
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//			if (ngaySinhsql.toString().equals("")) {
//				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n ng??y sinh !", "Th??ng b??o !",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//				dateChooser.requestFocus();
//				return false;
//			} else if (LocalDate.now().getYear() - yearsql < 18) {
//				JOptionPane.showMessageDialog(this, "Tu???i c???a b???n ph???i >= 18 !", "Th??ng b??o !",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//				dateChooser.requestFocus();
//				return false;
//			} else if (LocalDate.now().getYear() - yearsql > 60) {
//				JOptionPane.showMessageDialog(this, "Tu???i c???a b???n ph???i <= 60 !", "Th??ng b??o !",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//				dateChooser.requestFocus();
//				return false;
//			}
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(this, "Ng??y sinh kh??ng h???p l??? !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
//					new ImageIcon("Hinh\\warning.png"));
//			return false;
//		}
//		//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		//		String ngaySinhtxt = dateFormat.format(dateChooser.getDate());
//		//		Date ngaySinhsql = null;
//		//		try {
//		//			java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
//		//			ngaySinhsql = new Date(ngaySinh.getTime());
//		//		} catch (Exception e2) {
//		//			e2.printStackTrace();
//		//		}
//
//		//		String gioiTinh = cboGioiTinh.getSelectedItem().toString();
//
//		String soDT = txtSoDT.getText().trim();
//		try {
//			if (soDT.equals("")) {
//				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p s??? ??i???n tho???i !", "Th??ng b??o !",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//				txtSoDT.requestFocus();
//				txtSoDT.selectAll();
//				return false;
//			} else if (soDT.matches("^[0]\\d{9}$") == false) {
//				JOptionPane.showMessageDialog(this, "S??? ??i???n tho???i g???m 10 s???, b???t ?????u b???ng s??? 0 !", "Th??ng b??o !",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//				txtSoDT.requestFocus();
//				txtSoDT.selectAll();
//				return false;
//			}
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(this, "S??? ??i???n tho???i kh??ng h???p l??? !", "Th??ng b??o !",
//					JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//			txtSoDT.requestFocus();
//			txtSoDT.selectAll();
//			return false;
//		}
//		String cmnd = txtCMND.getText().trim();
//		try {
//			if (cmnd.equals("")) {
//				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ch???ng minh nh??n d??n !", "Th??ng b??o !",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//				txtCMND.requestFocus();
//				txtCMND.selectAll();
//				return false;
//			} else if (cmnd.matches("^[0-9]{9}$") == false) {
//				JOptionPane.showMessageDialog(this, "Ch???ng minh nh??n d??n g???m 8 ch??? s??? !", "Th??ng b??o !",
//						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//				txtCMND.requestFocus();
//				txtCMND.selectAll();
//				return false;
//			}
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(this, "Ch???ng minh nh??n d??n kh??ng h???p l??? !", "Th??ng b??o !",
//					JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//			txtCMND.requestFocus();
//			txtCMND.selectAll();
//			return false;
//		}
//		//		String tenTK = FrmThemTaiKhoan.txtTenTaiKhoan.getText().trim();
//		txtTenTK.setText(null);
//
//		//		int maDiaChi = nvDao.getMaDiaChiMax();
//		txtMaDiaChi.setText(null);
//		//		String trangThai = cboTrangThai.getSelectedItem().toString();
//
//		//		String caLamViec = cboMaPBan.getSelectedItem().toString();
//		String trangThai = cboTrangThai.getSelectedItem().toString().trim();
//		if (trangThai.equalsIgnoreCase("Ngh??? vi???c") || trangThai.equalsIgnoreCase("T???m ngh??? vi???c")) {
//			JOptionPane.showMessageDialog(this, "Vui l??ng ch???n tr???ng th??i l?? \"??ang l??m vi???c\" !", "Th??ng b??o !",
//					JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
//			return false;
//		} else {
//
//			check = true;
//		}
//		return true;
//	}
//
//	public static void xoaAllDataTable() {
//		model = (DefaultTableModel) table.getModel();
//		model.getDataVector().removeAllElements();
//
//	}
//
//	public void xoaRong() {
//		txtMaNV.setText("");
//		txtHo.setText("");
//		txtMaDiaChi.setText("");
//		txtSoDT.setText("");
//		txtTen.setText("");
//		txtTenTK.setText("");
//		txtCMND.setText("");
//		txtTimKiem.setText("");
//		txtDiaChi.setText("");
//		dateChooser.setDate(null);
//	}
//}
