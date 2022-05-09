package entities;

import java.sql.Date;
import java.util.Vector;

public class NhanVien {
	private int maNV;
	private String ten;
	private String ho;
	private Date ngaySinh;
	private String gioiTinh;
	private String cmnd;
	private String soDienThoai;
	private DiaChi diaChi;
	
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhanVien(int maNV, String ten, String ho, Date ngaySinh,
			String gioiTinh, String cmnd, String soDienThoai, DiaChi diaChi) {
		super();
		this.maNV = maNV;
		this.ten = ten;
		this.ho = ho;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maNV + ", ten=" + ten + ", ho=" + ho + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", cmnd=" + cmnd + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi
				+ "]";
	}
	public Vector<Object> toVector() {
		Vector<Object> v = new Vector<>();
		v.add("");
		v.add(maNV);
		v.add(ho);
		v.add(ten);
		v.add(ngaySinh);
		v.add(gioiTinh);
		v.add(cmnd);
		v.add(soDienThoai);
		
		v.add(diaChi);
		return v;
	}
	
}
