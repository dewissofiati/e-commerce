INSERT INTO pembayaran(id_pembayaran, metode_pembayaran, biaya_penanganan ,deskripsi)
VALUES
('001','Transfer Bank',0,'Pembayaran-> Lain-lain-> Belanja Online-> Kode Pembayaran-> Tranfer'),
('002','Bayar di Indomaret',2500,'Pembayaran-> Belanja Online-> Cetak Struk-> Bayar di kasir');

INSERT INTO pemesanan(id_pemesanan, id_konsumen, id_produk, id_toko, jumlah, harga, total)
VALUES
('001','001','002','002',2,20000,40000);

INSERT INTO detail_pemesanan(id_detail_pemesanan, id_pemesanan, id_produk, id_toko, jumlah, harga, ongkir, id_pengirim, id_pembayaran, total, status_pembayaran)
VALUES
('001','001','001','001',5,40000,11000,'001','001',211000,true);