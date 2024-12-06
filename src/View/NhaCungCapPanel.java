package View;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.HoiVienController;
import Controller.NhaCungCapController;
import Model.HoiVien;
import Model.NhaCungCap;
import javax.swing.border.LineBorder;

public class NhaCungCapPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tf_mancc;
	private JTextField tf_tenncc;
	private JTextField tf_diachi;
	private JTextField tf_email;
	private JTextField tf_search;

	private Image img_search = new ImageIcon(QuanLyForm.class.getResource("/pictures/search.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_refresh = new ImageIcon(QuanLyForm.class.getResource("/pictures/refresh.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_add = new ImageIcon(QuanLyForm.class.getResource("/pictures/add.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_update = new ImageIcon(QuanLyForm.class.getResource("/pictures/update.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_delete = new ImageIcon(QuanLyForm.class.getResource("/pictures/delete.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private JTable table;

	/**
	 * Create the panel.
	 */
	public NhaCungCapPanel() {
		setBorder(new LineBorder(Color.WHITE, 3));
		setBackground(new Color(51, 153, 153));
		setBounds(0, 0, 1096, 573);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã nhà cung cấp:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblNewLabel.setBounds(10, 12, 247, 40);
		add(lblNewLabel);

		JLabel lblTnNv = new JLabel("Tên nhà cung cấp:");
		lblTnNv.setForeground(Color.WHITE);
		lblTnNv.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblTnNv.setBounds(544, 12, 247, 40);
		add(lblTnNv);

		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setForeground(Color.WHITE);
		lblaCh.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblaCh.setBounds(10, 112, 115, 40);
		add(lblaCh);

		JLabel lblSdt = new JLabel("Email:");
		lblSdt.setForeground(Color.WHITE);
		lblSdt.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblSdt.setBounds(544, 112, 115, 40);
		add(lblSdt);

		tf_mancc = new JTextField();
		tf_mancc.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		tf_mancc.setColumns(10);
		tf_mancc.setBounds(10, 62, 470, 40);
		add(tf_mancc);

		tf_tenncc = new JTextField();
		tf_tenncc.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		tf_tenncc.setColumns(10);
		tf_tenncc.setBounds(544, 62, 542, 40);
		add(tf_tenncc);

		tf_diachi = new JTextField();
		tf_diachi.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		tf_diachi.setColumns(10);
		tf_diachi.setBounds(10, 162, 470, 40);
		add(tf_diachi);

		tf_email = new JTextField();
		tf_email.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		tf_email.setColumns(10);
		tf_email.setBounds(548, 162, 538, 40);
		add(tf_email);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 240, 1076, 207);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "M\u00E3 NCC", "T\u00EAn NCC", "\u0110\u1ECBa ch\u1EC9", "Email" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(175);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(175);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		showData(NhaCungCapController.getAllNCC());

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting() && table.getSelectedRow() != -1) {
					int selectedRow = table.getSelectedRow();
					tf_mancc.setText(table.getValueAt(selectedRow, 0).toString());
					tf_tenncc.setText(table.getValueAt(selectedRow, 1).toString());
					tf_diachi.setText(table.getValueAt(selectedRow, 2).toString());
					tf_email.setText(table.getValueAt(selectedRow, 3).toString());

				}
			}
		});

		tf_search = new JTextField();
		tf_search.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		tf_search.setColumns(10);
		tf_search.setBounds(650, 499, 368, 40);
		add(tf_search);

		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm theo tên nhà cung cấp:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblNewLabel_1.setBounds(650, 458, 368, 40);
		add(lblNewLabel_1);

		JPanel panelRefresh = new JPanel();
		panelRefresh.setLayout(null);
		panelRefresh.setBorder(null);
		panelRefresh.setBackground(new Color(51, 153, 153));
		panelRefresh.setBounds(10, 479, 150, 60);
		add(panelRefresh);
		panelRefresh.addMouseListener(new PanleButtonMouseAdpter(panelRefresh) {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhaCungCapController nccController = new NhaCungCapController();
				showData(nccController.getAllNCC());
			}
		});

		JLabel lb_refresh = new JLabel("Refresh");
		lb_refresh.setHorizontalAlignment(SwingConstants.CENTER);
		lb_refresh.setForeground(Color.WHITE);
		lb_refresh.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lb_refresh.setBounds(10, 11, 127, 40);
		panelRefresh.add(lb_refresh);

		JPanel panelAdd = new JPanel();
		panelAdd.setLayout(null);
		panelAdd.setBorder(null);
		panelAdd.setBackground(new Color(51, 153, 153));
		panelAdd.setBounds(170, 479, 150, 60);
		add(panelAdd);
		panelAdd.addMouseListener(new PanleButtonMouseAdpter(panelAdd) {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        String mancc = tf_mancc.getText();
		        String tenhcc = tf_tenncc.getText();
		        String diachi = tf_diachi.getText();
		        String email = tf_email.getText();

		        // Kiểm tra thông tin không được để trống
		        if (!mancc.equals("") && !tenhcc.equals("") && !diachi.equals("") && !email.equals("")) {

		            // Kiểm tra định dạng email
		            if (email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")) { // Biểu thức chính quy để kiểm tra email
		                NhaCungCap ncc = new NhaCungCap();
		                ncc.setMaNCC(mancc);
		                ncc.setTenNhaCC(tenhcc);
		                ncc.setDiaChi(diachi);
		                ncc.setEmail(email);

		                NhaCungCapController nccController = new NhaCungCapController();
		                int check = nccController.Add(ncc);
		                showData(nccController.getAllNCC());
		                if (check <= 0) {
		                    JOptionPane.showMessageDialog(null, "Mã nhà cung cấp là duy nhất!", "Lỗi",
		                            JOptionPane.ERROR_MESSAGE);
		                } else {
		                    JOptionPane.showMessageDialog(null, "Thêm thành công!");
		                }
		            } else {
		                // Hiển thị lỗi nếu email không hợp lệ
		                JOptionPane.showMessageDialog(null, "Email không hợp lệ! Vui lòng nhập đúng định dạng email.", "Lỗi",
		                        JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Các thông tin không được để trống!", "Lỗi",
		                    JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});


		JLabel lb_add = new JLabel("Add");
		lb_add.setHorizontalAlignment(SwingConstants.CENTER);
		lb_add.setForeground(Color.WHITE);
		lb_add.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lb_add.setBounds(10, 11, 127, 40);
		panelAdd.add(lb_add);

		JPanel panelUpdate = new JPanel();
		panelUpdate.setLayout(null);
		panelUpdate.setBorder(null);
		panelUpdate.setBackground(new Color(51, 153, 153));
		panelUpdate.setBounds(330, 479, 150, 60);
		add(panelUpdate);
		panelUpdate.addMouseListener(new PanleButtonMouseAdpter(panelUpdate) {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mancc = tf_mancc.getText();
				String tenhcc = tf_tenncc.getText();
				String diachi = tf_diachi.getText();
				String email = tf_email.getText();

				if (!mancc.equals("") && !tenhcc.equals("") && !diachi.equals("") && !email.equals("")) {
					NhaCungCap ncc = new NhaCungCap();
					ncc.setMaNCC(mancc);
					ncc.setTenNhaCC(tenhcc);
					ncc.setDiaChi(diachi);
					ncc.setEmail(email);

					NhaCungCapController nccController = new NhaCungCapController();
					int check = nccController.Update(ncc);
					showData(nccController.getAllNCC());
					if (check <= 0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy nhà cung cấp này!", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Sửa thành công!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Các thông tin không được để trống!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JLabel lb_update = new JLabel("Update");
		lb_update.setHorizontalAlignment(SwingConstants.CENTER);
		lb_update.setForeground(Color.WHITE);
		lb_update.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lb_update.setBounds(10, 11, 127, 40);
		panelUpdate.add(lb_update);

		JPanel panelDelete = new JPanel();
		panelDelete.setLayout(null);
		panelDelete.setBorder(null);
		panelDelete.setBackground(new Color(51, 153, 153));
		panelDelete.setBounds(490, 479, 150, 60);
		add(panelDelete);

		JLabel lb_delete = new JLabel("Delete");
		lb_delete.setHorizontalAlignment(SwingConstants.CENTER);
		lb_delete.setForeground(Color.WHITE);
		lb_delete.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lb_delete.setBounds(10, 11, 127, 40);
		panelDelete.add(lb_delete);
		panelDelete.addMouseListener(new PanleButtonMouseAdpter(panelDelete) {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mancc = tf_mancc.getText();
				String tenhcc = tf_tenncc.getText();
				String diachi = tf_diachi.getText();
				String email = tf_email.getText();

				if (!mancc.equals("")) {
					NhaCungCap ncc = new NhaCungCap();
					ncc.setMaNCC(mancc);
					ncc.setTenNhaCC(tenhcc);
					ncc.setDiaChi(diachi);
					ncc.setEmail(email);

					NhaCungCapController nccController = new NhaCungCapController();
					int check = nccController.Delete(ncc);
					showData(nccController.getAllNCC());
					if (check <= 0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy nhà cung cấp này!", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Xóa thành công!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Các thông tin không được để trống!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JPanel panelSearch = new JPanel();
		panelSearch.setLayout(null);
		panelSearch.setBackground(new Color(51, 153, 153));
		panelSearch.setBounds(1028, 489, 50, 50);
		add(panelSearch);
		panelSearch.addMouseListener(new PanleButtonMouseAdpter(panelSearch) {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!tf_search.getText().equals("")) {
					NhaCungCap ncc = new NhaCungCap();
					ncc.setTenNhaCC(tf_search.getText());
					showData(NhaCungCapController.findByName(ncc));
					if (NhaCungCapController.findByName(ncc).size() <= 0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy nhà cung cấp này!", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						showData(NhaCungCapController.getAllNCC());
						tf_search.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Thông tin tìm kiếm không được để trống!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JLabel lb_search = new JLabel("");
		lb_search.setHorizontalAlignment(SwingConstants.CENTER);
		lb_search.setBounds(0, 0, 50, 50);
		panelSearch.add(lb_search);

		lb_refresh.setIcon(new ImageIcon(img_refresh));
		lb_add.setIcon(new ImageIcon(img_add));
		lb_delete.setIcon(new ImageIcon(img_delete));
		lb_update.setIcon(new ImageIcon(img_update));
		lb_search.setIcon(new ImageIcon(img_search));

	}

	public void showData(List<NhaCungCap> hoivien) {
		List<NhaCungCap> listncc = new ArrayList<>();
		listncc = hoivien;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		listncc.forEach((NhaCungCap) -> {
			tableModel.addRow(new Object[] { NhaCungCap.getMaNCC(), NhaCungCap.getTenNhaCC(), NhaCungCap.getDiaChi(),
					NhaCungCap.getEmail() });
		});
	}

	private class PanleButtonMouseAdpter extends MouseAdapter {
		JPanel panel;

		public PanleButtonMouseAdpter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(51, 140, 140));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(51, 153, 153));
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(51, 165, 165));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(51, 140, 140));
		}
	}
}
