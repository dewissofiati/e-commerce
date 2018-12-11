INSERT INTO pembayaran(id_pembayaran, metode_pembayaran, deskripsi)
VALUES
('001','Transfer Bank','Pembayaran-> Lain-lain-> Belanja Online-> Kode Pembayaran-> Tranfer'),
('002','Bayar di Indomaret','Pembayaran-> Belanja Online-> Cetak Struk-> Bayar di kasir');

INSERT INTO pemesanan(id_pemesanan, id_konsumen, tanggal_pesan, status_pembayaran, total_bayar, id_pengirim, id_pembayaran)
VALUES
('001','001','2018-12-01',true,200000,'002','001');

INSERT INTO detail_pemesanan(id_detail_pemesanan, id_pemesanan, id_produk, kuantiti, harga, total)
VALUES
('001','001','001',5,40000,200000);